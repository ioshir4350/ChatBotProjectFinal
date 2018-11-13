

import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

    /**
     * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
     */
    public static void main(String[] args)
    {
        ChatBot1 chatbot1 = new ChatBot1();
        ChatBot2 chatbot2 = new ChatBot2();
        ChatBot3 chatbot3 = new ChatBot3();


        Scanner in = new Scanner (System.in);
        System.out.println("Yo it's your boy chatbot.Let me know what you tryna talk about.");
        System.out.println("To talk about games, type games");
        System.out.println("To talk about sports,type sports");
        System.out.println("To talk about school,type school");
        String statement = in.nextLine();
        statement = statement.toLowerCase();


        while (!statement.equals("bye"))
        {
            if(statement.equals("games")) {
                //Use Logic to control which chatbot is handling the conversation\
                //This example has only chatbot1
                chatbot1.chatLoop(statement);
            }
            if(statement.equals("sports")){
                chatbot2.chatLoop(statement);
            }
            if (statement.equals("school"))
            {
                chatbot3.chatLoop(statement);
            }
            statement = in.nextLine();
        }
        System.out.println("Wow,lame");
    }

}