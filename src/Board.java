import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private Speler speler = new Speler(0,0);

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

        gamePanel = new JPanel(new GridLayout(10,10));

        super.add(gamePanel, BorderLayout.CENTER);
        super.add(homePanel, BorderLayout.PAGE_START);

        squares = new Square[10][10];

        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                squares[x][y] = new Square(x,y);
            }
        }

        squares[speler.getPosition().x][speler.getPosition().y].setBoardObject(speler);

        this.updateGamePanel();
    }
    public void movePlayer(char direction, int howMuch){
        Square vorigeSquare = squares[speler.getPosition().x][speler.getPosition().y];
        Square volgendeSquare = null;
        switch (direction){
            case 'x':
                volgendeSquare = squares[speler.getPosition().x + howMuch][speler.getPosition().y];
                break;
            case 'y':
                volgendeSquare = squares[speler.getPosition().x][speler.getPosition().y + howMuch];
                break;
        }
        System.out.println(volgendeSquare.getPosition().x + " " + volgendeSquare.getPosition().y);

        if(volgendeSquare.getBoardObject() == speler){
            speler.setPosition(volgendeSquare.getPosition().x, volgendeSquare.getPosition().y);
        }
        squares[volgendeSquare.getPosition().x][volgendeSquare.getPosition().y].setBoardObject(volgendeSquare.getBoardObject());
        updateGamePanel();
    }

    public void resetLevel(){
            System.out.println("hoi level is geupdate.");
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
    }
    public void updateHomePanel(){
        this.homePanel.removeAll();

        this.homePanel.add(this.resetLabel);
        this.homePanel.add(this.quitLabel);

        this.homePanel.revalidate();
        this.homePanel.repaint();
    }
}
