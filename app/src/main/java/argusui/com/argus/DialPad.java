package argusui.com.argus;

/**
 * Created by EDWIN JOSE on 2/21/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class DialPad extends AppCompatActivity {


    Button b[] = new Button[20];
    Button dial, bksp;
    TextToSpeech t1;
    public EditText editText;

    String num = "";

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
        EditText editText = (EditText) findViewById(R.id.dphoneno);
        editText.setText(num, TextView.BufferType.EDITABLE);
        //resetting buttons
        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }
        //
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
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        //button 0
        editText.setText(num);
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
                    num = num + "" + index;

                    //fuction  to be done
                }
            }
        });
        //button 1
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        //button 2
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        //button 3
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + index;
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + "*";
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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
                    num = num + "" + "#";
                    //fuction  to be done
                }
            }
        });
        editText.setText(num);
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

                    t1.speak("Dialed number is " + num + " press again to call", TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    t1.speak(" dialing " + num, TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + num));
                    startActivity(intent);
                    //fuction  to be done
                }
            }
        });


        //button bksp
        //button dial
        editText.setText(num);

        bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = 12;
                nrst(index);
                f[index]++;
                if (f[index] == 1) {
                    //stt
                    if (num != null && num.length() > 0) {
                        t1.speak("Delete " + num.charAt(num.length() - 1) + "   press again to delete", TextToSpeech.QUEUE_FLUSH, null);
                    } else
                        t1.speak("No number to delete", TextToSpeech.QUEUE_FLUSH, null);
                    //
                } else if (f[index] == 2) {
                    f[index] = 0;
                    if (num != null && num.length() > 0) {
                        String rem = "" + num.charAt(num.length() - 1);
                        num = num.substring(0, num.length() - 1);
                        t1.speak(" removed " + rem, TextToSpeech.QUEUE_FLUSH, null);
                    } else
                        t1.speak("No number to delete", TextToSpeech.QUEUE_FLUSH, null);
                    //fuction  to be done
                }
            }
        });


        // /
    }
}
