package com.cocoa.test.io;

/**
 * get tiny img from network
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.kqc.user.utils.TinyNetImg.java
 * @author: shenjun@kuaiqiangche.com
 * @date: 2016-06-13 10:59
 */
public class TinyNetImg {

    private static final String DOMAIN_QINIU = "image.kuaiqiangche.com";
    private static final String DOMAIN_ALI = "img.kuaiqiangche.com";
    private static final String ALI_TEMP = "%s@%sw_%sh_%sq";
    private static final String QINIU_TEMP = "%s?imageView2/0/w/%s/h/%s/q/%s/ignore-error/1";


    private int width;
    private int height;
    private int quality;

    public TinyNetImg(int width, int height, int quality) {
        this.width = width;
        this.height = height;
        this.quality = quality;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    private TinyNetImg() {
    }

    /**
     * @param imgUrl origin imgUrl
     * @return simple like http://image-demo.img-cn-hangzhou.aliyuncs.com/example.jpg@100w_100h_80q
     */
    private String tinyAliImg(String imgUrl) {
        return String.format(ALI_TEMP, imgUrl, width, height, quality
        );
    }


    /**
     * @param imgUrl origin imgUrl
     * @return simple like http://image.kuaiqiangche.com/data/attachment/2016-04-25/o_1ah6ctds016njoet1nda1sgetc97.jpg?imageView2/0/w/100/h/100/q/90/ignore-error/1
     */
    private String tinyQiniuImg(String imgUrl) {
        return String.format(QINIU_TEMP, imgUrl, width, height, quality
        );
    }


    public String tiny(String imgUrl) {
        if (isEmpty(imgUrl)) {
            return "";
        }
        if (imgUrl.contains(DOMAIN_ALI)) {  //ali
            return tinyAliImg(imgUrl);
        } else if (imgUrl.contains(DOMAIN_QINIU)) { //qiniu
            return tinyQiniuImg(imgUrl);
        }
        return imgUrl;
    }

    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
