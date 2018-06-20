package cn.pangkai.mineselfviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pangkai.mineselfviewdemo.R;

public class AnimatorActivity extends AppCompatActivity {

    @BindView(R.id.toggleButton)
    Button toggleButton;
    @BindView(R.id.theView)
    View theView;
    @BindView(R.id.bt_to_yingbi)
    Button btToYingbi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toggleButton, R.id.bt_to_yingbi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toggleButton:
                if (theView.getAlpha() > 0f) {
                    //如果视图可见，将其从右侧划出
                    theView
                            .animate()
                            .alpha(0f)
                            .rotation(90f);
//                    .translationX(getResources().getDimensionPixelSize(R.dimen.size_1000px)); //设置偏移
                } else {
                    //如果视图是隐藏的，原地做渐显动画
                    theView.setTranslationX(0f);    //设置偏移
                    theView
                            .animate()
                            .rotation(0f)
                            .alpha(1f);
                }
                break;

            case R.id.bt_to_yingbi:
                startActivity(new Intent(this , PaoYingbiActivity.class));
                break;

            default:
                break;
        }
    }
}
