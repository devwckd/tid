package me.devwckd.tid.interpolation;

public interface Interpolator {

    double apply(double first, double last, double frame, double duration);

}
