package cn.edu.gdpt.xxgcx.hellocharts172000hwh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayoutMainTabs;
    private ViewPager mViewPagerMainCharts;
    View lineView,pieView,columnView;/*声明布局对象变量*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTablayout();
        initLineChart();
    }

    private void initLineChart() {/*折线图*/
        LineChartView lineChartView = lineView.findViewById(R.id.lcv_main_temperature);/*初始化控件*/
        /*1、X和Y轴坐标刻度*/
        String[] lineData = {"周一","周二","周三","周四","周五","周六","周日"};
        List<AxisValue> axisXValues = new ArrayList<>();/*用集合类对象存储X轴刻度字符*/
        for (int i=0;i<lineData.length;i++) {
            axisXValues.add( new AxisValue(i).setLabel(lineData[i]));
        }
        Axis axisX = new Axis();
        axisX.setValues(axisXValues);
        Axis axisY = new Axis();/*Y轴不指定刻度字符*/
        /*2、点和线*/
        int[] temperature={23,17,36,10,24,20,15};
        List<PointValue> pintValues = new ArrayList<>();/*用集合类对象存点值*/
        for (int i=0;i<temperature.length;i++) {
            pintValues.add(new PointValue(i,temperature[i]));
        }
        Line line = new Line();/*单条线*/
        line.setValues(pintValues);
        List<Line> lines = new ArrayList<>();/*集合类对象存储线条*/
        lines.add(line);
        /*3、折线图数据对象*/
        LineChartData lineChartData = new LineChartData();
        lineChartData.setAxisXBottom(axisX);/*X轴*/
        lineChartData.setAxisYLeft(axisY);/*Y轴*/
        lineChartData.setLines(lines);/*线条*/
        /*4、数据对象赋给折线图控件，并显示*/
        lineChartView.setLineChartData(lineChartData);
        lineChartView.setVisibility(View.VISIBLE);
    }

    private void initTablayout() {/*二、实现选项卡和手势滑动效果*/
        /*1、选项卡效果*/
        List<String> mTitleList = new ArrayList<>();/*定义选项卡名称*/
        mTitleList.add("线形图");
        mTitleList.add("饼状图");
        mTitleList.add("柱状图");
        mTabLayoutMainTabs.addTab(mTabLayoutMainTabs.newTab().setText(mTitleList.get(0)));/*添加3个选项卡片*/
        mTabLayoutMainTabs.addTab(mTabLayoutMainTabs.newTab().setText(mTitleList.get(1)));
        mTabLayoutMainTabs.addTab(mTabLayoutMainTabs.newTab().setText(mTitleList.get(2)));
        /*2、ViewPager实现手势滑动效果*/
        /*2.1、定义布局文件对象，并保存到List集合类对象中*/
        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());/*定义布局文件加载器*/
        lineView = mInflater.inflate(R.layout.layout_line_chart, null);/*加载折线图布局文件*/
        pieView  = mInflater.inflate(R.layout.layout_pie_chart, null);/*加载饼状图布局文件*/
        columnView  = mInflater.inflate(R.layout.layout_column_chart, null);/*加载柱状图布局文件*/
        List<View> mViewList = new ArrayList<>();
        mViewList.add(lineView);
        mViewList.add(pieView);
        mViewList.add(columnView);
        /*2.2、通过ViewPager适配器，将视图文件赋值给ViewPager控件*/
        ViewPagerAdapter adapter = new ViewPagerAdapter(mViewList, mTitleList);
        mViewPagerMainCharts.setAdapter(adapter);
        /*3、将ViewPager跟TabLayout进行关联*/
        mTabLayoutMainTabs.setupWithViewPager(mViewPagerMainCharts);
    }

    private void initView() {/*一、控件初始化*/
        mTabLayoutMainTabs = (TabLayout) findViewById(R.id.tabLayout_main_tabs);
        mViewPagerMainCharts = (ViewPager) findViewById(R.id.viewPager_main_charts);
    }
}
