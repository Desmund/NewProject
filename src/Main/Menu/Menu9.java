package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu9 extends BaseMenu{
    @Override
    public boolean select(int i) {
        switch (i){
            case 1:
                //меню 8
                return true;
            case 2:
                //меню 1
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
