package io.plybuild.test.templates

import com.fasterxml.jackson.annotation.JsonProperty

data class Ply(
    @JsonProperty("package") val _package : String?
)
