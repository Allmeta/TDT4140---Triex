package tdt4140.gr1836.app.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tdt4140.gr1836.app.core.App;
import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.users.Users;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.Workouts;

public class Database {

	User user = null;

	public void init() throws IOException {
		try {
			FirebaseApp.getInstance();
		} catch (IllegalStateException e) {

			FileInputStream serviceAccount = new FileInputStream("tdt4140-g36-firebase-adminsdk-u74mt-fa295def3e.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://tdt4140-g36.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		}
	}

	public void login(String username, String password, App listenerApp) {
		// hash password, sjekk om de er stemmer med databasen
		// hvis ikke, returner null
		// listenerApp er appen som logger inn

		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users/" + username);
		ref.addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot dataSnapshot) {

				user = dataSnapshot.getValue(User.class);
				if (user != null) {
					// user exists, check pw
					// will hash soon pls
					String hashedPassword = Hash.hash(password, Hash.decodeSalt(user.getSalt()));
					if (!hashedPassword.equals(user.getPassword())) {

						// return null if login failed
						// setter listenerApp sin user og variabel for venting
						System.out.println("wrong password: ");
						listenerApp.setUser(null);
						listenerApp.setWaitForDatabase(false);
					} else {
						System.out.println("correct! logged in!!");
						listenerApp.setUser(user);
						listenerApp.setWaitForDatabase(false);
					}
				} else {
					// user does not exist. login failed.
					System.out.println("User does not exist.");
					listenerApp.setUser(null);
					listenerApp.setWaitForDatabase(false);
				}
			}

			public void onCancelled(DatabaseError arg0) {
				// return fant ikke users wtf
				System.out.println("fk");
				listenerApp.setWaitForDatabase(false);

			}
		});
	}

	public User register(String username, String name, int age, int height, int weight, String city, boolean isMale, 
			boolean isCoach, String password) {
		// hash password
		byte[] salt = null;
		try {
			salt = Hash.getSalt();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String hashedPassword = Hash.hash(password, salt);

		User user = new User(username, name, age, height, weight, city, isMale, isCoach, hashedPassword);

		user.setSalt(Hash.convertSalt(salt));

		// Send to database
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
		DatabaseReference s = ref.child(username);
		s.setValueAsync(user);
		return user;
		
	}

	public void deleteUser(String username) {
		// return null på /username for å fjerne data
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
		ref.child(username).setValueAsync(null);
	}
	public void getWorkouts(App listenerApp) {
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("workouts/"+listenerApp.getUser().getUsername());
		ref.addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot dataSnapshot) {
				if(dataSnapshot!=null) {
					listenerApp.setWorkouts(dataSnapshot.getValue(Workouts.class));
					listenerApp.setWaitForDatabase(false);
				}else {
					System.out.println("User has no workouts");
					listenerApp.setWorkouts(null);
					listenerApp.setWaitForDatabase(false);
				}
			}

			@Override
			public void onCancelled(DatabaseError arg0) {
				// TODO Auto-generated method stub
				listenerApp.setWaitForDatabase(false);
				
			}
		});
		
	}

	public void submitCardioWorkout(Workout cdw, App app) {
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("workouts");

		DatabaseReference s = ref.child(app.getUser().getUsername()).child(cdw.getType()).child(cdw.getDate());
		s.setValueAsync(cdw);
	}
	public void deleteWorkout(String username, String type, String date) {
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("workouts/"+username+"/"+type+"/"+date);
		ref.setValueAsync(null);
	}
	
	public void getUsers(App listenerApp){
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
		ref.addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot dataSnapshot) {
				if(dataSnapshot!=null) {
					listenerApp.setUsers(dataSnapshot.getValue(Users.class));
					listenerApp.setWaitForDatabase(false);
				}else {
					listenerApp.setUsers(null);
					listenerApp.setWaitForDatabase(false);
				}
									}

			@Override
			public void onCancelled(DatabaseError arg0) {
				// TODO Auto-generated method stub
				listenerApp.setWaitForDatabase(false);
				
			}
		});
	}
}
