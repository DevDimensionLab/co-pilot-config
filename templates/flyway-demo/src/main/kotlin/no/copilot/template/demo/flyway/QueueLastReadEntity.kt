package no.copilot.template.demo.flyway

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version


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