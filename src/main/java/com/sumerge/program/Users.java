package com.sumerge.program;

import java.time.Clock;
import java.util.ArrayList;



public class Users {
ArrayList<User> Users= new ArrayList<User>();

public User AddUser(String ID, String Name, String Adress, String Email){
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
    }
 return null;
}

public ArrayList<User> ShowAll(){

    return Users;
}

public void DeleteUserById(String ID){
    boolean found=false;
   for(int i=0;i<Users.size();i++){
       if(Users.get(i).getID()==ID){
           Users.remove(i);
           found=true;
       }
   }
    if(!found){
        System.out.println("This user does not exsist");
    }
}

public String SearchUserById(String ID){
    boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getID()==ID){
                found=true;
                return Users.get(i).toString();
            }
        }
    if(!found){
        System.out.println("This user does not exsist");
    }
        return null;
}

    public String SearchUserByName(String Name){
        boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getName()==Name){
                found=true;
                return Users.get(i).toString();
            }
        }
        if(!found){
            System.out.println("This user does not exsist");
        }
        return null;
    }

    public String SearchUserByEmail(String Email){
        boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getEmail()==Email){
                found=true;
                return Users.get(i).toString();
            }
        }
        if(!found){
            System.out.println("This user does not exsist");
        }
        return null;
    }

    public String SearchUserByAdress(String Adress){
        boolean found=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getAdress()==Adress){
                found=true;
                return Users.get(i).toString();
            }
        }
        if(!found){
            System.out.println("This user does not exsist");
        }
        return null;
    }

    public void UpdateUser(String ID, String Name, String Email, String Adress){
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
        }
    }

}
