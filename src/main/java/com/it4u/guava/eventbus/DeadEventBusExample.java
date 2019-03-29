package com.it4u.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.it4u.guava.eventbus.listeners.DeadEventListener;

public class DeadEventBusExample
{
    public static void main(String[] args)
    {
        final DeadEventListener deadEventListener = new DeadEventListener();
        final EventBus eventBus = new EventBus("DeadEventBus")
        {
            @Override
            public String toString()
            {
                return "DEAD-EVENT-BUS";
            }
        };
        eventBus.register(deadEventListener);
        eventBus.post("Hello");
    }
}
