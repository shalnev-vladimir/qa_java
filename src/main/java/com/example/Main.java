package com.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Alex alex = new Alex("Самец", feline);
        Cat cat = new Cat(feline);

        lion.getKittens();
        lion.doesHaveMane();
        lion.getFood();

        alex.getKittens();
        alex.doesHaveMane();
        alex.getFood();

        cat.getFood();
    }
}

