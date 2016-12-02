package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MissileCallback{

    private TargetView targetView;
    private MissileController missileController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        targetView = (TargetView) findViewById(R.id.target);

    }

    @Override
    public PointF getTargetData() {
        return targetView.getUserPoint();
    }

    @Override
    public boolean isLauncherMoving() {
        return targetView.isTargetMoving();
    }


    public void fireClick(View v){
        missileController.fire();
    }

    @Override
    public void onResume() {
        super.onResume();

        missileController = new MissileController(this);
        missileController.start();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        missileController.terminate();
        try {
            missileController.join();
        } catch (InterruptedException e) {
            missileController.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
