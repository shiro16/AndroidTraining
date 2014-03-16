
package jp.mixi.practice.network.networkpractice2;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

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
        HttpClient client = new DefaultHttpClient();
        try {
            return client.execute(new HttpGet(params[0]),
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