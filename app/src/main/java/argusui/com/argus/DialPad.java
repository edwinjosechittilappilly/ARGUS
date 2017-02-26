package argusui.com.argus;

/**
 * Created by EDWIN JOSE on 2/21/2017.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.String;
import java.util.Locale;

public class
DialPad extends AppCompatActivity {

    private int l;
    Button b[] = new Button[20];
    Button dial, bksp;
    TextToSpeech t1;
    TextView txt;
    //test


    SharedPreferences mPrefs2;
    final String welcomeScreenShownPref2 = "welcomeScreenShown2";
    //

    String ph = "";

    int f[] = new int[100];

    public void nrst(int n) {

        for (int i = 0; i < f.length; i++) {
            if (i != n)
                f[i] = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialler);
        txt = (TextView) findViewById(R.id.dphoneno);

        //
        mPrefs2 = PreferenceManager.getDefaultSharedPreferences(this);

        // second argument is the default to use if the preference can't be found
        Boolean welcomeScreenShown2 = mPrefs2.getBoolean(welcomeScreenShownPref2, false);

        if (!welcomeScreenShown2) {
            // here you can launch another activity if you like
            // the code below will display a popup
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dialer);
                    mp.start();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dialertap);
                            mp.start();
                        }
                    }, 11000);
                }
            }, 3000);

             /*MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.ocrcamera);
                    mp.start();*/

            SharedPreferences.Editor editor = mPrefs2.edit();
            editor.putBoolean(welcomeScreenShownPref2, true);
            editor.commit(); // Very important to save the preference
        }

        //
        //resetting buttons
        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }
        //
        ph = "";
        //
        b[0] = (Button) findViewById(R.id.buttond0);
        b[1] = (Button) findViewById(R.id.buttond1);
        b[2] = (Button) findViewById(R.id.buttond2);
        b[3] = (Button) findViewById(R.id.buttond3);
        b[4] = (Button) findViewById(R.id.buttond4);
        b[5] = (Button) findViewById(R.id.buttond5);
        b[6] = (Button) findViewById(R.id.buttond6);
        b[7] = (Button) findViewById(R.id.buttond7);
        b[8] = (Button) findViewById(R.id.buttond8);
        b[9] = (Button) findViewById(R.id.buttond9);

        b[10] = (Button) findViewById(R.id.buttonds);
        b[11] = (Button) findViewById(R.id.buttondh);
        dial = (Button) findViewById(R.id.buttondcall);
        bksp = (Button) findViewById(R.id.buttondback);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
                t1.speak(" Dialer  Opened ", TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        //button 0

        b[0].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                int index = 0;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);


                    //fuction  to be done
                }
            }
        });
        //button 1
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int index = 1;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });
        //button 2

        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int index = 2;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);
                    //fuction  to be done
                }
            }
        });
        //button 3

        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int index = 3;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int index = 4;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int index = 5;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int index = 6;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 7;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 8;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 9;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + " " + index;
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        //
        b[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 10;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + "" + "*";
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        b[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 11;
                nrst(index);
                f[index]++;
                String toSpeak = b[index].getText().toString();
                if (f[index] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" pressed " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    ph = ph + "" + "#";
                    txt.setText(ph);

                    //fuction  to be done
                }
            }
        });

        ///
        //repeat
        //button dial

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 11;
                nrst(index);
                f[index]++;
                if (f[index] == 1) {
                    //stt
                    t1.speak("Dialed number is " + ph + " press again to call", TextToSpeech.QUEUE_FLUSH, null);

                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" dialing ", TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    ph = ph.replaceAll("\\s+", "");
                    intent.setData(Uri.parse("tel:" + ph));
                    startActivity(intent);
                    ph = "";
                    txt.setText(ph);
                    //fuction  to be done
                }
            }
        });


        //button bksp
        //button dial


        bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = 12;
                nrst(index);
                f[index]++;
                if (f[index] == 1) {
                    //stt
                    if (ph != null && ph.length() > 0) {
                        t1.speak("Delete " + ph.charAt(ph.length() - 1) + "   press again to delete", TextToSpeech.QUEUE_FLUSH, null);
                    } else
                        t1.speak("No number to delete", TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    if (ph != null && ph.length() > 0) {
                        String rem = "" + ph.charAt(ph.length() - 1);
                        ph = ph.substring(0, ph.length() - 1);
                        txt.setText(ph);
                        t1.speak(" removed " + rem, TextToSpeech.QUEUE_FLUSH, null);

                    } else {
                        t1.speak("No number to delete", TextToSpeech.QUEUE_FLUSH, null);

                    }
                    // /fuction  to be done
                }
            }
        });


        // /
    }
}
