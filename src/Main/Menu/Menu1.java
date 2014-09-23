package Main.Menu;

/**
 * Created by Denis on 19.09.2014.
 */
import Main.Menu.*;
public class Menu1 extends BaseMenu{

    @Override
    public void printMenu() {
        stringWriteToConsol("Выберите один из пунктов меню:");
        stringWriteToConsol("1 - Записать новые курсовые работы");
        stringWriteToConsol("2 - Просмотреть оценки");
        stringWriteToConsol("3 - Поставить оценки");
        stringWriteToConsol("4 - Удалить проверяные курсовые работы");
        //todo удалить  вопрос+
        super.printMenu();
        getValue();
    }

    @Override
    public boolean select(int i) {
        switch(i){
            case 1:
                new Menu2().printMenu();
                return true;
            case 2:
                new Menu5().printMenu();
                return true;
            case 3:
                new Menu6().printMenu();
                return true;
            case 4:
                new Menu7().printMenu();
                return true;
            default:
                return super.select(i);
            //*примечание : если студентов без оценки 0 - то не печатать строчку
            //**примечание : некого вспоминать\забывать (нет такого файла) то не печатать эти строчки
        }
    }
}
