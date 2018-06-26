
package com.rishabh.wikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("pageid")
    @Expose
    public Integer pageid;
    @SerializedName("ns")
    @Expose
    public Integer ns;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("index")
    @Expose
    public Integer index;
    @SerializedName("thumbnail")
    @Expose
    public Thumbnail thumbnail;
    @SerializedName("terms")
    @Expose
    public Terms terms;

}
