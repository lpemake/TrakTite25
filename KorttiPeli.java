import java.util.ArrayList;

public class KorttiPeli {
    public static void main(String[] args) {
        KorttiPakka pakka = new KorttiPakka();
        pakka.teePakka();
        pakka.sekoita();
        pakka.jarjesta();

        System.out.println("PAKKA");
        System.out.println(pakka.toString());

        ArrayList<Kortti> kasi = pakka.jaa(5);
        System.out.println("KÄSI");
        for (Kortti k : kasi) {
            System.out.println(k.toString());
        }
    }
}
