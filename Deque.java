import java.util.*;

public class Deque<T>
{
    private LinkedList<T> data;

    public Deque()
    {
        data = new LinkedList<>();
    }

    public void addFront(T item)
    {
        data.push(item);
    }

    public void addTail(T item)
    {
        data.addLast(item);
    }

    public T removeFront()
    {
        if (size() > 0) {
            return data.pop();
        }
        return null;
    }

    public T removeTail()
    {
        if (size() > 0) {
            return data.removeLast();
        }
        return null;
    }

    public int size()
    {
        return data.size();
    }
}
