import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import vehicleModel.DrawableVehicle;
import vehicleModel.Vehicle;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private ArrayList<DrawableVehicle> drawableVehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.drawableVehicles = new ArrayList<>();
    }

    public void updateVehicles(ArrayList<DrawableVehicle> vehicles) {
        this.drawableVehicles = vehicles;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (DrawableVehicle vehicle : drawableVehicles) {
            Vehicle internalVehicle = vehicle.getVehicle();
            double[] vehiclePos = internalVehicle.getPosition();
            g.drawImage(vehicle.getImage(), (int)vehiclePos[0], (int)vehiclePos[1], null); // see javadoc for more info on the parameters   
        }
    }
}
