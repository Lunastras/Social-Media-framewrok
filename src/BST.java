/**
 * @author Radu Bucurescu.
 * - no copyright
 * @Version 1.0
 * 
 */

public class BST {
	
	BSTNode root;
	int index;
	int numberOfProfiles;
	
	/**
	 * Root of the tree.
	 * @param Root.
	 */
	public BST(BSTNode root)
	{
		numberOfProfiles = 0;
		this.root = root;
	}
	
	/**
	 * Inserts new profile in the tree alphabetically.
	 * @param Profile to be added.
	 * @param Current node we are checking.
	 */
	private void insertProfile(Profile p, BSTNode node)
	{
		if (node.data.getName().compareTo(p.getName()) < 0)
		{
			if(node.getRight() != null)
			{
				insertProfile(p, node.getRight());
			}
			else
			{
				node.setRight(new BSTNode(p));
			}
		}
		else
		{
			if(node.getLeft() != null)
			{
				insertProfile(p, node.getLeft());
			}
			else
			{
				node.setLeft(new BSTNode(p));
			}
		}
	}
	
	/**
	 * Inserts profile into the BST.
	 * @param Profile to be added.
	 */
	public void insertProfile(Profile p)
	{
		numberOfProfiles++;
		BSTNode node = new BSTNode(p);
		
		if(root == null)
		{
			root = node;
		}
		else
		{
			//Checks if user if already in the BST. If so, it will not insert it.
			if(this.getProfileOfName(p.getName()) == null)
			{
				insertProfile(p, root);
			}
			else
			{
				System.out.println(p.getName() + "is already in the BST");
			}
		}
	}
	
	/**
	 * Prints out the list of users alphabetically.
	 */
	public void printAlphabetical()
	{
		printNode(root);
	}
	
	/**
	 * In-order traversal of the BST and output of every name 
	 * in an alphabetical order.
	 * @param Start node.
	 */
	private void printNode(BSTNode node)
	{
		
		if(node.getLeft() != null)
		{
			printNode(node.getLeft());
		}
		
		System.out.println(node.data.getName());
		
		if(node.getRight() != null)
		{
			printNode(node.getRight());
		}
	}
	
	/**
	 * Makes an array of all profiles in the BST.
	 * @return The array with the profiles.
	 */
	public Profile[] getProfileArray()
	{
		Profile[] users = new Profile[numberOfProfiles];
		
		index = 0;
		makeProfileArray(users, root);
		
		return users;
		
	}
	
	/**
	 * Makes the profile array.
	 * @param The array.
	 * @param The starting node.
	 */
	private void makeProfileArray(Profile[] users, BSTNode node)
	{	
		if(node.getLeft() != null)
		{
			makeProfileArray(users, node.getLeft());
		}
		
		users[index] = node.data;
		index++;
				
		if(node.getRight() != null)
		{
			makeProfileArray(users, node.getRight());
		}
	}
	
	/**
	 * Returns the profile of the respective name from the BST.
	 * @param Name.
	 * @return The profile of the name.
	 */
	public Profile getProfileOfName(String name)
	{
		return findUserOfName(name, root);
	}
	
	/**
	 * Searches the BST for the profile.
	 * @param Name.
	 * @param Starting node.
	 * @return The desired profile.
	 */
	private Profile findUserOfName(String name, BSTNode node)
	{
		if(node.data.getName().equals(name))
		{
			return node.data;
		}
		else
		{
			Profile left = null;;
			Profile right = null;
			
			if(node.getLeft() != null)
			{
				left = findUserOfName(name, node.getLeft());
			}
			
			if(node.getRight() != null)
			{
				right = findUserOfName(name, node.getRight());
			}
			
			if(left != null)
			{
				return left;
			}
			else
				if(right != null)
				{
					return right;
				}
				else
				{
					return null;
				}
		}
	}
}
