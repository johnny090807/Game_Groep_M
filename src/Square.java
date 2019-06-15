import javax.swing.*;
import java.awt.*;

public class Square {
    private BoardObject boardObject;

    private JLabel label = new JLabel("");

    private Point position;

    private Type type = Type.SQUARE;

    private enum Type{
        SQUARE
    }

    public Square(int x, int y){

        this.position = new Point(x,y);
    }

    public boolean hasBoardObject(){
        return this.boardObject != null;
    }

    public BoardObject getBoardObject(){
        return this.boardObject;
    }

    public JLabel getLabel(){
        return this.label;
    }

    public Point getPosition(){
        return this.position;
    }

    public Type getType(){
        return this.type;
    }

    public void setBoardObject(BoardObject boardObject){
        this.boardObject = boardObject;
    }

    public void setLabel(JLabel label){
        this.label = label;
    }

    public void setType(Type type){
        this.type = type;
    }

}
