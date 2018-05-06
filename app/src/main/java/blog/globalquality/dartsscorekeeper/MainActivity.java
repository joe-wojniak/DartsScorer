package blog.globalquality.dartsscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static blog.globalquality.dartsscorekeeper.R.id.editHomeDart1;

public class MainActivity extends AppCompatActivity {

    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addKeyListener();
    }

    private void addKeyListener() {

        // get edittext component
        edittext = (EditText) findViewById(R.id.editHomeDart3);

        // add a keylistener to get entered values for Home Player's shots 1-3
        // code stub modified from https://www.mkyong.com/android/android-prompt-user-input-dialog-example/
        edittext.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // if keydown and "enter" is pressed
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    // get entered values from editText for Home Player's shots 1-3
                    EditText pointsHomeDart1 = (EditText) findViewById(editHomeDart1);
                    String pointsHomeDart1Is = (String) pointsHomeDart1.getText().toString();

                    EditText pointsHomeDart2 = (EditText) findViewById(R.id.editHomeDart2);
                    String pointsHomeDart2Is = (String) pointsHomeDart2.getText().toString();

                    EditText pointsHomeDart3 = (EditText) findViewById(R.id.editHomeDart3);
                    String pointsHomeDart3Is = (String) pointsHomeDart3.getText().toString();

                    String throwScoreHome = throwScore(pointsHomeDart1Is, pointsHomeDart2Is, pointsHomeDart3Is);

                    Log.v("MainActivity", "Home scored: " + throwScoreHome);

                    return true;

                }
                }
            }
        });
    }

    /**
     * This method converts segments to points
     *
     * @param shot1 : the segment hit on the first dart shot
     * @param shot2 : the segment hit on the second dart shot
     * @param shot3 : the segment hit on the third dart shot
     */

    private String throwScore(String shot1, String shot2, String shot3) {

        int shotScore1 = 0; // initialize local variables
        int shotScore2 = 0;
        int shotScore3 = 0;

        // convert String to int; first dart thrown (first shot)
        try {
            shotScore1 = Integer.parseInt(shot1);
        } catch (NumberFormatException e) {
            //lookup points value in dartboardSegmentsSparseArray
        }

        // convert String to int; 2nd dart thrown (2nd shot)
        try {
            shotScore2 = Integer.parseInt(shot2);
        } catch (NumberFormatException e) {
            //lookup points value in dartboardSegmentsSparseArray
        }

        // convert String to int; 3rd dart thrown (3rd shot)
        try {
            shotScore3 = Integer.parseInt(shot3);
        } catch (NumberFormatException e) {
            //lookup points value in dartboardSegmentsSparseArray
        }

        Log.v("MainActivity", "shotScore1: " + shotScore1);
        Log.v("MainActivity", "shotScore2: " + shotScore2);
        Log.v("MainActivity", "shotScore3: " + shotScore3);

        return Integer.toString(shotScore1 + shotScore2 + shotScore3);

    }
    /**
     * This builds a SparseArray with the dartboard segment points.
     * This allows the throwScore method to lookup the number of points to assign to each shot.
     * Segments 1-20, 25 and 50 can be converted to int using Integer.parseInt() and don't need to be included.
     * The following segments are included:
     *          Doubles: D1-D20, point value 2 - 40;
     *          Trebles: T1-T20, point value 3 - 60;
     *          Outer Bullseye: B or OB = 25;
     *          Inner Bullseye (aka double Bullseye): IB, DB or D25 = 50;
     */
    public class dartboardSegments {

    SparseArray<dartboardSegments> dartboardSegmentsSparseArray = new SparseArray<dartboardSegments>();

        private void setDartboardSegmentsSparseArray() {
        //Doubles
        dartboardSegmentsSparseArray.put(int D1, 2);
        dartboardSegmentsSparseArray.put(int D2,4);
        dartboardSegmentsSparseArray.put(int D3,6);
        dartboardSegmentsSparseArray.put(int D4,8);
        dartboardSegmentsSparseArray.put(int D5,10);
        dartboardSegmentsSparseArray.put(int D6,12);
        dartboardSegmentsSparseArray.put(int D7,14);
        dartboardSegmentsSparseArray.put(int D8,16);
        dartboardSegmentsSparseArray.put(int D9,18);
        dartboardSegmentsSparseArray.put(int D10,20);
        dartboardSegmentsSparseArray.put(int D11,22);
        dartboardSegmentsSparseArray.put(int D12,24);
        dartboardSegmentsSparseArray.put(int D13,26);
        dartboardSegmentsSparseArray.put(int D14,28);
        dartboardSegmentsSparseArray.put(int D15,30);
        dartboardSegmentsSparseArray.put(int D16,32);
        dartboardSegmentsSparseArray.put(int D17,34);
        dartboardSegmentsSparseArray.put(int D18,36);
        dartboardSegmentsSparseArray.put(int D19,38);
        dartboardSegmentsSparseArray.put(int D20,40);
        //Trebles
        dartboardSegmentsSparseArray.put(int T1,3);
        dartboardSegmentsSparseArray.put(int T2,6);
        dartboardSegmentsSparseArray.put(int T3,9);
        dartboardSegmentsSparseArray.put(int T4,12);
        dartboardSegmentsSparseArray.put(int T5,15);
        dartboardSegmentsSparseArray.put(int T6,18);
        dartboardSegmentsSparseArray.put(int T7,21);
        dartboardSegmentsSparseArray.put(int T8,24);
        dartboardSegmentsSparseArray.put(int T9,27);
        dartboardSegmentsSparseArray.put(int T10,30);
        dartboardSegmentsSparseArray.put(int T11,33);
        dartboardSegmentsSparseArray.put(int T12,36);
        dartboardSegmentsSparseArray.put(int T13,39);
        dartboardSegmentsSparseArray.put(int T14,42);
        dartboardSegmentsSparseArray.put(int T15,45);
        dartboardSegmentsSparseArray.put(int T16,48);
        dartboardSegmentsSparseArray.put(int T17,51);
        dartboardSegmentsSparseArray.put(int T18,54);
        dartboardSegmentsSparseArray.put(int T19,57);
        dartboardSegmentsSparseArray.put(int T20,60);
        //Bullseye - allowing for possible abbreviations
        dartboardSegmentsSparseArray.put(int B,25);
        dartboardSegmentsSparseArray.put(int OB,25);
        dartboardSegmentsSparseArray.put(int IB,50);
        dartboardSegmentsSparseArray.put(int DB,50);
        dartboardSegmentsSparseArray.put(int D25,50);
    }
}
}