package Main.Menu;

import Main.Utils;
import Main.FileUtils;
import Main.WorkInMemory;

import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu8 {

    ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();

    public void printMenu(boolean b){
        if(!outputFile(b)) {
            Utils.writeEnter();
            new Menu9().printMenu(b);
        }
        new Menu1().printMenu();
    }

    private boolean outputFile(boolean b){
        Utils.stringWriteToConsol("Введите имя файла:");
        try {
            String filePath ="E:/JS/MyNewProject/";
            filePath += Utils.stringReadFromConsol();
            FileUtils file = new FileUtils();
            if(!file.exists(filePath)) {
                Utils.stringWriteToConsol("Некорректное имя файла!");
                return false;
            }
            else{
                if(b)
                    inputWork(filePath);
                else
                    parseJsonString(filePath);
                if(bw.isEmpty()) {
                    Utils.stringWriteToConsol("Файл пуст!");
                    return false;
                }
                return true;
            }
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка!");
        }
        return false;
    }

    private void inputWork(String fileName){
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
                Date date = parseDateString(ja.get(4).toString());
                byte rating = Byte.parseByte(ja.get(5).toString());
                BaseWork base = new BaseWork(name,theme,group,mark);
                base.setDate(date);
                base.setRating(rating);
                bw.add(base);
            }
        }catch(Exception e){
            Utils.stringWriteToConsol("Ошибка,при парсинге строки!");
        }
        Utils.stringWriteToConsol(" ");
    }

    private Date parseDateString(String s){
        StringTokenizer st = new StringTokenizer(s," ,;:",false);
        int day=0,month=0,year=0,time=0;
        int n = st.countTokens();
        for(int i = 0; i < n; i++){
            s = st.nextToken();
            if (i == 1) month = (int) Month.valueOf(s).ordinal();
            if(i==2)day=Integer.parseInt(s);
            if(i==3)time+=Integer.parseInt(s)*3600000;
            if(i==4)time+=Integer.parseInt(s)*60000;
            if(i==5)time+=Integer.parseInt(s)*1000;
            if(i==7)year=Integer.parseInt(s);
        }
        Calendar c = new GregorianCalendar(year,month,day);
        Date d;
        d = c.getTime();
        d.setTime(d.getTime()+time);
        return d;
    }

    enum Month {Jan,Feb, Mar, Apr, May, Jun,Jul,Aug,Sep,Oct,Nov,Dec }
}
