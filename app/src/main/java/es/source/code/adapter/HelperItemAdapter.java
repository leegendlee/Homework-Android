package es.source.code.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.source.code.R;

/**
 * Created by leegend on 2018/3/24.
 */

public class HelperItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater parentInflater;
//    private List<>
    public HelperItemAdapter(Context context) {
        this.context = context;
        this.parentInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            viewHolder = new ViewHolder();

//            viewHolder = parentInflater.inflate(R.layout.scos_helper_item, parent, false);
            convertView.setTag(viewHolder);
        }

        return null;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
