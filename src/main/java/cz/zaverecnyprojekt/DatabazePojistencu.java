package cz.zaverecnyprojekt;

import java.util.ArrayList;

public class DatabazePojistencu {

    // Vytvoření listu pojištěnců
    private ArrayList<Pojistenec> pojistenci;

    /**
     * Konstruktor
     */
    public DatabazePojistencu() {
        pojistenci = new ArrayList<>();
    }

    /**
     * Přidá nového pojištěnce do listu
     * @param jmeno jméno pojištěnce
     * @param prijmeni příjmení pojištěnce
     * @param vek věk pojištěnce
     * @param telefon telefon pojištěnce
     */
    public void pridejPojistence (String jmeno, String prijmeni, int vek, int telefon) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon));
    }

    /**
     * Podle zadaného jména a příjmení vyhledá v listu pojištěnce
     * @param jmeno jméno hledaného pojištěnce
     * @param prijmeni příjmení hledaného pojištěnce
     * @return list - prázdný, s jedním nebo více pojištěnců
     */
    public ArrayList<Pojistenec> vyhledejPojistence (String jmeno, String prijmeni) {
        // Vytvoření nového listu pro vyhladané pojištěnce
        ArrayList<Pojistenec> vyhledaniPojistenci = new ArrayList<>();
        // cyklem se projde každé jméno a příjmení pojištěnce a případná shoda se uloží do právě vytvořeného listu
        for (Pojistenec pojistenec : getPojistenci()) {
            if (pojistenec.getJmeno().equals(jmeno)) {
                if (pojistenec.getPrijmeni().equals(prijmeni)) {
                    vyhledaniPojistenci.add(pojistenec);
                }
            }
        }
        return vyhledaniPojistenci;
    }

    /**
     * Vrátí list všech pojištěnců
     * @return list pojištěnců
     */
    public ArrayList<Pojistenec> getPojistenci() {
        return pojistenci;
    }

    public void setPojistenci(ArrayList<Pojistenec> pojistenci) {
        this.pojistenci = pojistenci;
    }
}
