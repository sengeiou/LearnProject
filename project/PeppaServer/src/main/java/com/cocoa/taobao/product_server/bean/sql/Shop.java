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
public class Shop implements Serializable {

    private static final long serialVersionUID = 1532961179897L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:0
    */
    private Integer shop_id;

    /**
    * 
    * isNullAble:0
    */
    private String title;

    /**
    * 
    * isNullAble:0
    */
    private String url;

    /**
    * 
    * isNullAble:0
    */
    private Integer total;

    /**
    * 
    * isNullAble:0
    */
    private String items;

    /**
    * 
    * isNullAble:0
    */
    private Long create_date;

    /**
    * 
    * isNullAble:0
    */
    private Integer status;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setShop_id(Integer shop_id){this.shop_id = shop_id;}

    public Integer getShop_id(){return this.shop_id;}

    public void setTitle(String title){this.title = title;}

    public String getTitle(){return this.title;}

    public void setUrl(String url){this.url = url;}

    public String getUrl(){return this.url;}

    public void setTotal(Integer total){this.total = total;}

    public Integer getTotal(){return this.total;}

    public void setItems(String items){this.items = items;}

    public String getItems(){return this.items;}

    public void setCreate_date(Long create_date){this.create_date = create_date;}

    public Long getCreate_date(){return this.create_date;}

    public void setStatus(Integer status){this.status = status;}

    public Integer getStatus(){return this.status;}
    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                "shop_id='" + shop_id + '\'' +
                "title='" + title + '\'' +
                "url='" + url + '\'' +
                "total='" + total + '\'' +
                "items='" + items + '\'' +
                "create_date='" + create_date + '\'' +
                "status='" + status + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Shop set;

        private ConditionBuilder where;

        public UpdateBuilder set(Shop set){
            this.set = set;
            return this;
        }

