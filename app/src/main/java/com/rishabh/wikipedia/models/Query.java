
package com.rishabh.wikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Query {

    @SerializedName("pages")
    @Expose
    public List<Page> pages = null;

}
