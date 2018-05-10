
package com.curtesmalteser.kotlinkitsuexplorer.api.model_anime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeStaff {

    @SerializedName("links")
    @Expose
    private NavLinks links;

    public NavLinks getLinks() {
        return links;
    }

    public void setLinks(NavLinks links) {
        this.links = links;
    }

}
