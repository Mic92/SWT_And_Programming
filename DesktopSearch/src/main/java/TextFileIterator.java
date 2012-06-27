import java.util.*;
public class TextFileIterator implements Iterator<String> {
    // der (Rest-)Text
    private String text;
    // wird beim nächsten Aufruf von next() zurückgegeben
    private String nextWord;
    // Fortsetzung auf der nächsten Seite
    public TextFileIterator(Resource res) {
// Text aus der Resource einlesen
// Worttrennungen entfernen
        text = text.replaceAll("-\n(?=[a-z])", "");
// das erste Wort berechnen
    }
    public boolean hasNext() {
        return nextWord != null;
    }
    public String next() {
        return null;
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
    private String getAsString(Resource res) {
// als gegeben voraussetzen, hier nur simuliert
        return ("Viel Erfolg in dieser Klausur ;-)");
    }
    private String extractNextWord() {
        int beginIdx = 0;
// alles überspringen, bis zum nächsten Buchstaben oder Ziffer
        while (beginIdx < text.length() &&
                !Character.isLetter(text.charAt(beginIdx)) &&
                !Character.isDigit(text.charAt(beginIdx))) {
            beginIdx++;
        }
        int idx = beginIdx;
// Wortende suchen
        while (idx < text.length() &&
                (Character.isLetter(text.charAt(idx)) ||
                        Character.isDigit(text.charAt(idx)))) {
            idx++;
        }
        if (beginIdx == idx) {
            return null;
        }
        String word = text.substring(beginIdx, idx);
        text = text.substring(idx);
        return word;
    }
}
