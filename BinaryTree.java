import java.lang.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data,Node left,Node right)
    {
        this.data=data;
        this.left=left;
        this.right=right;
    }
}

class BinaryTree
{
	Node parent;
    public Node addNode(Node root,int data)
    {
        if(root==null)
        {
            root=new Node(data,null,null);
            return root;
        }
        else
        {
            if(data<root.data)
            {
                root.left=addNode(root.left,data);
                return root;
            }
            else
            {
                root.right=addNode(root.right,data);
                return root;
            }
        }
    }

    public boolean removeNode(Node root,int data)
    {
        System.out.println("\n\nremoving "+data+" form tree");
        Node parent=root;
        Node focusNode=root;

        boolean isLeft=true;

        while(focusNode.data!=data)
        {
            if(data<focusNode.data)
            {
                parent=focusNode;
                focusNode=focusNode.left;
                isLeft=true;
            }
            else
            {
                parent=focusNode;
                focusNode=focusNode.right;
                isLeft=false;
            }
            if(focusNode==null)
            return false;
        }

        if(focusNode.left==null && focusNode.right==null)
        {
            if(isLeft)
            parent.left=null;
            else
            parent.right=null;
        }
        else if(focusNode.left==null)
        {
            if(isLeft)
            parent.left=focusNode.right;
            else
            parent.right=focusNode.right;
        }
        else if(focusNode.right==null)
        {
            if(isLeft)
            parent.left=focusNode.left;
            else
            parent.right=focusNode.left;
        }

        else
        {
            Node replacement=getReplacement(focusNode);
             if(parent==focusNode)
             {
                focusNode.data=replacement.data;

             }
             else{
                    if (isLeft)
                    parent.left = replacement;

                    else
                    parent.right = replacement;

                    replacement.left = focusNode.left;
                    }
        }
        return true;
    }

    public Node getReplacement(Node root)
    {
        Node focusParent=root;
        Node focus=root.right;

        if(focus.left==null)
        {
            return focus;
        }
        else
        {
            while(focus.left!=null)
            {
                focusParent=focus;
                focus=focus.left;
            }

            focusParent.left=focus.right;
            focus.right=root.right;

            return focus;
        }
    }

    public void inOrderTraverse(Node root)
    {
        if(root!=null)
        {
            inOrderTraverse(root.left);
            System.out.print(root.data+" ");
            inOrderTraverse(root.right);
        }
    }


    public static void main(String args[])
    {
        BinaryTree theTree=new BinaryTree();
        Node root=null;
        boolean isPresent=true;

        root=theTree.addNode(root,40);
        theTree.addNode(root,25);
        theTree.addNode(root,50);
        theTree.addNode(root,48);
        theTree.addNode(root,12);
        theTree.addNode(root,97);
        theTree.addNode(root,63);
        theTree.addNode(root,24);
        theTree.addNode(root,8);
        theTree.addNode(root,32);

        theTree.inOrderTraverse(root);
        isPresent=theTree.removeNode(root,40);

        if(isPresent)
        {
            System.out.println();
            theTree.inOrderTraverse(root);
        }
        else
        {
            System.out.println("\nnot found");
        }
    }
}