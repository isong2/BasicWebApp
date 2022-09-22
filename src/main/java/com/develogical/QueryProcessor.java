package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("hello")) {
            return "Hello there, beautiful day we are having isn't it?";
        }

        if (query.toLowerCase().contains("name")) {
            return "curry";
        }

        if (query.toLowerCase().contains("largest")) {
            String[] splitquery = query.split("%");
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < splitquery.length; i++) {
                String potentialNum = splitquery[i];
                if (potentialNum.contains(",")) {
                    potentialNum = potentialNum.substring(0, potentialNum.length() - 1);
                }
                numList.add(convertingStringNumbersToIntegers(potentialNum));
            }
            List<Integer> sortedlist = new ArrayList<>(numList);
            Collections.sort(sortedlist);
            return sortedlist.get(sortedlist.size() - 1).toString();
        }
        return "";
    }

    public int convertingStringNumbersToIntegers(String stringNum) {
        try {
            int number = Integer.parseInt(stringNum);
            return number;
        } catch (NumberFormatException nfe){
            return 0;
        }
      }
}
