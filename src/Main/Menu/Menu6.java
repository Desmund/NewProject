package Main.Menu;

import Main.Utils;
import Main.WorkInMemory;

import java.util.ArrayList;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu6 extends BaseMenu {

    ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();

    @Override
    public void printMenu() {
        //TODO Вывести все работы без оценок! +
        writeWorks(bw);
        Utils.stringWriteToConsol("Кол-во проверянных работ: "+getCountOfStudentWithRating(bw));
        stringWriteToConsol("Какое у вас сейчас настроение?");
        stringWriteToConsol("1 - Хорошое");
        stringWriteToConsol("2 - Плохое");
        getValue();
        new Menu1();
    }

    @Override
    public boolean select(int i) {
        int rating = 10;
        switch (i) {
            case 1:
                //todo удалить вопрос+
                putRating(bw,-rating);
                new Menu1().printMenu();
                return true;
            case 2:
                putRating(bw,rating);
                new Menu1().printMenu();
                return true;
            default:
                return super.select(i);
        }
    }

    private void putRating(ArrayList<BaseWork>list,int rating){
        //TODO  проставить оценки!  +
        int random_rating=0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getMark()==0) {
                random_rating = (int) Math.random() * 11;
                if(random_rating + rating<0)
                    rating=50;
                    else
                        rating+=random_rating;
                bw.get(i).setRating((byte)(50 + rating));
            }
            else
                if(list.get(i).getMark()==1){
                    random_rating = (int) Math.random() * 30;
                    bw.get(i).setRating((byte)(random_rating + 60 + rating));
                }
            else{
                random_rating = (int) Math.random() * 11;
                if(random_rating + rating>10)
                        rating=100;
                    else
                        rating+=random_rating;
                    bw.get(i).setRating((byte)(90 + rating));
            }
        }
    }

    protected void writeWorks(ArrayList<BaseWork> list){
        for(int i=0;i<list.size();i++) {
            BaseWork bw = list.get(i);
            if(bw.getRating()!=0){
                stringWriteToConsol(bw.getName());
                stringWriteToConsol(bw.getGroup());
                stringWriteToConsol(bw.getDate().toString());
                stringWriteToConsol(Integer.toString(bw.getMark()));
            }
        }
    }

    protected int getCountOfStudentWithRating(ArrayList<BaseWork> list){
        int count = 0;
        for(int i=0;i<list.size();i++) {
            BaseWork bw = list.get(i);
            if(bw.getRating()>0)
                count++;
        }
        return count;
    }
}
