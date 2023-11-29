package com.mcneil.technologies.triplexlinersystem;


import org.springframework.util.StringUtils;

public class Utils {

    /**
     * A function that take's in a string and replaces all "_" with " " and capitalizes the first letter of each word.
     * @param stringToFormat The string to format.
     * @return The formatted string.
     */
    public static String formatString(String stringToFormat) {
        String formattedString = stringToFormat.replace("_", " ");
        String[] words = formattedString.split(" ");
        StringBuilder formattedStringBuffer = new StringBuilder();
        for (String word : words) {
            formattedStringBuffer.append(StringUtils.capitalize(word)).append(" ");
        }
        return formattedStringBuffer.toString().trim();
    }
}
