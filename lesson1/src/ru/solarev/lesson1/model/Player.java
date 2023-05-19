package ru.solarev.lesson1.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<BattleShipBoard> bsbs;

    public Player(String name) {
        this.name = name;
        bsbs = new ArrayList<>();
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBattleShipBoard(BattleShipBoard bsb){
        bsbs.add(bsb);
    }


}
