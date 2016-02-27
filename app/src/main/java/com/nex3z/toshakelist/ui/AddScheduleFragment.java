package com.nex3z.toshakelist.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nex3z.toshakelist.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddScheduleFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    private static final String LOG_TAG = AddScheduleFragment.class.getSimpleName();

    @Bind(R.id.btn_schedule_start)
    Button btnScheduleStart;

    public AddScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_fragment, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        // NOTE: monthOfYear starts from 0
        Log.v(LOG_TAG, "onDateSet(): year = " + year + ", monthOfYear = " + monthOfYear +
                ", dayOfMonth = " + dayOfMonth);
    }

    @OnClick(R.id.btn_schedule_start)
    public void pickStartDate(View view) {
        Log.v("123", "123");
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");

    }
}
