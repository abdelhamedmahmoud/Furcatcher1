package com.example.dell.furcatcher1;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;

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

/**
 * Created by KeMoOo on 11/28/2016.
 */

public class BackgroundDB_helper extends AsyncTask<String , String , String> {
     Context context ;
    BackgroundDB_helper (Context ctx)
    {
        context= ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String Db_url= "https://furcatcher.000webhostapp.com/login.php";
        String Db_url2= "https://furcatcher.000webhostapp.com/signup.php";

        if(type.equals("login"))
        {
            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(Db_url);
                HttpURLConnection httpURLConnection  = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ////////////output Stream
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream , "UTF-8"));
                String post_data =
                          URLEncoder.encode("user_name" ,"UTF-8") + "="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        + URLEncoder.encode("password" ,"UTF-8") + "="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /////////////////////////

                ////////// input Stream
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream , "iso-8859-1"));
                String result = "" ;
                String line = "";
                while((line = bufferedReader.readLine())!= null)
                {
                    result += line ;
                }
             bufferedReader.close();
                inputStream.close();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (type.equals("SignUp"))
        {
            try {
                String user_name = params[1];
                String password = params[2];
                String email= params[3];
                URL url = new URL(Db_url2);
                HttpURLConnection httpURLConnection  = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream , "UTF-8"));
                String post_data =
                          URLEncoder.encode("user_name" ,"UTF-8") + "="+URLEncoder.encode( user_name,"UTF-8")+"&"
                        + URLEncoder.encode("password" ,"UTF-8") + "="+URLEncoder.encode( password, "UTF-8" )+"&"
                        + URLEncoder.encode("email" ,"UTF-8") +"="+URLEncoder.encode( email, "UTF-8") ;

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream ,"iso-8859-1"));

                String Line = "" ;
                String result = "" ;
                while((Line = bufferedReader.readLine())!= null)
                {
                    result += Line ;
                }
                bufferedReader.close();
                inputStream.close();

                return result;

            } catch (MalformedURLException e) {
              System.out.print(e);  e.printStackTrace();
            } catch (IOException e) {
                System.out.print(e);
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setMessage(s)
                .setTitle("Registration Status")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
        Log.d("message:", s);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
