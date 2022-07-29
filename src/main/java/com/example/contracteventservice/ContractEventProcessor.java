package com.example.contracteventservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ContractEventProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class);
        exchange.getOut().setBody(message);
    }
}
