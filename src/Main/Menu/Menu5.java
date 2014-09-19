package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu5{
    public void printMenu(){
        outputWork();
        new Menu1().printMenu();
    }
    private void outputWork() {
        //TODO вывод работ
        Utils.stringWriteToConsol("Вывод работ");
        Utils.stringWriteToConsol("Нажмите Enter");
        try {
            Utils.stringReadFromConsol();
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка ввода!");
        }
        //*примечание : если 0 - то не печатать строчку
    }
}
