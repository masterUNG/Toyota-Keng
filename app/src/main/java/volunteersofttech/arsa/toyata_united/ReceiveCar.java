package volunteersofttech.arsa.toyata_united;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class ReceiveCar extends AppCompatActivity {

    //Explicit
    private EditText receiveNoEditText, vinNoEditText, kaludaiEditText;
    private TextView dateTextView, latTextView, lngTextView;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_car);

        bindWidget();

        //SetUp Date
        setupDate();


    }   // Main Method

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

            String newDateSet = Integer.toString(day) + "/" +
                    Integer.toString(month + 1) + "/" +
                    Integer.toString(year);
            dateTextView.setText(newDateSet);

        }   // onDateSet
    };



    private void setupDate() {

        Calendar calendar = Calendar.getInstance();
        int intCurrentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int intCurrentMonth = calendar.get(Calendar.MONTH);
        int intCurrentYear = calendar.get(Calendar.YEAR);

        String strCurrentDate = Integer.toString(intCurrentDay) + "/" +
                Integer.toString(intCurrentMonth + 1) + "/" +
                Integer.toString(intCurrentYear);

        dateTextView.setText(strCurrentDate);

    }   // setupDate

    public void clickCalendar(View view) {

        Calendar calendar = Calendar.getInstance();
        int intCurrentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int intCurrentMonth = calendar.get(Calendar.MONTH);
        int intCurrentYear = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(this, onDateSetListener,
                intCurrentYear, intCurrentMonth, intCurrentDay);
        datePickerDialog.setTitle("โปรดเลือก Date");
        datePickerDialog.show();

    }   // clickCalendar

    public void clickBarcodeVin(View view) {

    }

    public void clickBarcodeKaludi(View view) {

    }

    public void clickMap(View view) {

    }

    public void clickReceiveCar(View view) {

    }

    public void clickCancelReceiveCar(View view) {
        finish();
    }

    private void bindWidget() {

        receiveNoEditText = (EditText) findViewById(R.id.editText4);
        vinNoEditText = (EditText) findViewById(R.id.editText7);
        kaludaiEditText = (EditText) findViewById(R.id.editText8);
        dateTextView = (TextView) findViewById(R.id.editText6);
        latTextView = (TextView) findViewById(R.id.textView16);
        lngTextView = (TextView) findViewById(R.id.textView17);

    }

}   // Main Class
