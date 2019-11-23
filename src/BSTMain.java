
public class BSTMain {
	
	public static void main(String[] args)
	{
		FileReader reader = new FileReader();
		BST list = reader.readProfileSet("Profiles.txt");
		Graph g = new Graph("Friendships.txt", list);
				
		Profile[] users = list.getProfileArray();
		
		System.out.println("The profiles in the BST are:");
		list.printAlphabetical();
	}

}
