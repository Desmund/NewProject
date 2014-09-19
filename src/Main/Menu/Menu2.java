package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu2 extends BaseMenu {
    @Override
    public void printMenu() {
        stringWriteToConsol("Выберите способ ввода:");
        stringWriteToConsol("1 - Ввести руками");
        stringWriteToConsol("2 - Ввести из файла");
        super.printMenu();
        getValue();
    }

    @Override
    public boolean select(int i) {
        switch(i){
            case 1:
                //меню 3
                return true;
            case 2:
                //меню 8
                return true;
            default:
                return super.select(i);
        }
    }
}
