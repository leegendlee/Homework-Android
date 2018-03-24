package es.source.code.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.R;

public class SCOSHelper extends AppCompatActivity {
    private String[] texts = {"用户使用协议", "关于系统", "电话人工帮助", "短信帮助", "邮件帮助"};
    private String[] ids = {"scosHelperItem_imageView", "scosHelperItem_textView"};
    private List<Map<String, Object>> items = new ArrayList<>();
    private Context context = SCOSHelper.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoshelper);
        GridView helperGridView = (GridView) findViewById(R.id.scosHelper_gridView);

        for (int i = 0; i < texts.length; ++i) {
            Map<String, Object> item = new HashMap<>();
            item.put(ids[0], R.drawable.help);
            item.put(ids[1], texts[i]);
            items.add(item);
        }

        SimpleAdapter helperItemAdapter = new SimpleAdapter(this, items,
                R.layout.scos_helper_item, ids, new int[]{R.id.scosHelperItem_imageView,
                R.id.scosHelperItem_textView});
        helperGridView.setAdapter(helperItemAdapter);
        helperGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String, Object> item = items.get(i);
                String name = (String) item.get(ids[1]);
                if (name.equals("电话人工帮助")) {
                    Acp.getInstance(context).request(new AcpOptions.Builder().setPermissions(
                            Manifest.permission.CALL_PHONE
                            ).build(), new AcpListener() {
                                @Override
                                public void onGranted() {
                                    Intent intent = new Intent("fxxk");
//                                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "5554"));
                                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                                            == PackageManager.PERMISSION_GRANTED) {
                                        context.startActivity(intent);
                                    }
                                }

                                @Override
                                public void onDenied(List<String> permissions) {

                                }
                            }
                    );
                }


            }
        });
    }

}
