import java.util.ArrayList;
import java.util.List;

class YouTubeChannel implements Subject {
    private List<Observer> observers;
    private String channelName;
    private String latestVideo;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
        this.observers = new ArrayList<>();
    }

    public void uploadVideo(String videoTitle) {
        this.latestVideo = videoTitle;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(channelName, latestVideo);
        }
    }
}
