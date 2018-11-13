import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//William leung//

public class ChatBot3 {

    int emotion = 0;

<<<<<<< HEAD
    // Start of chat//
    public void chatLoop(String statement) {
        Scanner in = new Scanner(System.in);
        System.out.println(getGreeting());


        while (!statement.equals("Bye")) {
=======
//Intro
        while (!statement.equals("Bye"))
        {
>>>>>>> 890e11a5fa65fd5e3bb233addd75c94c79ab35b5


            statement = in.nextLine();
            //getResponse handles the user reply
            System.out.println(getResponse(statement));


        }

    }

    String bellschedule[] = {"8:00 AM", "8:47 AM", "9:32 AM", "10:22 AM", "11:07 AM", "11:52 AM", "12:37 AM", "1:22 PM",
            "2:07 PM"};

    public String getGreeting() {
        return "Hi, what is poppin?";
    }
<<<<<<< HEAD

    // Greeting//
    public String getResponse(String statement) {
=======
//Greeting
    public String getResponse(String statement)
    {
>>>>>>> 890e11a5fa65fd5e3bb233addd75c94c79ab35b5
        String response = "";

        if (statement.length() == 0) {
            response = "Say something I'm giving up on you~.";
        } else if (findKeyword(statement, "no") >= 0) {
            response = "rude";
            emotion--;
<<<<<<< HEAD
        } else if (findKeyword(statement, "How's school?") >= 0) {
=======
        }
        else if (findKeyword(statement, "How's school?" ) >= 0)
        {
>>>>>>> 890e11a5fa65fd5e3bb233addd75c94c79ab35b5
            response = "Hard";
        } else if (findKeyword(statement, "I'm tired") >= 0) {
            response = "You think you're tired? I have a 1-10 with three lunches for no reason and I have 4 AP classes";
            emotion--;
        } else if (findKeyword(statement, "I want to die") >= 0) {
            response = "please don't do that";
        } else if (findKeyword(statement, "I want to", 0) >= 0) {
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement, "I want", 0) >= 0) {
            response = transformIWantStatement(statement);
<<<<<<< HEAD
        } else if (findKeyword(statement, "When does period", 0) >= 0) {
            response = transformRequestforBellSchedule(statement);
        } else {
=======
        }
        else if (findKeyword(statement, "When does period",0) >= 0)
        {
            response = transformRequestforBellSchedule(statement);
        }
        else
        {
>>>>>>> 890e11a5fa65fd5e3bb233addd75c94c79ab35b5
            response = getRandomResponse();
        }

        return response;
    }

<<<<<<< HEAD
    //
    private String transformIWantToStatement(String statement) {
=======
// Transform I want to
    private String transformIWantToStatement(String statement)
    {
>>>>>>> 890e11a5fa65fd5e3bb233addd75c94c79ab35b5
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Why do you want to " + restOfStatement + "?";
    }

    private String transformIWantStatement(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "If you want" + restOfStatement + ", then how do you plan to achieve it?";
    }
<<<<<<< HEAD

    private String transformRequestforBellSchedule(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword(statement, "When does period", 0);
        String restOfStatement = statement.substring(17, 18);
        Integer prd = Integer.valueOf(restOfStatement);
        int trueprd = prd - 1;
        if (trueprd >= 0 && trueprd <= 9) {
            return "It starts " + bellschedule[trueprd];
        } else {
            return "You don't have class in that period";
        }
    }



=======
    private String transformRequestforBellSchedule(String statement)
    {
        int bellschedule[] = {800,847,932,1022,1107,1152,1237,122,207,252};
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "When is period", 0);
        String restOfStatement = statement.substring(psn + 16).trim();
        int period = Integer.parseInt(restOfStatement);
        return "It starts "+  bellschedule[period];
    }
>>>>>>> 890e11a5fa65fd5e3bb233addd75c94c79ab35b5
    private int findKeyword(String statement, String goal,
                            int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        int psn = phrase.indexOf(goal, startPos);

        while (psn >= 0)
        {

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

            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }

    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

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

    private String [] randomNeutralResponses = {"cool, what else",
            "Hmmm.",
            "I'm good",
            "Alrighty then",
            "tell me something else"
    };
    private String [] randomAngryResponses = {"'Seen'", "'Read'", "No u", "weird flex but ok"};
    private String [] randomHappyResponses = {"Awesome dude,catch ya later", "You're a good person", "Whatever you're struggling with, I wish you best of luck.","You deserve this bread"};

}
