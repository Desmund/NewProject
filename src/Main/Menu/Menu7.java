package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu7 extends BaseMenu {

    @Override
    public void printMenu() {
        stringWriteToConsol("Вы уверенны?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        getValue();
    }

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        switch (i){
            case 1:
                //TODO сделать действие
            case 2:
                new Menu1().printMenu();
                return true;
        }
        return false;
    }
}
