import java.util.List;

public class Albums {
    private List<String> songs;

    public Albums(List<String> songs) {
        this.songs = songs;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        System.out.print("Songs in album of: ");
        songs.stream().forEach(value -> System.out.print(value + " "));
        return " ";
    }
}
