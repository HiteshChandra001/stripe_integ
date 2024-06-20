package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.RequestDto;
import com.demo.services.PaymentService;
import com.stripe.exception.StripeException;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

	@Autowired
	private PaymentService service;

	@PostMapping("/create_intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody RequestDto request) {
		try {
			String intent = service.createPaymentIntent(request);
			return ResponseEntity.ok(intent);
		} catch (StripeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	 @PostMapping("/capture_intent/{id}")
	    public ResponseEntity<String> capturePaymentIntent(@PathVariable String id) {
	        try {
	        	String intent = service.captureIntent(id);
	            return ResponseEntity.ok(intent);
	        } catch (StripeException e) {
				e.printStackTrace();
	            return ResponseEntity.badRequest().body(null);
	        }
	    }

	    @PostMapping("/create_refund/{id}")
	    public ResponseEntity<String> createRefund(@PathVariable String id) {
	        try {
	        	String refund = service.createRefund(id);
	            return ResponseEntity.ok(refund);
	        } catch (StripeException e) {
				e.printStackTrace();
	            return ResponseEntity.badRequest().body(null);
	        }
	    }

	    @GetMapping("/get_intents")
	    public ResponseEntity<String> getPaymentIntents() {
	        try {
	        	String intents = service.getAllIntents();
	            return ResponseEntity.ok(intents);
	        } catch (StripeException e) {
				e.printStackTrace();
	            return ResponseEntity.badRequest().body(null);
	        }
	    }
}
