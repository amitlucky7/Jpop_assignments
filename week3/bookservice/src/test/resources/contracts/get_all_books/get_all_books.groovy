import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("contract to obtain all available books")
    request {
        method("GET")
        urlPath("/book-service/books")
    }
    response {
        status OK()
        headers {
            header 'Content-Type': 'application/json;charset=UTF-8'
        }
        body(file("response.json"))
    }
}