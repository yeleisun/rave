/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package at.hephy.Rave;

public class RaveKVertex {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected RaveKVertex(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RaveKVertex obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        raveJNI.delete_RaveKVertex(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public RaveKVertex(SWIGTYPE_p_rave__BasicKinematicVertex arg0) {
    this(raveJNI.new_RaveKVertex__SWIG_0(SWIGTYPE_p_rave__BasicKinematicVertex.getCPtr(arg0)), true);
  }

  public RaveKVertex() {
    this(raveJNI.new_RaveKVertex__SWIG_1(), true);
  }

  public RavePoint3D position() {
    return new RavePoint3D(raveJNI.RaveKVertex_position(swigCPtr, this), false);
  }

  public RaveCovariance3D error() {
    return new RaveCovariance3D(raveJNI.RaveKVertex_error(swigCPtr, this), false);
  }

  public SWIGTYPE_p_boost__weak_ptrT_rave__BasicKinematicTree_t correspondingTree() {
    return new SWIGTYPE_p_boost__weak_ptrT_rave__BasicKinematicTree_t(raveJNI.RaveKVertex_correspondingTree(swigCPtr, this), true);
  }

  public float ndf() {
    return raveJNI.RaveKVertex_ndf(swigCPtr, this);
  }

  public float chiSquared() {
    return raveJNI.RaveKVertex_chiSquared(swigCPtr, this);
  }

  public int id() {
    return raveJNI.RaveKVertex_id(swigCPtr, this);
  }

  public boolean isValid() {
    return raveJNI.RaveKVertex_isValid(swigCPtr, this);
  }

  public void unlink() {
    raveJNI.RaveKVertex_unlink(swigCPtr, this);
  }

}