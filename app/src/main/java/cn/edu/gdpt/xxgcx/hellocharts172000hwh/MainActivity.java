package cn.edu.gdpt.xxgcx.hellocharts172000hwh;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayoutMainTabs;
    private ViewPager mViewPagerMainCharts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabLayoutMainTabs = (TabLayout) findViewById(R.id.tabLayout_main_tabs);
        mViewPagerMainCharts = (ViewPager) findViewById(R.id.viewPager_main_charts);
    }
}
