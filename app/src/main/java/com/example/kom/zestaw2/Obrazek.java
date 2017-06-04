package com.example.kom.zestaw2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Obrazek extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obrazek);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void zmienObrazek(View view)
    {
        imageView.setImageResource(R.drawable.android1);
    }

    public void Poprzedni(View view)
    {
        imageView.setImageResource(R.drawable.android);
    }

    public void Powrot(View view)
    {
        finish();
    }
}