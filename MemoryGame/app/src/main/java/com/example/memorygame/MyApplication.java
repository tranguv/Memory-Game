package com.example.memorygame;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MyApplication extends Application {
    private int bestMove;
    private ArrayList<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.g1, R.drawable.g2, R.drawable.g4, R.drawable.g5, R.drawable.g6, R.drawable.g7,
            R.drawable.g8, R.drawable.g9, R.drawable.g11, R.drawable.g12, R.drawable.g13, R.drawable.g14, R.drawable.g15, R.drawable.g16, R.drawable.g18
            , R.drawable.g19, R.drawable.g20, R.drawable.g21, R.drawable.g22, R.drawable.g24));
    public MyApplication(){
        this.bestMove = 0;
    }

    public void setbestMove(int move) {
        this.bestMove = move;
    }

    public ArrayList<Integer> getImages(){
        return images;
    }

    public ArrayList<Integer> chooseRandom(int size){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Collections.shuffle(images);
        for(int i = 0 ; i < size; i++){
            result.add(images.get(i));
        }
        return result;
    }



}
