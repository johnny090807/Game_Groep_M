import javax.swing.*;
import java.lang.reflect.Type;

public class Einde extends BoardObject{


    public Einde(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/end.png")));
    }
    public void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board){
        board.nextLevel();
    }

    public int getValue(){
        return 0;
    }
    public BoardObject getSleutel() { return null; }
    public void setSleutel (BoardObject sleutel) {}
}
