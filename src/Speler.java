import javax.swing.*;

public class Speler extends BoardObject{

    private BoardObject sleutel = null;



    public Speler(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/speler.png")));

    }

    public void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board){


    }
    public int getValue(){
        return 0;
    }

    public BoardObject getSleutel() { return this.sleutel;}
    public void setSleutel (BoardObject sleutel) {this.sleutel = sleutel;}


}
