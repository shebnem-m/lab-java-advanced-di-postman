package config;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class EarlyBirdDiscountService{
    public String discountService(double price, LocalDate bookingDate,LocalDate eventDate){
        long daysBetween=ChronoUnit.DAYS.between(bookingDate, eventDate);
        if(daysBetween>=30){
            double discountedPrice=price-price*0.15;
            return "Congratulations! You received a 15% discount for booking at least 30 days in advance. New price: " + discountedPrice;
        }
        if(daysBetween<=0){
           return "Error: The event has already taken place or is happening today. Price "+ price ;
        }
        else{
            return "Sorry, no discount is available (less than 30 days remaining). Price: " + price;
        }
    }
}
