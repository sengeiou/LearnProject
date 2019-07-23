package com.cocoa.shiji.worker;

import com.cocoa.shiji.bean.rmd.RmdDetail;
import com.cocoa.shiji.bean.rmd.RmdDetailContent;
import com.cocoa.shiji.bean.rmd.RmdList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RmdMaker  extends  Thread{

    @Override
    public void run() {
        super.run();

        List<RmdDetail> detailList = new ArrayList<>();

        //t1
        RmdDetail d1 = new RmdDetail("王小二 越南进口玉芒新鲜水果批发包邮应季特产芒果青芒时令生鲜","189.31","559218652404","http://img.alicdn.com/imgextra/i4/2939922051/TB2bEDOnN6I8KJjSszfXXaZVXXa_!!2939922051.jpg");

        List<RmdDetailContent> rmdDetailContentList = new ArrayList<>();
        rmdDetailContentList.add(new RmdDetailContent("txt","推荐文案1"));
        rmdDetailContentList.add(new RmdDetailContent("txt","推荐文案2"));
        rmdDetailContentList.add(new RmdDetailContent("img","http://img.alicdn.com/imgextra/i4/2939922051/TB2bEDOnN6I8KJjSszfXXaZVXXa_!!2939922051.jpg"));

        d1.setContentList(rmdDetailContentList);
        detailList.add(d1);


        // t2
        d1 = new RmdDetail("王小二 越南进口玉芒新鲜水果批发包邮应季特产芒果青芒时令生鲜","12.3","559218652404","http://img.alicdn.com/imgextra/i4/2939922051/TB2bEDOnN6I8KJjSszfXXaZVXXa_!!2939922051.jpg");
        rmdDetailContentList = new ArrayList<>();
        rmdDetailContentList.add(new RmdDetailContent("txt","推荐文案1"));
        rmdDetailContentList.add(new RmdDetailContent("txt","推荐文案2"));
        rmdDetailContentList.add(new RmdDetailContent("img","http://img.alicdn.com/imgextra/i4/2939922051/TB2bEDOnN6I8KJjSszfXXaZVXXa_!!2939922051.jpg"));
        rmdDetailContentList.add(new RmdDetailContent("img","http://p3.pstatp.com/large/31dd000506cdf91a1314"));

        d1.setContentList(rmdDetailContentList);
        detailList.add(d1);



        RmdList rmdList  = new RmdList();
        rmdList.setDate(new Date());
        rmdList.setTitle("title");
        String[] bannerImg = {""};
        rmdList.setBannerImg(bannerImg);
        rmdList.setDetailList(detailList);
        rmdList.setDateLong(System.currentTimeMillis());

        System.out.println(new Gson().toJson(rmdList));

    }
}
