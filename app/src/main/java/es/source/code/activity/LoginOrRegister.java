package es.source.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.source.code.R;
import es.source.code.model.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginOrRegister extends AppCompatActivity {

    @BindView(R.id.loginOrRegister_btnLogin)
    Button userLogin;
    @BindView(R.id.loginOrRegister_btnReturn)
    Button userReturn;
    @BindView(R.id.loginOrRegister_userName)
    EditText userName;
    @BindView(R.id.loginOrRegister_userPassword)
    EditText userPassword;
    @BindView(R.id.loginOrRegister_pBar)
    ProgressBar pBar;
    @BindView(R.id.loginOrRegister_btnRegister)
    Button loginOrRegisterBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginOrRegister_btnLogin)
    public void onLoginOrRegisterBtnLoginClicked() {
//        LoginRegisterAsyncTask pBar = new LoginRegisterAsyncTask(this, this.pBar);
//        pBar.execute();
        this.getBaidu();

        if (this.validate(this.userName, this.userName.getText().toString())) {
            Intent mainScreen = new Intent(LoginOrRegister.this, MainScreen.class);
            mainScreen.putExtra("msg", "LoginSuccess");
            startActivity(mainScreen);
        }
    }

    @OnClick(R.id.loginOrRegister_btnReturn)
    public void onLoginOrRegisterBtnReturnClicked() {
        Intent mainScreen = new Intent(LoginOrRegister.this, MainScreen.class);
        mainScreen.putExtra("msg", "Return");
        startActivity(mainScreen);
    }

    private void getBaidu() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                synchronized (Thread.currentThread()) {
                    try {
//                        OkHttpClient client = new OkHttpClient();
//                        Request request = new Request.Builder().url("http://www.baidu.com").build();
//                        Response response = client.newCall(request).execute();
//                        if (response.isSuccessful()) {
//                            Log.i("code", response.body().string());
                            pBar.setVisibility(View.VISIBLE);
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean validate(EditText editText, String string) {
        if (!Pattern.matches("^[a-zA-Z0-9]+$", string)) { //+号：1次或多次；*号：0次或多次
            editText.setError("输入内容不符合规则");
            return false;
        }

        return true;
    }

    @OnClick(R.id.loginOrRegister_btnRegister)
    public void onLoginOrRegisterBtnRegisterClicked() {
//        this.pBarChange();

        if (this.validate(this.userName, this.userName.getText().toString())) {
            User user = new User();
            user.setUserName(this.userName.getText().toString());
            user.setPassword(this.userPassword.getText().toString());
            user.setOldUser(false);
            Intent mainScreen = new Intent(LoginOrRegister.this, MainScreen.class);
            mainScreen.putExtra("user", (Parcelable) user);
            mainScreen.putExtra("msg", "RegisterSuccess");
            startActivity(mainScreen);
        }
    }
}
