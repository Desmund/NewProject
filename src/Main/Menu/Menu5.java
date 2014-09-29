package Main.Menu;

import Main.Utils;
import Main.WorkInMemory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu5{

    public void printMenu(){
        ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();
        Utils.stringWriteToConsol("Кол-во прогульщиков: "+getCountOfStudentByMark(bw,0));
        Utils.stringWriteToConsol("Кол-во хороших студентов: "+getCountOfStudentByMark(bw,1));
        Utils.stringWriteToConsol("Кол-во курсовиков: "+getCountOfStudentByMark(bw,2));
        Utils.writeEnter();
        if(WorkInMemory.get().countWorkHasRating()!=bw.size()) {
            Utils.stringWriteToConsol("Работы без оценок:");
            outputWork(bw, false);
            Utils.writeEnter();
        }
        if(WorkInMemory.get().oneWorkHasRating()) {
            Utils.stringWriteToConsol("Работы с оценками:");
            outputWork(bw, true);
            Utils.writeEnter();
        }
        new Menu1().printMenu();
    }

    private void outputWork(ArrayList<BaseWork> bw,boolean b) {
        writeWorks(bw,b);
        Utils.stringWriteToConsol("Нажмите Enter");
        try {
            Utils.stringReadFromConsol();
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка ввода!");
        }
        //*примечание : если 0 - то не печатать строчку
    }

    protected void writeWorks(ArrayList<BaseWork> list,boolean b){
        for(int i=0;i<list.size();i++) {
            BaseWork bw = list.get(i);
            if(bw.getRating()!=0&&b){
                Utils.stringWriteToConsolWithoutEnter(bw.getName()+" ");
                Utils.stringWriteToConsolWithoutEnter(bw.getGroup()+" ");
                Utils.stringWriteToConsolWithoutEnter(bw.getDate().toString()+" ");
                Utils.stringWriteToConsol(Integer.toString(bw.getRating()));
            }
            else
            if(bw.getRating()==0&&!b){
                Utils.stringWriteToConsolWithoutEnter(bw.getName()+" ");
                Utils.stringWriteToConsolWithoutEnter(bw.getGroup()+" ");
                Utils.stringWriteToConsol(bw.getDate().toString() + " ");
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
