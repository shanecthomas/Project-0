public class GeniusBrain extends Brain
{
    public GeniusBrain(Terrain[][] m, Player p) throws NullPointerException
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
            if (testCol < 9) //Test NE / EN
            {
                testCol++; //NE
                compareLocation = map[testRow][testCol];
                comparePlayer = player1;
                if (comparePlayer.enter(compareLocation))
                {
                    testRow++;
                    compareLocation = map[testRow][testCol];
                    if (comparePlayer.enter(compareLocation))
                    {
                        testPlayer = player1;
                        if (testPlayer.enter(testLocation))
                        {
                            testTotal = testPlayer.getFoodSupply() + testPlayer.getWaterSupply() + testPlayer.getStaminaSupply();
                            compareTotal = comparePlayer.getFoodSupply() + comparePlayer.getStaminaSupply() + comparePlayer.getWaterSupply();
                            if (testTotal < compareTotal)
                                route = 2; //North East
                        }
                        else
                            route = 2; //North East
                    }
                }
                testCol = col;
                testRow = row;
                testRow++; //EN
                compareLocation = map[testRow][testCol];
                comparePlayer = player1;
                if (comparePlayer.enter(compareLocation))
                {
                    testCol++;
                    compareLocation = map[testRow][testCol];
                    if (comparePlayer.enter(compareLocation))
                    {
                        testPlayer = player1;
                        if (testPlayer.enter(testLocation))
                        {
                            testTotal = testPlayer.getFoodSupply() + testPlayer.getWaterSupply() + testPlayer.getStaminaSupply();
                            compareTotal = comparePlayer.getFoodSupply() + comparePlayer.getStaminaSupply() + comparePlayer.getWaterSupply();
                            if (testTotal < compareTotal)
                                route = 3; //East North
                        }
                        else
                            route = 3; //East North
                    }
                }
            }
            testRow = row;
            testCol = col;
            if (testCol > 0) //Test SE / ES
            {
                testCol--; //SE
                compareLocation = map[testRow][testCol];
                comparePlayer = player1;
                if (comparePlayer.enter(compareLocation))
                {
                    testRow++;
                    compareLocation = map[testRow][testCol];
                    if (comparePlayer.enter(compareLocation))
                    {
                        testPlayer = player1;
                        if (testPlayer.enter(testLocation))
                        {
                            testTotal = testPlayer.getFoodSupply() + testPlayer.getWaterSupply() + testPlayer.getStaminaSupply();
                            compareTotal = comparePlayer.getFoodSupply() + comparePlayer.getStaminaSupply() + comparePlayer.getWaterSupply();
                            if (testTotal < compareTotal)
                                route = 4; //South East
                        }
                        else
                            route = 4; //South East
                    }
                }
                testCol = col;
                testRow = row;
                testRow++; //ES
                compareLocation = map[testRow][testCol];
                comparePlayer = player1;
                if (comparePlayer.enter(compareLocation))
                {
                    testCol--;
                    compareLocation = map[testRow][testCol];
                    if (comparePlayer.enter(compareLocation))
                    {
                        testPlayer = player1;
                        if (testPlayer.enter(testLocation))
                        {
                            testTotal = testPlayer.getFoodSupply() + testPlayer.getWaterSupply() + testPlayer.getStaminaSupply();
                            compareTotal = comparePlayer.getFoodSupply() + comparePlayer.getStaminaSupply() + comparePlayer.getWaterSupply();
                            if (testTotal < compareTotal)
                                route = 5; //East South
                        }
                        else
                            route = 5; //East South
                    }
                }
            }

            if (route == 1) //East
                row++;
            if (route == 2) // North East
            {
                col++;
                pLocation = map[row][col];
                player1.enter(pLocation);
                row++;
            }
            if (route == 3) // East North
            {
                row++;
                pLocation = map[row][col];
                player1.enter(pLocation);
                col++;
            }
            if (route == 4) // South East
            {
                col--;
                pLocation = map[row][col];
                player1.enter(pLocation);
                row++;
            }
            if (route == 5) // East South
            {
                row++;
                pLocation = map[row][col];
                player1.enter(pLocation);
                col--;
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
