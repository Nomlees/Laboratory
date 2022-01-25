package ru.zak.five;

import java.util.Arrays;

public class DownState extends ElevatorState {


    public DownState(Elevator elevator) {
        super(elevator);
    }
    private Elevator mCurState;

    @Override
    public void down() {
        System.out.println("Лифт спускается с этажа");

    }

    @Override
    public void up() {
        System.out.println("Лифт поднимается на этаж");
    }

}