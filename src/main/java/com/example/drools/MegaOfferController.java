package com.example.drools;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MegaOfferController {

    @Autowired
    private KieSession session;

    // @PostMapping("/order")
    // public Order orderNow(@RequestBody Order order) {
    //     if (order.getCardType().equalsIgnoreCase("HSBC") && order.getPrice() > 10000) {
    //         order.setDiscount(10);
    //     }
    //     if (order.getCardType().equalsIgnoreCase("ICICI") && order.getPrice() > 15000) {
    //         order.setDiscount(8);
    //     }
    //     return order;
    // }

    @PostMapping("/order")
    public Order orderNow(@RequestBody Order order) {
        session.insert(order);
        session.fireAllRules();
        return order;
    }
}
