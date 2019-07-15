package comp1406a5;

public class Node{
  protected String data;
  protected Node   left;
  protected Node   right;

  public Node(String data){
    this(data, null, null);
  }

  public Node(String data, Node left, Node right){
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public String getData(){return this.data;}
  public Node   getLeft(){ return this.left;}
  public Node   getRight(){ return this.right;}

  public void setData(String s){ this.data = s;}
  public void setLeft(Node left){ this.left = left;}
  public void setRight(Node right){ this.right = right;}
  public void setLeftRight(Node left, Node right){
    this.left = left;
    this.right = right;
  }
  public void setAll(String data, Node left, Node right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  // Todd Davies StackOverflow https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram/8948691#8948691
  public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
    if(right!=null) {
        right.toString(new StringBuilder().append(prefix).append(isTail ? "\u2502   " : "    "), false, sb);
    }
    sb.append(prefix).append(isTail ? "\u2514\u2500\u2500 " : "\u250C\u2500\u2500 ").append(data.toString()).append("\n");
    if(left!=null) {
        left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "\u2502   "), true, sb);
    }
    return sb;
}

// Todd Davies StackOverflow https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram/8948691#8948691
@Override
public String toString() {
    return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
}

}
