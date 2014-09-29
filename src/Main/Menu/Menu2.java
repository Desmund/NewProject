package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu2 extends BaseMenu {

    @Override
    public void printMenu() {
        stringWriteToConsol("Выберите способ ввода:");
        stringWriteToConsol("1 - Ввести руками");
        stringWriteToConsol("2 - Вывести из файла");
        stringWriteToConsol("3 - Ввести в файл");
        getValue();
    }

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        switch(i){
            case 1:
                new Menu3().printMenu();
                return true;
            case 2:
                new Menu8().printMenu(false);
                return true;
            case 3:
                new Menu8().printMenu(true);
                return true;
        }
        return false;
    }
}
