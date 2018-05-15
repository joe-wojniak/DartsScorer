package blog.globalquality.dartsscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import static blog.globalquality.dartsscorekeeper.R.id.editAwayDart1;
import static blog.globalquality.dartsscorekeeper.R.id.editAwayDart2;
import static blog.globalquality.dartsscorekeeper.R.id.editAwayDart3;
import static blog.globalquality.dartsscorekeeper.R.id.editAwayScore;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart1;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart2;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart3;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeScore;

public class MainActivity extends AppCompatActivity {

    EditText pointsHomeDart1;
    EditText pointsHomeDart2;
    EditText pointsHomeDart3;
    EditText pointsAwayDart1;
    EditText pointsAwayDart2;
    EditText pointsAwayDart3;

    public HashMap<String, Integer> dartboardSegments = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

        /**
         * This method is called when the start button is clicked.
         */
        public void startButton(View view) {
            // Convert editHomeScore and editAwayScore text values to Integers
            EditText homeScore = (EditText) findViewById(editHomeScore);
            boolean homeScoreIs = Boolean.parseBoolean(homeScore.getText().toString());

            EditText awayScore = (EditText) findViewById(editAwayScore);
            boolean awayScoreIs = Boolean.parseBoolean(homeScore.getText().toString());

            //Check if editHomeScore and editAwayScore have been entered for the x01 game.
             if (homeScoreIs == false) {
                Toast.makeText(this, "Please enter 1001, 701, 501, or 301 to start the game", Toast.LENGTH_LONG).show();
                return;
            } else {
                 awayScore.setText(homeScore.getText());
             }
        }

    /**
     * This method is called when the score button is clicked.
     */
    public void scoreButton(View view) {
        //Home shots 1-3; convert EditText values to integers
        //If D## then multipy by 2
        //If T## then multiply by 3
        //If ### then keep as is (do not multiply)

        int pointsHomeDart1Seg;
        int pointsHomeDart2Seg;
        int pointsHomeDart3Seg;

        pointsHomeDart1 = (EditText) findViewById(editHomeDart1);
        String pointsHomeDart1Is = pointsHomeDart1.getText().toString();
        char result = pointsHomeDart1Is.charAt(0);
        if (result == 'D') {
            pointsHomeDart1Is = pointsHomeDart1Is.substring(1);
            pointsHomeDart1Seg = Integer.parseInt(pointsHomeDart1Is);
            pointsHomeDart1Seg = 2*pointsHomeDart1Seg;
        } else if (result == 'T') {
            pointsHomeDart1Is = pointsHomeDart1Is.substring(1);
            pointsHomeDart1Seg = Integer.parseInt(pointsHomeDart1Is);
            pointsHomeDart1Seg = 3*pointsHomeDart1Seg;
        } else {
            pointsHomeDart1Seg = Integer.parseInt(pointsHomeDart1Is);
        }

        pointsHomeDart2 = (EditText) findViewById(editHomeDart2);
        String pointsHomeDart2Is = pointsHomeDart2.getText().toString();
        result = pointsHomeDart2Is.charAt(0);
        if (result == 'D') {
            pointsHomeDart2Is = pointsHomeDart2Is.substring(1);
            pointsHomeDart2Seg = Integer.parseInt(pointsHomeDart2Is);
            pointsHomeDart2Seg = 2*pointsHomeDart2Seg;
        } else if (result == 'T') {
            pointsHomeDart2Is = pointsHomeDart2Is.substring(1);
            pointsHomeDart2Seg = Integer.parseInt(pointsHomeDart2Is);
            pointsHomeDart2Seg = 3*pointsHomeDart2Seg;
        } else {
            pointsHomeDart2Seg = Integer.parseInt(pointsHomeDart2Is);
        }

        pointsHomeDart3 = (EditText) findViewById(editHomeDart3);
        String pointsHomeDart3Is = pointsHomeDart3.getText().toString();
        result = pointsHomeDart3Is.charAt(0);
        if (result == 'D') {
            pointsHomeDart3Is = pointsHomeDart3Is.substring(1);
            pointsHomeDart3Seg = Integer.parseInt(pointsHomeDart3Is);
            pointsHomeDart3Seg = 2*pointsHomeDart3Seg;
        } else if (result == 'T') {
            pointsHomeDart3Is = pointsHomeDart3Is.substring(1);
            pointsHomeDart3Seg = Integer.parseInt(pointsHomeDart3Is);
            pointsHomeDart3Seg = 3*pointsHomeDart3Seg;
        } else {
            pointsHomeDart3Seg = Integer.parseInt(pointsHomeDart3Is);
        }

        //Update Home score
        int scoreHome = throwScore(pointsHomeDart1Seg,pointsHomeDart2Seg,pointsHomeDart3Seg);
        TextView textHomeThrow1 = (TextView) findViewById(R.id.textHomeThrow1);
        textHomeThrow1.setText(scoreHome);

        //setContentView(R.layout.activity_main);

        //TextView tv0 = (TextView) findViewById(editHomeScore);
        //String score = tv0.getText().toString();

        //TextView tv1 = (TextView)findViewById(R.id.textHomeThrow1);
        //tv1.setText(scoreHome);

        //TextView tv2 = (TextView)findViewById(R.id.textHomeScore1);
        //tv2.setText(Integer.parseInt(score)-Integer.parseInt(scoreHome));

        // Away Shots l-3; convert EditText values to integers
        pointsAwayDart1 = (EditText) findViewById(editAwayDart1);
        int pointsAwayDart1Is = Integer.parseInt(pointsAwayDart1.getText().toString());

        pointsAwayDart2 = (EditText) findViewById(editAwayDart2);
        int pointsAwayDart2Is = Integer.parseInt(pointsAwayDart2.getText().toString());

        pointsAwayDart3 = (EditText) findViewById(editAwayDart3);
        int pointsAwayDart3Is = Integer.parseInt(pointsAwayDart3.getText().toString());

        //Update Away score
        int scoreAway = throwScore(pointsAwayDart1Is,pointsAwayDart2Is,pointsAwayDart3Is);

        //      TextView textAwayThrow1 = (TextView) findViewById(R.id.textAwayThrow1);
        //    textAwayThrow1.setText(scoreHome);

        //setContentView(R.layout.activity_main);

        //tv0 = (TextView) findViewById(editAwayScore);
        //score = tv0.getText().toString();

        //tv1 = (TextView)findViewById(R.id.textAwayThrow1);
        //tv1.setText(scoreAway);

        //tv2 = (TextView)findViewById(R.id.textAwayScore1);
        //tv2.setText(Integer.parseInt(score)-Integer.parseInt(scoreHome));
    }

