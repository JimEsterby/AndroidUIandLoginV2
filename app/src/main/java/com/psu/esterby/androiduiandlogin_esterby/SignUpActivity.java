package com.psu.esterby.androiduiandlogin_esterby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity implements View.OnClickListener {

    // widgets
    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextUserName;
    private EditText mEditTextBirthday;
    private EditText mEditTextPhone;  // mobile
    private EditText mEditTextMail;  // Email
    private EditText mEditTextPassword;
    private Button mButtonConfirm;

    private UserProfilePersistence upp;  // database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // map resource ID's to activity fields
        mEditTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        mEditTextLastName = (EditText) findViewById(R.id.editTextLastName);
        mEditTextUserName = (EditText) findViewById(R.id.editTextUserName);
        mEditTextBirthday = (EditText) findViewById(R.id.editTextBirthday);
        mEditTextPhone = (EditText) findViewById(R.id.editTextMobile);
        mEditTextMail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mButtonConfirm = (Button) findViewById(R.id.buttonConfirm);

        mButtonConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonConfirm)
        {
            if (checkInputs() == true)
            {
                // TODO - add to database
                String first_name = mEditTextFirstName.getText().toString();
                String last_name = mEditTextLastName.getText().toString();
                String user_name = mEditTextUserName.getText().toString();
                String email_addr = mEditTextMail.getText().toString();
                String phone = mEditTextPhone.getText().toString();
                String birthday = mEditTextBirthday.getText().toString();
                String password = mEditTextPassword.getText().toString();

                UserProfile new_user = new UserProfile(first_name,
                        last_name,
                        user_name,
                        birthday,
                        phone,
                        email_addr,
                        password);

                upp.insert(new_user);

                Toast.makeText(getApplicationContext(), R.string.user_added, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            else
            {
                Toast.makeText(getApplicationContext(), R.string.missing_data, Toast.LENGTH_SHORT).show();
           }


        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        upp = new UserProfilePersistence(this);
    }

    // check to see if user has provided the required fields.  This could be much more robust...
    private boolean checkInputs() {
        boolean retval = true;
        
        if (mEditTextFirstName.getText().length() == 0) retval = false;
        else if (mEditTextLastName.getText().length() == 0) retval = false;
        else if (mEditTextUserName.getText().length() == 0) retval = false;
        else if (mEditTextMail.getText().length() == 0) retval = false;
        else if (mEditTextPassword.getText().length() == 0) retval = false;

        return retval;
    }
}
