package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class BusinessDelegatePattern {
    public static void main(String... args){
        BusinessDelegate delegate = new BusinessDelegate();
        delegate.setServiceType("default");
        ClientApplication application = new ClientApplication(delegate);
        application.processTask();
    }
}

class ClientApplication{
    private BusinessDelegate businessDelegate;

    public ClientApplication(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    public void processTask(){
        businessDelegate.doTask();
    }
}

class BusinessDelegate{
    private LookUpService lookUpService = new LookUpService();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService = lookUpService.getServiceByType(serviceType);
        businessService.doProcess();
    }
}

class LookUpService{
    public BusinessService getServiceByType(String type){
        if ( type.equals("default")){
            return new BusinessService();
        }
        return null;
    }
}

class BusinessService{
    void doProcess(){
        System.out.println("Business service doProcess");
    }
}
