package com.maxstudio.app.data

data class Project(
    val id: String,
    val name: String,
    val format: String,
    val status: String
)

enum class VideoFormat(val label: String) {
    PORTRAIT("9:16"), LANDSCAPE("16:9"), SQUARE("1:1")
}

val SampleProjects = listOf(
    Project("sample-1", "City lights at night", "9:16", "Draft"),
    Project("sample-2", "Behind the scenes", "16:9", "In progress")
)
