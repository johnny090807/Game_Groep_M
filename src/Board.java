import javax.swing.*;
import java.awt.*;
/*
    Klasse Board;
    Het overerft de klasse JPanel
 */
public class Board extends JPanel {

    // Variabele van het level
    private Level level;

    // Variabele voor de speler
    private BoardObject speler = new Speler(0,0);

    // Alle Panelen
    private JPanel
            gamePanel,
            infoPanel = new JPanel(new GridLayout(1,3)),
            homePanel = new JPanel();

    // Alle Labels
    private JLabel
            resetLabel = new JLabel("Reset by pressing (R).", JLabel.CENTER),
            quitLabel = new JLabel("Press (ESC) to quit.", JLabel.CENTER),
            infoLabel = new JLabel("Probeer tot het groene vlak te komen", JLabel.CENTER);

    // Alle rechthoeken die het spel maken
    private Square[][] squares;

    // Constructor voor het board
    public Board(){
        // Zet de layout van het overgeerfte paneel in een BorderLayout
        super.setLayout(new BorderLayout());

        // Zet de grootte vast van het home paneel
        this.homePanel.setPreferredSize(new Dimension(500, 55));

        // Start het level met de daarop aangewezen level
        startLevel(1);
    }

    // operatie startLevel; verwacht een nummer voor welk level die moet starten
    public void startLevel(int numberLevel){
        // Update het home paneel
        this.updateHomePanel();

        // Update het info paneel
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

        // Stel de array vast op de grootte en breedte van het speelveld
        squares = new Square[this.level.boardGrootte.width][this.level.boardGrootte.height];

        // Vul het speelveld met vierkanten
        for(int x = 0; x < this.level.boardGrootte.width; x++){
            for(int y = 0; y < this.level.boardGrootte.height; y++){
                squares[x][y] = new Square(x,y);
            }
        }

        for (BoardObject object: this.level.objecten){
            switch (object.getType()){
                case "MUUR":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(new Muur(object.getPosition().x, object.getPosition().y));
                    break;
                case "BARRICADE":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(new Barricade(object.getPosition().x, object.getPosition().y, object.getValue()));
                    break;
                case "SLEUTEL":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(new Sleutel(object.getPosition().x, object.getPosition().y, object.getValue()));
                    break;
                case "EINDE":
                    squares[object.getPosition().x][object.getPosition().y].setBoardObject(new Einde(object.getPosition().x, object.getPosition().y));
                    break;

            }
        squares[speler.getPosition().x][speler.getPosition().y].setBoardObject(speler);

        // Update het game paneel
        updateGamePanel();
    }
    }

    // operatie beweegSpeler; verwacht een char voor de directie en een int voor hoeveel diegene zou moeten bewegen
    public void beweegSpeler(char direction, int howMuch){
        // Stel het vorige vierkant vast
        Square vorigeSquare = squares[speler.getPosition().x][speler.getPosition().y];

        // Initializeer de volgende vierkant
        Square volgendeSquare = null;

        // Start de switch case voor het bepalen welke kant de speler wilt opbewegen
        switch (direction){
            // Is dit het X Coordinaat dan gebeurt dit
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
        }
        // Als de volgendeSquare een object heeft dan gaat hij hierin de switch case behandelen
        if(volgendeSquare.hasBoardObject()){
            // Behandel de switch case met de types van de bord objecten
            switch (volgendeSquare.getBoardObject().getType()){
                // Als het een barricade is dat doet het dit
                case "BARRICADE":
                    //  Zet de barricade vast die op de volgende square staat
                    Barricade volgendeSquareBarricade = (Barricade) volgendeSquare.getBoardObject();
                    // Als de speler een sleutel heeft en met dezelfde waar als de volgende square barricade dan gebeurt er dit
                    if (speler.getSleutel() != null && speler.getSleutel().getValue() == volgendeSquareBarricade.unlockValue) {
                        // Verander de positie van de speler voor de volgende square
                        speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
                        // Maak de vorige square null
                        vorigeSquare.setBoardObject(null);
                        // Zet de speler op de volgende square
                        volgendeSquare.setBoardObject(speler);
                        // Mocht de speler een sleutel hebben maar niet met dezelfde waarde dan gebeurt er dit
                    } else if (speler.getSleutel() != null && speler.getSleutel().getValue() != volgendeSquareBarricade.unlockValue){
                        // Zet de text van de infoLabel
                        this.infoLabel.setText("Hier heb je sleutel " +  volgendeSquareBarricade.unlockValue + " voor nodig.");
                        // Update de info paneel
                        updateInfoPanel();
                    }else if(speler.getSleutel() == null){
                        // Zet de text van de infoLabel
                        this.infoLabel.setText("Je hebt geen sleutel!");
                        // Update de info paneel
                        updateInfoPanel();
                    }else{
                        // Zet de text van de infoLabel
                        this.infoLabel.setText("Er is iets fout gegaan!");
                        // Update de info paneel
                        updateInfoPanel();
                    }
                    break;
                // Als het een sleutel is dat doet het dit
                case "SLEUTEL":
                    speler.setSleutel(volgendeSquare.getBoardObject());
                    // Zet de sleutel vast in de speler
                    speler.setSleutel((Sleutel) volgendeSquare.getBoardObject());
                    // Verander de positie van de speler voor de volgende square
                    speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
                    // Zet de speler op de volgende square
                    volgendeSquare.setBoardObject(speler);
                    // Maak de vorige square null
                    vorigeSquare.setBoardObject(null);
                    break;
                // Als het een eindzone is dat doet het dit
                case "EINDE":
                    // Start het volgende level
                    nextLevel();
                    break;
                // Als het een muur is dat doet het niks
                case "MUUR":
                    break;
            }

        }else{
            // Anders verander de positie van de speler voor de volgende square
            speler.setPosition(volgendeSquare.getPosition().x,volgendeSquare.getPosition().y);
            // Maak de vorige square null
            vorigeSquare.setBoardObject(null);
            // Zet de speler op de volgende square
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

        this.homePanel.add(this.resetLabel);
        this.homePanel.add(this.quitLabel);

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

