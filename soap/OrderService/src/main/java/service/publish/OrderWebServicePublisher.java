package service.publish;

import javax.xml.ws.Endpoint;

import service.OrderProcessService;

public class OrderWebServicePublisher {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8888/v1/order",
                new OrderProcessService());
    }
}
