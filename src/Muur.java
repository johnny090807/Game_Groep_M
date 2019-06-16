import javax.swing.*;
import java.lang.reflect.Type;

public class Muur extends BoardObject{
    private String type;

    public String getType(){
        return this.type;
    }

    public int getValue(){
        return 0;
    }
    public BoardObject getSleutel() { return null; }
    public void setSleutel (BoardObject sleutel) {

    }

    public Muur(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/muur.jpg")));
        this.type = "MUUR";
    }

}
