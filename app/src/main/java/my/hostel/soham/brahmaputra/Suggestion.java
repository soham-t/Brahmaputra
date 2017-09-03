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

public class Suggestion extends AppCompatActivity {
    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //URL derived from form URL
    public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLScZc_t4fqsZBGCyneQk3nblis9SzLCbQ_29mnu2xO4zfMXdUw/formResponse";
    //input element ids found from the live form page
    public static final String NAME_KEY="entry_422540080";
    public static final String ROOM_KEY="entry_1304052707";
    public static final String WBML_KEY="entry_958370745";
    public static final String SUGG_KEY="entry_1119663091";

    private Context context;
    private EditText roomEditText;
    private EditText nameEditText;
    private EditText webmEditText;
    private EditText suggEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        Intent intent=getIntent();
        //save the activity in a context variable to be used afterwards
        context =this;

        //Get references to UI elements in the layout
        Button submitButton = (Button)findViewById(R.id.submitButton1);
        roomEditText = (EditText)findViewById(R.id.roomEditText1);
        nameEditText = (EditText)findViewById(R.id.nameEditText1);
        webmEditText = (EditText)findViewById(R.id.webmEditText1);
        suggEditText = (EditText)findViewById(R.id.suggEditText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make sure all the fields are filled with values
                if(TextUtils.isEmpty(roomEditText.getText().toString()) ||
                        TextUtils.isEmpty(nameEditText.getText().toString()) ||
                        TextUtils.isEmpty(suggEditText.getText().toString()) ||
                        TextUtils.isEmpty(webmEditText.getText().toString()))
                {
                    Toast.makeText(context,"Fill Up the mandatory fields.",Toast.LENGTH_LONG).show();
                    return;
                }
                //Check if a valid email is entered

                //Create an object for PostDataTask AsyncTask
                PostDataTask postDataTask = new PostDataTask();

                //execute asynctask
                postDataTask.execute(URL,
                        nameEditText.getText().toString(),
                        roomEditText.getText().toString(),
                        webmEditText.getText().toString(),
                        suggEditText.getText().toString());
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
            String sugg = contactData[4];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = NAME_KEY+"=" + URLEncoder.encode(name,"UTF-8") +
                        "&" + ROOM_KEY + "=" + URLEncoder.encode(room,"UTF-8") +
                        "&" + WBML_KEY + "=" + URLEncoder.encode(webm,"UTF-8") +
                        "&" + SUGG_KEY + "=" + URLEncoder.encode(sugg,"UTF-8");
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
