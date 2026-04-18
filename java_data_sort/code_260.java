package com.kiwi.camera.utils.camera;


import android.hardware.Camera;
import android.util.Log;

import java.util.Iterator;
import java.util.List;

public class CameraUtils {
    private static final String TAG = "CameraUtils";

    public CameraUtils() {
    }

    public static void choosePreviewSize(Camera.Parameters parms, int width, int height) {
        Camera.Size ppsfv = parms.getPreferredPreviewSizeForVideo();
        if(ppsfv != null) {
            Log.d("CameraUtils", "Camera preferred preview size for video is " + ppsfv.width + "x" + ppsfv.height);
        }

        Iterator var4 = parms.getSupportedPreviewSizes().iterator();

        Camera.Size size;
        while(var4.hasNext()) {
            size = (Camera.Size)var4.next();
            Log.d("CameraUtils", "supported: " + size.width + "x" + size.height);
        }

        var4 = parms.getSupportedPreviewSizes().iterator();

        do {
            if(!var4.hasNext()) {
                Log.w("CameraUtils", "Unable to set preview size to " + width + "x" + height);
                if(ppsfv != null) {
                    parms.setPreviewSize(ppsfv.width, ppsfv.height);
                }

                return;
            }

            size = (Camera.Size)var4.next();
        } while(size.width != width || size.height != height);

        Log.d("CameraUtils", "setting preview size: " + width + "x" + height);
        parms.setPreviewSize(width, height);
    }


    public static int[] chooseFixedPreviewFps(int expectedFps, List<int[]> fpsRanges) {
        expectedFps *= 1000;
        int[] closestRange = fpsRanges.get(0);
        int measure = Math.abs(closestRange[0] - expectedFps) + Math.abs(closestRange[1] - expectedFps);
        for (int[] range : fpsRanges) {
            if (range[0] <= expectedFps && range[1] >= expectedFps) {
                int curMeasure = Math.abs(range[0] - expectedFps) + Math.abs(range[1] - expectedFps);
                if (curMeasure < measure) {
                    closestRange = range;
                    measure = curMeasure;
                }
            }
        }
        return closestRange;
    }
}