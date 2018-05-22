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
    int previousHomeThrowScore; // the score from the last throw
    int previousAwayThrowScore; // the score from the last throw
    int homePointsScored; // keeps track of Home Player's points scored
    int awayPointsScored; // keeps track of Away Player's points scored

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        if (homePointsScored + shotPoints1 + shotPoints2 + shotPoints3 < startScore) {
            homePointsScored = homePointsScored + shotPoints1 + shotPoints2 + shotPoints3;
        } else {
            goOut(homePointsScored, shotPoints1 + shotPoints2 + shotPoints3);
        }

        //Update Home score & dart average
        if (n == 10) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow1);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(startScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView homeScore = (TextView) findViewById(R.id.textHomeScore1);
            homeScore.setText(scoreThrow);

            previousHomeThrowScore = startScore - shotPoints1 - shotPoints2 - shotPoints3;

            String homeAvg = Double.toString(homePointsScored / 1);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);

        }

        if (n == 9) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow2);
            textThrow.setText(score);

            TextView previousScore = (TextView) findViewById(R.id.textHomeScore1);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore2);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 2);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 8) {

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {

                String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
                TextView textThrow = (TextView) findViewById(R.id.textHomeThrow3);
                textThrow.setText(score);

                String scoreThrow = Integer.toString(previousHomeThrowScore);
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;

                TextView homeScore = (TextView) findViewById(R.id.textHomeScore3);
                homeScore.setText(scoreThrow);

            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 3);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 7) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow4);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore4);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 4);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 6) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow5);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore5);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 5);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 5) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow6);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore6);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 6);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 4) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow7);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore7);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 7);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 3) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow8);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore8);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 8);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 2) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow9);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore9);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 9);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
        }

        if (n == 1) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textHomeThrow10);
            textThrow.setText(score);

            if (previousHomeThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousHomeThrowScore = previousHomeThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousHomeThrowScore);
                TextView homeScore = (TextView) findViewById(R.id.textHomeScore10);
                homeScore.setText(scoreThrow);
            } else if (previousHomeThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousHomeThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String homeAvg = Double.toString(homePointsScored / 10);

            TextView textHomeAvg = (TextView) findViewById(R.id.textHomeAvg);
            textHomeAvg.setText(homeAvg);
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

        if (awayPointsScored + shotPoints1 + shotPoints2 + shotPoints3 < startScore) {
            awayPointsScored = awayPointsScored + shotPoints1 + shotPoints2 + shotPoints3;
        } else {
            goOut(awayPointsScored, shotPoints1 + shotPoints2 + shotPoints3);
        }

        //Update Away score & dart average
        if (n == 10) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow1);
            textThrow.setText(score);

            String scoreThrow = Integer.toString(startScore - shotPoints1 - shotPoints2 - shotPoints3);

            TextView awayScore = (TextView) findViewById(R.id.textAwayScore1);
            awayScore.setText(scoreThrow);

            previousAwayThrowScore = startScore - shotPoints1 - shotPoints2 - shotPoints3;

            String awayAvg = Double.toString(awayPointsScored / 1);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);

        }

        if (n == 9) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow2);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore2);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 2);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 8) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow3);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore3);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            String awayAvg = Double.toString(awayPointsScored / 3);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 7) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow4);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore4);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }
            String awayAvg = Double.toString(awayPointsScored / 4);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 6) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow5);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore5);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 5);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 5) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textAwayThrow = (TextView) findViewById(R.id.textAwayThrow6);
            textAwayThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore6);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 6);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 4) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow7);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore7);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 7);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 3) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow8);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore8);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 8);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 2) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow9);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore9);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 9);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 1) {
            String score = Integer.toString(shotPoints1 + shotPoints2 + shotPoints3);
            TextView textThrow = (TextView) findViewById(R.id.textAwayThrow10);
            textThrow.setText(score);

            if (previousAwayThrowScore > shotPoints1 + shotPoints2 + shotPoints3) {
                previousAwayThrowScore = previousAwayThrowScore - shotPoints1 - shotPoints2 - shotPoints3;
                String scoreThrow = Integer.toString(previousAwayThrowScore);
                TextView awayScore = (TextView) findViewById(R.id.textAwayScore10);
                awayScore.setText(scoreThrow);
            } else if (previousAwayThrowScore < shotPoints1 + shotPoints2 + shotPoints3) {
                Toast.makeText(this, "Must shoot " + previousAwayThrowScore + " to go out.", Toast.LENGTH_LONG).show();
            }

            String awayAvg = Double.toString(awayPointsScored / 10);

            TextView textAwayAvg = (TextView) findViewById(R.id.textAwayAvg);
            textAwayAvg.setText(awayAvg);
        }

        if (n == 0) {
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show();
            return;
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

    public void goOut(int currentScore, int currentThrow) {
        int toGoOut;
        toGoOut = startScore - currentScore;
        Toast.makeText(this, "Your throw is " + currentThrow, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Must shoot " + toGoOut + " to go out.", Toast.LENGTH_LONG).show();
    }

    /**
     * This method is called when the reset button is clicked.
     */
    public void resetButton(View view) {
        clearScores();
        startScore = 501; // reset starting score of the x01 game
        n = 10; // reset throw counter
        previousHomeThrowScore = 0; // reset the score from the last throw
        previousAwayThrowScore = 0; // reset the score from the last throw
        homePointsScored = 0; // keeps track of Home Player's points scored
        awayPointsScored = 0; // keeps track of Away Player's points scored
    }

    /**
     * This method is called when the checkOutHomeButton is clicked.
     */
    public void checkoutHomeButton(View view) {
        int pointsLeftInGame; // startScore - Player's Points Scored so far
        int shot1; // checkout shot #1
        int shot2; // checkout shot #2
        int shot3; // checkout shot #3

        // Home Player's checkout combinations
        pointsLeftInGame = startScore - homePointsScored;
        if (pointsLeftInGame > 170) {
            Toast.makeText(this, "Score must be no more than 170 to checkout in 3 shots", Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame == 170) {
            Toast.makeText(this, "Home to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "T20, T20, Bull", Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame > 119) {
            shot1 = 60;
            shot2 = 60;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Home to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame > 99) {
            shot1 = 60;
            shot2 = 40;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Home to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame > 79) {
            shot1 = 50;
            shot2 = 30;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Home to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        } else {
            shot1 = 40;
            shot2 = 20;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Home to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method is called when the checkOutHomeButton is clicked.
     */
    public void checkoutAwayButton(View view) {
        int pointsLeftInGame; // startScore - Player's Points Scored so far
        int shot1; // checkout shot #1
        int shot2; // checkout shot #2
        int shot3; // checkout shot #3

        // Away Player's checkout combinations
        pointsLeftInGame = startScore - awayPointsScored;
        if (pointsLeftInGame > 170) {
            Toast.makeText(this, "Score must be no more than 170 to checkout in 3 shots", Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame == 170) {
            Toast.makeText(this, "Away to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "T20, T20, Bull", Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame > 119) {
            shot1 = 60;
            shot2 = 60;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Away to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame > 99) {
            shot1 = 60;
            shot2 = 40;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Away to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        } else if (pointsLeftInGame > 79) {
            shot1 = 50;
            shot2 = 30;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Away to Go Out::", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        } else {
            shot1 = 40;
            shot2 = 20;
            shot3 = pointsLeftInGame - (shot1 + shot2);

            Toast.makeText(this, "Away to Go Out:", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shot1 + " " + shot2 + " " + shot3, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method is called by the start and the reset button to set the scores to null.
     */
    public void clearScores() {

        //Set Home Player's throw & score TextViews to null;
        TextView homeThrow = (TextView) findViewById(textHomeThrow1);
        homeThrow.setText(null);

        TextView homeScore = (TextView) findViewById(R.id.textHomeScore1);
        homeScore.setText(null);

        TextView homeAvg = (TextView) findViewById(R.id.textHomeAvg);
        homeAvg.setText(null);

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

        TextView awayAvg = (TextView) findViewById(R.id.textAwayAvg);
        awayAvg.setText(null);

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
}

// DONE Define functionality of the start button: check that the x01 game has been entered (1001, 701, 501, 301)
// DONE Empty points from the table cells when start button is pushed
// DONE Define functionality for the score button: score the Home throw and the Away throw
// DONE Calculate & display each player's dart average
// DONE Add link to Darts501.com
// DONE Define point lookup in the hashMap
// DONE editAwayScore can be changed to a TextView
// DONE Implement the game rules- last throw must result in score = 0 to go out (to end the game)