package org.example.DI;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("transientService")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransientService {

    public TransientService() {
        System.out.println("TransientService::Constructor= " + this);
    }

    public void executeOperation() {
        System.out.println("Invoked TransientService::executeOperation() on " + this);
    }
}