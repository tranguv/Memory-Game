package com.example.memorygame;

public class MemoryCard {
    public boolean isMatched;
    public boolean isFaceUp;
    private int position;

    public MemoryCard(int position, boolean isFaceUp, boolean isMatched){
        this.position = position;
        this.isMatched = isMatched;
        this.isFaceUp = isFaceUp;
    }

    public int getPosition() {
        return position;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }
    public void setMatched(boolean isMatched){isMatched = isMatched; }

}
