package io.muic.ooc.fab;

import java.awt.*;

public enum ActorType {
    RABBIT(0.08, Rabbit.class, Color.ORANGE),
    FOX(0.02, Fox.class, Color.BLUE),
    TIGER(0.02, Tiger.class, Color.RED),
    HUNTER(0.01, Hunter.class, Color.DARK_GRAY);

    private double Creationprobability;

    private Class actorClass;

    private Color color;

    ActorType(double Creationprobability, Class actorClass, Color color) {
        this.Creationprobability = Creationprobability;
        this.actorClass = actorClass;
        this.color = color;
    }

    public double getCreationprobability() {
        return Creationprobability;

    }

    public Class getActorClass(){
        return actorClass;
    }

    public Color getColor() {
        return color;
    }
}
