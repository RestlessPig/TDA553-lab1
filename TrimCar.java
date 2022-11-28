import java.awt.Color;

/**
 * TrimCar
 */
public class TrimCar extends Vehicle {

    private final double trimFactor;

    public TrimCar(int nrDoors, Color color, double enginePower, String modelName, double trimFactor) {
        super(nrDoors, color, enginePower, modelName);
        this.trimFactor = trimFactor;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}