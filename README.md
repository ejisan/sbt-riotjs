# Riot Source Compiler Plugin

This plugin hooks your `.tag` files in the Asset compilation phase.
It works with `SbtWeb`.

To use this plugin use the addSbtPlugin command within your project's
plugins.sbt.

```scala
addSbtPlugin("com.ejisan.sbt" % "sbt-riotjs" % "2.2.4")
```

Your project's build file also needs to enable sbt-web plugin.

```scala
lazy val root = (project in file(".")).enablePlugins(SbtWeb)
```

## License

`sbt-riotjs` is licensed under the [Apache License, Version 2.0](./LICENSE)
