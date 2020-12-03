package com.father_in_law.artisan_s_workplace.Util.Firebase;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseUtil {

    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static FirebaseAuth getAuth(){
        return mAuth;
    }
}
