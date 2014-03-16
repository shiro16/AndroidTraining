package jp.mixi.practice.storage.storagepractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private static final int REQUEST_GALLERY = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button internalSaveButton = (Button) findViewById(R.id.internalFileSave);
        internalSaveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String FILENAME = "text_file";
                EditText editText = (EditText) findViewById(R.id.text);
                
                FileOutputStream fos = null;
                try {
                    openFileOutput(FILENAME, MODE_PRIVATE);
                    fos.write(editText.getText().toString().getBytes());
                } catch (IOException e) {
                    // 例外処理
                } finally {
                    try {
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                    }
                }
            }
        });
        
        Button externalSaveButton = (Button) findViewById(R.id.externalFileSave);
        externalSaveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String FILENAME = "image_file";
                File file = new File(Environment.getExternalStorageDirectory(), FILENAME);
                try {
                    InputStream is = getResources().openRawResource(R.id.file);
                    FileOutputStream os = new FileOutputStream(file);
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    os.write(data);
                    is.close();
                    os.close();
                } catch (IOException e) {
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
