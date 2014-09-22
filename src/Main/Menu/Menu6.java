package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu6 extends BaseMenu {

    @Override
    public void printMenu() {
        //TODO Вывести все работы!
        stringWriteToConsol("Все работы!");
        stringWriteToConsol("Какое у вас сейчас настроение?");
        stringWriteToConsol("1 - Хорошое");
        stringWriteToConsol("2 - Плохое");
        getValue();
        new Menu1();
    }

    @Override
    public boolean select(int i) {
        int rating = 10;
        switch (i) {
            case 1:
                putRating(-rating);
                new Menu7().printMenu();
                return true;
            case 2:
                putRating(rating);
                new Menu7().printMenu();
                return true;
            default:
                return super.select(i);
        }
    }

    private void putRating(int rating){
        //TODO  проставить оценки!
        System.out.println("Оценки проставлены!");
    }
}
