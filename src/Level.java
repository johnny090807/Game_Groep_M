import java.awt.*;
import java.util.ArrayList;

public class Level {


    public int levelNumber;

    public ArrayList<Sleutel> sleutels = new ArrayList<>();
    public ArrayList<Muur> muren = new ArrayList<>();
    public ArrayList<Barricade> barricades = new ArrayList<>();

    public BoardObject beginZone;

    public Dimension boardGrootte;

    public Einde eindZone;

    public Level(int levelNumber){
        this.levelNumber = levelNumber;
        this.boardGrootte = new Dimension(10, 10);
        switch (levelNumber){
            case 1:
                this.eindZone = new Einde(9,9);
                this.sleutels.add(new Sleutel(0,2, 100));
//                this.sleutels.add(new Sleutel(0,3, 200));
//                this.sleutels.add(new Sleutel(0,4, 300));
//
                this.muren.add(new Muur(0,1));
                this.muren.add(new Muur(1,1));
                this.muren.add(new Muur(2,1));
                this.muren.add(new Muur(3,1));
                this.muren.add(new Muur(4,1));
                this.muren.add(new Muur(5,1));
                this.muren.add(new Muur(6,1));
                this.muren.add(new Muur(7,1));

                this.barricades.add(new Barricade(4,4,100));
        }
    }

}
