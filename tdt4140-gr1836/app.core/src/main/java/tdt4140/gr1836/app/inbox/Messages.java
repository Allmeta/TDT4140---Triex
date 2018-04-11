package tdt4140.gr1836.app.inbox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@SuppressWarnings("serial")
public class Messages implements Serializable{
	public Map<String,Message> messages;
	public Messages() {
		
	}
	public ArrayList<Message> toList() {
		if(messages==null) {
			return null;
		}
		ArrayList<Message> temp=new ArrayList<Message>();
		for(String key : this.messages.keySet()) {
			temp.add(this.messages.get(key));
		}
		//sorter etter dato
		temp.sort((o1,o2)->o1.getDate().compareTo(o2.getDate()));
		return temp;
	}
}
