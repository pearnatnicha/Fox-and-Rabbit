package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {

    private Map<ActorType, Double> probabilityMap = new HashMap<>(){{
        ActorType[] actorTypes = ActorType.values();
        for (int i = 0; i< actorTypes.length; i++){
            put(actorTypes[i], actorTypes[i].getCreationprobability());
        }
    }};

    private static final Random RANDOM = new Random();


    public void populate(Field field, List<Actor> animals) {

        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (Map.Entry<ActorType, Double> entry : probabilityMap.entrySet()) {
                    if (RANDOM.nextDouble() <= entry.getValue()) {
                        Location location = new Location(row, col);
                        Actor actor = ActorFactory.createAnimal(entry.getKey(), field, location);
                        animals.add(actor);
                    }
                }
                // else leave the location empty.
            }
        }
    }
}
