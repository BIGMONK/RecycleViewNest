package com.youtu.djf.recycleviewnest;

import java.io.Serializable;

/**
 * Created by djf on 2017/2/23.
 */

public class RouteBean implements Serializable {
    @Override
    public String toString() {
        return "{" +
                "branchId:'" + branchId + '\'' +
                ", lineTitle:'" + lineTitle + '\'' +
                ", englishName:'" + englishName + '\'' +
                ", imageUrl:'" + imageUrl + '\'' +
                ", desjson:'" + desjson + '\'' +
                ", model:" + model +
                ", allFileZipUrl:'" + allFileZipUrl + '\'' +
                ", zipMd5:'" + zipMd5 + '\'' +
                ", zipSize:'" + zipSize + '\'' +
                ", newestApkVersion:" + newestApkVersion +
                '}';
    }

    public boolean isLocalAvailable() {
        return isLocalAvailable;
    }

    public void setLocalAvailable(boolean localAvailable) {
        isLocalAvailable = localAvailable;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public float getHeated() {
        return heated;
    }

    public void setHeated(float hotRank) {
        this.heated = hotRank;
    }

    /**
     * branchId : 3001
     * lineTitle : 瑞士小镇
     * englishName : Town-Swizerland
     * imageUrl : http://115.29.198.179:8081/km1930/resources/box/1487761190169_1001.png
     * desjson : http://115.29.198.179:8081/km1930/resources/box/3001.json
     * model : 1
     * allFileZipUrl : http://115.29.198.179:8081/km1930/resources/box/3001.zip
     * zipMd5 : e16213796f9d2b38ca31c7e863999ccc
     * newestApkVersion : 1
     */

    private boolean isPressed;
    private float heated;
    private boolean isLocalAvailable;
    private String branchId;
    private String lineTitle;
    private String englishName;
    private String imageUrl;
    private String desjson;
    private int model;
    private String allFileZipUrl;
    private String zipMd5;
    private double zipSize;
    private int newestApkVersion;

    public double getZipSize() {
        return zipSize;
    }

    public void setZipSize(double zipSize) {
        this.zipSize = zipSize;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getLineTitle() {
        return lineTitle;
    }

    public void setLineTitle(String lineTitle) {
        this.lineTitle = lineTitle;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesjson() {
        return desjson;
    }

    public void setDesjson(String desjson) {
        this.desjson =desjson ;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getAllFileZipUrl() {
        return allFileZipUrl;
    }

    public void setAllFileZipUrl(String allFileZipUrl) {
        this.allFileZipUrl = allFileZipUrl;
    }

    public String getZipMd5() {
        return zipMd5;
    }

    public void setZipMd5(String zipMd5) {
        this.zipMd5 = zipMd5;
    }

    public int getNewestApkVersion() {
        return newestApkVersion;
    }

    public void setNewestApkVersion(int newestApkVersion) {
        this.newestApkVersion = newestApkVersion;
    }


}
