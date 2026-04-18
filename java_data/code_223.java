package org.bytedeco.opencv.opencv_tracking;

import org.bytedeco.javacpp.annotation.Index;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.opencv.opencv_plot.*;
import static org.bytedeco.opencv.global.opencv_plot.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_calib3d.*;
import static org.bytedeco.opencv.global.opencv_calib3d.*;
import org.bytedeco.opencv.opencv_video.*;
import static org.bytedeco.opencv.global.opencv_video.*;
import org.bytedeco.opencv.opencv_dnn.*;
import static org.bytedeco.opencv.global.opencv_dnn.*;

import static org.bytedeco.opencv.global.opencv_tracking.*;





@Namespace("cv") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_tracking.class)
public class MultiTracker_Alt extends Pointer {
    static { Loader.load(); }
    
    public MultiTracker_Alt(Pointer p) { super(p); }
    
    public MultiTracker_Alt(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public MultiTracker_Alt position(long position) {
        return (MultiTracker_Alt)super.position(position);
    }

  
  public MultiTracker_Alt() { super((Pointer)null); allocate(); }
  private native void allocate();

  
  public native @Cast("bool") boolean addTarget(@ByVal Mat image, @Const @ByRef Rect2d boundingBox, @Ptr @ByVal Tracker tracker_algorithm);
  public native @Cast("bool") boolean addTarget(@ByVal UMat image, @Const @ByRef Rect2d boundingBox, @Ptr @ByVal Tracker tracker_algorithm);
  public native @Cast("bool") boolean addTarget(@ByVal GpuMat image, @Const @ByRef Rect2d boundingBox, @Ptr @ByVal Tracker tracker_algorithm);

  
  public native @Cast("bool") boolean update(@ByVal Mat image);
  public native @Cast("bool") boolean update(@ByVal UMat image);
  public native @Cast("bool") boolean update(@ByVal GpuMat image);

  
  public native int targetNum(); public native MultiTracker_Alt targetNum(int setter);

  
  public native @ByRef TrackerVector trackers(); public native MultiTracker_Alt trackers(TrackerVector setter);

  
  public native @ByRef Rect2dVector boundingBoxes(); public native MultiTracker_Alt boundingBoxes(Rect2dVector setter);
  
  public native @ByRef ScalarVector colors(); public native MultiTracker_Alt colors(ScalarVector setter);
}