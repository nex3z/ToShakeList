package com.nex3z.toshakelist.data.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class ScheduleContract {
    public static final String CONTENT_AUTHORITY = "com.nex3z.toshakelist";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_SCHEDULE = "schedule";

    public static final class ScheduleEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SCHEDULE).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHEDULE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHEDULE;

        public static final String TABLE_NAME = "schedule";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DETAIL = "detail";
        public static final String COLUMN_TYPE = "type";

        public static final String COLUMN_DATE_FROM = "date_from";
        public static final String COLUMN_DATE_TO = "date_to";
        public static final String COLUMN_REPEAT_SCHEDULE = "repeat_schedule";

        public static final String COLUMN_ALARM_TIME = "alarm_time";
        public static final String COLUMN_REPEAT_ALARM_TIMES = "repeat_alarm_times";
        public static final String COLUMN_REPEAT_ALARM_INTERVAL = "repeat_alarm_interval";

        public static Uri buildScheduleUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static int getScheduleIdFromUri(Uri uri) {
            return Integer.parseInt(uri.getPathSegments().get(1));
        }
    }

}
