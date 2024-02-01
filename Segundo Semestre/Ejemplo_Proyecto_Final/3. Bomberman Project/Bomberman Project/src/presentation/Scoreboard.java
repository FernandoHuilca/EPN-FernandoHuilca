package presentation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {

    private List<String> scoresArray;
    private static final String[] highScores = {"-", "-", "-", "-", "-"};

    public Scoreboard() {
        scoresArray = new ArrayList<>();
    }

    public void update() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("scores.txt"),
                        StandardCharsets.UTF_8
                )
        )) {
            String row;
            scoresArray.clear();
            while ((row = reader.readLine()) != null) {
                scoresArray.add(row);
            }
            Collections.sort(scoresArray, scoresComparator);
        } catch (IOException e) {
            e.printStackTrace();
        }

        chooseTop5Scores();
    }

    private Comparator<String> scoresComparator = (s1, s2) -> {
        int score1 = extractScore(s1);
        int score2 = extractScore(s2);
        return Integer.compare(score2, score1);
    };

    private int extractScore(String s) {
        try {
            String[] parts = s.split("-");
            if (parts.length >= 2) {
                return Integer.parseInt(parts[1].trim());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 for invalid input
    }

    public static void writeScore(String name, int score) {
        if (score > 0) {
            try (OutputStreamWriter output = new OutputStreamWriter(
                    new FileOutputStream("scores.txt", true),
                    StandardCharsets.UTF_8
            )) {
                output.append(name).append("     ").append(String.valueOf(score)).append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] getHighScores() {
        return highScores;
    }

    private void chooseTop5Scores() {
        for (int i = 0; i < highScores.length; i++) {
            if (i < scoresArray.size()) {
                highScores[i] = scoresArray.get(i);
            } else {
                highScores[i] = "-";
            }
        }
    }
}
