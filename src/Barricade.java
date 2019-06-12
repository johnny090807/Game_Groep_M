import javax.swing.*;

public class Barricade extends BoardObject {

    public int unlockValue;

    public Barricade(int x, int y, int unlockValue){
        super(x,y);
        super.setType(Type.BARRICADE);
        this.unlockValue = unlockValue;

        switch (unlockValue){
            case 100:
                super.setLabel(new JLabel(new ImageIcon("src/assets/barricade.jpg")));
                break;




        }
    }
}
