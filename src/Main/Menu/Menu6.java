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
        if(bw.size()!=0) {
            if(getCountOfStudentWithRating(bw)!=0) {
                Utils.stringWriteToConsol("Работы с оценками:");
                writeWorks(bw, true);
                Utils.writeEnter();
            }
            if(getCountOfStudentWithRating(bw)!=bw.size()) {
                Utils.stringWriteToConsol("Работы без оценки:");
                writeWorks(bw, false);
                Utils.writeEnter();
            }
        }
        Utils.stringWriteToConsol("Кол-во проверянных работ: " + getCountOfStudentWithRating(bw));
        Utils.writeEnter();
        stringWriteToConsol("Какое у вас сейчас настроение?");
        stringWriteToConsol("1 - Хорошое");
        stringWriteToConsol("2 - Плохое");
        getValue();
        new Menu1();
    }

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        int rating = 10;
        switch (i) {
            case 1:
                putRating(bw,rating);
                new Menu1().printMenu();
                return true;
            case 2:
                putRating(bw,-rating);
                new Menu1().printMenu();
                return true;
            default:
                return super.select(i);
        }
    }

    private void putRating(ArrayList<BaseWork>list,int rating){
        int random_rating=0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getRating()==0) {
                list.get(i).setRating(definitionRating(list.get(i).mark, rating));
            }
        }
    }

    private byte definitionRating(int mark,int mood){
        byte rat=0;
        switch(mark){
            case 0:
                rat = (byte)(Math.random() * 11);
                rat += mood + 50;
                if(rat<50)
                    return 50;
                else
                    return rat;
            case 1:
                rat = (byte)(Math.random() * 31);
                rat += mood + 60;
                return rat;
            case 2:
                rat = (byte)(Math.random() * 11);
                rat += mood + 90;
                if(rat>100)
                    return 100;
                else
                    return rat;
            default: return 50;
        }
    }

    protected void writeWorks(ArrayList<BaseWork> list,boolean b){
        for(int i=0;i<list.size();i++) {
            BaseWork bw = list.get(i);
            if(bw.getRating()!=0&&b){
                writeWork(bw);
            }
            else
            if(bw.getRating()==0&&!b)
                writeWork(bw);
        }
    }

    protected void writeWork(BaseWork bw) {
        Utils.stringWriteToConsolWithoutEnter(bw.getName()+" ");
        Utils.stringWriteToConsolWithoutEnter(bw.getGroup()+" ");
        Utils.stringWriteToConsolWithoutEnter(bw.getDate().toString()+" ");
        Utils.stringWriteToConsol(Integer.toString(bw.getMark()));
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
