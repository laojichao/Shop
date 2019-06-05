package com.glut.shop.bean;

import java.util.List;

/**
 * CategoryBean
 *
 * @author lao
 * @date 2019/6/4
 */
public class CategoryBean {

    /**
     * code : 0
     * data : [{"type":"category","dataList":[{"id":"1","desc":"夏季男士短袖t恤韩版修身立领POLO衫新款潮流半袖体恤男丅上衣薄","type":"product","title":"T恤","imgURL":"https://gd3.alicdn.com/imgextra/i1/2995722328/O1CN01tn4e5f1T4GYUdEz5E_!!2995722328.jpg_400x400.jpg","price":"129.00","linkType":"","linkParam":"","online_time":"","offline_time":""},{"id":"2","desc":"RC潮牌夏男士短袖衬衫七分韩版修身潮流立领帅气白色衬衣中袖寸衫","type":"product","title":"衬衫","imgURL":"https://gd1.alicdn.com/imgextra/i1/1893126530/O1CN01KDnVYK1y6moTnlarG_!!1893126530.jpg_400x400.jpg","price":"189.00","linkType":"","linkParam":"","online_time":"","offline_time":""},{"id":"3","desc":"男士休闲裤夏季薄款直筒宽松运动裤韩版潮流百搭纯棉修身长裤子男","type":"product","title":"休闲裤","imgURL":"https://gd1.alicdn.com/imgextra/i4/2998568473/O1CN01w5uIQj2CSgNPPLo3D_!!2998568473.jpg_400x400.jpg","price":"109.00","linkType":"","linkParam":"","online_time":"","offline_time":""},{"id":"4","desc":"黑色弹力牛仔裤男潮牌春夏款韩版修身小脚裤百搭休闲裤长裤子","type":"product","title":"牛仔裤","imgURL":"https://gd4.alicdn.com/imgextra/i2/0/O1CN011WTrUT24rAd39sa_!!0-item_pic.jpg_400x400.jpg","price":"119.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"5","desc":"夏季男士防晒衣服韩版潮流中长款风衣外套百搭超薄款大码透气上衣","type":"product","title":"外套","imgURL":"https://gd2.alicdn.com/imgextra/i1/0/O1CN01Ih3RDt1Rba9A61Yk1_!!0-item_pic.jpg_400x400.jpg","price":"219.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"6","desc":"日版 CHAMPION 刺绣小C LOGO 拉链卫衣 外套 C3-C119-810 米色","type":"product","title":"卫衣","imgURL":"https://gd1.alicdn.com/imgextra/i2/1091247010/O1CN01d9eAOI21ecwHqZ6oE_!!1091247010.jpg_400x400.jpg","price":"169.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"7","desc":"花花公子男装2019春秋季翻领风衣男中年商务休闲中长款外套爸爸装","type":"product","title":"风衣","imgURL":"https://gd3.alicdn.com/imgextra/i1/844894988/O1CN01oJXzYm1miY4TITRDN_!!844894988.jpg_400x400.jpg","price":"329.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"8","desc":"男士西服套装帅气韩版修身小西装一套大学生休闲结婚外套正装潮流","type":"product","title":"西装","imgURL":"https://gd3.alicdn.com/imgextra/i4/861873847/O1CN0186P4qW1eHyAEbiKvD_!!861873847.jpg_400x400.jpg","price":"359.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"9","desc":"男道春季新款美式休闲棒球服男士街头潮牌拼色印花飞行员夹克外套","type":"product","title":"棒球服","imgURL":"https://gd2.alicdn.com/imgextra/i3/0/O1CN01PhWImV2Cp7lX1LK6a_!!0-item_pic.jpg_400x400.jpg","price":"199.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"10","desc":"菠萝针提花撞色条纹纯棉 夏季男士休闲针织衫圆领短袖T恤衫半袖","type":"product","title":"针织衫","imgURL":"https://gd1.alicdn.com/imgextra/i1/46577731/O1CN01RZCK5P26yqV6tba37_!!46577731.jpg_400x400.jpg","price":"99.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"11","desc":"DreamMaker日系潮牌宽松束脚余文乐工装裤男潮流直筒百搭九分裤子","type":"product","title":"工装裤","imgURL":"https://gd1.alicdn.com/imgextra/i3/3331762418/O1CN01qrWSAK1TjUCXrgpnz_!!3331762418.jpg_400x400.jpg","price":"129.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"12","desc":"2019春夏新款 新版tb羊毛薄款红白蓝织带纽扣针织毛衣开衫","type":"product","title":"开衫","imgURL":"https://gd3.alicdn.com/imgextra/i3/3626053174/O1CN01pIBi2G1ZJjcfhved5_!!3626053174.jpg_400x400.jpg","price":"139.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"13","desc":"秋冬韩国ulzzang外套棒球服毛呢加厚学院风INS超火的棉衣棉服男女","type":"product","title":"棉衣","imgURL":"https://gd2.alicdn.com/imgextra/i3/2614702490/O1CN011UGSfz1csdEYTwf_!!2614702490.jpg_400x400.jpg","price":"259.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"14","desc":"绫致SELECTED思莱德男夏新连帽款羽绒服418412516","type":"product","title":"羽绒服","imgURL":"https://gd4.alicdn.com/imgextra/i2/1122110005/O1CN01s0p6E21BuKSezVNe5_!!1122110005.jpg_400x400.jpg","price":"529.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"15","desc":"夏季亚麻男士夹克中国风开衫唐装两件套青年休闲长裤套装汉服大码","type":"product","title":"唐装","imgURL":"https://gd2.alicdn.com/imgextra/i1/0/O1CN01lvt7oT1QAjIfhH5T7_!!0-item_pic.jpg_400x400.jpg","price":"89.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"男装","moreLinkType":"storeTags","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"},{"type":"category","dataList":[{"id":"16","desc":"『薇薇法代』MAJE 绣花蕾丝连衣裙中长款 19夏女装","type":"product","title":"连衣裙","imgURL":"https://gd2.alicdn.com/imgextra/i4/2576563806/O1CN01kv17uo1dzBxC5NqUM_!!2576563806.jpg_400x400.jpg","price":"149.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"17","desc":"日版冠军Champion短袖t恤女男潮牌纯棉宽松半袖19夏ins情侣打底衫","type":"product","title":"T恤","imgURL":"https://gd1.alicdn.com/imgextra/i4/61916025/O1CN01k6jDXh1uNUoGYtIV2_!!61916025.jpg_400x400.jpg","price":"109.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"18","desc":"白衬衫女长袖修身百搭显瘦休闲上衣女上班工作服夏天衣服女装批发","type":"product","title":"衬衫","imgURL":"https://gd1.alicdn.com/imgextra/i1/745777781/O1CN014ZdwMN27LkHkINpLY_!!745777781.jpg_400x400.jpg","price":"79.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"19","desc":"阔腿裤女夏2019高腰垂感薄款凉凉裤宽松显瘦坠感西装直筒拖地裤子","type":"product","title":"拖地裤","imgURL":"https://img.alicdn.com/imgextra/i2/159895889/O1CN01fyusxT1tNCxrFf0h5_!!159895889.jpg_400x400.jpg","price":"69.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"20","desc":"破洞牛仔短裤女2019新款外穿夏高腰显瘦宽松烟灰色百搭a字热裤潮","type":"product","title":"牛仔裤","imgURL":"https://gd2.alicdn.com/imgextra/i2/2747932740/O1CN014SP18v1W6xklCkyNk_!!2747932740.jpg_400x400.jpg","price":"79.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"21","desc":"JOLIMENT小西装气质款！肌理感修身棉麻西装外套女夏薄款亚麻西服","type":"product","title":"西装","imgURL":"https://gd1.alicdn.com/imgextra/i4/0/O1CN01cOvcLY1UacAG4Rehq_!!0-item_pic.jpg_400x400.jpg","price":"109.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"22","desc":"2019夏季新款条纹防晒衣女长袖中长款韩版百搭宽松薄款雪纺外套","type":"product","title":"短外套","imgURL":"https://gd3.alicdn.com/imgextra/i1/0/O1CN013P5r1y1GMxiRVLBiR_!!0-item_pic.jpg_400x400.jpg","price":"159.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"23","desc":"诗雨2019夏季新款chic个性百褶格子半身裙内部短裤a字高腰短裙女","type":"product","title":"半身裙","imgURL":"https://img.alicdn.com/imgextra/i1/62762127/O1CN01IG2F4F1RaCwpurCA4_!!62762127.jpg_400x400.jpg","price":"119.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"24","desc":"冰丝针织衫女防晒2019夏季新款宽松薄款水溶蕾丝空调衫女开衫外套","type":"product","title":"针织衫","imgURL":"https://gd1.alicdn.com/imgextra/i1/2901914701/O1CN01E9B9R61kb6QPfUNC0_!!2901914701.jpg_400x400.jpg","price":"129.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"25","desc":"FANNIU2019春夏 不一样的防晒衣 米灰撞色拼接轻薄长款真丝风衣女","type":"product","title":"风衣","imgURL":"https://gd4.alicdn.com/imgextra/i4/59159352/O1CN017sUWNI2IxGW1JsNAI_!!59159352.jpg_400x400.jpg","price":"149.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"26","desc":"坠感阔腿裤女夏薄款小个子宽松高腰显瘦扩腿裤垂感九分休闲宽腿裤","type":"product","title":"休闲裤","imgURL":"https://gd1.alicdn.com/imgextra/i1/1099026015/O1CN01xleafS1uIurtrdZab_!!1099026015.jpg_400x400.jpg","price":"139.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"27","desc":"秋冬纯棉套头连帽刺绣紫色两件套加绒卫衣显瘦休闲女运动套装绒衫","type":"product","title":"卫衣绒衫","imgURL":"https://gd2.alicdn.com/imgextra/i2/2563662418/O1CN01SokqZo1TjUCd6AtZk_!!2563662418.jpg_400x400.jpg","price":"129.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"28","desc":"韩国短袖蕾丝衫女2019夏季小清新超仙镂空大码半袖小衫衬衫上衣潮","type":"product","title":"蕾丝衫","imgURL":"https://gd3.alicdn.com/imgextra/i1/0/O1CN01zdNvK425YuSSHK3mz_!!0-item_pic.jpg_400x400.jpg","price":"89.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"29","desc":"港味复古chic吊带背心女夏外穿冰丝针织韩版挂脖式无袖露肩上衣","type":"product","title":"背心吊带","imgURL":"https://gd2.alicdn.com/imgextra/i4/2588288419/TB2RcC9pOCYBuNkHFCcXXcHtVXa_!!2588288419.jpg_400x400.jpg","price":"79.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"30","desc":"2018冬季新款韩版连帽面包羽绒棉服女衣服工装中长款外套棉袄女装","type":"product","title":"棉衣","imgURL":"https://gd2.alicdn.com/imgextra/i2/314679657/O1CN016qIR3I2LCxJsxKau9_!!314679657.jpg_400x400.jpg","price":"429.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"女装","moreLinkType":"topic","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"},{"type":"category","dataList":[{"id":"31","desc":"东大韩金蜂蜜柚子茶1000g*2瓶冲饮泡水喝的饮品商用水果茶酱原料","type":"product","title":"柚子茶","imgURL":"https://img.alicdn.com/imgextra/i2/2773155262/TB2_Hvlh_nI8KJjSszgXXc8ApXa_!!2773155262.jpg_430x430q90.jpg","price":"59.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"32","desc":"宁安堡宁夏枸杞子中宁正宗特级500g构杞茶苟杞红黑小袋装茶品","type":"product","title":"枸杞","imgURL":"https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i2/372438979/O1CN012GCQkAGI63E1h6D_!!372438979.jpg_430x430q90.jpg","price":"19.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"33","desc":"新土蜂蜜 天然 农家自产百花峰蜜纯 野生 共1000g","type":"product","title":"蜂蜜","imgURL":"https://img.alicdn.com/imgextra/i3/2094337257/O1CN01qhXNaj23TkkEixQDC_!!0-item_pic.jpg_430x430q90.jpg","price":"99.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"34","desc":"WINEBOSS 西班牙原装进口蜡封款红酒干红葡萄酒原瓶进口","type":"product","title":"红酒","imgURL":"https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i2/1657921350/O1CN011LqL9v2Mj0tWbf3_!!1657921350.jpg_430x430q90.jpg","price":"399.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"35","desc":"新鲜现摘妃子笑荔枝桂味糯米糍白糖罂水囊中华红应季水果","type":"product","title":"荔枝","imgURL":"https://img.alicdn.com/imgextra/i1/2200734988716/O1CN01mkgyvs2EFydIjGeWz_!!0-item_pic.jpg_430x430q90.jpg","price":"69.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"36","desc":"顾一大芒果新鲜金煌芒果大青芒水仙芒果水果批发","type":"product","title":"芒果","imgURL":"https://img.alicdn.com/imgextra/i2/3529747702/O1CN01ZQxBeK26lZ0qWLH0m_!!3529747702.jpg_430x430q90.jpg","price":"79.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"37","desc":"暖餐麻辣小龙虾熟食十三香即食香辣味鲜活","type":"product","title":"小龙虾","imgURL":"https://img.alicdn.com/imgextra/i4/2200734241584/O1CN014H2Yup1NZVsz0hVik_!!2200734241584.jpg_430x430q90.jpg","price":"109.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"38","desc":"现货烟台大樱桃新鲜水果山东黄水晶樱桃","type":"product","title":"樱桃","imgURL":"https://img.alicdn.com/imgextra/i3/2242023855/O1CN013PCxGG1eLdLhZoVju_!!2242023855.jpg_430x430q90.jpg","price":"89.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"39","desc":"澳嘉厚切澳洲安格斯谷饲200天M3+级西冷牛排6片1200g新鲜原切健身","type":"product","title":"牛排","imgURL":"https://img.alicdn.com/imgextra/i2/3588033281/O1CN01aqr2x51a6k1RvTUPn_!!0-item_pic.jpg_430x430q90.jpg","price":"99.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"40","desc":"荣锦本味草木灰咸鸭蛋正宗老味道鲜香流油拌饭佐粥佳品","type":"product","title":"咸鸭蛋","imgURL":"https://img.alicdn.com/imgextra/i2/4044489357/O1CN01R0S90T2IzYW5zGZJQ_!!4044489357.jpg_430x430q90.jpg","price":"59.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"41","desc":"泰国进口山竹新鲜热带水果当季批发","type":"product","title":"山竹","imgURL":"https://img.alicdn.com/imgextra/i4/3015214310/O1CN01xdmUq61hi1XCC0Mgy_!!3015214310.jpg_430x430q90.jpg","price":"39.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"42","desc":"蒙时代超干手撕风干牛肉干 内蒙古正宗小零食特产","type":"product","title":"牛肉干","imgURL":"https://img.alicdn.com/imgextra/i2/3201604836/O1CN014JCGU21lavu1Kzua3_!!3201604836.jpg_430x430q90.jpg","price":"39.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"43","desc":"好利来半熟芝士蛋糕双味2盒甜品糕点点心小蛋糕面包早餐网红零食","type":"product","title":"小蛋糕","imgURL":"https://img.alicdn.com/imgextra/i4/2455221099/O1CN01zQunQS1JzNnS86sI8_!!2455221099.jpg_430x430q90.jpg","price":"29.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"44","desc":"良品铺子抹茶夹心饼干抹茶味曲奇饼干网红零食品","type":"product","title":"饼干","imgURL":"https://img.alicdn.com/imgextra/i4/619123122/O1CN01BqBLVt1Yvv01SXvgo_!!619123122.jpg_430x430q90.jpg","price":"19.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"45","desc":"乐奈手工松露黑巧克力礼盒装喜糖果大礼包散装送女友（代可可脂）","type":"product","title":"糖果","imgURL":"https://img.alicdn.com/imgextra/i2/739302607/O1CN011V830jOg87pXDmR_!!739302607.jpg_430x430q90.jpg","price":"69.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"美食","moreLinkType":"","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"},{"type":"category","dataList":[{"id":"46","desc":"美国西屋无叶电风扇落地扇家用超静音立式摇头涡轮空气净化循环扇","type":"product","title":"风扇","imgURL":"https://gd4.alicdn.com/imgextra/i4/2940021413/O1CN013laUfR1MJC9uO43zy_!!2940021413.jpg_400x400.jpg","price":"229.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"47","desc":"苏泊尔SF40HC32智能电饭煲4L家用精铁球釜ih电磁加热饭锅3-5-6人","type":"product","title":"电饭煲","imgURL":"https://gd3.alicdn.com/imgextra/i3/755346638/O1CN017GyETX1yuFb5e63qW_!!755346638.jpg_400x400.jpg","price":"439.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"48","desc":"小米 米家空气净化器pro家用卧室室内办公智能氧吧除甲醛雾霾粉尘","type":"product","title":"空气净化器","imgURL":"https://img.alicdn.com/imgextra/i3/1714128138/O1CN0129zFeqdwDOXOQXN_!!1714128138.jpg_430x430q90.jpg","price":"599.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"49","desc":"米家小米扫地机器人1S家用全自动扫地机无线智能超薄清洁吸尘器","type":"product","title":"扫地机器人","imgURL":"https://gd2.alicdn.com/imgextra/i2/719244293/O1CN01rgzjQ01haEpDyYKuY_!!719244293.jpg_400x400.jpg","price":"1099.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"50","desc":"吉谷快速壶家用全自动电热水壶烧水壶恒温带上水自动断电304不锈","type":"product","title":"热水壶","imgURL":"https://gd3.alicdn.com/imgextra/i3/880663122/TB2vkTMG7OWBuNjSsppXXXPgpXa_!!880663122.jpg_400x400.jpg","price":"329.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"51","desc":"美式咖啡机家用全自动小型滴漏式迷你煮咖啡泡茶一体现磨冰咖啡壶","type":"product","title":"咖啡机","imgURL":"https://gd1.alicdn.com/imgextra/i1/17424695/TB2rCELsYtlpuFjSspfXXXLUpXa_!!17424695.jpg_400x400.jpg","price":"459.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"52","desc":"美的电磁炉家用智能大功率全自动炒菜节能电池炉正品官方旗舰","type":"product","title":"电磁炉","imgURL":"https://img.alicdn.com/imgextra/i4/2973966816/O1CN01Vbkkpd20Dm7NuZjDV_!!2973966816.jpg_430x430q90.jpg","price":"519.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"53","desc":"红心渣分离榨汁机家用全自动果蔬多功能原汁机小型炸水果汁机低速","type":"product","title":"榨汁机","imgURL":"https://gd4.alicdn.com/imgextra/i4/37256907/O1CN01WiS9j520tS6N9WsTj_!!37256907.jpg_400x400.jpg","price":"279.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"54","desc":"小米智能除湿机家用卧室抽湿除潮吸湿器地下室工业大功率小型干燥","type":"product","title":"除湿机","imgURL":"https://img.alicdn.com/imgextra/i3/134708044/O1CN0129ICQ89u0lVAEzJ_!!134708044.jpg_400x400.jpg","price":"469.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"55","desc":"美国惠而浦无线吸尘器家用小型强力大吸力手持推杆超静音充电车载","type":"product","title":"吸尘器","imgURL":"https://img.alicdn.com/imgextra/i4/3504156152/O1CN01zCAPCX1vJf6TlqKOo_!!3504156152.jpg_400x400.jpg","price":"329.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"家电","moreLinkType":"","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"},{"type":"category","dataList":[{"id":"56","desc":"组装电脑台式全套主机高配电竞i7直播整机家用水冷组装游戏型","type":"product","title":"主机","imgURL":"https://img.alicdn.com/imgextra/i3/185268682/O1CN01fzsKYx2E0PAhfxPk7_!!185268682.jpg_400x400.jpg","price":"4999.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"57","desc":"Xiaomi/小米 小米平板4 Plus大屏安卓超薄智能电脑4G商务办公","type":"product","title":"平板电脑","imgURL":"https://img.alicdn.com/imgextra/i1/1714128138/TB2D3caoFkoBKNjSZFkXXb4tFXa_!!1714128138.jpg_430x430q90.jpg","price":"2399.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"58","desc":"国行现货Sony/索尼 A6400L套机16-50镜头高清微单反数码相机a6300","type":"product","title":"数码相机","imgURL":"https://gd1.alicdn.com/imgextra/i1/103209408/O1CN01ZosemZ2JMuidkUxDV_!!103209408.jpg_400x400.jpg","price":"9999.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"59","desc":"罗技M558 无线支持蓝牙4.0鼠标笔记本电脑","type":"product","title":"鼠标","imgURL":"https://gd4.alicdn.com/imgextra/i4/2559268090/TB2XVZdXn0ATuJjSZFEXXap2FXa_!!2559268090.jpg_400x400.jpg","price":"129.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"60","desc":"G610电竞游戏吃鸡机械键盘红轴背光绝地求生神器 电脑通用104按键","type":"product","title":"机械键盘","imgURL":"https://gd2.alicdn.com/imgextra/i2/4141478813/O1CN012EyOzTGR5qsj0DL_!!4141478813.jpg_400x400.jpg","price":"429.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"61","desc":"ThinkPad X1 Carbon 09CD /25CD 英特尔酷睿i5 超薄笔记本 14英寸超极本 商务办公 便携手提笔记本电脑联想","type":"product","title":"ThinkPad笔记本","imgURL":"https://img.alicdn.com/imgextra/i4/2955374408/O1CN018rFR7X1iQuOOC13cT_!!2955374408.jpg_430x430q90.jpg","price":"10899.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"62","desc":"HP/惠普游戏本 英特尔酷睿i5 光影精灵4代暗影精灵暗夜游戏笔记本电脑旗舰店1050Ti 15.6英寸可选144Hz电竞屏","type":"product","title":"惠普笔记本","imgURL":"https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i2/133668489/O1CN01dEbgiR2Ca0jKMLTNB_!!133668489.jpg_430x430q90.jpg","price":"6899.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"63","desc":"2018新款 Apple/苹果 MacBook Air 八代i5 256G 轻薄便携笔记本电脑","type":"product","title":"Macbook","imgURL":"https://img.alicdn.com/imgextra/i1/2616970884/O1CN01S9dgJi1IOuejArZFs_!!2616970884.jpg_430x430q90.jpg","price":"13599.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"64","desc":"Huawei/华为 MateBook D MRC-W60 2018款i7轻薄便携独显15.6英寸学生商务办公游戏笔记本电脑","type":"product","title":"华为笔记本","imgURL":"https://img.alicdn.com/imgextra/i3/2838892713/TB2O5DMjwLD8KJjSszeXXaGRpXa_!!2838892713.jpg_430x430q90.jpg","price":"7799.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"65","desc":"Xiaomi/小米 笔记本Pro 15.6英寸2019新款 轻薄便携学生游戏电脑 官方旗舰店正品独显超薄","type":"product","title":"小米笔记本","imgURL":"https://img.alicdn.com/imgextra/i4/1714128138/O1CN01fmvLYN29zFiKCjWxU_!!1714128138.jpg_430x430q90.jpg","price":"6899.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"数码","moreLinkType":"","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"},{"type":"category","dataList":[{"id":"66","desc":"Xiaomi/小米小米9骁龙855全面屏索尼4800万拍照游戏手机官方旗舰","type":"product","title":"MI","imgURL":"https://img.alicdn.com/imgextra/i5/TB1d4D5HQzoK1RjSZFlDP9i4VXa_121840.jpg_430x430q90.jpg","price":"2999.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"67","desc":"Huawei/华为 P30全面屏超感光徕卡三摄变焦双景录像980芯片智能手机p30","type":"product","title":"HUAWEI","imgURL":"https://img.alicdn.com/imgextra/i5/TB1trAMNQPoK1RjSZKb.LB1IXXa_101123.jpg_430x430q90.jpg","price":"5499.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"68","desc":"Apple/苹果 iPhone Xs Max 256G 全网通4G手机 双卡双待苹果iphonexsmax","type":"product","title":"iPhone","imgURL":"https://img.alicdn.com/imgextra/i4/TB1Lni1DMHqK1RjSZFEfUoGMXXa_043627.jpg_430x430q90.jpg","price":"8799.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"69","desc":"华为HONOR荣耀20全面屏超广角AI四摄麒麟980芯片智能手机正品官方旗舰PRO手机","type":"product","title":"HONOR","imgURL":"https://img.alicdn.com/imgextra/i1/1114511827/O1CN01Xv2cEH1PMo8sSnCR8_!!1114511827.jpg_430x430q90.jpg","price":"2199.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"70","desc":"nubia/努比亚 X 双屏全网通大内存游戏智能美颜拍照大屏手机","type":"product","title":"Nubia","imgURL":"https://img.alicdn.com/imgextra/i3/1677335387/O1CN011pfI4sAMtak8u3X_!!1677335387.jpg_430x430q90.jpg","price":"1899.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"71","desc":"一加7Pro手机全新正品OnePlus7pro 骁龙855 一加七 6t 1+7T 一加7手机官方旗舰店官网 一加7pro","type":"product","title":"OnePlus","imgURL":"https://img.alicdn.com/imgextra/i2/2432146763/O1CN01udgGPB1zpV7ZrN0Z4_!!2432146763.jpg_430x430q90.jpg","price":"3299.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"72","desc":"Meizu/魅族 16th Plus 旗舰智能手机","type":"product","title":"Meizu","imgURL":"https://img.alicdn.com/imgextra/i4/1695308781/TB2dIbeBvuSBuNkHFqDXXXfhVXa_!!1695308781.jpg_430x430q90.jpg","price":"2299.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"手机","moreLinkType":"storeTags","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"},{"type":"category","dataList":[{"id":"73","desc":"SPALDING官方旗舰店NBA掌控比赛用球室内室外PU篮球7号球74-604Y","type":"product","title":"篮球","imgURL":"https://img.alicdn.com/imgextra/i2/394694533/O1CN018DZsum1jM9tpBaPoC_!!0-item_pic.jpg_430x430q90.jpg","price":"329.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"74","desc":"Nike 耐克官方NIKE STRIKE PRO TEAM 足球SC3937","type":"product","title":"足球","imgURL":"https://img.alicdn.com/imgextra/i1/890482188/O1CN01tDteiS1S296Lb0LbW_!!890482188.jpg_430x430q90.jpg","price":"439.00","linkType":"userId","linkParam":"","online_time":"","offline_time":""},{"id":"75","desc":"国家队官网正品李宁羽毛球拍单拍 风刃900/风动7000i/风动9000C/D","type":"product","title":"羽毛球拍","imgURL":"https://img.alicdn.com/imgextra/i4/2248091262/O1CN01nSTkza1LC2MhWMcL7_!!2248091262.jpg_430x430q90.jpg","price":"569.00","linkType":"channelId","linkParam":"","online_time":"","offline_time":""},{"id":"76","desc":"蝴蝶乒乓球拍日本正品蝴蝶王8星单拍1只碳素底板八星进攻型成品拍","type":"product","title":"乒乓球拍","imgURL":"https://img.alicdn.com/imgextra/i1/690161050/TB2hZrsvY9YBuNjy0FgXXcxcXXa_!!690161050.jpg_430x430q90.jpg","price":"459.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"77","desc":"babolat百宝力pd李娜碳素网球拍pure drive专业男女单人套装单拍","type":"product","title":"网球拍","imgURL":"https://img.alicdn.com/imgextra/i4/818395603/O1CN01gLo47d1rGDfzuyYdZ_!!818395603.jpg_430x430q90.jpg","price":"399.00","linkParam":"","online_time":"","offline_time":""},{"id":"78","desc":"美洲豹毒药3D系列台球杆正品九球杆大头杆黑八中式八球美式台球杆","type":"product","title":"台球杆","imgURL":"https://img.alicdn.com/imgextra/TB1YhmSvY5YBuNjSspoL6TeNFXa_430x430q90.jpg","price":"279.00","linkType":"channelId","linkParam":"","online_time":"","offline_time":""},{"id":"79","desc":"哑铃男士健身器材家用20kg30公斤特价杠铃一对练臂肌可调节","type":"product","title":"哑铃","imgURL":"https://img.alicdn.com/imgextra/i3/1842780198/O1CN01xF9tLv1DKiuRMKtY5_!!0-item_pic.jpg_430x430q90.jpg","price":"99.00","linkType":"channelId","linkParam":"","online_time":"","offline_time":""},{"id":"80","desc":"李宁5号排球正品软中学生室内训练比赛大学生中考体育专用排球","type":"product","title":"排球","imgURL":"https://img.alicdn.com/imgextra/i4/352183601/TB2S1JegiFTMKJjSZFAXXckJpXa_!!352183601.jpg_430x430q90.jpg","price":"59.00","linkType":"userId","linkParam":"","online_time":"","offline_time":""},{"id":"81","desc":"迪卡侬棒球棒棒球棍儿童青少年成人铝合金实木训练专业比赛Base","type":"product","title":"棒球棍","imgURL":"https://img.alicdn.com/imgextra/i3/352469034/O1CN01LIHfQH2GbcYhrgIcb_!!352469034.jpg_430x430q90.jpg","price":"39.00","linkType":"channelId","linkParam":"","online_time":"","offline_time":""},{"id":"82","desc":"拳击沙袋散打立式家用不倒翁成人健身沙包儿童吊式跆拳道训练器材","type":"product","title":"沙袋","imgURL":"https://img.alicdn.com/imgextra/i2/3333316467/O1CN01cN1ayL1xdvqfrCFct_!!3333316467.jpg_430x430q90.jpg","price":"229.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"83","desc":"家用单杠室内引体向上器家庭单双杠儿童吊杆单杆体育运动健身器材","type":"product","title":"家用单杠","imgURL":"https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/1658621812/O1CN01UfgT501PFwCeD5Pzl_!!1658621812.jpg_430x430q90.jpg","price":"739.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"84","desc":"Keep智能跑步机专业家用款室内健身专用小型多功能静音走步机加宽","type":"product","title":"跑步机","imgURL":"https://img.alicdn.com/imgextra/i2/3619780669/O1CN01c71r9n1GoRRlLJqsI_!!3619780669.jpg_430x430q90.jpg","price":"2899.00","linkType":"channelId","linkParam":"","online_time":"","offline_time":""},{"id":"85","desc":"Keep健身垫加厚宽长双面专业TPE瑜伽垫体位线防滑初学者瑜珈男女","type":"product","title":"瑜伽垫","imgURL":"https://img.alicdn.com/imgextra/i3/3619780669/O1CN011GoRRL2mES62Ytk_!!3619780669.jpg_430x430q90.jpg","price":"89.00","linkType":"channelId","linkParam":"","online_time":"","offline_time":""}],"moreIcon":"","moreText":"","moduleStyle":"nothing","moduleTitle":"体育器材","moreLinkType":"storeTags","interfaceLink":"","moreLinkParam":"","moreTextDisplay":"true"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : category
         * dataList : [{"id":"1","desc":"夏季男士短袖t恤韩版修身立领POLO衫新款潮流半袖体恤男丅上衣薄","type":"product","title":"T恤","imgURL":"https://gd3.alicdn.com/imgextra/i1/2995722328/O1CN01tn4e5f1T4GYUdEz5E_!!2995722328.jpg_400x400.jpg","price":"129.00","linkType":"","linkParam":"","online_time":"","offline_time":""},{"id":"2","desc":"RC潮牌夏男士短袖衬衫七分韩版修身潮流立领帅气白色衬衣中袖寸衫","type":"product","title":"衬衫","imgURL":"https://gd1.alicdn.com/imgextra/i1/1893126530/O1CN01KDnVYK1y6moTnlarG_!!1893126530.jpg_400x400.jpg","price":"189.00","linkType":"","linkParam":"","online_time":"","offline_time":""},{"id":"3","desc":"男士休闲裤夏季薄款直筒宽松运动裤韩版潮流百搭纯棉修身长裤子男","type":"product","title":"休闲裤","imgURL":"https://gd1.alicdn.com/imgextra/i4/2998568473/O1CN01w5uIQj2CSgNPPLo3D_!!2998568473.jpg_400x400.jpg","price":"109.00","linkType":"","linkParam":"","online_time":"","offline_time":""},{"id":"4","desc":"黑色弹力牛仔裤男潮牌春夏款韩版修身小脚裤百搭休闲裤长裤子","type":"product","title":"牛仔裤","imgURL":"https://gd4.alicdn.com/imgextra/i2/0/O1CN011WTrUT24rAd39sa_!!0-item_pic.jpg_400x400.jpg","price":"119.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"5","desc":"夏季男士防晒衣服韩版潮流中长款风衣外套百搭超薄款大码透气上衣","type":"product","title":"外套","imgURL":"https://gd2.alicdn.com/imgextra/i1/0/O1CN01Ih3RDt1Rba9A61Yk1_!!0-item_pic.jpg_400x400.jpg","price":"219.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"6","desc":"日版 CHAMPION 刺绣小C LOGO 拉链卫衣 外套 C3-C119-810 米色","type":"product","title":"卫衣","imgURL":"https://gd1.alicdn.com/imgextra/i2/1091247010/O1CN01d9eAOI21ecwHqZ6oE_!!1091247010.jpg_400x400.jpg","price":"169.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"7","desc":"花花公子男装2019春秋季翻领风衣男中年商务休闲中长款外套爸爸装","type":"product","title":"风衣","imgURL":"https://gd3.alicdn.com/imgextra/i1/844894988/O1CN01oJXzYm1miY4TITRDN_!!844894988.jpg_400x400.jpg","price":"329.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"8","desc":"男士西服套装帅气韩版修身小西装一套大学生休闲结婚外套正装潮流","type":"product","title":"西装","imgURL":"https://gd3.alicdn.com/imgextra/i4/861873847/O1CN0186P4qW1eHyAEbiKvD_!!861873847.jpg_400x400.jpg","price":"359.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"9","desc":"男道春季新款美式休闲棒球服男士街头潮牌拼色印花飞行员夹克外套","type":"product","title":"棒球服","imgURL":"https://gd2.alicdn.com/imgextra/i3/0/O1CN01PhWImV2Cp7lX1LK6a_!!0-item_pic.jpg_400x400.jpg","price":"199.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"10","desc":"菠萝针提花撞色条纹纯棉 夏季男士休闲针织衫圆领短袖T恤衫半袖","type":"product","title":"针织衫","imgURL":"https://gd1.alicdn.com/imgextra/i1/46577731/O1CN01RZCK5P26yqV6tba37_!!46577731.jpg_400x400.jpg","price":"99.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"11","desc":"DreamMaker日系潮牌宽松束脚余文乐工装裤男潮流直筒百搭九分裤子","type":"product","title":"工装裤","imgURL":"https://gd1.alicdn.com/imgextra/i3/3331762418/O1CN01qrWSAK1TjUCXrgpnz_!!3331762418.jpg_400x400.jpg","price":"129.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"12","desc":"2019春夏新款 新版tb羊毛薄款红白蓝织带纽扣针织毛衣开衫","type":"product","title":"开衫","imgURL":"https://gd3.alicdn.com/imgextra/i3/3626053174/O1CN01pIBi2G1ZJjcfhved5_!!3626053174.jpg_400x400.jpg","price":"139.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"13","desc":"秋冬韩国ulzzang外套棒球服毛呢加厚学院风INS超火的棉衣棉服男女","type":"product","title":"棉衣","imgURL":"https://gd2.alicdn.com/imgextra/i3/2614702490/O1CN011UGSfz1csdEYTwf_!!2614702490.jpg_400x400.jpg","price":"259.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"14","desc":"绫致SELECTED思莱德男夏新连帽款羽绒服418412516","type":"product","title":"羽绒服","imgURL":"https://gd4.alicdn.com/imgextra/i2/1122110005/O1CN01s0p6E21BuKSezVNe5_!!1122110005.jpg_400x400.jpg","price":"529.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""},{"id":"15","desc":"夏季亚麻男士夹克中国风开衫唐装两件套青年休闲长裤套装汉服大码","type":"product","title":"唐装","imgURL":"https://gd2.alicdn.com/imgextra/i1/0/O1CN01lvt7oT1QAjIfhH5T7_!!0-item_pic.jpg_400x400.jpg","price":"89.00","linkType":"storeTags","linkParam":"","online_time":"","offline_time":""}]
         * moreIcon :
         * moreText :
         * moduleStyle : nothing
         * moduleTitle : 男装
         * moreLinkType : storeTags
         * interfaceLink :
         * moreLinkParam :
         * moreTextDisplay : true
         */

