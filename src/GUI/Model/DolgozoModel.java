
package GUI.Model;

import java.awt.List;
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
        for (String string : adatok) {
            String[] szeparalt = string.split(separator);
            dolgozok.add(szeparalt);
            for (String string1 : szeparalt) {
                System.out.println(string1);
            }
        }
        
        
        
    }
    
    
}
