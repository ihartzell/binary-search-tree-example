import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BST <E extends Comparable<E>> 
{

	protected TreeNode<E> root;
	protected int size = 0;
	
	public BST() 
	{ 
		
	}
	
	public BST(E[] objects) 
	{
		for (int i=0; i<objects.length; i++) 
		{
			insert(objects[i]);
		}
	}
	
	public boolean search(E e) 
	{
		TreeNode<E> current = root;
		
		while (current != null) 
		{
			if (e.compareTo(current.element) < 0) 
			{
				current = current.left;
			} 
			else if (e.compareTo(current.element) > 0) 
			{
				current = current.right;
			} 
			else 
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean insert(E e) 
	{
		if (root == null) 
		{
			root = createNewNode(e);
		}
		else 
		{
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			
			while (current != null) 
			{
				if (e.compareTo(current.element) < 0) 
				{
					parent = current;
					current = current.left;
				} 
				else if (e.compareTo(current.element) > 0) 
				{
					parent = current;
					current = current.right;
				} 
				else 
				{
					return false;
				}
			}
				
			if (e.compareTo(parent.element) < 0) 
			{
				parent.left = createNewNode(e);
			} 
			else 
			{
				parent.right = createNewNode(e);
			}
		}
		size++;
		return true;
	}
	
	protected TreeNode<E> createNewNode(E e) 
	{
		return new TreeNode<E>(e);
	}
	
	public void inorder() 
	{
		inorder(root);
	}
	
	protected void inorder(TreeNode<E> root) 
	{
		if (root == null) 
		return;
		inorder(root.left);
		System.out.print(root.element + ", ");
		inorder(root.right);
	}
	
	public void postorder() 
	{
		postorder(root);
	}
	
	protected void postorder(TreeNode<E> root)
	{
		if (root == null) 
		return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + ", ");
	}
	
	public void preorder() 
	{
		preorder(root);
	}
	
	protected void preorder(TreeNode<E> root) 
	{
		if (root == null) 
		return;
		System.out.print(root.element + ", ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public TreeNode<E> getRoot() 
	{
		return root;
	}
	
	public ArrayList<TreeNode<E>> path(E e) 
	{
		ArrayList<TreeNode<E>> list = new ArrayList<>();
		TreeNode<E> current = root;
		
		while (current != null) 
		{
			list.add(current);
			
			if (e.compareTo(current.element) < 0) 
			{
				current = current.left;
			} 
			else if (e.compareTo(current.element) > 0) 
			{
				current = current.right;
			} 
			else 
			{
				break;
			}
		}
		
		return list;
	}
	
	public boolean delete(E e) 
	{
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		
		while (current != null) 
		{
			if (e.compareTo(current.element) < 0) 
			{
				parent = current;
				current = current.left;
			} 
			else if (e.compareTo(current.element)> 0) 
			{
				parent = current;
				current = current.right;
			}
			else 
			{
				break;
			}
		}
		
		if (current == null)
		{
			return false;
		}
		
		if (current.left == null)
		{
			if (parent == null) 
			{
				root = current.right;
			} 
			else 
			{
				if (e.compareTo(parent.element) < 0) 
				{
					parent.left = current.right;
				} 
				else 
				{
					parent.right = current.right;
				}
			}
		} 
		else 
		{
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null) 
			{
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			current.element = rightMost.element;
			
			if (parentOfRightMost.right == rightMost) 
			{
				parentOfRightMost.right = rightMost.left;
			} 
			else
			{
				parentOfRightMost.left = rightMost.left;
			}
		}
		
		size--;
		return true;
	}
	
	public Iterator<E> iterator()
	{
		return new InorderIterator();
	}
	
	public void clear() 
	{
		root = null;
		size = 0;
	}
	
	
	private class InorderIterator implements Iterator<E> 
	{
		
		private ArrayList<E> list = new ArrayList<>();
		private int current = 0;
		
		public InorderIterator() 
		{
			inorder();
		}
		
		private void inorder() 
		{
			inorder(root);
		}
		
		private void inorder(TreeNode<E> root) 
		{
			if (root == null) 
			return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		
		public boolean hasNext() 
		{
			return current < list.size();
		}
		
		public E next() 
		{
			return list.get(current++);
		}
		
		public void remove() 
		{
			delete(list.get(current));
			list.clear();
			inorder();
		}
	}
	public void breadthFirstTraversal()
	{
		// I'm making a new generic list
		List<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
		
		// if the root node is nothing
		if(root != null)
		{
			// add root to the list and create a generic TreeNode variable which is the present.
			list.add(root);
			TreeNode<E> present;
			
			// As long as this list is empty.
			while(!list.isEmpty())
			{
				// The present variable is assigned as the list removing the first element in the list.
				present = (TreeNode<E>) list.remove(0);
				System.out.println(present.element + " ");
				
				// If the present left node is nothing
				if(present.left != null)
				{
					// Add the present left node
					list.add(present.left);
				}
				//If the present right node is nothing
				if(present.right != null)
				{
					//Add the present right node.
					list.add(present.right);
				}
			}
		}
	}
	//Returns the second height method with the root node as the argument.
	public int height()
	{
		return height(root);
	}
	//I'm passing a generic tree node which is the root node.
	private int height(TreeNode<E> root)
	{
		// if the root or starting node is nothing I return nothing
		if(root == null)
		{
			return 0;
		}
		// Otherwise I return 1 + the maximum height of the root to the left and the root to the right.
		else
		{
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}
	
	//I'm calling for my second inorderImplementingStack method with the root node as the argument
	//This is an overloaded method.
	public void inorderImplementingStack()
	{
		inorderImplementingStack(root);
	}
	private void inorderImplementingStack(TreeNode<E> root)
	{
		// I'm creating a gerneric tree node stack.
		Stack<TreeNode<E>> myStack = new Stack<TreeNode<E>>();
		
		// As longs as this stack has something or the root node is something
		while(!myStack.isEmpty() || root != null)
		{
			// if the root node is something
			if(root != null)
			{
				// I push the root node onto the stack
				// Then I assign the root node as the root node to the left.
				myStack.push(root);
				root = root.left;
			}
			//Otherwise...
			else
			{
				//I assign the root node to what's been popped of the stack.
				// Then I print out this element and assign the root node to the root node on the right.
				root = myStack.pop();
				System.out.println(root.element + " ");
				root = root.right;
			}
		}
	}
}

