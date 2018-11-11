package com.psu.esterby.androiduiandlogin_esterby;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {

    // widgets
    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextUserName;
    private EditText mEditTextBirthday;
    private EditText mEditTextPhone;  // mobile
    private EditText mEditTextMail;  // Email
    private EditText mEditTextPassword;
    private Button mButtonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEditTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        mEditTextLastName = (EditText) findViewById(R.id.editTextLastName);
        mEditTextUserName = (EditText) findViewById(R.id.editTextUserName);
        mEditTextBirthday = (EditText) findViewById(R.id.editTextBirthday);
        mEditTextPhone = (EditText) findViewById(R.id.editTextMobile);
        mEditTextMail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mButtonConfirm = (Button) findViewById(R.id.buttonConfirm);
    }
}
