package com.example.kom.zestaw2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity
{
    private Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doAktywnosciObrazek(View v)
    {
        context = getApplicationContext();
        intent = new Intent(context, Obrazek.class);
        startActivity(intent);
    }

    public void doQuizStart(View v)
    {
        context = getApplicationContext();
        intent = new Intent(context, QuizStart.class);
        startActivity(intent);
    }

    public void doAktywosci2(View v)
    {
        context = getApplicationContext();
        intent = new Intent(context, Zadanie2.class);
        startActivity(intent);
    }
    public  void doAktywnosci5(View v)
    {
        context =getApplicationContext();
        intent=new Intent(context,Zadanie5.class);
        startActivity(intent);
    }

    public  void doAktywnosci6(View v)
    {
        context =getApplicationContext();
        intent=new Intent(context,Zadanie6.class);
        startActivity(intent);
    }

    public  void doAktywnosci7(View v)
    {
        context =getApplicationContext();
        intent=new Intent(context,Zadanie7.class);
        startActivity(intent);
    }

}