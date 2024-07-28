class DigitalAudioFile {
    private String trackTitle;
    private String musicianName;
    private int lengthInSeconds;

    public DigitalAudioFile(String trackTitle, String musicianName, int lengthInSeconds) {
        this.trackTitle = trackTitle;
        this.musicianName = musicianName;
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getTrackTitle() { return trackTitle; }
    public String getMusicianName() { return musicianName; }
    public int getLengthInSeconds() { return lengthInSeconds; }
    public void playDigitalTrack() { System.out.println("Playing digital track: " + trackTitle); }
}