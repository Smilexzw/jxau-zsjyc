package cn.jxau.zsjyc;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import cn.jxau.zsjyc.util.WordToHtml;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("cn.jxau.zsjyc.mapper")
@ServletComponentScan
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10240MB");
        /// 总上传数据大小
        factory.setMaxRequestSize("10240MB");
        return factory.createMultipartConfig();
    }
}
