package com.example.gridviewdemoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GridView 객체를 main.xml을 기술된 속성을 기준으로 생성한다.
        //GridVIew 불러오기
        GridView gridview = (GridView) findViewById(R.id.gridVIew);

        /*GridView Setting
         * GridView는 Adapter를 쓰는 경우가 많음.
         * ImageAdapter는 사용자가 만든 함수
         * 데이터를 어떻게 매칭시키고 어떤 이미지를 넣고, 어떤 레이아웃을 보일지를 설정 */
        gridview.setAdapter(new ImageAdapter(this));

    }

    //BaseAdapter를 상속받는 ImageAdapter를 생성한다.
    //BaseAdapter에서는 getCount, getItem, getItemid, getView 함수를 제공한다.
    //데이터를 어떻게 매칭시키고 어떤 이미지를 넣고, 어떤 레이아웃을 보일지를 설정
    public class ImageAdapter extends BaseAdapter{
        private Context context;

        /*이미지 배열을 선언
        * 안드로이드에서 Image형을 Integer로 바꿔준다.
        * 이미지는 res/drawable에 추가한 뒤 꺼내서 사용하면 된다.*/
        private Integer[] images = {
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6};

        //GridView의 위치 파악
        public ImageAdapter(Context c){
            this.context = c;
        }

        //이미지 배열의 개수를 return
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /* 지정된 위치에 배열의 이미지를 삽입
         * Array의 개수만큼 호출
         * convertView는 기존의 뷰를 반환해주는 역할을 한다.*/
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            /*convertView는 재사용 할 수 있게 도와주는 view이다.
             * 어떠한 이미지도 삽입되지 않은 상태일때 convertView가 null이다.*/
            if(convertView == null){
                //position == 0일 때
                //imageView의 instance 생성
                imageView = new ImageView(context);

                //imageView의 x(width), y(heigth) 설정
                imageView.setLayoutParams(new GridView.LayoutParams(60, 60));
                //imageView의 안에 얼만큼 채울것인지 설정(여기서는 딱 맞게)
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //imageView의 패딩값 설정
                imageView.setPadding(10, 10, 10, 10);
            }else{
                //position > 0 일 때
                //imageView에 convert값을 삽입한다.
                imageView = (ImageView) convertView;
            }

            //position 값은 처음 호출이 되면 0, 두번째 호출이 되면 1 등... 으로, Array의 개수만큼 호출이 된다.
            imageView.setImageResource(images[position]);
            return imageView;
        }
    }
}
