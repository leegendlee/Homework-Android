package es.source.code.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import es.source.code.fragment.FoodItemFragment;

/**
 * Created by leegend on 2018/3/24.
 */

public class FoodViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] page_titles;
    public FoodViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(String[] food_types) {
        for (int i = 0; i < food_types.length; ++i) {
            Fragment foodFragment = FoodItemFragment.newInstance(food_types[i]);
            fragmentList.add(foodFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.page_titles[position];
    }

    public void setPage_titles(String[] page_titles) {
        this.page_titles = page_titles;
    }
}
