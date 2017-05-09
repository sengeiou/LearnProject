package com.company;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Main extends  Thread{
    static  String o  = new String("a");

    public static void main(String[] args) throws Exception {


//        正式环境	http://gw.api.taobao.com/router/rest	https://eco.taobao.com/router/rest
//        沙箱环境	http://gw.api.tbsandbox.com/router/rest	https://gw.api.tbsandbox.com/router/rest

        String url ="http://gw.api.taobao.com/router/rest";
        String appkey ="23222740";
        String secret ="36b68bc26780160e5d80a129666dcc7f";



        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("食品");
        req.setCat("16,18");
//        req.setItemloc("杭州");
//        req.setSort("tk_rate_des");
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);
//        req.setPageNo(123L);
//        req.setPageSize(20L);
        TbkItemGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());



//            ServerSocketChannel channel  = ServerSocketChannel.open();
//            channel.bind(new InetSocketAddress(8899));
//            Selector selector = Selector.open();
//
//            channel.configureBlocking(false);
//            SelectionKey mSelectionKey  =  channel.register(selector, SelectionKey.OP_ACCEPT);
//
//            while (true) {
//                int readyChannels = selector.select();
//                if (readyChannels == 0) continue;
//                Set<SelectionKey> selectedKeys = selector.selectedKeys();
//                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
//                while (keyIterator.hasNext()) {
//                    SelectionKey key = keyIterator.next();
//                    if (key.isAcceptable()) {
//                        System.out.print("isAcceptable");
//                    } else if (key.isConnectable()) {
//                        System.out.print("isConnectable");
//                    } else if (key.isReadable()) {
//                        System.out.print("isReadable");
//                    } else if (key.isWritable()) {
//                        System.out.print("isWritable");
//                    }
//                    keyIterator.remove();
//                }
//            }
    }

    public synchronized  void lock() throws InterruptedException {
        while(isAlive()){
            wait(0);
        }
    }



    @Override
    public void run() {
        super.run();
        try {

            int i = 10;
            while( i > 5) {
                i--;
                System.out.println("===="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
