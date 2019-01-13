package com.example.huangkl.exam_gimmatek;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String SYMBOL_SEMICOLON = ";";
    private final static String SYMBOL_COMMA = ",";
    private Button mSignInButton;
    private Button mSignUpButton;
    private Button mForgetPasswordButton;
    private TextView mVersionTextView;
    private EditText mAccountEditText;
    private EditText mPasswordEditText;
    private Spinner mTestAccountSpinner;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSignInButton = findViewById(R.id.sign_in_button);
        mSignUpButton = findViewById(R.id.sign_up_button);
        mForgetPasswordButton = findViewById(R.id.forget_password_button);
        mVersionTextView = findViewById(R.id.version_text_view);
        mAccountEditText = findViewById(R.id.account_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mVersionTextView.setText(BuildConfig.VERSION_NAME);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isAccountCorrect = mAccountEditText.getText().toString().equals(getString(R.string.test_id));
                boolean isPasswordCorrect = mPasswordEditText.getText().toString().equals(getString(R.string.test_password));

                if (isAccountCorrect && isPasswordCorrect) {
                    Toast.makeText(getApplication(), R.string.signIn_test_ok, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplication(), R.string.signIn_test_fail, Toast.LENGTH_LONG).show();
                }
            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SignUpAccountActivity.newIntent(MainActivity.this));
            }
        });
    }
}
