import com.itheima.solr.pojo.TbItem;
import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-solr.xml")
public class TestSolrTemplate {
    @Autowired
    private SolrTemplate solrTemplate;


    //添加测试
    @Test
    public void testAdd(){
        TbItem item = new TbItem();
        item.setId(1L);
        item.setTitle("Solr添加测试");
        item.setCategory("手机");
        item.setBrand("华为");
        item.setSeller("小米旗舰店");
        item.setGoodsId(1L);
        //item.setPrice(new BigDecimal(3000.01).setScale(2, BigDecimal.ROUND_HALF_UP));
        item.setPrice(new BigDecimal(3000.01));
        solrTemplate.saveBean(item);
        solrTemplate.commit();

    }
    //主键查询测试
    @Test
    public void testFind(){
        TbItem tbItem = solrTemplate.getById("1", TbItem.class);
        System.out.println(tbItem);
    }
    //主键删除测试
    @Test
    public void testDel(){
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }
    //大量数据添加
    @Test
    public void testAddList(){
        List<TbItem> list = new ArrayList<>();
        for(int i = 0;i<100;i++){
            TbItem item = new TbItem();
            item.setId(i+1L);
            item.setTitle("Solr添加测试"+i);
            item.setCategory("手机");
            item.setBrand("华为");
            item.setSeller("小米旗舰店");
            item.setGoodsId(1L);
            item.setPrice(new BigDecimal(2000+i));
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }
    //分页查询测试
   @Test
    public void testPageQuery(){
       Query query = new SimpleQuery("*:*");
       //开始索引 默认0
       query.setOffset(20);
       //每页记录数
       query.setRows(20);
       ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
       System.out.println("总记录数:"+page.getTotalElements());

       List<TbItem> list = page.getContent();
       for (TbItem item : list) {
           System.out.println(item);
       }
   }
    //分页条件查询测试
    @Test
    public void testPageQueryMutil(){
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_price").between(2005,2055);
        criteria = criteria.and("item_title").contains("2");
        query.addCriteria(criteria);
        //开始索引 默认0
//        query.setOffset(20);
        //每页记录数
//        query.setRows(20);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("总记录数:"+page.getTotalElements());

        List<TbItem> list = page.getContent();
        for (TbItem item : list) {
            System.out.println(item);
        }
    }
    //全部删除
    @Test
    public void testDelAll(){
        Query query = new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }

}
