import javax.swing.*;
import java.awt.*;
/*
    Klasse Board;
    Het overerft de klasse JPanel
 */

public class Board extends JPanel {

    // Variabele van het level
    private Level level;


    public Speler speler = new Speler(0,0);

    // Alle Panelen
    private JPanel
            gamePanel,
            infoPanel = new JPanel(new GridLayout(1,3)),
            homePanel = new JPanel();

    // Alle Labels
    public JLabel infoLabel = new JLabel("Probeer tot het groene vlak te komen", JLabel.CENTER);

    private JButton
            resetButton = new JButton("Reset"),
            quitButton = new JButton("Exit");

    // Alle rechthoeken die het spel maken
    private Square[][] squares;

    // Constructor voor het board
    public Board(){

        resetButton.setFocusable(false);
        quitButton.setFocusable(false);
        // Zet de layout van het overgeerfte paneel in een BorderLayout
        super.setLayout(new BorderLayout());

        // Zet de grootte vast van het home paneel
        this.homePanel.setPreferredSize(new Dimension(500, 55));

// Start het level met de daarop aangewezen level
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

    // operatie startLevel; verwacht een nummer voor welk level die moet starten
    public void startLevel(int numberLevel){
// Update het home paneel
        this.updateHomePanel();


        this.updateInfoPanel();
        // Stel het level vast voor deze klasse
        this.level = new Level(numberLevel);
        // Vul de variabele van de speler
        speler = new Speler(this.level.beginZone.x,this.level.beginZone.y);
        // Stel de grootte vast van het game paneel
        gamePanel = new JPanel(new GridLayout(this.level.boardGrootte.width,this.level.boardGrootte.height));
        // Voeg de panelen toe aan het overgeerfte JPanel
        super.add(gamePanel, BorderLayout.CENTER);
        super.add(homePanel, BorderLayout.PAGE_START);
        super.add(infoPanel, BorderLayout.PAGE_END);


        squares = new Square[this.level.boardGrootte.width][this.level.boardGrootte.height];
        // Vul het speelveld met vierkanten

        for(int x = 0; x < this.level.boardGrootte.width; x++){
            for(int y = 0; y < this.level.boardGrootte.height; y++){
                squares[x][y] = new Square(x,y);
            }
        }

        for (BoardObject object: this.level.objecten){
            squares[object.getPosition().x][object.getPosition().y].setBoardObject(object);
        }

        squares[speler.getPosition().x][speler.getPosition().y].setBoardObject(speler);

// Update het game paneel
        updateGamePanel();
    }
    // operatie beweegSpeler; verwacht een char voor de directie en een int voor hoeveel diegene zou moeten bewegen
    public void beweegSpeler(char direction, int howMuch){
// Stel het vorige vierkant vast
        Square vorigeSquare = squares[speler.getPosition().x][speler.getPosition().y];
        // Initializeer de volgende vierkant
        Square volgendeSquare = null;

        // Start de switch case voor het bepalen welke kant de speler wilt opbewegen
        switch (direction){

            case 'x':
                // Als de spelers positie lager dan 0 is en groter dan 9 dan gebeurt er niks
                if(speler.getPosition().x + howMuch < 0 || speler.getPosition().x + howMuch > this.level.boardGrootte.width -1){
                    return;
                }else{
                    // Anders dan wordt de volgendeSquare de plek waar de speler zich dan eindigt
                    volgendeSquare = squares[speler.getPosition().x + howMuch][speler.getPosition().y];

                }
                break;
            // Is dit het Y Coordinaat dan gebeurt dit
            case 'y':
// Als de spelers positie lager dan 0 is en groter dan 9 dan gebeurt er niks
                if(speler.getPosition().y + howMuch < 0 || vorigeSquare.getPosition().y + howMuch > this.level.boardGrootte.height -1){
                   return;
                }else {
// Anders dan wordt de volgendeSquare de plek waar de speler zich dan eindigt
                    volgendeSquare = squares[speler.getPosition().x][speler.getPosition().y + howMuch];
                }
                break;
            // Als de volgendeSquare een object heeft dan gaat hij hierin de switch case behandelen
        }

        if(volgendeSquare.hasBoardObject()){

            volgendeSquare.getBoardObject().checkCollision(speler, vorigeSquare, volgendeSquare, this);
            }
        else{

            speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
            // Maak de vorige square null
            vorigeSquare.setBoardObject(null);
// Zet de speler op de volgende square
            volgendeSquare.setBoardObject(speler);
        }
        updateInfoPanel();
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

