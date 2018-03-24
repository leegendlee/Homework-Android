package es.source.code.handler;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by leegend on 2018/3/25.
 */

public class LoginRegisterAsyncTask extends AsyncTask<Void, Integer, String> {
    private ProgressBar progressBar;
    private Context context;

    public LoginRegisterAsyncTask(Context context, ProgressBar progressBar) {
        this.progressBar = progressBar;
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            progressBar.setVisibility(View.VISIBLE);
            while (progressBar.getProgress() < progressBar.getMax()) {
                publishProgress(progressBar.getProgress());
                Thread.sleep(600);
            }
            progressBar.setVisibility(View.GONE);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        return "执行完毕";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressBar.setProgress(progressBar.getProgress() + 10);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(this.context, s, Toast.LENGTH_SHORT).show();
        super.onPostExecute(s);
    }
}
