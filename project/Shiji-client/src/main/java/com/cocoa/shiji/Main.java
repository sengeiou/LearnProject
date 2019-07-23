package com.cocoa.shiji;

import com.cocoa.shiji.db.MongoDb;
import com.cocoa.shiji.test.TaobaoRenqunThread;
import com.cocoa.shiji.worker.RmdMaker;
import com.cocoa.shiji.worker.consumer.*;
import com.cocoa.shiji.worker.product.*;
import com.mongodb.client.*;
import javafx.beans.property.SetProperty;
import org.bson.Document;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        try {

            new StatusProduct().start();
            new StatusConsumer().start();
            String token = "t=6ff43f5018585ad8f4fbd6549cc25d1d; account-path-guide-s1=true; 44823234_yxjh-filter-1=true; cna=BWqnEzefADoCAXPso3IWoiUb; cookie2=10f40535c417c226a837a7b502b9df1d; v=0; _tb_token_=553ab3ee1a88e; alimamapwag=TW96aWxsYS81LjAgKE1hY2ludG9zaDsgSW50ZWwgTWFjIE9TIFggMTBfMTNfNSkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzY3LjAuMzM5Ni45OSBTYWZhcmkvNTM3LjM2; cookie32=6261f7b1f4ec5d646b19a1f8c8c6b143; alimamapw=U15RDlIBUVEEOFRTAg1UUlYAAFMHVgoFBwMHUldRVQoAAlYGVgUDBVZV; cookie31=NDQ4MjMyMzQsY29jb2E2NTQzLGNvY29vb29vYUBnbWFpbC5jb20sVEI%3D; JSESSIONID=692D07AE569EBCCEE3AFEAADA8C1DA09; login=URm48syIIVrSKA%3D%3D; rurl=aHR0cHM6Ly9wdWIuYWxpbWFtYS5jb20vP3NwbT1hMjE5dC43OTAwMjIxLzI4LmEyMTR0cjguZDAwNi40NjEzNzVhNURESlZOUQ%3D%3D; isg=BOjoRmq9J8awLAsvLlnEtXcnudA6uVhki7A3XKIZNGNW_YhnSiEcq36b8dWoTQTz";

//            new TaobaoRenqunThread().start();
//            new RmdMaker().start();



//            new TaoCodeProduct(token).start();
//
            new ReportConsumer().start();
//
//            new RateListConsumer().start();
//            new TaoCodeConsumer().start();
//            new ContentImgConsumer().start();
//            new ItemDetailConsumer().start();

//            new RateListConsumer().start();
//            new RateListProduct().start();



//            new ContentImgConsumer().start();
//            new ContentImgProduct().start();


//            new TaoCodeConsumer().start();


//            new ItemDetailConsumer().start();
//            new ItemDetailProduct().start();


//            KeywordsConsumer keywordsConsumer = new KeywordsConsumer();
//            keywordsConsumer.setMaxRetryNum(1);
//            keywordsConsumer.start();


//            int i = 0 ;
//            while (true) {
//                System.out.println(i);
//                String num_iid = "556314662255";
//                String json = H5apiUtil.getH5Data(num_iid);
//                System.out.println(json);
//                Document document = Document.parse(json);
//                document.append("num_iid", num_iid);
//                document.append("date", System.currentTimeMillis());
//
//                collection.insertOne(document);
//                i++;
//                Thread.sleep(3000);
//            }

//            FindIterable<Document> findIterable = collection.find();
//            MongoCursor<Document> mongoCursor = findIterable.iterator();
//
//            while(mongoCursor.hasNext()){
//                Document document = mongoCursor.next();
////                System.out.println(document);
//                System.out.println(document.toJson());
//            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }


    }

}