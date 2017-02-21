package argusui.com.argus;

/**
 * Created by EDWIN JOSE on 2/21/2017.
 */

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class GesturePad extends Activity implements GestureOverlayView.OnGesturePerformedListener {
    GestureLibrary mLibrary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!mLibrary.load()) {
            finish();
        }

        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);
    }

    ///
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
            String result = predictions.get(0).name;

            if ("music".equalsIgnoreCase(result)) {
                Toast.makeText(this, "Opening music player ", Toast.LENGTH_LONG).show();
            } else if ("contacts".equalsIgnoreCase(result)) {
                Toast.makeText(this, "opening contacts", Toast.LENGTH_LONG).show();
            }
        }
    }

}