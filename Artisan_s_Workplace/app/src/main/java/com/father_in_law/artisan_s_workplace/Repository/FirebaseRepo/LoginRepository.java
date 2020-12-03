package com.father_in_law.artisan_s_workplace.Repository.FirebaseRepo;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.father_in_law.artisan_s_workplace.Util.Firebase.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginRepository{

    public interface FirebaseLoginListener{
        void onSuccess();
        void onError();
    }

    private FirebaseAuth mAuth;
    private FirebaseLoginListener listener;
    private Activity activity;

    public LoginRepository(FirebaseLoginListener listener, Activity activity) {
        this.mAuth = FirebaseUtil.getAuth();
        this.activity = activity;
        this.listener = listener;
    }

    public void firebaseSignup(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(activity, user.getEmail()+"으로 가입되었습니다.", Toast.LENGTH_SHORT).show();
                            listener.onSuccess();
                        } else {
                            listener.onError();
                        }
                    }
                });
    }

    public void firebaseLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            listener.onSuccess();
                        } else {
                            listener.onError();
                        }
                    }
                });
    }
}
