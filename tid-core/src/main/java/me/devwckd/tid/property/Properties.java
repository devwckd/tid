package me.devwckd.tid.property;

import java.util.Collections;
import java.util.Map;

public class Properties {

    private final int frame;
    private final Map<String, Object> propertyMap;

    public Properties(int frame, Map<String, Object> propertyMap) {
        this.frame = frame;
        this.propertyMap = Collections.unmodifiableMap(propertyMap);
    }

    /**
     * Gets the value of the property with said name if it exists
     * @param name the property name
     * @return the value or null
     * @param <T> the value type
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) propertyMap.get(name);
    }

    @Override
    public String toString() {
        return "Properties{" +
          "frame=" + frame +
          ", properties=" + propertyMap +
          '}';
    }
}
