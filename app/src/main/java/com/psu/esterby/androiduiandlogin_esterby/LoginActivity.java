package com.psu.esterby.androiduiandlogin_esterby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends Activity {

    // widgets for this activity
    private ImageView mImageViewVetFlag;
    private Button mButtonLogin;
    private Button mButtonSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get widgets from the resource
        mImageViewVetFlag = (ImageView)findViewById(R.id.imageViewFlag);
        mButtonLogin = (Button)findViewById(R.id.buttonLogin);
        mButtonSignup = (Button)findViewById(R.id.buttonSignup);

        // Sign-up button will move user to sign-up activity
        mButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(SignUp);
            }
        });
    }
}
