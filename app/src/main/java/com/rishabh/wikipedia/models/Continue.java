
package com.rishabh.wikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue {

    @SerializedName("gpsoffset")
    @Expose
    public Integer gpsoffset;
    @SerializedName("continue")
    @Expose
    public String _continue;

}
