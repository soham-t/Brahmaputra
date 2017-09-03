package my.hostel.soham.brahmaputra;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Soham on 7/17/2017.
 */

public class Register extends AppCompatActivity {
    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //URL derived from form URL
    public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLSeCpbspLXTm6f4x4v8X_A2XXXBhimKGzHyEA7vDE7U9u2l20A/formResponse";
    //input element ids found from the live form page
    public static final String ROOM_KEY="entry_2113494999";
    public static final String NAME_KEY="entry_1924726172";
    public static final String DEPT_KEY="entry_234307299";
    public static final String PROG_KEY="entry_1141239169";
    public static final String YEAR_KEY="entry_1713193889";
    public static final String ROLL_KEY="entry_449710570";
    public static final String WBML_KEY="entry_1300501668";
    public static final String ALTEMAIL_KEY="entry_1034764602";
    public static final String CONTCT_KEY="entry_438469556";
    public static final String ADDR_KEY="entry_1707792255";
    public static final String EMCON_KEY="entry_2024728723";
    public static final String BLOOD_KEY="entry_1315052151";
    public static final String INTRST_KEY="entry_1403799178";

    private Context context;
    private EditText roomEditText;
    private EditText nameEditText;
    private EditText deptEditText;
    private EditText yearEditText;
    private EditText rollEditText;
    private EditText webmEditText;
    private EditText mailEditText;
    private EditText contEditText;
    private EditText addrEditText;
    private EditText emcoEditText;
    private EditText intrEditText;
    private EditText progEditText;
    private String prog;
    public static String blood;
    private Spinner spinner1;
    private RadioGroup prog1;
    private RadioButton bull1;
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addListenerOnSpinnerItemSelection();
        Intent intent=getIntent();
        //save the activity in a context variable to be used afterwards
        context =this;

        //Get references to UI elements in the layout
        Button submitButton = (Button)findViewById(R.id.submitButton);
        roomEditText = (EditText)findViewById(R.id.roomEditText);
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        deptEditText = (EditText)findViewById(R.id.deptEditText);
        progEditText = (EditText)findViewById(R.id.progEditText);
        yearEditText = (EditText)findViewById(R.id.yearEditText);
        rollEditText = (EditText)findViewById(R.id.rollEditText);
        webmEditText = (EditText)findViewById(R.id.webmEditText);
        mailEditText = (EditText)findViewById(R.id.mailEditText);
        contEditText = (EditText)findViewById(R.id.contEditText);
        addrEditText = (EditText)findViewById(R.id.addrEditText);
        emcoEditText = (EditText)findViewById(R.id.emcoEditText);
        intrEditText = (EditText)findViewById(R.id.intrEditText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog1 = (RadioGroup) findViewById(R.id.program);
                int selectedId = prog1.getCheckedRadioButtonId();
                bull1 = (RadioButton) findViewById(selectedId);
                prog= bull1.getText().toString();
                if(prog.equals("Other"))
                {
                    prog=progEditText.getText().toString();
                }
                //Make sure all the fields are filled with values
                if(TextUtils.isEmpty(roomEditText.getText().toString()) ||
                        TextUtils.isEmpty(nameEditText.getText().toString()) ||
                        TextUtils.isEmpty(deptEditText.getText().toString()) ||
                        TextUtils.isEmpty(yearEditText.getText().toString()) ||
                        TextUtils.isEmpty(rollEditText.getText().toString()) ||
                        TextUtils.isEmpty(webmEditText.getText().toString()) ||
                        TextUtils.isEmpty(contEditText.getText().toString()) ||
                        TextUtils.isEmpty(addrEditText.getText().toString()) ||
                        TextUtils.isEmpty(emcoEditText.getText().toString()) ||
                        TextUtils.isEmpty(prog)||
                        TextUtils.isEmpty(blood))
                {
                    Toast.makeText(context,"Fill Up the mandatory fields.",Toast.LENGTH_LONG).show();
                    return;
                }
                //Check if a valid email is entered
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mailEditText.getText().toString()).matches())
                {
                    Toast.makeText(context,"Please enter a valid email.",Toast.LENGTH_LONG).show();
                    return;
                }
                //Create an object for PostDataTask AsyncTask
                PostDataTask postDataTask = new PostDataTask();

                //execute asynctask
                postDataTask.execute(URL,roomEditText.getText().toString(),
                        nameEditText.getText().toString(),
                        deptEditText.getText().toString(),
                        prog,
                        yearEditText.getText().toString(),
                        rollEditText.getText().toString(),
                        webmEditText.getText().toString(),
                        mailEditText.getText().toString(),
                        contEditText.getText().toString(),
                        addrEditText.getText().toString(),
                        emcoEditText.getText().toString(),
                        blood,
                        intrEditText.getText().toString());
            }
        });
    }

    //AsyncTask to send data as a http POST request
    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String room = contactData[1];
            String name = contactData[2];
            String dept = contactData[3];
            String prog = contactData[4];
            String year = contactData[5];
            String roll = contactData[6];
            String webm = contactData[7];
            String mail = contactData[8];
            String cont = contactData[9];
            String addr = contactData[10];
            String emcon = contactData[11];
            String blood = contactData[12];
            String inter = contactData[13];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = ROOM_KEY+"=" + URLEncoder.encode(room,"UTF-8") +
                        "&" + NAME_KEY + "=" + URLEncoder.encode(name,"UTF-8") +
                        "&" + DEPT_KEY + "=" + URLEncoder.encode(dept,"UTF-8") +
                        "&" + PROG_KEY + "=" + URLEncoder.encode(prog,"UTF-8") +
                        "&" + YEAR_KEY + "=" + URLEncoder.encode(year,"UTF-8") +
                        "&" + ROLL_KEY + "=" + URLEncoder.encode(roll,"UTF-8") +
                        "&" + WBML_KEY + "=" + URLEncoder.encode(webm,"UTF-8") +
                        "&" + ALTEMAIL_KEY + "=" + URLEncoder.encode(mail,"UTF-8") +
                        "&" + CONTCT_KEY + "=" + URLEncoder.encode(cont,"UTF-8") +
                        "&" + ADDR_KEY + "=" + URLEncoder.encode(addr,"UTF-8") +
                        "&" + EMCON_KEY + "=" + URLEncoder.encode(emcon,"UTF-8") +
                        "&" + BLOOD_KEY + "=" + URLEncoder.encode(blood,"UTF-8") +
                        "&" + INTRST_KEY + "=" + URLEncoder.encode(inter,"UTF-8");
                //Toast.makeText(context,postBody,Toast.LENGTH_LONG).show();
            } catch (UnsupportedEncodingException ex) {
                result=false;
            }

            /*
            //If you want to use HttpRequest class from http://stackoverflow.com/a/2253280/1261816
            try {
			HttpRequest httpRequest = new HttpRequest();
			httpRequest.sendPost(url, postBody);
		}catch (Exception exception){
			result = false;
		}
            */

            try{
                //Create OkHttpClient for sending request
                OkHttpClient client = new OkHttpClient();
                //Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                //Send the request
                Response response = client.newCall(request).execute();
            }catch (IOException exception){
                result=false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
            //Print Success or failure message accordingly
            Toast.makeText(context,result?"Message successfully sent!":"There was some error in sending message. Please try again after some time.",Toast.LENGTH_LONG).show();
        }

    }
}

