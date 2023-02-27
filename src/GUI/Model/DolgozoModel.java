
package GUI.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DolgozoModel {
    private ArrayList<String[]> dolgozok;
    private String separator = ";";

    public DolgozoModel(String url) throws IOException {
        dolgozok = new ArrayList<>();
        beolvas(url);
    }
    
    private void beolvas(String url) throws IOException{
        Path utvonal = Paths.get(url);
        ArrayList<String> adatok = new ArrayList<>();
        adatok = (ArrayList<String>) Files.readAllLines(utvonal);
        adatok.remove(0);
        dolgozok.clear();
        for (String string : adatok) {
            String[] szeparalt = string.split(separator);
            dolgozok.add(szeparalt);
        }
    }

    public ArrayList<String[]> getDolgozok() {
        return dolgozok;
    }
    
    public String[] osszesites(String nem){
        String[] osszesito = new String[3];
        int legidosebb=0;
        int osszKor=0;
        String hatEveDolgozo = "nincs";
        for (String[] dolgozo : dolgozok) {
            if(dolgozo[2].equals(nem)){
                if(Integer.parseInt(dolgozo[1]) > legidosebb){
                    legidosebb = Integer.parseInt(dolgozo[1]);
                }
                osszKor += Integer.parseInt(dolgozo[1]);
                if(dolgozo.length > 3){
                    if(Integer.parseInt(dolgozo[3])>6){
                        hatEveDolgozo = dolgozo[0];
                    }
                }
            }
        }
        osszesito[0]=legidosebb+"";
        osszesito[1]=osszKor+"";
        osszesito[2]=hatEveDolgozo;
        return osszesito;
    }
    
    public String[] aktualis(int index){
        return dolgozok.get(index);
    }
    
    public void mentes(String adat) throws IOException{
        File mentes = new File("emberekMentes.txt");
        FileWriter fw = new FileWriter("emberekMentes.txt");
        fw.write(adat);
        System.out.println("MENT");
        fw.close();
    }
    

    
    
}
