package com.cocoa.taobao.product_server;

import com.cocoa.taobao.product_server.conf.RequestInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.cocoa.taobao.product_server.mapper")
public class ProductServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServerApplication.class, args);
	}

	//mvc控制器
	@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
		//增加拦截器
		public void addInterceptors(InterceptorRegistry registry){
			registry.addInterceptor(new RequestInterceptor())    //指定拦截器类
					.addPathPatterns("/**");        //指定该类拦截的url
		}
	}

}
