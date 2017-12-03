package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class Bridge {
    public static void main(String... args){
        SomeBridge first = new BridgeImplFirst();
        SomeBridge second = new BridgeImplSecond();
        AbstractBridge abstractBridge1 = new AbstractBridgeImpl(first);
        abstractBridge1.callSomeMethod();
        AbstractBridge abstractBridge2 = new AbstractBridgeImpl(second);
        abstractBridge2.callSomeMethod();
    }
}

interface SomeBridge {
    void method();
}

class BridgeImplFirst implements SomeBridge {
    @Override
    public void method() {
        System.out.println("BridgeImplFirst : Calling method");
    }
}

class BridgeImplSecond implements SomeBridge {
    @Override
    public void method() {
        System.out.println("BridgeImplSecond : Calling method");
    }
}

interface AbstractBridge {
    void callSomeMethod();
}

class AbstractBridgeImpl implements AbstractBridge {
    private SomeBridge bridge;

    public AbstractBridgeImpl(SomeBridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void callSomeMethod() {
        bridge.method();
    }
}
