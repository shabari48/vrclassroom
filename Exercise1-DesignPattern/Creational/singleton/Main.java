public class Main {
    public static void main(String[] args) {
        Cache cache = Cache.getInstance();

        // Add data to the cache
        cache.put("username", "john_doe");
        cache.put("user_id", 12345);

        // Retrieve data from the cache
        System.out.println("Username: " + cache.get("username"));
        System.out.println("User ID: " + cache.get("user_id"));

        // Clear the cache
        cache.clear();

        // Verify the cache is empty
        System.out.println("Username after clear: " + cache.get("username"));
    }
}
