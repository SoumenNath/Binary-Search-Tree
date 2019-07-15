package comp1406a5;


public class BinaryTree {
	protected Node root;
  protected int  size;

	public BinaryTree(){
		size = 0;
	}

  public BinaryTree(String s){
		root = new Node(s);
		size = 1;
	}

	public int getSize(){ return this.size; }
	public Node getRoot(){ return this.root; }


	public boolean contains(String target){
		if( root == null ){ return false; }
		if( root.getData().equals(target) ){
			return true;
		}
		return false;
	}



	public void add(String s){
		addLeft(s);
	}

	/* add a node in the left most free spot in the existing tree */
	private void addLeft(String s){
		if(root == null && size == 0){
			root = new Node(s);
			return;
		}else{
		  Node tmp = root;
		  while(tmp.getLeft() != null){
		  	tmp = tmp.getLeft();
		  }
		  // assert: temp.left == null
			// yea! we have a place to add s
		  tmp.setLeft(new Node(s));
		}
		size += 1;
	}
	




	/** Computes the height of the binary tree
	  *
		* The height is the length of the longest path from
		* the root of the tree to any other node.
		*
		* @return the height of the tree
		*/
	public int height(){
	  if( root == null ){ return -1; }
		return heightRecursive(root);
	}
	protected static int heightRecursive(Node root){
			if( root == null ){
			  return -1;
			}
			int leftHeight = heightRecursive(root.getLeft());
			int rightHeight = heightRecursive(root.getRight());
			if( leftHeight < rightHeight){
				return 1 + rightHeight;
			}else{
			  return 1 + leftHeight;
			}
		}


	public static void main(String[] args){
		BinaryTree t = new BinaryTree("cat");
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		t.add("dog");
		t.add("eel");
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		BinaryTree t1 = new BST("horse");
		t1.add("monkey");
	  t1.add("bat");
		t1.add("cat");
		t1.add("ape");
	  t1.add("lion");
		t1.add("zebra");
		t1.add("yak");
		System.out.println("height = " + t1.height() + ",  size = " + t1.getSize());
		System.out.println(((BST)t1).contains("monkeyy"));
		System.out.println(((BST)t1).contains("horse"));
		System.out.println(((BST)t1).contains("monkey"));
		BinaryTree t2 = ((BST)t1).makeBalanced();
		System.out.println("height = " + t2.height() + ",  size = " + t2.getSize());
		System.out.println(((BST)t2).contains("horse"));
		System.out.println(((BST)t2).contains("monkey"));
		System.out.println(((BST)t2).contains("bat"));
		System.out.println(((BST)t2).contains("cat"));
		System.out.println(((BST)t2).contains("ape"));
		System.out.println(((BST)t2).contains("lion"));
		System.out.println(((BST)t2).contains("zebra"));
		t2.add("elephant");
		System.out.println("height = " + t2.height() + ",  size = " + t2.getSize());
	}
}
