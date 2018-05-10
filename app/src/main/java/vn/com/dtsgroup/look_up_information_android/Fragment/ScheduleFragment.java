package vn.com.dtsgroup.look_up_information_android.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.dtsgroup.look_up_information_android.R;

/*******************************
 *                             *
 * Created by: VinhLD 20180510 *
 *                             *
 *******************************/

public class ScheduleFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        return view;
    }
}
