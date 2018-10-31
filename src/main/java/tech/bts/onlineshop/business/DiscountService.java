package tech.bts.onlineshop.business;

import tech.bts.onlineshop.model.Discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountService {

    private Map<String, Discount> discountMap;

    public DiscountService() {


        this.discountMap = new HashMap<>();
    }



    public void  createDiscount(Discount discount) {

        discountMap.put(discount.getId(),discount);

    }

    public double calculateFinalAmount(String id, double amount) {
        double finalAmount;

        if (discount.getId().equals(discount.getName())) {
         finalAmount =  discount.getAmount() - createDiscount();

        } else {
            finalAmount = amount;
        }

      return finalAmount;
    }

}




// In DiscountService, define a method to create a discount (it will add it to the map).
// The id of the Discount object will be already set, so DiscountService is NOT responsible to generate the ids like ProductDatabase.

// Also in DiscountService, create a method calculateFinalAmount that takes a discount id and an amount (those are the parameters), and returns the final amount after applying the discount. If the discount doesn't exist, then the method just returns the original amount with no discount.
// This method has to check if the discount exists, and if so, check if the discount is absolute or a percentage to properly calculate the final amount.