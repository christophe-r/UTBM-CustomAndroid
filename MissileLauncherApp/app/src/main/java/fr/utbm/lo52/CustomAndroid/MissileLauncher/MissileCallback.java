package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import android.graphics.PointF;

/**
 * Created by vmars on 01/12/2016.
 */

public interface MissileCallback {
    public PointF getTargetData();
    public boolean isLauncherMoving();
}
