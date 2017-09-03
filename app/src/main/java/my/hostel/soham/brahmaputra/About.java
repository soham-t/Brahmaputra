package my.hostel.soham.brahmaputra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Soham_T on 8/1/2017.
 */

public class About extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageButton i1=(ImageButton)findViewById(R.id.feed);
        i1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSev3Wgq3bWWE3DCYCi4gvJXeXh4Sl-hYHOomuByFNkC8eE0JA/viewform"));
                startActivity(i);
            }
        });
        ImageButton i2=(ImageButton)findViewById(R.id.fb);
        i2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/jaibrahmaputra/"));
                startActivity(i);
            }
        });
        ImageButton i3=(ImageButton)findViewById(R.id.you);
        i3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC8_tWEvXaG0c7EyYSX_K4nQ"));
                startActivity(i);
            }
        });
        ImageButton i4=(ImageButton)findViewById(R.id.gu);
        i4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/104171996566028778304"));
                startActivity(i);
            }
        });
    }
}
