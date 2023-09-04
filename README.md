<center><div align="center">

<img height="100" src="src/main/resources/icon.png" width="100"/>

# ObsidianUI

[![GitHub license](https://img.shields.io/github/license/LambdAurora/SpruceUI?style=flat-square)](https://raw.githubusercontent.com/LambdAurora/SpruceUI/master/LICENSE)
![Environment: Client](https://img.shields.io/badge/environment-client-1976d2?style=flat-square)

A Minecraft mod API which adds some GUI utilities.

<img alt="java17" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/built-with/java17_vector.svg">

<a href="https://modrinth.com/mod/architectury-api">
<img alt="architectury-api" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/requires/architectury-api_vector.svg">
</a>

<img alt="forge" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/forge_vector.svg">

</div></center>


## Build

Just do `./gradlew build` and everything should build just fine!

## Use inside a mod

You can look at the [SpruceUI test](src/main/java/dev/lambdaurora/spruceui/test) for examples of use.

### Import inside a project

Add this to your `build.gradle` in addition of the base Forge mod `build.gradle`:

```groovy
repositories {
    mavenLocal()
    maven { url = "https://api.modrinth.com/maven" }
}

dependencies {
    include modImplementation("maven.modrinth:spruceui-forge:${project.spruceui_version}")
}
```

And this to your `gradle.properties`:

```properties
spruceui_version=0.1.1+1.20.1
```

It will JAR-in-JAR SpruceUI so users of your mod don't need to download it separately!
