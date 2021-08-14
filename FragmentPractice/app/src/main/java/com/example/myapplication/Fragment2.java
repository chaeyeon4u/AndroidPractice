package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    FragmentCallBack curActivity;
    ViewGroup rootView;
    ImageView image;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof FragmentCallBack){
            curActivity = (FragmentCallBack) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if(curActivity != null){
            curActivity = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        image = (ImageView) rootView.findViewById(R.id.imageView);

        return rootView;
    }

    public void setImage(int index){
        if(index == 1){
            image.setImageResource(R.drawable.ic_launcher_background);
        }else {
            image.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }
}
