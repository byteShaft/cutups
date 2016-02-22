package com.pits.cutups.utils;

import android.content.Context;
import android.os.Vibrator;

import java.util.ArrayList;
import java.util.Random;

public class Helpers {

    public static void vibrate(Context context, long time) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(time);
    }

    public static int getRandomNumber() {
        // get a random number with a max value of 2 (range 3)
        // could be 0, 1, or 2. Add 1 to that so that we never return 0;
        return new Random().nextInt(3) + 1;
    }

    public static ArrayList<String> getCutTextsFromInput(String inputFieldText) {
        // Initialize the list to return
        ArrayList<String> relevantTexts = new ArrayList<>();

        // The initial random number to select text after white spaces.
        int randomWhitespaceIterator = getRandomNumber();
        // Count of whitespaces occurred for each batch.
        int whitespaceOccurrences = 0;
        // A count to detect where last text cut occurred. Is the index number of char.
        int startTextIndex = 0;

        for (int i = 0; i < inputFieldText.length(); i++) {
            if (inputFieldText.charAt(i) == ' ') {
                whitespaceOccurrences += 1;
            }

            if (whitespaceOccurrences == randomWhitespaceIterator) {
                relevantTexts.add(inputFieldText.substring(startTextIndex, i));
                randomWhitespaceIterator = getRandomNumber();
                whitespaceOccurrences = 0;
                startTextIndex = i;
            }
        }

        return relevantTexts;
    }
}
