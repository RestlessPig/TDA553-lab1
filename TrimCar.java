import java.awt.Color;
/**
 * TrimCar
 */
public class TrimCar extends Car {

    private double trimFactor; //can be hypothetically changed in car repair shop

    TrimCar(int nrDoors, Color color, int enginePower, String modelName, double trimFactor) {
        super(nrDoors, color, enginePower, modelName);
        this.trimFactor = trimFactor;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}