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
    public static boolean status = false;
    public static void newUserWithId(int userId , int debtHour){

    }

    public static boolean checkIfUserExist(int userId){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(""+userId);
        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                if(value != null) {
                    Log.d(TAG, "Value is: " + value);
                    status =true;
                }else {
                    Log.d(TAG,"null value or refrence not found");
                    status = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG,"failure :"+databaseError.getMessage());
            }
        });
        return status;

    }

    public static int getUserDebtFromId(int userId){
    return 0;
    }
// TODO: 10/8/2016 implement sync adapter and complete firebase integration
}