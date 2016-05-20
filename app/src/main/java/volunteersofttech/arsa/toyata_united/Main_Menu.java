package volunteersofttech.arsa.toyata_united;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class Main_Menu extends AppCompatActivity {

    //ประกาศตัวแปร
    private TextView useridTextView,usernameTextView, branchTextView;
    private String useridString, usernameString;

    private ListView menuListView;

    private String[] resultStrings, titleStrings, detailStrings;
    private int[] iconInts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        resultStrings = getIntent().getStringArrayExtra("Result");

        //bind widget
        bindwidget();

        //show View
        showview();

        //listview controller
        listviewcontroller();  //Error อยู่


    }//main on create

    private void listviewcontroller() {

        if (resultStrings[4].equals("ME001")) {
            //ME001
            iconInts = new int[2];
            iconInts[0] = R.drawable.build1;
            iconInts[1] = R.drawable.build2;

            titleStrings = getResources().getStringArray(R.array.title_me001);
            detailStrings = getResources().getStringArray(R.array.detail_me001);

        } else if (resultStrings[4].equals("ME002")) {
            //ME002
            iconInts = new int[1];
            iconInts[0] = R.drawable.build1;

            titleStrings = getResources().getStringArray(R.array.title_me002);
            detailStrings = getResources().getStringArray(R.array.detail_me002);

        } // if

        menu_adapter menu_adapter = new menu_adapter(Main_Menu.this,
                iconInts, titleStrings, detailStrings);
        menuListView.setAdapter(menu_adapter);

    }   // ListView


    private void showview() {

        useridTextView.setText(resultStrings[0]);
        usernameTextView.setText(resultStrings[1]);
        branchTextView.setText(resultStrings[3]);


    }   // showView

    private void bindwidget() {
        useridTextView = (TextView) findViewById(R.id.textView2);
        usernameTextView = (TextView) findViewById(R.id.textView4);
        menuListView = (ListView) findViewById(R.id.listView);
        branchTextView = (TextView) findViewById(R.id.textView10);


    }//bindwidget

}//main class
