import java.util.Random;

public class Main //Shane Thomas
{
    public static void main(String[]args)
    {
        Random random = new Random();
        Terrain[][] map = new Terrain[50][10];
        Grass grass = new Grass();
        Sand sand = new Sand();
        Forest forest = new Forest();
        River river = new River();
        Cave cave = new Cave();


        for (int r = 0; r < 50; r++) //MAP CREATION
        {
            for (int c = 0; c < 10; c++)
            {
                int rand = random.nextInt(10);
                if (rand < 3)
                    map[r][c] = grass;
                if (rand > 2 && rand < 5)
                    map[r][c] = sand;
                if (rand > 4 && rand < 7)
                    map[r][c] = forest;
                if (rand > 6 && rand < 9)
                    map[r][c] = river;
                if (rand > 8)
                    map[r][c] = cave;
            }
        }

        Carnivore player1 = new Carnivore();
        SimpleBrain simpleBrain = new SimpleBrain(map, player1);

        Hiker player2 = new Hiker();
        ComplexBrain complexBrain = new ComplexBrain(map, player2);

        Student player3 = new Student();
        GeniusBrain geniusBrain = new GeniusBrain(map, player3);
    }
}
