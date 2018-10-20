
package com.app.varuna.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("terms")
    @Expose
    private Terms terms;
    @SerializedName("contentmodel")
    @Expose
    private String contentmodel;
    @SerializedName("pagelanguage")
    @Expose
    private String pagelanguage;
    @SerializedName("pagelanguagehtmlcode")
    @Expose
    private String pagelanguagehtmlcode;
    @SerializedName("pagelanguagedir")
    @Expose
    private String pagelanguagedir;
    @SerializedName("touched")
    @Expose
    private String touched;
    @SerializedName("lastrevid")
    @Expose
    private Integer lastrevid;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("fullurl")
    @Expose
    private String fullurl;
    @SerializedName("editurl")
    @Expose
    private String editurl;
    @SerializedName("canonicalurl")
    @Expose
    private String canonicalurl;

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public String getContentmodel() {
        return contentmodel;
    }

    public void setContentmodel(String contentmodel) {
        this.contentmodel = contentmodel;
    }

    public String getPagelanguage() {
        return pagelanguage;
    }

    public void setPagelanguage(String pagelanguage) {
        this.pagelanguage = pagelanguage;
    }

    public String getPagelanguagehtmlcode() {
        return pagelanguagehtmlcode;
    }

    public void setPagelanguagehtmlcode(String pagelanguagehtmlcode) {
        this.pagelanguagehtmlcode = pagelanguagehtmlcode;
    }

    public String getPagelanguagedir() {
        return pagelanguagedir;
    }

    public void setPagelanguagedir(String pagelanguagedir) {
        this.pagelanguagedir = pagelanguagedir;
    }

    public String getTouched() {
        return touched;
    }

    public void setTouched(String touched) {
        this.touched = touched;
    }

    public Integer getLastrevid() {
        return lastrevid;
    }

    public void setLastrevid(Integer lastrevid) {
        this.lastrevid = lastrevid;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getFullurl() {
        return fullurl;
    }

    public void setFullurl(String fullurl) {
        this.fullurl = fullurl;
    }

    public String getEditurl() {
        return editurl;
    }

    public void setEditurl(String editurl) {
        this.editurl = editurl;
    }

    public String getCanonicalurl() {
        return canonicalurl;
    }

    public void setCanonicalurl(String canonicalurl) {
        this.canonicalurl = canonicalurl;
    }

}
