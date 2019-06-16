import java.awt.*;
import java.util.ArrayList;

public class Level {


    public int levelNumber;

    public ArrayList<BoardObject> objecten = new ArrayList<>();

    public Point beginZone;

    public Dimension boardGrootte;

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
        this.boardGrootte = new Dimension(10, 10);
        switch (levelNumber) {
            case 1:
                this.beginZone = new Point(0, 0);
                this.objecten.add(new Einde(9, 9));

                this.objecten.add(new Sleutel(1, 4, 100));
                this.objecten.add(new Sleutel(1, 5, 300));
                this.objecten.add(new Sleutel(8, 0, 200));
                this.objecten.add(new Sleutel(2, 9, 100));

                this.objecten.add(new Muur(0, 1));
                this.objecten.add(new Muur(3, 1));
                this.objecten.add(new Muur(4, 1));
                this.objecten.add(new Muur(6, 1));
                this.objecten.add(new Muur(7, 1));
                this.objecten.add(new Muur(8, 1));
                this.objecten.add(new Muur(9, 1));
                this.objecten.add(new Muur(4, 4));
                this.objecten.add(new Muur(4, 5));
                this.objecten.add(new Muur(4, 6));
                this.objecten.add(new Muur(5, 6));
                this.objecten.add(new Muur(6, 6));
                this.objecten.add(new Muur(6, 3));
                this.objecten.add(new Muur(6, 4));
                this.objecten.add(new Muur(6, 7));
                this.objecten.add(new Muur(8, 7));
                this.objecten.add(new Muur(9, 7));

                this.objecten.add(new Barricade(0, 2, 100));
                this.objecten.add(new Barricade(0, 7, 30));
                this.objecten.add(new Barricade(0, 8, 70));
                this.objecten.add(new Barricade(0, 9, 90));
                this.objecten.add(new Barricade(1, 7, 90));
                this.objecten.add(new Barricade(1, 8, 40));
                this.objecten.add(new Barricade(1, 9, 90));
                this.objecten.add(new Barricade(2, 7, 300));
                this.objecten.add(new Barricade(2, 8, 300));
                this.objecten.add(new Barricade(3, 7, 190));
                this.objecten.add(new Barricade(3, 8, 80));
                this.objecten.add(new Barricade(3, 9, 90));
                this.objecten.add(new Barricade(4, 7, 220));
                this.objecten.add(new Barricade(4, 8, 100));
                this.objecten.add(new Barricade(4, 9, 50));
                this.objecten.add(new Barricade(5, 7, 100));
                this.objecten.add(new Barricade(5, 8, 360));

                this.objecten.add(new Barricade(2, 2, 100));
                this.objecten.add(new Barricade(3, 2, 100));
                this.objecten.add(new Barricade(4, 2, 100));
                this.objecten.add(new Barricade(5, 2, 100));
                this.objecten.add(new Barricade(6, 2, 100));
                this.objecten.add(new Barricade(7, 2, 100));
                this.objecten.add(new Barricade(7, 5, 100));
                this.objecten.add(new Barricade(8, 2, 100));
                this.objecten.add(new Barricade(9, 2, 100));
                this.objecten.add(new Barricade(6, 1, 200));
                this.objecten.add(new Barricade(4, 3, 100));
                this.objecten.add(new Barricade(7, 3, 900));
                this.objecten.add(new Barricade(7, 4, 500));
                this.objecten.add(new Barricade(7, 5, 100));
                this.objecten.add(new Barricade(8, 3, 50));
                this.objecten.add(new Barricade(9, 3, 150));
                this.objecten.add(new Barricade(7, 4, 500));
                this.objecten.add(new Barricade(7, 5, 100));
                this.objecten.add(new Barricade(6, 5, 300));
                break;
            case 2:
                this.beginZone = new Point(0, 0);
                this.objecten.add(new Einde(9, 9));
                this.objecten.add(new Sleutel(0, 9, 100));
                this.objecten.add(new Sleutel(4, 0, 200));
                this.objecten.add(new Sleutel(4, 9, 300));


                this.objecten.add(new Muur(1, 0));
                this.objecten.add(new Muur(2, 0));
                this.objecten.add(new Muur(3, 0));
                this.objecten.add(new Muur(1, 1));
                this.objecten.add(new Muur(2, 1));
                this.objecten.add(new Muur(3, 1));
                this.objecten.add(new Muur(1, 2));
                this.objecten.add(new Muur(2, 2));
                this.objecten.add(new Muur(3, 2));
                this.objecten.add(new Muur(1, 3));
                this.objecten.add(new Muur(2, 3));
                this.objecten.add(new Muur(3, 3));
                this.objecten.add(new Muur(1, 4));
                this.objecten.add(new Muur(2, 4));
                this.objecten.add(new Muur(3, 4));

                this.objecten.add(new Muur(2, 8));
                this.objecten.add(new Muur(3, 9));
                this.objecten.add(new Muur(3, 7));
                this.objecten.add(new Muur(3, 8));
                this.objecten.add(new Muur(5, 0));
                this.objecten.add(new Muur(5, 1));
                this.objecten.add(new Muur(5, 2));
                this.objecten.add(new Muur(5, 3));
                this.objecten.add(new Muur(7, 0));
                this.objecten.add(new Muur(7, 1));
                this.objecten.add(new Muur(7, 2));
                this.objecten.add(new Muur(7, 5));
                this.objecten.add(new Muur(7, 6));
                this.objecten.add(new Muur(7, 7));
                this.objecten.add(new Muur(7, 8));
                this.objecten.add(new Muur(7, 9));
                this.objecten.add(new Muur(6, 5));
                this.objecten.add(new Muur(6, 6));
                this.objecten.add(new Muur(6, 7));
                this.objecten.add(new Muur(6, 8));
                this.objecten.add(new Muur(5, 5));
                this.objecten.add(new Muur(5, 6));
                this.objecten.add(new Muur(5, 7));
                this.objecten.add(new Muur(5, 8));
                this.objecten.add(new Muur(1, 8));
                this.objecten.add(new Muur(5, 9));
                this.objecten.add(new Muur(5, 9));
                this.objecten.add(new Muur(6, 9));


                this.objecten.add(new Barricade(4, 2, 100));
                this.objecten.add(new Barricade(5, 4, 200));
                this.objecten.add(new Barricade(7, 3, 300));

                break;

            case 3:




        }


    }
}
