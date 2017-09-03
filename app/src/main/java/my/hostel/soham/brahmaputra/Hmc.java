package my.hostel.soham.brahmaputra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Soham on 7/18/2017.
 */

public class Hmc extends AppCompatActivity {
    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hmc);
        b1=(ImageButton)findViewById(R.id.tony);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.iitg.ernet.in/eee/tony.html#tonyStart"));
                startActivity(i);
            }
        });
        b2=(ImageButton)findViewById(R.id.benny);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.iitg.ernet.in/ben/"));
                startActivity(i);
            }
        });
        b3=(ImageButton)findViewById(R.id.partho);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.iitg.ernet.in/chemeng/pspg/home"));
                startActivity(i);
            }
        });
        b4=(ImageButton)findViewById(R.id.parth);
        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/gorkhiya.parth"));
                startActivity(i);
            }
        });
        b5=(ImageButton)findViewById(R.id.abhi);
        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100001334030652"));
                startActivity(i);
            }
        });
        b6=(ImageButton)findViewById(R.id.vinay);
        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/vinay.dubey.9047"));
                startActivity(i);
            }
        });
        b7=(ImageButton)findViewById(R.id.fouzder);
        b7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/gofouz"));
                startActivity(i);
            }
        });
        b8=(ImageButton)findViewById(R.id.asif);
        b8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100005908921745"));
                startActivity(i);
            }
        });
        b9=(ImageButton)findViewById(R.id.avishek);
        b9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/avishek.banik.50"));
                startActivity(i);
            }
        });
        b10=(ImageButton)findViewById(R.id.tushar);
        b10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/tusharyadav01"));
                startActivity(i);
            }
        });
        b11=(ImageButton)findViewById(R.id.rohit);
        b11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100010607021535"));
                startActivity(i);
            }
        });
        TextView t1=(TextView) findViewById(R.id.textView4);
        t1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+918638310118"));
                startActivity(i);
            }
        });
        TextView t2=(TextView) findViewById(R.id.textView5);
        t2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919958694992"));
                startActivity(i);
            }
        });
        TextView t3=(TextView) findViewById(R.id.textView6);
        t3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919476620432"));
                startActivity(i);
            }
        });
        TextView t4=(TextView) findViewById(R.id.textView7);
        t4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919401917453"));
                startActivity(i);
            }
        });
        TextView t5=(TextView) findViewById(R.id.textView8);
        t5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919493673561"));
                startActivity(i);
            }
        });
        TextView t6=(TextView) findViewById(R.id.textView9);
        t6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919435919166"));
                startActivity(i);
            }
        });
        TextView t7=(TextView) findViewById(R.id.textView10);
        t7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919711813898"));
                startActivity(i);
            }
        });
        TextView t8=(TextView) findViewById(R.id.textView11);
        t8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+917000951251"));
                startActivity(i);
            }
        });
    }
}
