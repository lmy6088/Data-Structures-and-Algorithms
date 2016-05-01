/**
 * Created by lauminyi on 13/2/16.
 */
public class BinaryTree {
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key,name);
        //if tree is empty we set the root as the newNode
        if(root == null){
            root = newNode;
        }
        else{
            //parent Node
            Node parent;
            //Assign a pointer to the current node we are looking at called focusNode
            Node focusNode=root;
            while(true){
                parent=focusNode;
                if(key<focusNode.key){
                    //switches to left child if key is smaller;
                    focusNode=focusNode.leftchild;
                    if(focusNode==null){
                        parent.leftchild=newNode;
                        return;//were done;
                    }
                }
                else{
                    //switch to right child if greater
                    focusNode=focusNode.rightchild;
                    if(focusNode==null){
                        parent.rightchild=newNode;
                        return;//were done;
                    }
                }

            }

        }
    }

    public void inOrderTraversal(Node focusNode){
        if (focusNode!=null) {
            inOrderTraversal(focusNode.leftchild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightchild);
        }
    }

    public void preOrderTraversal(Node focusNode){
        if(focusNode!=null){
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftchild);
            preOrderTraversal(focusNode.rightchild);

        }
    }

    public  void postOrderTraversal(Node focusNode){
        if(focusNode!=null){
            postOrderTraversal(focusNode.leftchild);
            postOrderTraversal(focusNode.rightchild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key){
        Node focusNode = root;
        while(focusNode.key!=key){
            if (key<focusNode.key){
                //shifts to the left child;
                focusNode=focusNode.leftchild;
            }
            else{
                //shifts to right child;
                focusNode=focusNode.rightchild;
            }
            if(focusNode==null){
                System.out.println("Sorry not found!");
                return null;
            }

        }
        return focusNode;

    }

    public boolean delete(int key){
        Node focusNode = root;
        Node parent = root;
        //boolean to check if current node is a left child or not
        boolean isleftChild=true;

        while(focusNode.key!=key){
            parent = focusNode;

            if(key<focusNode.key){
                isleftChild=true;
                focusNode=focusNode.leftchild;
            }
            else{
                isleftChild=false;
                focusNode=focusNode.rightchild;
            }
            if(focusNode==null){
                return false;
            }

        }
        //if current node has no children
        if(focusNode.leftchild==null && focusNode.rightchild==null){
            //if the current node is the root delete it
            if(focusNode==root){
                root = null;
            }
            //if its a left child
            else if(isleftChild){
                parent.leftchild = null;
            }
            //right child
            else {
                parent.rightchild = null;
            }

        }
        //if current node has no left child
        else if(focusNode.leftchild==null){
            //the deleted node will always be replaced by its right child
            if(focusNode==root){
                root=focusNode.rightchild;
            }
            else if(isleftChild){
                parent.leftchild=focusNode.rightchild;
            }
            else {
                parent.rightchild = focusNode.rightchild;
            }
        }
        //if current node has no right child
        else if(focusNode.rightchild==null){
            if(focusNode==root){
                root=focusNode.leftchild;
            }
            else if(isleftChild){
                parent.leftchild=focusNode.leftchild;
            }
            else {
                parent.leftchild=focusNode.rightchild;
            }
        }
        //if current node has 2 children
        else {
            Node replacement = getreplacement(focusNode);
            //if current node is a root
            if(focusNode==root){
                root=replacement;
            }
            //if current node to be deleted is a left child
            //make the parent's left child the replacement node
            else if(isleftChild){
                parent.leftchild=replacement;
            }
            //if current node to be deleted is a right child
            //vise versa
            else {
                parent.rightchild=replacement;
            }
            //set the replaced node's left child as the previous node's left child
            //to avoid breaking up the tree
            replacement.leftchild=focusNode.leftchild;
        }
        return true;
    }

    public Node getreplacement(Node nodeDeleted){
        Node replacement=nodeDeleted;
        Node replacementparent=nodeDeleted;
        //set the focus node as the node to be deleted's right child
        Node focusNode=nodeDeleted.rightchild;
        //keep going to the left until there is no more nodes
        while(focusNode!=null){
            replacementparent=replacement;
            replacement=focusNode;
            focusNode=focusNode.leftchild;
        }
        //if the replacement node is not the right child of the node to be deleted
        if(replacement!=nodeDeleted.rightchild){
            replacement.rightchild=nodeDeleted.rightchild;
            replacementparent.leftchild=replacement.rightchild;
        }
        return replacement;
    }



    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Boss");

        theTree.addNode(25, "Vice President");

        theTree.addNode(20, "Office Manager");

        theTree.addNode(23, "Secretary");
        theTree.addNode(22, "Sales Manager");

        theTree.addNode(37, "Salesman 1");
        theTree.delete(90);
        // Different ways to traverse binary trees
        System.out.println("Tree In order:");
        theTree.inOrderTraversal(theTree.root);
//        System.out.println("Tree Pre  order:");
//        theTree.preOrderTraversal(theTree.root);
//        System.out.println("Tree Post order:");
//        theTree.postOrderTraversal(theTree.root);

        System.out.println("\nNode with the key 75");

        System.out.println(theTree.findNode(75));




    }

}
