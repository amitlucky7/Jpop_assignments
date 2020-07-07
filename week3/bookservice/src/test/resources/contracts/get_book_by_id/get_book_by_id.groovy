import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("contract to obtain specific books by identifier")
    request {
        method("GET")
        urlPath("/book-service/books/1")
    }
    response {
        status OK()
        headers {
            header 'Content-Type': 'application/json;charset=UTF-8'
        }
        body(file("response.json"))
    }
}