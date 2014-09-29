package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu9 extends BaseMenu{

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        switch (i){
            case 1:
                new Menu8().printMenu(getBool());
                return true;
            case 2:
                new Menu1().printMenu();
                return true;
        }
        return false;
    }

    public void printMenu(boolean b) {
        setBool(b);
        stringWriteToConsol("Пробуем ввести другой файл?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        getValue();
    }

    private boolean b;

    private boolean getBool(){
        return b;
    }

    private void setBool(boolean b){
        this.b=b;
    }
}
