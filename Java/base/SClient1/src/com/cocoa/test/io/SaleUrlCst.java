package com.cocoa.test.io;

/**
 * Created by RainDrop
 * on 2016/4/21/17:44.
 */
public class SaleUrlCst {


    /**
     * 语音验证码
     */
    /**
     * 接口地址
     */

    public static final String API_URL = "http://api.sale.kuaiqiangche.com";
//    public static final String API_URL = "http://new_api.kuaiqiangche.cc";


    /**
     * 服务器地址
     */
    public static final String SERVER = "http://m.kuaiqiangche.com/";

    //比价
    public static final String BIJIA_URL = "http://m.bijia.kuaiqiangche.com/";

    //提车日记wap的url
    public static final String NEWS_URL = "http://m.kuaiqiangche.com/news";


    /**
     * 首页WAP页面地址
     */
    public static final String HOME_WAP_URL = SERVER;
    /**
     * 活动列表
     */
    public static final String HOME_WAP_ACTION_URL = SERVER + "topics/list";
    /**
     * 帮助
     */
    public static final String HOME_WAP_HELP_URL = SERVER + "/help";
    /**
     * 登陆
     */
    public static final String LOGIN = API_URL + "/user/login";
    /**
     * 退出登录
     */
    public static final String LOGIN_OUT = API_URL + "/user/logout";
    /**
     * 发送短信
     */
    public static final String SMS = API_URL + "/common/mobile_sms_send";
    /**
     * 语音验证码
     */
    public static final String VOICE = API_URL + "/common/mobile_voice_send";
    /**
     * 交易 我的订单
     */
    public static final String MY_ORDER = API_URL + "/order/my";
    /**
     * 获取用户信息
     */
    public static final String USER_INFO = API_URL + "/user/get_userinfo";
    /**
     * 改变订单状态
     */
    public static final String CHANGE_ORDER_STATE = API_URL + "/order/change_statu";
    /**
     * 订单详情
     */
    public static final String ORDER_DETAIL = API_URL + "/order/detail";
    /**
     * 支付
     */
    public static final String PAY = API_URL + "/pay/submit";
    /**
     * 创建订单
     */
    public static final String ORDER_CREATE = API_URL + "/order/create";

    /**
     * 上传身份证
     */
    public static final String ID_CARD_IMG = API_URL + "/app/fileUpload";

    //车辆品牌
    public static final String COMMON_CATEGORY = API_URL + "/car/category";
    //子品牌
    public static final String COMMON_CATEGORY_RES = API_URL + "/car/category_res";
    //热门关键字
    public static final String COMMON_HOT_KEYWORDS = API_URL + "/common/hot_keyword";
    //车辆搜索
    public static final String COMMON_SEARCH = API_URL + "/common/search";
    //车辆详情
    public static final String CAR_DETAIL = API_URL + "/app/productInfo";
    //车款计算器
    public static final String CAR_RATE = API_URL + "/common/rate_params";
    //贷款计算器
    public static final String CAR_LOAN = API_URL + "/loan/get_first_loan";
    //车辆的交易记录
    public static final String CAR_DEAL_RECORD = API_URL + "/app/dealRecord";
    //购车网点
    public static final String COMM_NETWORK = API_URL + "/common/network";
//提车日记

    public static final String COMMUNITY_LIST = API_URL + "/article/community_list";





    /**
     * 上传用户头像
     */
    public static final String USER_AVATAR = API_URL + "/user/upload_avatar_form";
    /**
     * 吐槽接口
     */
    public static final String FEEDBACK = API_URL + "/common/feedback";
    /**
     * 修改昵称
     */
    public static final String CHANGE_NICK = API_URL + "/user/change_nick";
    /**
     * 获取用户选择的汽车的商品信息
     */
    public static final String ORDER_GEN = API_URL + "/order/gen";
    /**
     * 委托购车合同
     */
    public static final String MY_AGREEMENT = API_URL + "/contract/my_agreement";


    /**
     * 更新检测
     */
    public static final String VERSION_CHECK = API_URL + "/app/check_version";
    /**
     * 购车合同
     */
    public static final String AGREEMENT = SERVER + "/agreement";
    /**
     * 专属客服
     */
    public static final String ADD_SERVICE = API_URL + "/order/addservice";

}
