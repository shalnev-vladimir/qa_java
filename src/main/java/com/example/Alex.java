package com.example;

import java.util.List;

public class Alex extends Lion {

    public Alex(String sex, Feline feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return this.feline.getKittens(0);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский Зоопарк";
    }
}
