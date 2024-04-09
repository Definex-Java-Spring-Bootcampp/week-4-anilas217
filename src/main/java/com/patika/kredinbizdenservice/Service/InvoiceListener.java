package com.patika.kredinbizdenservice.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceListener {
    @KafkaListener(topics = "invoice-topic", groupId = "invoice-group")
    public void handleInvoice(String Invoice) {
        System.out.println("Invoice has been created: " + Invoice);
    }
}
