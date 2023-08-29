package me.devwckd.tid.interpolation;

public interface EasingInterpolator extends Interpolator {

    EasingInterpolator LINEAR = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return change * currentFrame / totalFrames + first;
    };

    EasingInterpolator EASE_IN = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return change * (currentFrame /= totalFrames) * currentFrame + first;
    };
}
