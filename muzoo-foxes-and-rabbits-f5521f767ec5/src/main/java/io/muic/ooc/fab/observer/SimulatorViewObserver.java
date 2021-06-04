package io.muic.ooc.fab.observer;
import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.view.SimulatorView;

public class SimulatorViewObserver extends Observer {
    SimulatorView view;
    public SimulatorViewObserver(SimulatorView simulatorView){
        view = simulatorView;
    }

    @Override
    public void update(int step, Field field) {
        view.showStatus(step,field);

    }
}
