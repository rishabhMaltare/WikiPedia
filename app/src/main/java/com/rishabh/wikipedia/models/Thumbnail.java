
package com.rishabh.wikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail {

    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;

}
