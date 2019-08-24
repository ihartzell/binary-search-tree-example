public class TreeNode<E> 
{
	// A generic left node and a generic right node from the TreeNode class is created.
	protected E element;
	protected TreeNode<E> left;
	protected TreeNode<E> right;
	
	// a gernic variable is passed into this method and will be the element.
	public TreeNode(E e) 
	{
		element = e;
	}
	
	// Returns whatever the generic element is as a toString say "Jack" for instance.
	public String toString() 
	{
		return element.toString();
	}

}

