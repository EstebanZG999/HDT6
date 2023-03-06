import java.util.*;

public class MapFactory {

    public static Map MAPFactory(String eleccion){
            return switch (eleccion){
                case "hashmap" -> new HashMap<String, ArrayList<String>>();
                case "treemap" -> new TreeMap<String, ArrayList<String>>();
                case "linkedhashmap" -> new LinkedHashMap<String, ArrayList<String>>();
                default -> null;
            };
    }
}
