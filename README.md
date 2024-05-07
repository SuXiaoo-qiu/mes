1.目前代码拉下来就可以运行 

2.该项目是基于springboot 开发的mes系统

3.使用到的技术 springboot + mybatis + mybatisPlus + mysql + redis + rabbitmq + jwt 
          前端:vue3+ts

4.实现功能:
          按照功能分类：MES系统可以根据其功能的不同进行分类，如生产调度、生产执行、质量管理、物料管理、设备管理等。
          生产计划排程：MES系统可以根据订单和库存情况，制定生产计划并分配给各个生产线，以确保生产过程的顺利进行。
          生产过程控制：MES系统可以监控生产过程中的各个环节，如物料投料、加工、装配、检验等，及时发现和纠正生产过程中的问题，确保生产过程的质量和效率。
          
          生产数据采集：MES系统可以收集生产过程中的各种数据，如物料消耗、工时、产量、质量等，用于分析和优化生产过程。
          
          生产质量管理：MES系统可以监控产品质量，及时发现和纠正生产过程中的质量问题，确保产品符合质量标准。
          
          生产报告和分析：MES系统可以生成各种生产报告和分析，如生产计划完成情况、生产效率、质量指标等，用于管理层决策和生产过程的优化。
          
          与其他系统集成：MES系统可以与企业其他系统进行集成，如ERP系统、SCADA系统等，实现信息共享和流程协同，提高企业整体效率和竞争力。
          
          订单管理：包括订单接收、订单处理、订单排产、订单跟踪等功能，用于保证生产计划的准确性和及时性。
          
          生产计划排程：包括生产计划制定、生产线分配、生产进度跟踪等功能，用于保证生产过程的顺利进行。
          
          物料管理：包括物料采购、物料入库、物料领用、物料消耗等功能，用于保证生产过程中物料的充足性和准确性。
          
          生产执行：包括生产过程控制、设备控制、质量控制、工艺参数控制等功能，用于确保生产过程的质量和效率。
          
          质量管理：包括质量检验、质量分析、质量控制等功能，用于确保产品符合质量标准。
          
          设备管理：包括设备维护、设备保养、设备故障报修等功能，用于保证设备的正常运行。
          
          数据采集和分析：包括生产数据采集、数据存储、数据分析、数据报表等功能，用于分析和优化生产过程。
          
          人员管理：包括员工考勤、员工培训、员工绩效考核等功能，用于管理和优化企业人力资源。
          
          报告和分析：包括生产报告、生产分析、生产决策支持等功能，用于帮助管理层做出决策。
          
          与其他系统集成：包括与ERP系统、SCADA系统、PLM系统等的集成，用于实现信息共享和流程协同。
            
          
          agv管理 充电 报表 等  后续还会整合硬件部分进行编程 (esp8266串口开发板)
            还会更新物流模块的   从生产到出入库 从合同 --订单 -- 生产 -- 工艺 -工序 -- 入库 -- 出库 -- 收款  ......

审批流
审批流是用于审核和批准请求或文档的一系列步骤，每个步骤需要一个人或多个人来审核和决策。审批流的核心在于待审信息的流动方式及决策过程，涉及申请者提供待审信息，相关审批人进行传递及处理，每个审批者基于自己的职责和权限对待审信息进行核对、判断（通过/驳回）及协商（反馈意见），直至抵达最高决策层进行取舍。审批流的重要性包括提高决策质量、提高工作效率、保证合规性、提高透明度等。12

审批流的构成要素包括流程模型（定义流程的步骤、规则和决策）、角色和权限（流程的执行者，定义不同角色和分配权限）、待审信息（需要审批的信息，如差旅申请、购买请求）、动作和流转（流程中的主要操作，如核对、判断、协商）、通知和跟踪（辅助操作，用于发送通知和跟踪流程进度）。

审批流的类型包括：

发起人：向审批流程中的相应审批人提交申请，并提供必要的信息和支持文件。
审批人：审批流程中的关键角色，负责审查、评估和决策提交的申请。
抄送人：在审批中被通知关于审批进展和结果的信息，但不直接参与决策和授权。
流程审批内容：展示最关键的审批字段，根据审批事项的不同，需要流转的内容也不同。
流程审批流设置：包括自主选定审批流程、串行流程审批（每一步按照特定顺序依次进行）、并行流程审批（不同步骤同时进行，不同审批人或团队同时参与的复杂审批事项）、条件触发流程审批（基于特定条件或规则进行自动触发的审批流程）。
此外，还有通知渠道（如站内消息通知、短信通知、微信消息等），用于通知审批相关方审批结果并促使相关方快速做出判断及响应。

根据合同生成订单-根据订单生成生产计划排程-根据生产计划排程进行下发agv 进行拉货 生产













基本信息

订单编号：唯一标识每个订单的编码
客户名称：订单的客户名称
订单日期：订单的创建日期
交货日期：订单的预计交货日期
订单类型：订单的类型，如生产订单、销售订单等
订单状态：订单的状态，如已创建、已审核、已排产、已生产、已完成等
产品信息id：
生产信息id：
物流信息id：
其他信息id：
备注：其他需要记录的订单信息

产品信息
产品编号：对应产品管理表中的产品编号
产品名称：产品的描述性名称
产品规格：产品的技术参数，如尺寸、重量、材质等
计量单位：产品的计量单位
订单数量：订单中该产品的数量
预计交货日期：该产品预计的交货日期
备注：其他需要记录的产品信息

生产信息
生产线编号：对应生产线管理表中的生产线编号
工艺路线：产品的生产工艺路线
生产计划：产品的生产计划
生产进度：产品的生产进度
质量检验：产品的质量检验记录
生产成本：产品的生产成本
备注：其他需要记录的生产信息

物流信息
发货方式：订单的运输方式
物流公司：订单的物流公司
运单号：订单的运单号
发货日期：订单的发货日期
到货日期：订单的预计到货日期
物流费用：订单的物流费用
备注：其他需要记录的物流信息
其他信息
销售人员：订单的销售人员
生产人员：订单的生产人员
质检人员：订单的质检人员
审核人员：订单的审核人员
附件：订单相关附件

大概写一下 代码持续更新中 ~~~~
