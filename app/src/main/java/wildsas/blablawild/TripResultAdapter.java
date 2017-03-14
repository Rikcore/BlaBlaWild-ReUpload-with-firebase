package wildsas.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




// Ici on lie le XML qui sert de modele à un item de la liste à l'adapter et à l'objet TripResultModel //

public class TripResultAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<TripResultModel> mItems;



    private Context mContext;
    public TripResultAdapter(Context mContext, ArrayList<TripResultModel> items) {
        this.mContext = mContext;
        this.mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.trip_item, parent, false); //ON DONNE LE NOM DU XML MODELE D'ITEM//
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description

        TextView textViewmFirstName = (TextView) convertView.findViewById(R.id.textViewFirstName);
        TextView textViewmDepartureTime = (TextView) convertView.findViewById(R.id.textViewDepartureTime);
        TextView textViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);


        textViewmFirstName.setText(currentItem.getFirstName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        textViewmDepartureTime.setText(sdf.format(currentItem.getDepartureTime()));
        String stringPrice = String.valueOf(currentItem.getPrice());
        textViewPrice.setText(stringPrice);
        // [...]

        // returns the view for the current row
        return convertView;
    }
}
