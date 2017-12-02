package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class Facade {
    public static void main(String... args) {
        CustomPaymentProcessor processor = new CustomPaymentProcessor();
        processor.processDefault();
        processor.processExternal();
    }
}

class CustomPaymentProcessor {
    private Payment defaultPayment;
    private Payment external;

    public CustomPaymentProcessor() {
        defaultPayment = new Payment();
        external = new ExternalPaymentAdapter().adapt(new ExternalPayment());
    }

    public void processDefault() {
        PaymentProcessor.getInstance().processPayment(defaultPayment);
    }

    public void processExternal(){
        PaymentProcessor.getInstance().processPayment(external);
    }
}