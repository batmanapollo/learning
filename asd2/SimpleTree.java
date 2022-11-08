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
        if (ParentNode == null) {
            Root = NewChild;
        } else {
            if (ParentNode.Children == null) {
                ParentNode.Children = new ArrayList<>();
            }
            ParentNode.Children.add(NewChild);
            NewChild.Parent = ParentNode;
        }
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        if (NodeToDelete.equals(Root)) {
            Root = null;
        } else if (Root != null) {
            delete(Root, NodeToDelete);
        }
    }

    private boolean delete(SimpleTreeNode<T> node, SimpleTreeNode<T> NodeToDelete) {
        if (NodeToDelete.equals(node) && NodeToDelete.Parent.Children != null) {
            var deleted = NodeToDelete.Parent.Children.remove(node);
            if (deleted) {
                NodeToDelete.Parent = null;
            }
            return deleted;
        }

        if (node.Children != null) {
            for (SimpleTreeNode<T> child : node.Children) {
                var deleted = delete(child, NodeToDelete);
                if (deleted) {
                    return true;
                }
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
        acc.add(node);
        if (node.Children != null) {
            for (SimpleTreeNode<T> child : node.Children) {
                addAllChildren(acc, child);
            }
        }
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        if (Root == null) {
            return Collections.emptyList();
        }

        var result = new ArrayList<SimpleTreeNode<T>>();
        addAllChildrenByValue(result, Root, val);

        return result;
    }

    private void addAllChildrenByValue(List<SimpleTreeNode<T>> acc, SimpleTreeNode<T> node, T val) {
        if (val.equals(node.NodeValue)) {
            acc.add(node);
        }
        if (node.Children != null) {
            for (SimpleTreeNode<T> child : node.Children) {
                addAllChildrenByValue(acc, child, val);
            }
        }
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        delete(OriginalNode.Parent, OriginalNode);
        AddChild(NewParent, OriginalNode);
    }

    public int Count()
    {
        return GetAllNodes().size();
    }

    public int LeafCount()
    {
        return GetAllNodes().size();
    }

    private Integer countLeafs(SimpleTreeNode<T> node) {
        if (node.Children == null || node.Children.size() == 0) {
            return 1;
        }

        return node.Children.stream().map(this::countLeafs).reduce(0, Integer::sum);
    }
}
