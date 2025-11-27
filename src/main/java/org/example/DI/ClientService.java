package org.example.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("clientService")
public class ClientService {


    private final TransientService transientInstance;
    private final SingletonService singletonInstance;

    @Autowired
    public ClientService(TransientService transientService, SingletonService singletonService) {
        this.transientInstance = transientService;
        this.singletonInstance = singletonService;

        System.out.println("ClientService::Constructor= " + this);
        System.out.println("SingletonService Instance= " + singletonService);
        System.out.println("TransientService Instance= " + transientService);
    }

    public void executeClientLogic() {
        System.out.println("Invoked ClientService::executeClientLogic() on " + this);
        System.out.println("Using SingletonService Instance= " + singletonInstance);
        singletonInstance.executeOperation();
        System.out.println("Using TransientService Instance= " + transientInstance);
        transientInstance.executeOperation();
    }
}