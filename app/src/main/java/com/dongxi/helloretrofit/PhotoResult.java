package com.dongxi.helloretrofit;

/**
 * Created by Administrator on 2016/10/12.
 */

public class PhotoResult {


    /**
     * count : 5844
     * fcount : 0
     * galleryclass : 3
     * id : 1
     * img : /ext/150714/aeb85cdb34f325ccfb3ae0928f846d2d.jpg
     * rcount : 0
     * size : 18
     * time : 1436874237000
     * title : 絕對吸引眼球的超級美腿
     */

    private int count;
    private int fcount;
    private int galleryclass;
    private int id;
    private String img;
    private int rcount;
    private int size;
    private long time;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getGalleryclass() {
        return galleryclass;
    }

    public void setGalleryclass(int galleryclass) {
        this.galleryclass = galleryclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PhotoResult{" +
                "count=" + count +
                ", fcount=" + fcount +
                ", galleryclass=" + galleryclass +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", rcount=" + rcount +
                ", size=" + size +
                ", time=" + time +
                ", title='" + title + '\'' +
                '}';
    }
}
