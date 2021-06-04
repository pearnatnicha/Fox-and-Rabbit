package io.muic.ooc.fab;

public class Rabbit extends Animal {

    @Override
    protected Location moveToNewLocation() { return field.freeAdjacentLocation(getLocation()); }

    /**
     * This is what the rabbit does most of the time - it runs around. Sometimes
     * it will breed or die of old age.
     *
     * @param animals A list to return newly born rabbits.
     */


    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }

    @Override
    protected int getFoodValue(){ return 9; }


}
