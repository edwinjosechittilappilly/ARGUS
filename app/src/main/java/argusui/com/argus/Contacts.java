package argusui.com.argus;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.tts.TextToSpeech;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by EDWIN JOSE on 2/25/2017.
 */

public class Contacts extends Activity {

    String nam[] = {"", "Adish", "Alan", "Aljo", "Allen", "Babitha", "Chetan", "Santhosh", "Sumukh", "Zvendata"};
    String num[] = {"", "9 7 3 1 1 6 2 4 9 8", "9 4 0 0 9 2 2 2 1 1", " 9 7 4 7 6 6 4 3 8 8", "9 4 9 5 5 4 9 0 3 3", "9 5 2 6 0 0 3 4 1 8", "9 7 3 9 2 7 8 5 1 2", "9 9 7 2 3 6 6 3 4 6", "8  1 4 7 3 0 2 5 1 6", " 9 6 8 6 8 4 7 0 1 4"};
    Button b[] = new Button[num.length];
    int index = 1;
    TextToSpeech t1;
    int pg = 1;
    int f[] = new int[10];
    public int j;

    public void nrst(int n) {
        for (int i = 0; i < f.length; i++) {
            if (i != n)
                f[i] = 0;
        }
    }

    public void updateup(int i) {
        j = i - 1;
        while (index < 4 * i) {
            b[0] = (Button) findViewById(R.id.button1);
            b[0].setText(nam[index++]);
            b[1] = (Button) findViewById(R.id.button2);
            b[1].setText(nam[index++]);
            b[2] = (Button) findViewById(R.id.button3);
            b[2].setText(nam[index++]);
            b[3] = (Button) findViewById(R.id.button4);
            b[3].setText(nam[index++]);
        }


    }

    public void updatedn(int i) {
        j = i - 1;
        while (index >((4 * i) - 4)) {
            b[3] = (Button) findViewById(R.id.button4);
            b[3].setText(nam[index--]);
            b[2] = (Button) findViewById(R.id.button3);
            b[2].setText(nam[index--]);
            b[1] = (Button) findViewById(R.id.button2);
            b[1].setText(nam[index--]);
            b[0] = (Button) findViewById(R.id.button1);
            b[0].setText(nam[index--]);
        }


    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        index = 1;

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(new Locale("en", "IN"));
                }
                t1.speak(" Contacts Page ", TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        updateup(1);
        b[0] = (Button) findViewById(R.id.button1);
        b[1] = (Button) findViewById(R.id.button2);
        b[2] = (Button) findViewById(R.id.button3);
        b[3] = (Button) findViewById(R.id.button4);
        b[4] = (Button) findViewById(R.id.button5);
        b[5] = (Button) findViewById(R.id.button6);
        b[6] = (Button) findViewById(R.id.button7);
        //
        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }
        //
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ind = 0;

                nrst(ind);
                f[ind]++;
                if (f[ind] == 1) {
                    //stt
                    t1.speak("call " + b[ind].getText() + " press again to call", TextToSpeech.QUEUE_FLUSH, null);

                    //
                } else if (f[ind] == 2) {
                    f[ind] = 0;
                    t1.speak(" calling " + b[ind].getText(), TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String no = num[(ind + 1) + (4 * j)].replaceAll("\\s+", "");
                    intent.setData(Uri.parse("tel:" + no));
                    startActivity(intent);
                    //fuction  to be done
                }
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ind = 1;

                nrst(ind);
                f[ind]++;
                if (f[ind] == 1) {
                    //stt
                    t1.speak("call " + b[ind].getText() + " press again to call", TextToSpeech.QUEUE_FLUSH, null);

                    //
                } else if (f[ind] == 2) {
                    f[ind] = 0;
                    t1.speak(" calling " + b[ind].getText(), TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String no = num[(ind + 1) + (4 * j)].replaceAll("\\s+", "");
                    intent.setData(Uri.parse("tel:" + no));
                    startActivity(intent);
                    //fuction  to be done
                }
            }
        });
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ind = 2;

                nrst(ind);
                f[ind]++;
                if (f[ind] == 1) {
                    //stt
                    t1.speak("call " + b[ind].getText() + " press again to call", TextToSpeech.QUEUE_FLUSH, null);

                    //
                } else if (f[ind] == 2) {
                    f[ind] = 0;
                    t1.speak(" calling " + b[ind].getText(), TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String no = num[(ind + 1) + (4 * j)].replaceAll("\\s+", "");
                    intent.setData(Uri.parse("tel:" + no));
                    startActivity(intent);
                    //fuction  to be done
                }
            }
        });
        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ind = 3;

                nrst(ind);
                f[ind]++;
                if (f[ind] == 1) {
                    //stt
                    t1.speak("call " + b[ind].getText() + " press again to call", TextToSpeech.QUEUE_FLUSH, null);

                    //
                } else if (f[ind] == 2) {
                    f[ind] = 0;
                    t1.speak(" calling " + b[ind].getText(), TextToSpeech.QUEUE_FLUSH, null);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String no = num[(ind + 1) + (4 * j)].replaceAll("\\s+", "");
                    intent.setData(Uri.parse("tel:" + no));
                    startActivity(intent);
                    //fuction  to be done
                }
            }
        });


        //
        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ind = 4;

                nrst(ind);
                f[ind]++;
                if (f[ind] == 1) {
                    //stt
                    t1.speak("next page press again ", TextToSpeech.QUEUE_FLUSH, null);

                    //
                } else if (f[ind] == 2) {
                    f[ind] = 0;
                    pg = pg + 1;
                    updateup(pg);
                    //fuction  to be done
                }
            }
        });
        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ind = 5;

                nrst(ind);
                f[ind]++;
                if (pg == 1) {
                    t1.speak(" No previous page ", TextToSpeech.QUEUE_FLUSH, null);
                } else {
                    if (f[ind] == 1) {
                        //stt
                        t1.speak("previous page press again", TextToSpeech.QUEUE_FLUSH, null);

                        //
                    } else if (f[ind] == 2) {
                        f[ind] = 0;
                        pg = pg - 1;
                        index=(4*pg);
                        updatedn(pg);

                        //fuction  to be done
                    }
                }
            }
        });

    }
}
