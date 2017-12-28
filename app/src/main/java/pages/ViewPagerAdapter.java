package pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;



public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

//        this.fragmentList = fragmentList;
//        this.tabTitles = tabTitles;
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
        return tabTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){

        fragmentList.add(fragment);
        tabTitles.add(title);

    }

}
