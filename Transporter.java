import java.awt.Color;

/**
 * Transporter
 */
public class Transporter extends Vehicle{
    
    private boolean rampUp;
    private LoadableVehicle[] flatbed;

    public Transporter() {
        super(2, Color.black, 500001, "jasonStathamWhoIsTheMainLeadInMovieTransporter");
        this.rampUp = false;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        incrementSpeedIfSafe(amount);
        
    }

    private void incrementSpeedIfSafe(double amount) {
        if (rampUp == false) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        } else {
            throw new Error("Ramp is up, can't do the brumbrum"); // <<<Vem kan detta vara??????
        }
    }

        
    }

    
