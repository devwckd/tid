package me.devwckd.tid.property;

import me.devwckd.tid.interpolation.EasingInterpolator;
import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.Interpolator;

public interface PropertyBuilder<V> {

    PropertyBuilder<V> keyframe(int frame, V value, Interpolator easing);

    default PropertyBuilder<V> keyframe(int frame, V value) {
        return keyframe(frame, value, EasingInterpolator.LINEAR);
    }

    static <V> PropertyBuilder<V> newBuilder(String name, InterpolationApplier<V> interpolationApplier) {
        return new PropertyBuilderImpl<>(name, interpolationApplier);
    }

}
