package com.example.kom.zestaw2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kom on 2017-05-30.
 */
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class Zadanie7 extends AppCompatActivity {

    private MediaRecorder myAudioRecorder;
    private MediaPlayer mediaPlayer;
    private static String mFileName = "raw/MyRec.3gp";
    private static final int RECORD_REQUEST_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie7);

    }


    public void zapis(View view) throws IOException
    {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED || permissionCheck2 != PackageManager.PERMISSION_GRANTED)
        {
            Log.i(mFileName, "Permission to record denied");
            makeRequest();
        }
        else
        {
            startRec();
        }
    }

    protected void makeRequest ()
    {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, RECORD_REQUEST_CODE);
    }

    public void onRequestPermissionsResult( int requestCode , String permissions[] , int[] grantResults) {
        switch (requestCode) {
            case RECORD_REQUEST_CODE: {
                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(mFileName, "Permission has been denied by user");
                } else {
                    Log.i(mFileName, "Permission has been granted by user");

                    try {
                        startRec();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return;
            }
        }
    }
    public void stopRec(View view) {
        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder = null;

    }

    public void startRec() throws IOException {
        myAudioRecorder = new MediaRecorder();
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(mFileName);

        myAudioRecorder.prepare();
        myAudioRecorder.start();


    }

    public void playRec(View view) throws IOException
    {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(mFileName);
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    public void powrot(View v)
    {
        this.finish();
    }
}