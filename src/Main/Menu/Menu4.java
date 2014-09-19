package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu4 extends BaseMenu {
    @Override
    public void printMenu() {
        stringWriteToConsol("Проверить еще одну работу?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        stringWriteToConsol("3 - Простовить оценки");
        getValue();
    }

    @Override
    public boolean select(int i) {
        switch (i) {
            case 1:
                //меню 3
                return true;
            case 2:
                //меню 1
                return true;
            case 3:
                //меню 6
                return true;
            default:
                return super.select(i);
        }
    }
}
