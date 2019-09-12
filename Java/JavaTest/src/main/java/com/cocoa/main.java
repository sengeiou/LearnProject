package com.cocoa;



public class main {

    public static void main(String[] args) {
        try {
//            new main().test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 砂夹石的
        System.out.println("can find any more!");

        TestParent  parent = new TestParent();
        parent.setAge(12);
        parent.setName("parent");
        TestChild child = new TestChild();
        child.setAddr("address");
        parent.setChild(child);

        System.out.println(parent.getName());

        try {
            TestParent parent1 = (TestParent) parent.clone();
            parent1.setChild(null);
            parent1.setName(null);

            System.out.println(parent.getChild().toString());
            System.out.println(parent.getName().toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }


//    public void test() throws Exception{
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        String url = "https://api.netease.im/nimserver/user/refreshToken.action";
//        HttpPost httpPost = new HttpPost(url);
//
//        String appKey = "dd87cd68fa15d7499e98ea7f0d2c061b";
//        String appSecret = "10d14d4d6a2a";
//        String nonce =  "12345";
//        String curTime = String.valueOf((new Date()).getTime() / 1000L);
//        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);
//
//        httpPost.addHeader("AppKey", appKey);
//        httpPost.addHeader("Nonce", nonce);
//        httpPost.addHeader("CurTime", curTime);
//        httpPost.addHeader("CheckSum", checkSum);
//        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("accid", "testqccr2"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
//
//        HttpResponse response = httpClient.execute(httpPost);
//
//        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
//    }

}
