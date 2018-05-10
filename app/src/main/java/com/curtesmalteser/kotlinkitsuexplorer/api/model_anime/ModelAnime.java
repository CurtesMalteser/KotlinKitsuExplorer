
package com.curtesmalteser.kotlinkitsuexplorer.api.model_anime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelAnime {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("links")
    @Expose
    private Links links;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
