package com.it4u.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.it4u.guava.eventbus.listeners.SimpleListener;

import java.util.concurrent.Executor;

public class AsyncEventBusExample
{
    public static void main(String[] args)
    {
        AsyncEventBus eventBus = new AsyncEventBus(new SeqExecutor());
        eventBus.register(new SimpleListener());
        eventBus.post("hello");

    }

    static class SeqExecutor implements Executor
    {
        @Override
        public void execute(Runnable command)
        {
            command.run();
        }
    }
}
