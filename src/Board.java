import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private Speler speler = new Speler(0,0);

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

        muren.add(new Muur(0,1));
        muren.add(new Muur(1,1));
        muren.add(new Muur(2,1));
        muren.add(new Muur(3,1));
        muren.add(new Muur(4,1));
        muren.add(new Muur(5,1));
        barricades.add(new Barricade(8,1,100));
        sleutels.add(new Sleutel(3,5,100));


        gamePanel = new JPanel(new GridLayout(10,10));

        super.add(gamePanel, BorderLayout.CENTER);
        super.add(homePanel, BorderLayout.PAGE_START);

        squares = new Square[10][10];

        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                squares[x][y] = new Square(x,y);
            }
        }

        for (Muur muur: muren){
            squares[muur.getPosition().x][muur.getPosition().y].setBoardObject(new Muur(muur.getPosition().x,muur.getPosition().y));
        }

        for (Barricade barricade: barricades){
            squares[barricade.getPosition().x][barricade.getPosition().y].setBoardObject(new Barricade(barricade.getPosition().x,barricade.getPosition().y,100));
        }

        for (Sleutel sleutel: sleutels){
            squares[sleutel.getPosition().x][sleutel.getPosition().y].setBoardObject(new Sleutel(sleutel.getPosition().x,sleutel.getPosition().y,100));
        }


        squares[speler.getPosition().x][speler.getPosition().y].setBoardObject(speler);

        this.updateGamePanel();
    }
    public void movePlayer(char direction, int howMuch){
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
//                case SPELER:
//                    volgendeSquare.setBoardObject(speler);
//                    break;


                case BARRICADE:
                    Barricade volgendeSquareBarricade = (Barricade) volgendeSquare.getBoardObject();
                    if (speler.getSleutel() != null && speler.getSleutel().getValue() == volgendeSquareBarricade.unlockValue) {
                        vorigeSquare.setBoardObject(null);
                        volgendeSquare.setBoardObject(speler);

                    } else if (speler.getSleutel() != null && speler.getSleutel().getValue() != volgendeSquareBarricade.unlockValue){

                        JOptionPane.showMessageDialog(null, "Verkeerd sleutel", "",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case SLEUTEL:
                    speler.setSleutel((Sleutel) volgendeSquare.getBoardObject());
                    volgendeSquare.setBoardObject(speler);
                    vorigeSquare.setBoardObject(null);
                    break;

                case MUUR:
                    return;
            }

        }else{
            speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
            vorigeSquare.setBoardObject(null);
            volgendeSquare.setBoardObject(speler);
        }
        updateGamePanel();
    }

    public void restartLevel(){
        speler.setPosition(0,0);
        updateGamePanel();
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
