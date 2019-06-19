import javax.swing.*;
import java.lang.reflect.Type;

public class Sleutel  extends BoardObject {
    private int value;

    public Sleutel(int x, int y, int value) {

        super(x, y);

        this.value = value;

        switch (this.value) {
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
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("src/assets/KeyDefault.png"));
                label.setText("" + value);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.CENTER);
                super.setLabel(label);
                break;
        }
    }
    public void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board){
        speler.setSleutel(this);
        speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
        volgendeSquare.setBoardObject(speler);
        vorigeSquare.setBoardObject(null);
    }

    public int getValue() {
        return this.value;
    }
}

