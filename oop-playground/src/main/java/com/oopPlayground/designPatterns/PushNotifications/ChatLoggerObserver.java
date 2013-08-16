package com.oopPlayground.designPatterns.PushNotifications;

import com.oopPlayground.designPatterns.ObserverPattern.IObserver;

public abstract class ChatLoggerObserver implements IObserver<Chat>, ILogger<Chat> {

    public abstract void log(Chat object);

    public void update(Chat state) {

    }
}

