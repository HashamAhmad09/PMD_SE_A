package com.example.myapplication.AsynTaskClassExamples;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class WebContentDownloadMianActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content_download_mian);
        editText =findViewById(R.id.edtmultilineweb);
    }

    public void Download_WebContent(View view) {
        DownloadWebCOntent obj = new DownloadWebCOntent();
        try {
            String webContent=obj.execute("https://wwww.google.com").get();
            Log.d("TAG","Back in Mian Activity");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class DownloadWebCOntent extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            Log.d("TAG","DoInBackground in Progress....");
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                InputStreamReader reader= new InputStreamReader(inputStream);
                int data=reader.read();
                String webContent=" ";
                while (data!=-1)
                {
                    char c = (char) data;
                    webContent +=c;
                    data=reader.read();
                }
                return webContent;
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}