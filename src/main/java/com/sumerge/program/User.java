package com.sumerge.program;

public class User {
    private String ID;
    private String name;
    private String email;
    private String adress;

    public User(String ID, String Name,String email,String adress){
        this.ID = ID;
        this.name = Name;
        this.adress=adress;
        this.email=email;
    }


    public void setName(String name) {
        name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", Name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
