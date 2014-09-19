package Main.Menu;

import Main.Utils;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu8 {
    public void inputFile()throws Exception{
        Utils.stringWriteToConsol("Введите название листочка");
        Utils.stringWriteToConsol("Введите название файла:");
        String s = Utils.stringReadFromConsol();
        //<Если файл существует, то считать записи из файла, написать об это на экране и перейти на экран №1>
        //<Если файл существует, но содержит ошибку или не существует, но написат написать соответствующее сообщение и перейти на экран №9>
    }
}