        private String type;
        private String moreIcon;
        private String moreText;
        private String moduleStyle;
        private String moduleTitle;
        private String moreLinkType;
        private String interfaceLink;
        private String moreLinkParam;
        private String moreTextDisplay;
        private List<DataListBean> dataList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMoreIcon() {
            return moreIcon;
        }

        public void setMoreIcon(String moreIcon) {
            this.moreIcon = moreIcon;
        }

        public String getMoreText() {
            return moreText;
        }

        public void setMoreText(String moreText) {
            this.moreText = moreText;
        }

        public String getModuleStyle() {
            return moduleStyle;
        }

        public void setModuleStyle(String moduleStyle) {
            this.moduleStyle = moduleStyle;
        }

        public String getModuleTitle() {
            return moduleTitle;
        }

        public void setModuleTitle(String moduleTitle) {
            this.moduleTitle = moduleTitle;
        }

        public String getMoreLinkType() {
            return moreLinkType;
        }

        public void setMoreLinkType(String moreLinkType) {
            this.moreLinkType = moreLinkType;
        }

        public String getInterfaceLink() {
            return interfaceLink;
        }

        public void setInterfaceLink(String interfaceLink) {
            this.interfaceLink = interfaceLink;
        }

        public String getMoreLinkParam() {
            return moreLinkParam;
        }

