package com.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Alex alex = new Alex("Самец", feline);

        lion.getKittens();
        lion.doesHaveMane();
        lion.getFood();

        alex.getKittens();
        alex.doesHaveMane();
        alex.getFood();
    }
}

