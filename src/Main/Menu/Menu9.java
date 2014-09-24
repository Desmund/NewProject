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
                new Menu8().printMenu();
                return true;
            case 2:
                new Menu1().printMenu();
                return true;
            default:
                return super.select(i);
        }
    }

    @Override
    public void printMenu() {
        stringWriteToConsol("Пробуем ввести другой файл?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        getValue();
    }
}