        public void setMoreLinkParam(String moreLinkParam) {
            this.moreLinkParam = moreLinkParam;
        }

        public String getMoreTextDisplay() {
            return moreTextDisplay;
        }

        public void setMoreTextDisplay(String moreTextDisplay) {
            this.moreTextDisplay = moreTextDisplay;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            /**
             * id : 1
             * desc : 夏季男士短袖t恤韩版修身立领POLO衫新款潮流半袖体恤男丅上衣薄
             * type : product
             * title : T恤
             * imgURL : https://gd3.alicdn.com/imgextra/i1/2995722328/O1CN01tn4e5f1T4GYUdEz5E_!!2995722328.jpg_400x400.jpg
             * price : 129.00
             * linkType :
             * linkParam :
             * online_time :
             * offline_time :
             */

            private String id;
            private String desc;
            private String type;
            private String title;
            private String imgURL;
            private String price;
            private String linkType;
            private String linkParam;
            private String online_time;
            private String offline_time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgURL() {
                return imgURL;
            }

            public void setImgURL(String imgURL) {
                this.imgURL = imgURL;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getLinkType() {
                return linkType;
            }

            public void setLinkType(String linkType) {
                this.linkType = linkType;
            }

            public String getLinkParam() {
                return linkParam;
            }

            public void setLinkParam(String linkParam) {
                this.linkParam = linkParam;
            }

            public String getOnline_time() {
                return online_time;
            }

            public void setOnline_time(String online_time) {
                this.online_time = online_time;
            }

            public String getOffline_time() {
                return offline_time;
            }

            public void setOffline_time(String offline_time) {
                this.offline_time = offline_time;
            }
        }
    }
}
