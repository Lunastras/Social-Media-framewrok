/**
 * @author Radu Bucurescu.
 * - no copyright
 * @Version 1.0
 * 
 */

public class BSTNode {
	
	Profile data;
	
	BSTNode left;
	BSTNode right;
	
	/**
	 * Initializes the node.
	 * @param Profile of the node.
	 */
	public BSTNode(Profile data)
	{
		this.data = data;
	}
	
	/**
	 * Set the left node of the node.
	 * @param The left node.
	 */
	public void setLeft(BSTNode l)
	{
		left = l;
	}
	
	/**
	 * Set the right node of the node.
	 * @param The right node.
	 */
	public void setRight(BSTNode r)
	{
		right = r;
	}

	/**
	 * Returns the left node.
	 * @return Left node.
	 */
	public BSTNode getLeft()
	{
		return left;
	}
	
	/**
	 * Returns right left node.
	 * @return Right node.
	 */
	public BSTNode getRight()
	{
		return right;
	}
}
