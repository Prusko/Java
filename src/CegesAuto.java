import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class CegesAuto {
    static List<Auto> autok = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try (BufferedReader beolvas = new BufferedReader(new FileReader("autok.txt"))) {
            String olvas;
            while ((olvas = beolvas.readLine()) != null){
                String[]sor = olvas.split(" ");
                autok.add(new Auto(Integer.parseInt(sor[0]), sor[1], sor[2], sor[3], Integer.parseInt(sor[4]), (sor[5].equals("1"))));
            }
        }

        Feladat2();
        Feladat3();
        Feladat4();
        Feladat5();
        Feladat6();
        Feladat7();
    }
    public static void Feladat2(){
        System.out.println("2. Feladat");
        for (int i = autok.size() -1; i > 0; i--){
            if (autok.get(i).hajtas == false){
                System.out.println(autok.get(i).nap + ". nap rendszám: " + autok.get(i).rendszam);
                break;
            }
        }
    }
    public static void Feladat3(){
        System.out.println("3. Feladat");
        System.out.print("Nap: ");
        int nap = Integer.parseInt(System.console().readLine());
        for (Auto auto : autok) {
            if (auto.nap == nap){
                System.out.printf("%s %s %s %s%n",auto.datum, auto.rendszam, auto.id, (auto.hajtas ? "be" : "ki"));
            }
        }
    }
    public static void Feladat4(){
        System.out.println("4. feladat");
        int db = 0;
        for (Auto auto : autok) {
            if (auto.hajtas)
                db--;
            else
                db++;
        }
        System.out.println("A hónap végén " + db + " autót nem hoztak vissza.");
    }
    public static void Feladat5(){
        System.out.println("5. Feladat");
        Set<String> kocsik = new HashSet<>();
        for (Auto auto : autok){
            kocsik.add(auto.rendszam);
        }
        for (String rendszam : kocsik){
            int minkm = 0;
            int i = 0;
            int maxkm = 0;
            int osszkm;
            for (Auto auto : autok){
                if (auto.rendszam.equals(rendszam)){
                    if (i == 0)
                        minkm = auto.km;
                    i++;
                    maxkm = auto.km;
                }
            }
            osszkm = maxkm - minkm;
            System.out.printf("%s %d%n", rendszam, osszkm);
        }
    }
    public static void Feladat6(){
        System.out.println("6. Feladat");
        Set<String> szemelyek = new HashSet<>();
        for (Auto auto : autok){
            szemelyek.add(auto.id);
        }
        int maxkm = 0;
        String maxid = "";
        int tav;
        for (String szemely : szemelyek){
            int kikm = 0;
            int bekm;
            for (Auto auto : autok){
                if (auto.id.equals(szemely) && !auto.hajtas)
                    kikm = auto.km;
                if (auto.id.equals(szemely) && auto.hajtas){
                    bekm = auto.km;
                    tav = bekm - kikm;
                    if (maxkm < tav){
                        maxid = auto.id;
                        maxkm = tav;
                    }
                }                
            }   
        }
        System.out.printf("Leghosszabb út: %d km, személy: %s", maxkm, maxid);
    }
    public static void Feladat7(){
        System.out.println("7. Feladat");
        System.out.print("Rendszám: ");
        String rendszam = System.console().readLine();

        try (PrintWriter kiir = new PrintWriter(new FileWriter(rendszam + "_menetlevel.txt"))) {
            for (Auto auto : autok) {
                if (auto.rendszam.equals(rendszam)){
                    if (!auto.hajtas){
                        kiir.printf("%s\t%d. %s\t%d km\t",auto.id, auto.nap, auto.datum, auto.km);
                    }
                    if (auto.hajtas){
                        kiir.printf("%d. %s\t%d km%n", auto.nap, auto.datum, auto.km, auto.rendszam);
                    }
                }
            } 
        } catch (IOException e) {
                    
                }
        System.out.println("Menetlevél kész.");
    }
}
