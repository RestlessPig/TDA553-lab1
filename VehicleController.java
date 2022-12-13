
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController implements Observer {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    //private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private VehicleView view;

    private VehicleModel model;

    //methods:

    public VehicleController(VehicleModel m, VehicleView v) {
        view = v;
        model = m;
        //timer.start();
    }

    /* 
    * If controller is responsible for the "update loop"
    * */
    //private class TimerListener implements ActionListener {
    //    public void actionPerformed(ActionEvent e) {
    //        model.moveVehicles();
    //        frame.updateVehicles();
    //        // repaint() calls the paintComponent method of the panel
    //        frame.drawPanel.repaint();
    //    }     
    //}

    @Override
    public void updateObserver() {
        this.gas(view.gasAmount);
    }

    void gas(int amount) {
        model.gas(amount);
    }
}
