package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;

import java.util.Scanner;

public class SmsMessageService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        if (!(message instanceof SmsMessage)) {
            throw new IllegalArgumentException("Invalid message type for SMS service");
        }

        SmsMessage smsMessage = (SmsMessage) message;
        if (validatePhoneNumber(smsMessage.getSourcePhoneNumber())
                && validatePhoneNumber(smsMessage.getTargetPhoneNumber())) {
            System.out.println("Sending a SMS from " + smsMessage.getSourcePhoneNumber() + " to "
                    + smsMessage.getTargetPhoneNumber() + " with content : " + smsMessage.getContent());
        } else {
            throw new IllegalArgumentException("Phone Number is Not Correct!");
        }
    }

    @Override
    public Message collectInput(Scanner scanner) {
        SmsMessage smsMessage = new SmsMessage();
        System.out.print("Enter source phone : ");
        smsMessage.setSourcePhoneNumber(scanner.next());
        System.out.print("Enter target phone : ");
        smsMessage.setTargetPhoneNumber(scanner.next());
        System.out.println("Write Your Message : ");
        smsMessage.setContent(scanner.next(".*$"));
        return smsMessage;
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        // Check if the phone number is exactly 11 characters long
        if (phoneNumber.length() != 11) {
            return false; // Phone number length is not valid
        }

        // Check if the phone number contains only numeric digits
        for (char digit : phoneNumber.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false; // Phone number contains non-numeric characters
            }
        }

        // If all checks pass, return true (valid phone number)
        return true;
    }
}
