package me.devwckd.tid.minecraft.interpolation.impl;

import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.Interpolator;
import org.bukkit.util.Vector;

public final class VectorInterpolationApplier implements InterpolationApplier<Vector> {

    public static final VectorInterpolationApplier INSTANCE = new VectorInterpolationApplier();

    private VectorInterpolationApplier() {
    }

    @Override
    public Vector applyInterpolation(Vector first, Vector last, int frame, int duration, Interpolator easing) {
        return new Vector(
          easing.apply(first.getX(), last.getX(), frame, duration),
          easing.apply(first.getY(), last.getY(), frame, duration),
          easing.apply(first.getZ(), last.getZ(), frame, duration)
        );
    }

    @Override
    public Vector defaultValue() {
        return new Vector();
    }
}
