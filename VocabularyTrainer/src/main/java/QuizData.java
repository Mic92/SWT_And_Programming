import java.util.*;

public class QuizData {
    private CardDrawing cardDrawing;
    private Map<Integer,VocabCard> vocabMap = new HashMap<Integer,VocabCard>();
    public QuizData() {
        cardDrawing = new CycleRandom();

// initialisiert die Vokabeln (vocabMap)
// und das Attribut cardDrawing
    }
    public int sizeVocab() {
        return 0;
    }
    public void drawNext() {
    }
    public VocabCard getCurrentVocabCard() {
        return null;
    }
}