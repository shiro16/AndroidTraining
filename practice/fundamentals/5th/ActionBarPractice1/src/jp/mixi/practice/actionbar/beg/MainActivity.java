
package jp.mixi.practice.actionbar.beg;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // タブナビゲーションモードに設定
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // タブを作成して追加。タブの選択・解除・再選択をハンドリングするコールバックの TabListener をセットしないと実行時例外でクラッシュする
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("Tab1").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("Tab2").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("Tab3").setTabListener(this));
    }

    @Override
    public void onTabSelected(com.actionbarsherlock.app.ActionBar.Tab tab,
            android.support.v4.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
        Toast.makeText(this, tab.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(com.actionbarsherlock.app.ActionBar.Tab tab,
            android.support.v4.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTabReselected(com.actionbarsherlock.app.ActionBar.Tab tab,
            android.support.v4.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
        
    }
}
