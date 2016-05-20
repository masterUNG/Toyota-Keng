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

    private String[] resultStrings;



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
        //listviewcontroller();  //Error อยู่


    }//main on create

//    private void listviewcontroller() {
//        final int[] iconInts = new int[3];
//        iconInts[0] = R.drawable.menu1;
//        iconInts[1] = R.drawable.menu2;
//        iconInts[3] = R.drawable.menu2;
//        final String[] titleStrings = new String[3];
//        titleStrings[0] = "menu1";
//        titleStrings[1] = "menu2";
//        titleStrings[2] = "menu3";
//        final String[] detailStrings = new String[3];
//        titleStrings[0] = "menu1";
//        titleStrings[1] = "menu2";
//        titleStrings[2] = "menu3";
//
//        menu_adapter valmenu_adapter = new menu_adapter(Main_Menu.this, iconInts, titleStrings, detailStrings);
//        menuListView.setAdapter(valmenu_adapter);
//
//        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //สำหรับเรียก form ต่อ
//                //Intent intent = new Intent(Main_Menu.this,)
//            }
//        });
//
//    }//listviewcontroller

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
