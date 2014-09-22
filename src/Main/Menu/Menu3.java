package Main.Menu;
import Main.Utils;
/**
 * Created by Denis on 19.09.2014.
 */
public class Menu3{
    public void printMenu(){
        inputWork();
        new Menu4().printMenu();
    }

    private void inputWork(){
        //TOdo сохранение данных
        String name,theme,group;
        int mark;
            Utils.stringWriteToConsol("Ввести имя студента:");
            name = readValue();
            Utils.stringWriteToConsol("Ввести тему курсача:");
            theme = readValue();
            Utils.stringWriteToConsol("Ввести группу:");
            group  = readValue();
            Utils.stringWriteToConsol("Ввести метку:");
            try {
                Utils.stringWriteToConsol("0 - Прогульщик,1 - Хороший студент,2 - Курсовик");
                mark = inputMark();
            }catch(Exception e){
                Utils.stringWriteToConsol("Вы ввели не корректные данные!");
            }
    }

    private String readValue(){
        String s="";
        try{
            while(s.equals(""))
              s = Utils.stringReadFromConsol();
        }catch(Exception e){
            s="";
            Utils.stringWriteToConsol("Вы ввели не корректные данные!");
        }
        return s;
    }

    private int inputMark()throws Exception{
        int mark = -1;
        while ((mark<0)||(mark>2)) {
            try {
                mark = Utils.getIntValue();
                if((mark<0)||(mark>2)) Utils.stringWriteToConsol("Введите одно из чисел:0,1,2");
            }catch(Exception e){
                mark = -1;
                Utils.stringWriteToConsol("Введите одно из чисел:0,1,2");
            }
        }
        return mark;
    }
}
