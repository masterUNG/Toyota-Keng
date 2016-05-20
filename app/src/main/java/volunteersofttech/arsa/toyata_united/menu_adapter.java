package volunteersofttech.arsa.toyata_united;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import volunteersofttech.arsa.toyata_united.R;

/**
 * Created by ACER on 3/21/2016.
 */
public class menu_adapter extends BaseAdapter {
    //ประกาศตัวแปร
    private Context context;
    private int[] iconInts;
    private String[] titlesStrings, detailStrings;


    public menu_adapter(Context context, int[] iconInts, String[] titlesStrings, String[] detailStrings) {
        this.context = context;
        this.iconInts = iconInts;
        this.titlesStrings = titlesStrings;
        this.detailStrings = detailStrings;
    }//construtor


    @Override
    public int getCount() {
        return titlesStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, parent, false);

        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView2);
        iconImageView.setImageResource(iconInts[position]);
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView5);
        titleTextView.setText(titlesStrings[position]);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView6);
        detailTextView.setText(detailStrings[position]);

        return view1;
    }
}//main class
