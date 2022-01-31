public class ComplexBrain extends Brain
{
    public ComplexBrain(Terrain[][] m, Player p) throws NullPointerException
    {
        map = m;
        player1 = p;
        row = 0;
        col = 5;

        do
        {
            if (row == 49)
                break;
            testRow = row;
            testCol = col;
            testRow++;
            testLocation = map[testRow][testCol];
            route = 1; //East
            testRow = row;
            testCol++;
            if (testCol < 10) //Test North
            {
                compareLocation = map[testRow][testCol];
                comparePlayer = player1;
                if (comparePlayer.enter(compareLocation))
                {
                    testPlayer = player1;
                    if (testPlayer.enter(testLocation))
                    {
                        testTotal = testPlayer.getFoodSupply() + testPlayer.getWaterSupply() + testPlayer.getStaminaSupply();
                        compareTotal = comparePlayer.getFoodSupply() + comparePlayer.getStaminaSupply() + comparePlayer.getWaterSupply();
                        if (testTotal < compareTotal)
                            route = 2; //North
                    }
                    else
                        route = 2; //North
                }
            }
            testCol -= 2;
            if (testCol > -1) //Test South
            {
                compareLocation = map[testRow][testCol];
                comparePlayer = player1;
                if (comparePlayer.enter(compareLocation))
                {
                    testPlayer = player1;
                    if (testPlayer.enter(testLocation))
                    {
                        testTotal = testPlayer.getFoodSupply() + testPlayer.getWaterSupply() + testPlayer.getStaminaSupply();
                        compareTotal = comparePlayer.getFoodSupply() + comparePlayer.getStaminaSupply() + comparePlayer.getWaterSupply();
                        if (testTotal < compareTotal)
                            route = 3; //South
                    }
                    else
                        route = 3; //South
                }
            }

            if (loop > 8) //Fixes North/South loop
                route = 1;
            if (route == 1) //East
            {
                row++;
                loop = 0;
            }
            if (route == 2) // North
            {
                col++;
                loop++;
            }
            if (route == 3) //South
            {
                col--;
                loop++;
            }
            pLocation = map[row][col];
            alive = player1.enter(pLocation);
            if (!alive)
                break;
        } while (true);

        if (row == 49)
            System.out.println("You won!");
        else
            System.out.println("You died @ Row: " + row + ", Col: " + col);
    }
}
