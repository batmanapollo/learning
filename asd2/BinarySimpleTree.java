import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
    {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key)
    {
        if (Root == null) {
            return new BSTFind<>();
        }

        return find((Root), key);
    }

    private BSTFind<T> find(BSTNode<T> node, int key) {
        if (key == node.NodeKey) {
            var find = new BSTFind<T>();
            find.Node = node;
            find.NodeHasKey = true;
            return find;
        }

        var isToLeft = key < node.NodeKey;

        if (node.LeftChild == null && node.RightChild == null) {
            var find = new BSTFind<T>();
            find.Node = node;
            find.NodeHasKey = false;
            find.ToLeft = isToLeft;
            return find;
        }

        if (isToLeft) {
            return find(node.LeftChild, key);
        }

        return find(node.RightChild, key);
    }

    public boolean AddKeyValue(int key, T val)
    {
        var find = FindNodeByKey(key);
        if (find.NodeHasKey) {
            return false;
        }
        var newNode = new BSTNode<>(key, val, find.Node);
        if (find.ToLeft) {
            find.Node.LeftChild = newNode;
        } else {
            find.Node.RightChild = newNode;
        }
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        if (!FindMax && FromNode.LeftChild == null) {
            return FromNode;
        }
        if (!FindMax) {
            return FinMinMax(FromNode.LeftChild, FindMax);
        }
        if (FindMax && FromNode.RightChild == null) {
            return FromNode;
        }
        return FinMinMax(FromNode.RightChild, FindMax);
    }

    public boolean DeleteNodeByKey(int key)
    {
        var find = FindNodeByKey(key);
        var nodeToDelete = find.Node;
        if (find.NodeHasKey && nodeToDelete.RightChild != null) {
            var leftest = getLeftest(nodeToDelete.RightChild);
            if (nodeToDelete.Parent.LeftChild.equals(nodeToDelete)) {
                nodeToDelete.Parent.LeftChild = leftest;
            } else {
                nodeToDelete.Parent.RightChild = leftest;
            }
            nodeToDelete.Parent = null;
            return true;
        }
        return false; 
    }

    private BSTNode<T> getLeftest(BSTNode<T> node) {
        if (node.LeftChild == null) {
            return node;
        }
        return getLeftest(node.LeftChild);
    }

    public int Count()
    {
        if (Root == null) {
            return 0;
        }

        return count(Root);
    }

    private int count(BSTNode<T> node) {
        var result = 1;
        if (node.LeftChild != null) {
            result = result + count(node.LeftChild);
        }
        if (node.RightChild != null) {
            result = result + count(node.RightChild);
        }
        return result;
    }

}
