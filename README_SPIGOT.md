# tid - Spigot Support
  
### Installation

Spigot support needs the `tid-spigot` artifact.

#### Gradle KTS
```kotlin
dependencies {
    implementation("me.devwckd.tid:tid-spigot:{latestVersion}")
}
```

#### Gradle Groovy

```groovy
dependencies {
    implementation 'me.devwckd.tid:tid-spigot:{latestVersion}'
}
```

#### Maven
```xml
<dependencies>
    <dependency>
        <groupId>me.devwckd.tid</groupId>
        <artifactId>tid-spigot</artifactId>
        <version>{latestVersion}</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

### Usage

tid-spigot adds support for the usage of `org.bukkit.util.Vector` as the keyframe value.

```java
final Timeline timeline = TimelineBuilder.newBuilder()
  .name("Spigot Timeline") 
  .duration(20)
  .property(
      "easeInVector",
      VectorInterpolationApplier.INSTANCE,
      builder -> builder
          .keyframe(0, new Vector(0.0, 1.0, 0.0), EasingInterpolator.EASE_IN)
          .keyframe(25, new Vector(0.0, 3.0, 2.0)) 
  )
  .build();

  for (int i = 0; i < timeline.getDuration(); i++) {
    final Properties properties = timeline.at(i);
    final Vector easeInVector = properties.get("easeInVector");
  }
```

### Example Plugin

[tid-spigot-example](https://github.com/devwckd/tid-spigot-example)

### Feature Requests

Feel free to suggest any features that would work well if supported by the lib on the [issues](https://github.com/devwckd/tid/issues).
