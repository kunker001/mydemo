package com.example.kun.mydemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.kun.mydemo.R;
import com.example.kun.mydemo.adapter.ImgGridAdapter;
import com.example.kun.mydemo.base.BaseActivity;
import com.example.kun.mydemo.callBack.FreshImgCallBack;
import com.xuexiang.xui.widget.button.ButtonView;
import com.yanzhenjie.album.Album;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;


public class UploadImgActivity extends BaseActivity implements FreshImgCallBack {


    private static final int REQUEST_CODE_GALLERY = 100;//打开相册
    private static final int REQUEST_CODE_PREVIEW = 101;//预览图片
    private GridView gvImage;
    private ImgGridAdapter adapter;
    private ArrayList<String> imgList = new ArrayList<>();
    private final static int maxImgSize = 3;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_img;
    }

    @Override
    protected void init() {
        gvImage = (GridView) findViewById(R.id.gvImage);
        adapter = new ImgGridAdapter(UploadImgActivity.this, imgList, maxImgSize, this);
        gvImage.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                ArrayList<String> photos =
                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                imgList.clear();//不可直接指向
                for (int i = photos.size() - 1; i >= 0; i--) {
                    imgList.add(photos.get(i));//控制图片顺序
                }
                adapter.notifyDataSetChanged();
            }
        }

    }

    //更新图片：当前用于删除
    @Override
    public void updateGvImgShow(int position) {
        imgList.remove(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openGallery() {
        //多图片选择
        PhotoPicker.builder()
                .setPhotoCount(2)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start(this, PhotoPicker.REQUEST_CODE);
//        Album.album(this)//打开相册
//                .requestCode(REQUEST_CODE_GALLERY)
//                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
//                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
//                .selectCount(maxImgSize)
//                .columnCount(3)
//                .camera(true)
//                .start();
    }

    @Override
    public void previewImg(int position) {
        PhotoPreview.builder()
                .setPhotos(imgList)
                .setCurrentItem(position)
                .setShowDeleteButton(false)
                .start(this);
//        Album.gallery(this)//预览图片
//                .requestCode(REQUEST_CODE_PREVIEW)
//                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
//                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
//                .currentPosition(position)
//                .checkFunction(false)
//                .start();
    }


}



