package cn.pangkai.mineselfviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pangkai.mineselfviewdemo.activity.AnimatorActivity;
import cn.pangkai.mineselfviewdemo.views.MineSeveralColorCircle;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mine_several_circle)
    MineSeveralColorCircle mineSeveralCircle;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e(TAG, "走到了这呵呵呵呵呵呵呵");
    }

    @OnClick(R.id.mine_several_circle)
    public void onViewClicked() {
        startActivity(new Intent(this, AnimatorActivity.class));
    }
}
