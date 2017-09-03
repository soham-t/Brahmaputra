package my.hostel.soham.brahmaputra;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity
{   TextView txt[]=new TextView[6];
    final String[] url=new String[6];
    ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.pager1);
        customSwipeAdapter=new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);
        Timer timer=new Timer();
        timer.schedule(new MyTimerTask(),1500,3000);
        txt[0]=(TextView)findViewById(R.id.text1);
        txt[1]=(TextView)findViewById(R.id.text2);
        txt[2]=(TextView)findViewById(R.id.text3);
        txt[3]=(TextView)findViewById(R.id.text4);
        txt[4]=(TextView)findViewById(R.id.text5);
        txt[5]=(TextView)findViewById(R.id.text6);
        getwebsite();
        if(isNetworkAvailable())
        {
            flag=0;
        }
        else
        {
            flag=1;
        }
        if(flag==0) {
            txt[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (!(url[0].equals("javascript:void(0)"))) {
                        i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url[0]));
                        startActivity(i);
                    }
                }
            });
            txt[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (!(url[1].equals("javascript:void(0)"))) {
                        i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url[1]));
                        startActivity(i);
                    }
                }
            });
            txt[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (!(url[2].equals("javascript:void(0)"))) {
                        i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url[2]));
                        startActivity(i);
                    }
                }
            });
            txt[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (!(url[3].equals("javascript:void(0)"))) {
                        i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url[3]));
                        startActivity(i);
                    }
                }
            });
            txt[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (!(url[4].equals("javascript:void(0)"))) {
                        i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url[4]));
                        startActivity(i);
                    }
                }
            });
            txt[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (!(url[5].equals("javascript:void(0)"))) {
                        i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url[5]));
                        startActivity(i);
                    }
                }
            });
        }
    }
    public class MyTimerTask extends TimerTask{
        @Override
        public void run(){
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0)
                        viewPager.setCurrentItem(1);
                    else if(viewPager.getCurrentItem()==1)
                        viewPager.setCurrentItem(2);
                    else if(viewPager.getCurrentItem()==2)
                        viewPager.setCurrentItem(3);
                    else if(viewPager.getCurrentItem()==3)
                        viewPager.setCurrentItem(4);
                    else if(viewPager.getCurrentItem()==4)
                        viewPager.setCurrentItem(5);
                    else if(viewPager.getCurrentItem()==5)
                        viewPager.setCurrentItem(0);
                }
            });
        }
    }
    private void getwebsite() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final String[] builder = new String[6];

                try {
                    Document doc =Jsoup.connect("http://newsbrahma.blogspot.in/").get();
                    Elements metas=doc.select("div.snippet-item>a[href]");
                    int index=0;
                    for(Element meta : metas) {
                        builder[index]=meta.text();
                        url[index]=meta.attr("href");
                        index++;
                    }
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(flag==0) {
                            txt[0].setText("\u2022 " + builder[0]);
                            txt[1].setText("\u2022 " + builder[1]);
                            txt[2].setText("\u2022 " + builder[2]);
                            txt[3].setText("\u2022 " + builder[3]);
                            txt[4].setText("\u2022 " + builder[4]);
                            txt[5].setText("\u2022 " + builder[5]);
                        }
                        else
                        {
                            txt[3].setText(" ** APP IS OFFLINE **");
                        }
                    }
                });
            }
        }).start();

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu, menu);
        setIconInMenu(menu,R.id.forms,R.string.forms,R.drawable.ic_description_black_24dp);
        setIconInMenu(menu,R.id.hmc,R.string.hmc,R.drawable.ic_account_box_black_24dp);
        setIconInMenu(menu,R.id.map,R.string.maps,R.drawable.ic_place_black_24dp);
        setIconInMenu(menu,R.id.menus,R.string.menus,R.drawable.ic_library_books_black_24dp);
        setIconInMenu(menu,R.id.about,R.string.about,R.drawable.ic_info_outline_black_24dp);
        setIconInMenu(menu,R.id.bus,R.string.bus,R.drawable.ic_directions_bus_black_24dp);
        return true;
    }
    private void setIconInMenu(Menu menu, int menuID, int labelId, int iconId){
        MenuItem item=menu.findItem(menuID);
        SpannableStringBuilder builder=new SpannableStringBuilder(" "+getResources().getString(labelId));
        builder.setSpan(new ImageSpan(this,iconId),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        item.setTitle(builder);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.forms:
                startActivity(new Intent(this, Forms.class));
                return true;
            case R.id.hmc:
                startActivity(new Intent(this, Hmc.class));
                return true;
            case R.id.map:
                startActivity(new Intent(MainActivity.this,Maps.class));
                return true;
            case R.id.menus:
                startActivity(new Intent(MainActivity.this,Menus.class));
                return true;
            case R.id.about:
                startActivity(new Intent(MainActivity.this,About.class));
                return true;
            case R.id.bus:
                startActivity(new Intent(MainActivity.this,Bus.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
