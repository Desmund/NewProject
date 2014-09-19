package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu6 extends BaseMenu {
    @Override
    public void printMenu() {
        stringWriteToConsol("Вывести все работы!");
        stringWriteToConsol("Какое у вас сейчас настроение?");
        stringWriteToConsol("1 - Хорошое");
        stringWriteToConsol("2 - Плохое");
        getValue();
    }

    @Override
    public boolean select(int i) {
        switch (i) {
            case 1:
                //нарастить оценки
                //меню 7
                return true;
            case 2:
                //уменьшить оценки
                //меню 7
                return true;
            default:
                return super.select(i);
        }
    }
}
