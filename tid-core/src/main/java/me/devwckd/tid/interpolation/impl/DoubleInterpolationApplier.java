package me.devwckd.tid.interpolation.impl;

import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.Interpolator;

public final class DoubleInterpolationApplier implements InterpolationApplier<Double> {

    public static final DoubleInterpolationApplier INSTANCE = new DoubleInterpolationApplier();

    private DoubleInterpolationApplier() {}

    @Override
    public Double applyInterpolation(Double first, Double last, int frame, int duration, Interpolator interpolator) {
        return interpolator.apply(first, last - first, frame, duration);
    }

    @Override
    public Double defaultValue() {
        return 0.0;
    }
}
