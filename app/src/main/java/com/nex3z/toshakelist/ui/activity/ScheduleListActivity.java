package com.nex3z.toshakelist.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.nex3z.toshakelist.R;
import com.nex3z.toshakelist.ui.adapter.ScheduleAdapter;
import com.nex3z.toshakelist.ui.fragment.ScheduleDetailFragment;
import com.nex3z.toshakelist.ui.fragment.ScheduleListFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleListActivity extends AppCompatActivity
        implements ScheduleListFragment.Callbacks {
    private static final String LOG_TAG = ScheduleListActivity.class.getSimpleName();

    private static final String DETAIL_FRAGMENT_TAG = "detail_fragment";
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.schedule_detail_container) != null) {
            mTwoPane = true;
            Log.v(LOG_TAG, "onCreate(): mTwoPane = " + mTwoPane);
        }
    }

    @OnClick(R.id.fab)
    public void pickStartDate(View view) {
        Intent intent = new Intent(ScheduleListActivity.this, AddScheduleActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(Uri uri, ScheduleAdapter.ViewHolder vh) {
        Log.v(LOG_TAG, "onItemSelected(): uri = " + uri);

        if (mTwoPane) {
            Bundle args = new Bundle();
            args.putParcelable(ScheduleDetailFragment.DETAIL_URI, uri);

            ScheduleDetailFragment fragment = new ScheduleDetailFragment();
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.schedule_detail_container, fragment, DETAIL_FRAGMENT_TAG)
                    .commit();
        } else {
            Intent intent = new Intent(this, ScheduleDetailActivity.class);
            intent.setData(uri);
            startActivity(intent);
        }
    }
}
