package Lesson4;

import java.util.Arrays;

public class Storage {
    private int size = 3;
    private Good[] goods = new Good[size];

    public void addGood(Good good){
        for (int i = 0; i < goods.length; i++)
        if (goods[i] == null) {
            goods[i] = good;
            return;
        }
        System.out.println("Места нет");
    }


    public void showGood(){
        System.out.println(Arrays.toString(goods));
    }

}
