package pl.sii.eu.producer.rest

org.springframework.cloud.contract.spec.Contract.make {
    request {
        description("""
Represents a very nasty object in terms of serialization/deserialization

            given:
                syntax of version of the most popular mobile operating systems
            when:
                client sends latest detected version
            then:
                we respond with current time
""")
        method 'POST'
        url '/nasty/systemversion'
        body(
                systemVersions: [
                        iPhone : value(consumer(regex('\\d+\\.\\d+\\.?\\d*')), producer('11.2')),
                        android: value(consumer(regex('\\d+\\.\\d+\\.?\\d*')), producer('7.0.0'))
                ]
        )
        headers {
            header 'Content-Type', 'application/vnd.nasty-version.request.v1+json;charset=UTF-8'
            header 'Accept', 'application/vnd.nasty-version.response.v1+json;charset=UTF-8'
        }
    }
    response {
        status 200
        body("""
            {
                "time": "2017-12-04T20:51:34Z"
            }
        """)
        headers {
            header 'Content-Type', 'application/vnd.nasty-version.response.v1+json;charset=UTF-8'
        }
    }
}