public class PredicateLength<T extends String> implements Predicate<T> {
    public boolean predicate(T element, T argument) {
        if (element == null || argument == null) return false;
        int len = Integer.parseInt(argument);
        return element.length() == len;
    }
}
