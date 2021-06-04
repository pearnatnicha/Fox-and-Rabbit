package io.muic.ooc.fab;

import java.util.List;

public abstract class Actor {
    private boolean alive = true;
    protected Location location;
    protected Field field;

    public void initialize(boolean randomAge, Field field, Location location){
        this.field = field;
        setLocation(location);
    }

    protected abstract Location moveToNewLocation();

    public abstract void act(List<Actor> newActor);

    public Location getLocation() {
        return location;
    }



    /**
     * Increase the age. This could result in the rabbit's death.
     */

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


}
