package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

import java.util.Scanner;

public interface MessageService {
    void sendMessage(Message message);

    Message collectInput(Scanner scanner);
}
