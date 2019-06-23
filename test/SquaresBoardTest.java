import org.junit.Test;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static org.junit.Assert.*;

// Gemaakt door: John
// Deze test kijkt of het speelveld met alle vakjes gemaakt wordt

public class SquaresBoardTest {

    private Square[][] squares;

    @Test
    public void startLevel() {
        squares = new Square[10][10];

        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++) {
                squares[x][y] = new Square(x,y);
            }
        }
        int i = 0;
        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++) {
                if(!squares[x][y].hasBoardObject()){
                    i++;
                }
            }
        }
        assertEquals(100, i);
    }
}