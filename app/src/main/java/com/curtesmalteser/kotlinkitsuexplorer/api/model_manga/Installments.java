
package com.curtesmalteser.kotlinkitsuexplorer.api.model_manga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Installments {

    @SerializedName("links")
    @Expose
    private Links links;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
