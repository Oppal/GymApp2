package com.example.android.gymapp2;

public class gymInstructor extends Instructor {
    private int ID;
    private static String Firstname;
    private static String Lastname;
    private static String Nickname;
    private static String Image;
    private static String Current_gym;
    private static String Description;

    public gymInstructor(int ID, String Firstname, String Lastname, String Nickname, String Image, String Current_gym, String Description) {
        this.ID = ID;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Nickname = Nickname;
        this.Image = Image;
        this.Current_gym = Current_gym;
        this.Description = Description;
    }

    public int getID() {
        return ID;
    }

    public static String getFirstname() {
        return Firstname;
    }

    public static String getLastname() {
        return Lastname;
    }

    public static String getNickname() {
        return Nickname;
    }


    public static String getImage() {
        return Image;
    }

    public static String getCurrent_gym() {
        return Current_gym;
    }
    public static String getDescription() {
        return Description;
    }
}
