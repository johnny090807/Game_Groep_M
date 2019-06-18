import javax.swing.*;
import java.awt.*;


public class Board extends JPanel {


    private Level level;


    private BoardObject speler = new Speler(0,0);


    private JPanel
            gamePanel,
            infoPanel = new JPanel(new GridLayout(1,3)),
            homePanel = new JPanel();


    private JLabel
            resetLabel = new JLabel("Reset by pressing (R).", JLabel.CENTER),
            quitLabel = new JLabel("Press (ESC) to quit.", JLabel.CENTER),
            infoLabel = new JLabel("Probeer tot het groene vlak te komen", JLabel.CENTER);

    private JButton
            resetButton = new JButton("Reset"),
            quitButton = new JButton("Exit");


    private Square[][] squares;


    public Board(){
        resetButton.setFocusable(false);
        quitButton.setFocusable(false);

        super.setLayout(new BorderLayout());


        this.homePanel.setPreferredSize(new Dimension(500, 55));


        startLevel(1);

        resetButton.addActionListener(action -> {
            restartLevel();
            resetButton.setFocusable(false);
        });
        quitButton.addActionListener(action -> {
            System.exit(0);
            quitButton.setFocusable(false);
        });
    }


    public void startLevel(int numberLevel){

        this.updateHomePanel();


        this.updateInfoPanel();

        this.level = new Level(numberLevel);

        speler = new Speler(this.level.beginZone.x,this.level.beginZone.y);

        gamePanel = new JPanel(new GridLayout(this.level.boardGrootte.width,this.level.boardGrootte.height));

        super.add(gamePanel, BorderLayout.CENTER);
        super.add(homePanel, BorderLayout.PAGE_START);
        super.add(infoPanel, BorderLayout.PAGE_END);


        squares = new Square[this.level.boardGrootte.width][this.level.boardGrootte.height];


        for(int x = 0; x < this.level.boardGrootte.width; x++){
            for(int y = 0; y < this.level.boardGrootte.height; y++){
                squares[x][y] = new Square(x,y);
            }
        }

        for (BoardObject object: this.level.objecten){
            switch (object.getType()){
                case "MUUR":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(object);
                    break;
                case "BARRICADE":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(object);
                    break;
                case "SLEUTEL":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(object);
                    break;
                case "EINDE":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(object);
                    break;

            }
        squares[speler.getPosition().x][speler.getPosition().y].setBoardObject(speler);


        updateGamePanel();
    }
    }

    public void beweegSpeler(char direction, int howMuch){

        Square vorigeSquare = squares[speler.getPosition().x][speler.getPosition().y];


        Square volgendeSquare = null;


        switch (direction){

            case 'x':

                if(speler.getPosition().x + howMuch < 0 || speler.getPosition().x + howMuch > this.level.boardGrootte.width -1){
                    return;
                }else{

                    volgendeSquare = squares[speler.getPosition().x + howMuch][speler.getPosition().y];

                }
                break;

            case 'y':

                if(speler.getPosition().y + howMuch < 0 || vorigeSquare.getPosition().y + howMuch > this.level.boardGrootte.height -1){
                   return;
                }else {

                    volgendeSquare = squares[speler.getPosition().x][speler.getPosition().y + howMuch];
                }
                break;
        }

        if(volgendeSquare.hasBoardObject()){

            switch (volgendeSquare.getBoardObject().getType()){

                case "BARRICADE":

                    Barricade volgendeSquareBarricade = (Barricade) volgendeSquare.getBoardObject();

                    if (speler.getSleutel() != null && speler.getSleutel().getValue() == volgendeSquareBarricade.unlockValue) {

                        speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);

                        vorigeSquare.setBoardObject(null);

                        volgendeSquare.setBoardObject(speler);

                    } else if (speler.getSleutel() != null && speler.getSleutel().getValue() != volgendeSquareBarricade.unlockValue){

                        this.infoLabel.setText("Hier heb je sleutel " +  volgendeSquareBarricade.unlockValue + " voor nodig.");

                        updateInfoPanel();
                    }else if(speler.getSleutel() == null){

                        this.infoLabel.setText("Je hebt geen sleutel!");

                        updateInfoPanel();
                    }else{

                        this.infoLabel.setText("Er is iets fout gegaan!");

                        updateInfoPanel();
                    }
                    break;

                case "SLEUTEL":
                    speler.setSleutel(volgendeSquare.getBoardObject());

                    speler.setSleutel((Sleutel) volgendeSquare.getBoardObject());

                    speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);

                    volgendeSquare.setBoardObject(speler);

                    vorigeSquare.setBoardObject(null);
                    break;

                case "EINDE":


                    nextLevel();
                    break;

                case "MUUR":
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
    public void nextLevel(){
        try{
            startLevel(this.level.levelNumber + 1);
        }catch (Exception e){
            this.infoLabel.setText("Er is geen volgend level!");
            this.updateInfoPanel();
            startLevel(this.level.levelNumber - 1);

        }
    }

    public void updateGamePanel(){
        gamePanel.removeAll();
        gamePanel.setBackground(new Color(255,255,255));
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


        this.homePanel.add(this.resetButton);
        this.homePanel.add(this.quitButton);

        this.homePanel.revalidate();
        this.homePanel.repaint();
    }

    public void updateInfoPanel(){
        this.infoPanel.removeAll();

        this.infoPanel.add(this.infoLabel);

        this.infoPanel.revalidate();
        this.infoPanel.repaint();
    }
}

