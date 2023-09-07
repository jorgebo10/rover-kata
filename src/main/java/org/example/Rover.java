package org.example;


import java.util.List;

public class Rover {
    private final Plateau plateau;
    private Coordinates coordinates;
    private Orientation orientation;
    private final int step;


    public Rover(Plateau plateau, Coordinates coordinates, int step) {
        this.plateau = plateau;
        this.coordinates = coordinates;
        this.orientation = Orientation.NORTH;
        this.step = step;
    }

    public String processCommand(String command) {
        for (MoveRover moveRover : getToCharArray(command)) {
            moveRover.move();
        }
        return getCoordinates();
    }

    private List<MoveRover> getToCharArray(String command) { //this is on the edge
        List<Character> list = command.chars().mapToObj(c -> (char) c).toList();

        return list.stream().map(character -> {
            if (character.equals('M')) {
                return new Advance(this);
            }
            if (character.equals('L')) {
                return new RotateLeft(this);
            }
            if (character.equals('R')) {
                return new RotateRight(this);
            }
            throw new IllegalArgumentException("Unknown command");
        }).toList();
    }

    private String getCoordinates() {
        return coordinates.x() + ":" + coordinates.y() + ":" + orientation.name().charAt(0);
    }

    void rotateRight() {
        switch (orientation) {
            case NORTH -> orientation = Orientation.EAST;
            case SOUTH -> orientation = Orientation.WEST;
            case WEST -> orientation = Orientation.NORTH;
            case EAST -> orientation = Orientation.SOUTH;
        }
    }

    void rotateLeft() {
        switch (orientation) {
            case NORTH -> orientation = Orientation.WEST;
            case SOUTH -> orientation = Orientation.EAST;
            case WEST -> orientation = Orientation.SOUTH;
            case EAST -> orientation = Orientation.NORTH;
        }
    }

    void advance() {
        switch (orientation) {
            case WEST ->
                    coordinates = new Coordinates((coordinates.x() - step) % plateau.plateauWidth(), coordinates.y());
            case EAST ->
                    coordinates = new Coordinates((coordinates.x() + step) % plateau.plateauWidth(), coordinates.y());
            case NORTH ->
                    coordinates = new Coordinates(coordinates.x(), (coordinates.y() + step) % plateau.plateauHeight());
            case SOUTH ->
                    coordinates = new Coordinates(coordinates.x(), (coordinates.y() - step) % plateau.plateauHeight());
        }
    }
}
