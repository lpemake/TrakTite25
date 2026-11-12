import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void sekoita() {
        Collections.shuffle(this.pakka);
    }

    public void jarjesta() {
        Comparator<Kortti> maanJaArvonMukaan = (k1, k2) -> {
            int ret = k1.getMaa().compareTo(k2.getMaa());
            if (ret == 0)
                ret = k1.getArvo() - k2.getArvo();
            return ret;
        };
        Collections.sort(this.pakka, maanJaArvonMukaan);
    }

    public void jarjestaArvonMukaan() {
        Collections.sort((k1, k2) -> k1.getArvo() - k2.getArvo());
    }

    public ArrayList<Kortti> jaa(int n) {
        // jaetaan n korttia
        // otetaan n korttia pakan päältä
        ArrayList<Kortti> kasi = new ArrayList<>(this.pakka.subList(0, n));
        // poistetaan jaetut kortit pakasta
        this.pakka.removeAll(kasi);
        // palautetaan käsi
        return kasi;
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
