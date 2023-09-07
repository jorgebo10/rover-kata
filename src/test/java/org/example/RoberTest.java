package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * # Mars Rover Kata
 * <p>
 * 1. A robotic rover is to be landed by NASA on a plateau on Mars
 * 2. The rover’s position on the plateau is represented by a combination of X and Y coordinates in a grid
 * 3. The coordinates 0,0 means the rover is positioned at the bottom left of the grid
 * 4. The rover also has the direction he is pointing to, which is represented by one of the four cardinal compass points: N,S,E,W
 * 5. When a rover lands on the plateau, his initial starting point is always: 0,0,N
 * 6. In order to control a rover, NASA sends a simple string of letters, which are called commands
 * 7. The possible commands are ‘L’, ‘R’, and ‘M’
 * 8. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right, respectively, without moving from its current spot
 * 9. ‘M’ moves the rover one point in the current direction
 * <p>
 * Example:
 * <p>
 * The rover receives the following commands “RMMLM” and returns the finishing point after the moves: “2:1:N” (N means facing North).
 * <p>
 * Initial position: "0:0:N"
 * <p>
 * |---|---|---|
 * |   |   |   |
 * |---|---|---|
 * |   |   |   |
 * |---|---|---|
 * | N |   |   |
 * |---|---|---|
 * <p>
 * After sending the commands RMMLM: "2:1:N"
 * <p>
 * |---|---|---|
 * |   |   |   |
 * |---|---|---|
 * |   |   | N |
 * |---|---|---|
 * |   |   |   |
 * |---|---|---|
 *
 * @jorgebo10
 */
class RoberTest {

    @Test
    void canRotateLeft() {
        String command = "L";
        String position = getRober().processCommand(command);

        assertEquals("0:0:W", position);
    }

    private Rover getRober() {
        return new Rover(new Plateau(4, 4), new Coordinates(0, 0), 1);
    }

    @Test
    void canRotateRight() {
        String command = "R";
        String position = getRober().processCommand(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void canMoveOneForwardStep() {
        String command = "M";
        String position = getRober().processCommand(command);

        assertEquals("0:1:N", position);
    }

    @Test
    void canRotateAndMove() {
        String command = "RM";
        String position = getRober().processCommand(command);

        assertEquals("1:0:E", position);
    }

    @Test
    void canMakeMoreMovements() {
        String command = "RMMLM";
        String position = getRober().processCommand(command);

        assertEquals("2:1:N", position);
    }

    @Test
    void canFoldThePlateau() {
        String command = "MMMM";
        String position = getRober().processCommand(command);

        assertEquals("0:0:N", position);
    }
}

/**
 * 3
 * 2
 * 1
 * 0 1 2 3
 */