
package jp.mixi.practice.intent.med;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    public static final String ACTION_FIRST = "jp.mixi.practice.intent.med.android.intent.action.FIRST";
    public static final String ACTION_SECOND = "jp.mixi.practice.intent.med.android.intent.action.SECOND";
    public static final String ACTION_THIRD = "jp.mixi.practice.intent.med.android.intent.action.THIRD";

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("hogehoge", "local broadcast received.");
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button1 = findViewById(R.id.CallAction1);
        View button2 = findViewById(R.id.CallAction2);
        View button3 = findViewById(R.id.CallAction3);

        // TODO それぞれ、Broadcast を受け取ったら Log.v(String, String) を利用して、ログ出力にどの Action を受信したかを表示する処理を書くこと
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、ACTION_FIRST を呼び出す処理を書く
                sendBroadcast(new Intent(ACTION_FIRST));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、ACTION_SECOND を呼び出す処理を書く
                sendBroadcast(new Intent(ACTION_SECOND));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、ACTION_THIRD を呼び出す処理を書く
                sendBroadcast(new Intent(ACTION_THIRD));
            }
        });
    }
    
    @Override
    protected void onStart() {
        super.onStart();

        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);
        manager.registerReceiver(mReceiver, new IntentFilter(ACTION_FIRST));
        manager.registerReceiver(mReceiver, new IntentFilter(ACTION_SECOND));
        manager.registerReceiver(mReceiver, new IntentFilter(ACTION_THIRD));
    }
    
    @Override
    protected void onStop() {
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);
        manager.unregisterReceiver(mReceiver);
        super.onStop();
    }
}