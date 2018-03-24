package es.source.code.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.source.code.R;
import es.source.code.model.Food;

/**
 * Created by leegend on 2018/3/24.
 */

public class FoodViewItemAdapter extends RecyclerView.Adapter<FoodViewItemAdapter.ViewHolder> {
    private List<Food> foodItems = new ArrayList<>();
    private Context context;
    private LayoutInflater parentInflater;

    public FoodViewItemAdapter(List<Food> foods, Context context) {
        this.foodItems = foods;
        this.context = context;
        this.parentInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View foodItem = this.parentInflater.inflate(R.layout.food_view_item, parent, false);
        return new ViewHolder(foodItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = this.foodItems.get(position);
        //监听器需要在绑定的时候添加
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return this.foodItems.size();
    }

    //ListView的写法
//    public View getView(int i, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView != null) {
//            viewHolder = (ViewHolder) convertView.getTag();
//        } else {
//            viewHolder = new ViewHolder();
//            //以下只是在把ViewHolder绑定到ConvertView上，不是在赋值
//            viewHolder.foodName = (TextView) convertView.findViewById(R.id.fooViewItem_foodName);
//            viewHolder.foodPrice = (TextView) convertView.findViewById(R.id.fooViewItem_foodPrice);
//            viewHolder.isOrdered = (Button) convertView.findViewById(R.id.fooViewItem_btnOrderItem);
//            convertView.setTag(viewHolder);
//        }
//
//        Food food = (Food) this.getItem(i);
//
//        viewHolder.isOrdered.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                orderCount += 1;
//
//                notifyDataSetChanged();
//            }
//        });
//
//        return convertView;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView foodName;
        private TextView foodPrice;
        private Button isOrdered;
        private int orderCount = 0;

        public ViewHolder(View itemView) {
            super(itemView);
            this.foodName = (TextView) itemView.findViewById(R.id.foodViewItem_foodName);
            this.foodPrice = (TextView) itemView.findViewById(R.id.foodViewItem_foodPrice);
            this.isOrdered = (Button) itemView.findViewById(R.id.foodViewItem_btnOrderItem);
        }

//        @Override
//        public void onClick(View view) {
//
//        }

        public void bind(Food food) {
            this.foodName.setText(food.getFoodName());
            this.foodPrice.setText(String.valueOf(food.getFoodPrice()));
            //中文value无法传到的问题
            this.isOrdered.setText(this.orderCount > 0 ? "已点" : "点菜");
            this.isOrdered.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ++orderCount;
                    Toast.makeText(context, "点菜成功", Toast.LENGTH_SHORT).show();
                    isOrdered.setText(orderCount > 0 ? "已点" : "点菜");
                }
            });
        }
    }
}
