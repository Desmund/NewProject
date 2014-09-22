package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu8 {

    public void printMenu(){
        inputFile();
        new Menu1().printMenu();
    }

    private void inputFile(){
        //TODO фаловый вывод и сохранение данных
        Utils.stringWriteToConsol("Введите название файла:");
        try {
            String s = Utils.stringReadFromConsol();
        }catch(Exception e){
            Utils.stringWriteToConsol("Некорректное имя файла!");
        }
        //<Если файл существует, то считать записи из файла, написать об это на экране и перейти на экран №1>
        //<Если файл существует, но содержит ошибку или не существует, но написат написать соответствующее сообщение и перейти на экран №9>
    }
}
