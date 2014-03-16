package jp.mixi.assignment.sharedpreferences.sharedpreferencesassignment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSharedPreferenceChangeListener { 

    private SharedPreferences mPrivatePreferences;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mPrivatePreferences = getSharedPreferences("count", MODE_PRIVATE);
        mPrivatePreferences.registerOnSharedPreferenceChangeListener(this);
        
        TextView textView = (TextView) findViewById(R.id.count);
        Integer Int = mPrivatePreferences.getInt("count", 0);
        textView.setText(Int.toString());
        
        Button countupButton = (Button) findViewById(R.id.countup);
        countupButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 内容をクリアする処理を書いてください。
                Integer count = mPrivatePreferences.getInt("count", 0);
                Editor editor = mPrivatePreferences.edit();
                editor.putInt("count", ++count);
                editor.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy(){
        mPrivatePreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }
    
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
            String key) {
        Integer count = mPrivatePreferences.getInt("count", 0);
        TextView tv = (TextView) findViewById(R.id.count);
        tv.setText(count.toString());
    }

}
