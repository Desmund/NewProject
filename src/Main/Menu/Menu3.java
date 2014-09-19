package Main.Menu;
import Main.Utils;
/**
 * Created by Denis on 19.09.2014.
 */
public class Menu3{
    public void inputWork(){
        String name,theme,group;
        int mark;
        try {
            Utils.stringWriteToConsol("Ввести имя студента:");
            name = Utils.stringReadFromConsol();
            Utils.stringWriteToConsol("Ввести тему курсача:");
            theme = Utils.stringReadFromConsol();
            Utils.stringWriteToConsol("Ввести группу:");
            group  = Utils.stringReadFromConsol();
            Utils.stringWriteToConsol("Ввести метка:");
            mark = Utils.getIntValue();
        }catch(Exception e){
            Utils.stringWriteToConsol("Вы ввели не корректные данные!");
        }
    }
}
