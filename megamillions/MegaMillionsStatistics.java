package com.lottery.lottery.megamillions;
import java.util.ArrayList;
import java.util.HashMap;

public class MegaMillionsStatistics{

    private MegaMillionsReader data;
    
    public int[] most_frequent_winning_numbers;
    public int most_frequent_megaball_number;


    public MegaMillionsStatistics(){
        data = new MegaMillionsReader("C:\\Users\\fawces\\Desktop\\Github\\lottery\\lottery\\src\\main\\java\\com\\lottery\\megamillions\\data\\2002+data.csv.csv");
    }



    //most frequent winning numbers
    public ArrayList<Integer> m_f_w_n(){
        HashMap<Integer, Integer> number_frequency = new HashMap<Integer, Integer>();
        for(String date : data.DATA.keySet()){
            for(int i = 0; i < data.DATA.get(date).length - 1; i++){
                if(!number_frequency.containsKey(data.DATA.get(date)[i]) && data.DATA.get(date)[i] != 0){
                    number_frequency.put(data.DATA.get(date)[i], 1);
                } else {
                    number_frequency.put(data.DATA.get(date)[i], number_frequency.get(data.DATA.get(date)[i]) + 1);
                }
            }
        }

        
        ArrayList<Integer> most_frequent = new ArrayList<Integer>();
        most_frequent.add(0, 1);
        most_frequent.add(1, 1);
        most_frequent.add(2, 1);
        most_frequent.add(3, 1);
        most_frequent.add(4, 1);

        for(int i = 0; i < 5; i++){
            int cur_mf = 1;
            for(int num : number_frequency.keySet()){
                if((number_frequency.get(num) > number_frequency.get(cur_mf) && !most_frequent.contains(num))){
                    cur_mf = num;
                }
            }
            most_frequent.add(i, cur_mf);
        }

        most_frequent.remove(9);
        most_frequent.remove(8);
        most_frequent.remove(7);
        most_frequent.remove(6);
        most_frequent.remove(5);

        return most_frequent;
    }


}