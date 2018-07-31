package com.marvelwall.ahmedpc.clinicalguidelines;

import android.content.Context;
import android.widget.ExpandableListView;

/**
 * Created by ahmedpc on 7/19/2016.
 */
public class CustExpListview extends ExpandableListView {

    public CustExpListview(Context context)
    {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(500000, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
