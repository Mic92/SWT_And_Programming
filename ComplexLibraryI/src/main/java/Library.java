import static java.lang.System.arraycopy;
import static java.lang.System.out;

public final class Library {
    private String[] inventory;
    private String[][] userAccounts;
    private static Library instance;

    private Library() {
        inventory = new String[20];
        userAccounts = new String[20][6];
    }

    public static Library getTheLibrary() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public boolean addBook(String newbook) {
        if (newbook == null) {
            throw new NullPointerException();
        }
        int llen = inventory.length;
        for (int i = 0; i < llen; i++) {
            if (inventory[i] == null) {
                inventory[i] = newbook;
                return true;
            } else if (inventory[i].equals(newbook)) {
                return false;
            }
        }
        return false;
    }
    public boolean removeBook(String remove) {
        if (remove == null) {
            return false;
        }
        int llen = inventory.length;
        for (int i = 0; i < llen; i++) {
            if (inventory[i] == null) {
                return false;
            } else if (inventory[i].equals(remove)) {
                // shift left
                if ((i+2) < llen) {
                    arraycopy(inventory, i+1, inventory, i, llen-i-1);
                }
                inventory[llen-1] = null;
                return true;
            }
        }
        return false;
    }

    public String getBook(String book) {
        if (book == null) {
            return null;
        }

        for (String b: inventory) {
            if (book.equals(b)) {
                return b;
            }
        }
        return null;
    }

    public boolean returnBook(String book, String user) {
        if (user == null || book == null) {
            throw new NullPointerException();
        }
        for (String[] u: userAccounts) {
            if (user.equals(u[0])) {
                int llen = u.length;
                for (int i = 1; i < llen; i++) {
                    if (book.equals(u[i])) {
                        u[i] = null;
                        this.addBook(book);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean borrowBook(String book, String user) {
        if (user == null || book == null) {
            return false;
        }
        for (String[] u: userAccounts) {
            if (user.equals(u[0])) {
                if (!this.removeBook(book)) {
                    return false;
                }

                int llen = u.length;
                for (int i = 1; i < llen; i++) {
                    if (u[i] == null) {
                        u[i] = book;
                        return true;
                    }
                }
                this.addBook(book);
                return false;
            }
        }
        return false;
    }

    public boolean addUserAccount(String pi) {
        if (pi == null) {
            return false;
        }
        for (String[] u : userAccounts) {
            if (u[0] == null) {
                u[0] = pi;
                return true;
            } else if (u[0].equals(pi)) {
                return false;
            }
        }
        return false;
    }
    public boolean removeUserAccount(String pi) {
        if (pi == null) {
            return false;
        }
        int llen = userAccounts.length;
        for (int i=0; i<llen; i++) {
            if (userAccounts[i][0] == null) {
                return false;
            } else if (userAccounts[i][0].equals(pi)) {
                userAccounts[i] = new String[6];
                return true;
            }
        }
        return false;
    }
    public boolean hasUserAccount(String pi) {
        if (pi == null) return false;
        for (String[] u: userAccounts) {
            if (pi.equals(u[0])) {
                return true;
            }
        }
        return false;
    }
}