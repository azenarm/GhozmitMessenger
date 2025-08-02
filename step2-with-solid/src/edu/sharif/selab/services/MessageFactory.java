package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

public class MessageFactory {

    public static Message createMessage(int messageType) {
        switch (messageType) {
            case 1:
                return new SmsMessage();
            case 2:
                return new EmailMessage();
            case 3:
                return new TelegramMessage();
            default:
                throw new IllegalArgumentException("Invalid message type: " + messageType);
        }
    }

    public static MessageService createMessageService(int messageType) {
        switch (messageType) {
            case 1:
                return new SmsMessageService();
            case 2:
                return new EmailMessageService();
            case 3:
                return new TelegramMessageService();
            default:
                throw new IllegalArgumentException("Invalid message type: " + messageType);
        }
    }
}