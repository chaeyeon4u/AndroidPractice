package com.example.viewpagerdemoa1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewpager = (ViewPager) findViewById(R.id.view_pager);
        ImagePagerAdapter ipa = new ImagePagerAdapter(this);
        viewpager.setAdapter(ipa);

    }

    public class ImagePagerAdapter extends PagerAdapter {
        Context context;

        int[] images = new int[] {R.drawable.redros, R.drawable.pinkrose};

        public ImagePagerAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(View container, int position){
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setImageResource(images[position]);

            ((ViewPager) container).addView(imageView);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}
