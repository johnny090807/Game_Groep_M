import javax.swing.*;

public class Einde extends BoardObject{
    public Einde(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/end.png")));
        super.setType(Type.EINDE);
    }
}
