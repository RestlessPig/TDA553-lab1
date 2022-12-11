import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import vehicleModel.DrawableVehicle;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private ArrayList<DrawableVehicle> drawableVehicles;
    
    public void updateVehicles(ArrayList<DrawableVehicle> vehicles) {
        this.drawableVehicles = vehicles;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (DrawableVehicle vehicle : drawableVehicles) {
            g.drawImage(vehicle.getImage(), (int)vehicle.getVehicle().getPosition()[0], (int)vehicle.getVehicle().getPosition()[1], null); // see javadoc for more info on the parameters   
        }
    }
}
