package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.TelegramMessage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TelegramMessageService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        if (!(message instanceof TelegramMessage)) {
            throw new IllegalArgumentException("Invalid message type for Telegram service");
        }

        TelegramMessage telegramMessage = (TelegramMessage) message;
        if (validateUsername(telegramMessage.getSourceUsername())
                && validateUsername(telegramMessage.getTargetUsername())) {
            System.out.println("Sending a telegram message from " + telegramMessage.getSourceUsername() + " to "
                    + telegramMessage.getTargetUsername() + " with content : " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Telegram username is Not Correct!");
        }
    }

    @Override
    public Message collectInput(Scanner scanner) {
        TelegramMessage telegramMessage = new TelegramMessage();
        System.out.print("Enter source username : ");
        telegramMessage.setSourceUsername(scanner.next());
        System.out.print("Enter target username : ");
        telegramMessage.setTargetUsername(scanner.next());
        System.out.println("Write Your Message : ");
        telegramMessage.setContent(scanner.next());
        return telegramMessage;
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
