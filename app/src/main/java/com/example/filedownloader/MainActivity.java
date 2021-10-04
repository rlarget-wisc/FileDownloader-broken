package com.example.filedownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
    }

    class ExampleRunnable implements Runnable {
        @Override
        public void run() {
            mockFileDownloader();
        }
    }

    public void mockFileDownloader() {

        startButton.setText("DOWNLOADING...");

        for (int downloadProgress = 0; downloadProgress <= 100; downloadProgress+=10) {
            Log.d(TAG,"Download Progress: "+downloadProgress+"%");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startDownload(View view) {
        ExampleRunnable runnable = new ExampleRunnable();
        new Thread(runnable).start();
    }
}