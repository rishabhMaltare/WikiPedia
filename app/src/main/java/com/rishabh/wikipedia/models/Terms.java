
package com.rishabh.wikipedia.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Terms {

    @SerializedName("description")
    @Expose
    public List<String> description = null;

}
