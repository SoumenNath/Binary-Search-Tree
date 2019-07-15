package comp1406a5;
import java.util.ArrayList;
public class BST extends BinaryTree{

	// You MUST have a zero argument constructor that
	// creates an empty binary search tree
	// You can can add code to this if you want (or leave it alone).
  // We will create all BSTs for testing using this constructor
  public BST(){}
  public BST(String s){super(s);}

  @Override
  public boolean contains(String s){
    boolean c = false;
    Node curr = this.root;
    while (curr!=null){
      if (curr.getData().compareTo(s)==0){
        c = true;
        break;
      }
      else if(curr.getData().compareTo(s)<0){
        curr = curr.getRight();
      }
      else if(curr.getData().compareTo(s)>0){
        curr = curr.getLeft();
      }
    }
    return c;
  }

  public void helperA(String s, Node n){
    if(n.getData().compareTo(s) < 0) {
      if (n.getRight() == null){
        n.setRight(new Node(s));
        size+=1;
        return;
      } 
      else{
        helperA(s, n.getRight());
      }  
    }
    else if(n.getData().compareTo(s) > 0) {
      if (n.getLeft() == null){
        n.setLeft(new Node(s));
        size+=1;
        return;
      } 
      else{
        helperA(s, n.getLeft());
      } 
    }
    else{
      return;
    }
  }
  @Override
  public void add(String s){
    if(this.root == null && this.size == 0){
      this.root = new Node(s);
      size+=1;
    }
    else{
      helperA(s, this.root);
    }
  }
  ArrayList <String> arrl = new ArrayList<String>();
  public void traverse(Node node){
    if (node==null){
      return;
    }
    traverse(node.getLeft());
    arrl.add(node.getData());
    traverse(node.getRight());
  }
  public boolean helperValid(Node node){  
    boolean re = true;
    traverse(node);
    for(int i=1; i<arrl.size(); i++){
      if (arrl.get(i).compareTo(arrl.get(i-1))<0 || arrl.get(i).compareTo(arrl.get(i-1))==0){
        re = false;
      }
    }
    arrl.clear();
    return re;
  }
  public boolean isValidBST(){
    if (this.root==null){
      return true;
    }
    return helperValid(this.root);
    
  }

  ArrayList <Node> nodel = new ArrayList<Node>();
  public void traverse2(Node node){
    if (node==null){
      return;
    }
   
    traverse2(node.getLeft());
    nodel.add(node);
    System.out.println(node.getData());
    traverse2(node.getRight());
  }
  
  public BST mBhelper(BST tree, int start, int end){
    if (start>end){
      return null;
    }
    int mid = (int) (((start + end)/2) + 0.5); 
    Node n = new Node(nodel.get(mid).getData());
    System.out.println("Tree 2 Data: "+n.getData());
    tree.add(n.getData());
    mBhelper(tree, start, mid-1);
    mBhelper(tree, mid+1, end);
    return tree;
  }
  public BST makeBalanced(){
    if (this.root==null){
      BST t = new BST();
      return t;
    }
    traverse2(this.root);
    int s = nodel.size();
    BST t = new BST();
    t = mBhelper(t, 0, s-1);
    nodel.clear();
    return t;
  }

}
