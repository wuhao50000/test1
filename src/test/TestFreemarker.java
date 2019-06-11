import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TestFreemarker {

    @Test
    public void test1() throws IOException, TemplateException {
        //1 创建Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2 设置模板文件所在的目录路径
        configuration.setDirectoryForTemplateLoading(new File("D:\\develop\\ideawork\\framepractice\\src\\main\\resources"));
        //3 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        //4 加载模板 创建模板对象
        Template template = configuration.getTemplate("test.ftl");
        //5 创建一个模板使用的数据集 通常为map 也可以是pojo
        HashMap map = new HashMap<>();
        map.put("name","以撒");
        map.put("message","nmsl");
        map.put("flag",false);
        //6 创建一个Writer对象 一般为FileWriter 指定生成的文件名
        FileWriter out = new FileWriter(new File("C:\\sina\\test1.html"));
        //7 调用模板对象的process方法输出文件
        template.process(map,out);
        //8 关闭流
        out.close();


    }

}
