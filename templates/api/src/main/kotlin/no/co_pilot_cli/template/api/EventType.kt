package no.co_pilot_cli.template.api

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class EventType( val code : String ) {
    CREATE( "create"),
    UPDATE( "update"),
    DELETE( "delete");

    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun from(code: String): EventType = EventType.values().firstOrNull{ it.code == code }?.let { it }
                ?: throw IllegalArgumentException("Code `${code}` does not exist ${EventType.values().map { it.code }}")
    }

    @JsonValue
    override fun toString() = code
    
}
