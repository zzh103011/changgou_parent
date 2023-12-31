package com.itheima.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZJ
 */
@CanalEventListener
public class BusinessListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ListenPoint(schema = "changgou_business", table = {"tb_ad"})
    public void adUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.err.println("广告数据发生变化");

        //修改前数据
//        for(CanalEntry.Column column: rowData.getBeforeColumnsList()) {
//            System.out.println("修改前数据 列名 " + column.getName() + " value: " + column.getValue());
//            if(column.getName().equals("position")){
//                System.out.println("发送消息到mq  ad_update_queue:"+column.getValue());
//                rabbitTemplate.convertAndSend("","ad_update_queue",column.getValue());  //发送消息到mq
//                break;
//            }
//        }

        //修改后数据
        for(CanalEntry.Column column: rowData.getAfterColumnsList()) {
//            if(column.getName().equals("position")){
//                //监听到数据库变动直接调用get请求，更新数据
//                System.out.println("修改后的数据 列名" + column.getName() + " value: " + column.getValue());
//                String url = "http://8.136.15.64/ad_update?position=" + column.getValue();
//                HttpClient.doGet(url);
//                break;
//            }
            if(column.getName().equals("position")){
                System.out.println("发送消息到mq  ad_update_queue:"+column.getValue());
                rabbitTemplate.convertAndSend("","ad_update_queue",column.getValue());  //发送消息到mq
                break;
            }
        }
    }
}
