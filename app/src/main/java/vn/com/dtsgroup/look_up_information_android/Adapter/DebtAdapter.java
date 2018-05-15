package vn.com.dtsgroup.look_up_information_android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import vn.com.dtsgroup.look_up_information_android.Class.Debt;
import vn.com.dtsgroup.look_up_information_android.R;

/*******************************
 *                             *
 * Created by: VinhLD 20180515 *
 *                             *
 *******************************/

public class DebtAdapter extends ArrayAdapter<Debt>{
    public DebtAdapter(@NonNull Context context, int resource, @NonNull List<Debt> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_debt, null);
        }

        Debt debt = getItem(position);
        if(debt != null){

        }

        return view;
    }
}
