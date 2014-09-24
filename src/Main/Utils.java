package Main;
/**
 * Created by Denis on 18.09.2014.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {

    public static String stringReadFromConsol()throws Exception{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s = buff.readLine();
        return s;
    }

    public static void stringWriteToConsol(String s){
        System.out.println(s);
    }

    public static void stringWriteToConsolWithoutEnter(String s){
        System.out.print(s);
    }

    public static void writeEnter(){
        System.out.println("");
    }

    public static int getIntValue()throws Exception{
        int num = Integer.parseInt(stringReadFromConsol());
        return num;
    }
}
