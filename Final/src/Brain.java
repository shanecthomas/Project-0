public class Brain
{
    Terrain[][] map = new Terrain[50][10];
    Terrain pLocation = new Terrain();
    Terrain testLocation = new Terrain();
    Terrain compareLocation = new Terrain();
    Player player1 = new Player();
    Player testPlayer = new Player();
    Player comparePlayer = new Player();
    boolean alive = true;
    int row, col, testRow, testCol, route, loop;
    double testTotal, compareTotal;

    public Brain() {}
    public Brain (Terrain t, Terrain[][] m, Player p) throws NullPointerException
    {
        pLocation = t;
        map = m;
        player1 = p;
    }

    public void setPLocation(Terrain m) throws NullPointerException
    {pLocation = m;}
    public void setMap(Terrain[][] m) throws NullPointerException
    {map = m;}
    public void setPlayer1(Player p) throws NullPointerException
    {player1 = p;}

    public Terrain getPLocation() {return pLocation;}
    public Terrain[][] getMap() {return map;}
    public Player getPlayer1() {return player1;}
}