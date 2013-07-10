package components.java;

public interface Observer{

    public void update(String name, Issue issue) throws UnsupportedOperationException;
}
