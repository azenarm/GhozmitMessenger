import edu.sharif.selab.models.Message;
import edu.sharif.selab.services.MessageFactory;
import edu.sharif.selab.services.MessageService;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer = 0;
        do {
            Message message = null;
            MessageService messageService;

            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            userAnswer = scanner.nextInt();

            if (userAnswer == 0) {
                break;
            }

            try {
                messageService = MessageFactory.createMessageService(userAnswer);
                message = messageService.collectInput(scanner);
                messageService.sendMessage(message);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (true);
    }
}