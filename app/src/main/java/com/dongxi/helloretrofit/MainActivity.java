package com.dongxi.helloretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Tngou> {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<PhotoResult> photoList;

//    private List<PhotoResult> photoList = new ArrayList<PhotoResult>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        ListenerMenu();
        getDataFromService();


    }

    /**
     * 获取服务器的数据
     */
    private void getDataFromService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        PhotoService service = retrofit.create(PhotoService.class);
        Call<Tngou> call = service.getResult();
        call.enqueue(this);
    }

    /**
     * 点击事件的监听
     */
    private void ListenerMenu() {
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cardView:
                        list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                }
                return true;
            }
        });
    }

    /**
     * 初始化布局
     */
    private void initView() {
        setSupportActionBar(toolBar);//设置支持Action Bar
        toolBar.setTitle("HelloRetrofit");
        //设置主标题颜色
        toolBar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用，如果某个页面想隐藏掉返回键比如首页，可以调用mToolbar.setNavigationIcion(null);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        list.setLayoutManager(staggeredGridLayoutManager);

    }

    /**
     * 设置菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        photoList = response.body().getList();
        list.setAdapter(new PhotoAdater(photoList, this));
//        Log.e("返回的List:", "normalGet:" + photoList.toString());//返回成功

    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {

    }


}
