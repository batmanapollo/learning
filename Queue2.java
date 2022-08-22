import java.util.*;

public class Queue<T>
{
    private LinkedList<T> data;

    public Queue()
    {
        data = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        data.addLast(item);
    }

    public T dequeue()
    {
        if (size() > 0) {
            return data.pop();
        }
        return null;
    }

    public int size()
    {
        return data.size();
    }

}
