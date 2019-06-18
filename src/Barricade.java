import javax.swing.*;
import java.lang.reflect.Type;

public class Barricade extends BoardObject {

    public int unlockValue;


    public Barricade(int x, int y, int unlockValue){
        super(x,y);
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
    public void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board){
        Barricade volgendeSquareBarricade = (Barricade) volgendeSquare.getBoardObject();

        if (speler.getSleutel() != null && speler.getSleutel().getValue() == volgendeSquareBarricade.unlockValue) {

            speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);

            vorigeSquare.setBoardObject(null);

            volgendeSquare.setBoardObject(speler);

        } else if (speler.getSleutel() != null && speler.getSleutel().getValue() != volgendeSquareBarricade.unlockValue){

            board.infoLabel.setText("Hier heb je sleutel " +  volgendeSquareBarricade.unlockValue + " voor nodig.");
            board.updateInfoPanel();

        }else if(speler.getSleutel() == null){

            board.infoLabel.setText("Je hebt geen sleutel!");
            board.updateInfoPanel();

        }else{

            board.infoLabel.setText("Er is iets fout gegaan!");
            board.updateInfoPanel();
        }
    }

    public int getValue(){
        return this.unlockValue;
    }

    public BoardObject getSleutel() {
        return null; }
    public void setSleutel (BoardObject sleutel) {

    }
}
