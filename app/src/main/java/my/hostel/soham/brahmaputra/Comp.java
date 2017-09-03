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
 * Created by Soham on 7/18/2017.
 */

public class Comp extends AppCompatActivity {
    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //URL derived from form URL
    public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLSfpoM4mN3nXAPIAP77FU1SP_3hKCQtxDVGCUG4QqtGWAHdCbA/formResponse";
    //input element ids found from the live form page
    public static final String NAME_KEY="entry_185909119";
    public static final String ROOM_KEY="entry_2005506036";
    public static final String WBML_KEY="entry_653824513";
    public static final String TYPE_KEY="entry_696939301";
    public static final String CONT_KEY="entry_741031785";
    public static final String DETL_KEY="entry_1804509916";
    public static final String SOLN_KEY="entry_91232641";

    private Context context;
    private EditText roomEditText;
    private EditText nameEditText;
    private EditText detlEditText;
    private EditText webmEditText;
    private EditText solnEditText;
    private EditText contEditText;
    private String type;
    private RadioGroup type1;
    private RadioButton bull1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);
        Intent intent=getIntent();
        //save the activity in a context variable to be used afterwards
        context =this;

        //Get references to UI elements in the layout
        Button submitButton = (Button)findViewById(R.id.submitButton);
        roomEditText = (EditText)findViewById(R.id.roomEditText);
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        detlEditText = (EditText)findViewById(R.id.detlEditText);
        solnEditText = (EditText)findViewById(R.id.solnEditText);
        webmEditText = (EditText)findViewById(R.id.webmEditText);
        contEditText = (EditText)findViewById(R.id.contEditText) ;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = (RadioGroup) findViewById(R.id.type);
                int selectedId = type1.getCheckedRadioButtonId();
                bull1 = (RadioButton) findViewById(selectedId);
                type= bull1.getText().toString();
                //Make sure all the fields are filled with values
                if(TextUtils.isEmpty(roomEditText.getText().toString()) ||
                        TextUtils.isEmpty(nameEditText.getText().toString()) ||
                        TextUtils.isEmpty(detlEditText.getText().toString()) ||
                        TextUtils.isEmpty(webmEditText.getText().toString()) ||
                        TextUtils.isEmpty(contEditText.getText().toString()) ||
                        TextUtils.isEmpty(type))
                {
                    Toast.makeText(context,"Fill Up the mandatory fields.",Toast.LENGTH_LONG).show();
                    return;
                }
                //Check if a valid email is entered
                //Create an object for PostDataTask AsyncTask
                PostDataTask postDataTask = new PostDataTask();
                //execute asynctask
                postDataTask.execute(URL,nameEditText.getText().toString(),
                        roomEditText.getText().toString(),
                        webmEditText.getText().toString(),
                        contEditText.getText().toString(),
                        type,
                        detlEditText.getText().toString(),
                        solnEditText.getText().toString());
            }
        });
    }

    //AsyncTask to send data as a http POST request
    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String name = contactData[1];
            String room = contactData[2];
            String webm = contactData[3];
            String cont = contactData[4];
            String type = contactData[5];
            String detl = contactData[6];
            String soln = contactData[7];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = NAME_KEY+"=" + URLEncoder.encode(name,"UTF-8") +
                        "&" + ROOM_KEY + "=" + URLEncoder.encode(room,"UTF-8") +
                        "&" + WBML_KEY + "=" + URLEncoder.encode(webm,"UTF-8") +
                        "&" + CONT_KEY + "=" + URLEncoder.encode(cont,"UTF-8") +
                        "&" + TYPE_KEY + "=" + URLEncoder.encode(type,"UTF-8") +
                        "&" + DETL_KEY + "=" + URLEncoder.encode(detl,"UTF-8") +
                        "&" + SOLN_KEY + "=" + URLEncoder.encode(soln,"UTF-8");
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
