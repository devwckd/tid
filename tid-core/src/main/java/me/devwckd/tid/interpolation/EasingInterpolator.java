package me.devwckd.tid.interpolation;


/**
 * <a href="https://github.com/mattdesl/cisc226game/blob/master/SpaceGame/src/space/engine/easing/Easing.java">Equations Source</a>
 */
public interface EasingInterpolator extends Interpolator {

    /**
     * Linear - no tweening
     */
    EasingInterpolator LINEAR = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return change * currentFrame / totalFrames + first;
    };

    /**
     * Quadratic Ease In
     */
    EasingInterpolator EASE_IN_QUAD = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return change * (currentFrame /= totalFrames) * currentFrame + first;
    };

    /**
     * Quadratic Ease Out
     */
    EasingInterpolator EASE_OUT_QUAD = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return -change * (currentFrame /= totalFrames) * (currentFrame - 2) + first;
    };

    /**
     * Quadratic Ease In & Out
     */
    EasingInterpolator EASE_IN_OUT_QUAD = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        if ((currentFrame /= totalFrames / 2) < 1) return change / 2 * currentFrame * currentFrame + first;
        return -change / 2 * ((--currentFrame) * (currentFrame - 2) - 1) + first;
    };

    /**
     * Cubic Ease In
     */
    EasingInterpolator EASE_IN_CUBIC = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return change * (currentFrame /= totalFrames) * currentFrame * currentFrame + first;
    };

    /**
     * Cubic Ease Out
     */
    EasingInterpolator EASE_OUT_CUBIC = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        return change * ((currentFrame = currentFrame / totalFrames - 1) * currentFrame * currentFrame + 1) + first;
    };

    /**
     * Cubic Ease In & Out
     */
    EasingInterpolator EASE_IN_OUT_CUBIC = (first, last, currentFrame, totalFrames) -> {
        double change = last - first;
        if ((currentFrame /= totalFrames / 2) < 1)
            return change / 2 * currentFrame * currentFrame * currentFrame + first;
        return change / 2 * ((currentFrame -= 2) * currentFrame * currentFrame + 2) + first;
    };

}
