import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private Level level;

    private Speler speler;

    private ArrayList<Muur> muren = new ArrayList<>();
    private ArrayList<Barricade> barricades = new ArrayList<>();
    private  ArrayList<Sleutel> sleutels = new ArrayList<>();

    private JPanel
            gamePanel,
            homePanel = new JPanel(new GridLayout(1,3));

    private JLabel
            resetLabel = new JLabel("Reset by pressing (R).", JLabel.CENTER),
            quitLabel = new JLabel("Press (ESC) to quit.", JLabel.CENTER);

    private Square[][] squares;

    public Board(){
        super.setLayout(new BorderLayout());

        this.homePanel.setPreferredSize(new Dimension(500, 55));

        startLevel(1);
    }

    public void startLevel(int numberLevel){
        updateHomePanel();

        this.level = new Level(numberLevel);

        speler = new Speler(0,0);

        gamePanel = new JPanel(new GridLayout(this.level.boardGrootte.width,this.level.boardGrootte.height));

        super.add(gamePanel, BorderLayout.CENTER);
        super.add(homePanel, BorderLayout.PAGE_START);

        squares = new Square[this.level.boardGrootte.width][this.level.boardGrootte.height];

        for(int x = 0; x < this.level.boardGrootte.width; x++){
            for(int y = 0; y < this.level.boardGrootte.height; y++){
                squares[x][y] = new Square(x,y);
            }
        }

        for (Muur muur: this.level.muren){
            squares[muur.getPosition().x][muur.getPosition().y].setBoardObject(new Muur(muur.getPosition().x, muur.getPosition().y));
        }

        for (Barricade barricade: this.level.barricades){
            squares[barricade.getPosition().x][barricade.getPosition().y].setBoardObject(new Barricade(barricade.getPosition().x, barricade.getPosition().y, barricade.getUnlockValue()));
        }

        for (Sleutel sleutel: this.level.sleutels){
            squares[sleutel.getPosition().x][sleutel.getPosition().y].setBoardObject(new Sleutel(sleutel.getPosition().x, sleutel.getPosition().y, sleutel.getValue()));
        }

        squares[speler.getPosition().x][speler.getPosition().y].setBoardObject(speler);

        squares[this.level.eindZone.getPosition().x][this.level.eindZone.getPosition().y].setBoardObject(new Einde(this.level.eindZone.getPosition().x,this.level.eindZone.getPosition().y));

        updateGamePanel();
    }
    public void beweegSpeler(char direction, int howMuch){
        Square vorigeSquare = squares[speler.getPosition().x][speler.getPosition().y];
        Square volgendeSquare = null;
        switch (direction){
            case 'x':
                if(speler.getPosition().x + howMuch < 0 || speler.getPosition().x + howMuch > 10){
                    return;
                }else{
                    volgendeSquare = squares[speler.getPosition().x + howMuch][speler.getPosition().y];

                }
                break;
            case 'y':
                if(speler.getPosition().y + howMuch < 0 || vorigeSquare.getPosition().y + howMuch > 10){
                   return;
                }else {
                    volgendeSquare = squares[speler.getPosition().x][speler.getPosition().y + howMuch];
                }
                break;
        }
        if(volgendeSquare.hasBoardObject()){
            switch (volgendeSquare.getBoardObject().getType()){
                case BARRICADE:
                    Barricade volgendeSquareBarricade = (Barricade) volgendeSquare.getBoardObject();
                    if (speler.getSleutel() != null && speler.getSleutel().getValue() == volgendeSquareBarricade.unlockValue) {
                        speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
                        vorigeSquare.setBoardObject(null);
                        volgendeSquare.setBoardObject(speler);
                    } else if (speler.getSleutel() != null && speler.getSleutel().getValue() != volgendeSquareBarricade.unlockValue){
                        JOptionPane.showMessageDialog(null, "Verkeerd sleutel", "",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case SLEUTEL:
                    speler.setSleutel((Sleutel) volgendeSquare.getBoardObject());
                    speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
                    volgendeSquare.setBoardObject(speler);
                    vorigeSquare.setBoardObject(null);
                    break;
                case EINDE:
                    restartLevel();
                    break;
                case MUUR:
                    break;
            }

        }else{
            speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
            vorigeSquare.setBoardObject(null);
            volgendeSquare.setBoardObject(speler);
        }
        updateGamePanel();
    }

    public void restartLevel(){
        startLevel(this.level.levelNumber);
    }

    public void updateGamePanel(){
        gamePanel.removeAll();

        for(Square[] squares: squares){
            for(Square square: squares){
                if(square.hasBoardObject()){
                    gamePanel.add(square.getBoardObject().getLabel());
                }else{
                    gamePanel.add(square.getLabel());
                }
            }
        }
        this.gamePanel.revalidate();
        this.gamePanel.repaint();
    }
    public void updateHomePanel(){
        this.homePanel.removeAll();

        this.homePanel.add(this.resetLabel);
        this.homePanel.add(this.quitLabel);

        this.homePanel.revalidate();
        this.homePanel.repaint();
    }
}
