import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Artists {
    @Id
    private String name;
    private int count;

    public Artists(){};

    @OneToMany(mappedBy = "artist",fetch= FetchType.EAGER)
    private List<Paintings> paintings = new ArrayList<>();

    public List<Paintings> getPaintings() {
        return paintings;
    }

    public void setPaintings(List<Paintings> paintings) {
        this.paintings = paintings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Artists(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
