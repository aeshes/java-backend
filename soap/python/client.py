from zeep import Client

client = Client('http://localhost:8888/v1/order?wsdl')

order_type = client.get_type('ns0:order')
print(order_type)

customer_type = client.get_type('ns0:customer')
print(customer_type)


order_item_type = client.get_type('ns0:orderItem')
print(order_item_type)

order = order_type()
customer = customer_type()
customer.customerId = 'A123'
customer.firstName = 'John'
customer.lastName = 'Smith'
order.customer = customer

item = order_item_type()
item.itemId = '11'
item.qty = 11

order.orderItems.append(item)
print(order)

result = client.service.processOrder(order)
print(result)
