import java.util.Arrays;

public class PhoneBook {
    private int index, numberOfEntries;
    private Entry[] entries;

    public PhoneBook(int maxSize) {
        entries = new Entry[maxSize];
        numberOfEntries = 0;
        index = 0;
    }
    public boolean addNewEntry(TelephoneNumber t, Person p, Address a) {
        if (numberOfEntries >= entries.length) {
            return false;
        }
        index = numberOfEntries;
        entries[numberOfEntries] = new Entry(p,t,a);
        numberOfEntries++;
        return true;
    }
    public boolean removeMarkedEntry() {
        if (numberOfEntries == 0) return false;

        // remove entry by shifting array one times left.
        System.arraycopy(entries,index+1,entries,index,entries.length-1-index);
        numberOfEntries--;
        // index is greater than phonebook.
        if (index >= (numberOfEntries - 1))
            index = numberOfEntries - 1;
        return true;
    }
    public int countEntries() {
        return numberOfEntries;
    }
    public Entry getFirstEntry() {
        return entries[0];
    }
    public Entry getLastEntry() {
        int idx = numberOfEntries == 0 ? 0 : numberOfEntries-1;
        return entries[idx];
    }
    public Entry getMarkedEntry() {
        if (numberOfEntries == 0) {
            return null;
        }
        return entries[index];
    }
    public void markNextEntry() {
        System.out.println("index: "+index+ " numberOfEntries: "+numberOfEntries);
        if (index < (numberOfEntries - 1)) {
            index++;
        }
    }
    public void markPreviousEntry() {
        if (index > 0) {
            index--;
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "index=" + index +
                ", numberOfEntries=" + numberOfEntries +
                ", entries=" + (entries == null ? null : Arrays.asList(entries)) +
                '}';
    }
}
