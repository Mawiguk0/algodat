package de.mawiguko.helpers;

import org.junit.platform.commons.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserDialog {
    private String message, question;
    private java.util.List<String> positives;
    private java.util.List<String> negatives;

    public UserDialog(String message, String question, List<String> positive, List<String> negatives) {
        this.message = message;
        this.question = question;
        this.positives = positive;
        this.negatives = negatives;
    }

    /**
     *
     * @param _message
     * @param _question
     */
    public UserDialog(String _message, String _question) {
        positives = new ArrayList<>();
        positives.add("Yes");
        positives.add("y");
        positives.add("Ja");
        positives.add("j");

        negatives = new ArrayList<>();
        negatives.add("No");
        negatives.add("n");
        negatives.add("Nein");
        negatives.add("n");

        this.message = _message;
        this.question = _question;
    }


    public boolean getUserContinue() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(message)
                .append("\n")
                .append(question)
                .append(" (");
        for(String s : positives) {
            sb.append(s);
            sb.append(",");
        }
        sb.append("/");
        for(String s : negatives) {
            sb.append(s);
            sb.append(",");
        }
        sb.append("): ");
        System.out.print(sb.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(true) {
                String st = reader.readLine();
                if(this.positives.contains(st)) {
                    return true;
                } else if ( this.negatives.contains(st)) {
                    return false;
                } else {
                    System.out.print(sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
