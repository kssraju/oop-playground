package com.oopPlayground.designPatterns.PushNotifications;

import com.oopPlayground.designPatterns.ObserverPattern.IObserver;

public abstract class ChatApplicationObserver implements IObserver<Chat>, IChatApplication<Chat> {

    public abstract void ping(Chat message);

    public void update(Chat message) {
        ping(message);
    }
}

