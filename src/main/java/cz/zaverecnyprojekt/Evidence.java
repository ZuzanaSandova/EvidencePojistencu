package cz.zaverecnyprojekt;

import java.util.ArrayList;
import java.util.Scanner;

public class Evidence {

    private Scanner sc = new Scanner(System.in);
    private DatabazePojistencu databazePojistencu = new DatabazePojistencu();

    /**
     * Konstruktor
     */
    public Evidence () {
    }

    /**
     * Vypíše se úvodní menu do konzole
     */
    public void vypisUvodniObrazovku() {
        System.out.println("------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("------------------------------------------\n");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
        System.out.print("\nVolba: ");
    }

    /**
     * Postupně se zadají všechny údaje o pojištěnci, poté se zkontroluje zadaný věk a telefon, po kontrole se přidá do listu
     */
    public void pridejNovehoPojistence() {
        // zadání vstupu od uživatele, jméno a příjmení
        System.out.println("\nZadejte jméno pojištěného: ");
        String jmeno = sc.nextLine().trim();
        System.out.println("Zadejte příjmení pojištěného: ");
        String prijmeni = sc.nextLine().trim();

        // zadání vstupu od uživatele a kontrola, jestli je to číslo: věk a telefonní číslo
        int vek = kontrolaCiselnehoVstupu("Zadejte věk pojištěného:");
        int telefon = kontrolaCiselnehoVstupu("Zadejte telefonní číslo pojištěného:");

        // přidání pojištěnce do databáze
        databazePojistencu.pridejPojistence(jmeno, prijmeni, vek, telefon);
        System.out.println("\nData byla uložena.");
    }

    /**
     * Zkontroluje se hodnota po zadání, pokud to není číslo, vyhodí se výjimka a vstup se musí zadat znovu
     * @param vypisZadani text, který se vypíše do konzole, určuje přesné zadání
     * @return vrátí správně zadanou hodnotu (číselnou)
     */
    private int kontrolaCiselnehoVstupu (String vypisZadani) {
        System.out.println(vypisZadani);
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Zadaná hodnota je neplatná, zadejte prosím znovu!");
            }
        }
    }

    /**
     * Do konzole se vypíšou všichni pojištěnci z databáze
     */
    public void vypisVsechnyPojistence() {
        System.out.println();
        ArrayList<Pojistenec> vypisPojistencu = databazePojistencu.getPojistenci();
        vypisPojistenceZListu(vypisPojistencu, "V databázi není žádný pojištěnec!");
        System.out.println();
    }

    /**
     * Zadá se jméno a příjmení, podle toho se vypíše jeden nebo více pojištěnců se všemi údaji, případně se vypíše, pokud bude pojištěnec nenalezen
     */
    public void vyhledejPojistence() {
        // od uživatele se zadá jméno a příjmení
        System.out.println("\nZadejte jméno hledaného pojištěnce:");
        String jmeno = sc.nextLine().trim();
        System.out.println("Zadejte příjmení hledaného pojištěnce:");
        String prijmeni = sc.nextLine().trim();
        System.out.println();

        // vytvoří se nový list, do kterého se uloží list všech pojištěnců se stejným jménem a příjmení
        ArrayList<Pojistenec> vyhledaniPojistenci = databazePojistencu.vyhledejPojistence(jmeno, prijmeni);
        // vypíše se do konzole seznam nalezených pojištěnců
        vypisPojistenceZListu(vyhledaniPojistenci, "Podle zadaného jména a příjmení není v databázi žádný pojištěnec!");
        System.out.println();
    }

    /**
     * Vypíše do konzole obsah ze zadaného listu, v případně prázdného, vypíše zadaný text
     * @param listPojistencu list pojištěnců určený k výpisu
     * @param textKVypisu text, který se vypíše v případě, že list je prázdný
     */
    private void vypisPojistenceZListu (ArrayList<Pojistenec> listPojistencu, String textKVypisu) {
        // nejdříve se zkontroluje, jestli je list prázdný, když není, vypíšou se pojištěnci
        if (listPojistencu.isEmpty()) {
            System.out.println(textKVypisu);
        } else {
            System.out.println("Výpis všech pojištěnců:");
            for (Pojistenec pojistenec : listPojistencu) {
                System.out.println(pojistenec);
            }
        }
    }
}
