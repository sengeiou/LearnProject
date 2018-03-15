package com.cocoa.rmq_client.worker;


import com.cocoa.rmq_client.bean.client.BaseParams;
import com.cocoa.rmq_client.bean.client.BasicParams;
import com.cocoa.rmq_client.bean.ding.LinkType;
import com.cocoa.rmq_client.bean.ding.Reporter;
import com.cocoa.rmq_client.util.OkHttpUtil;
import com.google.gson.Gson;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BaseWorker extends Thread {

    public BasicParams basicParams;
    public BaseParams params;


    public void report(String msg) {
        try {

            LinkType type = new LinkType(msg, params.toString(), "", basicParams.getBaseUrl() + "/display?message=" + params.toString());
            Reporter reporter = new Reporter();
            reporter.setMsgtype("link");
            reporter.setLink(type);
            System.out.println(new Gson().toJson(reporter));
            OkHttpUtil.postRequest(basicParams.getDingUrl(), new Gson().toJson(reporter));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void report(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        report(sw.toString());
    }
}
