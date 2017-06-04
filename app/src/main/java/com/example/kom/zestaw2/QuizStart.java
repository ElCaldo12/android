package com.example.kom.zestaw2;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QuizStart extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quzistart);
    }

    public void start(View view)
    {
        Context context;
        Intent intent;
        context = getApplicationContext();
        intent = new Intent(context, Quiz.class);
        startActivity(intent);
    }
    public void powrot(View v)
    {
        this.finish();
    }
}