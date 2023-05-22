package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {




    ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        ImageView snake = findViewById(R.id.snake);
        ImageView chick = findViewById(R.id.chick);
        Button button = findViewById(R.id.button);

        snake.setVisibility(View.GONE);

        mAnimator = ObjectAnimator.ofFloat(imageView, "x", 300);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAnimator.setDuration(2000);
                mAnimator.start();
                mAnimator.addListener(new AnimatorListenerAdapter(){
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mAnimator = ObjectAnimator.ofFloat(chick, "x", 1000);
                        mAnimator.start();

                        super.onAnimationEnd(animation);
                    }
                });
            }
        });


    }
}

//    ObjectAnimator mAnimator;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ImageView imgView = findViewById(R.id.img);
//        Button btn = findViewById(R.id.btn_start);
//
//        mAnimator = ObjectAnimator.ofFloat(imgView, "rotation", 360);
//        mAnimator = ObjectAnimator.ofFloat(imgView, "rotation", 360);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAnimator.setDuration(1000);
//                mAnimator.start();
//            }
//        });
//    }
//}