package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu4 extends BaseMenu {

    @Override
    public void printMenu() {
        stringWriteToConsol("Повторить опирацию?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        stringWriteToConsol("3 - Простовить оценки");
        getValue();
    }

    @Override
    public boolean select(int i) {
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
            default:
                return super.select(i);
        }
    }
}
