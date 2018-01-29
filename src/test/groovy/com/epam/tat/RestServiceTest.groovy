package com.epam.tat

import org.testng.annotations.Test

class RestServiceTest {

    RestService restService = new RestService()
    def json = '''{
    "attr": [
        {
            "name": "director",
            "size": 5
        }
    ],
    "metrics": [
        {
            "name": "volume",
            "type": "sys",
            "nullInclude": false,
            "bucketName": "doc_count"
        }
    ],
    "refinementBehavior": 0,
    "filter": {
        "date": {
            "startDate": 20140101,
            "endDate": 20160201
        }
    },
    "source": {
        "cluster": {
            "hosts": [
                {
                    "http": {
                        "hostName": "dev02",
                        "hostAddress": "10.153.75.47",
                        "port": 9200
                    },
                    "transport": {
                        "hostName": "dev02",
                        "hostAddress": "10.153.75.47",
                        "port": 9300
                    }
                }
            ],
            "description": "dev02",
            "name": "dev02"
        },
        "index": {
            "readAlias": "read_1\$4036746",
            "writeAlias": "write_1\$4036746",
            "dataIndexName": "1\$4036746",
            "percolatorIndexName": "1$p\$4036746"
        }
    },
    "systemSchema": {
        "user": "ss_testshm",
        "password": "ss_testshm",
        "url": "jdbc:postgresql://10.153.75.47:5432/postgres",
        "serverName": "dev02",
        "databaseName": "postgres",
        "portNumber": 5432,
        "description": "System schema"
    },
    "projectId": 1,
    "projectName": "projectName_log",
    "accountId": 101,
    "accountName": "accountName_log",
    "contentProviderId": 102,
    "contentProviderName": "contentProviderName_log",
    "widgetId": 103,
    "widgetName": "widgetName_log",
    "userLoggedInName": "userName_log",
    "userLoggedInId": 104,
    "userRunAsName": "userName_log",
    "userRunAsId": 104,
    "dashboardId": 105,
    "dashboardName": "dashboardName_log"
}'''


    @Test
    void testGet() {
        new Proxy().server
        def temp = restService.restClientGet(json)
        println(temp)
    }
}
