package com.example.android.findit;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;


public class end_activity extends Activity {
    private TextView text;
    public static final String MYPRE ="myprefile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity);
        text = (TextView)findViewById(R.id.scores);
        SharedPreferences settings = getSharedPreferences(MYPRE ,0);
        int s=0;
        s = settings.getInt("scores",s);
        text.setText(String.valueOf(s));
    }



    public void Restart(View v){
        Intent i = new Intent(this, CameraActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
        startActivity(i);
    }
}
