package viikko6.playlist.th;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    // lista voidaan alustaa heti muuttujan määrittelyssä:
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        this.songs.add(song);
    }

    @Override
    public String toString() {
        // Kutsutaan jokaisen kappaleen toString-metodia erikseen
        // kerätään merkkijonot talteen yhdeksi "isoksi merkkijonoksi"
        String rivit = "";
        for (int i = 0; i < this.songs.size(); i++) {
            String rivi = (i + 1) + ": " + this.songs.get(i).toString();
            rivit += rivi + "\n";
        }
        return rivit;
    }
}
