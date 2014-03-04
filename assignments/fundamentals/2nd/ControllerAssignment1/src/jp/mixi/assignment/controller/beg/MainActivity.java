
package jp.mixi.assignment.controller.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

/**
 * TODO: 課題1
 * {@link Toast#makeText(Context, CharSequence, int)} または
 * {@link Toast#makeText(Context, int, int)} を利用して、各ライフサイクルメソッドがどのような順番で
 * 実行されているかを確認してください。
 * 確認したら、assignments/fundamentals/2nd/Report.md にその順番を記述してください。
 * @author keishin.yokomaku
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onStart();
    }
    
    @Override
    protected void onRestart () {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onRestart();
    }
    
    @Override
    protected void onResume() {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onResume();
    }

    @Override
    protected void onPause() {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onPause();
    }
    
    @Override
    protected void onStop() {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onStop();
    }
    
    @Override
    protected void onDestroy() {
        showToast(new Throwable().getStackTrace()[0].getMethodName());
        super.onDestroy();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void showToast(String showText) {
        Toast ts = Toast.makeText(this, "call " + showText , Toast.LENGTH_LONG);
        ts.show();
    }
}