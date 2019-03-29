package com.it4u.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.it4u.guava.eventbus.listeners.MultipleEventListeners;

public class MultipleEventBusExample
{
    public static void main(String[] args)
    {
        final EventBus eventBus = new EventBus();
        eventBus.register(new MultipleEventListeners());
        System.out.println("post the string event");
        eventBus.post("I am string event");
        System.out.println("post the int event");
        eventBus.post(1000);
    }
}
