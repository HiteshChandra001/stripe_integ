package com.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.model.RequestDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import com.stripe.model.Refund;
import com.stripe.param.PaymentIntentCaptureParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentIntentListParams;
import com.stripe.param.RefundCreateParams;

import jakarta.annotation.PostConstruct;

@Service
public class PaymentService {

	@Value("${SECRET_KEY}")
	private String apiKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = apiKey;
	}

	public String createPaymentIntent(RequestDto requestDto) throws StripeException {
		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount(requestDto.getAmount())
				.setCurrency(requestDto.getCurrency())
				 .addPaymentMethodType("card")
				    .addPaymentMethodType("giropay")
				    .setPaymentMethodOptions(
				      PaymentIntentCreateParams.PaymentMethodOptions.builder()
				        .setCard(
				          PaymentIntentCreateParams.PaymentMethodOptions.Card.builder()
				            .setCaptureMethod(
				              PaymentIntentCreateParams.PaymentMethodOptions.Card.CaptureMethod.MANUAL
				            )
				            .build()
				        )
				        .build()
				    )
				    .setPaymentMethod("pm_card_visa")
				    .build();
		PaymentIntent paymentIntent = PaymentIntent.create(params);
		paymentIntent.confirm();

		return paymentIntent.toJson();
	}

	public String captureIntent(String intentId) throws StripeException {
		PaymentIntent resource = PaymentIntent.retrieve(intentId);

		PaymentIntentCaptureParams params = PaymentIntentCaptureParams.builder().build();

		PaymentIntent paymentIntent = resource.capture(params);
		return paymentIntent.toJson();
	}

	public String createRefund(String intentId) throws StripeException {
		RefundCreateParams params = RefundCreateParams.builder().setPaymentIntent(intentId).build();
		Refund refund = Refund.create(params);
		return refund.toJson();
	}

	public String getAllIntents() throws StripeException {
		PaymentIntentListParams params = PaymentIntentListParams.builder().build();
		PaymentIntentCollection paymentIntents = PaymentIntent.list(params);
		return paymentIntents.toJson();
	}

}
