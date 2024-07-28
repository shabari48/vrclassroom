public class YouTubeNotificationSystem {
    public static void main(String[] args) {
        // Create a YouTube channel
        YouTubeChannel techChannel = new YouTubeChannel("Tech Insights");

        // Create subscribers
        Subscriber subscriber1 = new Subscriber("Alice");
        Subscriber subscriber2 = new Subscriber("Bob");
        Subscriber subscriber3 = new Subscriber("Charlie");

        // Register subscribers to the channel
        techChannel.registerObserver(subscriber1);
        techChannel.registerObserver(subscriber2);
        techChannel.registerObserver(subscriber3);

        // Upload a new video
        techChannel.uploadVideo("Understanding the Observer Pattern");

        // Unregister a subscriber
        techChannel.removeObserver(subscriber2);

        // Upload another video
        techChannel.uploadVideo("Advanced Java Programming Tips");
    }
}
