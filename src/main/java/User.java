import java.io.*;
import java.lang.*;
import java.util.*;


public class User {

    private static ArrayList<User> users = new ArrayList<User>();
    private String name;
    private String surname;
    private String username;
    private String password;


    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static boolean addUser(User user) {
        User.users.add(user);
        return true;
    }

    public static int getSize() {
        return User.users.size();
    }

    public static ArrayList<User> getUsers() {
        return users;
    }




    public User findUser(String username,String password){
        for (User user : User.users) {
            if (user.username.equals(username) && user.password.equals(password))
            {
                return user;
            }
        }
        return null;
    }
    


    public static Student getStudent(int am) {
        for (User user : User.users)
            if (user instanceof Student && (((Student) user).getAm() == am))
                return (Student) user;
        return null;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
