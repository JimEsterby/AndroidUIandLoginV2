package com.psu.esterby.androiduiandlogin_esterby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends Activity {   // for maximum portability, extend AppCompatActivity

    // widgets for this activity
    private Button mButtonLogin;
    private Button mButtonSignup;
    private EditText mEditTextUser;
    private EditText mEditTextUserPassword;

    // Is it needed to have all the widgets in the class if they have no actions associated?
    private ImageView mImageViewVetFlag;
    private LinearLayout mLayoutButtons;
    private LinearLayout mLayoutUser;
    private LinearLayout mLayoutUserPassword;
    private TextView mLabelUser;
    private TextView mLabelUserPassword;
    private TextView mLabelOr;

    private ArrayList<UserProfile> profiles;
    private UserProfilePersistence upPersist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get widgets from the resource
        mButtonLogin = (Button)findViewById(R.id.buttonLogin);
        mButtonSignup = (Button)findViewById(R.id.buttonSignup);
        mEditTextUserPassword = (EditText)findViewById(R.id.editTextUserPassword);
        mEditTextUser = (EditText)findViewById(R.id.editTextUser);

        // no actions associated with these widgets
        mImageViewVetFlag = (ImageView)findViewById(R.id.imageViewFlag);
        mLayoutButtons = (LinearLayout)findViewById(R.id.button_wrapper);
        mLayoutUser = (LinearLayout)findViewById(R.id.user_id_wrapper);
        mLayoutUserPassword = (LinearLayout)findViewById(R.id.password_wrapper);
        mLabelUser = (TextView)findViewById(R.id.textViewUser);
        mLabelUserPassword = (TextView) findViewById(R.id.textViewUserPassword);
        mLabelOr = (TextView)findViewById(R.id.textViewOR);

        // Sign-up button will move user to sign-up activity
        mButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(SignUp);
            }
        });

        // Login button will move user to login success activity
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // load the database
        upPersist = new UserProfilePersistence(this);
        profiles = upPersist.getDataFromDB();
    }

    private void validateLogin() {

        UserProfile userProfile = null;

        if(profiles != null && !profiles.isEmpty()){

            String user = mEditTextUser.getText().toString();
            String password = mEditTextUserPassword.getText().toString();

            for (UserProfile up : profiles){
                if(up.getUserName().equals(user) ){
                    userProfile = up;
                }
                break;
            }
            if(userProfile == null){
                Toast.makeText(getApplicationContext(), R.string.not_found, Toast.LENGTH_LONG).show();
            }else {
                if(!userProfile.getPassword().equals(password)){
                    Toast.makeText(getApplicationContext(), R.string.incorrect_pass, Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    intent.putExtra("USER", userProfile.getUserName());
                    intent.putExtra("PASSWORD", userProfile.getPassword());
                    startActivity(intent);
                }
            }
        }
    }
}
