import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ObjectPlus implements Serializable {
    private static Map<Class, List<ObjectPlus>> allExtents = new Hashtable<>();

    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            // Extent of this class already exists
            extent = allExtents.get(theClass);
        } else {
            // Extent of this class doesn't exist
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }


    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
        if (allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(
                String.format("%s. Stored extents: %s",
                        type.toString(), allExtents.keySet()));
    }

    //Metoda klasowa
    public static void showExtent(Class theClass) throws Exception {
        List<ObjectPlus> extent = null;

        if (allExtents.containsKey(theClass)) {
            //Extent of this class already exist
            extent = allExtents.get(theClass);
        } else {
            throw new Exception("Unknown class" + theClass);
        }

        System.out.println("Extent of the class " + theClass + ":");
        if (extent.isEmpty()) {
            System.out.println("No extents!");
        }
        for (Object obj : extent) {
            System.out.println(obj);
        }
    }

    public static void removeExtent (Class theClass, ObjectPlusPlus objectPlusPlus, String roleName) throws Exception {
        if (roleName == "part" || roleName == "whole") {
            if (objectPlusPlus.getLinks("part").length > 0) {
                throw new Exception("Calosc ma powiazane czesci, uzyj metody removeExtentWithParts");
            }
        }
        if (allExtents.get(theClass).contains(objectPlusPlus)) {
            allExtents.get(theClass).remove(objectPlusPlus);
        } else throw new Exception ("Such object doesn't exists");
    }

    public static void removeExtentWithParts (Class theClass, Class partClass, ObjectPlusPlus objectPlusPlus) throws Exception {
        if (objectPlusPlus.getLinks("part").length > 0) {
            for (ObjectPlusPlus o : objectPlusPlus.getLinks("part")) {
                objectPlusPlus.removePart(o);
                allExtents.get(partClass).remove(o);
            }
        }
        if (allExtents.get(theClass).contains(objectPlusPlus)) {
            allExtents.get(theClass).remove(objectPlusPlus);
        } else throw new Exception ("Such object doesn't exists");
    }
}