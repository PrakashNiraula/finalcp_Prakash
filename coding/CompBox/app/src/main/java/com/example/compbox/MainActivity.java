package com.example.compbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button loginbtn;
    // Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);
        loginbtn = (Button) findViewById(R.id.btnlogin);
    }

    public void loginmethod(View view) {

        String usernmae = user.getText().toString();
        String password = pass.getText().toString();
        String type = "login";

        BackgroundWorker bw = new BackgroundWorker(this);
        bw.execute(type, usernmae, password);


    }

    public void gotoreg(View view) {


        Intent gotodash = new Intent(this.getApplicationContext(), RegisterNew.class);
        this.startActivity(gotodash);
    }

    public void submitanon(View view) {
    }
}
