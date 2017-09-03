package my.hostel.soham.brahmaputra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Soham on 7/17/2017.
 */

public class Forms extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        Intent intent = getIntent();
        ImageButton register = (ImageButton) findViewById(R.id.Registerimg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forms.this,Register.class));
            }
        });
        ImageButton suggest = (ImageButton) findViewById(R.id.Suggestimg);
        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forms.this,Suggestion.class));
            }
        });
        ImageButton help = (ImageButton) findViewById(R.id.Helpimg);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forms.this,Help.class));
            }
        });
        ImageButton comp = (ImageButton) findViewById(R.id.Compimg);
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forms.this,Comp.class));
            }
        });
    }
}
