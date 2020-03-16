package viikko6.playlist.th;

public class Song {

    private Artist artist;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.artist;
    }
}
