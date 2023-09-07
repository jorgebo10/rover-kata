package org.example;

class RotateRight implements MoveRover {
    private final Rover rover;

    RotateRight(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void move() {
        rover.rotateRight();
    }
}
