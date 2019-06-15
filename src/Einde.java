import javax.swing.*;
import java.lang.reflect.Type;

public class Einde extends BoardObject{

    private String type;

    public Einde(int x, int y){
        super(x,y);
        super.setLabel(new JLabel(new ImageIcon("src/assets/end.png")));
        this.type = "EINDE";
    }
    public String getType(){
        return this.type;
    }

    public int getValue(){
        return 0;
    }
    public BoardObject getSleutel() { return null; }
    public void setSleutel (BoardObject sleutel) {}
}
