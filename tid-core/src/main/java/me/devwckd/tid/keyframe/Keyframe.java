package me.devwckd.tid.keyframe;

import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.Interpolator;

public class Keyframe<V> {

    private final int startFrame;
    private final V value;
    private final Interpolator easing;

    public Keyframe(int startFrame, V value, Interpolator easing) {
        this.startFrame = startFrame;
        this.value = value;
        this.easing = easing;
    }

    public V compute(V last, int currentFrame, int duration, InterpolationApplier<V> interpolationApplier) {
        currentFrame -= startFrame;
        if(currentFrame == 0) return value;
        duration -= startFrame;

        return interpolationApplier.applyInterpolation(this.value, last, currentFrame, duration, easing);
    }

    public V getValue() {
        return value;
    }
}
