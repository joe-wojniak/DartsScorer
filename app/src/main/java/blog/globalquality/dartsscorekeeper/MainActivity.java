package blog.globalquality.dartsscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import java.util.HashMap;

import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart1;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart2;
import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart3;

public class MainActivity extends AppCompatActivity {

    EditText pointsHomeDart1;
    EditText pointsHomeDart2;
    EditText pointsHomeDart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsHomeDart1 = (EditText) findViewById(editHomeDart1);
        String pointsHomeDart1Is = (String) pointsHomeDart1.getText().toString();

        pointsHomeDart2 = (EditText) findViewById(editHomeDart2);
        String pointsHomeDart2Is = (String) pointsHomeDart2.getText().toString();

        pointsHomeDart3 = (EditText) findViewById(editHomeDart3);
        String pointsHomeDart3Is = (String) pointsHomeDart3.getText().toString();
    }

    /**
     * This method converts segments to points
     *
     * @param shot1 : the segment hit on the first dart shot
     * @param shot2 : the segment hit on the second dart shot
     * @param shot3 : the segment hit on the third dart shot
     */

    public String throwScore(String shot1, String shot2, String shot3) {

        int shotScore1 = 0;
        int shotScore2 = 0;
        int shotScore3 = 0;

        Class c1 = new Class();

        // convert String to int; first dart thrown (first shot)
        try {
            shotScore1 = Integer.parseInt(shot1);
        } catch (NumberFormatException e) {
            //lookup points value in hashMap
            shotScore1 = c1.get(shot1);
        }

        // convert String to int; 2nd dart thrown (2nd shot)
        try {
            shotScore2 = Integer.parseInt(shot2);
        } catch (NumberFormatException e) {
            //lookup points value in hashMap
        }

        // convert String to int; 3rd dart thrown (3rd shot)
        try {
            shotScore3 = Integer.parseInt(shot3);
        } catch (NumberFormatException e) {
            //lookup points value in hashMap
        }

        Log.v("MainActivity", "shotScore1: " + shotScore1);
        Log.v("MainActivity", "shotScore2: " + shotScore2);
        Log.v("MainActivity", "shotScore3: " + shotScore3);

        return Integer.toString(shotScore1 + shotScore2 + shotScore3);

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

        HashMap<String, Integer> dartboardSegments = new HashMap<String, Integer>();

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
