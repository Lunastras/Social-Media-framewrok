
public class GraphMain {
	
	public static void main(String[] args)
	{
		FileReader reader = new FileReader();
		BST list = reader.readProfileSet("Profiles.txt");
		Graph g = new Graph("Friendships.txt", list);
				
		Profile[] users = list.getProfileArray();
		
		System.out.println("The profiles in the BST are:");
		list.printAlphabetical();
		
		System.out.println();
		
		BST[] recom = g.friendRecommendations(users);
			
		for(int i = 0; i < recom.length; i++)
		{
			System.out.println("The recommended friends for " + users[i].getName() + " are:");
			recom[i].printAlphabetical();
			System.out.println();
		}	
 	}

}
