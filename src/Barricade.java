import javax.swing.*;

public class Barricade extends BoardObject {

    public int unlockValue;

    public Barricade(int x, int y, int unlockValue){
        super(x,y);
        super.setType(Type.BARRICADE);
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
    public int getUnlockValue(){
        return this.unlockValue;
    }
}
