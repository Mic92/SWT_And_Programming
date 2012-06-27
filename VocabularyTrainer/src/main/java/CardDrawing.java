public abstract class CardDrawing {
    public abstract int getNextVocabId(int sizeVocab);
    public int random(int max) {
        return (int)Math.floor(Math.random() * max) + 1;
    }
}