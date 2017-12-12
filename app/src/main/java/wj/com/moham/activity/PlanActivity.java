package wj.com.moham.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import wj.com.moham.R;
import wj.com.moham.adapter.PlanPagerAdapter;
import wj.com.moham.fragment.PlanCalendarFragment;
import wj.com.moham.fragment.PlanListFragment;
import wj.com.moham.common.util.Util;

public class PlanActivity extends FragmentActivity {

    private ViewPager mViewPagerPlan;
    private TabLayout mTabLayoutPlan;
    private PlanPagerAdapter mPlanPagerAdapter;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        initViewPager();
    }

    private void initViewPager() {

        mViewPagerPlan = (ViewPager) findViewById(R.id.view_pager_plan);
        mTabLayoutPlan = (TabLayout) findViewById(R.id.tab_layout_plan);

        fragmentList = new ArrayList<>();
        fragmentList.add(new PlanListFragment());
        fragmentList.add(new PlanCalendarFragment());

        mPlanPagerAdapter = new PlanPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPagerPlan.setAdapter(mPlanPagerAdapter);

        mViewPagerPlan.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayoutPlan));
        mTabLayoutPlan.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mViewPagerPlan.setCurrentItem(tab.getPosition());
                        break;
                    case 1:
                        mViewPagerPlan.setCurrentItem(tab.getPosition());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
