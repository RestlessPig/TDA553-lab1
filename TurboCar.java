import java.awt.Color;

/**
 * TurboCar
 */
public abstract class TurboCar extends Car {

    private boolean turboOn;
    private double turboStrength;       //can be hypothetically changed in car repair shop

    TurboCar(int nrDoors, Color color, int enginePower, String modelName, double turboStrength) {
        super(nrDoors, color, enginePower, modelName);
        this.turboStrength = turboStrength;
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = turboStrength;
        return getEnginePower() * 0.01 * turbo;
    }

}