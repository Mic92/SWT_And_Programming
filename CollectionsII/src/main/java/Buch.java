public class Buch implements Comparable<Buch> {
    String isbn, autor, title;
    public Buch(String isbn, String autor, String title) {
        this.isbn = isbn;
        this.autor = autor;
        this.title = title;
    }

    public int compareTo(Buch b) {
        if (this == b) return 0;
        if (b == null) return -1;
        if (isbn != null) {
            return isbn.compareTo(b.isbn);
        }
        return (b.isbn == null)?1:0;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && this.hashCode() == o.hashCode();
    }
}
