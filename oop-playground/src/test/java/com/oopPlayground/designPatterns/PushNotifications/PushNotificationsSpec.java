package com.oopPlayground.designPatterns.PushNotifications;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PushNotificationsSpec {

    Conversation conversation;
    Chat message;

    @Before
    public void setup() {
        conversation = new Conversation();
        message = new Chat();
        message.setMessage("Sample");
    }

    @Test
    public void shouldPushChatNotificationToRecipient() {
        //Given
        ChatApplicationObserver chatApplicationObserver = mock(ChatApplicationObserver.class);
        conversation.addRecipient(chatApplicationObserver);
        conversation.sendChat(message);

        //When
        conversation.notifyParticipants();

        //Then
        verify(chatApplicationObserver).update(message);
    }

    @Test
    public void shouldAddRecipientToConversation() {
        //Given
        ChatApplicationObserver chatApplicationObserver = mock(ChatApplicationObserver.class);
        ChatApplicationObserver secondChatApplicationObserver = mock(ChatApplicationObserver.class);
        conversation.addRecipient(chatApplicationObserver);

        //When
        conversation.addRecipient(secondChatApplicationObserver);
        conversation.sendChat(message);
        conversation.notifyParticipants();

        //Then
        verify(chatApplicationObserver).update(message);
        verify(secondChatApplicationObserver).update(message);
    }

    @Test
    public void shouldRemoveARecipientFromConversation() {
        //Given
        ChatApplicationObserver chatApplicationObserver = mock(ChatApplicationObserver.class);
        ChatApplicationObserver secondChatApplicationObserver = mock(ChatApplicationObserver.class);
        conversation.addRecipient(chatApplicationObserver);
        conversation.addRecipient(secondChatApplicationObserver);

        //When
        conversation.removeRecipient(chatApplicationObserver);
        conversation.sendChat(message);
        conversation.notifyParticipants();

        //Then
        verify(chatApplicationObserver, times(0)).update(message);
        verify(secondChatApplicationObserver).update(message);
    }

    @Test
    public void shouldPushChatNotificationToTwoApplications() {
        //Given
        ChatApplicationObserver desktopApplicationObserver = mock(DesktopChatApplication.class);
        ChatApplicationObserver mobileApplicationObserver = mock(MobileChatApplication.class);
        conversation.addRecipient(desktopApplicationObserver);
        conversation.addRecipient(mobileApplicationObserver);
        conversation.sendChat(message);

        //When
        conversation.notifyParticipants();

        //Then
        verify(desktopApplicationObserver).update(message);
        verify(mobileApplicationObserver).update(message);
    }

    @Test
    public void shouldPushChatNotificationToApplicationAndLogger() {
        //Given
        ChatApplicationObserver chatApplicationObserver = mock(ChatApplicationObserver.class);
        ChatLoggerObserver chatLoggerObserver = mock(ChatLoggerObserver.class);
        conversation.addRecipient(chatApplicationObserver);
        conversation.addRecipient(chatLoggerObserver);
        conversation.sendChat(message);

        //When
        conversation.notifyParticipants();

        //Then
        verify(chatApplicationObserver).update(message);
        verify(chatLoggerObserver).update(message);
    }
}
