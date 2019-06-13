import java.awt.*;
import java.util.ArrayList;

public class Level {


    public int levelNumber;

    public ArrayList<Sleutel> sleutels = new ArrayList<>();
    public ArrayList<Muur> muren = new ArrayList<>();
    public ArrayList<Barricade> barricades = new ArrayList<>();

    public Point beginZone;

    public Dimension boardGrootte;

    public Einde eindZone;

    public Level(int levelNumber){
        this.levelNumber = levelNumber;
        this.boardGrootte = new Dimension(10, 10);
        switch (levelNumber){
            case 1:
                this.beginZone = new Point(0,0);
                this.eindZone = new Einde(9,9);

                this.sleutels.add(new Sleutel(0,2, 100));
                this.sleutels.add(new Sleutel(0,3, 200));
                this.sleutels.add(new Sleutel(0,4, 300));
                this.sleutels.add(new Sleutel(0,5, 400));
                this.sleutels.add(new Sleutel(0,6, 500));
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
                this.barricades.add(new Barricade(4,5,200));
                this.barricades.add(new Barricade(4,6,300));
                this.barricades.add(new Barricade(4,7,400));
                this.barricades.add(new Barricade(4,8,500));
                break;
            case 2:
                this.beginZone = new Point(0,0);
                this.eindZone = new Einde(9,9);
                this.sleutels.add(new Sleutel(0,2, 100));
                this.sleutels.add(new Sleutel(0,3, 200));
                this.sleutels.add(new Sleutel(0,4, 300));
                this.sleutels.add(new Sleutel(0,5, 400));
                this.sleutels.add(new Sleutel(0,5, 500));
//
                this.muren.add(new Muur(1,2));
                this.muren.add(new Muur(2,2));
                this.muren.add(new Muur(3,2));
                this.muren.add(new Muur(4,2));
                this.muren.add(new Muur(5,2));
                this.muren.add(new Muur(6,2));
                this.muren.add(new Muur(7,2));

                this.barricades.add(new Barricade(4,4,100));
                this.barricades.add(new Barricade(4,5,200));
                this.barricades.add(new Barricade(4,6,300));
                this.barricades.add(new Barricade(4,7,400));
                break;

        }
    }

}
