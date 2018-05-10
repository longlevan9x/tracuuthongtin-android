package vn.com.dtsgroup.look_up_information_android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import vn.com.dtsgroup.look_up_information_android.Class.Mark;
import vn.com.dtsgroup.look_up_information_android.R;

/*******************************
 *                             *
 * Created by: VinhLD 20180510 *
 *                             *
 *******************************/

public class MarkAdapter extends ArrayAdapter<Mark>{
    public MarkAdapter(@NonNull Context context, int resource, @NonNull List<Mark> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_mark, null);
        }

        Mark mark = getItem(position);
        if(mark != null){

        }

        return view;
    }
}
