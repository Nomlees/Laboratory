package ru.zak.five;

public class Elevator {
    private ElevatorState downState;
    private ElevatorState upState;
    private ElevatorState mCurState;


    public void setState(ElevatorState state) {
        this.mCurState = state;
    }

    public ElevatorState getDownState() {
        return downState;
    }

    public ElevatorState getUpState() {
        return upState;
    }
    public void up(){
        mCurState.up();
    }
    public void down(){
        mCurState.down();
    }
}