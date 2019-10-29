package com.example.compbox;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {


    Context context;
    AlertDialog ad;

    BackgroundWorker(Context ctx) {
        context = ctx;

    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];


        if (type.equals("login")) {
            String login_url = "http://10.0.2.2/compbox/join.php";
            String Username = params[1];
            String Password = params[2];

            try {
                URL url = new URL(login_url);
                HttpURLConnection hr = (HttpURLConnection) url.openConnection();
                hr.setRequestMethod("POST");

                hr.setDoOutput(true);
                hr.setDoInput(true);
                OutputStream os = hr.getOutputStream();
                BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String PostData = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(Username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");
                br.write(PostData);

                br.flush();
                br.close();
                os.close();
                InputStream is = hr.getInputStream();
                BufferedReader buffRead = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = buffRead.readLine()) != "Null") {
                    result += line;
                    break;
                }
                buffRead.close();
                is.close();
                hr.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("register")) {
            String reg_url = "http://10.0.2.2/compbox/registration.php";
            String Fname = params[1];
            String Lname = params[2];
            String Address = params[3];
            String Emailadd = params[4];
            String Phonenum = params[5];
            String Username = params[6];
            String Password = params[7];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection hr = (HttpURLConnection) url.openConnection();
                hr.setRequestMethod("POST");

                hr.setDoOutput(true);
                hr.setDoInput(true);
                OutputStream os = hr.getOutputStream();
                BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String PostData = URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(Fname, "UTF-8") + "&"
                        + URLEncoder.encode("lname", "UTF-8") + "=" + URLEncoder.encode(Lname, "UTF-8") + "&"
                        + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(Address, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(Emailadd, "UTF-8") + "&"
                        + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(Phonenum, "UTF-8") + "&"
                        + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(Username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");
                br.write(PostData);


                br.flush();
                br.close();
                os.close();

                InputStream is = hr.getInputStream();
                BufferedReader buffRead = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = buffRead.readLine()) != "Null") {
                    result += line;
                    break;


                }
                buffRead.close();
                is.close();
                hr.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        ad = new AlertDialog.Builder(context).create();
        ad.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Login success")) {
            ad.setMessage(result);
            ad.show();
            Intent gotodash = new Intent(context.getApplicationContext(), Dashboard.class);
            context.startActivity(gotodash);
        } else if (result.equals("Login Failed")) {
            ad.setMessage(result);
            ad.show();
        } else if (result.equals("Register Success")) {
            ad.setMessage(result);
            ad.show();

        } else {
            ad.setMessage(result);
            ad.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
