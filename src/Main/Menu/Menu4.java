package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu4 extends BaseMenu {

    @Override
    public void printMenu() {
        stringWriteToConsol("Повторить опирацию?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        stringWriteToConsol("3 - Проставить оценки");
        getValue();
    }

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        switch (i) {
            case 1:
                new Menu3().printMenu();
                return true;
            case 2:
                new Menu1().printMenu();
                return true;
            case 3:
                new Menu6().printMenu();
                return true;
        }
        return false;
    }
}
