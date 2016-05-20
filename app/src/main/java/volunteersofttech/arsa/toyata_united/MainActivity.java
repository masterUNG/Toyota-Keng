package volunteersofttech.arsa.toyata_united;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText userEdittext, passwordEdittext;
    private String userString, passwordString;
    private boolean result;
    private String messageString;
    private String[] resultStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind widget
        bindwidget();


    }//main onCreate

    //Inner Class
    public class MySynchornizeUser extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            try {


            } catch (Exception e) {
                return null;
            }
            return null;
        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("20MayV1", "JSON ==> " + s);


        }   // onPost

    }   // MySyn Class


    public void clickLogin(View view) {

        userString = userEdittext.getText().toString().trim();
        passwordString = passwordEdittext.getText().toString().trim();

        //Check มีการใส่ข้อมูลว่างหรือไม่
        if (userString.equals("") || passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "โปรดกรอกให้ครบ", "โปรดกรอกให้ครบทุกช่อง คะ");

        } else {
            checkUser();
        }


    }

    private void checkUser() {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("user_id", userString)
                .add("password", passwordString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(MySetup.urlJSON).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                String strJSON = response.body().string();
                Log.d("20MayV1", "response ==> " + strJSON);

                try {

                    JSONObject jsonObject = new JSONObject(strJSON);
                    result = jsonObject.getBoolean("result");
                    messageString = jsonObject.getString("message");

                    Log.d("20MayV1", "result ==> " + result);

                    try {

                        resultStrings = new String[5];
                        resultStrings[0] = jsonObject.getString("userid");
                        resultStrings[1] = jsonObject.getString("Username");
                        resultStrings[2] = jsonObject.getString("Login_company");
                        resultStrings[3] = jsonObject.getString("companyname");
                        resultStrings[4] = jsonObject.getString("menu_no");

                    } catch (Exception e) {
                        Log.d("20MayV2", "Error จาก Authen False ==> " + e.toString());
                    }

                    checkResult(result, messageString);

                } catch (Exception e) {
                    Log.d("20MayV1", "my Error ==> " + e.toString());
                }   // try


            }

            private void checkResult(boolean result, final String messageString) {
                if (result) {
                    //Authen Pass
                    for (int i=0;i<5;i++) {
                        Log.d("20MayV2", "result " + i + " = " + resultStrings[i]);
                    }

                    Intent intent = new Intent(MainActivity.this, Main_Menu.class);
                    intent.putExtra("Result", resultStrings);
                    startActivity(intent);
                    finish();

                } else {
                    //Authen False
                    Log.d("20MayV1", "Authen False");

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            //Toast.makeText(MainActivity.this, "Authentication False", Toast.LENGTH_SHORT).show();

                            MyAlert myAlert = new MyAlert();
                            myAlert.myDialog(MainActivity.this, "Authen False",
                                    messageString);

                        }
                    });

                }
            }
        });


//        Intent intent = new Intent(MainActivity.this, Main_Menu.class);
//        intent.putExtra("user_id", userEdittext.getText().toString().trim());
//        startActivity(intent);
//        finish();
    }


    private void myAlert(final String strMessage) {

        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, strMessage, Toast.LENGTH_SHORT).show();
            }
        };
        handler.post(runnable);

    }

    private void bindwidget() {

        userEdittext = (EditText) findViewById(R.id.editText);
        passwordEdittext = (EditText) findViewById(R.id.editText2);


    }//bindwidget


}//main class
