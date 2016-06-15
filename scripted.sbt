ScriptedPlugin.scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }

scriptedBufferLog := false
