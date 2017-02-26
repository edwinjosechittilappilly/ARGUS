package argusui.com.argus;

/**
 * Created by EDWIN JOSE on 2/21/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
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
    public int flag = 0;
    private String act = "";
    SharedPreferences mPrefs3;
    final String welcomeScreenShownPref3 = "welcomeScreenShown3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_pad);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(new Locale("en", "IN"));
                }
            }
        });
        //welcome

        mPrefs3 = PreferenceManager.getDefaultSharedPreferences(this);

        // second argument is the default to use if the preference can't be found
        Boolean welcomeScreenShown3 = mPrefs3.getBoolean(welcomeScreenShownPref3, false);

        if (!welcomeScreenShown3) {
            // here you can launch another activity if you like
            // the code below will display a popup
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gesture);
                    mp.start();
                }
            }, 3000);
            SharedPreferences.Editor editor = mPrefs3.edit();
            editor.putBoolean(welcomeScreenShownPref3, true);
            editor.commit(); // Very important to save the preference
        }

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
    public boolean onOkPerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
            String result = predictions.get(0).name;
            if ("ok".equalsIgnoreCase(result)) {

                return true;
            } else
                return false;
        }
        return false;
    }

    ///
    ///
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

        //
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //t1.setLanguage(new Locale("en", "IN"));
                    t1.setLanguage(new Locale("en", "IN"));
                }
            }
        });

        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
            String result = predictions.get(0).name;
            if (onOkPerformed(overlay, gesture)) {
                flag = 2;
                result = act;
            }
            if ("music".equalsIgnoreCase(result)) {
                if (flag == 0) {
                    act = result;
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  music player tick to open", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                } else if (flag == 2) {
                    act = "";
                    flag = 0;
                    Toast.makeText(this, "opening Music player", Toast.LENGTH_LONG).show();
                    t1.speak("  opening music player", TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
               /* if (onOkPerformed(overlay, gesture))
                    Toast.makeText(this, "Opening music player ", Toast.LENGTH_LONG).show();*/

            } else if ("contacts".equalsIgnoreCase(result)) {
                if (flag == 0) {
                    act = result;
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  contacts tick to open", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                } else if (flag == 2) {
                    act = "";
                    flag = 0;
                    Toast.makeText(this, "opening contacts", Toast.LENGTH_LONG).show();
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  opening contacts ", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                   /* MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.ocrcamera);
                    mp.start();*/

                    Intent read1 = new Intent(getApplicationContext(),Contacts.class);
                    startActivity(read1);
                }

                //opening traditional contacts
            } else if ("dialer".equalsIgnoreCase(result)) {
                if (flag == 0) {
                    act = result;
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  dialer. tick to open", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                } else if (flag == 2) {

                    act = "";
                    flag = 0;
                    Intent i = new Intent(getApplicationContext(), DialPad.class);
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  opening Dialer ", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                    startActivity(i);
                }


            } else if ("home".equalsIgnoreCase(result)) {
                if (flag == 0) {
                    act = result;
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  Home screen. tick to open", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                } else if (flag == 2) {
                    act = "";
                    flag = 0;
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status != TextToSpeech.ERROR) {
                                t1.setLanguage(new Locale("en", "IN"));
                            }
                            t1.speak("  opening Home screen ", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                    startActivity(i);
                }
            }

        }

    }

}