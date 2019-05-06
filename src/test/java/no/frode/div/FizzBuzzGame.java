package no.frode.div;

public class FizzBuzzGame {

    public String fizzBuzzGame(int i) {

        int deleligTre = i % 3;
        int deleligFem = i % 5;

        if (deleligTre == 0 && deleligFem == 0){
            return "fizzbuzz";
        }

        else if (deleligTre == 0) {
            return "fizz";
        }

        else if (deleligFem == 0) {
            return "buzz";
        }

        else if (deleligTre ==  0) {
            return String.valueOf(i);
        }

        else {
            return String.valueOf(i);
        }
    }

}
