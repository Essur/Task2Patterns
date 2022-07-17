package broadcasting;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private String author;
    private int time;

    public Song(String name, String author, int time) {
        this.name = name;
        this.author = author;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", time=" + time +
                '}';
    }
}
