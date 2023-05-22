package cz.zaverecnyprojekt;

public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefon;

    public Pojistenec (String jmeno, String prijmeni, int vek, int telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    // gettery a settery
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    /**
     * Vlastní výpis pojištěnce do konzole
     * @return pojištěnec se všemi informacemi
     */
    @Override
    public String toString () {
        return getJmeno() + "\t" + getPrijmeni() + "\t" + getVek() + "\t\t" + getTelefon();
    }
}
