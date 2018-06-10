package service;

import service.model.Order;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "OrderProcess",
    portName = "OrderProcessPort",
    targetNamespace = "http://localhost:8888/v1/order")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
    parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class OrderProcessService {

    @WebMethod
    public Order processOrder(Order order) {
        System.out.println("processOrder called for customer: "
            + order.getCustomer().getCustomerId());

        if (order.getOrderItems() != null) {
            System.out.println("Number of items is: "
                + order.getOrderItems().length);
        }

        order.setOrderId("A1234");
        return order;
    }
}
