package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu7 extends BaseMenu {
    @Override
    public void printMenu() {
        stringWriteToConsol("Вы уверенны?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
    }

    @Override
    public boolean select(int i) {
        switch (i){
            case 1:
                //сделать действие и выход в меню 1
            case 2:
                //меню 1
            default:
                return super.select(i);
        }
    }
}
