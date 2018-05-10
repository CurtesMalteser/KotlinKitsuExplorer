package com.curtesmalteser.kotlinkitsuexplorer.api.model_genres;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelGenres {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("links")
    @Expose
    private NavLinks links;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public NavLinks getLinks() {
        return links;
    }

    public void setLinks(NavLinks links) {
        this.links = links;
    }

}
