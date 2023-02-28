package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class q4 extends AppCompatActivity {

    String filename = "MORLOT--PINTAMORVAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        Button ok = findViewById(R.id.button);
        File dir = getFilesDir();
        File file = new File(dir, "MORLOT--PINTAMORVAN");
        String fileContents = "Bonjour Mme FEUILLATRE";
        ok.setOnClickListener(view -> {
            try{
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(fileContents.getBytes());
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    void save(String content, String filename, Context context){
        File file = new File(context.getFilesDir(),filename);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void cancel(View v){
        EditText editableText = (EditText) findViewById (R.id.b);
        FileInputStream fis = null;
        try{
            fis = openFileInput("MORLOT--PINTAMORVAN");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }
            editableText.setText(sb.toString());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try{
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    String fetchFileContent(Context context, String filename){
        File file = new File(context.getFilesDir(),filename);
        if(file.exists()){
            try{
                FileInputStream fis = new FileInputStream(file);
                fis.read();
                fis.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return "File not found";
    }

}