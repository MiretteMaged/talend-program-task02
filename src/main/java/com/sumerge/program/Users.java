package com.sumerge.program;

import java.time.Clock;
import java.util.ArrayList;



public class Users {
static ArrayList<User> Users= new ArrayList<User>();

public User addUser(String ID, String Name, String Adress, String Email){
    boolean found=false;
    for(int i=0;i<Users.size();i++){
        if(Users.get(i).getID()==ID){
            found=true;
        }
    }
    if(!found){
    User user = new User(ID,Name,Email,Adress);
    this.Users.add(user);
    return user;}
    else{
        System.out.println("Duplicate User");
        throw new IllegalArgumentException("Duplicate User");
    }
 //return null;
}

public ArrayList<User> showAll(){

    return Users;
}

public void deleteUserById(String ID){
    boolean found=false;
   for(int i=0;i<Users.size();i++){
       if(Users.get(i).getID()==ID){
           Users.remove(i);
           found=true;
       }
   }
    if(!found){
        System.out.println("This user does not exsist");
        throw new IllegalArgumentException("This user does not exsist");
    }
}

public String searchUserById(String ID){
    boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getID()==ID){
                found=true;
                return Users.get(i).toString();
            }
        }
    if(!found){
        System.out.println("This user does not exsist");
        throw new IllegalArgumentException("This user does not exsist");
    }
        return null;
}

    public String searchUserByName(String Name){
        boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getName()==Name){
                found=true;
                return Users.get(i).toString();
            }
        }
        if(!found){
            System.out.println("This user does not exsist");
            throw new IllegalArgumentException("This user does not exsist");
        }
        return null;
    }

    public String searchUserByEmail(String Email){
        boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getEmail()==Email){
                found=true;
                return Users.get(i).toString();
            }
        }
        if(!found){
            System.out.println("This user does not exsist");
            throw new IllegalArgumentException("This user does not exsist");
        }
        return null;
    }

    public String searchUserByAdress(String Adress){
        boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getAdress()==Adress){
                found=true;
                return Users.get(i).toString();
            }
        }
        if(!found){
            System.out.println("This user does not exsist");
            throw new IllegalArgumentException("This user does not exsist");
        }
        return null;
    }

    public void updateUser(String ID, String Name, String Email, String Adress){
    boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getID()==ID){
                found=true;
                Users.get(i).setName(Name);
                Users.get(i).setAdress(Adress);
                Users.get(i).setEmail(Email);

            }
        }
        if(!found){
            System.out.println("This user does not exsist");
            throw new IllegalArgumentException("This user does not exsist");
        }
    }

}
