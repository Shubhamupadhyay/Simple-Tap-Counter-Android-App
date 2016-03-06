package com.example.shubham.simpletapcounter;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plus;
    Button minus;
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        plus =(Button)findViewById(R.id.plus);
        minus=(Button)findViewById(R.id.minus);
        reset=(Button)findViewById(R.id.reset);
        plus.setBackgroundColor(Color.parseColor("#8043d854"));
        minus.setBackgroundColor(Color.parseColor("#80e2203d"));
        reset.setBackgroundColor(Color.parseColor("#802fa5d6"));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click + for increasing and - for decreasing", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {

            TextView textView;

            textView = (TextView)findViewById(R.id.textView);
            String num=textView.getText().toString();
            int n=Integer.parseInt(num);
            n++;
            num= String.valueOf(n);
            AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
            float vol = 1; //This will be half of the default system sound
            am.playSoundEffect(AudioManager.FX_KEY_CLICK, vol);

            textView.setText(num);

        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {

            TextView textView;

            textView = (TextView) findViewById(R.id.textView);
            String num = textView.getText().toString();
            int n = Integer.parseInt(num);
            n--;
            num = String.valueOf(n);
            AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            float vol = 1; //This will be half of the default system sound
            am.playSoundEffect(AudioManager.FX_KEY_CLICK, vol);

            textView.setText(num);


            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            this.moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    public void add(View target)
    {

        TextView textView;

        textView = (TextView)findViewById(R.id.textView);
        String num=textView.getText().toString();
        int n=Integer.parseInt(num);
        n++;
        num= String.valueOf(n);


        textView.setText(num);
    }

    public void sub(View target)
    {
        TextView textView;

        textView = (TextView)findViewById(R.id.textView);

        String num=textView.getText().toString();
        int n=Integer.parseInt(num);
        n--;
        num= String.valueOf(n);
        textView.setText(num);

       // textView.setText("Sub");
    }
    public void reset(View target)
    {
        TextView textView;

        textView = (TextView)findViewById(R.id.textView);
     //   target.playSoundEffect(SoundEffectConstants.CLICK);

        textView.setText("0");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
