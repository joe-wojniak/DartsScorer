package blog.globalquality.dartsscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static blog.globalquality.dartsscorekeeper.R.id.editAwayDart1;
import static blog.globalquality.dartsscorekeeper.R.id.editAwayDart2;
import static blog.globalquality.dartsscorekeeper.R.id.editAwayDart3;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart1;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart2;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart3;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeScore;
import static blog.globalquality.dartsscorekeeper.R.id.textAwayScore;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow1;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow10;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow2;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow3;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow4;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow5;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow6;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow7;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow8;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow9;

public class MainActivity extends AppCompatActivity {

    EditText pointsHomeDart1;
    EditText pointsHomeDart2;
    EditText pointsHomeDart3;
    EditText pointsAwayDart1;
    EditText pointsAwayDart2;
    EditText pointsAwayDart3;

    int n = 10; // initialize throw counter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the start button is clicked.
     */
    public void startButton(View view) {
        //Check if editHomeScore and editAwayScore have been entered for the x01 game.
        boolean edHomeScoreIs = true;

        EditText edHomeScore = (EditText) findViewById(editHomeScore);
        edHomeScoreIs = Boolean.parseBoolean(edHomeScore.getText().toString());

        if (edHomeScoreIs == !edHomeScoreIs) {
            Toast.makeText(this, "Please enter 1001, 701, 501, or 301 to start the game", Toast.LENGTH_LONG).show();
        } else {
            TextView awayScore = (TextView) findViewById(textAwayScore);
            awayScore.setText(edHomeScore.getText());
        }
        //Set Players' throw & score TextViews to null;

        //int n = 10; // initialize counter

        //while (n > 0) {

        //  String textHomeThrow = "textHomeThrow+n";

        // replace with programmatically generated resource id: texthomeThrow# and textHomeScore#, etc.

        //Set Home Player's throw & score TextViews to null;
        TextView homeThrow = (TextView) findViewById(textHomeThrow1);
        homeThrow.setText(null);

        TextView homeScore = (TextView) findViewById(R.id.textHomeScore1);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow2);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore2);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow3);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore3);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow4);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore4);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow5);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore5);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow6);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore6);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow7);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore7);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow8);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore8);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow9);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore9);
        homeScore.setText(null);

        homeThrow = (TextView) findViewById(textHomeThrow10);
        homeThrow.setText(null);

        homeScore = (TextView) findViewById(R.id.textHomeScore10);
        homeScore.setText(null);

        //Set Away Player's throw & score TextViews to null;

        TextView awayThrow = (TextView) findViewById(R.id.textAwayThrow1);
        awayThrow.setText(null);

        TextView awayScore = (TextView) findViewById(R.id.textAwayScore1);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow2);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore2);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow3);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore3);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow4);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore4);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow5);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore5);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow6);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore6);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow7);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore7);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow8);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore8);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow9);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore9);
        awayScore.setText(null);

        awayThrow = (TextView) findViewById(R.id.textAwayThrow10);
        awayThrow.setText(null);

        awayScore = (TextView) findViewById(R.id.textAwayScore10);
        awayScore.setText(null);
        //n = n - 1; // decrement counter
    }

    /**
     * This method is called when the score button is clicked.
     */
    public void scoreButton(View view) {

        //Score Home Player's throw (shots 1-3);
        pointsHomeDart1 = (EditText) findViewById(editHomeDart1);
        String pointsHomeDart1Is = pointsHomeDart1.getText().toString();
        int shotPoints1 = shot(pointsHomeDart1Is);

        pointsHomeDart2 = (EditText) findViewById(editHomeDart2);
        String pointsHomeDart2Is = pointsHomeDart2.getText().toString();
        int shotPoints2 = shot(pointsHomeDart2Is);

        pointsHomeDart3 = (EditText) findViewById(editHomeDart3);
        String pointsHomeDart3Is = pointsHomeDart3.getText().toString();
        int shotPoints3 = shot(pointsHomeDart3Is);

        //Update Home score
        if (n == 10) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow1);
            textThrow.setText(score);

            EditText editScore = (EditText) findViewById(R.id.editHomeScore);
            int homeScore = Integer.parseInt(editScore.toString()); // crashes here
            // homeScore = homeScore - shotPoints1 - shotPoints2 - shotPoints3;
            String strHomescore = Integer.toString(homeScore);
            TextView textScore = (TextView) findViewById(R.id.textHomeScore1);
            textScore.setText(strHomescore);
        }

        if (n == 9) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow2);
            textThrow.setText(score);
        }

        if (n == 8) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow3);
            textThrow.setText(score);
        }

        if (n == 7) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow4);
            textThrow.setText(score);
        }

        if (n == 6) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow5);
            textThrow.setText(score);
        }

        if (n == 5) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow6);
            textThrow.setText(score);
        }

        if (n == 4) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow7);
            textThrow.setText(score);
        }

        if (n == 3) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow8);
            textThrow.setText(score);
        }

        if (n == 2) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow9);
            textThrow.setText(score);
        }

        if (n == 1) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow10);
            textThrow.setText(score);
        }

        if (n == 0) {
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show();
        }

        if (n == -1) {
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show();
        }

        //Score Away Player's throw (shots 1-3);
        pointsAwayDart1 = (EditText) findViewById(editAwayDart1);
        String pointsAwayDart1Is = pointsAwayDart1.getText().toString();
        shotPoints1 = shot(pointsAwayDart1Is);

        pointsAwayDart2 = (EditText) findViewById(editAwayDart2);
        String pointsAwayDart2Is = pointsAwayDart2.getText().toString();
        shotPoints2 = shot(pointsAwayDart2Is);

        pointsAwayDart3 = (EditText) findViewById(editAwayDart3);
        String pointsAwayDart3Is = pointsAwayDart3.getText().toString();
        shotPoints3 = shot(pointsAwayDart3Is);

        //Update Away score
        if (n == 10) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow1);
            textThrow.setText(score);
        }

        if (n == 9) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow2);
            textThrow.setText(score);
        }

        if (n == 8) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow3);
            textThrow.setText(score);
        }

        if (n == 7) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow4);
            textThrow.setText(score);
        }

        if (n == 6) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow5);
            textThrow.setText(score);
        }

        if (n == 5) {
            String scoreHome = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textHomeThrow = (TextView) findViewById(textHomeThrow6);
            textHomeThrow.setText(scoreHome);
        }

        if (n == 4) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow7);
            textThrow.setText(score);
        }

        if (n == 3) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow8);
            textThrow.setText(score);
        }

        if (n == 2) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow9);
            textThrow.setText(score);
        }

        if (n == 1) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow10);
            textThrow.setText(score);
        }
        n = n - 1; // decrement throw counter
    }

    /**
     * This method converts dart throw to points
     *
     * @param shot: the segment hit on the dart shot
     */

    public int shot(String shot) {
        int shotPoints;
        String shotIs;

        char result = shot.charAt(0);
        if (result == 'D') {
            shotIs = shot.substring(1);
            shotPoints = Integer.parseInt(shotIs);
            shotPoints = 2 * shotPoints;
        } else if (result == 'T') {
            shotIs = shot.substring(1);
            shotPoints = Integer.parseInt(shotIs);
            shotPoints = 3 * shotPoints;
        } else if (result == 'O') {
            shotPoints = 25;
        } else if (result == 'B') {
            shotPoints = 50;
        } else if (result == 'I') {
            shotPoints = 50;
        } else {
            shotPoints = Integer.parseInt(shot);
        }

        Log.v("MainActivity", "Shot Points: " + shotPoints);

        return (shotPoints);
    }
}

// DONE Define functionality of the start button: check that the x01 game has been entered (1001, 701, 501, 301)
// DONE Empty points from the table cells when start button is pushed
// DONE Copy x01 game from Home Player Score to Away Player Score
// TODO Define functionality for the score button: score the Home throw and the Away throw
// TODO Calculate each player's average points per throw (i.e. per 3 darts thrown)
// DONE Define point lookup in the hashMap
// DONE editAwayScore can be changed to a TextView.