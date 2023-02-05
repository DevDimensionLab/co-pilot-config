package org.devdimensionlab.template.microservice.foo

import org.springframework.stereotype.Service

@Service
class FooService {
    fun getAll(): List<Foo> {
        return listOf()
    }
}