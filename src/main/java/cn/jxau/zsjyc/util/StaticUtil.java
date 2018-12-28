package cn.jxau.zsjyc.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;


public class StaticUtil {
    public boolean toStatic(String prefix,String suffix){
        try{
            //构造模板
            ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
            resolver.setPrefix(prefix);
            resolver.setSuffix(suffix);
            TemplateEngine templateEngine=new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);
            //填充数据
            Context context=new Context();
            context.setVariable("","");

            FileWriter writer=new FileWriter("d://");
            templateEngine.process("1",context,writer);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
