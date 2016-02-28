package com.nex3z.toshakelist.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nex3z.toshakelist.R;
import com.nex3z.toshakelist.ui.fragment.ScheduleListFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private static final String LOG_TAG = ScheduleAdapter.class.getSimpleName();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("E MMM d, yyyy");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("kk:mm");

    private static OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position, ScheduleAdapter.ViewHolder vh);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    private Cursor mCursor;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_schedule, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        String title = mCursor.getString(ScheduleListFragment.COL_SCHEDULE_TITLE);
        Date start = new Date(mCursor.getInt(ScheduleListFragment.COL_SCHEDULE_DATE_START));
        Date end = new Date(mCursor.getInt(ScheduleListFragment.COL_SCHEDULE_DATE_END));

        Log.v(LOG_TAG, "onBindViewHolder(): position = " + position + ", start = " + start +
                ", end = " + end);

        holder.tvScheduleTitle.setText(title);
        String startTime = TIME_FORMAT.format(start);
        String endTime = TIME_FORMAT.format(start);
        Log.v(LOG_TAG, "onBindViewHolder(): startTime = " + startTime + ", endTime = " + endTime);

        holder.tvScheduleStartTime.setText(startTime);
        holder.tvScheduleEndTime.setText(endTime);
    }

    @Override
    public int getItemCount() {
        int count = mCursor == null ? 0: mCursor.getCount();
        Log.v(LOG_TAG, "onBindViewHolder(): count = " + count);
        return count;
    }

    public void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }

    public Cursor getCursor() {
        return mCursor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.tv_schedule_title) public TextView tvScheduleTitle;
        @Bind(R.id.tv_schedule_start_time) public TextView tvScheduleStartTime;
        @Bind(R.id.tv_schedule_end_time) public TextView tvScheduleEndTime;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
