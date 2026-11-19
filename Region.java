
import java.util.*;
public class Region {
    private String name;
    private ArrayList<Municipality> municipalities;

    public Region(String name) {
        this.name = name;
        this.municipalities = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addMunicipality(Municipality m) {
        municipalities.add(m);
    }

    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Municipality m : this.municipalities) {
            sb.append(m.toString() + "\n");
        }

        return sb.toString();
    }
}
