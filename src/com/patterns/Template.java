package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class Template {
    public static void main(String... args){
        FirstDataService firstDataService = new FirstDataService();
        firstDataService.processData();
        SecondDataService secondDataService = new SecondDataService();
        secondDataService.processData();
    }
}

abstract class SomeDataService{
    public final void processData(){
        prepareData();
        doAction();
        disposeResources();
    }

    protected abstract void prepareData();
    protected abstract void doAction();
    protected abstract void disposeResources();
}

class FirstDataService extends SomeDataService{
    @Override
    protected void prepareData() {
        System.out.println("FirstDataService prepareData");
    }

    @Override
    protected void doAction() {
        System.out.println("FirstDataService doAction");
    }

    @Override
    protected void disposeResources() {
        System.out.println("FirstDataService disposeResources");
    }
}

class SecondDataService extends SomeDataService{
    @Override
    protected void prepareData() {
        System.out.println("SecondDataService prepareData");
    }

    @Override
    protected void doAction() {
        System.out.println("SecondDataService doAction");
    }

    @Override
    protected void disposeResources() {
        System.out.println("SecondDataService disposeResources");
    }
}