package org.example;

class RotateLeft implements MoveRover {
    private final Rover rover;

    RotateLeft(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void move() {
        rover.rotateLeft();
    }
}
