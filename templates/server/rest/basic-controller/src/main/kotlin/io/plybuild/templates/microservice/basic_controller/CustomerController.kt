package io.plybuild.templates.microservice.basic_controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/customers"])
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getCustomerById(@PathVariable customerId: String?): Customer {
        return customerService.getCustomerDetail(customerId)
    }
}