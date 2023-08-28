package me.devwckd.tid.interpolation;

public interface EasingInterpolator extends Interpolator {

    EasingInterpolator LINEAR = (first, last, currentFrame, totalFrames) ->
      last * currentFrame / totalFrames + first;

    EasingInterpolator EASE_IN = (first, last, currentFrame, totalFrames) ->
      last * (currentFrame /= totalFrames) * currentFrame + first;
}
