package com.example.dice;

public class DiceRoll
{
    public enum RollType { COIN, DICE, RANDOM };

    public  String name;

    public RollType type;


    public DiceRoll( String n, RollType t )
    {
        name = n;
        type = t;
    }
}
