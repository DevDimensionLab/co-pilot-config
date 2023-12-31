package org.devdimensionlab.templates.client.conf

import org.devdimensionlab.templates.client.http.TypedHttpClient

class RestApiHttpClient(baseUrl: String) : TypedHttpClient("$baseUrl/resource")