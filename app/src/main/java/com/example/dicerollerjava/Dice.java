package com.example.dicerollerjava;

public class Dice {
    private int _sides;

    /**
     * Constructor
     */
    public int GetSides() {
        return _sides;
    }

    public int SetSides(int sides) {
        this._sides = sides;
        return sides;
    }

    public Dice(int sides) {
        this._sides = sides;
    }

    public int DiceRoll() {
        //Get a random range from 0 to the amount of sides
        return (int) (Math.random() * _sides + 1);
    }



}
