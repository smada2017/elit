package com.example.saimada.shelterfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    EditText ed1,ed2, ed3;
    Button b1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        ed3 = (EditText)findViewById(R.id.editText3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( ed3.getText().toString().compareTo(ed2.getText().toString()) == 0) {
                    createAccount(ed1.getText().toString(),ed2.getText().toString());
                }else {
                    ed3.setError("Passwords Don't Match");
                    //refresh editText fields
                }
            }

        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    private void createAccount(String s, String s1) {
        mAuth.createUserWithEmailAndPassword(s,s1);
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password);
    }

}
