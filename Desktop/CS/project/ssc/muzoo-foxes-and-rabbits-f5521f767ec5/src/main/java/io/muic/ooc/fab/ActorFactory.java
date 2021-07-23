package io.muic.ooc.fab;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ActorFactory {
    private static Map<ActorType, Class> actorClassMap = new HashMap<>(){{
        ActorType[] actorTypes = ActorType.values();
        for (int i = 0; i< actorTypes.length; i++){
            put(actorTypes[i], actorTypes[i].getActorClass());
        }
    }};

    public static Actor createAnimal(ActorType actorType, Field field, Location location) {
        Class actorClass = actorClassMap.get(actorType);
        return createAnimal(actorClass,field,location);
    }
    public static Actor createAnimal(Class animalClass, Field field, Location location) {
        if (animalClass != null){
            try {
                Actor actor = (Actor) animalClass.getDeclaredConstructor().newInstance();
                actor.initialize(true,field,location);
                return actor;
            }catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
                e.printStackTrace();
            }
        }

        throw new IllegalArgumentException("Unknown animalType");
    }
}
