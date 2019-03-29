package com.it4u.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.it4u.guava.eventbus.service.QueryService;
import com.it4u.guava.eventbus.service.RequestQueryHandler;

public class ComEachOtherEventBusExample
{
    public static void main(String[] args)
    {
        final EventBus eventBus = new EventBus();
        QueryService queryService = new QueryService(eventBus);
        eventBus.register(new RequestQueryHandler(eventBus));
        queryService.query("1234567890");
    }
}
