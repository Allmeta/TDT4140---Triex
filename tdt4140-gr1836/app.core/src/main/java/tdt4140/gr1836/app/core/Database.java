package tdt4140.gr1836.app.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.api.client.util.Sleeper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Database {

	
	User user = null;

	public void init() throws IOException {
	    try{
	        FirebaseApp.getInstance();
	    }
	    catch (IllegalStateException e)
	    {
		
		
		FileInputStream serviceAccount = new FileInputStream("tdt4140-g36-firebase-adminsdk-u74mt-fa295def3e.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://tdt4140-g36.firebaseio.com").build();

		FirebaseApp.initializeApp(options);
		System.out.println("did init ty");

		/*DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
		ref.addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot dataSnapshot) {
				Object res = dataSnapshot.getValue();
				System.out.println(res);
			}

			public void onCancelled(DatabaseError arg0) {
				// TODO Auto-generated method stub
				System.out.println("fk");

			}
		});*/

		// Pushe til database
		// DatabaseReference child=ref.push();
		// User test= new User("Johan", "Eple");
		// child.setValueAsync(test);
	    }
	}

	public User login(String username, String password) {
		// hash password, sjekk om de er stemmer med databasen
		// hvis ikke, returner null
		
		//NB: Har ikke implementert hashing enda!
		
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users/"+username);
		ref.addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot dataSnapshot) {
				User b=dataSnapshot.getValue(user.getClass());
				
				System.out.println(b);
				if (b != null) {
					//user = dataSnapshot.getValue(User.class);
					// user exists, check pw
					//will hash soon pls
					if (password != user.password) {
						//return null if login failed
						user=null;
						System.out.println("wrong password");
					}
				} else {
					// user does not exist. login failed.
					System.out.println("no reference");
					user=null;
				}
			}

			public void onCancelled(DatabaseError arg0) {
				// return fant ikke users wtf
				System.out.println("fk");

			}
		});
		return user;
	}

	public User register(String username,String name, int age, String city, String email, String adress,int phone, String password) {
		//hash password
		User newUser=new User(name, age, city, email, adress,phone, password);
		Map<String, User> k=new HashMap<>();
		k.put(username, newUser);
		//Send to database
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
		DatabaseReference s=ref.child(username);
		s.setValueAsync(newUser);
		return newUser;
	}
	public void deleteUser(String username) {
		//return null på /username for å fjerne data
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
		ref.child(username).setValueAsync(null);
	}
}
