class MusicStreamingService {
    public static void main(String[] args) {
        // Create tracks from different sources
        VinylRecord vinylRecord = new VinylRecord("Bohemian Rhapsody", "Queen", 6);
        DigitalAudioFile digitalAudio = new DigitalAudioFile("Imagine", "John Lennon", 183);

        // Adapt them to our standard interface
        StandardTrack track1 = new VinylAdapter(vinylRecord);
        StandardTrack track2 = new DigitalAudioAdapter(digitalAudio);

        // Use them uniformly in our streaming service
        playTrack(track1);
        playTrack(track2);
    }

    public static void playTrack(StandardTrack track) {
        System.out.println("Now playing: " + track.getTitle() + " by " + track.getArtist() +
                           " (Duration: " + track.getDurationInSeconds() + " seconds)");
        track.play();
        System.out.println();
    }
}