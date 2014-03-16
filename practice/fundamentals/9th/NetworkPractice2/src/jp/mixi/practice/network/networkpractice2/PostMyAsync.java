
package jp.mixi.practice.network.networkpractice2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class PostMyAsync extends AsyncTask<String, Void, String> {
    private Activity mActivity;

    public PostMyAsync(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    protected String doInBackground(String... params) {
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost postMethod = new HttpPost(params[0]);

            StringBuilder builder = new StringBuilder();
            builder.append(params[1]);
            postMethod.setEntity(new StringEntity(builder.toString()));
            
            return client.execute(postMethod,
                    new ResponseHandler<String>() {
                        public String handleResponse(HttpResponse response)
                                throws ClientProtocolException, IOException {
                            return EntityUtils.toString(response.getEntity());
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void onPostExecute(String string) {
        TextView textView = (TextView) mActivity.findViewById(R.id.responce);
        textView.setText(string);
    }
}