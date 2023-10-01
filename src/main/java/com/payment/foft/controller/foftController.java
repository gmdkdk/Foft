package com.payment.foft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/api/v1")
public class foftController {

    @GetMapping("/reserve")
    public String reservePage(){
        return "foft_reserve";
    }

    @PostMapping("/payment")
    public String paymentPage(
            @RequestParam(value = "order_id")       String orderId,
            @RequestParam(value = "order_name")     String orderName,
            @RequestParam(value = "customer_email") String customerEmail,
            @RequestParam(value = "customer_name")  String customerName,
            @RequestParam(value = "total_amt")      String totalAmt,
            Model model
    ) {
        System.out.println("orderId = " + orderId);
        System.out.println("orderName = " + orderName);
        System.out.println("customerEmail = " + customerEmail);
        System.out.println("customerName = " + customerName);
        System.out.println("total_amt = " + totalAmt);

        model.addAttribute("order_id"       , orderId);
        model.addAttribute("order_name"     , orderName);
        model.addAttribute("customer_email" , customerEmail);
        model.addAttribute("customer_name"  , customerName);
        model.addAttribute("total_amt"      , totalAmt);

        return "foft_payment";
    }

}
