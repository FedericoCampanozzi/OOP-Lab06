package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	
	private Map<String, List<U>> friends;
	
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        friends = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    public boolean addFollowedUser(final String circle, final U user) {
    	
    	if(friends.containsKey(circle)) {
    		friends.get(circle).add(user);
    		return false;
    	}
    	else
    	{
    		friends.put(circle, new ArrayList<>());
    		friends.get(circle).add(user);
            return true;
    	}
    	
    }
    
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Collection<U> followed = new ArrayList<U>();
    	if(friends.containsKey(groupName)) {
    		
    		for(U usr : friends.get(groupName)) {
    			followed.add(usr);
        	}
    		
        	return followed;
        }
    	
    	//Se tra gli amici non c'e' group name
    	return followed;
    }

    public List<U> getFollowedUsers() {
        List<U> allFriends = new ArrayList<U>();
        
        for(String s : friends.keySet()) {
        	for(U usr : friends.get(s)) {
        		allFriends.add(usr);
        	}
        }
        
    	return allFriends;
    }
    
    /*
	@Override
	public String toString() {
		String s = "";
		for(String g : friends.keySet()) {
			s += g + " = ["; 
			for(U usr : friends.get(g)) {
				s += usr.getFirstName() + " ";
			}
			s += " ]\n";
		}
		return s;
	}
	*/
}
