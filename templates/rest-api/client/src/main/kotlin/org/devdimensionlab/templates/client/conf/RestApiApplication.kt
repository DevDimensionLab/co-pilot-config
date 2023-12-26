package org.devdimensionlab.templates.client.conf

import org.devdimensionlab.templates.client.http.HttpRestClient

class RestApiApplication(baseUrl: String) : HttpRestClient("$baseUrl/resource")