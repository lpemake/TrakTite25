import java.util.ArrayList;

public class KorttiPakka {
    
    private ArrayList<Kortti> pakka = new ArrayList<Kortti>();

    public KorttiPakka() {

    }

    // tee kortit korttipakkaan
    public void teePakka() {
        // tee 52 korttia
        String[] maat = {"Hertta", "Ruutu", "Risti", "Pata"};

        // käydään maat läpi
        for (int i = 0; i < maat.length; i++) {
            // käydään arvot läpi
            for (int j = 1; j <= 13; j++) {
                Kortti k = new Kortti(maat[i], j);
                // muista lisätä kortti listaan
                this.pakka.add(k);
            }
        }
    }

    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Kortti k : this.pakka) {
            sb.append(k.toString() + "\n");
        }

        return sb.toString();
    }
}
