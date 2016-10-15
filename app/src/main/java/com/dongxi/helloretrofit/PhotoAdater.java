package com.dongxi.helloretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */

public class PhotoAdater extends RecyclerView.Adapter<PhotoAdater.myPhotoView> {

    private List<PhotoResult> photoList = new ArrayList<PhotoResult>();
    private PhotoResult PhotoInfo;
    private ImageView image;
    private Context mContent;
    private PhotoAdater.myPhotoView myPhotoView;
    private static final int NORMAL_ITEM = 0;
    private static final int GROUP_ITEM = 1;

    public PhotoAdater(List<PhotoResult> list, Context context) {
        this.photoList = list;
        this.mContent = context;
    }

    @Override
    public myPhotoView onCreateViewHolder(ViewGroup parent, int viewType) {
        myPhotoView = new myPhotoView(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_cardview_layout, parent, false));

        return myPhotoView;
    }

    @Override
    public void onBindViewHolder(myPhotoView holder, int position) {
        PhotoInfo = photoList.get(position);
        String imgUrl = "http://tnfs.tngou.net/image" + PhotoInfo.getImg() + "_180x120";
        Glide.with(mContent).load(imgUrl).into(image);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    class myPhotoView extends RecyclerView.ViewHolder {

        public myPhotoView(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
