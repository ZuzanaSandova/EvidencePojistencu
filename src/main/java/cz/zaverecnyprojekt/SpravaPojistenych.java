package cz.zaverecnyprojekt;

import java.util.Scanner;

public class SpravaPojistenych {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Evidence evidence = new Evidence();
        String volbaAkce = "";

        while (!volbaAkce.equals("4")) {
            evidence.vypisUvodniObrazovku();
            volbaAkce = sc.nextLine();
            switch (volbaAkce) {
                case "1":
                    evidence.pridejNovehoPojistence();
                    break;
                case "2":
                    evidence.vypisVsechnyPojistence();
                    break;
                case "3":
                    evidence.vyhledejPojistence();
                    break;
                case "4":
                    System.out.println("Děkujeme za použití evidence pojištěnců!");
                    break;
                default:
                    System.out.println("Špatně zadaná volba");
            }
        }
    }
}
