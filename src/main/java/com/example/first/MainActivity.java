package com.example.first;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {
    String tiedosto, merkkijono;
    EditText nameInput, fileInput;
    TextView text;
    Button save, load;
    Context context = null;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        nameInput = (EditText) findViewById(R.id.nameInput);
        fileInput = (EditText) findViewById(R.id.fileInput);
        load = (Button) findViewById(R.id.load);
        save = (Button) findViewById(R.id.save);
        context = MainActivity.this;

}



    public void readFile(View v){
        try {
            tiedosto = nameInput.getText().toString();
            InputStream ins = context.openFileInput(tiedosto);
            String s;

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));

            while ((s = br.readLine()) != null) {
                text.setText(s);
            }
            ins.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä.");
        }
    }


    public void writeFile(View v){
        try{
            tiedosto = nameInput.getText().toString();
            fileInput.setVisibility(View.VISIBLE);
            System.out.println("KANSION SIJAINTI: "+ context.getFilesDir());
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(tiedosto, Context.MODE_PRIVATE));
            merkkijono = getTextToFile();
            System.out.println(merkkijono);
            ows.write(merkkijono);
            ows.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä.");
        }
    }

    public String getTextToFile(){
    merkkijono = fileInput.getText().toString();
    return merkkijono;
    }
}








