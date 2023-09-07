package org.example;

class Advance implements MoveRover {
    private final Rover rover;

    Advance(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void move() {
        rover.advance();
    }
}