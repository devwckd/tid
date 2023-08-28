package me.devwckd.tid.property;

import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.Interpolator;
import me.devwckd.tid.keyframe.Keyframe;

import java.util.Map;
import java.util.TreeMap;

public class PropertyBuilderImpl<V> implements PropertyBuilder<V> {

    private final String name;
    private final InterpolationApplier<V> interpolationApplier;
    private final TreeMap<Integer, Keyframe<V>> keyframes;
    private int duration = 0;

    PropertyBuilderImpl(String name, InterpolationApplier<V> interpolationApplier) {
        this.name = name;
        this.interpolationApplier = interpolationApplier;
        this.keyframes = new TreeMap<>();
    }

    public PropertyBuilderImpl<V> keyframe(int frame, V value, Interpolator easing) {
        keyframes.put(frame, new Keyframe<>(frame, value, easing));

        if(frame > duration) {
            duration = frame;
        }

        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Object buildFrame(int frame, int totalDuration) {
        final Map.Entry<Integer, Keyframe<V>> floorEntry = keyframes.floorEntry(frame);
        if(floorEntry == null) return interpolationApplier.defaultValue();

        final Keyframe<V> startKeyframe = floorEntry.getValue();

        final Map.Entry<Integer, Keyframe<V>> ceilingEntry = keyframes.higherEntry(frame);
        int endFrame = ceilingEntry == null ? totalDuration : ceilingEntry.getKey();
        final V endKeyframeValue = ceilingEntry == null ? startKeyframe.getValue() : ceilingEntry.getValue().getValue();

        return startKeyframe.compute(endKeyframeValue, frame, endFrame, interpolationApplier);
    }

    public String getName() {
        return name;
    }
}
