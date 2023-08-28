# tid  
  
A simple static timeline interpolation library.

## Index

1. [Installation](#installation)
   1. [Gradle KTS](#gradle-kts)
   2. [Gradle Groovy](#gradle-groovy)
   3. [Maven](#maven)
2. [Usage](#usage)
3. [Roadmap](#roadmap)
4. [Spigot Support](#spigot-support)
5. [Contributing](#contributing)
6. [License](#license)
7. [Thanks](#thanks)

### Installation

All artifacts are stored on [Maven Central](https://central.sonatype.com/).

#### Gradle KTS
```kotlin
dependencies {
    implementation("me.devwckd.tid:tid-core:{latestVersion}")
}
```

#### Gradle Groovy

```groovy
dependencies {
    implementation 'me.devwckd.tid:tid-core:{latestVersion}'
}
```

#### Maven
```xml
<dependencies>
    <dependency>
        <groupId>me.devwckd.tid</groupId>
        <artifactId>tid-core</artifactId>
        <version>{latestVersion}</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

### Usage

Sample usage

```java
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
          .keyframe(0, 0.0, EasingInterpolator.EASE_IN) // Applies the EaseIn function to the keyframe
          .keyframe(20, 50.0)
  )
  .build();

  for (int i = 0; i < timeline.getDuration(); i++) {
    final Properties properties = timeline.at(i);
    final Long linearLong = properties.get("linearLong");
    final Double easeInDouble = properties.get("easeInDouble");
  }
```

### Roadmap

- [ ] Add more easing functions ([ref](https://github.com/mattdesl/cisc226game/blob/master/SpaceGame/src/space/engine/easing/Easing.java))
- [ ] Add compute properties
- [ ] Make a Json and/or Binary Serializer and Deserializer module

### Spigot Support

Spigot support documentation is available in [README_SPIGOT.md](README_SPIGOT.md)

### Contributing

Pull request and issues are always appreciated.  
Just make sure to explain what the changes you're proposing do on the description.

### License

**tid** is free, open source and permissively licensed under the **MIT License** ([LICENSE-MIT](LICENSE-MIT) or http://opensource.org/licenses/MIT)

### Thanks

Thanks for reading and using tid :)  
Leave a ⭐ if it helped you.