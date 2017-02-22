package argusui.com.argus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5,b6;
    TextView bt;
    int f1, f2, f3, f4, f5;
    TextToSpeech t1;
    int f[] = new int[10];

    public void nrst(int n) {
        for (int i = 0; i < f.length; i++) {
            if (i != n)
                f[i] = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        //resetting values

        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }
        //

        //stt
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
                t1.speak(" Home  Screen ", TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        //home screen talking
        bt = (TextView) findViewById(R.id.textView2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //home screen stt
                String toSpeak = bt.getText().toString();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        //
        //button 1
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrst(1);
                f[1]++;
                String toSpeak = b1.getText().toString();
                if (f[1] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[1] == 2) {
                    f[1] = 0;
                    t1.speak("  opening " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //fuction  to be done
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.google.com"));
                    startActivity(i);
                }
            }
        });

        //button 2

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                nrst(2);
                f[2]++;
                String toSpeak = b2.getText().toString();
                if (f[2] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[2] == 2) {
                    f[2] = 0;
                    //fuction  to be done
                    t1.speak(" Opening Dialer ", TextToSpeech.QUEUE_FLUSH, null);
                    Intent i = new Intent(getApplicationContext(),DialPad.class);
                    startActivity(i);
                }
            }
        });
        //button 3
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                nrst(3);
                f[3]++;
                String toSpeak = b3.getText().toString();
                if (f[3] == 1) {
                    //stt
                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[3] == 2) {
                    f[3] = 0;
                    //fuction  to be done
                    t1.speak(" Opening " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    Intent read1 = new Intent();
                    read1.setAction(android.content.Intent.ACTION_VIEW);
                    read1.setData(ContactsContract.Contacts.CONTENT_URI);
                    startActivity(read1);
                }


                //

            }
        });
        //button 4

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrst(4);
                f[4]++;
                String toSpeak = b4.getText().toString();
                if (f[4] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[4] == 2) {
                    f[4] = 0;
                    //fuction  to be done
                    t1.speak(" Activating " + toSpeak + " commands ", TextToSpeech.QUEUE_FLUSH, null);
                    Intent i = new Intent(Intent.ACTION_VOICE_COMMAND);
                    startActivity(i);
                }


            }
        });
        //button 5
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrst(5);
                f[5]++;
                String toSpeak = b5.getText().toString();
                if (f[5] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[5] == 2) {
                    f[5] = 0;
                    //fuction  to be done
                    t1.speak(" Opening " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(i);
                }


                //

            }
        });
        //getsture
        b6=(Button)findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nrst(6);
                f[6]++;
                String toSpeak = b6.getText().toString();
                if (f[6] == 1) {
                    //stt

                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[6] == 2) {
                    f[6] = 0;
                    //fuction  to be done
                    t1.speak(" Opening " + toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    Intent i = new Intent(getApplicationContext(),GesturePad.class);
                    startActivity(i);
                }


                //

            }
        });
    }
}

