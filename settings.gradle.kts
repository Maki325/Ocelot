import java.util.Locale

if (!file(".git").exists()) {
    val errorText = """
        
        =====================[ ERROR ]=====================
         The Ocelot project directory is not a properly cloned Git repository.
         
         In order to build Ocelot from source you must clone
         the Ocelot repository using Git, not download a code
         zip from GitHub.
         
         Built Ocelot jars are available for download at
         https://ocelot.maki325.me/downloads
         
         See https://github.com/Maki325/Ocelot/blob/HEAD/CONTRIBUTING.md
         for further information on building and modifying Ocelot.
        ===================================================
    """.trimIndent()
    error(errorText)
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

rootProject.name = "ocelot"

for (name in listOf("Ocelot-API", "Ocelot-Server")) {
    val projName = name.toLowerCase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")!!.projectDir = file(name)
}
