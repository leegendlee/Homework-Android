package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import es.source.code.R;

public class SCOSEntry extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.gestureDetector = new GestureDetector(SCOSEntry.this, this);
        setContentView(R.layout.activity_scosentry);
    }

    //这个方法需要手动添加
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
        float start = motionEvent.getX();
        float end = motionEvent1.getX();
        if ((start - end) >= 100) {
            Intent mainScreen = new Intent(this, MainScreen.class);
            mainScreen.putExtra("from", "FromEntry");
            startActivity(mainScreen);
        }
        return false;
    }
}
