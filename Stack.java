import java.util.*;

public class Stack<T>
{
    private LinkedList<T> data;

    public Stack()
    {
        data = new LinkedList<>();
    }

    public int size()
    {
        return data.size();
    }

    public T pop()
    {
        if (size() > 0) {
            return data.pop();
        }
        return null;
    }

    public void push(T val)
    {
        data.push(val);
    }

    public T peek()
    {
        if (size() > 0) {
            return data.peek();
        }
        return null;
    }
}
