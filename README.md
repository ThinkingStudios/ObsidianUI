<center><div align="center">

<img height="100" src="common/src/main/resources/icon.png" width="100"/>

# ObsidianUI

[![GitHub license](https://img.shields.io/github/license/ThinkingStudios/ObsidianUI?style=flat-square)](https://raw.githubusercontent.com/ThinkingStudios/ObsidianUI/master/LICENSE)
![Environment: Client](https://img.shields.io/badge/environment-client-1976d2?style=flat-square)

SpruceUI unofficial architectury port.

A Minecraft mod API which adds some GUI utilities.

<img alt="fabric" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_vector.svg">
<img alt="forge" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/forge_vector.svg">

</div></center>


## Build

Just do `./gradlew build` and everything should build just fine!

## Use inside a mod

You can look at the [fabric-testmod](https://github.com/ThinkingStudios/ObsidianUI/tree/1.21-architectury/test-fabric)/[neoforge-testmod](https://github.com/ThinkingStudios/ObsidianUI/tree/1.21-architectury/test-neoforge) for examples of use.

### Import inside a project

Add this to your `build.gradle` in addition of the base mod `build.gradle`:

```groovy
repositories {
    maven { url = "https://api.modrinth.com/maven" }
}

dependencies {
    include modImplementation("maven.modrinth:obsidianui:${project.obsidianui_version}-${modloader}")
}
```

And this to your `gradle.properties`:

```properties
obsidianui_version=0.2.6+1.21
```