        public Shop getSet(){
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

    public static class QueryBuilder extends Shop{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> shop_idList;

        public List<Integer> getShop_idList(){return this.shop_idList;}

        private Integer shop_idSt;

        private Integer shop_idEd;

        public Integer getShop_idSt(){return this.shop_idSt;}

        public Integer getShop_idEd(){return this.shop_idEd;}

        private List<String> titleList;

        public List<String> getTitleList(){return this.titleList;}


        private List<String> fuzzyTitle;

        public List<String> getFuzzyTitle(){return this.fuzzyTitle;}

        private List<String> rightFuzzyTitle;

        public List<String> getRightFuzzyTitle(){return this.rightFuzzyTitle;}
        private List<String> urlList;

        public List<String> getUrlList(){return this.urlList;}


        private List<String> fuzzyUrl;

        public List<String> getFuzzyUrl(){return this.fuzzyUrl;}

        private List<String> rightFuzzyUrl;

        public List<String> getRightFuzzyUrl(){return this.rightFuzzyUrl;}
        private List<Integer> totalList;

        public List<Integer> getTotalList(){return this.totalList;}

        private Integer totalSt;

        private Integer totalEd;

        public Integer getTotalSt(){return this.totalSt;}

        public Integer getTotalEd(){return this.totalEd;}

        private List<String> itemsList;

        public List<String> getItemsList(){return this.itemsList;}


        private List<String> fuzzyItems;

        public List<String> getFuzzyItems(){return this.fuzzyItems;}

        private List<String> rightFuzzyItems;

        public List<String> getRightFuzzyItems(){return this.rightFuzzyItems;}
        private List<Long> create_dateList;

        public List<Long> getCreate_dateList(){return this.create_dateList;}

        private Long create_dateSt;

        private Long create_dateEd;

        public Long getCreate_dateSt(){return this.create_dateSt;}

        public Long getCreate_dateEd(){return this.create_dateEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
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

        public QueryBuilder shop_idBetWeen(Integer shop_idSt,Integer shop_idEd){
            this.shop_idSt = shop_idSt;
            this.shop_idEd = shop_idEd;
            return this;
        }

        public QueryBuilder shop_idGreaterEqThan(Integer shop_idSt){
            this.shop_idSt = shop_idSt;
            return this;
        }
        public QueryBuilder shop_idLessEqThan(Integer shop_idEd){
            this.shop_idEd = shop_idEd;
            return this;
        }


        public QueryBuilder shop_id(Integer shop_id){
            setShop_id(shop_id);
            return this;
        }

        public QueryBuilder shop_idList(Integer ... shop_id){
            this.shop_idList = solveNullList(shop_id);
            return this;
        }

        public QueryBuilder shop_idList(List<Integer> shop_id){
            this.shop_idList = shop_id;
            return this;
        }

        public QueryBuilder fetchShop_id(){
            setFetchFields("fetchFields","shop_id");
            return this;
        }

        public QueryBuilder excludeShop_id(){
            setFetchFields("excludeFields","shop_id");
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

        public QueryBuilder fuzzyUrl (List<String> fuzzyUrl){
            this.fuzzyUrl = fuzzyUrl;
            return this;
        }

        public QueryBuilder fuzzyUrl (String ... fuzzyUrl){
            this.fuzzyUrl = solveNullList(fuzzyUrl);
            return this;
        }

        public QueryBuilder rightFuzzyUrl (List<String> rightFuzzyUrl){
            this.rightFuzzyUrl = rightFuzzyUrl;
            return this;
        }

        public QueryBuilder rightFuzzyUrl (String ... rightFuzzyUrl){
            this.rightFuzzyUrl = solveNullList(rightFuzzyUrl);
            return this;
        }

        public QueryBuilder url(String url){
            setUrl(url);
            return this;
        }

        public QueryBuilder urlList(String ... url){
            this.urlList = solveNullList(url);
            return this;
        }

        public QueryBuilder urlList(List<String> url){
            this.urlList = url;
            return this;
        }

        public QueryBuilder fetchUrl(){
            setFetchFields("fetchFields","url");
            return this;
        }

        public QueryBuilder excludeUrl(){
            setFetchFields("excludeFields","url");
            return this;
        }

        public QueryBuilder totalBetWeen(Integer totalSt,Integer totalEd){
            this.totalSt = totalSt;
            this.totalEd = totalEd;
            return this;
        }

        public QueryBuilder totalGreaterEqThan(Integer totalSt){
            this.totalSt = totalSt;
            return this;
        }
        public QueryBuilder totalLessEqThan(Integer totalEd){
            this.totalEd = totalEd;
            return this;
        }


        public QueryBuilder total(Integer total){
            setTotal(total);
            return this;
        }

        public QueryBuilder totalList(Integer ... total){
            this.totalList = solveNullList(total);
            return this;
        }

        public QueryBuilder totalList(List<Integer> total){
            this.totalList = total;
            return this;
        }

        public QueryBuilder fetchTotal(){
            setFetchFields("fetchFields","total");
            return this;
        }

        public QueryBuilder excludeTotal(){
            setFetchFields("excludeFields","total");
            return this;
        }

        public QueryBuilder fuzzyItems (List<String> fuzzyItems){
            this.fuzzyItems = fuzzyItems;
            return this;
        }

        public QueryBuilder fuzzyItems (String ... fuzzyItems){
            this.fuzzyItems = solveNullList(fuzzyItems);
            return this;
        }

        public QueryBuilder rightFuzzyItems (List<String> rightFuzzyItems){
            this.rightFuzzyItems = rightFuzzyItems;
            return this;
        }

        public QueryBuilder rightFuzzyItems (String ... rightFuzzyItems){
            this.rightFuzzyItems = solveNullList(rightFuzzyItems);
            return this;
        }

        public QueryBuilder items(String items){
            setItems(items);
            return this;
        }

        public QueryBuilder itemsList(String ... items){
            this.itemsList = solveNullList(items);
            return this;
        }

        public QueryBuilder itemsList(List<String> items){
            this.itemsList = items;
            return this;
        }

        public QueryBuilder fetchItems(){
            setFetchFields("fetchFields","items");
            return this;
        }

        public QueryBuilder excludeItems(){
            setFetchFields("excludeFields","items");
            return this;
        }

        public QueryBuilder create_dateBetWeen(Long create_dateSt,Long create_dateEd){
            this.create_dateSt = create_dateSt;
            this.create_dateEd = create_dateEd;
            return this;
        }

        public QueryBuilder create_dateGreaterEqThan(Long create_dateSt){
            this.create_dateSt = create_dateSt;
            return this;
        }
        public QueryBuilder create_dateLessEqThan(Long create_dateEd){
            this.create_dateEd = create_dateEd;
            return this;
        }


        public QueryBuilder create_date(Long create_date){
            setCreate_date(create_date);
            return this;
        }

        public QueryBuilder create_dateList(Long ... create_date){
            this.create_dateList = solveNullList(create_date);
            return this;
        }

        public QueryBuilder create_dateList(List<Long> create_date){
            this.create_dateList = create_date;
            return this;
        }

        public QueryBuilder fetchCreate_date(){
            setFetchFields("fetchFields","create_date");
            return this;
        }

        public QueryBuilder excludeCreate_date(){
            setFetchFields("excludeFields","create_date");
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

        public Shop build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> shop_idList;

        public List<Integer> getShop_idList(){return this.shop_idList;}

        private Integer shop_idSt;

        private Integer shop_idEd;

        public Integer getShop_idSt(){return this.shop_idSt;}

        public Integer getShop_idEd(){return this.shop_idEd;}

        private List<String> titleList;

        public List<String> getTitleList(){return this.titleList;}


        private List<String> fuzzyTitle;

        public List<String> getFuzzyTitle(){return this.fuzzyTitle;}

        private List<String> rightFuzzyTitle;

        public List<String> getRightFuzzyTitle(){return this.rightFuzzyTitle;}
        private List<String> urlList;

        public List<String> getUrlList(){return this.urlList;}


        private List<String> fuzzyUrl;

        public List<String> getFuzzyUrl(){return this.fuzzyUrl;}

        private List<String> rightFuzzyUrl;

        public List<String> getRightFuzzyUrl(){return this.rightFuzzyUrl;}
        private List<Integer> totalList;

        public List<Integer> getTotalList(){return this.totalList;}

        private Integer totalSt;

        private Integer totalEd;

        public Integer getTotalSt(){return this.totalSt;}

        public Integer getTotalEd(){return this.totalEd;}

        private List<String> itemsList;

        public List<String> getItemsList(){return this.itemsList;}


        private List<String> fuzzyItems;

        public List<String> getFuzzyItems(){return this.fuzzyItems;}

        private List<String> rightFuzzyItems;

        public List<String> getRightFuzzyItems(){return this.rightFuzzyItems;}
        private List<Long> create_dateList;

        public List<Long> getCreate_dateList(){return this.create_dateList;}

        private Long create_dateSt;

        private Long create_dateEd;

        public Long getCreate_dateSt(){return this.create_dateSt;}

        public Long getCreate_dateEd(){return this.create_dateEd;}

        private List<Integer> statusList;

        public List<Integer> getStatusList(){return this.statusList;}

        private Integer statusSt;

        private Integer statusEd;

        public Integer getStatusSt(){return this.statusSt;}

        public Integer getStatusEd(){return this.statusEd;}


        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder shop_idBetWeen(Integer shop_idSt,Integer shop_idEd){
            this.shop_idSt = shop_idSt;
            this.shop_idEd = shop_idEd;
            return this;
        }

        public ConditionBuilder shop_idGreaterEqThan(Integer shop_idSt){
            this.shop_idSt = shop_idSt;
            return this;
        }
        public ConditionBuilder shop_idLessEqThan(Integer shop_idEd){
            this.shop_idEd = shop_idEd;
            return this;
        }


        public ConditionBuilder shop_idList(Integer ... shop_id){
            this.shop_idList = solveNullList(shop_id);
            return this;
        }

        public ConditionBuilder shop_idList(List<Integer> shop_id){
            this.shop_idList = shop_id;
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

        public ConditionBuilder fuzzyUrl (List<String> fuzzyUrl){
            this.fuzzyUrl = fuzzyUrl;
            return this;
        }

        public ConditionBuilder fuzzyUrl (String ... fuzzyUrl){
            this.fuzzyUrl = solveNullList(fuzzyUrl);
            return this;
        }

        public ConditionBuilder rightFuzzyUrl (List<String> rightFuzzyUrl){
            this.rightFuzzyUrl = rightFuzzyUrl;
            return this;
        }

        public ConditionBuilder rightFuzzyUrl (String ... rightFuzzyUrl){
            this.rightFuzzyUrl = solveNullList(rightFuzzyUrl);
            return this;
        }

        public ConditionBuilder urlList(String ... url){
            this.urlList = solveNullList(url);
            return this;
        }

        public ConditionBuilder urlList(List<String> url){
            this.urlList = url;
            return this;
        }

        public ConditionBuilder totalBetWeen(Integer totalSt,Integer totalEd){
            this.totalSt = totalSt;
            this.totalEd = totalEd;
            return this;
        }

        public ConditionBuilder totalGreaterEqThan(Integer totalSt){
            this.totalSt = totalSt;
            return this;
        }
        public ConditionBuilder totalLessEqThan(Integer totalEd){
            this.totalEd = totalEd;
            return this;
        }


        public ConditionBuilder totalList(Integer ... total){
            this.totalList = solveNullList(total);
            return this;
        }

        public ConditionBuilder totalList(List<Integer> total){
            this.totalList = total;
            return this;
        }

        public ConditionBuilder fuzzyItems (List<String> fuzzyItems){
            this.fuzzyItems = fuzzyItems;
            return this;
        }

        public ConditionBuilder fuzzyItems (String ... fuzzyItems){
            this.fuzzyItems = solveNullList(fuzzyItems);
            return this;
        }

        public ConditionBuilder rightFuzzyItems (List<String> rightFuzzyItems){
            this.rightFuzzyItems = rightFuzzyItems;
            return this;
        }

        public ConditionBuilder rightFuzzyItems (String ... rightFuzzyItems){
            this.rightFuzzyItems = solveNullList(rightFuzzyItems);
            return this;
        }

        public ConditionBuilder itemsList(String ... items){
            this.itemsList = solveNullList(items);
            return this;
        }

        public ConditionBuilder itemsList(List<String> items){
            this.itemsList = items;
            return this;
        }

        public ConditionBuilder create_dateBetWeen(Long create_dateSt,Long create_dateEd){
            this.create_dateSt = create_dateSt;
            this.create_dateEd = create_dateEd;
            return this;
        }

        public ConditionBuilder create_dateGreaterEqThan(Long create_dateSt){
            this.create_dateSt = create_dateSt;
            return this;
        }
        public ConditionBuilder create_dateLessEqThan(Long create_dateEd){
            this.create_dateEd = create_dateEd;
            return this;
        }


        public ConditionBuilder create_dateList(Long ... create_date){
            this.create_dateList = solveNullList(create_date);
            return this;
        }

        public ConditionBuilder create_dateList(List<Long> create_date){
            this.create_dateList = create_date;
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

        private Shop obj;

        public Builder(){
            this.obj = new Shop();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder shop_id(Integer shop_id){
            this.obj.setShop_id(shop_id);
            return this;
        }
        public Builder title(String title){
            this.obj.setTitle(title);
            return this;
        }
        public Builder url(String url){
            this.obj.setUrl(url);
            return this;
        }
        public Builder total(Integer total){
            this.obj.setTotal(total);
            return this;
        }
        public Builder items(String items){
            this.obj.setItems(items);
            return this;
        }
        public Builder create_date(Long create_date){
            this.obj.setCreate_date(create_date);
            return this;
        }
        public Builder status(Integer status){
            this.obj.setStatus(status);
            return this;
        }
        public Shop build(){return obj;}
    }

}
