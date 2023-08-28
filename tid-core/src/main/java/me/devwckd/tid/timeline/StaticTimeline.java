package me.devwckd.tid.timeline;

import me.devwckd.tid.property.Properties;

public final class StaticTimeline implements Timeline {

    private final String name;
    private final int duration;
    private final Properties[] properties;

    StaticTimeline(String name, int duration, Properties[] properties) {
        this.name = name;
        this.duration = duration + 1;
        this.properties = properties;
    }

    @Override
    public Properties at(int frame) {
        return properties[frame % duration];
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getName() {
        return name;
    }
}
