import javax.swing.*;

public class Speler extends BoardObject{

    public Speler(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/speler.png")));
    }



}
