package my.hostel.soham.brahmaputra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Soham_T on 8/1/2017.
 */

public class Menus extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        Intent intent = getIntent();
        ImageButton b1=(ImageButton)findViewById(R.id.buttonm1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menus.this,Juice.class));
            }
        });
        ImageButton b2=(ImageButton)findViewById(R.id.buttonm2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menus.this,Canteen.class));
            }
        });
        ImageButton b3=(ImageButton)findViewById(R.id.buttonm3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menus.this,Mess.class));
            }
        });
        ImageButton b4=(ImageButton)findViewById(R.id.buttonm4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menus.this,Live.class));
            }
        });
    }
}
