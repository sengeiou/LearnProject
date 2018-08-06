package com.cocoa.taobao.product_server.bean.sql;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class ShijiItem implements Serializable {

    private static final long serialVersionUID = 1533277595880L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 
    * isNullAble:1
    */
    private String item_url;

    /**
    * 
    * isNullAble:1
    */
    private String nick;

    /**
    * 
    * isNullAble:1
    */
    private String num_iid;

    /**
    * 
    * isNullAble:1
    */
    private String pict_url;

    /**
    * 
    * isNullAble:1
    */
    private String provcity;

    /**
    * 
    * isNullAble:1
    */
    private String reserve_price;

    /**
    * 
    * isNullAble:1
    */
    private String seller_id;

    /**
    * 
    * isNullAble:1
    */
    private String small_images;

    /**
    * 
    * isNullAble:1
    */
    private String title;

    /**
    * 
    * isNullAble:1,defaultVal:-1
    */
    private Integer user_type;

    /**
    * 
    * isNullAble:1
    */
    private String volume;

    /**
    * 
    * isNullAble:1
    */
    private String zk_final_price;

    /**
    * 
    * isNullAble:1,defaultVal:0
    */
    private Integer sales;

    /**
    * 
    * isNullAble:1
    */
    private Long sales_update_time;

    /**
    * 
    * isNullAble:1
    */
    private Long create_time;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Integer status;

    /**
    * 
    * isNullAble:1
    */
    private String search_kw;

    /**
    * 
    * isNullAble:1,defaultVal:-1
    */
    private Integer tb_from;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setItem_url(String item_url){this.item_url = item_url;}

    public String getItem_url(){return this.item_url;}

    public void setNick(String nick){this.nick = nick;}

    public String getNick(){return this.nick;}

    public void setNum_iid(String num_iid){this.num_iid = num_iid;}

    public String getNum_iid(){return this.num_iid;}

    public void setPict_url(String pict_url){this.pict_url = pict_url;}

    public String getPict_url(){return this.pict_url;}

    public void setProvcity(String provcity){this.provcity = provcity;}

    public String getProvcity(){return this.provcity;}

    public void setReserve_price(String reserve_price){this.reserve_price = reserve_price;}

    public String getReserve_price(){return this.reserve_price;}

    public void setSeller_id(String seller_id){this.seller_id = seller_id;}

    public String getSeller_id(){return this.seller_id;}

    public void setSmall_images(String small_images){this.small_images = small_images;}

    public String getSmall_images(){return this.small_images;}

    public void setTitle(String title){this.title = title;}

    public String getTitle(){return this.title;}

    public void setUser_type(Integer user_type){this.user_type = user_type;}

    public Integer getUser_type(){return this.user_type;}

    public void setVolume(String volume){this.volume = volume;}

    public String getVolume(){return this.volume;}

    public void setZk_final_price(String zk_final_price){this.zk_final_price = zk_final_price;}

    public String getZk_final_price(){return this.zk_final_price;}

    public void setSales(Integer sales){this.sales = sales;}

    public Integer getSales(){return this.sales;}

    public void setSales_update_time(Long sales_update_time){this.sales_update_time = sales_update_time;}

    public Long getSales_update_time(){return this.sales_update_time;}

    public void setCreate_time(Long create_time){this.create_time = create_time;}

    public Long getCreate_time(){return this.create_time;}

    public void setStatus(Integer status){this.status = status;}

    public Integer getStatus(){return this.status;}

    public void setSearch_kw(String search_kw){this.search_kw = search_kw;}

    public String getSearch_kw(){return this.search_kw;}

    public void setTb_from(Integer tb_from){this.tb_from = tb_from;}

    public Integer getTb_from(){return this.tb_from;}
    @Override
    public String toString() {
        return "ShijiItem{" +
                "id='" + id + '\'' +
                "item_url='" + item_url + '\'' +
                "nick='" + nick + '\'' +
                "num_iid='" + num_iid + '\'' +
                "pict_url='" + pict_url + '\'' +
                "provcity='" + provcity + '\'' +
                "reserve_price='" + reserve_price + '\'' +
                "seller_id='" + seller_id + '\'' +
                "small_images='" + small_images + '\'' +
                "title='" + title + '\'' +
                "user_type='" + user_type + '\'' +
                "volume='" + volume + '\'' +
                "zk_final_price='" + zk_final_price + '\'' +
                "sales='" + sales + '\'' +
                "sales_update_time='" + sales_update_time + '\'' +
                "create_time='" + create_time + '\'' +
                "status='" + status + '\'' +
                "search_kw='" + search_kw + '\'' +
                "tb_from='" + tb_from + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private ShijiItem set;

        private ConditionBuilder where;

        public UpdateBuilder set(ShijiItem set){
            this.set = set;
            return this;
        }

        public ShijiItem getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends ShijiItem{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> item_urlList;

        public List<String> getItem_urlList(){return this.item_urlList;}


        private List<String> fuzzyItem_url;

        public List<String> getFuzzyItem_url(){return this.fuzzyItem_url;}

        private List<String> rightFuzzyItem_url;

        public List<String> getRightFuzzyItem_url(){return this.rightFuzzyItem_url;}
        private List<String> nickList;

        public List<String> getNickList(){return this.nickList;}


        private List<String> fuzzyNick;

        public List<String> getFuzzyNick(){return this.fuzzyNick;}

        private List<String> rightFuzzyNick;

        public List<String> getRightFuzzyNick(){return this.rightFuzzyNick;}
        private List<String> num_iidList;

        public List<String> getNum_iidList(){return this.num_iidList;}


        private List<String> fuzzyNum_iid;

        public List<String> getFuzzyNum_iid(){return this.fuzzyNum_iid;}

        private List<String> rightFuzzyNum_iid;

        public List<String> getRightFuzzyNum_iid(){return this.rightFuzzyNum_iid;}
        private List<String> pict_urlList;

        public List<String> getPict_urlList(){return this.pict_urlList;}


        private List<String> fuzzyPict_url;

        public List<String> getFuzzyPict_url(){return this.fuzzyPict_url;}

        private List<String> rightFuzzyPict_url;

        public List<String> getRightFuzzyPict_url(){return this.rightFuzzyPict_url;}
        private List<String> provcityList;

        public List<String> getProvcityList(){return this.provcityList;}


        private List<String> fuzzyProvcity;

        public List<String> getFuzzyProvcity(){return this.fuzzyProvcity;}

        private List<String> rightFuzzyProvcity;

        public List<String> getRightFuzzyProvcity(){return this.rightFuzzyProvcity;}
        private List<String> reserve_priceList;

        public List<String> getReserve_priceList(){return this.reserve_priceList;}


        private List<String> fuzzyReserve_price;

        public List<String> getFuzzyReserve_price(){return this.fuzzyReserve_price;}

        private List<String> rightFuzzyReserve_price;

        public List<String> getRightFuzzyReserve_price(){return this.rightFuzzyReserve_price;}
        private List<String> seller_idList;

        public List<String> getSeller_idList(){return this.seller_idList;}


        private List<String> fuzzySeller_id;

        public List<String> getFuzzySeller_id(){return this.fuzzySeller_id;}

        private List<String> rightFuzzySeller_id;

        public List<String> getRightFuzzySeller_id(){return this.rightFuzzySeller_id;}
        private List<String> small_imagesList;

        public List<String> getSmall_imagesList(){return this.small_imagesList;}


        private List<String> fuzzySmall_images;

        public List<String> getFuzzySmall_images(){return this.fuzzySmall_images;}

        private List<String> rightFuzzySmall_images;

        public List<String> getRightFuzzySmall_images(){return this.rightFuzzySmall_images;}
        private List<String> titleList;

        public List<String> getTitleList(){return this.titleList;}


        private List<String> fuzzyTitle;

        public List<String> getFuzzyTitle(){return this.fuzzyTitle;}

        private List<String> rightFuzzyTitle;

        public List<String> getRightFuzzyTitle(){return this.rightFuzzyTitle;}
        private List<Integer> user_typeList;

        public List<Integer> getUser_typeList(){return this.user_typeList;}

        private Integer user_typeSt;

        private Integer user_typeEd;

        public Integer getUser_typeSt(){return this.user_typeSt;}

        public Integer getUser_typeEd(){return this.user_typeEd;}

        private List<String> volumeList;

        public List<String> getVolumeList(){return this.volumeList;}


        private List<String> fuzzyVolume;

        public List<String> getFuzzyVolume(){return this.fuzzyVolume;}

        private List<String> rightFuzzyVolume;

        public List<String> getRightFuzzyVolume(){return this.rightFuzzyVolume;}
        private List<String> zk_final_priceList;

        public List<String> getZk_final_priceList(){return this.zk_final_priceList;}


        private List<String> fuzzyZk_final_price;

        public List<String> getFuzzyZk_final_price(){return this.fuzzyZk_final_price;}

        private List<String> rightFuzzyZk_final_price;

        public List<String> getRightFuzzyZk_final_price(){return this.rightFuzzyZk_final_price;}
        private List<Integer> salesList;

        public List<Integer> getSalesList(){return this.salesList;}

        private Integer salesSt;

        private Integer salesEd;

        public Integer getSalesSt(){return this.salesSt;}

        public Integer getSalesEd(){return this.salesEd;}

        private List<Long> sales_update_timeList;

        public List<Long> getSales_update_timeList(){return this.sales_update_timeList;}

        private Long sales_update_timeSt;

        private Long sales_update_timeEd;

        public Long getSales_update_timeSt(){return this.sales_update_timeSt;}

        public Long getSales_update_timeEd(){return this.sales_update_timeEd;}

        private List<Long> create_timeList;

        public List<Long> getCreate_timeList(){return this.create_timeList;}

        private Long create_timeSt;

        private Long create_timeEd;

        public Long getCreate_timeSt(){return this.create_timeSt;}

        public Long getCreate_timeEd(){return this.create_timeEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<String> search_kwList;

        public List<String> getSearch_kwList(){return this.search_kwList;}


        private List<String> fuzzySearch_kw;

        public List<String> getFuzzySearch_kw(){return this.fuzzySearch_kw;}

        private List<String> rightFuzzySearch_kw;

        public List<String> getRightFuzzySearch_kw(){return this.rightFuzzySearch_kw;}
        private List<Integer> tb_fromList;

        public List<Integer> getTb_fromList(){return this.tb_fromList;}

        private Integer tb_fromSt;

        private Integer tb_fromEd;

        public Integer getTb_fromSt(){return this.tb_fromSt;}

        public Integer getTb_fromEd(){return this.tb_fromEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Long id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyItem_url (List<String> fuzzyItem_url){
            this.fuzzyItem_url = fuzzyItem_url;
            return this;
        }

        public QueryBuilder fuzzyItem_url (String ... fuzzyItem_url){
            this.fuzzyItem_url = solveNullList(fuzzyItem_url);
            return this;
        }

        public QueryBuilder rightFuzzyItem_url (List<String> rightFuzzyItem_url){
            this.rightFuzzyItem_url = rightFuzzyItem_url;
            return this;
        }

        public QueryBuilder rightFuzzyItem_url (String ... rightFuzzyItem_url){
            this.rightFuzzyItem_url = solveNullList(rightFuzzyItem_url);
            return this;
        }

        public QueryBuilder item_url(String item_url){
            setItem_url(item_url);
            return this;
        }

        public QueryBuilder item_urlList(String ... item_url){
            this.item_urlList = solveNullList(item_url);
            return this;
        }

        public QueryBuilder item_urlList(List<String> item_url){
            this.item_urlList = item_url;
            return this;
        }

        public QueryBuilder fetchItem_url(){
            setFetchFields("fetchFields","item_url");
            return this;
        }

        public QueryBuilder excludeItem_url(){
            setFetchFields("excludeFields","item_url");
            return this;
        }

        public QueryBuilder fuzzyNick (List<String> fuzzyNick){
            this.fuzzyNick = fuzzyNick;
            return this;
        }

        public QueryBuilder fuzzyNick (String ... fuzzyNick){
            this.fuzzyNick = solveNullList(fuzzyNick);
            return this;
        }

        public QueryBuilder rightFuzzyNick (List<String> rightFuzzyNick){
            this.rightFuzzyNick = rightFuzzyNick;
            return this;
        }

        public QueryBuilder rightFuzzyNick (String ... rightFuzzyNick){
            this.rightFuzzyNick = solveNullList(rightFuzzyNick);
            return this;
        }

        public QueryBuilder nick(String nick){
            setNick(nick);
            return this;
        }

        public QueryBuilder nickList(String ... nick){
            this.nickList = solveNullList(nick);
            return this;
        }

        public QueryBuilder nickList(List<String> nick){
            this.nickList = nick;
            return this;
        }

        public QueryBuilder fetchNick(){
            setFetchFields("fetchFields","nick");
            return this;
        }

        public QueryBuilder excludeNick(){
            setFetchFields("excludeFields","nick");
            return this;
        }

        public QueryBuilder fuzzyNum_iid (List<String> fuzzyNum_iid){
            this.fuzzyNum_iid = fuzzyNum_iid;
            return this;
        }

        public QueryBuilder fuzzyNum_iid (String ... fuzzyNum_iid){
            this.fuzzyNum_iid = solveNullList(fuzzyNum_iid);
            return this;
        }

        public QueryBuilder rightFuzzyNum_iid (List<String> rightFuzzyNum_iid){
            this.rightFuzzyNum_iid = rightFuzzyNum_iid;
            return this;
        }

        public QueryBuilder rightFuzzyNum_iid (String ... rightFuzzyNum_iid){
            this.rightFuzzyNum_iid = solveNullList(rightFuzzyNum_iid);
            return this;
        }

        public QueryBuilder num_iid(String num_iid){
            setNum_iid(num_iid);
            return this;
        }

        public QueryBuilder num_iidList(String ... num_iid){
            this.num_iidList = solveNullList(num_iid);
            return this;
        }

        public QueryBuilder num_iidList(List<String> num_iid){
            this.num_iidList = num_iid;
            return this;
        }

        public QueryBuilder fetchNum_iid(){
            setFetchFields("fetchFields","num_iid");
            return this;
        }

        public QueryBuilder excludeNum_iid(){
            setFetchFields("excludeFields","num_iid");
            return this;
        }

        public QueryBuilder fuzzyPict_url (List<String> fuzzyPict_url){
            this.fuzzyPict_url = fuzzyPict_url;
            return this;
        }

        public QueryBuilder fuzzyPict_url (String ... fuzzyPict_url){
            this.fuzzyPict_url = solveNullList(fuzzyPict_url);
            return this;
        }

        public QueryBuilder rightFuzzyPict_url (List<String> rightFuzzyPict_url){
            this.rightFuzzyPict_url = rightFuzzyPict_url;
            return this;
        }

        public QueryBuilder rightFuzzyPict_url (String ... rightFuzzyPict_url){
            this.rightFuzzyPict_url = solveNullList(rightFuzzyPict_url);
            return this;
        }

        public QueryBuilder pict_url(String pict_url){
            setPict_url(pict_url);
            return this;
        }

        public QueryBuilder pict_urlList(String ... pict_url){
            this.pict_urlList = solveNullList(pict_url);
            return this;
        }

        public QueryBuilder pict_urlList(List<String> pict_url){
            this.pict_urlList = pict_url;
            return this;
        }

        public QueryBuilder fetchPict_url(){
            setFetchFields("fetchFields","pict_url");
            return this;
        }

        public QueryBuilder excludePict_url(){
            setFetchFields("excludeFields","pict_url");
            return this;
        }

        public QueryBuilder fuzzyProvcity (List<String> fuzzyProvcity){
            this.fuzzyProvcity = fuzzyProvcity;
            return this;
        }

        public QueryBuilder fuzzyProvcity (String ... fuzzyProvcity){
            this.fuzzyProvcity = solveNullList(fuzzyProvcity);
            return this;
        }

        public QueryBuilder rightFuzzyProvcity (List<String> rightFuzzyProvcity){
            this.rightFuzzyProvcity = rightFuzzyProvcity;
            return this;
        }

        public QueryBuilder rightFuzzyProvcity (String ... rightFuzzyProvcity){
            this.rightFuzzyProvcity = solveNullList(rightFuzzyProvcity);
            return this;
        }

        public QueryBuilder provcity(String provcity){
            setProvcity(provcity);
            return this;
        }

        public QueryBuilder provcityList(String ... provcity){
            this.provcityList = solveNullList(provcity);
            return this;
        }

        public QueryBuilder provcityList(List<String> provcity){
            this.provcityList = provcity;
            return this;
        }

        public QueryBuilder fetchProvcity(){
            setFetchFields("fetchFields","provcity");
            return this;
        }

        public QueryBuilder excludeProvcity(){
            setFetchFields("excludeFields","provcity");
            return this;
        }

        public QueryBuilder fuzzyReserve_price (List<String> fuzzyReserve_price){
            this.fuzzyReserve_price = fuzzyReserve_price;
            return this;
        }

        public QueryBuilder fuzzyReserve_price (String ... fuzzyReserve_price){
            this.fuzzyReserve_price = solveNullList(fuzzyReserve_price);
            return this;
        }

        public QueryBuilder rightFuzzyReserve_price (List<String> rightFuzzyReserve_price){
            this.rightFuzzyReserve_price = rightFuzzyReserve_price;
            return this;
        }

        public QueryBuilder rightFuzzyReserve_price (String ... rightFuzzyReserve_price){
            this.rightFuzzyReserve_price = solveNullList(rightFuzzyReserve_price);
            return this;
        }

        public QueryBuilder reserve_price(String reserve_price){
            setReserve_price(reserve_price);
            return this;
        }

        public QueryBuilder reserve_priceList(String ... reserve_price){
            this.reserve_priceList = solveNullList(reserve_price);
            return this;
        }

        public QueryBuilder reserve_priceList(List<String> reserve_price){
            this.reserve_priceList = reserve_price;
            return this;
        }

        public QueryBuilder fetchReserve_price(){
            setFetchFields("fetchFields","reserve_price");
            return this;
        }

        public QueryBuilder excludeReserve_price(){
            setFetchFields("excludeFields","reserve_price");
            return this;
        }

        public QueryBuilder fuzzySeller_id (List<String> fuzzySeller_id){
            this.fuzzySeller_id = fuzzySeller_id;
            return this;
        }

        public QueryBuilder fuzzySeller_id (String ... fuzzySeller_id){
            this.fuzzySeller_id = solveNullList(fuzzySeller_id);
            return this;
        }

        public QueryBuilder rightFuzzySeller_id (List<String> rightFuzzySeller_id){
            this.rightFuzzySeller_id = rightFuzzySeller_id;
            return this;
        }

        public QueryBuilder rightFuzzySeller_id (String ... rightFuzzySeller_id){
            this.rightFuzzySeller_id = solveNullList(rightFuzzySeller_id);
            return this;
        }

        public QueryBuilder seller_id(String seller_id){
            setSeller_id(seller_id);
            return this;
        }

        public QueryBuilder seller_idList(String ... seller_id){
            this.seller_idList = solveNullList(seller_id);
            return this;
        }

        public QueryBuilder seller_idList(List<String> seller_id){
            this.seller_idList = seller_id;
            return this;
        }

        public QueryBuilder fetchSeller_id(){
            setFetchFields("fetchFields","seller_id");
            return this;
        }

        public QueryBuilder excludeSeller_id(){
            setFetchFields("excludeFields","seller_id");
            return this;
        }

        public QueryBuilder fuzzySmall_images (List<String> fuzzySmall_images){
            this.fuzzySmall_images = fuzzySmall_images;
            return this;
        }

        public QueryBuilder fuzzySmall_images (String ... fuzzySmall_images){
            this.fuzzySmall_images = solveNullList(fuzzySmall_images);
            return this;
        }

        public QueryBuilder rightFuzzySmall_images (List<String> rightFuzzySmall_images){
            this.rightFuzzySmall_images = rightFuzzySmall_images;
            return this;
        }

        public QueryBuilder rightFuzzySmall_images (String ... rightFuzzySmall_images){
            this.rightFuzzySmall_images = solveNullList(rightFuzzySmall_images);
            return this;
        }

        public QueryBuilder small_images(String small_images){
            setSmall_images(small_images);
            return this;
        }

        public QueryBuilder small_imagesList(String ... small_images){
            this.small_imagesList = solveNullList(small_images);
            return this;
        }

        public QueryBuilder small_imagesList(List<String> small_images){
            this.small_imagesList = small_images;
            return this;
        }

        public QueryBuilder fetchSmall_images(){
            setFetchFields("fetchFields","small_images");
            return this;
        }

        public QueryBuilder excludeSmall_images(){
            setFetchFields("excludeFields","small_images");
            return this;
        }

        public QueryBuilder fuzzyTitle (List<String> fuzzyTitle){
            this.fuzzyTitle = fuzzyTitle;
            return this;
        }

        public QueryBuilder fuzzyTitle (String ... fuzzyTitle){
            this.fuzzyTitle = solveNullList(fuzzyTitle);
            return this;
        }

        public QueryBuilder rightFuzzyTitle (List<String> rightFuzzyTitle){
            this.rightFuzzyTitle = rightFuzzyTitle;
            return this;
        }

        public QueryBuilder rightFuzzyTitle (String ... rightFuzzyTitle){
            this.rightFuzzyTitle = solveNullList(rightFuzzyTitle);
            return this;
        }

        public QueryBuilder title(String title){
            setTitle(title);
            return this;
        }

        public QueryBuilder titleList(String ... title){
            this.titleList = solveNullList(title);
            return this;
        }

        public QueryBuilder titleList(List<String> title){
            this.titleList = title;
            return this;
        }

        public QueryBuilder fetchTitle(){
            setFetchFields("fetchFields","title");
            return this;
        }

        public QueryBuilder excludeTitle(){
            setFetchFields("excludeFields","title");
            return this;
        }

        public QueryBuilder user_typeBetWeen(Integer user_typeSt,Integer user_typeEd){
            this.user_typeSt = user_typeSt;
            this.user_typeEd = user_typeEd;
            return this;
        }

        public QueryBuilder user_typeGreaterEqThan(Integer user_typeSt){
            this.user_typeSt = user_typeSt;
            return this;
        }
        public QueryBuilder user_typeLessEqThan(Integer user_typeEd){
            this.user_typeEd = user_typeEd;
            return this;
        }


        public QueryBuilder user_type(Integer user_type){
            setUser_type(user_type);
            return this;
        }

        public QueryBuilder user_typeList(Integer ... user_type){
            this.user_typeList = solveNullList(user_type);
            return this;
        }

        public QueryBuilder user_typeList(List<Integer> user_type){
            this.user_typeList = user_type;
            return this;
        }

        public QueryBuilder fetchUser_type(){
            setFetchFields("fetchFields","user_type");
            return this;
        }

        public QueryBuilder excludeUser_type(){
            setFetchFields("excludeFields","user_type");
            return this;
        }

        public QueryBuilder fuzzyVolume (List<String> fuzzyVolume){
            this.fuzzyVolume = fuzzyVolume;
            return this;
        }

        public QueryBuilder fuzzyVolume (String ... fuzzyVolume){
            this.fuzzyVolume = solveNullList(fuzzyVolume);
            return this;
        }

        public QueryBuilder rightFuzzyVolume (List<String> rightFuzzyVolume){
            this.rightFuzzyVolume = rightFuzzyVolume;
            return this;
        }

        public QueryBuilder rightFuzzyVolume (String ... rightFuzzyVolume){
            this.rightFuzzyVolume = solveNullList(rightFuzzyVolume);
            return this;
        }

        public QueryBuilder volume(String volume){
            setVolume(volume);
            return this;
        }

        public QueryBuilder volumeList(String ... volume){
            this.volumeList = solveNullList(volume);
            return this;
        }

        public QueryBuilder volumeList(List<String> volume){
            this.volumeList = volume;
            return this;
        }

        public QueryBuilder fetchVolume(){
            setFetchFields("fetchFields","volume");
            return this;
        }

        public QueryBuilder excludeVolume(){
            setFetchFields("excludeFields","volume");
            return this;
        }

        public QueryBuilder fuzzyZk_final_price (List<String> fuzzyZk_final_price){
            this.fuzzyZk_final_price = fuzzyZk_final_price;
            return this;
        }

        public QueryBuilder fuzzyZk_final_price (String ... fuzzyZk_final_price){
            this.fuzzyZk_final_price = solveNullList(fuzzyZk_final_price);
            return this;
        }

        public QueryBuilder rightFuzzyZk_final_price (List<String> rightFuzzyZk_final_price){
            this.rightFuzzyZk_final_price = rightFuzzyZk_final_price;
            return this;
        }

        public QueryBuilder rightFuzzyZk_final_price (String ... rightFuzzyZk_final_price){
            this.rightFuzzyZk_final_price = solveNullList(rightFuzzyZk_final_price);
            return this;
        }

        public QueryBuilder zk_final_price(String zk_final_price){
            setZk_final_price(zk_final_price);
            return this;
        }

        public QueryBuilder zk_final_priceList(String ... zk_final_price){
            this.zk_final_priceList = solveNullList(zk_final_price);
            return this;
        }

        public QueryBuilder zk_final_priceList(List<String> zk_final_price){
            this.zk_final_priceList = zk_final_price;
            return this;
        }

        public QueryBuilder fetchZk_final_price(){
            setFetchFields("fetchFields","zk_final_price");
            return this;
        }

        public QueryBuilder excludeZk_final_price(){
            setFetchFields("excludeFields","zk_final_price");
            return this;
        }

        public QueryBuilder salesBetWeen(Integer salesSt,Integer salesEd){
            this.salesSt = salesSt;
            this.salesEd = salesEd;
            return this;
        }

        public QueryBuilder salesGreaterEqThan(Integer salesSt){
            this.salesSt = salesSt;
            return this;
        }
        public QueryBuilder salesLessEqThan(Integer salesEd){
            this.salesEd = salesEd;
            return this;
        }


        public QueryBuilder sales(Integer sales){
            setSales(sales);
            return this;
        }

        public QueryBuilder salesList(Integer ... sales){
            this.salesList = solveNullList(sales);
            return this;
        }

        public QueryBuilder salesList(List<Integer> sales){
            this.salesList = sales;
            return this;
        }

        public QueryBuilder fetchSales(){
            setFetchFields("fetchFields","sales");
            return this;
        }

        public QueryBuilder excludeSales(){
            setFetchFields("excludeFields","sales");
            return this;
        }

        public QueryBuilder sales_update_timeBetWeen(Long sales_update_timeSt,Long sales_update_timeEd){
            this.sales_update_timeSt = sales_update_timeSt;
            this.sales_update_timeEd = sales_update_timeEd;
            return this;
        }

        public QueryBuilder sales_update_timeGreaterEqThan(Long sales_update_timeSt){
            this.sales_update_timeSt = sales_update_timeSt;
            return this;
        }
        public QueryBuilder sales_update_timeLessEqThan(Long sales_update_timeEd){
            this.sales_update_timeEd = sales_update_timeEd;
            return this;
        }


        public QueryBuilder sales_update_time(Long sales_update_time){
            setSales_update_time(sales_update_time);
            return this;
        }

        public QueryBuilder sales_update_timeList(Long ... sales_update_time){
            this.sales_update_timeList = solveNullList(sales_update_time);
            return this;
        }

        public QueryBuilder sales_update_timeList(List<Long> sales_update_time){
            this.sales_update_timeList = sales_update_time;
            return this;
        }

        public QueryBuilder fetchSales_update_time(){
            setFetchFields("fetchFields","sales_update_time");
            return this;
        }

        public QueryBuilder excludeSales_update_time(){
            setFetchFields("excludeFields","sales_update_time");
            return this;
        }

        public QueryBuilder create_timeBetWeen(Long create_timeSt,Long create_timeEd){
            this.create_timeSt = create_timeSt;
            this.create_timeEd = create_timeEd;
            return this;
        }

        public QueryBuilder create_timeGreaterEqThan(Long create_timeSt){
            this.create_timeSt = create_timeSt;
            return this;
        }
        public QueryBuilder create_timeLessEqThan(Long create_timeEd){
            this.create_timeEd = create_timeEd;
            return this;
        }


        public QueryBuilder create_time(Long create_time){
            setCreate_time(create_time);
            return this;
        }

        public QueryBuilder create_timeList(Long ... create_time){
            this.create_timeList = solveNullList(create_time);
            return this;
        }

        public QueryBuilder create_timeList(List<Long> create_time){
            this.create_timeList = create_time;
            return this;
        }

        public QueryBuilder fetchCreate_time(){
            setFetchFields("fetchFields","create_time");
            return this;
        }

        public QueryBuilder excludeCreate_time(){
            setFetchFields("excludeFields","create_time");
            return this;
        }

        public QueryBuilder statusBetWeen(Integer statusSt,Integer statusEd){
            this.statusSt = statusSt;
            this.statusEd = statusEd;
            return this;
        }

        public QueryBuilder statusGreaterEqThan(Integer statusSt){
            this.statusSt = statusSt;
            return this;
        }
        public QueryBuilder statusLessEqThan(Integer statusEd){
            this.statusEd = statusEd;
            return this;
        }


        public QueryBuilder status(Integer status){
            setStatus(status);
            return this;
        }

        public QueryBuilder statusList(Integer ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public QueryBuilder statusList(List<Integer> status){
            this.statusList = status;
            return this;
        }

        public QueryBuilder fetchStatus(){
            setFetchFields("fetchFields","status");
            return this;
        }

        public QueryBuilder excludeStatus(){
            setFetchFields("excludeFields","status");
            return this;
        }

        public QueryBuilder fuzzySearch_kw (List<String> fuzzySearch_kw){
            this.fuzzySearch_kw = fuzzySearch_kw;
            return this;
        }

        public QueryBuilder fuzzySearch_kw (String ... fuzzySearch_kw){
            this.fuzzySearch_kw = solveNullList(fuzzySearch_kw);
            return this;
        }

        public QueryBuilder rightFuzzySearch_kw (List<String> rightFuzzySearch_kw){
            this.rightFuzzySearch_kw = rightFuzzySearch_kw;
            return this;
        }

        public QueryBuilder rightFuzzySearch_kw (String ... rightFuzzySearch_kw){
            this.rightFuzzySearch_kw = solveNullList(rightFuzzySearch_kw);
            return this;
        }

        public QueryBuilder search_kw(String search_kw){
            setSearch_kw(search_kw);
            return this;
        }

        public QueryBuilder search_kwList(String ... search_kw){
            this.search_kwList = solveNullList(search_kw);
            return this;
        }

        public QueryBuilder search_kwList(List<String> search_kw){
            this.search_kwList = search_kw;
            return this;
        }

        public QueryBuilder fetchSearch_kw(){
            setFetchFields("fetchFields","search_kw");
            return this;
        }

        public QueryBuilder excludeSearch_kw(){
            setFetchFields("excludeFields","search_kw");
            return this;
        }

        public QueryBuilder tb_fromBetWeen(Integer tb_fromSt,Integer tb_fromEd){
            this.tb_fromSt = tb_fromSt;
            this.tb_fromEd = tb_fromEd;
            return this;
        }

        public QueryBuilder tb_fromGreaterEqThan(Integer tb_fromSt){
            this.tb_fromSt = tb_fromSt;
            return this;
        }
        public QueryBuilder tb_fromLessEqThan(Integer tb_fromEd){
            this.tb_fromEd = tb_fromEd;
            return this;
        }


        public QueryBuilder tb_from(Integer tb_from){
            setTb_from(tb_from);
            return this;
        }

        public QueryBuilder tb_fromList(Integer ... tb_from){
            this.tb_fromList = solveNullList(tb_from);
            return this;
        }

        public QueryBuilder tb_fromList(List<Integer> tb_from){
            this.tb_fromList = tb_from;
            return this;
        }

        public QueryBuilder fetchTb_from(){
            setFetchFields("fetchFields","tb_from");
            return this;
        }

        public QueryBuilder excludeTb_from(){
            setFetchFields("excludeFields","tb_from");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public ShijiItem build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> item_urlList;

        public List<String> getItem_urlList(){return this.item_urlList;}


        private List<String> fuzzyItem_url;

        public List<String> getFuzzyItem_url(){return this.fuzzyItem_url;}

        private List<String> rightFuzzyItem_url;

        public List<String> getRightFuzzyItem_url(){return this.rightFuzzyItem_url;}
        private List<String> nickList;

        public List<String> getNickList(){return this.nickList;}


        private List<String> fuzzyNick;

        public List<String> getFuzzyNick(){return this.fuzzyNick;}

        private List<String> rightFuzzyNick;

        public List<String> getRightFuzzyNick(){return this.rightFuzzyNick;}
        private List<String> num_iidList;

        public List<String> getNum_iidList(){return this.num_iidList;}


        private List<String> fuzzyNum_iid;

        public List<String> getFuzzyNum_iid(){return this.fuzzyNum_iid;}

        private List<String> rightFuzzyNum_iid;

        public List<String> getRightFuzzyNum_iid(){return this.rightFuzzyNum_iid;}
        private List<String> pict_urlList;

        public List<String> getPict_urlList(){return this.pict_urlList;}


        private List<String> fuzzyPict_url;

        public List<String> getFuzzyPict_url(){return this.fuzzyPict_url;}

        private List<String> rightFuzzyPict_url;

        public List<String> getRightFuzzyPict_url(){return this.rightFuzzyPict_url;}
        private List<String> provcityList;

        public List<String> getProvcityList(){return this.provcityList;}


        private List<String> fuzzyProvcity;

        public List<String> getFuzzyProvcity(){return this.fuzzyProvcity;}

        private List<String> rightFuzzyProvcity;

        public List<String> getRightFuzzyProvcity(){return this.rightFuzzyProvcity;}
        private List<String> reserve_priceList;

        public List<String> getReserve_priceList(){return this.reserve_priceList;}


        private List<String> fuzzyReserve_price;

        public List<String> getFuzzyReserve_price(){return this.fuzzyReserve_price;}

        private List<String> rightFuzzyReserve_price;

        public List<String> getRightFuzzyReserve_price(){return this.rightFuzzyReserve_price;}
        private List<String> seller_idList;

        public List<String> getSeller_idList(){return this.seller_idList;}


        private List<String> fuzzySeller_id;

        public List<String> getFuzzySeller_id(){return this.fuzzySeller_id;}

        private List<String> rightFuzzySeller_id;

        public List<String> getRightFuzzySeller_id(){return this.rightFuzzySeller_id;}
        private List<String> small_imagesList;

        public List<String> getSmall_imagesList(){return this.small_imagesList;}


        private List<String> fuzzySmall_images;

        public List<String> getFuzzySmall_images(){return this.fuzzySmall_images;}

        private List<String> rightFuzzySmall_images;

        public List<String> getRightFuzzySmall_images(){return this.rightFuzzySmall_images;}
        private List<String> titleList;

        public List<String> getTitleList(){return this.titleList;}


        private List<String> fuzzyTitle;

        public List<String> getFuzzyTitle(){return this.fuzzyTitle;}

        private List<String> rightFuzzyTitle;

        public List<String> getRightFuzzyTitle(){return this.rightFuzzyTitle;}
        private List<Integer> user_typeList;

        public List<Integer> getUser_typeList(){return this.user_typeList;}

        private Integer user_typeSt;

        private Integer user_typeEd;

        public Integer getUser_typeSt(){return this.user_typeSt;}

        public Integer getUser_typeEd(){return this.user_typeEd;}

        private List<String> volumeList;

        public List<String> getVolumeList(){return this.volumeList;}


        private List<String> fuzzyVolume;

        public List<String> getFuzzyVolume(){return this.fuzzyVolume;}

        private List<String> rightFuzzyVolume;

        public List<String> getRightFuzzyVolume(){return this.rightFuzzyVolume;}
        private List<String> zk_final_priceList;

        public List<String> getZk_final_priceList(){return this.zk_final_priceList;}


        private List<String> fuzzyZk_final_price;

        public List<String> getFuzzyZk_final_price(){return this.fuzzyZk_final_price;}

        private List<String> rightFuzzyZk_final_price;

        public List<String> getRightFuzzyZk_final_price(){return this.rightFuzzyZk_final_price;}
        private List<Integer> salesList;

        public List<Integer> getSalesList(){return this.salesList;}

        private Integer salesSt;

        private Integer salesEd;

        public Integer getSalesSt(){return this.salesSt;}

        public Integer getSalesEd(){return this.salesEd;}

        private List<Long> sales_update_timeList;

        public List<Long> getSales_update_timeList(){return this.sales_update_timeList;}

        private Long sales_update_timeSt;

        private Long sales_update_timeEd;

        public Long getSales_update_timeSt(){return this.sales_update_timeSt;}

        public Long getSales_update_timeEd(){return this.sales_update_timeEd;}

        private List<Long> create_timeList;

        public List<Long> getCreate_timeList(){return this.create_timeList;}

        private Long create_timeSt;

        private Long create_timeEd;

        public Long getCreate_timeSt(){return this.create_timeSt;}

        public Long getCreate_timeEd(){return this.create_timeEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private List<String> search_kwList;

        public List<String> getSearch_kwList(){return this.search_kwList;}


        private List<String> fuzzySearch_kw;

        public List<String> getFuzzySearch_kw(){return this.fuzzySearch_kw;}

        private List<String> rightFuzzySearch_kw;

        public List<String> getRightFuzzySearch_kw(){return this.rightFuzzySearch_kw;}
        private List<Integer> tb_fromList;

        public List<Integer> getTb_fromList(){return this.tb_fromList;}

        private Integer tb_fromSt;

        private Integer tb_fromEd;

        public Integer getTb_fromSt(){return this.tb_fromSt;}

        public Integer getTb_fromEd(){return this.tb_fromEd;}


        public ConditionBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyItem_url (List<String> fuzzyItem_url){
            this.fuzzyItem_url = fuzzyItem_url;
            return this;
        }

        public ConditionBuilder fuzzyItem_url (String ... fuzzyItem_url){
            this.fuzzyItem_url = solveNullList(fuzzyItem_url);
            return this;
        }

        public ConditionBuilder rightFuzzyItem_url (List<String> rightFuzzyItem_url){
            this.rightFuzzyItem_url = rightFuzzyItem_url;
            return this;
        }

        public ConditionBuilder rightFuzzyItem_url (String ... rightFuzzyItem_url){
            this.rightFuzzyItem_url = solveNullList(rightFuzzyItem_url);
            return this;
        }

        public ConditionBuilder item_urlList(String ... item_url){
            this.item_urlList = solveNullList(item_url);
            return this;
        }

        public ConditionBuilder item_urlList(List<String> item_url){
            this.item_urlList = item_url;
            return this;
        }

        public ConditionBuilder fuzzyNick (List<String> fuzzyNick){
            this.fuzzyNick = fuzzyNick;
            return this;
        }

        public ConditionBuilder fuzzyNick (String ... fuzzyNick){
            this.fuzzyNick = solveNullList(fuzzyNick);
            return this;
        }

        public ConditionBuilder rightFuzzyNick (List<String> rightFuzzyNick){
            this.rightFuzzyNick = rightFuzzyNick;
            return this;
        }

        public ConditionBuilder rightFuzzyNick (String ... rightFuzzyNick){
            this.rightFuzzyNick = solveNullList(rightFuzzyNick);
            return this;
        }

        public ConditionBuilder nickList(String ... nick){
            this.nickList = solveNullList(nick);
            return this;
        }

        public ConditionBuilder nickList(List<String> nick){
            this.nickList = nick;
            return this;
        }

        public ConditionBuilder fuzzyNum_iid (List<String> fuzzyNum_iid){
            this.fuzzyNum_iid = fuzzyNum_iid;
            return this;
        }

        public ConditionBuilder fuzzyNum_iid (String ... fuzzyNum_iid){
            this.fuzzyNum_iid = solveNullList(fuzzyNum_iid);
            return this;
        }

        public ConditionBuilder rightFuzzyNum_iid (List<String> rightFuzzyNum_iid){
            this.rightFuzzyNum_iid = rightFuzzyNum_iid;
            return this;
        }

        public ConditionBuilder rightFuzzyNum_iid (String ... rightFuzzyNum_iid){
            this.rightFuzzyNum_iid = solveNullList(rightFuzzyNum_iid);
            return this;
        }

        public ConditionBuilder num_iidList(String ... num_iid){
            this.num_iidList = solveNullList(num_iid);
            return this;
        }

        public ConditionBuilder num_iidList(List<String> num_iid){
            this.num_iidList = num_iid;
            return this;
        }

        public ConditionBuilder fuzzyPict_url (List<String> fuzzyPict_url){
            this.fuzzyPict_url = fuzzyPict_url;
            return this;
        }

        public ConditionBuilder fuzzyPict_url (String ... fuzzyPict_url){
            this.fuzzyPict_url = solveNullList(fuzzyPict_url);
            return this;
        }

        public ConditionBuilder rightFuzzyPict_url (List<String> rightFuzzyPict_url){
            this.rightFuzzyPict_url = rightFuzzyPict_url;
            return this;
        }

        public ConditionBuilder rightFuzzyPict_url (String ... rightFuzzyPict_url){
            this.rightFuzzyPict_url = solveNullList(rightFuzzyPict_url);
            return this;
        }

        public ConditionBuilder pict_urlList(String ... pict_url){
            this.pict_urlList = solveNullList(pict_url);
            return this;
        }

        public ConditionBuilder pict_urlList(List<String> pict_url){
            this.pict_urlList = pict_url;
            return this;
        }

        public ConditionBuilder fuzzyProvcity (List<String> fuzzyProvcity){
            this.fuzzyProvcity = fuzzyProvcity;
            return this;
        }

        public ConditionBuilder fuzzyProvcity (String ... fuzzyProvcity){
            this.fuzzyProvcity = solveNullList(fuzzyProvcity);
            return this;
        }

        public ConditionBuilder rightFuzzyProvcity (List<String> rightFuzzyProvcity){
            this.rightFuzzyProvcity = rightFuzzyProvcity;
            return this;
        }

        public ConditionBuilder rightFuzzyProvcity (String ... rightFuzzyProvcity){
            this.rightFuzzyProvcity = solveNullList(rightFuzzyProvcity);
            return this;
        }

        public ConditionBuilder provcityList(String ... provcity){
            this.provcityList = solveNullList(provcity);
            return this;
        }

        public ConditionBuilder provcityList(List<String> provcity){
            this.provcityList = provcity;
            return this;
        }

        public ConditionBuilder fuzzyReserve_price (List<String> fuzzyReserve_price){
            this.fuzzyReserve_price = fuzzyReserve_price;
            return this;
        }

        public ConditionBuilder fuzzyReserve_price (String ... fuzzyReserve_price){
            this.fuzzyReserve_price = solveNullList(fuzzyReserve_price);
            return this;
        }

        public ConditionBuilder rightFuzzyReserve_price (List<String> rightFuzzyReserve_price){
            this.rightFuzzyReserve_price = rightFuzzyReserve_price;
            return this;
        }

        public ConditionBuilder rightFuzzyReserve_price (String ... rightFuzzyReserve_price){
            this.rightFuzzyReserve_price = solveNullList(rightFuzzyReserve_price);
            return this;
        }

        public ConditionBuilder reserve_priceList(String ... reserve_price){
            this.reserve_priceList = solveNullList(reserve_price);
            return this;
        }

        public ConditionBuilder reserve_priceList(List<String> reserve_price){
            this.reserve_priceList = reserve_price;
            return this;
        }

        public ConditionBuilder fuzzySeller_id (List<String> fuzzySeller_id){
            this.fuzzySeller_id = fuzzySeller_id;
            return this;
        }

        public ConditionBuilder fuzzySeller_id (String ... fuzzySeller_id){
            this.fuzzySeller_id = solveNullList(fuzzySeller_id);
            return this;
        }

        public ConditionBuilder rightFuzzySeller_id (List<String> rightFuzzySeller_id){
            this.rightFuzzySeller_id = rightFuzzySeller_id;
            return this;
        }

        public ConditionBuilder rightFuzzySeller_id (String ... rightFuzzySeller_id){
            this.rightFuzzySeller_id = solveNullList(rightFuzzySeller_id);
            return this;
        }

        public ConditionBuilder seller_idList(String ... seller_id){
            this.seller_idList = solveNullList(seller_id);
            return this;
        }

        public ConditionBuilder seller_idList(List<String> seller_id){
            this.seller_idList = seller_id;
            return this;
        }

        public ConditionBuilder fuzzySmall_images (List<String> fuzzySmall_images){
            this.fuzzySmall_images = fuzzySmall_images;
            return this;
        }

        public ConditionBuilder fuzzySmall_images (String ... fuzzySmall_images){
            this.fuzzySmall_images = solveNullList(fuzzySmall_images);
            return this;
        }

        public ConditionBuilder rightFuzzySmall_images (List<String> rightFuzzySmall_images){
            this.rightFuzzySmall_images = rightFuzzySmall_images;
            return this;
        }

        public ConditionBuilder rightFuzzySmall_images (String ... rightFuzzySmall_images){
            this.rightFuzzySmall_images = solveNullList(rightFuzzySmall_images);
            return this;
        }

        public ConditionBuilder small_imagesList(String ... small_images){
            this.small_imagesList = solveNullList(small_images);
            return this;
        }

        public ConditionBuilder small_imagesList(List<String> small_images){
            this.small_imagesList = small_images;
            return this;
        }

        public ConditionBuilder fuzzyTitle (List<String> fuzzyTitle){
            this.fuzzyTitle = fuzzyTitle;
            return this;
        }

        public ConditionBuilder fuzzyTitle (String ... fuzzyTitle){
            this.fuzzyTitle = solveNullList(fuzzyTitle);
            return this;
        }

        public ConditionBuilder rightFuzzyTitle (List<String> rightFuzzyTitle){
            this.rightFuzzyTitle = rightFuzzyTitle;
            return this;
        }

        public ConditionBuilder rightFuzzyTitle (String ... rightFuzzyTitle){
            this.rightFuzzyTitle = solveNullList(rightFuzzyTitle);
            return this;
        }

        public ConditionBuilder titleList(String ... title){
            this.titleList = solveNullList(title);
            return this;
        }

        public ConditionBuilder titleList(List<String> title){
            this.titleList = title;
            return this;
        }

        public ConditionBuilder user_typeBetWeen(Integer user_typeSt,Integer user_typeEd){
            this.user_typeSt = user_typeSt;
            this.user_typeEd = user_typeEd;
            return this;
        }

        public ConditionBuilder user_typeGreaterEqThan(Integer user_typeSt){
            this.user_typeSt = user_typeSt;
            return this;
        }
        public ConditionBuilder user_typeLessEqThan(Integer user_typeEd){
            this.user_typeEd = user_typeEd;
            return this;
        }


        public ConditionBuilder user_typeList(Integer ... user_type){
            this.user_typeList = solveNullList(user_type);
            return this;
        }

        public ConditionBuilder user_typeList(List<Integer> user_type){
            this.user_typeList = user_type;
            return this;
        }

        public ConditionBuilder fuzzyVolume (List<String> fuzzyVolume){
            this.fuzzyVolume = fuzzyVolume;
            return this;
        }

        public ConditionBuilder fuzzyVolume (String ... fuzzyVolume){
            this.fuzzyVolume = solveNullList(fuzzyVolume);
            return this;
        }

        public ConditionBuilder rightFuzzyVolume (List<String> rightFuzzyVolume){
            this.rightFuzzyVolume = rightFuzzyVolume;
            return this;
        }

        public ConditionBuilder rightFuzzyVolume (String ... rightFuzzyVolume){
            this.rightFuzzyVolume = solveNullList(rightFuzzyVolume);
            return this;
        }

        public ConditionBuilder volumeList(String ... volume){
            this.volumeList = solveNullList(volume);
            return this;
        }

        public ConditionBuilder volumeList(List<String> volume){
            this.volumeList = volume;
            return this;
        }

        public ConditionBuilder fuzzyZk_final_price (List<String> fuzzyZk_final_price){
            this.fuzzyZk_final_price = fuzzyZk_final_price;
            return this;
        }

        public ConditionBuilder fuzzyZk_final_price (String ... fuzzyZk_final_price){
            this.fuzzyZk_final_price = solveNullList(fuzzyZk_final_price);
            return this;
        }

        public ConditionBuilder rightFuzzyZk_final_price (List<String> rightFuzzyZk_final_price){
            this.rightFuzzyZk_final_price = rightFuzzyZk_final_price;
            return this;
        }

        public ConditionBuilder rightFuzzyZk_final_price (String ... rightFuzzyZk_final_price){
            this.rightFuzzyZk_final_price = solveNullList(rightFuzzyZk_final_price);
            return this;
        }

        public ConditionBuilder zk_final_priceList(String ... zk_final_price){
            this.zk_final_priceList = solveNullList(zk_final_price);
            return this;
        }

        public ConditionBuilder zk_final_priceList(List<String> zk_final_price){
            this.zk_final_priceList = zk_final_price;
            return this;
        }

        public ConditionBuilder salesBetWeen(Integer salesSt,Integer salesEd){
            this.salesSt = salesSt;
            this.salesEd = salesEd;
            return this;
        }

        public ConditionBuilder salesGreaterEqThan(Integer salesSt){
            this.salesSt = salesSt;
            return this;
        }
        public ConditionBuilder salesLessEqThan(Integer salesEd){
            this.salesEd = salesEd;
            return this;
        }


        public ConditionBuilder salesList(Integer ... sales){
            this.salesList = solveNullList(sales);
            return this;
        }

        public ConditionBuilder salesList(List<Integer> sales){
            this.salesList = sales;
            return this;
        }

        public ConditionBuilder sales_update_timeBetWeen(Long sales_update_timeSt,Long sales_update_timeEd){
            this.sales_update_timeSt = sales_update_timeSt;
            this.sales_update_timeEd = sales_update_timeEd;
            return this;
        }

        public ConditionBuilder sales_update_timeGreaterEqThan(Long sales_update_timeSt){
            this.sales_update_timeSt = sales_update_timeSt;
            return this;
        }
        public ConditionBuilder sales_update_timeLessEqThan(Long sales_update_timeEd){
            this.sales_update_timeEd = sales_update_timeEd;
            return this;
        }


        public ConditionBuilder sales_update_timeList(Long ... sales_update_time){
            this.sales_update_timeList = solveNullList(sales_update_time);
            return this;
        }

        public ConditionBuilder sales_update_timeList(List<Long> sales_update_time){
            this.sales_update_timeList = sales_update_time;
            return this;
        }

        public ConditionBuilder create_timeBetWeen(Long create_timeSt,Long create_timeEd){
            this.create_timeSt = create_timeSt;
            this.create_timeEd = create_timeEd;
            return this;
        }

        public ConditionBuilder create_timeGreaterEqThan(Long create_timeSt){
            this.create_timeSt = create_timeSt;
            return this;
        }
        public ConditionBuilder create_timeLessEqThan(Long create_timeEd){
            this.create_timeEd = create_timeEd;
            return this;
        }


        public ConditionBuilder create_timeList(Long ... create_time){
            this.create_timeList = solveNullList(create_time);
            return this;
        }

        public ConditionBuilder create_timeList(List<Long> create_time){
            this.create_timeList = create_time;
            return this;
        }

        public ConditionBuilder statusBetWeen(Integer statusSt,Integer statusEd){
            this.statusSt = statusSt;
            this.statusEd = statusEd;
            return this;
        }

        public ConditionBuilder statusGreaterEqThan(Integer statusSt){
            this.statusSt = statusSt;
            return this;
        }
        public ConditionBuilder statusLessEqThan(Integer statusEd){
            this.statusEd = statusEd;
            return this;
        }


        public ConditionBuilder statusList(Integer ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public ConditionBuilder statusList(List<Integer> status){
            this.statusList = status;
            return this;
        }

        public ConditionBuilder fuzzySearch_kw (List<String> fuzzySearch_kw){
            this.fuzzySearch_kw = fuzzySearch_kw;
            return this;
        }

        public ConditionBuilder fuzzySearch_kw (String ... fuzzySearch_kw){
            this.fuzzySearch_kw = solveNullList(fuzzySearch_kw);
            return this;
        }

        public ConditionBuilder rightFuzzySearch_kw (List<String> rightFuzzySearch_kw){
            this.rightFuzzySearch_kw = rightFuzzySearch_kw;
            return this;
        }

        public ConditionBuilder rightFuzzySearch_kw (String ... rightFuzzySearch_kw){
            this.rightFuzzySearch_kw = solveNullList(rightFuzzySearch_kw);
            return this;
        }

        public ConditionBuilder search_kwList(String ... search_kw){
            this.search_kwList = solveNullList(search_kw);
            return this;
        }

        public ConditionBuilder search_kwList(List<String> search_kw){
            this.search_kwList = search_kw;
            return this;
        }

        public ConditionBuilder tb_fromBetWeen(Integer tb_fromSt,Integer tb_fromEd){
            this.tb_fromSt = tb_fromSt;
            this.tb_fromEd = tb_fromEd;
            return this;
        }

        public ConditionBuilder tb_fromGreaterEqThan(Integer tb_fromSt){
            this.tb_fromSt = tb_fromSt;
            return this;
        }
        public ConditionBuilder tb_fromLessEqThan(Integer tb_fromEd){
            this.tb_fromEd = tb_fromEd;
            return this;
        }


        public ConditionBuilder tb_fromList(Integer ... tb_from){
            this.tb_fromList = solveNullList(tb_from);
            return this;
        }

        public ConditionBuilder tb_fromList(List<Integer> tb_from){
            this.tb_fromList = tb_from;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private ShijiItem obj;

        public Builder(){
            this.obj = new ShijiItem();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder item_url(String item_url){
            this.obj.setItem_url(item_url);
            return this;
        }
        public Builder nick(String nick){
            this.obj.setNick(nick);
            return this;
        }
        public Builder num_iid(String num_iid){
            this.obj.setNum_iid(num_iid);
            return this;
        }
        public Builder pict_url(String pict_url){
            this.obj.setPict_url(pict_url);
            return this;
        }
        public Builder provcity(String provcity){
            this.obj.setProvcity(provcity);
            return this;
        }
        public Builder reserve_price(String reserve_price){
            this.obj.setReserve_price(reserve_price);
            return this;
        }
        public Builder seller_id(String seller_id){
            this.obj.setSeller_id(seller_id);
            return this;
        }
        public Builder small_images(String small_images){
            this.obj.setSmall_images(small_images);
            return this;
        }
        public Builder title(String title){
            this.obj.setTitle(title);
            return this;
        }
        public Builder user_type(Integer user_type){
            this.obj.setUser_type(user_type);
            return this;
        }
        public Builder volume(String volume){
            this.obj.setVolume(volume);
            return this;
        }
        public Builder zk_final_price(String zk_final_price){
            this.obj.setZk_final_price(zk_final_price);
            return this;
        }
        public Builder sales(Integer sales){
            this.obj.setSales(sales);
            return this;
        }
        public Builder sales_update_time(Long sales_update_time){
            this.obj.setSales_update_time(sales_update_time);
            return this;
        }
        public Builder create_time(Long create_time){
            this.obj.setCreate_time(create_time);
            return this;
        }
        public Builder status(Integer status){
            this.obj.setStatus(status);
            return this;
        }
        public Builder search_kw(String search_kw){
            this.obj.setSearch_kw(search_kw);
            return this;
        }
        public Builder tb_from(Integer tb_from){
            this.obj.setTb_from(tb_from);
            return this;
        }
        public ShijiItem build(){return obj;}
    }

}
