package tdt4140.gr1836.app.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import tdt4140.gr1836.app.core.App;
import tdt4140.gr1836.app.core.User;

public class DummyApp extends App {
	private User user;
	private User correctUser;
	private File file;
	
	
	public DummyApp() throws IOException {
		this.user=null;
		this.correctUser=new User("Mr.TestFx", 20, "Trondheim", "hasselhoff@yahoo", "computer","1234", "test");
		
	}
	public void register(String username,String name, int age, String city, String email, String address,String phone, String password) {
		/*JSONObject user = new JSONObject();
        user.put("Username", username);  
        user.put("Name", name);  
        user.put("Age", age);  
        user.put("City", city);  
        user.put("email", email);  
        user.put("Address", address);  
        user.put("Phone", phone);  
        user.put("Password", password);  
        
	    try {
	        FileWriter fileWriter = new FileWriter("users.json");
	        fileWriter.write(user.toString());  
	        fileWriter.flush();  
	        fileWriter.close(); 
	        
	    } catch (IOException e) {
	        e.printStackTrace();  
	        }
	        */
		System.out.println("Register");
		
	}
	public User login(String username, String password) {
		/*String line = null;
		this.user=null;
       try {
            FileReader fileReader = 
                new FileReader("users.txt");

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(line.startsWith(username) && (line.endsWith(password))) {
                	System.out.println(line);
                }
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" );                  
        }
		return this.user;
		*/
		if(username.equals("testFxBoy") && password.equals("test")) {
			return correctUser;
		}
		else {
			return user;
		}
		
	}
	public void deleteUser(String username) {
		/*
		String line = null;
       try {
            FileReader fileReader = 
                new FileReader("users.txt");

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(line.startsWith(username)) {
                	//må slette
                	System.out.println(line);
                }
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" );                  
        }
        */
		System.out.println("Delete user");
		this.correctUser=null;
		
	}


}
