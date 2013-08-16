package com.oopPlayground.designPatterns.PushNotifications;

import com.oopPlayground.designPatterns.ObserverPattern.IObserver;
import com.oopPlayground.designPatterns.ObserverPattern.Observable;

public class Conversation extends Observable<Chat> {

    Chat chat;

    public void sendChat(Chat chat) {
        this.chat = chat;
    }

    public void notifyParticipants() {
        super.notifyObservers(this.chat);
    }

    public void addRecipient(IObserver recipient) {
        super.addObserver(recipient);
    }

    public void removeRecipient(IObserver recipient){
        super.removeObservers(recipient);
    }
}