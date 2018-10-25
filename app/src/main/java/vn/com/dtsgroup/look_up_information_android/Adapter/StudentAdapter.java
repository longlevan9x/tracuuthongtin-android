package vn.com.dtsgroup.look_up_information_android.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vn.com.dtsgroup.look_up_information_android.Class.Student;
import vn.com.dtsgroup.look_up_information_android.Init.DataManager;
import vn.com.dtsgroup.look_up_information_android.Init.VLDxxxModule;
import vn.com.dtsgroup.look_up_information_android.R;

public class StudentAdapter extends ArrayAdapter<StudentAdapter.VStudent> {
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<VStudent> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_search, parent);
        }

        VStudent student = getItem(position);
        if (student != null) {
            ((TextView) view.findViewById(R.id.txt_search_rank)).setText(student.getRank());
            ((TextView) view.findViewById(R.id.txt_search_name_id)).setText(VLDxxxModule.ProperNoun(student.getName())
                    + " - " + String.valueOf(student.getId()));
            ((TextView) view.findViewById(R.id.txt_search_info))
                    .setText(student.get_class() + "\n" + (new DataManager(getContext())).FacultyName(student.getId_department()));
        }

        return view;
    }

    public static class VStudent extends Student {
        private int rank;

        public VStudent(int rank, int id, String code, String name, String _class, int id_department, String branch_group, String branch, String status, String day_admission, String school_year, int course, String education_level, String gender, String type_education, int area, String department, String average_cumulative, int total_term, String created_at, String updated_at) {
            super(id, code, name, _class, id_department, branch_group, branch, status, day_admission, school_year, course, education_level, gender, type_education, area, department, average_cumulative, total_term, created_at, updated_at);
            this.rank = rank;
        }

        public VStudent(int rank, Cursor cursor) {
            super(cursor);
            this.rank = rank;
        }

        public String getRank() {
            return String.valueOf(rank);
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
