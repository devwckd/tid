package me.devwckd.tid.timeline;

import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.interpolation.impl.DoubleInterpolationApplier;
import me.devwckd.tid.interpolation.impl.LongInterpolationApplier;
import me.devwckd.tid.property.PropertyBuilder;

import java.util.function.Consumer;

public interface TimelineBuilder {

    TimelineBuilder name(String name);

    TimelineBuilder duration(int duration);

    <V, I extends InterpolationApplier<V>> TimelineBuilderImpl property(String name, I interpolator, Consumer<PropertyBuilder<V>> consumer);

    default TimelineBuilderImpl doubleProperty(String name, Consumer<PropertyBuilder<Double>> consumer) {
        return property(name, DoubleInterpolationApplier.INSTANCE, consumer);
    }

    default TimelineBuilderImpl longProperty(String name, Consumer<PropertyBuilder<Long>> consumer) {
        return property(name, LongInterpolationApplier.INSTANCE, consumer);
    }

    Timeline build();

    static TimelineBuilder newBuilder() {
        return newBuilder("Timeline");
    }

    static TimelineBuilder newBuilder(String name) {
        return new TimelineBuilderImpl(name);
    }

}
