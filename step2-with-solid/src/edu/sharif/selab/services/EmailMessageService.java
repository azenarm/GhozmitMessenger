package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.EmailMessage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailMessageService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        if (!(message instanceof EmailMessage)) {
            throw new IllegalArgumentException("Invalid message type for Email service");
        }

        EmailMessage emailMessage = (EmailMessage) message;
        if (validateEmailAddress(emailMessage.getSourceEmailAddress())
                && validateEmailAddress(emailMessage.getTargetEmailAddress())) {
            System.out.println("Sending an Email from " + emailMessage.getSourceEmailAddress() + " to "
                    + emailMessage.getTargetEmailAddress() + " with content : " + emailMessage.getContent());
        } else {
            throw new IllegalArgumentException("Email Address is Not Correct!");
        }
    }

    @Override
    public Message collectInput(Scanner scanner) {
        EmailMessage emailMessage = new EmailMessage();
        System.out.print("Enter source email : ");
        emailMessage.setSourceEmailAddress(scanner.next());
        System.out.print("Enter target email : ");
        emailMessage.setTargetEmailAddress(scanner.next());
        System.out.println("Write Your Message : ");
        emailMessage.setContent(scanner.next());
        return emailMessage;
    }

    public boolean validateEmailAddress(String email) {
        // Regular expression pattern for validating email addresses
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Check if the email string matches the regex pattern
        return pattern.matcher(email).matches();
    }
}
