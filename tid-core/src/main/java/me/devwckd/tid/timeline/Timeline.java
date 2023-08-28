package me.devwckd.tid.timeline;

import me.devwckd.tid.property.Properties;

public interface Timeline {

    /**
     * Gets the properties from said frame
     * @param frame the frame number
     * @return the computed properties
     */
    Properties at(int frame);

    /**
     * Gets the timeline name
     * @return the name
     */
    String getName();

    /**
     * Gets the timeline total duration in frames
     * @return the duration
     */
    int getDuration();

}
