package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
import Main.Menu.*;
import Main.Utils;
import Main.WorkInMemory;

import java.util.ArrayList;

public class Menu1 extends BaseMenu{

    @Override
    public void printMenu() {
        ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();
        int i=1;
        stringWriteToConsol("Выберите один из пунктов меню:");
        stringWriteToConsol(i+" - Записать новые курсовые работы");
        if(bw.size()!=0) {
            i++;
            stringWriteToConsol(i+" - Поставить оценки");
            i++;
            stringWriteToConsol(i+" - Просмотреть работы");
            if(WorkInMemory.get().oneWorkHasRating()) {
                i++;
                stringWriteToConsol(i + " - Удалить провереные курсовые работы");
            }
            super.printMenu();
        }
        else
            super.printMenu();
        getValue(i);
    }

    protected int getValue(int max) {
        int num=0;
        boolean hasValue=false;
        while(!hasValue||num>max){
            try {
                num = Utils.getIntValue();
                if(num>max)
                    stringWriteToConsol("Введено не верное число!");
                else
                    hasValue = select(num);
            }catch(Exception e){
                stringWriteToConsol("Введите целое числа!");
            }
        }
        return num;
    }

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        switch(i){
            case 1:
                new Menu2().printMenu();
                return true;
            case 2:
                new Menu6().printMenu();
                return true;
            case 3:
                new Menu5().printMenu();
                return true;
            case 4:
                new Menu7().printMenu();
                return true;
            default:
                return super.select(i);
            //*примечание : если студентов без оценки 0 - то не печатать строчку
            //**примечание : некого вспоминать\забывать (нет такого файла) то не печатать эти строчки
        }
    }
}
