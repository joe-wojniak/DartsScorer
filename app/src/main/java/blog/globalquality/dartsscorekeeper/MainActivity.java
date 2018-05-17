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
import static blog.globalquality.dartsscorekeeper.R.id.textAwayScore1;
import static blog.globalquality.dartsscorekeeper.R.id.textAwayThrow1;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeScore1;
import static blog.globalquality.dartsscorekeeper.R.id.textHomeThrow1;

public class MainActivity extends AppCompatActivity {

    EditText pointsHomeDart1;
    EditText pointsHomeDart2;
    EditText pointsHomeDart3;
    EditText pointsAwayDart1;
    EditText pointsAwayDart2;
    EditText pointsAwayDart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

        /**
         * This method is called when the start button is clicked.
         */
        public void startButton(View view) {
            //Check if editHomeScore and editAwayScore have been entered for the x01 game.
            boolean homeScoreIs = true;

            EditText homeScore = (EditText) findViewById(editHomeScore);
            homeScoreIs = Boolean.parseBoolean(homeScore.getText().toString());

             if (homeScoreIs == !homeScoreIs) {
                Toast.makeText(this, "Please enter 1001, 701, 501, or 301 to start the game", Toast.LENGTH_LONG).show();
            } else {
                 TextView awayScore = (TextView) findViewById(textAwayScore);
                 awayScore.setText(homeScore.getText());
             }
             //Set Players' throw & score TextViews to null;

            int n = 10; // initialize counter

            while (n > 0) {

                String textHomeThrow = "textHomeThrow + n";

                // replace with programmatically generated resource id: texthomeThrow# and textHomeScore#, etc.

                TextView homeThrow1 = (TextView) findViewById(textHomeThrow1);
                homeThrow1.setText(null);

                TextView homeScore1 = (TextView) findViewById(textHomeScore1);
                homeScore1.setText(null);

                //Set Away Player's throw & score TextViews to null;

                TextView awayThrow1 = (TextView) findViewById(textAwayThrow1);
                awayThrow1.setText(null);

                TextView awayScore1 = (TextView) findViewById(textAwayScore1);
                awayScore1.setText(null);

                n = n - 1; // decrement counter
            }
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
        int scoreHome = shotPoints1 + shotPoints2 + shotPoints3;
        TextView textHomeThrow1 = (TextView) findViewById(R.id.textHomeThrow1);
        textHomeThrow1.setText(scoreHome);

        //Score Away Player's throw (shots 1-3);
        pointsAwayDart1 = (EditText) findViewById(editAwayDart1);
        String pointsAwayDart1Is = pointsAwayDart1.getText().toString();
        shotPoints1 = shot(pointsHomeDart1Is);

        pointsAwayDart2 = (EditText) findViewById(editAwayDart2);
        String pointsAwayDart2Is = pointsAwayDart2.getText().toString();
        shotPoints2 = shot(pointsAwayDart2Is);

        pointsAwayDart3 = (EditText) findViewById(editAwayDart3);
        String pointsAwayDart3Is = pointsAwayDart3.getText().toString();
        shotPoints3 = shot(pointsAwayDart3Is);

        //Update Away score
        int scoreAway = shotPoints1 + shotPoints2 + shotPoints3;
        TextView textAwayThrow1 = (TextView) findViewById(R.id.textAwayThrow1);
        textAwayThrow1.setText(scoreAway);
    }

    /**
     * This method converts dart throw to points
     *
     * @param shot: the segment hit on the dart shot
     */

    public int shot(String shot) {
        int shotPoints = 0;
        String shotIs = null;

        char result = shot.charAt(0);
        if (result == 'D') {
            shotIs = shotIs.substring(1);
            shotPoints = Integer.parseInt(shotIs);
            shotPoints = 2*shotPoints;
        } else if (result == 'T') {
            shotIs = shotIs.substring(1);
            shotPoints = Integer.parseInt(shotIs);
            shotPoints = 3*shotPoints;
        } else if (result == 'O') {
            shotPoints = 25;
        } else if (result == 'B') {
            shotPoints = 50;
        } else if (result == 'I') {
            shotPoints = 50;
        } else {
            shotPoints = Integer.parseInt(shotIs);
        }

        Log.v("MainActivity", "Shot Points: " + shotPoints);

        return (shotPoints);
    }
}

// TODO Define functionality of the start button: check that the x01 game has been entered (1001, 701, 501, 301)
// TODO Empty points from the table cells when start button is pushed
// TODO Copy x01 game from Home Player Score to Away Player Score
// TODO Define functionality for the score button: score the Home throw and the Away throw
// TODO Calculate each player's average points per throw (i.e. per 3 darts thrown)
// TODO Define point lookup in the hashMap
// TODO editAwayScore can be changed to a TextView. Copy entry over from editHomeScore