/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package at.hephy.Rave;

public class RavePlane {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected RavePlane(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RavePlane obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        raveJNI.delete_RavePlane(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public RavePlane(RavePoint3D pos, RavePoint3D normal) {
    this(raveJNI.new_RavePlane(RavePoint3D.getCPtr(pos), pos, RavePoint3D.getCPtr(normal), normal), true);
  }

  public RavePoint3D position() {
    return new RavePoint3D(raveJNI.RavePlane_position(swigCPtr, this), true);
  }

  public RavePoint3D normalVector() {
    return new RavePoint3D(raveJNI.RavePlane_normalVector(swigCPtr, this), true);
  }

}
