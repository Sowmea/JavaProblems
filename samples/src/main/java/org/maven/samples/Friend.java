package org.maven.samples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
    	//System.out.println(friend.getFriends());
    	//Iterator it = friend.getFriends().iterator();
    	/*Collection<Friend> connectedFriends = null;
        while (it.hasNext()) {
        	connectedFriends = (Collection<Friend>) it.next();
        	
        }*/
    	boolean connected = false;
    	List<String> connectedFriends = new ArrayList<>();
    	for(Friend f: this.getFriends()) {
    		connectedFriends.add(f.getEmail());
    	}
    	for(Friend f: friend.getFriends()) {
    		//System.out.println(f.getFriends());
    		
    			for(Friend f1: f.getFriends()) {
    				System.out.println(f1.getEmail());
    			}
    		//}
    		connected = connectedFriends.contains(f.getEmail());
    		if(connected) break;    		
    	}
        return connected;
    }
    
    private void recurseMutualFriends(Friend f) {
    	while(f.getFriends()!=null) {
    		for(Friend a:f.getFriends()) {
        		recurseMutualFriends(a);
        	}
    	}
    	
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");

        a.addFriendship(b);
        b.addFriendship(a);
        b.addFriendship(c);
        c.addFriendship(b);
        d.addFriendship(c);

        System.out.println(a.canBeConnected(d));
    }
}