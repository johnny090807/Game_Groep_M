import javax.swing.*;
import java.awt.*;

public class Square {
    private BoardObject boardObject;

    private JLabel label = new JLabel("");

    private Point position;



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


    public void setBoardObject(BoardObject boardObject){
        this.boardObject = boardObject;
    }


}
