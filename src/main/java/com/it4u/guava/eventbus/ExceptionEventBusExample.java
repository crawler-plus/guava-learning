package com.it4u.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.it4u.guava.eventbus.listeners.ExceptionListener;

public class ExceptionEventBusExample
{
    public static void main(String[] args)
    {
        final EventBus eventBus = new EventBus((exception, context) ->
        {
            System.out.println(context.getEvent());
            System.out.println(context.getEventBus());
            System.out.println(context.getSubscriber());
            System.out.println(context.getSubscriberMethod());
        });
        eventBus.register(new ExceptionListener());
        eventBus.post("exception post");
    }

}
