package com.example.cwl.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.example.cwl.common.glide.ImageLoader;
import com.example.cwl.myapplication.R;
import com.youth.banner.loader.ImageLoaderInterface;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/28
 */
public class GlideImageLoader  implements ImageLoaderInterface<ImageView> {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String url= (String) path;
        ImageLoader.getInstance().loadImageViewLoding(context,url,imageView,R.drawable.pic_default,R.drawable.pic_default);
    }

    @Override
    public ImageView createImageView(Context context) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }
    public static void  loadImage(Context context,String url,ImageView imageView){
        ImageLoader.getInstance().loadImageView(context,url,imageView);
    }
    public static void loadImageWithDefault(Context context,String url,ImageView view){
        ImageLoader.getInstance().loadImageViewLoding(context,url,view,R.drawable.pic_default);
    }
}
