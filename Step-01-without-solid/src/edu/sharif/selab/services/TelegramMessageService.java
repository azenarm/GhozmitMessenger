package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

import java.util.regex.Pattern;

public class TelegramMessageService implements MessageService{
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if(validateUsername(telegramMessage.getSourceUsername()) && validateUsername(telegramMessage.getSourceUsername())){
            System.out.println("Sending a telegram message from " + telegramMessage.getSourceUsername() + " to " + telegramMessage.getTargetUsername() + " with content : " + telegramMessage.getContent());
        }else{
            throw new IllegalArgumentException("Telegram username is Not Correct!");
        }
    }

    public boolean validateUsername(String username) {
        // Regular expression pattern for validating username
        String usernamePattern = "^@[a-zA-Z0-9_]{5,32}$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(usernamePattern);

        // Check if the username string matches the regex pattern
        return pattern.matcher(username).matches();
    }
}
