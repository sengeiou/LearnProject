package com.cocoa.shiji.worker;


import com.cocoa.shiji.bean.client.BaseParams;
import com.cocoa.shiji.bean.client.BasicParams;
import com.google.gson.Gson;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

public abstract class BaseWorker extends Thread {


    public final String TAG = getClass().getSimpleName();
    public final String FORMAT_TAG = getClass().getSimpleName() + "_%s";
    public SimpleDateFormat dateFormatWhitHyphen = new SimpleDateFormat("yyyy/MM/dd-");
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    public String NAME_SEV_ADDR = "116.196.79.208:9876";

    public BasicParams basicParams;
    public BaseParams params;

    public Gson mGson = null;

    protected String consumerGroup;
    protected String topic;
    protected String subExpression;

    public String serverUrl;

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubExpression() {
        return subExpression;
    }

    public void setSubExpression(String subExpression) {
        this.subExpression = subExpression;
    }


    public BaseWorker() {
        this.mGson = new Gson();
    }

//    public void report(String msg, Reporter.LogLevel logLevel) {
//        reporter.report(msg, logLevel, Reporter.Plat.CLIENT);
//    }

//    public void report(Exception e) {
//        StringWriter sw = new StringWriter();
//        e.printStackTrace(new PrintWriter(sw, true));
//        report(sw.toString(), Reporter.LogLevel.ERROR);
//    }


    public class ConsumerStatus {
        private ConsumeConcurrentlyStatus status;
        private String msg;
        private Object ext;
        private Exception e;



        public ConsumerStatus(ConsumeConcurrentlyStatus status, String msg, Object ext, Exception e) {
            this.status = status;
            this.msg = msg;
            this.ext = ext;
            this.e = e;
        }

        public ConsumerStatus(Exception e) {
            this.status = ConsumeConcurrentlyStatus.RECONSUME_LATER;
            this.e = e;
        }

        public ConsumerStatus(String msg) {
            this.status = ConsumeConcurrentlyStatus.RECONSUME_LATER;
            this.msg = msg;
        }


        public ConsumerStatus() {
            this.status = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        public ConsumeConcurrentlyStatus getStatus() {
            return status;
        }

        public void setStatus(ConsumeConcurrentlyStatus status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }


        public Exception getE() {
            return e;
        }

        public void setE(Exception e) {
            this.e = e;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getExt() {
            return ext;
        }

        public void setExt(Object ext) {
            this.ext = ext;
        }

    }


}
