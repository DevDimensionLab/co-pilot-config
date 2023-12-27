package org.devdimensionlab.templates.client.conf

import org.devdimensionlab.templates.client.http.DefaultHttpClient

class RestApiHttpClient(baseUrl: String) : DefaultHttpClient("$baseUrl/resource")