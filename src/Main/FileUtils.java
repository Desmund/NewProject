package Main;

import java.io.*;

/**
 * Created by Denis on 26.09.2014.
 */
public class FileUtils {

    public void writeFile(String fileName,String text){
        try{
            File file = new File(fileName);
            if(!file.exists())
                file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        }catch(Exception e) {
            System.out.println("Ошибка при работе с файлом!");
        }
    }

    public String readFile(String fileName){
        StringBuilder sb = new StringBuilder();
        if(exists(fileName)) {
            File file = new File(fileName);
            try {
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                }finally {
                    in.close();
                }
            }catch (Exception e) {
                System.out.println("Ошибка при работе с файлом!");
            }
        }
        return sb.toString();
    }

    public boolean exists(String fileName){
        File file = new File(fileName);
        if (!file.exists())
            return false;
        else
            return true;
    }

    public void updateFile(String fileName, String newText){
        if(exists(fileName)) {
            StringBuilder sb = new StringBuilder();
            String oldFile = readFile(fileName);
            sb.append(oldFile);
            sb.append(newText);
            writeFile(fileName, sb.toString());
        }
    }
    public void delete(String fileName){
        if(exists(fileName))
            new File(fileName).delete();
    }
}
