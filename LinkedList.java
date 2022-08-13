import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        if (node == null) {
            return false;
        }

        if (node.next == null) {
            if (node.value == _value) {
                clear();
                return true;
            }
            return false;
        }

        Node nextNode = node.next;
        while (nextNode != null) {
            if (nextNode.value == _value) {
                node.next = nextNode.next;
                if (node.next == null) {
                    tail = node;
                }
                return true;
            }
            nextNode = nextNode.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        if (node == null) {
            return;
        }

        if (node.next == null) {
            if (node.value == _value) {
                clear();
            }
        }

        Node nextNode = node.next;
        while (nextNode != null) {
            if (nextNode.value == _value) {
                node.next = nextNode.next;
                if (node.next == null) {
                    tail = node;
                }
            }
            nextNode = nextNode.next;
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        Node node = head;
        if (_nodeAfter == null) {
            head = _nodeToInsert;
            head.next = node;
        }

        while (node != null) {
            if (node == _nodeAfter) {
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
            }
            node = node.next;
        }
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
