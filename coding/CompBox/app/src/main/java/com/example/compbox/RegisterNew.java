package com.example.compbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterNew extends AppCompatActivity {
EditText Fname,Lname,address,Emailadd,Phone,Username,Pass,Conpass;
AlertDialog ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new);
        Fname=(EditText)findViewById(R.id.fname);
        Lname=(EditText)findViewById(R.id.lname);
        address=(EditText)findViewById(R.id.address);
        Emailadd=(EditText)findViewById(R.id.mailadd);
        Phone=(EditText)findViewById(R.id.phonenumber);
        Username=(EditText)findViewById(R.id.uname);
        Pass=(EditText)findViewById(R.id.password);
        Conpass=(EditText)findViewById(R.id.cpass);
    }

    public void registernew(View view) {

        String type="register";
        String firstname=Fname.getText().toString();
        String lastname=Lname.getText().toString();
        String Address=address.getText().toString();
        String emailaddress=Emailadd.getText().toString();
        String PhoneNumber=Phone.getText().toString();
        String Uname=Username.getText().toString();
        String Password=Pass.getText().toString();
        String ConPass=Conpass.getText().toString();

        if(Password.equals(ConPass)) {


            BackgroundWorker bw = new BackgroundWorker(this);
            bw.execute(type, firstname, lastname,Address, emailaddress, PhoneNumber, Uname, Password);

        }
        else{
            ad=new AlertDialog.Builder(this).create();
            ad.setTitle("Alert");
            ad.setMessage("Password Dont Match");
            ad.show();

        }
    }
}
