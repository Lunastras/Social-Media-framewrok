/**
 * @author Radu Bucurescu.
 * - no copyright
 * @Version 1.0
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	/**
	 * Reads the users from the respective file.
	 * @param Filename.
	 * @return BST with all users.
	 */
	public static BST readProfileSet(String filename)
	{
		try 
		{
			Scanner in = new Scanner(new File(filename));
			
			BST profiles = new BST(null);
			
			while(in.hasNextLine())
			{
				String p = in.nextLine();
			//	System.out.println(p);
				profiles.insertProfile(readProfile(p));
			}
			
			return profiles;			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Filename is invalid.");
			return null;
		}
	}
	
	/**
	 * Returns a profile made with the line.
	 * @param Line.
	 * @return The profile.
	 */
	private static Profile readProfile(String line)
	{
		Scanner in = new Scanner(line);
		in.useDelimiter(",");
		String firstname = in.next(), lastname = in.next();
		int day = in.nextInt(), month = in.nextInt(), year = in.nextInt();
		String town = in.next(), country = in.next(), nationality = in.next();
		String email = in.next();
		String[] interests = readInterests(in);
	
		return new Profile(lastname ,firstname, day, month, year, town, country,
				nationality, email, interests);	
	}
	
	/**
	 * Read the interests of the user.
	 * @param Used scanner.
	 * @return String[] with interests.
	 */
	private static String[] readInterests(Scanner in)
	{
		String[] interests = new String[99];
		
		in.useDelimiter(";");
		int i = 0; //index for interests
		String var; //current interest read
		
		while( in.hasNext())
		{
			var = in.next();
			interests[i] = var;
			i++;
		}
		
		return interests;
	}
}
