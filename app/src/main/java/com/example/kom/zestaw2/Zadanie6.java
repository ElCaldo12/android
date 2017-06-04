package com.example.kom.zestaw2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Kom on 2017-05-30.
 */

public class Zadanie6 extends AppCompatActivity
{

    static final private int ALERT_DIALOG_PLAIN=1;
    static final private int ALERT_DIALOG_BUTTONS=2;
    static final private int ALERT_DIALOG_LIST=3;
    static final private int CUSTOM_ALERT_DIALOG=4;

    private Button btnNewAlertDialog;
    private Button btnNewAlertDialogButton;
    private Button btnNewAlertDialogList;
    private Button btnNewCustomAlertDialog;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie6);

        btnNewAlertDialog= (Button) findViewById(R.id.btnNewAlertDialog);
        btnNewAlertDialogButton= (Button) findViewById(R.id.btnNewAlertDialogButton);
        btnNewAlertDialogList= (Button) findViewById(R.id.btnNewAlertDialogList);
        btnNewCustomAlertDialog= (Button) findViewById(R.id.btnNewCustomAlertDialog);
        initButtonsClick();
    }

    private void  initButtonsClick()
    {
        View.OnClickListener listener =new View.OnClickListener()
        {
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.btnNewAlertDialog:showDialog(ALERT_DIALOG_PLAIN);
                        break;
                    case R.id.btnNewAlertDialogButton:showDialog(ALERT_DIALOG_BUTTONS);
                        break;
                    case R.id.btnNewAlertDialogList:showDialog(ALERT_DIALOG_LIST);
                        break;
                    case R.id.btnNewCustomAlertDialog:showDialog(CUSTOM_ALERT_DIALOG);
                        break;
                    default:
                        break;
                }
            }
        };
        btnNewAlertDialog.setOnClickListener(listener);
        btnNewAlertDialogButton.setOnClickListener(listener);
        btnNewAlertDialogList.setOnClickListener(listener);
        btnNewCustomAlertDialog.setOnClickListener(listener);
    }

    protected Dialog onCreateDialog(int id)
    {
        switch(id) {
            case ALERT_DIALOG_PLAIN :
                return  createPlainAlertDialog ();
            case ALERT_DIALOG_BUTTONS :
                return createAlertDialogWithButtons();
            case ALERT_DIALOG_LIST:
                return createAlertDialogWithList();
            default:
                return null;
        }
    }
    private Dialog createPlainAlertDialog()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder( this);
        dialogBuilder.setTitle("Prosty dialog");
        dialogBuilder.setMessage("Wiadomość prostego dialogu");
        return dialogBuilder.create();
    }

    private Dialog createAlertDialogWithButtons() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle( "Wyjście");
        dialogBuilder.setMessage( "Czy napewno?");
        dialogBuilder.setCancelable( false);
        dialogBuilder.setPositiveButton("Tak", new Dialog.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int whichButton)
            {
                showToast("Wychodzę" );
                Zadanie6.this.finish();
            }
        });
        dialogBuilder.setNegativeButton("Nie",new Dialog.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog,int whichButton)
            {
                showToast("Anulowaleś wyjście" );
            }
        });
        return
                dialogBuilder.create();
    }

    private void showToast(String message)
    {
        Toast. makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private MediaPlayer mediaPlayer;
    private Dialog createAlertDialogWithList()
    {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder( this );
        final String[] options = {
                "utwor 1"
                ,
                "utwor 2"
                ,
                "Pauza"
        };
        dialogBuilder.setTitle("Lista opcji" );
        dialogBuilder.setItems(options, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int  position)
            {
                if(options[position].equals("utwor 1"))
                    playSound1();
                if(options[position].equals("utwor 2"))
                    playSound2();
                if(options[position].equals("Pauza"))
                    stopSound();
            }
        });
        return dialogBuilder.create();
    }

    public void playSound1()
    {
        mediaPlayer= MediaPlayer.create(this,R.raw.a);
        mediaPlayer.start();
    }
    public void playSound2()
    {
        mediaPlayer= MediaPlayer.create(this,R.raw.b);
        mediaPlayer.start();
    }
    public void stopSound()
    {
        mediaPlayer.stop();
    }

    public void powrot(View v)
    {
        this.finish();
    }

}
