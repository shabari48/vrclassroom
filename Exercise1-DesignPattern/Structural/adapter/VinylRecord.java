class VinylRecord {
    private String songName;
    private String performer;
    private int durationInMinutes;

    public VinylRecord(String songName, String performer, int durationInMinutes) {
        this.songName = songName;
        this.performer = performer;
        this.durationInMinutes = durationInMinutes;
    }

    public String getSongName() { return songName; }
    public String getPerformer() { return performer; }
    public int getDurationInMinutes() { return durationInMinutes; }
    public void spinVinyl() { System.out.println("Vinyl spinning: " + songName); }
}

// Adapter for Vinyl Records
class VinylAdapter implements StandardTrack {
    private VinylRecord vinylRecord;

    public VinylAdapter(VinylRecord vinylRecord) {
        this.vinylRecord = vinylRecord;
    }

    @Override
    public String getTitle() { return vinylRecord.getSongName(); }

    @Override
    public String getArtist() { return vinylRecord.getPerformer(); }

    @Override
    public int getDurationInSeconds() { return vinylRecord.getDurationInMinutes() * 60; }

    @Override
    public void play() { vinylRecord.spinVinyl(); }
}