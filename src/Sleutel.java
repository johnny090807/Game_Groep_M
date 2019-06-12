import javax.swing.*;

public class Sleutel  extends BoardObject {
    private  int value;


    public Sleutel(int x, int y, int value){

        super(x, y);
        super.setType(Type.SLEUTEL);

        this.value = value;

        switch (this.value){
            case 100:
                super.setLabel(new JLabel(new ImageIcon("src/assets/redkey.jpg")));
                break;
        }
    }

    public int getValue() {return  this.value;}
}
