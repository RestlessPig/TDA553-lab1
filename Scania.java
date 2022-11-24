import java.awt.Color;

/**
 * Scania
 */
public class Scania extends Vehicle {

    private double platformAngle;

    public Scania() {
        super(2, Color.pink, 5000000, "Scania1337");
        this.platformAngle = 0;
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
        if (this.platformAngle == 0) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        } else {
            throw new Error("Platform is not lowered, can't do the brumbrum");
        }
    }

    public void changePlatformAngle(double angle) {
        changePlatformAngleIfStationary(angle);
    }

    private void changePlatformAngleIfStationary(double angle) {
        if (getCurrentSpeed() == 0) {
            if (angle <= 70 && angle >= 0) {
                setPlatformAngle(angle);
            } else {
                throw new Error("Platform angle outside safe operating range");
            }
        } else {
            throw new Error("Can't change platform angle while car is brumbrum'ing");
        }
    }

    private void setPlatformAngle(double angle){
        platformAngle = angle;
    }

}





/**
The angle of the platform can not be lower than 0 deg  or higher than 70 deg

If angle not 0 -> must be stationary 
 
if angle 0 -> cant move 

if truck is moving -> cant raise platform
 
The car transport ramp has only two positions, up or down.

The ramp can only be down if the car transport is stationary. If the ramp is down, the car transport must not move, and if the car transport is moving, the ramp must not be lowered.
  
Cars can only be loaded if the ramp is down, and they are reasonably close to the car transport (make your own assumption about what "reasonably close" means, the details are not important).

Cars can only be unloaded if the ramp is down. They should then end up reasonably close to the car transport.

Important things to keep in mind during this task:

Avoid code duplication for functionality that is common to several different classes, e.g. Scania and car transport.

Think about the need for polymorphism for different purposes, and how it affects future extensibility.
 
 
*/