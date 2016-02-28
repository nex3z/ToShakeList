package com.nex3z.toshakelist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.nex3z.toshakelist.R;
import com.nex3z.toshakelist.ui.fragment.ScheduleDetailFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ScheduleDetailActivity extends AppCompatActivity {
    private static final String LOG_TAG = ScheduleDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            Log.v(LOG_TAG, "onCreate(): intent = " + getIntent().getData());
            arguments.putParcelable(ScheduleDetailFragment.DETAIL_URI, getIntent().getData());

            ScheduleDetailFragment fragment = new ScheduleDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.schedule_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, ScheduleListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void editSchedule(View view) {
        Log.v(LOG_TAG, "editSchedule()");
    }
}
