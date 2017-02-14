import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Bot {
    private final String name;
    private final String author;
    private final int rating;
    private final int score;

    public Bot(String name, String author, int rating, int score) {
        this.rating = rating; // 注意这里的顺序,并非按参数顺序逐一调用
        this.score = score;
        this.name = name;
        this.author = author;
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Class<Bot> clazz = Bot.class;
        Constructor ctor = clazz.getConstructor(String.class, String.class, int.class, int.class);
        Parameter[] ctorParameters = ctor.getParameters();
        for (Parameter param: ctorParameters) {
            System.out.println(param.isNamePresent() + ":" + param.getName());
        }
    }
}




<!--<ScrollView-->
        <!--android:id="@+id/sv_car_item_detail"-->
        <!--android:layout_width="match_parent"-->
        <!--android:layout_height="match_parent"-->
        <!--android:layout_above="@id/ll_bottom_tabs"-->
        <!--android:layout_alignParentTop="true">-->

        <!--<LinearLayout-->
            <!--android:layout_width="match_parent"-->
            <!--android:layout_height="match_parent"-->
            <!--android:background="@color/app_white_ffffff"-->
            <!--android:orientation="vertical">-->

            <!--<cn.bingoogolapple.bgabanner.BGABanner-->
                <!--android:id="@+id/banner_detail"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="200dp"-->
                <!--app:banner_pointAutoPlayAble="false"-->
                <!--style="@style/BannerDefaultStyle"-->
                <!--app:banner_pointContainerBackground="#00000000"-->
                <!--app:banner_indicatorGravity="bottom|right"-->
                <!--app:banner_numberIndicatorTextColor="@color/white"-->
                <!--app:banner_numberIndicatorTextSize="@dimen/font_13sp"-->
                <!--app:banner_isNumberIndicator="true"-->
                <!--app:banner_isNeedShowIndicatorOnOnlyOnePage="true"-->
                <!--app:banner_numberIndicatorBackground="@drawable/cardetail_indicator_bg"-->
                <!--app:banner_transitionEffect="defaultEffect" />-->
            <!--&lt;!&ndash;app:banner_pointDrawable="@drawable/selector_banner_view_point"&ndash;&gt;-->
            <!--&lt;!&ndash;app:banner_pointContainerBackground="@android:color/transparent"&ndash;&gt;-->


            <!--<TextView-->
                <!--android:id="@+id/tv_car_name"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:layout_marginTop="14dp"-->
                <!--android:maxLines="1"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:textColor="@color/font_333"/>-->

            <!--<TextView-->
                <!--android:id="@+id/tv_car_type"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:layout_marginBottom="3dp"-->
                <!--android:ellipsize="end"-->
                <!--android:maxLines="1"-->
                <!--android:singleLine="true"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:textColor="@color/font_333"/>-->

            <!--<TextView-->
                <!--android:id="@+id/tv_date"-->
                <!--android:layout_width="wrap_content"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:textColor="@color/font_999"-->
                <!--android:layout_marginBottom="7dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:textSize="14sp"-->
                <!--/>-->

            <!--<include-->
                <!--android:id="@+id/direct_line_top"-->
                <!--layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/ll_car_source_direct_price"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_direct_price_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:maxLines="1"-->
                    <!--android:singleLine="true"-->
                    <!--android:text="@string/car_detail_direct_price"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_direct_price"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->

            <!--<include-->
                <!--android:id="@+id/direct_line_bottom"-->
                <!--layout="@layout/line_h_efefef"/>-->

            <!--<include layout="@layout/placee_holder_empty_gray"/>-->

            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/ll_car_source_color"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_color_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/car_detail_color"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_color"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:maxLines="1"-->
                    <!--android:singleLine="true"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->

            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/ll_car_source_price_policy"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_policy_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/car_detail_price_policy"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_policy"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->

            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_deal_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:maxLines="1"-->
                    <!--android:singleLine="true"-->
                    <!--android:text="@string/car_detail_price_deal"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_deal"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:textColor="@color/app_org_ff7206"/>-->

            <!--</LinearLayout>-->

            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_stats_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/car_detail_price_status"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_stats"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->



            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_get_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/publish_car_lift_area2"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_get"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->

            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_count_tip"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/car_detail_price_count"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_car_source_price_count"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->

            <!--<include layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/ll_optional_area"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="vertical">-->

                <!--<include layout="@layout/placee_holder_empty_gray"/>-->

                <!--<include layout="@layout/line_h_efefef"/>-->


                <!--<LinearLayout-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:orientation="horizontal"-->
                    <!--android:paddingBottom="11dp"-->
                    <!--android:paddingLeft="16dp"-->
                    <!--android:paddingRight="16dp"-->
                    <!--android:paddingTop="11dp">-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_car_source_sale_tip"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="3"-->
                        <!--android:ellipsize="end"-->
                        <!--android:maxLines="1"-->
                        <!--android:singleLine="true"-->
                        <!--android:text="@string/car_detail_sale_area"-->
                        <!--android:textColor="@color/app_gray_999999"/>-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_car_source_sale"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="1"-->
                        <!--android:ellipsize="end"-->
                        <!--android:maxLines="1"-->
                        <!--android:singleLine="true"-->
                        <!--android:textColor="@color/app_black_333333"/>-->

                <!--</LinearLayout>-->

                <!--<include layout="@layout/line_h_efefef"/>-->

                <!--<LinearLayout-->
                    <!--android:id="@+id/ll_car_bill_source"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:orientation="horizontal"-->
                    <!--android:paddingBottom="11dp"-->
                    <!--android:paddingLeft="16dp"-->
                    <!--android:paddingRight="16dp"-->
                    <!--android:paddingTop="11dp">-->

                    <!--<TextView-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="3"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:text="@string/car_detail_ticket_source"-->
                        <!--android:textColor="@color/app_gray_999999"/>-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_car_bill_source"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="1"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:textColor="@color/app_black_333333"/>-->

                <!--</LinearLayout>-->

                <!--<include layout="@layout/line_h_efefef"/>-->

                <!--<LinearLayout-->
                    <!--android:id="@+id/ll_car_bill_mode"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:orientation="horizontal"-->
                    <!--android:paddingBottom="11dp"-->
                    <!--android:paddingLeft="16dp"-->
                    <!--android:paddingRight="16dp"-->
                    <!--android:paddingTop="11dp">-->

                    <!--<TextView-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="3"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:text="@string/car_detail_ticket_open"-->
                        <!--android:textColor="@color/app_gray_999999"/>-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_car_bill_mode"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="1"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:textColor="@color/app_black_333333"/>-->

                <!--</LinearLayout>-->

                <!--<include layout="@layout/line_h_efefef"/>-->

                <!--<LinearLayout-->
                    <!--android:id="@+id/ll_car_procedure_situation"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:orientation="horizontal"-->
                    <!--android:paddingBottom="11dp"-->
                    <!--android:paddingLeft="16dp"-->
                    <!--android:paddingRight="16dp"-->
                    <!--android:paddingTop="11dp">-->

                    <!--<TextView-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="3"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:text="@string/car_detail_procedure"-->
                        <!--android:textColor="@color/app_gray_999999"/>-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_car_procedure_situation"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="1"-->
                        <!--android:singleLine="true"-->
                        <!--android:ellipsize="end"-->
                        <!--android:maxLines="1"-->
                        <!--android:textColor="@color/app_black_333333"/>-->

                <!--</LinearLayout>-->

                <!--<include layout="@layout/line_h_efefef"/>-->

                <!--<LinearLayout-->
                    <!--android:id="@+id/ll_car_production_date"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:orientation="horizontal"-->
                    <!--android:paddingBottom="11dp"-->
                    <!--android:paddingLeft="16dp"-->
                    <!--android:paddingRight="16dp"-->
                    <!--android:paddingTop="11dp">-->

                    <!--<TextView-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="3"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:text="@string/car_detail_date"-->
                        <!--android:textColor="@color/app_gray_999999"/>-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_car_production_date"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="1"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:textColor="@color/app_black_333333"/>-->

                <!--</LinearLayout>-->

                <!--<include layout="@layout/line_h_efefef"/>-->

                <!--<LinearLayout-->
                    <!--android:id="@+id/ll_pub_lift_date"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:orientation="horizontal"-->
                    <!--android:paddingBottom="11dp"-->
                    <!--android:paddingLeft="16dp"-->
                    <!--android:paddingRight="16dp"-->
                    <!--android:paddingTop="11dp">-->

                    <!--<TextView-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="3"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:text="@string/will_order_lift_date"-->
                        <!--android:textColor="@color/app_gray_999999"/>-->

                    <!--<TextView-->
                        <!--android:id="@+id/tv_pub_lift_date"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="wrap_content"-->
                        <!--android:layout_gravity="center_vertical"-->
                        <!--android:layout_weight="1"-->
                        <!--android:ellipsize="end"-->
                        <!--android:singleLine="true"-->
                        <!--android:maxLines="1"-->
                        <!--android:textColor="@color/app_black_333333"/>-->

                <!--</LinearLayout>-->

                <!--<include layout="@layout/line_h_efefef"/>-->
            <!--</LinearLayout>-->

        <!--<LinearLayout-->
            <!--android:id="@+id/ll_vehicle_configuration"-->
            <!--android:layout_width="match_parent"-->
            <!--android:layout_height="wrap_content"-->
            <!--android:orientation="horizontal"-->
            <!--android:paddingBottom="11dp"-->
            <!--android:paddingLeft="16dp"-->
            <!--android:paddingRight="16dp"-->
            <!--android:paddingTop="11dp"-->
            <!--android:visibility="gone">-->

            <!--<TextView-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:layout_gravity="center_vertical"-->
                <!--android:layout_weight="3"-->
                <!--android:ellipsize="end"-->
                <!--android:maxLines="1"-->
                <!--android:singleLine="true"-->
                <!--android:text="@string/publish_car_vehicle_configuration"-->
                <!--android:textColor="@color/app_gray_999999"/>-->

            <!--<TextView-->
                <!--android:id="@+id/tv_vehicle_configuration"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:layout_gravity="center_vertical"-->
                <!--android:layout_weight="1"-->
                <!--android:ellipsize="end"-->
                <!--android:singleLine="true"-->
                <!--android:maxLength="1000"-->
                <!--android:textColor="@color/app_black_333333"/>-->
            <!--</LinearLayout>-->

            <!--<include layout="@layout/placee_holder_empty_gray"/>-->

            <!--<include-->
                <!--layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/ll_remarks"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/remarks"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<TextView-->
                    <!--android:id="@+id/tv_remarks"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="1"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLength="200"-->
                    <!--android:textColor="@color/app_black_333333"/>-->

            <!--</LinearLayout>-->

            <!--<include-->
                <!--layout="@layout/line_h_efefef"/>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/ll_img_list"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:orientation="horizontal"-->
                <!--android:paddingBottom="11dp"-->
                <!--android:paddingLeft="16dp"-->
                <!--android:paddingRight="16dp"-->
                <!--android:paddingTop="11dp">-->

                <!--<TextView-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_gravity="center_vertical"-->
                    <!--android:layout_weight="3"-->
                    <!--android:ellipsize="end"-->
                    <!--android:singleLine="true"-->
                    <!--android:maxLines="1"-->
                    <!--android:text="@string/car_detail_img"-->
                    <!--android:textColor="@color/app_gray_999999"/>-->

                <!--<LinearLayout-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="wrap_content"-->
                    <!--android:layout_weight="1">-->

                    <!--<android.support.v7.widget.RecyclerView-->
                        <!--android:id="@+id/rv_car_source_img_list"-->
                        <!--android:layout_width="wrap_content"-->
                        <!--android:layout_height="wrap_content">-->
                    <!--</android.support.v7.widget.RecyclerView>-->
                <!--</LinearLayout>-->
            <!--</LinearLayout>-->

            <!--<ViewStub-->
                <!--android:id="@+id/vs_bottom_layout"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:layout="@layout/viewstub_car_detail_note_img_business"/>-->

            <!--<ViewStub-->
                <!--android:id="@+id/vs_from_network"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="wrap_content"-->
                <!--android:layout="@layout/viewstub_car_detail_info_form_net"/>-->

        <!--</LinearLayout>-->
    <!--</ScrollView>-->
