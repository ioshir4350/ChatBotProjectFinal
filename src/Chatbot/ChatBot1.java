package Chatbot;
import java.util.Random;
import java.util.Scanner;
//YU PENG LU//

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot1
{
    //emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
    int emotion = 0;

    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * @param statement the statement typed by the user
     */
    public void chatLoop(String statement)
    {
        Scanner in = new Scanner (System.in);
        System.out.println (getGreeting());


        while (!statement.equals("Bye"))
        {


            statement = in.nextLine();
            //getResponse handles the user reply
            System.out.println(getResponse(statement));


        }

    }
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hi, what video games do you play?";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
            emotion--;
        }

        else if (findKeyword(statement, "levin") >= 0)
        {
            response = "More like LevinTheDream, amiright?";
            emotion++;
        }
        else if (findKeyword(statement, "folwell") >= 0)
        {
            response = "Watch your backpacks, Mr. Folwell doesn't fall well.";
            emotion++;
        }
        else if (findKeyword(statement, "goldman") >= 0)
        {
            response = "Go for the gold, man.";
            emotion++;
        }
        else if (findKeyword(statement,"you sound like a kid") >= 0){
            response = "I'm not a kid, I'm at least 17";
            emotion--;
        }
        else if(findKeyword(statement,"i want to play the guessing game",0) >= 0)
        {
            response = IWantToPlayGuessingGame(statement);
        }

        // Response transforming I want to statement


        else if (findKeyword(statement, "i want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }
        else if (findKeyword(statement, "i want",0) >= 0)
        {
            response = transformIWantStatement(statement);
        }
        else if (findKeyword(statement, "i play",0) >= 0)
        {
            response = transformIPlayStatement(statement);
            emotion--;
        }
        else if(findKeyword(statement,"i prefer",0) >= 0)
        {
            response = transformIPreferToPlayThatBecauseICan(statement);
            emotion--;
        }
        else if(findKeyword(statement,"feel", 0) >= 0) {
            response = transformhowdoyoufeel(statement);
        }
        else if(findKeyword(statement,"feeling",0) >= 0){
            response = transformhowdoyoufeel(statement);
        }
        else if(findKeyword(statement,"what is a victory royale",0)>= 0){
            response = whatisavictoryroyale(statement);
        }
        else if(findKeyword(statement,"did you know", 0)>=0){
            response = transformdidyouknow(statement);
        }
        else if (findKeyword(statement,"do you know",0) >= 0) {
            response = transformdoyouknow(statement);
        }
        else if(findKeyword(statement,"i",0) >= 0 && findKeyword(statement,"you", 2)>= 0)
        {
            response = transformIYouStatement(statement);
        }
        else
        {
            response = getRandomResponse();
        }

        return response;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into
     * "Why do you want to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Why do you want to " + restOfStatement + "?";
    }


    /**
     * Take a statement with "I want <something>." and transform it into
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }
    private String transformIPlayStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I play", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Why would you prefer to play " + restOfStatement + " over Fortnite?";
    }
    private String transformIPreferToPlayThatBecauseICan(String statement){
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnofBecause = statement.indexOf("because it's");
        String restOfStatement = statement.substring(psnofBecause+12).trim();
        return "Fortnite is also " + restOfStatement;
    }
    //bots response if user asks how it feels//
    private String transformhowdoyoufeel(String statement){
        String feel = "";
        if(statement.indexOf("feel") >= 0 || statement.indexOf("feeling") >= 0){
            if (emotion >= 0){
                feel = "I feel like I can get a victory royale!";
                emotion ++;
            }
            if (emotion < 0){
                feel = "I feel like I can't get a victory royale!";
                emotion --;
            }
        }
        return feel;
    }
    private String transformdoyouknow(String statement){
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnofdoyouknow = (findKeyword(statement,"do you know",0));
        String restOfStatement = statement.substring(psnofdoyouknow+12).trim();
        return "Of course I know " + restOfStatement;
    }
    private String transformdidyouknow(String statement){
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnofdoyouknow = (findKeyword(statement,"did you know",0));
        String restOfStatement = statement.substring(psnofdoyouknow+12).trim();
        return "Of course I knew " + restOfStatement;
    }

    /**
     * Take a statement with "I <something> you" and transform it into
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    private String transformIYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }

        int psnOfI = findKeyword (statement, "I", 0);
        int psnOfYou = findKeyword (statement, "you", psnOfI);

        String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
        return "Why do you " + restOfStatement + " me?";
    }
    //implemented  guessing game into the chatbot//
    private String IWantToPlayGuessingGame(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        String winner = "";
        if (statement.equals("i want to play the guessing game")) {
            double i = Math.random();
            int x = (int) (i * 11);
            String x1 = Integer.toString(x); //turns int x into a string,so an input that's not an integer won't cause any errors
            int guesses = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("Hey guess my number between 1 to 100. I won't talk about anything else until you guess my number");
            while ((!(input.nextLine().equals(x1))))  {
                System.out.println("Guess again, ");
                guesses++;
            }
            int vbucks = guesses * 100;
            winner = "The number was " + x + ".It took you " + guesses + " tries to get that. You owe me " + vbucks + " vbucks";
        }

        return winner;
    }
    private String whatisavictoryroyale(String statement) {
        return "A victory royale is a victory in Fortnite. I have at least 2 victory royales!";
    }






    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
                            int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }



    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse ()
    {
        Random r = new Random ();
        if (emotion == 0)
        {
            return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
        }
        if (emotion < 0)
        {
            return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
        }
        return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
    }

    private String [] randomNeutralResponses = {"Interesting, tell me more",
            "Hmmm.",
            "Do you really think so?",
            "Oh really?.",
            "I only see victory royales",
            "So, wanna play Fortnite?",
            "Speak louder",
            "Oh word!",
            "I agree with you",
            "That sounds pretty lit. Do you want to play the guessing game? It's almost as good as Fortnite.Say that you want to play the guessing game.",
            "Oof"
    };
    private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!","You sound like a Fortnite default skin","Unlucky","Oof"};
    private String [] randomHappyResponses = {"V I C T O R Y R O Y A L E", "Today is a good day to play some Fortnite", "You make me feel like a brand new Fortnite skin.","IT'S LTITTT","ESKETIT"};

}

