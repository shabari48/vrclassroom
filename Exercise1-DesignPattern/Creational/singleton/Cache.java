import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Cache instance;
    private Map<String, Object> cacheMap;

    // Private constructor to prevent instantiation
    private Cache() {
        cacheMap = new HashMap<>();
    }

    // Public method to provide access to the instance
    public static synchronized Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

    // Method to add data to the cache
    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    // Method to retrieve data from the cache
    public Object get(String key) {
        return cacheMap.get(key);
    }

    // Method to clear the cache
    public void clear() {
        cacheMap.clear();
    }
}
