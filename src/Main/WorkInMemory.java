package Main;

import Main.Menu.BaseWork;

import java.util.ArrayList;

/**
 * Created by Denis on 22.09.2014.
 */
public class WorkInMemory {
    private static WorkInMemory instance;

    private  ArrayList<BaseWork> bw = new ArrayList<BaseWork>();

    public ArrayList<BaseWork> getAllList(){
        return bw;
    }

    public void addWork(BaseWork work){
       bw.add(work);
    }

    private WorkInMemory() {
    }

    public static WorkInMemory get() {
        if (instance == null) {
            instance = new WorkInMemory();
        }
        return instance;
    }
}
