
package com.rishabh.wikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("batchcomplete")
    @Expose
    public Boolean batchcomplete;
    @SerializedName("continue")
    @Expose
    public Continue _continue;
    @SerializedName("query")
    @Expose
    public Query query;

}
