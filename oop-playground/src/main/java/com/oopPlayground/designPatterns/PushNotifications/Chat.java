package com.oopPlayground.designPatterns.PushNotifications;

import com.oopPlayground.designPatterns.ObserverPattern.State;

public class Chat extends State {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
