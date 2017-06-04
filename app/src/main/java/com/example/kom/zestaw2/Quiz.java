package com.example.kom.zestaw2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Quiz extends Activity
{
    int punkty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
    }

    public void punkt(View view)
    {
        punkty++;
    }

    public void odNowa(View view)
    {
        punkty = 0;
    }

    public void Punkty(View view)
    {
        Toast.makeText(getApplicationContext(),"Zdobyles " + punkty, Toast.LENGTH_LONG).
                show();
    }

    public void Powrot(View view)
    {
        finish();
    }

}