import java.awt.Color;
/**
 * Truck
 */
public class Truck extends Vehicle {

    private boolean rampInStandardPosition;

    Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.rampInStandardPosition = true;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
    
    @Override
    public void gas(double amount) {
        if (this.rampInStandardPosition) {
            super.gas(amount);
        } else {
            throw new Error("Ramp is not in standard position, can't increase speed");
        }
    }

    protected void setRampForUse() {
        rampInStandardPosition = false;
    }

    protected void setRampStandardPosition() {
        rampInStandardPosition = true;
    }

    public boolean getRampStandardPositionStatus() {
        return rampInStandardPosition;
    }
}