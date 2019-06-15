import javax.swing.*;
import java.lang.reflect.Type;

public class Barricade extends BoardObject {

    public int unlockValue;

    private String type;

    public Barricade(int x, int y, int unlockValue){
        super(x,y);
        this.type = "BARRICADE";
        this.unlockValue = unlockValue;

        switch (unlockValue){
            case 100:
                super.setLabel(new JLabel(new ImageIcon("src/assets/BarricadeRood.png")));
                break;
            case 200:
                super.setLabel(new JLabel(new ImageIcon("src/assets/BarricadeBlauw.png")));
                break;
            case 300:
                super.setLabel(new JLabel(new ImageIcon("src/assets/BarricadeGeel.png")));
                break;
            case 400:
                super.setLabel(new JLabel(new ImageIcon("src/assets/BarricadeGroen.png")));
                break;
            default:
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("src/assets/DefaultBarricade.png"));
                label.setText("" + unlockValue);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.CENTER);
                super.setLabel(label);
                break;
        }
    }

    public String getType(){
        return this.type;
    }
    public int getValue(){
        return this.unlockValue;
    }

    public BoardObject getSleutel() { return null; }
    public void setSleutel (BoardObject sleutel) {}
}
