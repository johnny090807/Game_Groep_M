import javax.swing.*;

public class Speler extends BoardObject{

    private Sleutel sleutel = null;

    public Speler(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/speler.png")));
    }

    public void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board){

    }
    public int getValue(){
        return 0;
    }

    public Sleutel getSleutel() { return this.sleutel;}
    public void setSleutel (Sleutel sleutel) {this.sleutel = sleutel;}
}
