import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * This class represents the Controller part in the MVC pattern.
 */

public class VehicleController extends JComponent {
    private static final int X = 1000;
    private static final int Y = 800;

    private VehicleModel model;

    // --------------------------------------- SHOULD BE IN VEHICLECONTROLLER
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Raise Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton turnLeftButton = new JButton("Turn Left");
    JButton turnRightButton = new JButton("Turn Right");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    // -----------------------------------------

    public VehicleController(VehicleModel m) {
        model = m;
        initComponents();
    }

    private void initComponents() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        this.setLayout(new GridLayout(2,5));
        this.setPreferredSize(new Dimension(X+4, 200));
        
        this.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        //startButton.setPreferredSize(new Dimension(X/5-15,200));

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        //stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(gasLabel, 0);
        this.add(gasSpinner, 1);
        this.add(turboOnButton, 2);
        this.add(turboOffButton, 3);
        this.add(startButton, 4);
        this.add(gasButton, 5);
        this.add(brakeButton, 6);
        this.add(liftBedButton, 7);
        this.add(lowerBedButton, 8);
        this.add(stopButton, 9);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });
    }

    private void gas(int amount) {
        model.gas(amount);
    }

    private void brake(int amount) {
        model.brake(amount);
    }

}
