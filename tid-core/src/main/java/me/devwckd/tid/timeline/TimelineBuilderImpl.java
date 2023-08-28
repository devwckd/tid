package me.devwckd.tid.timeline;

import me.devwckd.tid.property.Properties;
import me.devwckd.tid.property.PropertyBuilder;
import me.devwckd.tid.interpolation.InterpolationApplier;
import me.devwckd.tid.property.PropertyBuilderImpl;

import java.util.*;
import java.util.function.Consumer;

public class TimelineBuilderImpl implements TimelineBuilder {

    private static final Properties[] EMPTY_PROPERTIES = new Properties[0];

    private final Map<String, PropertyBuilderImpl<?>> propertyBuilders;

    private String name;
    private int duration = 0;

    TimelineBuilderImpl(String name) {
        this.name = name;
        this.propertyBuilders = new HashMap<>();
    }

    @Override
    public TimelineBuilderImpl name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TimelineBuilderImpl duration(int duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public <V, I extends InterpolationApplier<V>> TimelineBuilderImpl property(String name, I interpolator, Consumer<PropertyBuilder<V>> consumer) {
        final PropertyBuilderImpl<V> propertyBuilder = (PropertyBuilderImpl<V>) PropertyBuilder.newBuilder(name, interpolator);
        consumer.accept(propertyBuilder);
        propertyBuilders.put(name, propertyBuilder);
        return this;
    }

    @Override
    public Timeline build() {
        int duration = this.duration;
        for (PropertyBuilderImpl<?> value : propertyBuilders.values()) {
            final int propertyDuration = value.getDuration();
            if(propertyDuration > duration) {
                duration = propertyDuration;
            }
        }
//        duration;

        final List<Properties> properties = new ArrayList<>(duration);
        for (int frame = 0; frame <= duration; frame++) {
            final Map<String, Object> propertiesMap = new HashMap<>();

            for (PropertyBuilderImpl<?> propertyBuilder : propertyBuilders.values()) {
                propertiesMap.put(propertyBuilder.getName(), propertyBuilder.buildFrame(frame, duration));
            }

            properties.add(new Properties(frame, propertiesMap));
        }

        return new StaticTimeline(name, duration, properties.toArray(EMPTY_PROPERTIES));
    }

}
