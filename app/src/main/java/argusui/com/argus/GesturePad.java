package argusui.com.argus;

/**
 * Created by EDWIN JOSE on 2/21/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class GesturePad extends Activity implements GestureOverlayView.OnGesturePerformedListener {
    GestureLibrary mLibrary;
    public TextToSpeech t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_pad);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!mLibrary.load()) {
            finish();
        }

        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);


    }

    /*  public void onPause() {
          if (t1 != null) {
              t1.stop();
              t1.shutdown();
          }
          super.onPause();
      }
  */
    ///
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

        //
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
            String result = predictions.get(0).name;

            if ("music".equalsIgnoreCase(result)) {

                t1.speak("  opening music player", TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(this, "Opening music player ", Toast.LENGTH_LONG).show();

            } else if ("contacts".equalsIgnoreCase(result)) {

                Toast.makeText(this, "opening contacts", Toast.LENGTH_LONG).show();
                t1.speak("  opening contacts", TextToSpeech.QUEUE_FLUSH, null);

            } else if ("dialer".equalsIgnoreCase(result)) {


                Intent i = new Intent(Intent.ACTION_DIAL);
                t1.speak(" Opening Dialer ", TextToSpeech.QUEUE_FLUSH, null);
                startActivity(i);


            }
        }

    }

}