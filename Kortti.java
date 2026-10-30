public class Kortti {
    private String maa;
    private int arvo;

    public Kortti (String maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public String getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    @Override 
    public String toString() {
        // käsittele kuvakortit
        return maa + " " + arvo;
    }
}
