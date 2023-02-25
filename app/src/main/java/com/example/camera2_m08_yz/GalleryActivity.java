package com.example.camera2_m08_yz;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();
    File[] files;
    private String folderName = "Gallery";
    ViewPager viewPager;
    ViewPage viewPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallety_activity);
        getFromSDcard();

        viewPager = findViewById(R.id.viewPageMain);
        viewPage = new ViewPage(this,arrayList);
        viewPager.setAdapter(viewPage);
    }

    public void getFromSDcard(){
        File file = new File(getExternalFilesDir(folderName),"/");
        if (file.isDirectory()){
            files = file.listFiles();
            for (int i = 0; i < files.length; i++){
                arrayList.add(files[i].getAbsolutePath());
            }
        }
    }
}
