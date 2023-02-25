package com.example.camera2_m08_yz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class ViewPage extends PagerAdapter {

    Context context;

    ArrayList<String> imgPath;

    LayoutInflater layoutInflater;

    public ViewPage(Context context,ArrayList<String> imgPath){
        this.context = context;
        this.imgPath = imgPath;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imgPath.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup contain, final int position){
        View view = layoutInflater.inflate(R.layout.gallety_item, contain,false);
        ImageView imgView = view.findViewById(R.id.imageViewMain);
        Bitmap bitmap = BitmapFactory.decodeFile(imgPath.get(position));
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        Bitmap rotateBit = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        imgView.setImageBitmap(rotateBit);
        Objects.requireNonNull(contain).addView(view);
        return view;
    }
}
