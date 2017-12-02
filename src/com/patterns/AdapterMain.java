package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class AdapterMain {
    public static void main(String... args) {
        PaymentProcessor processor = PaymentProcessor.getInstance();
        Payment customPayment = new Payment();
        processor.processPayment(customPayment);
        ExternalPayment externalPayment = new ExternalPayment();
        Adapter<ExternalPayment, Payment> adapter = new ExternalPaymentAdapter();
        Payment external = adapter.adapt(externalPayment);
        processor.processPayment(external);
    }
}

class Payment {
    void pay() {
        System.out.println("called payment");
    }
}

class PaymentProcessor {
    private static PaymentProcessor instance;

    private PaymentProcessor() {
    }

    static {
        instance = new PaymentProcessor();
    }

    public static PaymentProcessor getInstance() {
        return instance;
    }

    void processPayment(Payment payment) {
        payment.pay();
    }
}

class ExternalPayment {
    void callPayment() {
        System.out.println("called external provider");
    }
}

class ExternalPaymentAdapter implements Adapter<ExternalPayment, Payment> {

    @Override
    public Payment adapt(ExternalPayment source) {
        return new Payment(){
            @Override
            void pay() {
                source.callPayment();
            }
        };
    }
}

interface Adapter<S, T> {
    T adapt(S source);
}
