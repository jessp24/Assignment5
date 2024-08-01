/**
 * A Tree Node with a left and right child 
 *  
 *  @author Jessica Park
 * 
 *  @param <T> The data type of TreeNode
 */
public class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
}
	/*
	 * Constructor for TreeNode
	 *  @param dataNode The data stored in the node
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor for making a deep copy of another TreeNode
	 * @param node the node to make a copy of
	 */
	 public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = (node.left == null) ? null : new TreeNode<>(node.left);
		this.right = (node.right == null) ? null : new TreeNode<>(node.right);
	 }
	 
	 /**
	  *  @returns the data within this TreeNode
	  */
	 public T getData() {
		 return data;
	 }
	

