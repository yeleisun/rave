/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package at.hephy.Rave;

public class RaveKTransientTrackParticle extends RaveKParticle {
  private long swigCPtr;

  protected RaveKTransientTrackParticle(long cPtr, boolean cMemoryOwn) {
    super(raveJNI.RaveKTransientTrackParticle_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RaveKTransientTrackParticle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        raveJNI.delete_RaveKTransientTrackParticle(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public RaveKTransientTrackParticle(RaveTrack initialTrack, float massGuess, float massSigma, float chiSquared, float degreesOfFr, SWIGTYPE_p_boost__any origin, String tag) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_0(RaveTrack.getCPtr(initialTrack), initialTrack, massGuess, massSigma, chiSquared, degreesOfFr, SWIGTYPE_p_boost__any.getCPtr(origin), tag), true);
  }

  public RaveKTransientTrackParticle(RaveTrack initialTrack, float massGuess, float massSigma, float chiSquared, float degreesOfFr, SWIGTYPE_p_boost__any origin) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_1(RaveTrack.getCPtr(initialTrack), initialTrack, massGuess, massSigma, chiSquared, degreesOfFr, SWIGTYPE_p_boost__any.getCPtr(origin)), true);
  }

  public RaveKTransientTrackParticle(RaveTrack initialTrack, float massGuess, float massSigma, float chiSquared, float degreesOfFr) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_2(RaveTrack.getCPtr(initialTrack), initialTrack, massGuess, massSigma, chiSquared, degreesOfFr), true);
  }

  public RaveKTransientTrackParticle(RaveTrack initialTrack, float massGuess, float massSigma, SWIGTYPE_p_boost__any origin, String tag) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_3(RaveTrack.getCPtr(initialTrack), initialTrack, massGuess, massSigma, SWIGTYPE_p_boost__any.getCPtr(origin), tag), true);
  }

  public RaveKTransientTrackParticle(RaveTrack initialTrack, float massGuess, float massSigma, SWIGTYPE_p_boost__any origin) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_4(RaveTrack.getCPtr(initialTrack), initialTrack, massGuess, massSigma, SWIGTYPE_p_boost__any.getCPtr(origin)), true);
  }

  public RaveKTransientTrackParticle(RaveTrack initialTrack, float massGuess, float massSigma) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_5(RaveTrack.getCPtr(initialTrack), initialTrack, massGuess, massSigma), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RaveCovariance7D error, int charge, float chiSquared, float degreesOfFr, SWIGTYPE_p_boost__any origin, String tag) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_6(RaveVector7D.getCPtr(state), state, RaveCovariance7D.getCPtr(error), error, charge, chiSquared, degreesOfFr, SWIGTYPE_p_boost__any.getCPtr(origin), tag), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RaveCovariance7D error, int charge, float chiSquared, float degreesOfFr, SWIGTYPE_p_boost__any origin) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_7(RaveVector7D.getCPtr(state), state, RaveCovariance7D.getCPtr(error), error, charge, chiSquared, degreesOfFr, SWIGTYPE_p_boost__any.getCPtr(origin)), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RaveCovariance7D error, int charge, float chiSquared, float degreesOfFr) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_8(RaveVector7D.getCPtr(state), state, RaveCovariance7D.getCPtr(error), error, charge, chiSquared, degreesOfFr), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr, RavePoint3D referencePoint, SWIGTYPE_p_boost__any origin, String tag) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_9(RaveVector7D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr, RavePoint3D.getCPtr(referencePoint), referencePoint, SWIGTYPE_p_boost__any.getCPtr(origin), tag), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr, RavePoint3D referencePoint, SWIGTYPE_p_boost__any origin) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_10(RaveVector7D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr, RavePoint3D.getCPtr(referencePoint), referencePoint, SWIGTYPE_p_boost__any.getCPtr(origin)), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr, RavePoint3D referencePoint) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_11(RaveVector7D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr, RavePoint3D.getCPtr(referencePoint), referencePoint), true);
  }

  public RaveKTransientTrackParticle(RaveVector7D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_12(RaveVector7D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr), true);
  }

  public RaveKTransientTrackParticle(RavePerigeeParameters6D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr, RavePoint3D referencePoint, SWIGTYPE_p_boost__any origin, String tag) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_13(RavePerigeeParameters6D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr, RavePoint3D.getCPtr(referencePoint), referencePoint, SWIGTYPE_p_boost__any.getCPtr(origin), tag), true);
  }

  public RaveKTransientTrackParticle(RavePerigeeParameters6D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr, RavePoint3D referencePoint, SWIGTYPE_p_boost__any origin) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_14(RavePerigeeParameters6D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr, RavePoint3D.getCPtr(referencePoint), referencePoint, SWIGTYPE_p_boost__any.getCPtr(origin)), true);
  }

  public RaveKTransientTrackParticle(RavePerigeeParameters6D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr, RavePoint3D referencePoint) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_15(RavePerigeeParameters6D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr, RavePoint3D.getCPtr(referencePoint), referencePoint), true);
  }

  public RaveKTransientTrackParticle(RavePerigeeParameters6D state, RavePerigeeCovariance6D error, int charge, double chiSquared, double degreesOfFr) {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_16(RavePerigeeParameters6D.getCPtr(state), state, RavePerigeeCovariance6D.getCPtr(error), error, charge, chiSquared, degreesOfFr), true);
  }

  public RaveKTransientTrackParticle() {
    this(raveJNI.new_RaveKTransientTrackParticle__SWIG_17(), true);
  }

  public RaveKTransientTrackParticle closestToTransversePoint(double x, double y) {
    return new RaveKTransientTrackParticle(raveJNI.RaveKTransientTrackParticle_closestToTransversePoint__SWIG_0(swigCPtr, this, x, y), true);
  }

  public RaveKTransientTrackParticle closestToTransversePoint(double x) {
    return new RaveKTransientTrackParticle(raveJNI.RaveKTransientTrackParticle_closestToTransversePoint__SWIG_1(swigCPtr, this, x), true);
  }

  public RaveKTransientTrackParticle closestToTransversePoint() {
    return new RaveKTransientTrackParticle(raveJNI.RaveKTransientTrackParticle_closestToTransversePoint__SWIG_2(swigCPtr, this), true);
  }

}
