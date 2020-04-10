package com.example.lenovo.fortest;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private LinearLayout mGallery;
    private int[] mImgIds;
    private String[] mImgNames;
    private LayoutInflater mInflater;
    private Boolean isVisisble = false;

    private Boolean isClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


        final HorizontalScrollView styleview = (HorizontalScrollView)findViewById(R.id.styleView);
        Button btn = (Button)findViewById(R.id.btn_style);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isVisisble){
                    isVisisble = true;
                    //设置风格列表显示
                    styleview.setVisibility(View.VISIBLE);


                }else{
                    isVisisble = false;
                    //设置风格列表显示
                    styleview.setVisibility(View.GONE);
                }
            }
        });

    }

    private void initData() {
        mImgIds = new int[]{R.drawable.candy, R.drawable.composition_vii, R.drawable.la_muse,
                R.drawable.feathers, R.drawable.mosaic, R.drawable.starry_night,
                R.drawable.the_scream, R.drawable.udnie, R.drawable.wave_crop
        };

        mImgNames = new String[]{"tangguo","composition_vii","la_muse","feathers","mosaic",
                "starry_night","the_scream","udine","wave"
        };
    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.activity_index_gallery_item,
                    mGallery, false);
            final ImageView img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText(mImgNames[i]);

            //每张图片设置点击的响应
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isClick){
                        isClick = false;
                        img.setBackgroundColor(Color.parseColor("#ffffff"));
                    }else{
                        isClick = true;
                        img.setBackgroundColor(Color.parseColor("#ff0000"));
                    }
                }
            });
            mGallery.addView(view);
        }
    }
}
