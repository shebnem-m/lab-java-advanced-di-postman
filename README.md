First, Design Choices
Initially, I used a modular structure with config, controller, and service packages. I created a specific class for each layer (controller, service, and config).

@Configuration and @Bean: I used @Configuration because it represents and activates the @Bean definitions. With @Bean, I don't have to create the objects myself; Spring Boot creates and controls them automatically.

@ConditionalOnProperty: I used this for setting conditions. I configured it with name=feature.earlybird.enabled and havingValue=true. This activates the "Early Bird" project only when it's set to true in the application.properties file.

API Layer: I used @GetMapping to define the path for the API. I also used @RequestParam for filtering data and @ResponseEntity to return information and notifications.

1. Why did you choose constructor-based DI for this lab?
   I chose constructor-based DI because it is the best approach for safety and testability.

Mocking: It makes it easy to create Mock objects for testing.

Immutability: By using final variables, the dependencies become constant and cannot be changed.

Error Detection: Errors are not hidden. You can see any errors initially during the setup and correct them immediately, making the application more usable and healthy.

2. What advantages do Postman pre-request and post-response scripts offer for automated testing?
   Postman scripts help prevent repetition and make testing more efficient:

Pre-request Scripts: These are useful because I don't have to write the same code with different variables every time. For example, I don't have to manually type the eventDate repeatedly; the script can handle it. This is very good for testability.

Post-response Scripts: I use these to validate the response automatically. I can check the status code and ensure the message is consistent with the business rules. It also allows me to log key outputs for debugging.

3. How does your application behave when the early bird feature is disabled?
   If I set feature.earlybird.enabled=false in the application.properties, the feature is disabled.

In this case, the EarlyBirdDiscountService is not created.

In Postman, you will see the message: "The Early Bird Discount service is currently disabled."

Instead of a crash, a 503 Service Unavailable warning is shown.

4. What are some challenges you faced when integrating advanced DI with API testing?
   I faced some challenges because many things were new for me:

ResponseEntity: Initially, I didn't know @ResponseEntity, which was a bit difficult. But I learned that it shows notifications like "200 OK" and sends data to the API correctly.

Optional: I didn't know Optional before. I learned that it helps handle cases where a service might be missing.

Date Logic: Using long daysBetween = ChronoUnit.DAYS.between(bookingDate, eventDate); was new for me. I learned this is used to find the number of days between two dates.

Integration: Putting all these new things together—ResponseEntity, Optional, and the daysBetween logic—to work together was a big learning process.
