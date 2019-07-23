package com.cocoa.taobao.product_server.controller;


import com.cocoa.taobao.product_server.bean.mongo.ReportMongoResult;
import com.cocoa.taobao.product_server.bean.report.LogLevel;
import com.cocoa.taobao.product_server.bean.report.Reporter;
import com.cocoa.taobao.product_server.bean.resp.BaseResp;
import com.cocoa.taobao.product_server.impl.ItemDetailDaoImpl;
import com.cocoa.taobao.product_server.impl.MQProducerImpl;
import com.cocoa.taobao.product_server.util.TextUtil;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportDingController {


    @Autowired
    private BaseResp baseResp;

    public static final Gson mGson = new Gson();

    @Value("${server.port}")
    private String server_port;

    @Value("${sub.exp.report_msg}")
    private String reportTag;


    @Autowired
    public ItemDetailDaoImpl itemDetailService;

    @Autowired
    private MQProducerImpl mqProducer;



    //http://127.0.0.1:8898/product/report/add?msg=xxxxxxx&num_iid=132312312312&level=info
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    @ApiOperation(value = "xxx", notes = "")
    public BaseResp report(@RequestParam(value = "title", required = true, defaultValue = "title") String title,
                           @RequestParam(value = "msg", required = true) String msg,
                           @RequestParam(value = "level", required = true, defaultValue = "info") String level,
                           @RequestParam(value = "num_iid", required = true, defaultValue = "unknow") String num_iid
    ) {
        if (TextUtil.isEmpty(level) || TextUtil.isEmpty(msg)) {
            return baseResp.setError(100, "msg or level is null");
        }

        LogLevel logLevel = LogLevel.create(level);

        if (logLevel == null) {
            return baseResp.setError(100, "cant find this " + level);
        }

        Reporter reporter = new Reporter(logLevel, title, msg, num_iid);

        try {

            String json = mGson.toJson(reporter);

            System.out.println(json);

            SendResult sendResul = mqProducer.senMsg(json, reportTag);
            baseResp.setData(sendResul);
            return baseResp.setResultOK();

        } catch (InterruptedException e) {
            return baseResp.setError(100, e.getLocalizedMessage());
        } catch (RemotingException e) {
            return baseResp.setError(100, e.getLocalizedMessage());
        } catch (MQClientException e) {
            return baseResp.setError(100, e.getLocalizedMessage());
        } catch (MQBrokerException e) {
            return baseResp.setError(100, e.getLocalizedMessage());
        }

    }


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ApiOperation(value = "xxx", notes = "")
    public BaseResp reportPost(@RequestParam(value = "title", required = true, defaultValue = "title") String title,
                           @RequestParam(value = "msg", required = true) String msg,
                           @RequestParam(value = "level", required = true, defaultValue = "info") String level,
                           @RequestParam(value = "num_iid", required = true, defaultValue = "unknow") String num_iid
    ) {

        return  report(title,msg,level,num_iid);

    }



    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ApiOperation(value = "xxx", notes = "")
    public BaseResp getMsg(@RequestParam(value = "id", required = true) String id) {
        ReportMongoResult reportMongoResult = itemDetailService.find(id, ReportMongoResult.class, "reportMsg");
        return new BaseResp().setData(reportMongoResult).setResultOK();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getall")
    @ApiOperation(value = "xxx", notes = "")
    public BaseResp getAllMsg() {
        List<ReportMongoResult> reportMongoResult = itemDetailService.findAll(ReportMongoResult.class, "reportMsg");
        return new BaseResp().setData(reportMongoResult).setResultOK();
    }


}
