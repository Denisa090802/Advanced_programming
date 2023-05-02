package lab8.compulsory;

public class Artist {

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Artist(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer id;
    public String name;

}
