import javax.swing.*;
import java.lang.reflect.Type;

public class Muur extends BoardObject{


    public int getValue(){
        return 0;
    }
    public BoardObject getSleutel() { return null; }
    public void setSleutel (BoardObject sleutel) {

    }

    public void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board){

    }
    public Muur(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/muur.jpg")));
    }

}
