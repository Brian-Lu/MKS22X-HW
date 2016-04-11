public interface Frontier<T> {
    public T next();
    public void add(T element);
    public boolean hasNext();
}
