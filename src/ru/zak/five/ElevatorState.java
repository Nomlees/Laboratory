package ru.zak.five;

public abstract class ElevatorState {
    protected Elevator mElevator;

    public ElevatorState(Elevator elevator) {
        this.mElevator = this.mElevator;
    }

    public abstract void down();
    public abstract void up();
}