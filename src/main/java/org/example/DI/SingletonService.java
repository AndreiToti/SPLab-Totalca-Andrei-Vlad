package org.example.DI;

import org.springframework.stereotype.Component;

@Component("singletonService")
public class SingletonService {

    public SingletonService() {
        System.out.println(
                "SingletonService::Constructor= " + this);
    }

    public void executeOperation() {
        System.out.println(
                "Invoked SingletonService::executeOperation() on " + this);
    }
}