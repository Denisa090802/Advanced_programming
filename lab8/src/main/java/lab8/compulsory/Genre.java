package lab8.compulsory;

public class Genre {

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer id;

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String name;
}
