package com.example.kom.zestaw2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Kom on 2017-05-30.
 */

public class Zadanie5 extends AppCompatActivity
{

    private ListView lv;
    private String[] lang;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie5);

        lv=(ListView) findViewById(R.id.list);
        initResources();
        initLanguagesListView();

    }


    private void initResources()
    {
        Resources res = getResources();
        lang=res.getStringArray(R.array.teleofny);

    }
    private void initLanguagesListView()
    {
        lv.setAdapter(new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1,lang));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id)
            {
                Intent intent = new Intent(Zadanie5.this,Zadanie5Telefony.class);
                intent.putExtra("nazwa", lang[pos]);
                startActivity(intent);
            }

        });

    }
    public void powrot(View v)
    {
        this.finish();
    }



}