    /**
     * This method converts segments to points
     *
     * @param shot1 : the segment hit on the first dart shot
     * @param shot2 : the segment hit on the second dart shot
     * @param shot3 : the segment hit on the third dart shot
     */

    public int throwScore(int shot1, int shot2, int shot3) {
        //int shotScore1;
        //int shotScore2;
        //int shotScore3;

        Class c1 = new Class();

        //lookup points value in hashMap
        //shotScore1 = dartboardSegments.get(c1);
        //shotScore2 = dartboardSegments.get(c1);
        //shotScore3 = dartboardSegments.get(c1);

        Log.v("MainActivity", "shotScore1: " + shot1);
        Log.v("MainActivity", "shotScore2: " + shot2);
        Log.v("MainActivity", "shotScore3: " + shot3);

        return (shot1 + shot2 + shot3);
    }

    /**
     * This builds a HashMap with the dartboard segment points.
     * This allows the throwScore method to lookup the number of points to assign to each shot.
     * Segments 1-20, 25 and 50 can be converted to int using Integer.parseInt() and don't need to be included.
     * The following segments are included:
     *          Doubles: D1-D20, point value 2 - 40;
     *          Trebles: T1-T20, point value 3 - 60;
     *          Outer Bullseye: B or OB = 25;
     *          Inner Bullseye (aka double Bullseye): IB, DB or D25 = 50;
     */
    public class Class {

        public Class() {

            //Doubles
            dartboardSegments.put("D1", 2);
            dartboardSegments.put("D2", 4);
            dartboardSegments.put("D3", 6);
            dartboardSegments.put("D4", 8);
            dartboardSegments.put("D5", 10);
            dartboardSegments.put("D6", 12);
            dartboardSegments.put("D7", 14);
            dartboardSegments.put("D8", 16);
            dartboardSegments.put("D9", 18);
            dartboardSegments.put("D10", 20);
            dartboardSegments.put("D11", 22);
            dartboardSegments.put("D12", 24);
            dartboardSegments.put("D13", 26);
            dartboardSegments.put("D14", 28);
            dartboardSegments.put("D15", 30);
            dartboardSegments.put("D16", 32);
            dartboardSegments.put("D17", 34);
            dartboardSegments.put("D18", 36);
            dartboardSegments.put("D19", 38);
            dartboardSegments.put("D20", 40);
            //Trebles
            dartboardSegments.put("T1", 3);
            dartboardSegments.put("T2", 6);
            dartboardSegments.put("T3", 9);
            dartboardSegments.put("T4", 12);
            dartboardSegments.put("T5", 15);
            dartboardSegments.put("T6", 18);
            dartboardSegments.put("T7", 21);
            dartboardSegments.put("T8", 24);
            dartboardSegments.put("T9", 27);
            dartboardSegments.put("T10", 30);
            dartboardSegments.put("T11", 33);
            dartboardSegments.put("T12", 36);
            dartboardSegments.put("T13", 39);
            dartboardSegments.put("T14", 42);
            dartboardSegments.put("T15", 45);
            dartboardSegments.put("T16", 48);
            dartboardSegments.put("T17", 51);
            dartboardSegments.put("T18", 54);
            dartboardSegments.put("T19", 57);
            dartboardSegments.put("T20", 60);
            //Bullseye - allowing for possible abbreviations
            dartboardSegments.put("B", 25);
            dartboardSegments.put("OB", 25);
            dartboardSegments.put("IB", 50);
            dartboardSegments.put("DB", 50);
            dartboardSegments.put("D25", 50);
        }
    }
}

// TODO Define functionality of the start button: check that the x01 game has been entered (1001, 701, 501, 301)
// TODO Copy x01 game from Home Player Score to Away Player Score
// TODO Define functionality for the score button: score the Home throw and the Away throw
// TODO Calculate each player's average points per throw (i.e. per 3 darts thrown)
// TODO Define point lookup in the hashMap