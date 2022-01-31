public class SimpleBrain extends Brain
{
    public SimpleBrain(Terrain[][] m, Player p) throws NullPointerException
    {
        map = m;
        player1 = p;
        col = 5;

        for (row = 1; row < 49; row++)
        {
            pLocation = map[row][col];
            alive = player1.enter(pLocation);
            if (!alive)
                break;
        }

        if (row == 49)
            System.out.println("You won!");
        else
            System.out.println("You died @ Row: " + row + ", Col: " + col);
    }
}