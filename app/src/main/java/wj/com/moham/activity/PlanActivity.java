package wj.com.moham.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import wj.com.moham.R;
import wj.com.moham.adapter.PlanPagerAdapter;
import wj.com.moham.common.ui.dialog.DialogMoham;
import wj.com.moham.common.ui.dialog.OnAlertClickListener;
import wj.com.moham.fragment.PlanCalendarFragment;
import wj.com.moham.fragment.PlanListFragment;

public class PlanActivity extends FragmentActivity {

    private ViewPager        mViewPagerPlan;
    private TabLayout        mTabLayoutPlan;
    private PlanPagerAdapter mPlanPagerAdapter;

    private List<Fragment>   mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        initViewPager();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        DialogMoham finishDialog = new DialogMoham();
        finishDialog.showAlertFinishDialog(PlanActivity.this, getString(R.string.alert) ,getString(R.string.msg_app_finish));
    }

    private void initViewPager() {

        mViewPagerPlan = (ViewPager) findViewById(R.id.view_pager_plan);
        mTabLayoutPlan = (TabLayout) findViewById(R.id.tab_layout_plan);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new PlanListFragment());
        mFragmentList.add(new PlanCalendarFragment());

        mPlanPagerAdapter = new PlanPagerAdapter(getSupportFragmentManager(), mFragmentList);
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
