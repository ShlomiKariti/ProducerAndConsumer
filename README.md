# ProducerAndConsumer
How to start the program(for Windows users) : 
1. Install Erlang.
2. Install RabbitMQ.
3. Enter RabbitMQ's Command Prompt and type : "rabbitmq-plugins enable rabbitmq_management" in order to start the server
4. Enter the URL: http://localhost:15672/ for RabbitMQ's Management page.
5. Fork/clone the project.
6. Run the program on an IDE.
7. Test with Postman using the following JSON template:
  - URL : http://localhost:8080/products
  - BODY :
{
  "productId" : 1,
  "name" : "Desk",
  "quantity" : 15
}

You can change the information in the JSON body as you wish(not the variable names).

Enjoy :)
