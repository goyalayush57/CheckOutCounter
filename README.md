# Checkout Counter

Domain model for a checkout counter in an online retail store that scans products and generates an itemized bill.(*HardCoded list is used for demo purpose*) The bill should also total the cost of all the products and the applicable sales tax for each product. The total cost and total sales tax should be printed along with the detailed bill.

**About The Project :** It is a hiring project from Mediaocean.Two Endpoints are Exposed

 - `localhost:8082/cart/products` - The purpose of this endpoint is to get all the products along with category which the user has added to the cart
 Method type = GET
 - `localhost:8082/cart/detailedBill` - The purpose of this endpoint is to get the total bill (along with taxes applicable based on category of the product) which is needed to be paid by the consumer.
 Method type = GET

**Pre requisite :** 

 - JDK 1.8 or higher version should be installed

**Running the Project :** 

 - If you just want to run the project in your machine then download [com.cart-0.0.1-SNAPSHOT.jar](https://github.com/goyalayush57/CheckOutCounter/blob/master/com.cart/target/com.cart-0.0.1-SNAPSHOT.jar) located at the target folder(click on the link to download)
 - go to the location where the jar file is downloaded in the command prompt/terminal and type : 
   
     java -jar .\com.cart-0.0.1-SNAPSHOT.jar
     

 - After the spring boot application is started,goto your web browser or any API testing tool like POSTMAN and hit the above mentioned URL
 - VOILA!!



## Interaction diagrams


```mermaid
HTTP Client ->> REST Controller: localhost:8082/cart/products
REST Controller -> Service Class: query for product
REST Controller -> Service Class: return model
Service Class -> DAO Layer: get data from repository
```

> In case of queries please feel free to drop me a message or add a
> comment Please Contribute by forking this Project
