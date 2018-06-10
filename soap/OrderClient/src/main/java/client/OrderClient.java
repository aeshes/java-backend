package client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import service.*;

public class OrderClient {

    final QName qName = new QName(
            "http://localhost:8888/v1/order", "OrderProcess");

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Specify the URL of the OrderProcess Web Service");
            System.exit(-1);
        }
        URL url = getWSDLURL(args[0]);
        OrderClient client = new OrderClient();
        client.processOrder(url);
    }

    private static URL getWSDLURL(String url) {
        URL result = null;
        try {
            result = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public void processOrder(URL url) {
        OrderProcess orderProcessingService = new OrderProcess(url, qName);

        System.out.println("Service is" + orderProcessingService);

        Order order = createOrder();

        OrderProcessService port = orderProcessingService.getOrderProcessPort();
        Order response = port.processOrder(order);

        System.out.println("Order id is " + response.getOrderId());
    }

    private Order createOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setCustomerId("A123");
        customer.setFirstName("John");
        customer.setLastName("Smith");
        order.setCustomer(customer);

        OrderItem item = new OrderItem();
        item.setItemId("11");
        item.setQty(11);

        order.getOrderItems().add(item);
        return order;
    }
}
