package com.restuarants.smart.speechtotextwatsonv7;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "StT";

    private MediaPlayer mPlayer;
    private RecordWavMaster rwm;

    private String outputFilePath;

    private boolean isRecording = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rwm = new RecordWavMaster();
        setUpButtons();

    }

    private void setUpButtons() {
        Button recordButton = (Button) findViewById(R.id.recordButton);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordButtonPressed();
            }
        });

        Button menuButton = (Button) findViewById(R.id.etMenu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playButtonPressed();
            }
        });

        Button speechToTextButton = (Button) findViewById(R.id.speechToTextButton);
        speechToTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speechToTextButtonPressed();
            }
        });
    }

    private void recordButtonPressed() {
        Button recordButton = (Button) findViewById(R.id.recordButton);

        if (isRecording) {
            outputFilePath = rwm.recordWavStop();

            //stopRecording();
            recordButton.setText("Start Recording");
        } else {
            rwm.recordWavStart();
            //startRecording();
            recordButton.setText("Stop Recording...");
        }
        isRecording = !isRecording;
    }

    private void speechToTextButtonPressed() {
        new SpeechToTextTask().execute("");
    }

    private void playButtonPressed() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(outputFilePath);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

    }

    private class SpeechToTextTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
            long totalSize = 0;

            SpeechToText service = new SpeechToText();
            service.setUsernameAndPassword("b535f60e-dae2-4783-9e89-5ecaf85a468c", "UqbobaXOFPLX");

            RecognizeOptions options = new RecognizeOptions().contentType("audio/wav");

            try {
                File sdcard = Environment.getExternalStorageDirectory();

                File file = new File(outputFilePath);

                SpeechResults speechResults = service.recognize(file, options);

                Log.e(LOG_TAG, speechResults.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            return "";
        }

        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(String result) {

        }
    }

}