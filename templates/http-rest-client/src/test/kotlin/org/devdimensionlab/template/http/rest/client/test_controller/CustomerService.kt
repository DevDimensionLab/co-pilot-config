package org.devdimensionlab.template.http.rest.client.test_controller

import org.springframework.stereotype.Service

@Service
class CustomerService {
    fun getCustomerDetail(customerId: String?): Customer {
        return Customer("42", "po", "Codify")
    }
}