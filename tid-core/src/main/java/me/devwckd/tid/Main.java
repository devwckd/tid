package me.devwckd.tid;

import me.devwckd.tid.interpolation.EasingInterpolator;
import me.devwckd.tid.interpolation.impl.DoubleInterpolationApplier;
import me.devwckd.tid.property.Properties;
import me.devwckd.tid.timeline.Timeline;
import me.devwckd.tid.timeline.TimelineBuilder;

public class Main {

    public static void main(String[] args) {
        final Timeline timeline = TimelineBuilder.newBuilder()
          .name("Cool Timeline") // Just for aesthetic purposes
          .duration(20) // 20 frames, can be overrided by property keyframes.
          .longProperty(
            "linearLong",
            builder -> builder
              .keyframe(0, 0L)
              .keyframe(25, 10L) // Overrides the duration
          )
          .doubleProperty(
            "easeInDouble",
            builder -> builder
              .keyframe(0, 0.0, EasingInterpolator.EASE_IN) // Eases in the values
              .keyframe(20, 50.0)
          )
          .build();

        for (int i = 0; i < timeline.getDuration(); i++) {
            final Properties properties = timeline.at(i);
            final Long linearLong = properties.get("linearLong");
            final Double easeInDouble = properties.get("easeInDouble");
        }
    }

}
