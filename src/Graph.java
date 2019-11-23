/**
 * @author Radu Bucurescu.
 * - no copyright
 * @Version 1.0
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
	
	String filename;
	BST users;
	static String ERROR_MSG;
	
	/**
	 * Makes 
	 * @param filename
	 * @param users
	 */
	public Graph(String filename, BST users)
	{
		ERROR_MSG = "ERROR.\nFile was not found.";
		this.users = users;
		this.filename = filename;
		readFriendList(filename);
	}
	
	/**
	 * Makes users on the line friends.
	 * @param "name1,name2".
	 */
	private void makeConnection(String line)
	{
		Scanner in = new Scanner(line);
		in.useDelimiter(",");
		
		Profile user1 = users.getProfileOfName(in.next());
		Profile user2 = users.getProfileOfName(in.next());
		
		if(user1 == null || user2 == null)
		{
			System.out.println("Profile doesn't exist.");
		}
		else
		{
			user1.addFriend(user2);
		}
		
	}
	
	/**
	 * Reads the friendlist.
	 * @param filename of the reading file.
	 */
	private void readFriendList(String filename)
	{
		try
		{
			Scanner in = new Scanner(new File(filename));
			
			while(in.hasNextLine()) 
			{
				makeConnection(in.nextLine());
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println(ERROR_MSG);
		}
	}
	
	/**
	 * Returns a list of friend recommendations for each user.
	 * @param users.
	 * @return recommendations in alphabetical order.
	 */
	public BST[] friendRecommendations(Profile[] users)
	{
		BST[] list = new BST[users.length];
		
		for(int i = 0; i < users.length; i++)
		{
			list[i] = new BST(null);
			for(int j = 0; j < users[i].numberOfFriends(); j++)
			{
				for(int k = 0; k < users[i].getFriend(j).numberOfFriends(); k++)
				{
					if(!users[i].hasFriend(users[i].getFriend(j).getFriend(k)))
					{
						if(users[i].getFriend(j).getFriend(k) != users[i])
						{
							list[i].insertProfile(users[i].getFriend(j).getFriend(k));
						}
					}
				}
			}
		}
		
		return list;
	}
	

}
