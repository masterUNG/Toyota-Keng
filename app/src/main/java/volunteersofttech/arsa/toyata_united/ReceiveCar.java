package volunteersofttech.arsa.toyata_united;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ReceiveCar extends AppCompatActivity {

    //Explicit
    private EditText receiveNoEditText, vinNoEditText, kaludaiEditText;
    private TextView dateTextView, latTextView, lngTextView;
    private DatePickerDialog datePickerDialog;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_car);

        bindWidget();

        //SetUp Date
        setupDate();

    }   // Main Method

    private void scanBar() {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            showDialog(ReceiveCar.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }   //scanBar



    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }   // showDwalog

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }   // onActivityResult





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

        scanBar();

    }

    public void clickBarcodeKaludi(View view) {
        Intent intent = new Intent(ReceiveCar.this, ReadBarCode.class);
        intent.putExtra("Barcode", "Kaludi");
        intent.putExtra("Result", getIntent().getStringArrayExtra("Result"));
        startActivity(intent);
        finish();

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
