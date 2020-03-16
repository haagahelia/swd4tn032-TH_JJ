package viikko6.playlist.th;

public class PlaylistTest {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Artist artist = new Artist("Rick Astley");

        Song song = new Song();
        song.setTitle("Never Gonna Give You Up");
        song.setArtist(artist);

        playlist.addSong(song);

        System.out.println(playlist);

        System.out.println("---");

        Artist artist2 = new Artist("David Hasselhoff");

        Song song2 = new Song();
        song2.setTitle("Hooked on a Feeling");
        song2.setArtist(artist2);

        playlist.addSong(song2);

        System.out.println(playlist);
    }
}
