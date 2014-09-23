package Main.Menu;

import Main.Utils;
import Main.WorkInMemory;

import java.util.ArrayList;
/**
 * Created by Denis on 19.09.2014.
 */
public class Menu5{

    public void printMenu(){
        ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();
        outputWork(bw);
        Utils.stringWriteToConsol("Кол-во прогульщиков: "+getCountOfStudentByMark(bw,0));
        Utils.stringWriteToConsol("Кол-во хороших студентов: "+getCountOfStudentByMark(bw,1));
        Utils.stringWriteToConsol("Кол-во курсовиков: "+getCountOfStudentByMark(bw,2));
        new Menu1().printMenu();
    }

    private void outputWork(ArrayList<BaseWork> bw) {
        //TODO вывод работ    с оценками+
        writeWorks(bw);
        Utils.stringWriteToConsol("Нажмите Enter");
        try {
            Utils.stringReadFromConsol();
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка ввода!");
        }
        //*примечание : если 0 - то не печатать строчку
    }

    protected void writeWorks(ArrayList<BaseWork> list){
        for(int i=0;i<list.size();i++) {
            BaseWork bw = list.get(i);
            if(bw.getRating()!=0){
                Utils.stringWriteToConsol(bw.getName());
                Utils.stringWriteToConsol(bw.getGroup());
                Utils.stringWriteToConsol(bw.getDate().toString());
                Utils.stringWriteToConsol(Integer.toString(bw.getRating()));
            }
        }
    }

    protected int getCountOfStudentByMark(ArrayList<BaseWork> list,int mark){
        int count = 0;
        for(int i=0;i<list.size();i++) {
            BaseWork bw = list.get(i);
            if(bw.getMark()==mark)
                count++;
        }
        return count;
    }
}
