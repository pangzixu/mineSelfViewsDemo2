package cn.pangkai.mineselfviewdemo.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pangkai.mineselfviewdemo.R;

/**
 * Created by Administrator on 2018/6/20.
 * 抛硬币的动画
 */

public class PaoYingbiActivity extends Activity {

    @BindView(R.id.flip_image)
    ImageView flipImage;

    private boolean mIsHeads;
    private ObjectAnimator mFlipper;
    private Bitmap mHeadsImage, mTailsImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pao_yingbi);
        ButterKnife.bind(this);
        mHeadsImage = BitmapFactory.decodeResource(getResources(), R.drawable.btn_style_alert_dialog_cancel_normal);
        mTailsImage = BitmapFactory.decodeResource(getResources(), R.drawable.btn_style_alert_dialog_special_normal);

        flipImage.setImageBitmap(mHeadsImage);
        mIsHeads = true;

        mFlipper = ObjectAnimator.ofFloat(flipImage, "rotationY", 0f, 360f);
        mFlipper.setDuration(1000);
        mFlipper.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (animation.getAnimatedFraction() >= 0.25f && mIsHeads) {
                    flipImage.setImageBitmap(mTailsImage);
                    mIsHeads = false;
                }

                if (animation.getAnimatedFraction() >= 0.75f && !mIsHeads) {
                    flipImage.setImageBitmap(mHeadsImage);
                    mIsHeads = true;
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mFlipper.start();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @OnClick(R.id.flip_image)
    public void onViewClicked() {
    }
}
