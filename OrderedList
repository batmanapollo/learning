import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;
    public int count;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
        count = 0;
    }

    public int compare(T v1, T v2)
    {
        var value1 = (Integer) v1;
        var value2 = (Integer) v2;
        var comparingResult = compare2(value1, value2);
        if (_ascending) {
            return comparingResult * -1;
        }
        return comparingResult;
    }

    private int compare2(Integer v1, Integer v2) {
        if (v1 < v2) {
            return -1;
        }

        if (v2 < v1) {
            return 1;
        }

        return 0;
    }

    public void add(T value)
    {
        var node = new Node<>(value);
        if (count == 0) {
            head = node;
            tail = node;
            count++;
            return;
        }
        count++;

        var n = find2(value);
        if (n == null) {
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }
        if (n.next == null) {
            node.prev = n;
            n.next = node;
            tail = node;
            return;
        }

        node.next = n.next;
        n.next.prev = node;
        node.prev = n;
        n.next = node;
    }

    private Node<T> find2(T value) {
        var node = head;
        while (node != null) {
            var comparingResult = compare(node.value, value);
            if (comparingResult < 0) {
                return node.prev;
            }
            node = node.next;
        }

        return tail;
    }

    public Node<T> find(T val)
    {
        var node = head;
        while (node != null) {
            var comparingResult = compare(node.value, val);
            if (comparingResult == 0) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void delete(T val)
    {
        if (count == 0) {
            return;
        }
        var n = find(val);
        if (n == null) {
            return;
        }
        if (count == 1) {
            clear(_ascending);
            return;
        }
        count--;
        if (n.prev == null) {
            head = n.next;
            head.prev = null;
            return;
        }
        if (n.next == null) {
            tail = n.prev;
            tail.next = null;
            return;
        }

        n.next.prev = n.prev;
        n.prev.next = n.next;
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        count = 0;
        head = null;
        tail = null;
    }

    public int count()
    {
        return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}

