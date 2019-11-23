/**
 * @author Radu Bucurescu.
 * - no copyright
 * @Version 1.0
 * 
 */

import java.util.ArrayList;

public class Profile {
	
	//Name of user.
	private String lastName;
	private String firstName;
	
	//Birthday of user.
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	
	//Nationality of user.
	private String townOfResidence;
	private String countryOfResidence;
	private String nationality;
	
	//Contant information.
	private String email;

	//User interests. 
	private String[] interests;
	
	//A list of all friends.
	private ArrayList<Profile> friends;
	
	public Profile(String lastName, String firstName, int birthDay, int birthMonth,
			int birthYear, String townOfResidence, String countryOfResidence, 
			String nationality, String email, String[] interests)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		
		this.townOfResidence = townOfResidence;
		this.countryOfResidence = countryOfResidence;
		this.nationality = nationality;
		
		this.email = email;
		this.interests = interests;
		
		friends = new ArrayList<Profile>();
	}
	
	/**
	 * Returns birthday of user.
	 * @return birthday in dd/mm/yyyy form.
	 */
	public String getBirthday()
	{
		return birthDay + "/" + birthMonth +
				"/" + birthYear;
	}
	
	/**
	 * Returns user's full name
	 * @return Name.
	 */
	public String getName()
	{
		return firstName + " " +
				lastName;
	}
	
	/**
	 * Return's user's town of residence.
	 * @return Town residence.
	 */
	public String getTown()
	{
		return townOfResidence;
	}
	
	/**
	 * Return's user's country of residence
	 * @return Country of residence.
	 */
	public String getCountry()
	{
		return countryOfResidence;
	}
	
	/**
	 * Returns user's nationality.
	 * @return Nationality.
	 */
	public String getNationality()
	{
		return nationality;
	}
	
	/**
	 * Returns user's interests in a String[] type variable.
	 * @return Interests.
	 */
	public String[] getInterests()
	{
		return interests;
	}
	
	
	/**
	 * Sets user's interests.
	 * @param Interests.
	 */
	public void setInterests(String[] interests)
	{
		this.interests = interests;
	}
	
	/**
	 * Sets user's country.
	 * @param Country.
	 */
	public void setCountry(String country)
	{
		this.countryOfResidence = country;
	}
	
	/**
	 * Sets user's town.
	 * @param Town.
	 */
	public void setTown(String town)
	{
		this.townOfResidence = town;
	}
	
	/**
	 * Sets user's nationality.
	 * @param Nationality.
	 */
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	
	/**
	 * Adds a friend into the user's friends list.
	 * @param Friend.
	 */
	public void addFriend(Profile friend)
	{
		friends.add(friend);
		boolean isAlreadyFriend = false;
		
		for(int i = 0; i < friend.numberOfFriends(); i++)
		{
			if(friend.getFriend(i) == this)
			{
				isAlreadyFriend = true;
				break;
			}
		}
		
		if(!isAlreadyFriend)
		{
			friend.addFriend(this);
		}		
	}
	
	/**
	 * Checks if the profile has the user in their friendlist.
	 * @param user
	 * @return Whether or not the user is a friend of the profile.
	 */
	public boolean hasFriend(Profile user)
	{
		for(Profile p: friends)
		{
			if(p == user)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns friend at index i.
	 * @param Index
	 * @return Friend at index i.
	 */
	public Profile getFriend(int i)
	{
		return friends.get(i);
	}
	
	/**
	 * Returns the number of friends from the user.
	 * @return Number of friends.
	 */
	public int numberOfFriends()
	{
		return friends.size();
	}
	
	/**
	 * Returns a general outlook of the profile in a string format.
	 * @return Profile's details.
	 */
	public String toString()
	{
		String interestsString = "";
		
		for(int i = 0; i < interests.length; i++)
		{
			interestsString += interests[i] + " ";
		}
		
		return getName() + " \n" + countryOfResidence + " " + 
				townOfResidence + " " + nationality + "\n" +
				"Interests: \n" + interestsString + "\n" +
				"Number of friends: " + friends.size();
	}
}
