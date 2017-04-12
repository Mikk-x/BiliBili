package com.mikk.bilibili.activity;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mikk.bilibili.R;
import com.mikk.bilibili.base.BaseFragment;
import com.mikk.bilibili.fragment.DongTaiFragment;
import com.mikk.bilibili.fragment.FaXianFragment;
import com.mikk.bilibili.fragment.FenQuFragment;
import com.mikk.bilibili.fragment.TuiJianFragment;
import com.mikk.bilibili.fragment.ZhiBoFragment;
import com.mikk.bilibili.fragment.ZhuiFanFragment;
import com.mikk.bilibili.utils.UIUtils;

import java.util.ArrayList;

import static com.mikk.bilibili.R.id.nav_view;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar mToolbar;
    // 刷新
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    // 整体抽屉布局
    private DrawerLayout mDrawerLayout;
    // 抽屉导航布局
    private NavigationView mNavigationView;

    private ArrayList<BaseFragment> mBaseFragment;

    private String[] mTabsArray;

    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // Translucent navigation bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        initView();
        initToolBar();
        initDrawerLayout();
        initFragment();

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mTabLayout = (TabLayout) findViewById(R.id.tablayout);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mNavigationView = (NavigationView) findViewById(nav_view);
    }

    private void initFragment() {

        //获得tabs的标题
        mTabsArray = UIUtils.getStringArray(R.array.home_tabs);

        //添加fragment
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new ZhiBoFragment());
        mBaseFragment.add(new TuiJianFragment());
        mBaseFragment.add(new ZhuiFanFragment());
        mBaseFragment.add(new FenQuFragment());
        mBaseFragment.add(new DongTaiFragment());
        mBaseFragment.add(new FaXianFragment());


        //tab和viewpager绑定
        //给viewpager设置适配器
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

        //因为viewpager初始化是不会走onPageSelected事件，要手动让它加载一次
        // 默认显示推荐Fragment
        mViewPager.setCurrentItem(1);

    }


    private void initToolBar() {

        // 将toolbar实例传入，外观和功能和ActionBar一致
        setSupportActionBar(mToolbar);
    }

    private void initDrawerLayout() {


        // 得到ActionBar的实例
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mToggle);
        // 同步状态
        mToggle.syncState();
        // 设置打开抽屉布局图标
        mToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);


        // 抽屉布局默认显示首页
        mNavigationView.setCheckedItem(R.id.nav_shouye);
        // 抽屉布局点击事件
        mNavigationView.setNavigationItemSelectedListener(this);

    }


    /**
     * 加载toolbar.xml这个菜单文件,toolbar图标
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * toolbar各个点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // HomeAsUp按钮的id永远都是 android.R.id.home
            case android.R.id.home:
                Toast.makeText(this, "HomeAsUp", Toast.LENGTH_SHORT).show();
                // openDrawer展示滑动菜单  参数：为了保证这里的行为和xml中定义的一致
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_game:
                Toast.makeText(this, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_download:
                Toast.makeText(this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(this, "查询", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /**
     * 侧滑菜单点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_shouye:
                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_huiyuan:
                Toast.makeText(this, "我的大会员", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_jifen:
                Toast.makeText(this, "会员积分", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_huancun:
                Toast.makeText(this, "离线缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_shaohou:
                Toast.makeText(this, "稍后再看", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_shoucang:
                Toast.makeText(this, "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_lishi:
                Toast.makeText(this, "历史记录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_guanzhu:
                Toast.makeText(this, "我的关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_qianbao:
                Toast.makeText(this, "B币钱包", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_zhuti:
                Toast.makeText(this, "主题选择", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_shezhi:
                Toast.makeText(this, "设置与帮助", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
        // 关闭侧滑菜单
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * viewpager的适配器
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mBaseFragment.get(position);
        }

        @Override
        public int getCount() {
            return mBaseFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabsArray[position];
        }
    }

}
