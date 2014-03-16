
package jp.mixi.practice.network.networkpractice1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

public class GetMyAsync extends AsyncTask<String, Void, String> {
    private Activity mActivity;

    public GetMyAsync(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            
            StringBuilder src = new StringBuilder();
            while (true) {
                byte[] line = new byte[1024];
                int size = is.read(line);
                if (size <= 0)
                    break;
                src.append(new String(line, "euc-jp"));
            }
            return new String(src);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
        return null;
    }
    
    public void onPostExecute(String string) {
        TextView textView = (TextView) mActivity.findViewById(R.id.responce);
        textView.setText(string);
    }
}