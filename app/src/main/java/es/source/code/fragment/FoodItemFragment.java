package es.source.code.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import es.source.code.R;
import es.source.code.adapter.FoodViewItemAdapter;
import es.source.code.listener.FoodViewItemListener;
import es.source.code.model.Food;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class FoodItemFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String FOOD_TYPE = "food_type";

    private String food_type;

    private OnFragmentInteractionListener mListener;

    public FoodItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param food_type Parameter 2.
     * @return A new instance of fragment food_view_item.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodItemFragment newInstance(String food_type) {
        FoodItemFragment fragment = new FoodItemFragment();
        Bundle args = new Bundle();
        args.putString(FOOD_TYPE, food_type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            food_type = getArguments().getString(FOOD_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_food_view, container, false);
        Resources resources = getResources();

        FoodViewItemAdapter foodViewItemAdapter;
        RecyclerView foodViewItems = fragmentView.findViewById(R.id.foodViewItem_recyclerView);
        List<Food> foodList = new ArrayList<>();
        Food food = new Food();
        if (this.food_type.equals(resources.getString(R.string.cold_food))) {
            food.setFoodName("皮蛋豆腐");
            food.setFoodPrice(10);
        } else if (this.food_type.equals(resources.getString(R.string.hot_food))) {
            food.setFoodName("咕咾肉");
            food.setFoodPrice(20);
        } else if (this.food_type.equals(resources.getString(R.string.seafood))) {
            food.setFoodName("生蚝");
            food.setFoodPrice(4);
        } else if (this.food_type.equals(resources.getString(R.string.drinks))) {
            food.setFoodName("酸奶");
            food.setFoodPrice(8);
        }
        foodList.add(food);
        foodViewItemAdapter = new FoodViewItemAdapter(foodList, getContext());
        foodViewItems.setLayoutManager(new LinearLayoutManager(getContext()));
//        foodViewItems.addOnItemTouchListener(new FoodViewItemListener(getContext(), new FoodViewItemListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//        }));
        foodViewItems.setAdapter(foodViewItemAdapter);
        return fragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
