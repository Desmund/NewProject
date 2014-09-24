package Main;

import Main.Menu.BaseWork;

import java.util.ArrayList;

/**
 * Created by Denis on 22.09.2014.
 */
public class WorkInMemory {
    private static WorkInMemory instance;

    private static ArrayList<BaseWork> bw;

    public ArrayList<BaseWork> getAllList(){
        return bw;
    }

    public void addWork(BaseWork work){
        bw.add(work);
    }

    public boolean oneWorkHasRating(){
        for(int i=0;i<bw.size();i++){
            if(bw.get(i).getRating()>0) return true;
        }
        return false;
    }

    private WorkInMemory() {
    }

    public static WorkInMemory get() {
        if (instance == null) {
            bw = new ArrayList<BaseWork>();
            instance = new WorkInMemory();
        }
        return instance;
    }
}
