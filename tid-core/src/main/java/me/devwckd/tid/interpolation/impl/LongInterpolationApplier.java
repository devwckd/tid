package me.devwckd.tid.interpolation.impl;

import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.Interpolator;

public final class LongInterpolationApplier implements InterpolationApplier<Long> {

    public static final LongInterpolationApplier INSTANCE = new LongInterpolationApplier();

    private LongInterpolationApplier() {}

    @Override
    public Long applyInterpolation(Long first, Long last, int frame, int duration, Interpolator interpolator) {
        return Math.round(interpolator.apply(first.doubleValue(), (last - first), frame, duration));
    }

    @Override
    public Long defaultValue() {
        return 0L;
    }
}
