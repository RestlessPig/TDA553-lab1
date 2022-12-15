import java.util.ArrayList;
import vehicleModel.DrawableVehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VehicleModel {

    private final int delay = 10;
    private Timer timer = new Timer(delay, new TimerListener());

    private ArrayList<DrawableVehicle> drawableVehicles;
    
    private ArrayList<Observer> observers;

    public VehicleModel() {
        drawableVehicles = new ArrayList<>();
        observers = new ArrayList<>();
        timer.start();
    }

    public void addDrawableVehicle(DrawableVehicle dv) {
        drawableVehicles.add(dv);
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    protected void moveVehicles() {
        for (DrawableVehicle drawableVehicle : drawableVehicles) {
            drawableVehicle.getVehicle().move();
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            moveVehicles();
            for (Observer observer : observers) {
                observer.updateObserver();
            }
        }     
    }

    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (DrawableVehicle vehicle : drawableVehicles) 
        {
            vehicle.getVehicle().gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double)amount) / 100;
        for (DrawableVehicle vehicle : drawableVehicles) 
        {
            vehicle.getVehicle().brake(brake);;
        }
    }

    protected ArrayList<DrawableVehicle> getVehicles() {
        return drawableVehicles;
    }


}


