package com.epam.tat

import groovyx.net.http.ContentType

class RestService {
    RestClient restClient = new RestClient()
    def path = '/v1/reports/struct_agg_v2'

    def restClientGet(json){
        def res = restClient.getRestClient()
        //res.handler.failure = res.handler.success
        res.post(path: path, contentType: ContentType.JSON, body: json)
    }
}
