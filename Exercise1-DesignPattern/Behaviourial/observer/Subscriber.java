class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println("Hello " + name + ", " + channelName + " has uploaded a new video: " + videoTitle);
    }
}
