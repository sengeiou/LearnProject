// 百川电商sdk
http://baichuan.taobao.com/product/esdk.htm?spm=a3c0d.7662652.1998907869.3.m4xLQG


    String pid = "mm_44823234_0_0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showItemDetailPage(view);

                openTaobao();
            }
        });


    }

    private void openTaobao() {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        String packageName = "com.taobao.taobao";
        String className = "com.taobao.tao.detail.activity.DetailActivity";
        intent.setClassName(packageName, className);

        //second method
//  intent.setComponent(new ComponentName(
//    "com.lazytech.projecta",
//    "com.lazytech.projecta.MainActivity"
//  ));
        Bundle bundle = new Bundle();
        bundle.putString("item_id", "546521914947");
        intent.putExtras(bundle);

        intent.putExtra("pid", android.os.Process.myPid());

        startActivityForResult(intent, 1);
        startActivity(intent);
    }


    public void showItemDetailPage(View view) {
//        TradeService tradeService = AlibabaSDK.getService(TradeService.class);
////ItemDetailPage(String itemId,  Map<String, String> exParams)
////itemId  商品id.支持标准的商品id，eg.37196464781；同时支持openItemId，eg.AAHd5d-HAAeGwJedwSnHktBI；必填，不允许为null；
////exParams 特殊业务扩展字段；选填，允许为null；目前支持3个参数：
////    1、TradeConstants.ITEM_DETAIL_VIEW_TYPE：启动页面类型，分为TAOBAO_H5_VIEW(以淘宝H5方式打开详情页)、TAOBAO_NATIVE_VIEW(唤起手机淘宝客户端打开详情页)。
////  2、TradeConstants.ISV_CODE(ISV_CODE用法可参看：http://baichuan.taobao.com/doc2/detail.htm?treeId=30&articleId=102596&docType=1)
////  3、TradeConstants. TAOBAO_BACK_URL:设置启动手淘native页面后的返回页面
//
//        ItemDetailPage itemDetailPage = new ItemDetailPage("xxxxxx_xx", null);
//
//        TaokeParams taokeParams = new TaokeParams(); //若非淘客taokeParams设置为null即可
//        taokeParams.pid = "xxxxxx_xxxx_xxx";
//        tradeService.show(itemDetailPage, taokeParams, MainActivity.this, null, new TradeProcessCallback(){
//
//            @Override
//            public void onFailure(int code, String msg) {
//                Toast.makeText(MainActivity.this, "失败 "+code+msg,
//                        Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onPaySuccess(TradeResult tradeResult) {
//                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT)
//                        .show();
//
//            }});
        //商品详情page   item_id
        AlibcDetailPage itemDetailPage = new AlibcDetailPage("546521914947");

        // 页面打开方式
        AlibcShowParams alibcShowParams = new AlibcShowParams(OpenType.Auto, true);


        AlibcTaokeParams taokeParams = new AlibcTaokeParams(pid, pid, pid); //若非淘客taokeParams设置为null即可

        //提供给三方传递配置参数
        Map<String, String> exParams = new HashMap<>();
//        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");
//        exParams.put(AlibcConstants.PAGE_TYPE, "appisvcode");


        //3.1方式
        AlibcTrade.show(this, itemDetailPage, alibcShowParams, taokeParams, null, new AlibcTradeCallback() {
            @Override
            public void onTradeSuccess(TradeResult tradeResult) {
                Log.e("----", "success---" + tradeResult.toString());
            }

            @Override
            public void onFailure(int code, String msg) {
                Log.e("----", "faile---" + msg.toString());
            }
        });


    }
}



com.taobao.taobao|com.taobao.taobao/com.taobao.tao.detail.activity.DetailActivity|316|215271386849431|111|1





    public static void main(String[] args) throws Exception {
//        正式环境	http://gw.api.taobao.com/router/rest	https://eco.taobao.com/router/rest
//        沙箱环境	http://gw.api.tbsandbox.com/router/rest	https://gw.api.tbsandbox.com/router/rest

        String url = "http://gw.api.taobao.com/router/rest";
        String appkey = "23222740";
        String secret = "36b68bc26780160e5d80a129666dcc7f";

        System.out.println(Long.toBinaryString(16));

        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("布丁");
//        req.setCat("21,23");
//        req.setItemloc("杭州");
//        req.setSort("tk_rate_des");
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);
        req.setPageNo(2L);
//        req.setPageSize(20L);
        TbkItemGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());