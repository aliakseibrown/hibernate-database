import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class  Paintings {
    @Id
    private int id;
    private String room;
    private String name;
    private String painting;
    private int year;
    @ManyToOne //(fetch= FetchType.EAGER)
    private Artists artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Paintings(int id, String room, String name, String painting, int year) {
        this.id = id;
        this.room = room;
        this.name = name;
        this.painting = painting;
        this.year = year;
    }

    public Paintings(){}

    @Override
    public String toString() {
        return "artist{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", name='" + name + '\'' +
                ", painting='" + painting + '\'' +
                ", year=" + year +
                '}';
    }
}
