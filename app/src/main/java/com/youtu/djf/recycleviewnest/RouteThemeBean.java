package com.youtu.djf.recycleviewnest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by djf on 2017/2/23.
 */

public class RouteThemeBean implements Serializable {
    @Override
    public String toString() {
        return "{" +
                "pageHeader:'" + pageHeader + '\'' +
                ", pageEnglishHeader:'" + pageEnglishHeader + '\'' +
                ", pageContent:" + pageContent.toString() +
                '}';
    }

    /**
     * pageHeader : 欧洲风情
     * pageEnglishHeader : ouzhoufengqing
     * pageContent : [{"branchId":"3001","lineTitle":"瑞士小镇","englishName":"Town-Swizerland","imageUrl":"http://115.29.198.179:8081/km1930/resources/box/1487761190169_1001.png","desjson":"http://115.29.198.179:8081/km1930/resources/box/3001.json","model":1,"allFileZipUrl":"http://115.29.198.179:8081/km1930/resources/box/3001.zip","zipMd5":"e16213796f9d2b38ca31c7e863999ccc","newestApkVersion":1},{"branchId":"3002","lineTitle":"测试子线路2","englishName":"dd2","imageUrl":"http://115.29.198.179:8081/files/1487663694048_1001.PNG","desjson":"http://115.29.198.179:8081/files/1487663689977_1001.png","model":1,"allFileZipUrl":"http://115.29.198.179:8081/files/3002.zip","zipMd5":"7b1fcdfd4ab738e94785a72a7f768f81","newestApkVersion":1}]
     */

    private String pageHeader;
    private String pageEnglishHeader;
    private List<RouteBean> pageContent;

    public String getPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader;
    }

    public String getPageEnglishHeader() {
        return pageEnglishHeader;
    }

    public void setPageEnglishHeader(String pageEnglishHeader) {
        this.pageEnglishHeader = pageEnglishHeader;
    }

    public List<RouteBean> getPageContent() {
        return pageContent;
    }

    public void setPageContent(List<RouteBean> pageContent) {
        this.pageContent = pageContent;
    }

}
