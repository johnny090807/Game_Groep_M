import javax.swing.*;

public class Sleutel  extends BoardObject {
    private  int value;


    public Sleutel(int x, int y, int value){

        super(x, y);
        super.setType(Type.SLEUTEL);

        this.value = value;

        switch (this.value){
            case 100:
                super.setLabel(new JLabel(new ImageIcon("src/assets/KeyRood.png")));
                break;
            case 200:
                super.setLabel(new JLabel(new ImageIcon("src/assets/KeyBlauw.png")));
                break;
            case 300:
                super.setLabel(new JLabel(new ImageIcon("src/assets/KeyGeel.png")));
                break;
            case 400:
                super.setLabel(new JLabel(new ImageIcon("src/assets/KeyGroen.png")));
                break;
            default:
                super.setLabel(new JLabel("ERROR"));
                break;
        }
    }

    public int getValue() {return  this.value;}
}
