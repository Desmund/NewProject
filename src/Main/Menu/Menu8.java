package Main.Menu;

import Main.Utils;
import Main.FileUtils;
import Main.WorkInMemory;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu8 {

    public void printMenu(){
        if(!outputFile()) {
            Utils.writeEnter();
            new Menu9().printMenu();
        }

        new Menu1().printMenu();
    }

    private boolean outputFile(){
        //TODO фаловый вывод++++
        //todo сохранение данных++++
        Utils.stringWriteToConsol("Введите полное имя файла(пример: e:/somefolder/somefile.txt):");
        try {
            String filePath = Utils.stringReadFromConsol();
            FileUtils file = new FileUtils();
            if(!file.exists(filePath)) {
                Utils.stringWriteToConsol("Некорректное имя файла!");
                return false;
            }
            else{
                //inputWork(filePath);
                parseJsonString(filePath);
                return true;
            }
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка!");
        }
        return false;
    }

    private void inputWork(String fileName){
        ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();
        FileUtils file = new FileUtils();
        JSONObject obj = new JSONObject();
        for(int i=0;i<bw.size();i++) {
            JSONArray arr = new JSONArray();
            arr.add(bw.get(i).getName());
            arr.add(bw.get(i).getGroup());
            arr.add(bw.get(i).getTheme());
            arr.add(bw.get(i).getMark());
            arr.add(bw.get(i).getDate().toString());
            arr.add(bw.get(i).getRating());
            obj.put(i,arr);
        }
        file.writeFile(fileName,obj.toString());
    }

    private void parseJsonString(String fileName)throws Exception{
        //todo парсинг для Date исправть
        ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();
        FileUtils file = new FileUtils();
        String json = file.readFile(fileName);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);
            JSONObject jsonObj = (JSONObject) obj;
            for(int i=0;i<jsonObj.size();i++){
                JSONArray ja = (JSONArray) jsonObj.get(Integer.toString(i));
                String name =ja.get(0).toString();
                String group = ja.get(1).toString();
                String theme = ja.get(2).toString();
                int mark = Integer.parseInt(ja.get(3).toString());
//                Date date = new Date(ja.get(4).toString());
                byte rating = Byte.parseByte(ja.get(5).toString());
                BaseWork base = new BaseWork(name,theme,group,mark);
//                base.setDate(date);
                base.setRating(rating);
                bw.add(base);
            }
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка,при парсинге строки!");
        }
    }
}
