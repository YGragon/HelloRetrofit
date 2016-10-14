package com.dongxi.helloretrofit;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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
    @BindView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout swipeRefreshWidget;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

//    private List<AndroidResult> photoList = new ArrayList<AndroidResult>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        AndroidService service = retrofit.create(AndroidService.class);
        Call<Tngou> call = service.getResult();
//        Call<AndroidResult> call = service.getResult("Android");
        call.enqueue(this);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        list.setLayoutManager(staggeredGridLayoutManager);

    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        List<AndroidResult> photoList = response.body().getList();
        list.setAdapter(new PhotoAdater(photoList,this));
//        Log.e("返回的List:", "normalGet:" + photoList.toString());//返回成功

    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {

    }
}
