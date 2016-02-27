package com.nex3z.toshakelist.data.provider;


import android.net.Uri;
import android.test.AndroidTestCase;

public class TestContract extends AndroidTestCase {
    public static final String LOG_TAG = TestContract.class.getSimpleName();

    private static final long TEST_SCHEDULE_ID = 9527L;

    public void testBuildScheduleUri() {
        Uri uri = ScheduleContract.ScheduleEntry.buildScheduleUri(TEST_SCHEDULE_ID);

        assertNotNull("Error: Null URI returned.", uri);

        assertEquals("Error: Schedule ID not properly appended to the end of the Uri.",
                String.valueOf(TEST_SCHEDULE_ID), uri.getLastPathSegment());

        assertEquals("Error: Weather location Uri doesn't match our expected result",
                uri.toString(),
                "content://com.nex3z.toshakelist/" +
                        ScheduleContract.PATH_SCHEDULE + "/" + TEST_SCHEDULE_ID);
    }
}
