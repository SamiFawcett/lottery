package com.lottery.lottery.megamillions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{

    public static void main(String[] args){
        MegaMillionsStatistics ms = new MegaMillionsStatistics();
        ArrayList<Integer> most_frequent = ms.m_f_w_n();
        Collections.sort(most_frequent);
        for(int i = 0; i < 5; i++){
            System.out.print(most_frequent.get(i) + " ");
        }
    }
}