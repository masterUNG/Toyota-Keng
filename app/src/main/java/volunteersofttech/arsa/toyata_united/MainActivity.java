package volunteersofttech.arsa.toyata_united;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userEdittext, passwordEdittext;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind widget
        bindwidget();




    }//main onCreate

    public void clickLogin(View view) {

        userString = userEdittext.getText().toString().trim();
        passwordString = passwordEdittext.getText().toString().trim();

        //Check มีการใส่ข้อมูลว่างหรือไม่
        if (userString.equals("") || passwordString.equals("")) {
            myAlert("กรุณาป้อนข้อมูล User id และ Password");
        } else {
            checkUser();
        }


    }

    private void checkUser() {

        Intent intent = new Intent(MainActivity.this, Main_Menu.class);
        intent.putExtra("user_id", userEdittext.getText().toString().trim());
        startActivity(intent);
        finish();
    }

    private void myAlert(String strMessage) {
        Toast.makeText(MainActivity.this,strMessage,Toast.LENGTH_SHORT).show();
    }

    private void bindwidget() {

        userEdittext = (EditText) findViewById(R.id.editText);
        passwordEdittext = (EditText) findViewById(R.id.editText2);



    }//bindwidget


    //.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    //    @Override
    //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

     //       Intent intent = new Intent(MainActivity.this, DetailActivity.class);

    //     intent.putExtra("title", titleStrings);
     //       intent.putExtra("image", iconInts);
     //       intent.putExtra("Index", position);


      //      startActivity(intent);


}//main class
