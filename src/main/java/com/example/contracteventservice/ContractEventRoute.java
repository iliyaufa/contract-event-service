package com.example.contracteventservice;

import com.example.contractprocessingservice.model.ContractStatus;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class ContractEventRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(8285).producerComponent("http");

        from("rabbitmq:contract.event?queue=contract.event&routingKey=soap&autoDelete=false").log("before processing" + "${body}")
                //.process("contractEventProcessor")
                .log("after processing ${body}")
                .to("rest:post:status")
                .end();
    }
}
