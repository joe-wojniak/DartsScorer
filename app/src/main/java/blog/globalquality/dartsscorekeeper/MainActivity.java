package blog.globalquality.dartsscorekeeper;

import android.app.Activity;
import android.os.Bundle;
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

public class MainActivity extends Activity {

    EditText pointsHomeDart1;
    EditText pointsHomeDart2;
    EditText pointsHomeDart3;
    EditText pointsAwayDart1;
    EditText pointsAwayDart2;
    EditText pointsAwayDart3;

    int startScore = 501; // Starting score of the x01 game
    int n = 10; // initialize throw counter
    int previousHomeThrowScore;
    int previousAwayThrowScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the start button is clicked.
     */
    public void startButton(View view) {

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

            String scoreThrow = Integer.toString(startScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore1);
            homeScore.setText(scoreThrow);

            previousHomeThrowScore = startScore - shotPoints1 - shotPoints2 - shotPoints3;
        }

        if (n == 9) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow2);
            textThrow.setText(score);

            TextView previousScore = (TextView) findViewById(R.id.textHomeScore1);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore2);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

        }

        if (n == 8) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow3);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore3);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
        }

        if (n == 7) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow4);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore4);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
        }

        if (n == 6) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow5);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore5);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 5) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow6);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore6);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 4) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow7);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore7);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 3) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow8);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore8);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 2) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow9);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore9);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 1) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow10);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore10);
            homeScore.setText(scoreThrow);

            if (previousHomeThrowScore>shotPoints1+shotPoints2+shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousHomeThrowScore<shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 0) {
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

            String scoreThrow = Integer.toString(startScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore1);
            awayScore.setText(scoreThrow);

            previousAwayThrowScore = startScore - shotPoints1 - shotPoints2 - shotPoints3;
        }

        if (n == 9) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow2);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore2);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
        }

        if (n == 8) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow3);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore3);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
        }

        if (n == 7) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow4);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore4);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
        }

        if (n == 6) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow5);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore5);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 5) {
            String scoreHome = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textHomeThrow = (TextView) findViewById(textHomeThrow6);
            textHomeThrow.setText(scoreHome);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore6);
            awayScore.setText(scoreThrow);

            previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            goOut(previousHomeThrowScore);
        }

        if (n == 4) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow7);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore7);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 3) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow8);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore8);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 2) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow9);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore9);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
        }

        if (n == 1) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow10);
            textThrow.setText(score);
            String scoreThrow = Integer.toString(previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore10);
            awayScore.setText(scoreThrow);

            if (previousAwayThrowScore > shotPoints1+shotPoints2+shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
            } else if (previousAwayThrowScore < shotPoints1+shotPoints2+shotPoints3){
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            goOut(previousHomeThrowScore);
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
    /**
     * This method checks to see if the player can go out
     *
     * @param currentScore - the player's current score
     */

    public void goOut(int currentScore) {
        if (currentScore==170) {
            Toast.makeText(this, "to Go Out next Throw:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "T20, T20, Bull", Toast.LENGTH_LONG).show();
        }
        if (currentScore==130) {
            Toast.makeText(this, "to Go Out next Throw:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "T20, 20, Bull", Toast.LENGTH_LONG).show();
        }
        if (currentScore==100) {
            Toast.makeText(this, "to Go Out next Throw:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "T20, D20", Toast.LENGTH_LONG).show();
        }
        if (currentScore==60) {
            Toast.makeText(this, "to Go Out next Throw:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "20, D20", Toast.LENGTH_LONG).show();
        }
    }

}

// DONE Define functionality of the start button: check that the x01 game has been entered (1001, 701, 501, 301)
// DONE Empty points from the table cells when start button is pushed
// DONE Define functionality for the score button: score the Home throw and the Away throw
// TODO Calculate each player's average points per throw (i.e. per 3 darts thrown)
// TODO Add link to Darts501.com
// DONE Define point lookup in the hashMap
// DONE editAwayScore can be changed to a TextView.