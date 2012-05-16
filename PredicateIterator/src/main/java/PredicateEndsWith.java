public class PredicateEndsWith<T extends String> implements  Predicate<T> {
    public boolean predicate(T element, T argument) {
         return element != null && argument != null && element.endsWith(argument);
    }
}
