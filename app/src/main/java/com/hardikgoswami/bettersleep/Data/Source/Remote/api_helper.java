package com.hardikgoswami.bettersleep.Data.Source.Remote;


//// TODO: 10/7/2016 add firebase instance and helper to update data to web and fetch data from web

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class api_helper{
    public static final String TAG = "BETTERSLEEP";
    public static void newUserWithId(int userId , int debtHour){

    }

    public static boolean checkIfUserExist(int userId){
        return false;
    }

    public static int getUserDebtFromId(int userId){
    return 0;
    }

}