package com.lottery.lottery.megamillions;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.util.*;

public class MegaMillionsReader{
    public HashMap<String, int[]> DATA = new HashMap<String, int[]>();
    private ArrayList<String> draw_data = new ArrayList<String>();
    private String file_name;

    public MegaMillionsReader(String file_name){
        this.file_name = file_name;
        this.read(file_name);
        this.organize();
    }

    public MegaMillionsReader(){
        //nothing
    }

    public void read(String file_name){
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(file_name)));
            String current_draw;
            //0th index are titles
            for(int i = 0; ((current_draw = br.readLine()) != null); i++){
                draw_data.add(i, current_draw);
            }
            br.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }

    }

    public void read(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(this.file_name)));
            String current_draw;
            //0th index are titles
            for(int i = 0; ((current_draw = br.readLine()) != null); i++){
                draw_data.add(i, current_draw);
            }
            br.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }

    }

    private void organize(){
        System.out.println("Sorting data... Please wait.");
        for(int i = 1; i < this.draw_data.size(); i++){
            String[] cur_data_line = this.draw_data.get(i).split(",");
            String[] winning_nums_str = cur_data_line[1].split(" ");
            int cur_mega_ball = Integer.parseInt(cur_data_line[2]);
            int[] cur_winning_nums = new int[6];
            for(int j = 0; j < cur_winning_nums.length - 1; j++){
                cur_winning_nums[j] = Integer.parseInt(winning_nums_str[j]);
            }
            cur_winning_nums[5] = cur_mega_ball;
            DATA.put(cur_data_line[0], cur_winning_nums);
        }
    }


}