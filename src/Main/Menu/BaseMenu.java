package Main.Menu;

/**
 * Created by Denis on 18.09.2014.
 */
import Main.Utils;

public abstract class BaseMenu {

    protected void printMenu(){
        stringWriteToConsol("0 - Выход");
    }

    protected void stringWriteToConsol(String s){
        System.out.println(s);
    }

    protected int getValue(){
        int num=0;
        boolean hasValue=false;
        while(!hasValue){
            try {
                num = Utils.getIntValue();
                hasValue = select(num);
                if(!hasValue)System.out.println("Введено не верное число!");
            }catch(Exception e){
                stringWriteToConsol("Вводить можно,только целые числа!");
            }
        }
        return num;
    }

    protected boolean select(int i){
        switch(i){
            case 0:
                System.exit(0);
            return true;
        }
        return false;
    }
}
