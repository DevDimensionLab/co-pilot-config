package no.copilot.template.demo.flyway

import java.time.LocalDateTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Version


@Table(name = "QUEUE_LAST_READ")
@Entity
class QueueLastReadEntity(

        @Id
        @Column(name = "ID")
        @Enumerated(EnumType.STRING)
        val koe : Queue,

        @Column(name = "POSITION")
        var sekvensnummer : Long = 0,

        @Column(name = "LAST_UPDATE")
        var registrert : LocalDateTime = LocalDateTime.now(),

        @Version
        @Column(name = "VERSION")
        val version: Long = -1
)