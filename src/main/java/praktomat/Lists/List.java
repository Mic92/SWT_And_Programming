// single-linked lists
class List {
    private ListElement first;

    List() { }

    public void append(String string) {
       ListElement e = first;
       ListElement next = new ListElement(string);
       if (e == null) { // empty list
           first = next;
       } else {
           while (e.getNext() != null) {  // move to end of list
               e = e.getNext();
           }
           e.setNext(next);  // append element
       }
    }

    public String remove(String string) {
        if (first == null) {  // empty list
            return null;
        }
        if (first.getContent().equals(string)) { // first element matches
            first = first.getNext();
            return string;
        }
        ListElement e = first;
        while (true) {
            ListElement next = e.getNext();
            if (next == null) {  // end of list
                return null;
            }
            if (next.getContent().equals(string)) { // element matches
               e.setNext(next.getNext()); // relink list
               return string;
            }
            e = next; // next element
        }
    }
}