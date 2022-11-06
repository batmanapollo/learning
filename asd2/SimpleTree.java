import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        if (Root != null) {
            delete(Root, NodeToDelete);
        }
    }

    private boolean delete(SimpleTreeNode<T> node, SimpleTreeNode<T> NodeToDelete) {
        if (NodeToDelete.equals(node)) {
            node.Parent.Children.remove(node);
            return true;
        }

        for (SimpleTreeNode<T> child : node.Children) {
            var deleted = delete(child, NodeToDelete);
            if (deleted) {
                return true;
            }
        }

        return false;
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        if (Root == null) {
            return Collections.emptyList();
        }

        var result = new ArrayList<SimpleTreeNode<T>>();
        addAllChildren(result, Root);

        return result;
    }

    private void addAllChildren(List<SimpleTreeNode<T>> acc, SimpleTreeNode<T> node) {
        acc.addAll(node.Children);
        for (SimpleTreeNode<T> child : node.Children) {
            addAllChildren(acc, child);
        }
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        if (Root == null) {
            return Collections.emptyList();
        }

        var result = new ArrayList<SimpleTreeNode<T>>();
        addAllChildren2(result, Root, val);

        return result;
    }

    private void addAllChildren2(List<SimpleTreeNode<T>> acc, SimpleTreeNode<T> node, T val) {
        if (val.equals(node.NodeValue)) {
            acc.add(node);
        }
        for (SimpleTreeNode<T> child : node.Children) {
            addAllChildren2(acc, child, val);
        }
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        OriginalNode.Parent = NewParent;
        delete(OriginalNode.Parent, OriginalNode);
        NewParent.Children.add(OriginalNode);
    }

    public int Count()
    {
        return GetAllNodes().size();
    }

    public int LeafCount()
    {
        return GetAllNodes().size();
    }
}
