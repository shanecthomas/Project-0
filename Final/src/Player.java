public class Player
{
    private double foodSupply, waterSupply, staminaSupply;


    public Player()
    {
        foodSupply = 20.0;
        waterSupply = 20.0;
        staminaSupply = 20.0;
    }

    public void setFoodSupply(double food) throws NullPointerException
    {foodSupply = food;}
    public void setWaterSupply(double water) throws NullPointerException
    {waterSupply = water;}
    public void setStaminaSupply(double stamina) throws NullPointerException
    {staminaSupply = stamina;}

    public double getFoodSupply() {return foodSupply;}
    public double getWaterSupply() {return waterSupply;}
    public double getStaminaSupply() {return staminaSupply;}

    public double foodFactor() {return 1.0;}
    public double waterFactor() {return 1.0;}
    public double staminaFactor() {return 1.0;}

    public boolean enter(Terrain square)
    {
        double food = square.foodCost();
        if (food > 0.0)
        {
            food *= foodFactor();
        }
        foodSupply -= food;
        if (foodSupply > 20.0)
        {
            foodSupply = 20.0;
        }
        if (foodSupply < 0.0) {
            return false; // The player has 'died'
        }

        double water = square.waterCost();
        if (water > 0.0)
        {
            water *= waterFactor();
        }
        waterSupply -= water;
        if (waterSupply > 15.0)
        {
            waterSupply = 15.0;
        }
        if (waterSupply < 0.0) {
            return false; // The player has 'died'
        }

        double stamina = square.staminaCost();
        if (stamina > 0.0)
        {
            stamina *= staminaFactor();
        }
        staminaSupply -= stamina;
        if (staminaSupply > 10.0)
        {
            staminaSupply = 10.0;
        }
        if (staminaSupply < 0.0) {
            return false; // The player has 'died'
        }

        return true;
    }
}
