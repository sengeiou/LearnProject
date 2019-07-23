package com.cocoa.shiji.bean.h5;

public class H5apiStackItem {
    public String sellCount;
    public Video[]  videos;

    static class Video{
      public String url;// "https://cloud.video.taobao.com/play/u/2604601918/p/2/e/6/t/1/50042100926.mp4?appKey=38829",
      public String type;// "2",
      public String videoThumbnailURL;// "https://img.alicdn.com/imgextra/i3/2604601918/TB2TUGBblTH8KJjy0FiXXcRsXXa_!!2604601918.jpg",
      public String spatialVideoDimension;// "16:9",
      public String videoId;// "50042100926"
    }
}
