package com.example.memorygame;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MedMode extends AppCompatActivity{
    private List<Button> buttonList;
    private int index = 0;
    private MemoryCard[] cardSelected;
    private int indexOfCurrentCard = -1;
    private Handler mHandler = new Handler();
    public int moves;
    public static int bestMove, prevMove;
    private TextView moveTV, bestMoveTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        MyApplication myApplication = (MyApplication) getApplication();
        myApplication.setbestMove(bestMove);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediummode);
        Button button = (Button) findViewById(R.id.returnHomeM);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        });
        buttonList = new ArrayList<Button>(Arrays.asList(findViewById(R.id.button6), findViewById(R.id.button5), findViewById(R.id.button4),
                findViewById(R.id.button11), findViewById(R.id.button2), findViewById(R.id.button3), findViewById(R.id.button), findViewById(R.id.button13),
                findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button12), findViewById(R.id.button14),
                findViewById(R.id.button10), findViewById(R.id.button15), findViewById(R.id.button16)));

        cardSelected = new MemoryCard[buttonList.size()];
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> chosenImage = myApplication.chooseRandom(buttonList.size()/2);
        result.addAll(chosenImage);
        result.addAll(chosenImage);
        Collections.shuffle(result);

        while(index < buttonList.size()){
            cardSelected[index] = new MemoryCard(result.get(index), false, false);

            buttonList.get(index).setOnClickListener(view -> {
                onClick(view, result);
            });
            index++;
        }
    }

    private boolean checkAllFaceUp() {
        for(MemoryCard card: cardSelected){
            if(!card.isFaceUp){
                return false;
            }
        }
        return true;
    }

    private void onClick(View view, ArrayList<Integer> result){
        updateModel(view, result);
        updateView(view, result);
        moves++;
        moveTV= (TextView) findViewById(R.id.moveM);
        moveTV.setText("Moves: " + moves);

        if(checkAllFaceUp()){
            bestMoveTV = (TextView) findViewById(R.id.bestMoveM);
            SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
            bestMove = prefs.getInt("key1", 0);
            if(bestMove == 0 || moves <= bestMove ){
                bestMove = moves;
                SharedPreferences.Editor edit = prefs.edit();
                edit.putInt("key1", moves);
                edit.commit();
            }
            bestMoveTV.setText("Best records: " + bestMove);
            Toast.makeText(this, "Yay, you found all the matches!", Toast.LENGTH_SHORT).show();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MedMode.this, Main.class);
                    startActivity(intent);
                }
            };
            mHandler.postDelayed(runnable, 2000);
        } else {
            return;
        }
    }



    private void updateView(View view, ArrayList<Integer> result) {
        int position = buttonList.indexOf(view);
        for(int i = 0; i < cardSelected.length; i++){
            Button button = buttonList.get(i);
            button.setBackgroundResource(cardSelected[i].isFaceUp ? cardSelected[i].getPosition() : R.drawable.bear);
        }
    }

    private void updateModel(View view, ArrayList<Integer> result) {
        int position = buttonList.indexOf(view);
        if(cardSelected[position].isFaceUp){
            Toast.makeText(this, "Choose another card", Toast.LENGTH_SHORT).show();
            return;
        }

        if(indexOfCurrentCard == -1){
            makeCardFaceDown();
            indexOfCurrentCard = position;
        } else {
            isMatched(indexOfCurrentCard, position);
            indexOfCurrentCard = -1;
        }
        cardSelected[position].isFaceUp = !cardSelected[position].isFaceUp;
    }

    private void makeCardFaceDown() {
        for(MemoryCard card: cardSelected){
            if(!card.isMatched){
                card.isFaceUp = false;
            }
        }
    }

    private void isMatched(int currentIndex, int pos){
        if(cardSelected[currentIndex].getPosition() == cardSelected[pos].getPosition()){
            cardSelected[currentIndex].isMatched = true;
            cardSelected[pos].isMatched = true;
        }
    }

}
