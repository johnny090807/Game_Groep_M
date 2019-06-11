import javax.swing.*;

public class Muur extends BoardObject{
    public Muur(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/muur.jpg")));
        super.setType(Type.MUUR);
    }

}
