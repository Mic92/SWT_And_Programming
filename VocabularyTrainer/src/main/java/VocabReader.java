import java.io.*;
import java.util.*;
public class VocabReader {
    private File vocabFile = new File("vocab.txt");
    public Map<Integer,VocabCard> vocabMap = new HashMap<Integer, VocabCard>();
    public Map<Integer,VocabCard> read(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(vocabFile));
            String line;
            while((line = br.readLine()) != null) {
                VocabCard c = createVocabCard(line);
                vocabMap.put(0,c);
            }
        }catch (IOException e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return vocabMap;
    }
    public VocabCard createVocabCard(String l) {
        if (l.startsWith("#") || l == null) return null;
        String[] word = l.split(":");
        if (word.length != 2) {
            return null;
        }
        return new VocabCard(word[0],word[1]);
    }
}
