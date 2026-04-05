import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        System.out.println("ChatBot: Hello! Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            userInput = sc.nextLine().toLowerCase();

            if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("ChatBot: Hi there! How can I help you?");
            }
            else if (userInput.contains("how are you")) {
                System.out.println("ChatBot: I'm just a bot, but I'm doing great!");
            }
            else if (userInput.contains("your name")) {
                System.out.println("ChatBot: I am CodSoft ChatBot.");
            }
            else if (userInput.contains("help")) {
                System.out.println("ChatBot: I can answer simple questions. Try asking something!");
            }
            else if (userInput.contains("bye")) {
                System.out.println("ChatBot: Goodbye! Have a nice day!");
                break;
            }
            else {
                System.out.println("ChatBot: Sorry, I don't understand that.");
            }
        }

        sc.close();
    }
}
