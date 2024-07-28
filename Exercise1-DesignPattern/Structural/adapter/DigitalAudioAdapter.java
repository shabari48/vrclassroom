class DigitalAudioAdapter implements StandardTrack {
    private DigitalAudioFile digitalAudio;

    public DigitalAudioAdapter(DigitalAudioFile digitalAudio) {
        this.digitalAudio = digitalAudio;
    }

    @Override
    public String getTitle() { return digitalAudio.getTrackTitle(); }

    @Override
    public String getArtist() { return digitalAudio.getMusicianName(); }

    @Override
    public int getDurationInSeconds() { return digitalAudio.getLengthInSeconds(); }

    @Override
    public void play() { digitalAudio.playDigitalTrack(); }
}
