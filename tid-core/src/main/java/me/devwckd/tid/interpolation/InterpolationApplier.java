package me.devwckd.tid.interpolation;

public interface InterpolationApplier<V> {

    V applyInterpolation(V first, V last, int frame, int duration, Interpolator easing);

    V defaultValue();
}
