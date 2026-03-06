import config.EarlyBirdDiscountService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class DiscountController{
    private EarlyBirdDiscountService discountService;
    public DiscountController(Optional<EarlyBirdDiscountService> discountService){
        this.discountService= discountService.orElse(null);
    }
    @GetMapping(" /api/discount")
    public ResponseEntity<String> getDiscount(@RequestParam double price, @RequestParam LocalDate bookingDate, @RequestParam  LocalDate eventDate)
    {
        if(discountService==null){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("The Early Bird Discount service is currently disabled");
        }
      String result= discountService.discountService(price,bookingDate,eventDate);
        return ResponseEntity.ok(result);
    }
}
