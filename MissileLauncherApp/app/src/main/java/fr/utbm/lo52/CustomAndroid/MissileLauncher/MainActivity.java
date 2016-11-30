package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MissileLauncher missileLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        missileLauncher = new MissileLauncher();

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        missileLauncher.Stop();
        missileLauncher.FreeUsb();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void fireClick(View v){
       //TODO
    }
}
