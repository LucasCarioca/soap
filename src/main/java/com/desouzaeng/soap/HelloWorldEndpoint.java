package com.desouzaeng.soap;

import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWorldEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloWorldRequest")
    @ResponsePayload
    public GetHelloWorldResponse getCountry(@RequestPayload GetHelloWorldRequest getHelloWorldRequest) {
        GetHelloWorldResponse getHelloWorldResponse = new GetHelloWorldResponse();
        Message message = new Message();
        message.setText("Hello " + getHelloWorldRequest.getName());
        getHelloWorldResponse.setMessage(message);
        return getHelloWorldResponse;
    }
}