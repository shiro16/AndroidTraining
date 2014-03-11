package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent received = getIntent();
        if(received != null){
            String str = received.getStringExtra("jp.mixi.practice.intent.beg.toast_message");
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_new2);
    }
}