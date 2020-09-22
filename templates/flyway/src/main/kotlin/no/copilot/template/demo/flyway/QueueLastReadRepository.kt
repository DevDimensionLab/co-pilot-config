package no.copilot.template.demo.flyway

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QueueLastReadRepository : JpaRepository<QueueLastReadEntity, Queue>