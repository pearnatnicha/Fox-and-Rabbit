package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Actor {
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    // Random generator

    // The fox's food level, which is increased by eating rabbits.

    /**
     * Create a fox. A fox can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field     The field currently occupied.
     * @param location  The location within the field.
     */

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findAnimal();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }

    /**
     * This is what the fox does most of the time: it hunts for rabbits. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     * @param newActor A list to return newly born foxes.
     */
    @Override
    public void act(List<Actor> newActor) {
        if (isAlive()) {
            // Try to move into a free location.
            Location newLocation = moveToNewLocation();
            if (newLocation != null) {
                setLocation(newLocation);
            }
        }
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */


    /**
     * Look for rabbits adjacent to the current location. Only the first live
     * rabbit is eaten.
     *
     * @return Where food was found, or null if it wasn't.
     */


    public Location findAnimal() {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Animal) {
                Animal animals = (Animal) animal;
                if (animals.isAlive()) {
                    animals.setDead();
                    return where;
                }
            }
        }
        return null;
    }

}
