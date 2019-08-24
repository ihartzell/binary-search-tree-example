public class Driver 
{
	public static void main(String[] args) 
	{
		BST<String> myTree = new BST<String>();
		
		// I'm making my ten string nodes.
		myTree.insert("Jack");
		myTree.insert("Kate");
		myTree.insert("Sawyer");
		myTree.insert("Hurley");
		myTree.insert("Sun");
		myTree.insert("Jhin");
		myTree.insert("Sayid");
		myTree.insert("Charlie");
		myTree.insert("Claire");
		myTree.insert("Aaron");
		
		System.out.println("Traversal tests for String list.");
		System.out.println("-------------------------------- ");
		System.out.println("\nInorder traversal test:  ");
		myTree.inorder();
		System.out.println();
		System.out.println("\nPreorder traversal test: ");
		myTree.preorder();
		System.out.println();
		System.out.println("\nPostorder traversal test: ");
		myTree.postorder();
		System.out.println();
		
		// Seeing the height of this tree.
		System.out.println("\nThe height of the tree is: " + myTree.height());
		
		//Testing breadthFirstTraversal
		System.out.println("\nBreadth first traversal: ");
		myTree.breadthFirstTraversal();
		
		//BST to integer test array.
		Integer[] nums = {1,2,4,6,7,8,9,-2,3,5};
		
		BST<Integer> numsList = new BST<Integer>(nums);
		
		// Testing tree traversal methods
		System.out.println("Traversal tests for Integer list.");
		System.out.println("--------------------------------- ");
		System.out.println("\nInorder traversal: ");
		numsList.inorder();
		System.out.println("\nPreorder traversal: ");
		numsList.preorder();
		System.out.println("\nPostorder traversal: ");
		numsList.postorder();
		
		// Seeing the height of this tree.
		System.out.println("\nThe height of the tree is: " + numsList.height());
		
		//Testing breadthFirstTraversal.
		System.out.println("\nBreadth first traversal: ");
		numsList.breadthFirstTraversal();
		
		//Seeing the height of this tree.
		System.out.println("\nHeight of tree: " + numsList.height());
		
		// Calling inorderImplementingStack for String tree.
		System.out.println("Stack tests.");
		System.out.println("------------");
		System.out.println("\nInorder using a stack of Strings:");
		myTree.inorderImplementingStack();
		
		//Calling height method.
		System.out.println("\nHeight of Tree: " + myTree.height());
		
		//Call inorderImplementingStack for Integer tree
		System.out.println("\nInorder using a stack of Integers:");
		numsList.inorderImplementingStack();
		
		//Calling height method
		System.out.println("\nHeight of Tree: " + numsList.height());
	}

}
