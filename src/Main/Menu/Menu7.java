package Main.Menu;

import Main.Utils;
import Main.WorkInMemory;

import java.util.ArrayList;

/**
 * Created by Denis on 19.09.2014.
 */
public class Menu7 extends BaseMenu {

    @Override
    public void printMenu() {
        stringWriteToConsol("Вы уверенны?");
        stringWriteToConsol("1 - Да");
        stringWriteToConsol("2 - Нет");
        getValue();
    }

    @Override
    public boolean select(int i) {
        Utils.writeEnter();
        switch (i){
            case 1:
                deleteAllWorksWithRating();
                new Menu1().printMenu();
                return true;
            case 2:
                new Menu1().printMenu();
                return true;
        }
        return false;
    }

    private void deleteAllWorksWithRating(){
        ArrayList<BaseWork> bw = WorkInMemory.get().getAllList();
        for(int i=0;i<bw.size();){
            if(bw.get(i).getRating()!=0)
                bw.remove(bw.get(i));
            else
                i++;
        }
        Utils.stringWriteToConsol("Проверенные работы удалены!");
        Utils.stringWriteToConsol("");
    }
}
