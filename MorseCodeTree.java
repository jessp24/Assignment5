
import java.util.ArrayList;

/*
 * MorseCodeTree class that implements LinkedConverterTreeInterface
 * @author Jessica Park
 * 
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	
	/*
	 * Constructor calls the buildTree method
	 */
	
	public MorseCodeTree() {
		buildTree();
	}
	
	/*
	 * @returns reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	
	/*
	 * sets the root of a tree
	 * @param newNode a TreeNode that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	 
	 
	 /*
	  * Adds results to the correct position in the tree based on the code
	  * This method will call the recursive method addNode
	  * 
	  * @param code the code for the new node to be added
	  * @param letter of the data of the new TreeNode to be added
	  */
	 public void insert(String code, String letter) {
		 addNode(root, code, letter)
	 }
	 
	 /*
	  * recursive method that adds element to the correct position in the tree based on the code.
	  * 
	  * @param root the root of the tree for this particular recursive instance of addNode
	  * @param code the code for this particular recursive instance of addNode
	  * @param letter the data of the new TreeNode to be added
	  * 
	  */
	 
	 public void addNode(TreeNode<String> root, String code, String letter) {
		 if (code.length() == 1) {
			 if (code.equals(".")) {
				 root.left = new TreeNode<>(letter);
			 } else if (code.equals("-")) {
				 root.right = new TreeNode<>(letter);
			 }
		 } else {
			 if (code.charAt(0) == '.') {
				 if (root.left == null) {
					 root.left = new TreeNode<>(null);
				 }
				 addNode(root.left, code.substring(1), letter);
			 } else if (code.charAt(0) == '-' ) {
				 if(root.right == null) {
					 root.right = new TreeNode<>(null);
				 }
			 }	addNode(root.right, code.substring(1), letter);
		 }
	 }
	 
	 /* 
	  * fetch the data in the tree based on the code
	  * This method will call the recursive method fetchNode
	  * @param code - the code that describes the traversal to retrieve the string (letter)
	  * @return letter - the string that corresponds to the code
	  */
	 public String fetch(String code) {
		 return fetchNode(root, code);
	 }
	 
	 /*
	  *The recursive method that fetches the data of the TreeNode that corresponds with the code 
	  * A '.' means traverse to the left. A '-' means traverse to the right.
	  * @param root the root of the tree for this particular recursive instance of addNode
	  * @param code the code for this particular recursive instance of fetchNode
	  * @return the data corresponding to the code
	  */
	 public String fetchNode(TreeNode<String> root, String code) {
		 if (code.length() == 1) {
			 if (code.equals(".")) {
				 return root.left.getData();
			 } else if (code.equals("-")) {
				 return root.right.getData();
			 }
		 } else {
			 if (code.charAt(0) == '.') {
				 return fetchNode(root.left, code.substring(1));
			 } else if (code.charAt(0) == '-') {
				 return fetchNode(root.right, code.substring(1));
			 }
		 }
		 return null;
	 }
	 
	 /*
	  * This operation is not supported in the MorseCodeTree
	  * @param data - data of node to be deleted
	  * @returns reference to the current tree
	  * @throws UnsupportedOperationException
	  */
	 public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		 throw new UnsupportedOperationException();
	 }
	 
	 /*
	  * This operation is not supported in the MorseCodeTree
	  * @returns reference to the current tree
	  * @throws UnsupportedOperationException
	  */
	 public MorseCodeTree update() throws UnsupportedOperationException {
		 throw new UnsupportedOperationException();
	 }
	 
	 /*
	  * This method builds the MorseCoseTree by inserting the nodes of the tree level by level based on the code.
	  */
	 public void buildTree() {
		 root = new TreeNode<>("");
		 insert(".", "e");
		 insert("-", "t");
	     insert("..", "i");
	     insert(".-", "a");
	     insert("-.", "n");
	     insert("--", "m");
	     insert("...", "s");
	     insert("..-", "u");
	     insert(".-.", "r");
	     insert(".--", "w");
	     insert("-..", "d");
	     insert("-.-", "k");
	     insert("--.", "g");
	     insert("---", "o");
	     insert("....", "h");
	     insert("...-", "v");
	     insert("..-.", "f");
	     insert(".-..", "l");
	     insert(".--.", "p");
	     insert(".---", "j");
	     insert("-...", "b");
	     insert("-..-", "x");
	     insert("-.--", "y");
	     insert("--..", "z");
	     insert("--.-", "q");
	 }
	 
	 /*
	  * @returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	  * used for testing to make sure tree is built correctly
	  */
	 public ArrayList<String> toArrayList() {
		 ArrayList<String> list = new ArrayList<>();
		 LNRoutputTraversal(root, list);
		 return list;
	 }
	 
	 /*
	  * The recursive method to put the contents of the linked converter tree in an ArrayList<String> in LNR (Inorder)
	  * @param root - the root of the tree for this particular recursive instance
	  * @param list - the ArrayList that will hold the contents of the tree in LNR order
	  */
	 public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		 if (root!=null) {
			 LNRoutputTraversal(root.left, list);
			 list.add(root.getData());
			 LNRoutputTraversal(root.right, list);
		 }
	 }
}
