import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Hall {
    private int id_paint;
    private int size;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId_paint(){
        return id_paint;
    }

    public void setId_paint(int id_paint){
        this.id_paint = id_paint;
    }

}
