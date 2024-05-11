package com.worlds.mes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MesApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
   void testCh(){
                String input = "CREATE TABLE  customer_info        (\n" +
                        "        `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',\n" +
                        "    customer_id VARCHAR(255) NOT NULL COMMENT '唯一标识每个客户记录的编码',\n" +
                        "    customer_name VARCHAR(255) NOT NULL COMMENT '客户公司或组织的名称',\n" +
                        "    customer_type ENUM('原始设备制造商', '分销商', '零售商', '其他') NOT NULL COMMENT '客户类型',\n" +
                        "    industry VARCHAR(255) COMMENT '客户所在行业',\n" +
                        "    location TEXT COMMENT '客户位置（地址、城市、州、国家）',\n" +
                        "    contact_info TEXT COMMENT '客户联系信息（电话号码、电子邮件地址、网站）',\n" +
                        "    primary_contact_name VARCHAR(255) COMMENT '主要联系人姓名',\n" +
                        "    primary_contact_info TEXT COMMENT '主要联系人联系信息',\n" +
                        "    customer_status ENUM('活跃', '不活跃', '潜在') NOT NULL COMMENT '客户状态',\n" +
                        "    credit_terms TEXT COMMENT '客户信用条款',\n" +
                        "    payment_history TEXT COMMENT '客户付款历史记录',\n" +
                        "    sales_representative VARCHAR(255) COMMENT '分配给客户的销售代表',\n" +
                        " PRIMARY KEY (`id`)\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户信息表';\n";
                String output = input.replaceAll("[a-zA-Z0-9()_`]+", "");
                System.out.println(output); // 输出: " !"
        }
}
