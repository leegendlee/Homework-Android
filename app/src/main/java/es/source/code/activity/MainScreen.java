package es.source.code.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.R;
import es.source.code.model.User;

public class MainScreen extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private GestureDetector gestureDetector;

    GridView mainScreenGridView;
    private List<Map<String, Object>> list = new ArrayList<>();
    private Resources resources;

    private Object[] images = {R.drawable.buy, R.drawable.order, R.drawable.login, R.drawable.help};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.gestureDetector = new GestureDetector(MainScreen.this, this);
        setContentView(R.layout.activity_main_screen);
        Bundle bundle = getIntent().getExtras();

        this.resources = getResources();
        String[] texts = {resources.getString(R.string.order_food), resources.getString(R.string.review_order),
                resources.getString(R.string.login_or_register), resources.getString(R.string.system_help)};

        this.mainScreenGridView = (GridView) findViewById(R.id.mainScreen_gridView);
        String[] strings = {"mainScreenItem_imageView", "mainScreenItem_textView"};
        for (int i = 0; i < texts.length; ++i) {
            Map<String, Object> map = new HashMap<>();
            map.put(strings[0], images[i]);
            map.put(strings[1], texts[i]);
            list.add(map);
        }

        String msg = bundle != null ? bundle.getString("msg") : "";
        User user = null;

        if (msg != null && msg.equals("RegisterSuccess")) {
            Toast.makeText(this, "欢迎成为SCOS用户", Toast.LENGTH_LONG).show();
            user = bundle != null ? (User) bundle.getParcelable("user") : null;
        }

        Log.i("userPass", user != null ? user.getPassword() : "wrong");
        SimpleAdapter simpleAdapter = new SimpleAdapter(MainScreen.this, list,
                R.layout.main_screen_item, strings, new int[]{R.id.mainScreenItem_imageView,
                R.id.mainScreenItem_textView});
        this.mainScreenGridView.setAdapter(simpleAdapter);
        this.mainScreenGridView.setOnItemClickListener(new ItemClick());

//        for (int i = 0; i < simpleAdapter.getCount(); ++i) {
//            LinearLayout layout = (LinearLayout) this.mainScreenGridView.getChildAt(i);
//            TextView textView = (TextView) layout.getChildAt(1);
////            if (textView.getText().toString().equals("点菜")
////                    || textView.getText().toString().equals("查看订单")) {
////                if (msg == null || !msg.equals("LoginSuccess")) {
////                    Log.i("msg", textView.getText().toString());
////                    layout.setVisibility(View.GONE);
////                }
////            }
//        }
    }

    private class ItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Map<String, Object> item = list.get(i);
            String string = (String) item.get("mainScreenItem_textView");
            Intent intent = null;
            if (string.equals("点菜")) {
                intent = new Intent(MainScreen.this, FoodView.class);
            } else if (string.equals("登录/注册")) {
                intent = new Intent(MainScreen.this, LoginOrRegister.class);
            } else if (string.equals("系统帮助")) {
                intent = new Intent(MainScreen.this, SCOSHelper.class);
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.i("123", "123");

        float start = motionEvent.getX();
        float end = motionEvent1.getX();
        if ((end - start) >= 100) {
            Intent entry = new Intent(this, SCOSEntry.class);
            startActivity(entry);
        }
        return false;
    }
}
