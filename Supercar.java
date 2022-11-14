import java.awt.*;
import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Supercar
 */
public abstract class Supercar implements Movable {

    private int nrDoors;
    private Color color;
    private double enginePower;
    private String modelName;
    private double currentSpeed;
    private double x;
    private double y;
    List<Integer> directionWheel;

    public Supercar(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.directionWheel = new ArrayList<Integer>(4);
        directionWheel.add(1);
        directionWheel.add(0);
        directionWheel.add(-1);
        directionWheel.add(0);
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(double setSpeed) {
        if (0 <= setSpeed && setSpeed <= enginePower){
            System.out.println("yes");
            currentSpeed = setSpeed;
        }
        else {
            System.out.println("no");
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (0 <= amount && amount <= 1){
            System.out.println("yes");
            incrementSpeed(amount);
        }
        else {
            System.out.println("no");
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if (0 <= amount && amount <= 1){
            System.out.println("yes");
            decrementSpeed(amount);
        }
        else {
            System.out.println("no");
        }
    }

    @Override
    public void move() {
        x += directionWheel.get(1) * getCurrentSpeed();
        y += directionWheel.get(0) * getCurrentSpeed();
    }

    @Override
    public void turnLeft(){
        Collections.rotate(directionWheel, -1);
    }
    @Override
    public void turnRight(){
        Collections.rotate(directionWheel, 1);
    }

}