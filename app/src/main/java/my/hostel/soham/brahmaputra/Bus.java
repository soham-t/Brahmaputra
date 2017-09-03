package my.hostel.soham.brahmaputra;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Soham_T on 8/4/2017.
 */

public class Bus extends AppCompatActivity {
    TextView txt0;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt10;
    TextView txt11;
    TextView txt12;
    TextView txt13;
    TextView txt14;
    TextView txt15;
    TextView txt16;
    TextView txt17;
    TextView txt18;
    int flag=0;
    String[] val=new String[28];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        Intent intent = getIntent();
        txt0=(TextView)findViewById(R.id.textView1b);
        txt1=(TextView)findViewById(R.id.textView2b);
        txt2=(TextView)findViewById(R.id.textView3b);
        txt3=(TextView)findViewById(R.id.textView4b);
        txt4=(TextView)findViewById(R.id.textView5b);
        txt5=(TextView)findViewById(R.id.textView6b);
        txt6=(TextView)findViewById(R.id.textView7b);
        txt7=(TextView)findViewById(R.id.textView8b);
        txt8=(TextView)findViewById(R.id.textView9b);
        txt9=(TextView)findViewById(R.id.textView10b);
        txt10=(TextView)findViewById(R.id.textView11b);
        txt11=(TextView)findViewById(R.id.textView12b);
        txt12=(TextView)findViewById(R.id.textView13b);
        txt13=(TextView)findViewById(R.id.textView14b);
        txt14=(TextView)findViewById(R.id.textView15b);
        txt15=(TextView)findViewById(R.id.textView16b);
        txt16=(TextView)findViewById(R.id.textView17b);
        txt17=(TextView)findViewById(R.id.textView18b);
        txt18=(TextView)findViewById(R.id.textViewoff);
        getwebsite();
        if(isNetworkAvailable())
        {
            flag=0;
        }
        else
        {
            flag=1;
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void getwebsite() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Document doc = Jsoup.connect("http://iitg-bus-timings.appspot.com/").get();
                    Elements metas=doc.select("tr");
                    int count=0;
                    for(Element meta : metas) {
                        String s = meta.text();
                        String[] f = s.split("\\s");
                        if(f.length<=7) {
                            val[count] = f[0];
                            val[count + 1] = f[2];
                            val[count + 2] = f[3];
                        }
                        else
                        {
                            val[count] = f[0]+" "+f[1]+" "+f[2];
                            val[count+1]=f[4];
                            val[count+2]=f[5];
                        }
                        count+=3;

                    }
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt0.setText(val[3]);
                        txt1.setText(val[4]);
                        txt2.setText(val[5]);
                        txt3.setText(val[6]);
                        txt4.setText(val[7]);
                        txt5.setText(val[8]);
                        txt6.setText(val[9]);
                        txt7.setText(val[10]);
                        txt8.setText(val[11]);
                        txt9.setText(val[15]);
                        txt10.setText(val[16]);
                        txt11.setText(val[17]);
                        txt12.setText(val[18]);
                        txt13.setText(val[19]);
                        txt14.setText(val[20]);
                        txt15.setText(val[21]);
                        txt16.setText(val[22]);
                        txt17.setText(val[23]);
                        if(flag==1)
                        {
                            txt18.setText("APP IS OFFLINE");
                        }

                    }
                });
            }
        }).start();

    }
}
