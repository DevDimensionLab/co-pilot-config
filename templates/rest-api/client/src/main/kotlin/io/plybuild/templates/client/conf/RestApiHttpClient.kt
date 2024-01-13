package io.plybuild.templates.client.conf

import io.plybuild.templates.client.http.TypedHttpClient

class RestApiHttpClient(baseUrl: String) : TypedHttpClient("$baseUrl/resource")