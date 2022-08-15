import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
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

        if (node.value == _value) {
            if (node.next == null) {
                clear();
            } else {
                head = node.next;
                head.prev = null;
            }
            return true;
        }

        Node nextNode = node.next;
        while (nextNode != null) {
            if (nextNode.value == _value) {
                node.next = nextNode.next;
                if (node.next == null) {
                    tail = node;
                    tail.next = null;
                } else {
                    node.next.prev = node;
                }
                return true;
            }
            node = nextNode;
            nextNode = nextNode.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node newHeadNode = findNextNotEqual(this.head, _value);
        if (newHeadNode == null) {
            clear();
            return;
        } else {
            head = newHeadNode;
            head.prev = null;
        }

        Node lastNode = head;
        Node node = findNextNotEqual(lastNode.next, _value);
        while (node != null) {
            lastNode.next = node;
            node.prev = lastNode;
            lastNode = node;
            node = findNextNotEqual(lastNode.next, _value);
        }

        tail = lastNode;
        tail.next = null;
    }

    private Node findNextNotEqual(Node node, int _value) {
        while (node != null) {
            if (node.value != _value) {
                return node;
            }
            node = node.next;
        }

        return null;
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
            if (node == null) {
                tail = _nodeToInsert;
            } else {
                head.next = node;
                node.next = null;
                node.prev = _nodeToInsert;
                tail = node;
            }
        } else {
            while (node != null) {
                if (node == _nodeAfter) {
                    _nodeToInsert.next = node.next;
                    node.next = _nodeToInsert;
                    _nodeToInsert.prev = node;
                    if (_nodeToInsert.next == null) {
                        tail = _nodeToInsert;
                    } else {
                        _nodeToInsert.next.prev = _nodeToInsert;
                    }
                    return;
                }
                node = node.next;
            }
        }

    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
