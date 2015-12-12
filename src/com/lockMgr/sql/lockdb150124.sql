/*
Navicat MySQL Data Transfer

Source Server         : 120.24.58.163
Source Server Version : 50095
Source Host           : 120.24.58.163:3306
Source Database       : lockdb

Target Server Type    : MYSQL
Target Server Version : 50095
File Encoding         : 65001

Date: 2015-01-24 15:02:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `verify` int(8) default NULL,
  `company` varchar(50) default NULL,
  `realName` varchar(20) default NULL,
  `address` varchar(100) default NULL,
  `tel` varchar(20) default NULL,
  `point_x` double default NULL,
  `point_y` double default NULL,
  `status` int(11) default '0',
  `image` varchar(200) default 'business.jpg',
  `userId` varchar(36) NOT NULL,
  `rating` int(11) default '0' COMMENT '等级：0，普通；1，优先；2，特级。',
  `type` int(8) NOT NULL default '0' COMMENT '0，批发商；1，零售商。',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('2431b4d1-caaa-4d6b-9f4a-099b03bd9a55', null, '是一家技术实力雄厚，凝聚了一大批高级研发人员集理念、设计、开发、生产、销售、及售后服务为一体的“晋亿”牌汽车油箱盖门锁总成，汽车点火开关总成的现代化管理专业制造企业。 公司一九九六年被一汽选为配套厂以来，以科技为依托，追求技术的突破，认真执行QS9000标准，还自发为一汽设计钥匙，并获得国家专利，公司还先后成为中国一汽集团，哈尔滨轻型工厂，中国一拖，广州羊城、彪马、正宇、英田、等国内知名汽车制造厂配套单位，公司除配套外，产品覆盖全国并销往中东、美洲、台湾等地区。 “诚信、勤奋、团结、求实、严细，服务”的晋亿人将不断创新，提供更加优良的品质、优质服务.', '2014-09-15 15:27:15', '1', '傲展电力科技有限公司', 'View', '江西省南昌市青山湖区', '76896546', '28.651559', '115.801278', '1', 'anzhandianli.jpg', '1', '1', '0');
INSERT INTO `business` VALUES ('2e428ddf-1b1e-4b27-b3e6-7491a682f492', 'aaa', 'aa	         ', '2015-01-23 17:55:33', '1', '91', '91', 'aa省aa市aa区aa', '91', '91', '91', '1', '', 'aaa', '0', '1');
INSERT INTO `business` VALUES ('2e72e37e-98c8-41f0-af61-313d7224c351', null, '是一家技术实力雄厚，凝聚了一大批高级研发人员集理念、设计、开发、生产、销售、及售后服务为一体的“晋亿”牌汽车油箱盖门锁总成，汽车点火开关总成的现代化管理专业制造企业。 公司一九九六年被一汽选为配套厂以来，以科技为依托，追求技术的突破，认真执行QS9000标准，还自发为一汽设计钥匙，并获得国家专利，公司还先后成为中国一汽集团，哈尔滨轻型工厂，中国一拖，广州羊城、彪马、正宇、英田、等国内知名汽车制造厂配套单位，公司除配套外，产品覆盖全国并销往中东、美洲、台湾等地区。 “诚信、勤奋、团结、求实、严细，服务”的晋亿人将不断创新，提供更加优良的品质、优质服务.', '2014-09-15 15:27:14', '1', '赛高阀门有限公司', 'Panle', '江西省南昌市青山湖区', '97674533', '28.641177', '115.8591', '1', 'saigao.jpg', '2', '2', '1');
INSERT INTO `business` VALUES ('31ad0d72-da34-4a03-8212-da4e13ca48f2', null, '金锁集团是一家技术实力雄厚，凝聚了一大批高级研发人员集理念、设计、开发、生产、销售、及售后服务为一体的“晋亿”牌汽车油箱盖门锁总成，汽车点火开关总成的现代化管理专业制造企业。 公司一九九六年被一汽选为配套厂以来，以科技为依托，追求技术的突破，认真执行QS9000标准，还自发为一汽设计钥匙，并获得国家专利，公司还先后成为中国一汽集团，哈尔滨轻型工厂，中国一拖，广州羊城、彪马、正宇、英田、等国内知名汽车制造厂配套单位，公司除配套外，产品覆盖全国并销往中东、美洲、台湾等地区。 “诚信、勤奋、团结、求实、严细，服务”的晋亿人将不断创新，提供更加优良的品质、优质服务.', '2014-09-01 15:45:54', '1', '金锁集团', '黄晓明', '江西省南昌市红谷滩区红谷中大道1234号', '13012341234', '28.661274', '115.809834', '1', 'jinsuo.jpg', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', '1');
INSERT INTO `business` VALUES ('3cbfbe55-7cb0-4cf7-8e60-9caeb0fe0486', null, '&nbsp;急开锁 修锁 换锁 超B级防盗锁芯 配汽车芯片钥匙 遥控器 汽车解码', '2015-01-21 00:49:57', '1', '0791锁业服务中心', '谭水龙', '江西省南昌市红谷滩新区区沁园路', '079188113113', '1154917', '284237', '1', '1501210027248.jpg', 'e0e0643a-93a8-4a1c-a41d-43f4a6f01a3e', '2', '0');
INSERT INTO `business` VALUES ('43fc907b-f38f-4951-8e98-eefbca5c791f', null, null, '2014-09-15 15:27:17', '1', '神弹五金机械有限公司', 'Jone', '江西省南昌市青山湖区', '43211234', '54.3', '154.2', '1', 'shendan.jpg', '3', '1', '0');
INSERT INTO `business` VALUES ('5b818d57-f102-4676-99ec-ec25c062dd24', null, '', '2014-09-15 15:27:17', '1', '纳声智能电子锁业有限公司', 'Orange', '江西省南昌市西湖区', '65342132', '28.671638', '115.818619', '1', 'nashen.jpg', '4', '2', '0');
INSERT INTO `business` VALUES ('67c9951c-3259-4c72-84d5-f1c1364b5c48', 'NinaXuYuan', '万山科技有限公司', '2015-01-23 18:14:21', '0', '南昌万山科技', 'NinaXuYuan', '江西省南昌市红谷滩区鼎峰中央', '15807006977', '125.55555', '28.55555', '0', '15012318130699.png', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '0', '1');
INSERT INTO `business` VALUES ('6a92ab4c-7634-4e72-b056-c01e1f009728', null, '', '2014-09-15 15:27:18', '1', '富宇五金制品有限公司', 'David', '江西省南昌市西湖区', '89745433', '28.649039', '115.819431', '1', 'fuyu.jpg', '5', '2', '0');
INSERT INTO `business` VALUES ('917303cd-c33a-4be4-928e-73ad4ec5a17e', 'liang', '简介就是没有', '2015-01-23 14:32:35', '1', '南昌万山科技', 'NinaXuYuan', '江西省南昌市红谷滩区鼎峰中央', '15807006977', '125.55555', '28.55555', '1', '15012314302022.png', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h', '0', '1');
INSERT INTO `business` VALUES ('a0868e14-ee02-4ff2-a680-e60f46cfde91', null, '', '2014-09-15 15:27:18', '1', '瓯海仙岩好达锁芯厂', 'King', '江西省南昌市青云谱区', '65347324', '28.636105', '115.804483', '1', 'ouhai.jpg', '7', '0', '0');
INSERT INTO `business` VALUES ('b7058ffa-523c-42b4-b41b-4f9e0616a43f', null, '', '2014-09-15 15:27:19', '1', '视点智能科技有限公司', 'Apple', '江西省南昌市青云谱区', '3256434', '28.654871', '115.817418', '1', 'shidian.jpg', '8', '0', '0');
INSERT INTO `business` VALUES ('c1a0c3e3-3b33-4935-a511-d16590b0f23d', null, '1', '2014-09-15 15:27:19', '1', '银锁集团', '黄小a', '江西省南昌市红谷滩区', '13043214321', '28.661274', '115.809834', '1', 'yinsuo.jpg', '7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', '1', '1');
INSERT INTO `business` VALUES ('c88ae76d-954f-4c08-b56a-20c40d366cf4', null, '', '2014-09-15 15:27:20', '1', '创安智能科技有限公司', 'Jonn', '江西省南昌市红谷滩区', '43564332', '28.709882', '115.84099', '1', 'chuangan.jpg', '10', '0', '0');
INSERT INTO `business` VALUES ('ce84c8f6-4f94-43ee-8ca8-d1640fcf2af9', null, '', '2014-09-15 15:27:20', '1', '伟英杰科技有限公司', 'Jone', '江西省南昌市红谷滩区', '34562345', '28.713937', '115.701573', '1', 'weiyingjie.jpg', '11', '2', '1');
INSERT INTO `business` VALUES ('dea5e1af-5550-4ac3-adef-638ef2c162a6', 'shuilong', '急开锁、换锁\r\n', '2015-01-11 23:17:50', '1', '0791锁业', '谭水龙', '江西省省南昌市市红谷滩区沁园路', '079188113113', '532', '134', '1', '1501112317450.jpg', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b', '0', '0');
INSERT INTO `business` VALUES ('f8da4d69-75c8-44a3-8f17-977ac1efced6', null, '', '2014-09-01 17:35:21', '1', 'user1', 'user1', '江西省南昌市红谷滩区', '11111111', '28.714951', '115.789822', '1', 'user1.jpg', '12', '2', '1');

-- ----------------------------
-- Table structure for businessoflifeservice
-- ----------------------------
DROP TABLE IF EXISTS `businessoflifeservice`;
CREATE TABLE `businessoflifeservice` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `userId` varchar(36) NOT NULL,
  `type` int(20) NOT NULL COMMENT '生活服务商家类型：1.家电维修;2.房屋维修;3.电脑维修;4.家居维修;5.手机维修;6.开锁换锁;7.管道疏通;8.搬家.',
  `company` varchar(45) NOT NULL,
  `phone` int(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of businessoflifeservice
-- ----------------------------
INSERT INTO `businessoflifeservice` VALUES ('fb1c1f5a-66ee-4606-8901-bf50c5e8bae8', null, null, '2014-12-29 16:19:55', 'haha', '1', 'ç¾åº¦', '110', 'chinabeijing', 'aaa');
INSERT INTO `businessoflifeservice` VALUES ('cff3bd66-1718-4248-abb4-ec4fef7564fc', null, null, '2014-12-29 16:24:32', 'haha', '1', 'ç¾åº¦', '110', 'chinabeijing', 'aaa');
INSERT INTO `businessoflifeservice` VALUES ('a55c2f20-bb93-4e1e-8836-20840b978843', null, null, '2014-12-29 16:27:18', 'haha', '1', 'ç¾åº¦', '110', 'chinabeijing', 'aaa');
INSERT INTO `businessoflifeservice` VALUES ('31e0ee0e-77fe-4396-8ec9-0266133da893', null, null, '2014-12-29 21:44:39', '', '1', '南昌家电', '135496659', '南京东路', '专业家电维修');
INSERT INTO `businessoflifeservice` VALUES ('a8fa8d57-317f-4cbc-8f60-90610bb764b3', null, null, '2015-01-21 00:09:04', 'e0e0643a-93a8-4a1c-a41d-43f4a6f01a3e', '6', '0791所以业服务中心', '0', '红谷滩沁圆路147号', '专业开锁，换超B级防盗门锁芯。配汽车遥控钥匙，汽车防盗解码。');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '1',
  `carName` varchar(45) NOT NULL,
  `carType` varchar(45) default NULL,
  `carLogo` varchar(45) default NULL,
  `image` varchar(200) default NULL,
  `carCountry` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('05ddd4bf-8072-4a97-a241-a2fc665d3604', null, null, '2015-01-21 01:06:14', '0', 'sss', null, null, null, '美洲车系');

-- ----------------------------
-- Table structure for carlogo
-- ----------------------------
DROP TABLE IF EXISTS `carlogo`;
CREATE TABLE `carlogo` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL default '0',
  `carName` varchar(45) NOT NULL,
  `carCountry` varchar(45) NOT NULL,
  `logo` varchar(45) default NULL,
  `logoImage` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carlogo
-- ----------------------------
INSERT INTO `carlogo` VALUES ('24ad1521-983e-429a-a3e0-20c3d032e16a', null, null, '2014-09-02 16:39:50', '0', '奔驰', '欧洲车系', null, 'file/carLogo/Benz.png');
INSERT INTO `carlogo` VALUES ('24ad1521-983e-429a-a3e0-20c3d032e16b', null, null, '2014-09-02 16:40:20', '0', '奥迪', '欧洲车系', null, 'file/carLogo/Audi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-983e-429a-a3e0-20c3d032e16c', null, null, '2014-09-02 16:39:31', '0', '宝马', '欧洲车系', 'BMW', 'file/carLogo/BMW.png');
INSERT INTO `carlogo` VALUES ('24ad1521-983e-429a-a3e0-20c3d032e16d', null, null, '2014-09-02 16:40:51', '0', '大众', '欧洲车系', null, 'file/carLogo/Volkswagen.png');
INSERT INTO `carlogo` VALUES ('24ad1521-983e-429a-a3e0-20c3d032e16f', null, null, '2014-08-25 15:42:11', '0', '红旗', '国产车系', null, 'file/carLogo/hongqi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-983e-429a-a3e0-20c3d032e16h', null, null, '2014-09-02 15:47:55', '0', '北京', '国产车系', null, 'file/carLogo/beijing.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16j', null, null, '2014-09-02 15:53:36', '0', '江南', '国产车系', null, 'file/carLogo/jiangnan.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16k', null, null, '2014-09-02 15:54:46', '0', '南汽', '国产车系', null, 'file/carLogo/nanqi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16l', null, null, '2014-09-02 16:05:47', '0', '理念', '国产车系', null, 'file/carLogo/linian.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16m', null, null, '2014-09-02 16:06:12', '0', '威麟', '国产车系', null, 'file/carLogo/weilin.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16n', null, null, '2014-09-02 16:06:24', '0', '开瑞', '国产车系', null, 'file/carLogo/kairui.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16o', null, null, '2014-09-02 16:06:36', '0', '全球鹰', '国产车系', null, 'file/carLogo/quanqiuying.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16p', null, null, '2014-09-02 16:06:46', '0', '黄海', '国产车系', null, 'file/carLogo/huanghai.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16q', null, null, '2014-09-02 16:06:52', '0', '九龙', '国产车系', null, 'file/carLogo/jiulong.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16r', null, null, '2014-09-02 16:07:01', '0', '瑞麒', '国产车系', null, 'file/carLogo/ruiqi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16s', null, null, '2014-09-02 16:07:12', '0', '江淮', '国产车系', null, 'file/carLogo/jianghuai.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16t', null, null, '2014-09-02 16:07:19', '0', '帝豪', '国产车系', null, 'file/carLogo/dihao.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16u', null, null, '2014-09-02 16:07:24', '0', '吉利', '国产车系', null, 'file/carLogo/jili.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16v', null, null, '2014-09-02 16:07:32', '0', '海马', '国产车系', null, 'file/carLogo/haima.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16w', null, null, '2014-09-02 16:07:38', '0', '东南', '国产车系', null, 'file/carLogo/dongnan.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16x', null, null, '2014-09-02 16:07:44', '0', '长丰', '国产车系', null, 'file/carLogo/changfeng.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16y', null, null, '2014-09-02 16:07:53', '0', '华泰', '国产车系', null, 'file/carLogo/huatai.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e16z', null, null, '2014-09-02 16:08:20', '0', '黑豹', '国产车系', null, 'file/carLogo/heibao.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17a', null, null, '2014-09-02 16:22:30', '0', '川汽野马', '国产车系', null, 'file/carLogo/chuangqiyema.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17b', null, null, '2014-09-02 16:22:41', '0', '解放', '国产车系', null, 'file/carLogo/jiefang.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17c', null, null, '2014-09-02 16:22:56', '0', '宝骏', '国产车系', null, 'file/carLogo/baojun.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17d', null, null, '2014-09-02 16:23:04', '0', '纳智捷', '国产车系', null, 'file/carLogo/nazhijie.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17e', null, null, '2014-09-02 16:23:10', '0', '威旺', '国产车系', null, 'file/carLogo/weiwang.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17f', null, null, '2014-09-02 16:23:16', '0', '吉林', '国产车系', null, 'file/carLogo/jilin.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17g', null, null, '2014-09-02 16:23:24', '0', '莲花', '国产车系', null, 'file/carLogo/lianghua.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17h', null, null, '2014-09-02 16:23:31', '0', '启辰', '国产车系', null, 'file/carLogo/qichen.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17i', null, null, '2014-09-02 16:24:43', '0', '长安', '国产车系', null, 'file/carLogo/changan2.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17j', null, null, '2014-09-02 16:25:54', '0', '海马郑州', '国产车系', null, 'file/carLogo/haimazhenzhou.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17k', null, null, '2014-09-02 16:29:14', '0', '东风风神', '国产车系', null, 'file/carLogo/dongfengfengshen.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17l', null, null, '2014-09-02 16:29:25', '0', '英伦汽车', '国产车系', null, 'file/carLogo/yinglun.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17m', null, null, '2014-09-02 16:29:40', '0', '厦门金龙', '国产车系', null, 'file/carLogo/jinlong.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17n', null, null, '2014-09-02 16:29:49', '0', '荣威', '国产车系', null, 'file/carLogo/rongwei.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17o', null, null, '2014-09-02 16:30:18', '0', '众泰', '国产车系', null, 'file/carLogo/zhongtai.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17p', null, null, '2014-09-02 16:30:32', '0', '奔腾', '国产车系', null, 'file/carLogo/bengteng.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17q', null, null, '2014-09-02 16:30:38', '0', '吉奥', '国产车系', null, 'file/carLogo/jiao.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17r', null, null, '2014-09-02 16:30:44', '0', '陆风', '国产车系', null, 'file/carLogo/lufeng.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17s', null, null, '2014-09-02 16:30:50', '0', '力帆', '国产车系', null, 'file/carLogo/lifan.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17t', null, null, '2014-09-02 16:30:59', '0', '一汽', '国产车系', null, 'file/carLogo/yiqi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17u', null, null, '2014-09-02 16:31:08', '0', '奇瑞', '国产车系', null, 'file/carLogo/qirui.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17v', null, null, '2014-09-02 16:31:15', '0', '广汽', '国产车系', null, 'file/carLogo/guangqi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17w', null, null, '2014-09-02 16:31:23', '0', '比亚迪', '国产车系', null, 'file/carLogo/biyadi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17x', null, null, '2014-09-02 16:31:35', '0', '依维柯', '国产车系', null, 'file/carLogo/yiweike.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17y', null, null, '2014-09-02 16:31:44', '0', '中兴', '国产车系', null, 'file/carLogo/zhongxing.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e17z', null, null, '2014-09-02 16:31:57', '0', '福迪', '国产车系', null, 'file/carLogo/fudi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18a', null, null, '2014-09-02 16:32:06', '0', '汇众', '国产车系', null, 'file/carLogo/huizhong.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18b', null, null, '2014-09-02 16:32:20', '0', '北汽', '国产车系', null, 'file/carLogo/beiqi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18c', null, null, '2014-09-02 16:32:36', '0', '庆铃', '国产车系', null, 'file/carLogo/qinglin.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18d', null, null, '2014-09-02 16:32:46', '0', '双环', '国产车系', null, 'file/carLogo/shuanghuan.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18e', null, null, '2014-09-02 16:32:54', '0', '五菱', '国产车系', null, 'file/carLogo/wuling.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18f', null, null, '2014-09-02 16:32:59', '0', '东风', '国产车系', null, 'file/carLogo/dongfeng.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18g', null, null, '2014-09-02 16:33:07', '0', '长城', '国产车系', null, 'file/carLogo/changcheng.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18h', null, null, '2014-09-02 16:33:12', '0', '中华', '国产车系', null, 'file/carLogo/zhonghua.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18i', null, null, '2014-09-02 16:33:26', '0', '江铃', '国产车系', null, 'file/carLogo/jiangling.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18j', null, null, '2014-09-02 16:33:34', '0', '金杯', '国产车系', null, 'file/carLogo/jinbei.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18k', null, null, '2014-09-02 16:33:46', '0', '哈飞', '国产车系', null, 'file/carLogo/hafei.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18l', null, null, '2014-09-02 16:33:58', '0', '华普', '国产车系', null, 'file/carLogo/huapu.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18m', null, null, '2014-09-02 16:34:09', '0', '昌河', '国产车系', null, 'file/carLogo/changhe.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18n', null, null, '2014-09-02 17:10:55', '0', '西雅特', '欧洲车系', null, 'file/carLogo/Seat.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18o', null, null, '2014-09-02 17:10:56', '0', 'MG（名爵）', '欧洲车系', null, 'file/carLogo/MG.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18p', null, null, '2014-09-02 17:10:59', '0', '劳斯莱斯', '欧洲车系', null, 'file/carLogo/Rolls-Royce.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18q', null, null, '2014-09-02 17:11:00', '0', '保时捷', '欧洲车系', null, 'file/carLogo/Porsche.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18r', '', '', '2014-09-02 17:08:14', '0', '欧宝', '欧洲车系', '', 'file/carLogo/OPEL.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18s', null, null, '2014-09-02 17:11:02', '0', '迈巴赫', '欧洲车系', null, 'file/carLogo/Maybach.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18t', null, null, '2014-09-02 17:11:03', '0', 'Smart', '欧洲车系', null, 'file/carLogo/Smart.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18u', null, null, '2014-09-02 17:11:04', '0', '标致', '欧洲车系', null, 'file/carLogo/Peugeot.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18v', null, null, '2014-09-02 17:11:05', '0', '雪铁龙', '欧洲车系', null, 'file/carLogo/Citroen.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18w', null, null, '2014-09-02 17:11:06', '0', '布加迪', '欧洲车系', null, 'file/carLogo/Bugatti.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18x', null, null, '2014-09-02 17:11:07', '0', '雷诺', '欧洲车系', null, 'file/carLogo/Renault.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18y', null, null, '2014-09-02 17:11:08', '0', '法拉利', '欧洲车系', null, 'file/carLogo/Ferrari.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e18z', null, null, '2014-09-02 17:11:10', '0', '帕加尼', '欧洲车系', null, 'file/carLogo/Pagani.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19a', null, null, '2014-09-02 17:11:24', '0', '玛莎拉蒂', '欧洲车系', null, 'file/carLogo/Maserati.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19b', null, null, '2014-09-02 17:11:26', '0', '兰博基尼', '欧洲车系', null, 'file/carLogo/Lamborghini.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19c', null, null, '2014-09-02 17:11:27', '0', '阿尔法罗密欧', '欧洲车系', null, 'file/carLogo/Alfa Romeo.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19d', null, null, '2014-09-02 17:11:28', '0', '菲亚特', '欧洲车系', null, 'file/carLogo/FIAT.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19e', null, null, '2014-09-02 17:11:29', '0', '宾利', '欧洲车系', null, 'file/carLogo/Bentley.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19f', null, null, '2014-09-02 17:11:30', '0', '迷你', '欧洲车系', null, 'file/carLogo/MINI.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19g', null, null, '2014-09-02 17:11:31', '0', '莲花', '欧洲车系', null, 'file/carLogo/Lotus.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19h', null, null, '2014-09-02 17:11:32', '0', '阿斯顿马丁', '欧洲车系', null, 'file/carLogo/AstonMartin.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19i', null, null, '2014-09-02 17:11:34', '0', '捷豹', '欧洲车系', null, 'file/carLogo/Jaguar.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19j', null, null, '2014-09-02 17:11:37', '0', '路虎', '欧洲车系', null, 'file/carLogo/Land Rover.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19k', null, null, '2014-09-02 17:11:38', '0', '世爵', '欧洲车系', null, 'file/carLogo/SPYKER.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19l', null, null, '2014-09-02 17:11:39', '0', '柯尼塞格', '欧洲车系', null, 'file/carLogo/Koenigsegg.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19m', null, null, '2014-09-02 17:11:40', '0', '萨博', '欧洲车系', null, 'file/carLogo/SAAB.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19n', null, null, '2014-09-02 17:11:41', '0', '沃尔沃', '欧洲车系', null, 'file/carLogo/Volvo.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19o', null, null, '2014-09-02 17:11:43', '0', '斯柯达', '欧洲车系', null, 'file/carLogo/SKODA.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19p', null, null, '2014-09-02 17:22:22', '0', '大发', '日韩车系', null, 'file/carLogo/Daihatsu.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19q', null, null, '2014-09-02 17:22:23', '0', '大宇', '日韩车系', null, 'file/carLogo/Daewoo.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19r', null, null, '2014-09-02 17:22:23', '0', '宝腾', '日韩车系', null, 'file/carLogo/Protom.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19s', null, null, '2014-09-02 17:22:24', '0', '现代', '日韩车系', null, 'file/carLogo/Hyundai.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19t', null, null, '2014-09-02 17:22:25', '0', '双龙', '日韩车系', null, 'file/carLogo/SsangYong.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19u', null, null, '2014-09-02 17:22:26', '0', '起亚', '日韩车系', null, 'file/carLogo/KIA.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19v', null, null, '2014-09-02 17:22:27', '0', '三菱', '日韩车系', null, 'file/carLogo/Mitsubishi.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19w', null, null, '2014-09-02 17:22:28', '0', '英菲尼迪', '日韩车系', null, 'file/carLogo/Infiniti.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19x', null, null, '2014-09-02 17:22:28', '0', '铃木', '日韩车系', null, 'file/carLogo/SUZUKI.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19y', null, null, '2014-09-02 17:22:30', '0', '雷克萨斯', '日韩车系', null, 'file/carLogo/Lexus.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e19z', null, null, '2014-09-02 17:22:32', '0', '斯巴鲁', '日韩车系', null, 'file/carLogo/Subaru.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20a', null, null, '2014-09-02 17:22:33', '0', '日产', '日韩车系', null, 'file/carLogo/Nissan.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20b', null, null, '2014-09-02 17:22:33', '0', '马自达', '日韩车系', '', 'file/carLogo/Mazda.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20c', null, null, '2014-09-02 17:22:34', '0', '本田', '日韩车系', null, 'file/carLogo/Honda.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20d', null, null, '2014-09-02 17:22:35', '0', '丰田', '日韩车系', null, 'file/carLogo/Toyota.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20e', null, null, '2014-09-02 17:22:35', '0', '讴歌', '日韩车系', null, 'file/carLogo/Acura.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20f', null, null, '2014-09-02 17:22:36', '0', '五十铃', '日韩车系', null, 'file/carLogo/ISUZU.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20g', null, null, '2014-09-02 17:22:37', '0', '罗森', '美洲车系', null, 'file/carLogo/Rossion.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20h', null, null, '2014-09-02 17:22:38', '0', '道奇', '美洲车系', null, 'file/carLogo/Dodge.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20i', null, null, '2014-09-02 17:22:39', '0', '吉普', '美洲车系', null, 'file/carLogo/Jeep.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20j', null, null, '2014-09-02 17:22:42', '0', '林肯', '美洲车系', null, 'file/carLogo/LINCOLN.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20k', null, null, '2014-09-02 17:22:42', '0', '吉姆西', '美洲车系', null, 'file/carLogo/GMC.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20l', null, null, '2014-09-02 17:22:43', '0', '悍马', '美洲车系', null, 'file/carLogo/HUMMER.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20m', null, null, '2014-09-02 17:22:44', '0', '克莱斯勒', '美洲车系', null, 'file/carLogo/Chrysler.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20n', null, null, '2014-09-02 17:22:44', '0', '别克', '美洲车系', null, 'file/carLogo/Buick.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20o', null, null, '2014-09-02 17:22:45', '0', '福特', '美洲车系', null, 'file/carLogo/Ford.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20p', null, null, '2014-09-02 17:22:46', '0', '雪佛兰', '美洲车系', null, 'file/carLogo/Chevrolet.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-20c3d032e20q', null, null, '2014-09-02 17:22:48', '0', '凯迪拉克', '美洲车系', null, 'file/carLogo/Cadillac.png');
INSERT INTO `carlogo` VALUES ('24ad1521-984e-429a-a3e0-22c3d032e17y', null, null, '2014-09-02 17:35:53', '0', '大迪', '国产车系', null, 'file/carLogo/dadi.png');

-- ----------------------------
-- Table structure for checknum
-- ----------------------------
DROP TABLE IF EXISTS `checknum`;
CREATE TABLE `checknum` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `endtime` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '校验码失效时间(创建时间+有效时间段)',
  `userId` varchar(36) NOT NULL,
  `checkNum` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checknum
-- ----------------------------
INSERT INTO `checknum` VALUES ('00bff19f-35f0-4287-9458-829474e6c1f5', null, null, '2015-01-24 11:29:52', '2015-01-25 11:29:52', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '916599');
INSERT INTO `checknum` VALUES ('73c48ca8-0592-4d79-85d5-45445c279fe3', null, null, '2015-01-24 11:36:59', '2015-01-25 11:36:59', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '577591');
INSERT INTO `checknum` VALUES ('7a55c497-cae1-406b-9f61-45efe9658903', null, null, '2015-01-24 11:59:02', '2015-01-25 11:59:02', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '803977');
INSERT INTO `checknum` VALUES ('9cd04f58-652c-4edf-85c8-18923bc03ae1', null, null, '2015-01-24 11:47:48', '2015-01-25 11:47:48', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '523847');
INSERT INTO `checknum` VALUES ('f9ebf8b9-aa18-4aad-9270-66bc16e6d66f', null, null, '2015-01-24 11:51:32', '2015-01-25 11:51:32', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '790503');
INSERT INTO `checknum` VALUES ('fa93e2a0-d326-4f73-8399-724c8cd5b815', null, null, '2015-01-24 11:55:00', '2015-01-25 11:55:00', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '14166');
INSERT INTO `checknum` VALUES ('ff2ec422-0ff4-4194-8f87-64cb0a0cc7dc', null, null, '2015-01-24 12:03:07', '2015-01-25 12:03:07', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '433788');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `userId` varchar(36) default NULL,
  `newsId` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1756925b-940d-4fd2-9b3d-53b4d1729f3c', null, null, '2014-09-13 12:02:58', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2');
INSERT INTO `collect` VALUES ('26be6083-d44e-40a7-a146-6d05ab1b47a4', null, null, '2014-09-13 12:03:26', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a');
INSERT INTO `collect` VALUES ('3226d4b7-7167-4152-9351-fc6b7e9b8a15', null, null, '2014-12-21 10:09:25', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s');
INSERT INTO `collect` VALUES ('651b5eb3-9a4e-4bc9-96af-8e51338c751b', null, null, '2014-09-10 10:35:05', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a');
INSERT INTO `collect` VALUES ('6be651f5-3ef7-480f-8d48-8906adb36c08', null, null, '2014-09-13 11:53:43', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae');
INSERT INTO `collect` VALUES ('7a75b757-17d9-47b4-a155-eb5be3621803', null, null, '2014-09-13 12:03:02', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a');
INSERT INTO `collect` VALUES ('a83dc867-09f7-4f87-bf36-d1aa230beffc', null, null, '2014-09-10 10:37:02', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2');
INSERT INTO `collect` VALUES ('da8814c9-ca02-43e5-b37b-d9d73513236b', null, null, '2014-09-10 10:15:06', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s');

-- ----------------------------
-- Table structure for groupbuy_locks
-- ----------------------------
DROP TABLE IF EXISTS `groupbuy_locks`;
CREATE TABLE `groupbuy_locks` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `locksId` varchar(36) NOT NULL,
  `businessId` varchar(36) default NULL,
  `type` varchar(36) default NULL,
  `origin` varchar(100) default NULL,
  `gbprice` double default NULL,
  `image` varchar(100) default NULL,
  `sales` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groupbuy_locks
-- ----------------------------
INSERT INTO `groupbuy_locks` VALUES ('0229b13b-5970-4519-8b77-50de4c29f450', '金锁', '金锁团购hahah', '2014-08-25 13:05:05', '1', '27c3d26d-e78f-48b9-b676-b1278fdac7bb', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'J234', '澳洲', '9.7', '14080111185151.jpg', '445');
INSERT INTO `groupbuy_locks` VALUES ('19d76141-0be6-451a-99e3-991a49d30835', '银锁', '银锁团购', '2014-08-25 13:02:10', '1', '04ac2b60-1e8b-4a98-a454-d5ab20cd3535', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', 'Y345', '美洲', '8.8', 'yinsuo.jpg', '25');
INSERT INTO `groupbuy_locks` VALUES ('57ca0268-3b85-4143-9cfa-f4bc28e4aa6b', '银牌锁', '一、结构特征：        ·锁体内部卡簧式锌压铸结构，外部包塑料，高H35mm，直径20mm。        ·锁杆为钢车件镀铬或包塑料,长L83mm,￠9.5mm，脑部直径20mm:锁定后总长L=85mm。        ·抗拉强度F 〉10000N。        ·本产品牢固、易锁、防盗性可靠。二、适用范围：        ·各式集装箱、货柜车、棚车。', '2014-12-21 17:30:58', '1', '04ac2b60-1e8b-4a98-a454-d5ab20cd3535', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', 'Y345', '非洲', '34', 'yinsuo.jpg', '1');
INSERT INTO `groupbuy_locks` VALUES ('ab07e66a-58bf-43e9-8004-00a1a87b268e', 'O型丝扣锁', 'KAILAS凯乐石 O型丝扣锁 攀岩锁 登山扣高空作业 保护锁 KE210031 Oval丝扣锁，用途广泛，对称圆滑的锁身特别很是连接滑轮、上升器、下降器、设置各种保护等。 造型简洁大方，独特的颜色便于识别。 适合各类攀登、救援、高空作业、拓展项目等。 重量：76克 闭门拉力：23KN 横向拉力：8KN 开门拉力：6KN', '2014-09-17 10:10:35', '0', 'eef9fdac-6aaf-45ac-ba93-a9967e0ee647', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', 'D320', '温州市', '44', 'ouhai.jpg', '0');

-- ----------------------------
-- Table structure for locks
-- ----------------------------
DROP TABLE IF EXISTS `locks`;
CREATE TABLE `locks` (
  `id` varchar(36) NOT NULL,
  `businessId` varchar(36) default NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `type` varchar(50) default NULL,
  `price` double default NULL,
  `oprice` double default NULL,
  `image` varchar(100) default NULL,
  `origin` varchar(100) default NULL,
  `sales` int(11) default NULL,
  `rating` int(11) default NULL,
  `rank` int(11) default NULL,
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of locks
-- ----------------------------
INSERT INTO `locks` VALUES ('04ac2b60-1e8b-4a98-a454-d5ab20cd3535', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '银牌锁', '一、结构特征：\r\n        ·锁体内部卡簧式锌压铸结构，外部包塑料，高H35mm，直径20mm。\r\n        ·锁杆为钢车件镀铬或包塑料,长L83mm,￠9.5mm，脑部直径20mm:锁定后总长L=85mm。\r\n        ·抗拉强度F 〉10000N。\r\n        ·本产品牢固、易锁、防盗性可靠。\r\n二、适用范围：\r\n        ·各式集装箱、货柜车、棚车。', '2014-07-25 10:22:52', 'Y345', '10.4', '17.4', 'yinsuo.jpg', '非洲', '888', '4', '4', '1');
INSERT INTO `locks` VALUES ('1027e34e-422b-41f9-884a-e1922011c55d', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '杂牌锁', 'a. 可连接安全光栅，实现多重安全保障的防夹功能。b. 遇障碍物自动反向运行，实现防夹防撞的安全功能。c. 断电时可自行解锁，实现无电时也能轻松手动开关门。d. 可连接USB备用电源，实现各种情况下的不间断控制。e. 双门互锁功能，适应银行内部通道、无菌房、工厂无尘车间等场所应用。f. 环保节能的宽度调节模式，设置合适的门扇开启宽度，以减少室内外空气热交换。', '2014-07-18 10:58:20', 'TKLJ', '4.2', '2.3', 'a.jpg', '太空回收', '8888', '0', '3', '1');
INSERT INTO `locks` VALUES ('1daa7a3a-200b-4367-97c2-43147caed186', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'You', 'hhhhhh', '2014-12-21 10:11:56', 'Ok', '44', '44', '3149fedebabe47d8b831842ce8f7c198.jpg', 'Jk', '0', '0', '0', '0');
INSERT INTO `locks` VALUES ('2736749a-b849-4c4d-961a-dc44c04cdf74', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '品牌锁', '很好用的一款产品。', '2015-01-23 14:59:44', 'pp444', '54.3', '54.3', '4bb4df68fde740ae9f74a0ea8eec873b.jpg', '南昌', '0', '0', '0', '0');
INSERT INTO `locks` VALUES ('27c3d26d-e78f-48b9-b676-b1278fdac7bb', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '金牌锁', 'a. 具备自学习功能，首次通电即能自行检测门扇重量、起止行程并保存参数。b. 快速系统试运行，自学习后能自动试运行以检验开门关门效果。c. 根据开门宽度变化，智能计算最佳分段动作时间，以保持自然、柔和的开关门动作。d. 马达带电自锁的门禁功能，禁止未授权的开门行为。', '2014-08-28 10:38:27', 'J234', '23.98', '37.8', 'jinsuo.jpg', '澳洲', '53', '0', '0', '1');
INSERT INTO `locks` VALUES ('401bbb77-44b1-4738-b6c8-0da0139f7738', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '零售', '', '2014-12-26 20:56:28', 'lingshou-1', '90', '100', '14122620524651.jpg', '南昌', '0', '0', '0', '1');
INSERT INTO `locks` VALUES ('469f409b-9b03-4458-9ddc-0d80cf6b0cc0', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '燃气防盗卡扣', '燃气防盗卡扣介绍 杨旺 产品特点 型号：15mm 20mm 25mm 32mm 40mm 70mm 管道活接一次性塑封卡是一种适用于煤气表、水表及其它活接式联接管道的一次性塑封卡，这种一次性塑封卡设计巧妙、结构简单、安装方便、成本低，安装后拆卸即损坏且无法复原，防盗性好，能有效防止私拆煤气表、水表及其他活接联接管道，避免埋藏安全隐患，是一种有效的、可靠的活接防护配件！！ 欢迎来电订购，执行全国最低价格！！ 产品可打条形码，二维码等', '2014-07-16 11:34:21', 'P321', '198.3', '232.5', 'fuyu.jpg', '中山市', '3432', '0', '0', '1');
INSERT INTO `locks` VALUES ('5043a343-546a-46e1-bede-73ed493fd2ac', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '按锁芯钥匙', '按锁芯钥匙分： 　　有梅花挂锁，十字挂锁，原子挂锁，感应挂锁，磁性挂锁，叶片挂锁，一次性锁。 按锁梁长短分： 　　有标准锁梁挂锁，4公分锁梁挂锁，6公分锁梁挂锁。9公分锁梁挂锁，也可以按照客户要求定做更长锁梁的挂锁。 按锁梁材质分： 　　有钢铁的。不锈钢的，铜的。 　　具体产品型号如：30MM梅花钥匙标准锁梁铜挂锁，30MM梅花钥匙4公分锁梁铜挂锁。 　　35MM十字钥匙6公分锁梁铜挂锁，35MM十字钥匙9公分铜挂锁 　　35MM原子钥匙标准锁梁塑钢锁，35MM原子钥匙4公分锁梁挂锁 　　40MM梅花钥匙铜梁铜挂锁，40MM纯铜挂锁，（铜锁芯，铜锁梁，铜锁体） 　　50MM铜挂锁，50MM叶片锁，50MM子母锁等 ', '2014-07-16 11:34:22', 'H63K', '42.6', '54.3', 'anzhandianli.jpg', '山东省', '34', '0', '0', '1');
INSERT INTO `locks` VALUES ('5b33c584-d6a5-4ba8-b884-9bd61768a200', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '表箱锁', '表箱锁,电力表箱锁/价格/规格/型号/厂家/特点/功能/作用 产品简介： 　　就是一把钥匙能开启一定范围内的挂锁。比如一把钥匙开100或10000把同类型的挂锁。这主要是为了方便管理而设定的。也称分组挂锁，可以一级一级管理下去，提高员工的工作效率。比如：供电公司，燃气公司，石油公司，物业公司，自来水公司等都属于此通开锁具。 按材料分： 　　有塑钢挂锁，锌合金挂锁，铜挂锁 按锁体的大小分： 　　有30MM挂锁，35MM挂锁,40MM挂锁，50MM挂锁，60MM挂锁。 ', '2014-07-16 11:34:24', 'E489', '69.3', '89.4', 'mankai.jpg', '东莞市', '565', '0', '0', '1');
INSERT INTO `locks` VALUES ('7962688b-7bf8-4aaf-8d14-78e17c2d5b78', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'Pvc变压器护栏锁', 'Pvc变压器护栏介绍 杨旺 主要生产塑钢PVC护栏型材、护栏成型产品、变压器护栏、草坪护栏、社区护栏、栅条护栏、阳台护栏、道路护栏，PVC挂板等系列产品。 公司引进先进生产线，生产PVC彩色护栏，样式新颖、大方，表面光洁美丽，经特殊工艺配方，具有强度高、耐腐蚀、抗静电，在—40至70下使用不褪色、不脱皮、不开裂、不脆化，又因其以高档的PVC为外观，以钢管为内衬，使典雅的外表和坚韧的内在品质完美结合。', '2014-07-16 11:34:24', 'I439', '54.9', '123.6', 'chuangan.jpg', '常州市', '58', '0', '0', '1');
INSERT INTO `locks` VALUES ('906af514-83df-409b-95a2-17cfb3161f55', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '挂锁', ' 钢丝直径：1.6mm或1.8mm,总长：230mm，可按客户要求或来样订做。防晒，防腐蚀，拉紧型结构，易安装。可热压或激光点印、公司标志或名称、编码。 抗拉强度：F≥300公斤以上,锁后可用断线钳剪除。 结构特征：此产品为钢珠弹子式车件组装而成，呈挂锁形状，可热压或激光点印、公司标志或名称、编码，锁头外包ABS塑料、易安装，锁后可用专制钢丝剪移除。钢绳直径4mm，总长7.2cm。 抗拉强度：F≥200公斤以上。 可按客户要求或来样订做。 也可按客户的要求调制多种颜色。颜色：红/黄/白/蓝/绿/橘/黑 包装：标准包装：1000个/袋-10袋/箱或50个/盒-200盒/箱。', '2014-07-16 11:34:25', 'T983', '71.4', '92.4', 'nashen.jpg', '常州市', '324', '0', '0', '1');
INSERT INTO `locks` VALUES ('95a69f58-ab84-4f0f-9fd3-7204493e9f66', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '宝马车锁', '很不错', '2014-09-13 14:58:45', 'G456', '51.6', '51.6', 'd396a867809548478cbdcc50b4343db3.jpg', '南昌', '0', '0', '0', '0');
INSERT INTO `locks` VALUES ('ad13b967-94fd-43f2-b622-3e8f0d4bd3ee', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'PVC外墙锁', '在提倡绿色环保的今天，PVC护栏以其独特多样的造型，灵活简便的组装，鲜艳夺目而又可以随时更换的色彩，深受广大客户的青睐。 生产的PVC外墙挂板具有耐老化、抗辐射、防腐、阻燃、造型美观、安装简便的特点，适用于各类建筑物的室内外墙面、棚面的装饰装修，是一种新型的绿色环保材料。 精良的设备、科学的管理、灵活的机制、严格的检测规程、完善的环保体系，确保了我公司健康、稳定、快速的发展。我公司秉承“视质量重于泰山、以诚信广纳四海”为宗旨，竭诚为广大用户提供最优质的产品和最优良的服务。', '2014-07-16 11:34:26', 'S432', '62.32', '89.2', 'shidian.jpg', '南昌市', '874', '0', '0', '1');
INSERT INTO `locks` VALUES ('b18cf566-e0bc-4aed-9fee-13ac6f84011f', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '锁锁锁', '很好用', '2014-09-13 10:35:04', 'fes', '22.3', '22.3', 'dae512e8dd9a4eecafde578d15957810', '南昌', '0', '0', '0', '0');
INSERT INTO `locks` VALUES ('e5a0352b-187b-46f3-bff4-f0130a1a0bf5', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '银牌分锁', 'a. 单向开门运行模式，设定自动感应只出不进，适合商店即将停止营业前使用。b. 常开/常关模式，门扇到位并保持开启或关闭状态，满足长时间开门通气等需要。c. 数字化全遥控的程序控制设定，可自定义更多变化功能。附加备注：依托自身的研发、生产和加工优势，捷力西自动门愿为自动门安装工程商、自动门代理销售公司、安防公司、装饰公司和各类门控集成商提供成套产品和OEM /ODM 代加工配套服务。目标是成为自动门领域优秀的制造商和友好的供应商。竭诚为您服务！ ', '2014-07-10 14:55:05', 'Y345', '9.32', '14.6', 'yinsuo.jpg', '非洲', '567', '4', '4', '1');
INSERT INTO `locks` VALUES ('ec34fb0c-7a2c-40b8-82b1-69033be74407', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '施封锁', '一次性施封锁，表封锁，钢丝封， 适用于电表，水表，邮包袋，军械施封，仪表、供电、供气、供水、军工、石油运输、化工、矿山、邮政、海关、铁路、金融、货柜，外贸商检，交通运输产品加工，及企业产品检验、包装桶封装等系列。 现拥有钢丝封条、高保封条、塑料封条、挂锁封条、铁皮封条、铅封、电子铅封、防伪标签，等共8个系列100余种产品，并不断创新，研发、设计、制造出多样性的产品，为客户解决最棘手的安全要求。 材质：内部是纯铅，外部用铁皮盒压制成，表面颜色由电镀上色，印刷、冲压或激光 。', '2014-07-16 11:34:30', 'U903', '90.02', '108.2', 'shendan.jpg', '上海市', '903', '0', '0', '1');
INSERT INTO `locks` VALUES ('ecdd8c8d-e7e5-4dbc-b0bb-5d49778857a2', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '防盗卡扣', '如有需要敬请联系 1：防盗卡扣材质为优质ABS工程塑料 型号：15mm 20mm 25mm 32mm 40mm 70mm 2：卡体可免费打印：公司名称、报修电话、编号及私拆违法等字样，使别人无法复制。 3：防盗卡可与铅封配套使用，双重保险作用； 4：颜色多种，可根据客户要求制作，燃气一般为黄色，自来水一般为蓝色；', '2014-07-16 11:34:31', 'R403', '21.3', '53.9', 'weiyingjie.jpg', '深圳市', '745', '0', '0', '1');
INSERT INTO `locks` VALUES ('eef9fdac-6aaf-45ac-ba93-a9967e0ee647', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', 'O型丝扣锁', 'KAILAS凯乐石 O型丝扣锁 攀岩锁 登山扣高空作业 保护锁 KE210031 Oval丝扣锁，用途广泛，对称圆滑的锁身特别很是连接滑轮、上升器、下降器、设置各种保护等。 造型简洁大方，独特的颜色便于识别。 适合各类攀登、救援、高空作业、拓展项目等。 重量：76克 闭门拉力：23KN 横向拉力：8KN 开门拉力：6KN', '2014-07-16 11:34:32', 'D320', '90.2', '130.2', 'ouhai.jpg', '温州市', '453', '0', '0', '1');
INSERT INTO `locks` VALUES ('fe35d039-6dbf-4b29-9c7b-ce1ee7d10ee0', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '通道锁', '产品功能:\r\n1:外形美观、结构坚固耐用（大大减少维护保养）、带夜光的推杆、价格合理的紧急通道门锁。\r\n2:紧急蔬散通道门，不用锁死也不用敞开，即可防盗又可自由出入，每日提供二十四小时安防保护。\r\n3:适合任何紧急通道门、安全出口门、防火门、逃生门、消防通道门。\r\n4:适用于控制人流、阻止擅自离开及防止偷窃，使楼宇符合有关紧急出口通道装置的建筑物法例要求。    \r\n5:推动压杆门开时,警号即响,直到人为取消。门禁压杆门开时，消防通道锁可推开不报警,通道锁被非法打开时,能给门禁系统提供信号,并发出报警(报警声可达到100分贝)。', '2014-09-20 10:26:00', 'O983', '43.2', '87.9', 'saigao.jpg', '浙江省', '432', '0', '0', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `_order` int(20) default NULL,
  `porder` int(10) default NULL,
  `icon` varchar(30) default NULL,
  `url` varchar(100) default NULL,
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('08361483-20a2-4606-a5e8-4e80ad3387b6', '商户管理', '', '2014-04-18 20:36:50', '1102', '11', 'icon-common', 'business.html', '0');
INSERT INTO `menu` VALUES ('1', '后台系统管理', '', '2014-04-16 18:55:35', '9', '0', 'icon-tip', '', '0');
INSERT INTO `menu` VALUES ('10614202-6f7f-49f1-8b78-edc091038414', '商户申请', '', '2014-07-12 16:28:18', '1103', '11', 'icon-common', 'triggerbuinessadd.html', '0');
INSERT INTO `menu` VALUES ('14f69e64-61f1-4da9-b4b7-aa5d1812ba8c', '帖子类型管理', '', '2014-06-26 18:02:06', '1302', '13', 'icon-common', 'newsType.html', '0');
INSERT INTO `menu` VALUES ('14f69e64-61f1-4da9-b4b7-aa5d1812bid0', '滚动图片管理', '管理员对首页和论坛滚动图片进行管理', '2014-11-03 11:08:32', '905', '9', 'icon-common', 'rotatePicture.html', '0');
INSERT INTO `menu` VALUES ('153f0e3e-8e27-4a43-a837-bc4e67e1c20e', '会员信息管理', '', '2014-04-16 20:05:23', '11', '0', 'icon-group', '', '0');
INSERT INTO `menu` VALUES ('15c5303b-ebd9-4239-bee1-2a87e092aa05', '锁芯专区', '', '2014-11-29 11:48:07', '1603', '16', 'icon-common', 'lockCylinder.html', '0');
INSERT INTO `menu` VALUES ('19e904d1-e02d-46b1-807e-d5b43ddcaed2', '商品管理', '', '2014-04-21 20:06:02', '12', '0', 'icon-home', '', '0');
INSERT INTO `menu` VALUES ('2', '角色权限设置', '', '2013-09-01 23:57:15', '901', '9', 'icon-common', 'role.html', '0');
INSERT INTO `menu` VALUES ('2f4e4fa6-6887-4ecd-b2d2-28baf1d5908e', '广告专区', '', '2014-11-29 11:48:18', '1604', '16', 'icon-common', 'advertisement.html', '0');
INSERT INTO `menu` VALUES ('341770f7-612b-4e3b-9943-54643a13a86e', '提现管理', '管理员操作各商户申请提现表单', '2014-10-17 15:45:44', '1504', '15', 'icon-common', 'apply_operator.html', '0');
INSERT INTO `menu` VALUES ('3cedbd0b-afb1-4ac6-9fc9-6919e3113efb', '商品管理', '', '2014-04-21 20:06:34', '1201', '12', 'icon-common', 'lock.html', '0');
INSERT INTO `menu` VALUES ('3e8af635-708c-4d60-aab3-34915f012e70', '团购锁', '', '2014-08-05 15:59:45', '1502', '15', 'icon-common', 'userorder_grouplocks.html', '0');
INSERT INTO `menu` VALUES ('450f0b03-e3ab-4e35-965a-e6f17406b93a', '订单管理', '', '2014-08-05 15:56:50', '15', '0', 'icon-common', null, '0');
INSERT INTO `menu` VALUES ('475f88f1-85f1-4234-9e7a-35325f231ffa', '操作员管理', '', '2013-10-13 14:07:31', '904', '9', 'icon-common', 'operator.html', '0');
INSERT INTO `menu` VALUES ('47f1adf0-393a-4e59-87d4-81ec029d4864', '同行管理', '', '2014-08-31 14:16:50', '1104', '11', 'icon-common', 'peers.html', '0');
INSERT INTO `menu` VALUES ('4c84ed0f-41db-42bb-94eb-4926e223e4eb', '资源管理', '', '2014-05-10 20:46:47', '14', '0', 'icon-log', '', '0');
INSERT INTO `menu` VALUES ('5f2e3e8a-1d5b-4af1-991c-f137b5b7885c', '日志查看', '', '2013-09-26 11:02:48', '903', '9', 'icon-common', 'syslog.html', '0');
INSERT INTO `menu` VALUES ('6', '菜单管理', '', '2013-09-01 23:57:21', '902', '9', 'icon-common', 'menumanage.html', '0');
INSERT INTO `menu` VALUES ('8cfb8e4e-9909-4c4d-a23e-02b8db083635', '指纹锁专区', '', '2014-11-29 11:47:56', '1602', '16', 'icon-common', 'fingerprintLockArea.html', '0');
INSERT INTO `menu` VALUES ('8ee52458-a69f-453f-a738-a621db870b55', '广播', null, '2014-12-06 15:46:12', '1605', '16', 'icon-common', 'radio.html', '0');
INSERT INTO `menu` VALUES ('a1eb035e-f750-452d-8a97-0d8605dcd0dc', '论坛管理', '', '2014-04-27 21:41:50', '13', '0', 'icon-pencil', '', '0');
INSERT INTO `menu` VALUES ('bcadb20e-776d-40d4-bfee-c7a91501b84a', '团购商品管理', '', '2014-07-23 10:31:10', '1202', '12', 'icon-common', 'groupbuy.html', '0');
INSERT INTO `menu` VALUES ('c12ffe7b-5da1-49ea-acbf-890f8fa3cebf', '软件下载管理(无类型)', null, '2014-12-22 11:14:08', '1403', '14', 'icon-common', 'resourceOfSoftware.html', '0');
INSERT INTO `menu` VALUES ('c74e14f3-a300-4904-8a9d-0ed6903a51a2', '帖子管理', '', '2014-04-27 21:42:23', '1301', '13', 'icon-common', 'news.html', '0');
INSERT INTO `menu` VALUES ('d24d64ce-fcff-40ec-9a33-9c15714aaf90', '广告管理', '', '2014-11-29 11:45:33', '16', '0', 'icon-common', null, '0');
INSERT INTO `menu` VALUES ('d5ea81e9-72be-4ab8-ac63-98f3b1fd644e', '康耐尔', '', '2014-11-29 11:47:44', '1601', '16', 'icon-common', 'CONAIR.html', '0');
INSERT INTO `menu` VALUES ('dd44d2f5-fcbd-491d-a46f-b3d20d8cbaa2', '前台角色管理', '', '2014-04-16 18:58:28', '1001', '10', 'icon-common', 'userrole.html', '0');
INSERT INTO `menu` VALUES ('e3caf782-a74e-49ec-88f5-39342e5c5c6c', '资源管理', '', '2014-12-22 10:45:03', '1402', '14', 'icon-common', 'resource.html', '0');
INSERT INTO `menu` VALUES ('e6676084-7de0-46ee-ac65-62fd9219f71c', '申请提现', '', '2014-10-17 15:44:21', '1503', '15', 'icon-common', 'apply_business.html', '0');
INSERT INTO `menu` VALUES ('e99e85d5-e809-46b1-aa02-a9da03d0a0b8', '会员信息', '', '2014-04-16 22:25:57', '1101', '11', 'icon-common', 'user.html', '0');
INSERT INTO `menu` VALUES ('f3725eaf-ea0d-451f-af77-cfde3e073f05', '车类管理', '', '2014-12-22 10:45:08', '1401', '14', 'icon-common', 'car.html', '0');
INSERT INTO `menu` VALUES ('f44c0542-ee7d-4d48-9b92-2d10c870631f', '基本锁', '', '2014-08-05 15:59:09', '1501', '15', 'icon-common', 'userorder_baselocks.html', '0');
INSERT INTO `menu` VALUES ('f7de8c0d-8bc8-41ba-a8af-cd4e44508f84', '前台系统管理', '', '2014-04-16 18:57:32', '10', '0', 'icon-stat', '', '0');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text COMMENT '存放图片处(如果有的话)',
  `createtime` timestamp NULL default NULL,
  `status` int(11) default '0',
  `userId` varchar(36) default NULL,
  `type` int(11) default NULL,
  `title` varchar(100) default NULL,
  `content` text,
  `userName` varchar(100) default NULL,
  `viewCount` int(11) default NULL,
  `reviewCount` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('', '', '', '2014-11-26 19:07:47', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('1', '', '', '2014-11-26 19:07:25', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('10', '', '', '2014-11-26 19:07:55', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('11', '', '', '2014-11-26 19:07:57', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('12', '', '', '2014-11-26 19:07:59', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('13', '', '', '2014-11-26 19:08:00', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('14', '', '', '2014-11-26 19:08:03', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('15', '', '', '2014-11-26 19:08:05', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('16', '', '', '2014-11-26 19:08:06', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('17', '', '', '2014-11-26 19:08:08', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('18', '', '', '2014-11-26 19:08:10', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('19', '', '', '2014-11-26 19:08:12', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('2', '', '', '2014-11-26 19:07:30', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('20', '', '', '2014-11-26 19:08:28', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('21', '', '', '2014-11-26 19:08:32', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('23', '', '', '2014-11-26 19:08:35', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('24', '', '', '2014-11-26 19:08:36', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('25', '', '', '2014-11-26 19:08:39', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '102', '100');
INSERT INTO `news` VALUES ('26', '', '', '2014-11-26 19:08:41', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '101', '100');
INSERT INTO `news` VALUES ('27', '', '', '2014-11-26 19:08:42', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('28', '', '', '2014-11-26 19:08:43', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '102', '100');
INSERT INTO `news` VALUES ('3', '', '', '2014-11-26 19:07:33', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('31ad0d72-da34-4a03-8212-da4e13ca48f2', 'xiaoming', 'xiaomingfatie.jpg', '2014-07-28 17:11:02', '1', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '1', '小明发帖', '内容是小明发帖', '小明', '396', '13');
INSERT INTO `news` VALUES ('4', '', '', '2014-11-26 19:07:35', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('5', '', '', '2014-11-26 19:07:37', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('6', '', '', '2014-11-26 19:07:40', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('7', '', '', '2014-11-26 19:07:44', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('758fce71-cd22-4cec-8cd1-f329f6ae7dd3', null, 'e30bca9c2b204118bc080abf2b16e45e.jpg', '2015-01-21 00:13:02', '1', 'e0e0643a-93a8-4a1c-a41d-43f4a6f01a3e', '6', '宝马仪表', '出售宝马仪表一块', '0791sy', '4', '0');
INSERT INTO `news` VALUES ('8fafe6d6-76a1-4f3d-a77d-083b6b22b035', null, 'd7d7bb69543d4b26bf4d63927cc9030f.jpg', '2014-12-21 16:13:37', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '2', '测试', '测试', 'user1', '0', '0');
INSERT INTO `news` VALUES ('9', '', '', '2014-11-26 19:07:51', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'aa', 'bb', 'user1', '100', '100');
INSERT INTO `news` VALUES ('9df963ca-b4b7-47d8-b249-7fc40d66133a', 'xiaoa', null, '2014-11-27 19:08:40', '1', '7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', '2', '小a发帖', '内容是小a发帖', '小a', '386', '13');
INSERT INTO `news` VALUES ('9df963ca-b4b7-47d8-b249-7fc40d66133s', null, null, '2014-11-27 19:12:09', '1', '7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', '2', '小a发帖', '内容是小a发帖顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告个', '小a', '3686', '36');
INSERT INTO `news` VALUES ('b84850b0-494a-4de7-8552-89a939b4a0ae', 'user1', null, '2014-11-27 19:09:39', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '1', 'user1', 'user1', 'user1', '19', '0');
INSERT INTO `news` VALUES ('d079847e-21f5-4671-bb4c-ebc1c741e835', null, '70bf55b559d04aef89e632fbb80594d2.jpg', '2014-12-24 04:01:48', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '2', '换锁', '明天需要换锁', 'user1', '38', '0');
INSERT INTO `news` VALUES ('eca7c6c9-2e28-432c-8ccd-bf86606a29fe', null, 'e6b10fceed364583938189e51790fab3.jpg', '2014-11-26 18:40:42', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '2', '测试乘法', '测定成都市', 'user1', '0', '0');
INSERT INTO `news` VALUES ('f3ef5c13-75d1-4ad1-ae25-68e0e0fb191b', null, '5f15aaa6662b4a90a811df8213621706.jpg', '2014-11-26 18:40:44', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '2', '测试发帖', '发帖测试', 'user1', '0', '0');
INSERT INTO `news` VALUES ('fb7477e5-8669-4995-bf7a-9ebb43b1cdc2', null, 'f28676fd4b924c749150ec344bc48255.jpg', '2014-12-21 15:25:26', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '2', 'k\'k\'k', 'k\'k\'k', 'user1', '0', '0');

-- ----------------------------
-- Table structure for newstype
-- ----------------------------
DROP TABLE IF EXISTS `newstype`;
CREATE TABLE `newstype` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `type` int(11) default '0',
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newstype
-- ----------------------------
INSERT INTO `newstype` VALUES ('333cc570-e8a1-4a9c-a472-3021802546f9', '民用开锁技术交流', '民用开锁技术交流', '2014-05-10 16:43:55', '2', '1');
INSERT INTO `newstype` VALUES ('3d770ee6-5ec2-4934-9abc-93652825747d', '二手设备出售', '二手设备出售', '2014-07-07 11:02:27', '6', '1');
INSERT INTO `newstype` VALUES ('40972329-afc1-4687-b713-da88de77e95d', '最新活动资讯', '最新活动资讯', '2014-05-10 16:43:26', '0', '1');
INSERT INTO `newstype` VALUES ('770335fc-9319-470a-9954-d20d2391d633', '汽车遥控匹配方法', '汽车遥控匹配方法', '2014-05-10 16:44:03', '3', '1');
INSERT INTO `newstype` VALUES ('b468b998-e0b9-4010-bf31-f2b9d388b05d', '芯片钥匙匹配方法', '芯片钥匙匹配方法', '2014-05-10 16:44:14', '4', '1');
INSERT INTO `newstype` VALUES ('d8f378c1-aff4-494e-8ce6-82e06b6b35b1', '汽车电脑维修资料', '汽车电脑维修资料', '2014-07-07 10:44:52', '5', '1');
INSERT INTO `newstype` VALUES ('ea8f5eb9-8432-4a55-9864-0aa2ffd7f7f1', '汽车解码技术交流', '汽车解码技术交流', '2014-05-10 16:43:49', '1', '1');

-- ----------------------------
-- Table structure for ofuser
-- ----------------------------
DROP TABLE IF EXISTS `ofuser`;
CREATE TABLE `ofuser` (
  `username` varchar(64) NOT NULL,
  `plainPassword` varchar(32) default NULL,
  `encryptedPassword` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  PRIMARY KEY  (`username`),
  KEY `ofUser_cDate_idx` (`creationDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ofuser
-- ----------------------------
INSERT INTO `ofuser` VALUES ('admin', null, 'c101c7898f2359ded2506080f3de384275cfe4917a160d30', 'Administrator', '761780598@qq.com', '001403785079703', '0');
INSERT INTO `ofuser` VALUES ('huangxuejian', null, '336870959f1bfb6f81318b5bca2c7c31f01153217d408f48156fad2287b6da5a23bed3575deb730a', 'huang', null, '001403786005031', '001403786005031');

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `account` varchar(30) default NULL,
  `password` varchar(200) default NULL,
  `roleId` varchar(36) default NULL,
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a', 'huang', '1', '2014-07-28 15:51:31', 'huang', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'cae61c58-113c-42cb-88d0-2e0cbc22ed63', '1');
INSERT INTO `operator` VALUES ('1402ff5a-028d-40db-bef5-a309eff55dec', null, null, '2015-01-11 22:25:42', '0791sy1', 'd850647350d822301ae3b3fe0d5bd57b99eb90b334b5bd98ce86477d3011f1a26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('1ea9b11d-f7c3-49d6-9d33-43debd98091d', null, null, '2015-01-11 22:27:35', '0791sy2', 'd850647350d822301ae3b3fe0d5bd57b99eb90b334b5bd98ce86477d3011f1a26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('2841c13a-3d8f-47a6-9228-ef95318d3df5', null, null, '2015-01-04 19:30:47', '人品差怎么办呢', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', null, null, '2015-01-23 14:10:19', 'NinaXuYuan', '8cf10f6be6c6597c7d321590947a3e3e066bc4f6e6ffcde640888fecd3e3a2de6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('37cc04d0-2ebb-4826-817a-d07aa9678522', null, null, '2015-01-06 00:38:02', '0791sy', '2eb63c447e91fb5fdc61cf246030b314de2a26899da3c54d2c31d8e347c66ec16e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('4a3b0049-2c3b-43d7-94c6-102dc779fa16', '商铺', '', '2014-12-05 11:55:25', 'user1', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '0');
INSERT INTO `operator` VALUES ('55522a93-260f-41bb-8bf5-c55744b96772', null, null, '2014-12-26 17:55:16', '许园nina', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0');
INSERT INTO `operator` VALUES ('561d6c90-a7df-4253-bdc4-058408b941be', null, null, '2014-09-05 07:50:42', '南昌谭水龙0', '1444d1a9a5d1468109e244b52b60ca90789fcdab8bb8cc34c0a9a72dd24d1bac6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('654fbb59-d0e2-46a6-b16f-845843b290fc', null, null, '2014-10-11 11:57:52', 'shuilong00', 'faff3a12e65fa18b8ca0e727f865aa7c0e902c85f7fa64c132f7dd84bce7d3366e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('688bdfb1-db64-4764-bf3b-d594b43bec23', null, null, '2014-12-25 10:09:28', '梁在超123456', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('6d445ed2-5167-4ebc-ad04-4f70dd1326e7', null, null, '2015-01-11 22:10:24', 'shuilong123', 'caaf41346beb3092b3402979590e8415249a7345e9e17263cdc78fbeff80f2c06e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0');
INSERT INTO `operator` VALUES ('7257b67c-5448-4d00-a592-334d65e2c869', null, null, '2014-12-26 17:43:24', '黄是黄学坚123', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', 'xiaoa', '', '2014-12-05 12:07:01', 'xiaoa', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '1');
INSERT INTO `operator` VALUES ('7c1dd44a-4491-46ff-82b2-ac2cf89214b4', null, null, '2015-01-04 14:09:31', '人品差怎么办', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0');
INSERT INTO `operator` VALUES ('89c66323-1ee7-43c2-90b4-bfcd25fce4a5', null, null, '2015-01-21 16:37:19', 'cjm1234', 'f187c629ee9df29b5243d758166ee6b9d3c372a794ebb3ea38b01b2d3193f5db6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('abc', null, null, '2015-01-15 11:26:28', 'abc', 'd9eac52e85c89745df430ebbcdbf51c25f340400c378ed0984f9a9d0d31933a26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0');
INSERT INTO `operator` VALUES ('b78e8b2e-420a-4b98-92c6-17a927dfd120', null, null, '2015-01-14 16:57:22', 'user', 'd9eac52e85c89745df430ebbcdbf51c25f340400c378ed0984f9a9d0d31933a26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0');
INSERT INTO `operator` VALUES ('c204ceac-c2ef-4d15-af6e-4348695bcbc5', null, null, '2015-01-03 14:22:08', 'hxj123', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('c28212ed-9a7e-4bd5-909f-988b5089ed08', null, null, '2015-01-04 10:27:47', 'nina', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0');
INSERT INTO `operator` VALUES ('dea2fc81-a0da-4a13-a8e8-7a9c05a18b57', null, null, '2015-01-13 12:24:51', '547548789', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('e0e0643a-93a8-4a1c-a41d-43f4a6f01a3e', null, null, '2015-01-11 22:24:22', '0791sy', 'd850647350d822301ae3b3fe0d5bd57b99eb90b334b5bd98ce86477d3011f1a26e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '0');
INSERT INTO `operator` VALUES ('e2832b54-17e7-4406-ba2a-62af7a7b3385', 'xiaoming', '', '2014-12-05 11:36:56', '小明', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'cae61c58-113c-42cb-88d0-2e0cbc22ed63', '1');
INSERT INTO `operator` VALUES ('ea894836-dcad-4206-80a9-c9d90784160e', null, null, '2015-01-03 14:12:41', 'huanghuang', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('f292f8ac-4b1e-4b62-bca8-0cf752dcc9c6', null, null, '2015-01-04 11:22:06', 'test7', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0');
INSERT INTO `operator` VALUES ('f61f4360-4092-48e5-9066-9684934c65b2', '普通注册会员', '', '2014-08-28 11:56:08', 'user2', '49449660afe4e5539fbf9a2ffb721b71', '2daae34e-274d-4661-b8da-e4891c83948e', '1');
INSERT INTO `operator` VALUES ('f9691425-29da-4c3d-a3a4-f9b62bc3105b', '谭水龙', '', '2015-01-14 21:40:14', 'shuilong', '33f832a077d10f48de98a5b0f9bd7c03c8b4bb3cce9d6223a6c93bb9ab1a69cb6e8662b6d7f37c27', '1', '0');
INSERT INTO `operator` VALUES ('f9691425-29da-4c3d-a3a4-f9b62bc3105h', null, null, '2015-01-23 17:18:36', 'liang', 'd9eac52e85c89745df430ebbcdbf51c25f340400c378ed0984f9a9d0d31933a26e8662b6d7f37c27', '1', '0');
INSERT INTO `operator` VALUES ('test1', null, null, '2014-12-05 14:54:07', 'test1', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '1');
INSERT INTO `operator` VALUES ('test2', null, null, '2014-12-05 14:54:30', 'test2', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '1');
INSERT INTO `operator` VALUES ('test3', null, null, '2014-12-05 14:54:51', 'test3', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `privilege` int(11) default NULL,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `orderNum` varchar(20) default NULL,
  `userId` varchar(36) default NULL,
  `consignee` varchar(20) default NULL,
  `consigneePhone` varchar(20) default NULL,
  `deliveryAddress` varchar(200) default NULL,
  `number` int(11) default NULL,
  `lockId` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for radio
-- ----------------------------
DROP TABLE IF EXISTS `radio`;
CREATE TABLE `radio` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `word` text NOT NULL COMMENT '广播内容',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of radio
-- ----------------------------
INSERT INTO `radio` VALUES ('1709638b-e680-41d5-b96d-d95ad9a3f8e2', null, null, '2015-01-01 20:05:13', '今日特价商品如下：康耐尔特价888元起。');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '1',
  `rank` int(11) default NULL,
  `score` int(11) default NULL,
  `type` int(11) default NULL,
  `title` varchar(255) default NULL,
  `resDescribe` text,
  `address` varchar(200) default NULL,
  `uploaderName` varchar(100) default NULL,
  `downloadNum` int(11) default NULL,
  `carName` varchar(45) NOT NULL,
  `carType` varchar(45) default NULL,
  `carCountry` varchar(36) default NULL,
  `resourceType` varchar(45) NOT NULL,
  `dataType` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for resource_copy
-- ----------------------------
DROP TABLE IF EXISTS `resource_copy`;
CREATE TABLE `resource_copy` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `rank` int(11) default NULL,
  `score` int(11) default NULL,
  `type` int(11) default NULL,
  `title` varchar(255) default NULL,
  `describe` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_copy
-- ----------------------------
INSERT INTO `resource_copy` VALUES ('0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a', 'huang', '1', '2013-11-27 16:38:26', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for resourceofsoftware
-- ----------------------------
DROP TABLE IF EXISTS `resourceofsoftware`;
CREATE TABLE `resourceofsoftware` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '1',
  `rank` int(11) default NULL,
  `score` int(11) default NULL,
  `title` varchar(255) default NULL,
  `resDescribe` text,
  `address` varchar(200) default NULL,
  `uploaderName` varchar(100) default NULL,
  `downloadNum` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resourceofsoftware
-- ----------------------------
INSERT INTO `resourceofsoftware` VALUES ('016d7eac-4fe5-4f81-8f09-44a2245e4d86', null, null, '2015-01-20 00:05:13', '1', '0', '0', '福特计算器 USB 驱动', '', '!/lockMgr/file/resource/1501200004576.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('03d1d0e7-030a-4f4b-9c19-4f8a5e81711b', null, null, '2015-01-19 23:39:52', '1', '0', '5', 'AK90 3.16软件', '', '!/lockMgr/file/resource/15011923393329.zip', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('0706a757-64e3-433e-a465-60d04acd00f1', null, null, '2015-01-19 23:45:42', '1', '0', '5', '宝马OBD  7.4', '', '!/lockMgr/file/resource/15011923453813.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('09472cc8-6b5d-4400-88e4-e5c74e9235ab', null, null, '2015-01-20 00:06:41', '1', '0', '5', '福特计算器1.1升级文件', '', '!/lockMgr/file/resource/15012000063041.zip', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('19f69603-644e-4e5f-9758-cafd2031ae4e', null, null, '2015-01-19 23:54:46', '1', '0', '5', 'VVDI  2.81软件', '', '!/lockMgr/file/resource/15011923535334.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('1a875ec7-abf8-4236-bb94-399e6e40fe2c', null, null, '2015-01-19 23:56:50', '1', '0', '0', 'VVDI遥控生成仪 2.1', '<a>确定添加</a>	         ', '!/lockMgr/file/resource/15011923561855.zip', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('1c656cff-99ff-484e-87ef-74adede31ac1', null, null, '2015-01-20 00:10:40', '1', '0', '5', '奇瑞密码计算器', '', '!/lockMgr/file/resource/15012000102558.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('250e8f88-23e2-475d-87b9-ebac2a41f1a0', null, null, '2015-01-19 23:59:05', '1', '0', '0', 'XP驱动软件', '', '!/lockMgr/file/resource/15011923585038.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('2702949a-aba5-44b8-b47e-f073ab7935f7', null, null, '2015-01-20 00:04:44', '1', '0', '0', '福特计算器使用说明', '', '!/lockMgr/file/resource/15012000043093.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('3fca6051-52d5-4980-8172-bfc2ecda383c', null, null, '2015-01-19 23:37:00', '1', '0', '5', '46拷贝机说明', '', '!/lockMgr/file/resource/1501192336472.doc', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('472381d4-a099-4601-984a-bcba04a74308', null, null, '2015-01-19 23:57:27', '1', '0', '5', 'VVDI 遥控生成仪V3.1', '', '!/lockMgr/file/resource/1501192357034.zip', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('4dd25178-35d9-4ffa-98d5-f0093b86aef2', null, null, '2015-01-19 23:59:36', '1', '0', '0', 'XP  使用方法', '', '!/lockMgr/file/resource/15011923592110.doc', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('4df7ca40-45da-4374-afc1-b56a8a82219d', null, null, '2015-01-20 00:08:57', '1', '0', '10', '现代8位密码计算软件', '', '!/lockMgr/file/resource/15012000083627.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('5737283f-7467-41c8-9b74-50d650fe837c', null, null, '2015-01-20 00:05:57', '1', '0', '5', '福特计算器 激活充值软件', '', '!/lockMgr/file/resource/15012000053977.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('60789dbc-3fbb-45d8-bc5f-85629bf9c671', null, null, '2015-01-19 23:39:11', '1', '0', '10', 'CAS4+配钥匙说明', '', '!/lockMgr/file/resource/1501192338471.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('64ea3c8d-3bb2-464b-aaf3-5cf1d837f484', null, null, '2015-01-20 00:12:56', '1', '0', '5', '最新KD100 软件', '', '!/lockMgr/file/resource/15012000124614.zip', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('8d752a0a-290a-4a57-9799-294c43195921', null, null, '2015-01-19 23:47:25', '1', '0', '5', 'H618 V1318.32924CN', '', '!/lockMgr/file/resource/15011923461068.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('8d84faab-09f6-4b6a-ba74-7daa3aae60a1', null, null, '2015-01-20 00:02:07', '1', '0', '0', '艾迪900 长时间没有升级解决方法', '', '!/lockMgr/file/resource/15012000014549.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('9e2c3d39-9328-477f-9624-89cd306585b8', null, null, '2015-01-20 00:02:54', '1', '0', '5', '奔驰计算器', '', '', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('a0c9cc0a-4937-42d6-a125-4ff528c91034', null, null, '2015-01-19 23:48:18', '1', '0', '0', '探戈  软件购买价格表', '', '!/lockMgr/file/resource/15011923475247.xls', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('ae41492f-a836-44cc-8c72-8d4f43f08a48', null, null, '2015-01-19 23:38:20', '1', '0', '5', 'XP 523 软件', '', '!/lockMgr/file/resource/15011923381718.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('b0958bf1-266f-47cd-b9c9-5cd2268bc8b3', null, null, '2015-01-19 23:48:41', '1', '0', '0', '探戈驱动', '', '!/lockMgr/file/resource/15011923483272.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('c1c55a33-3843-43a9-b838-895e1f906ddd', null, null, '2015-01-20 00:07:21', '1', '0', '5', '海马46芯片密码算法', '', '!/lockMgr/file/resource/15012000070175.zip', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('d16fb33f-8d7b-43f9-958d-294bf1ff1734', null, null, '2015-01-19 23:55:22', '1', '0', '5', '艾迪900 升级软件', '', '!/lockMgr/file/resource/15011923551056.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('d74a7271-e745-4e29-a2ff-294c8131e9db', null, null, '2015-01-20 00:11:22', '1', '0', '5', '芯尼桑计算软件', '', '!/lockMgr/file/resource/15012000112014.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('d7dac3b5-b38f-4225-a2a6-321a496fc20e', null, null, '2015-01-20 00:08:02', '1', '0', '5', '金山快译', '', '!/lockMgr/file/resource/15012000075491.rar', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('de72fd0e-4e1c-475a-9af5-6e421d842270', null, null, '2015-01-19 23:43:52', '1', '0', '5', '宝马OBD 7.3 软件', '', '', 'liang', '0');
INSERT INTO `resourceofsoftware` VALUES ('f6ecd990-5673-48d2-8e7d-70bdb002fbac', null, null, '2015-01-19 23:36:35', '1', '0', '5', '探戈1.97.1替换文件', '', '!/lockMgr/file/resource/15011923362948.zip', 'liang', '0');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text COMMENT '存放图片处(如果有的话)',
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `newsId` varchar(36) default NULL,
  `userId` varchar(36) default NULL,
  `showOrder` int(11) default NULL,
  `content` text,
  `userName` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('0a2cae7b-a5bd-49c6-a609-eb75de5b3568', null, null, '2014-07-19 16:11:49', '0', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '大大大', 'user1');
INSERT INTO `review` VALUES ('18e917e3-176d-4f04-a330-8f2da3212809', null, null, '2014-12-21 14:27:38', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133s', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '0', '萨法', 'user1');
INSERT INTO `review` VALUES ('2fbd3237-4306-47ff-a532-8479770eb6a9', null, null, '2014-09-10 10:00:56', '0', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '0', '9.10aajmwtpgjmdajunwtp', 'user1');
INSERT INTO `review` VALUES ('33dce8a6-2f34-44a7-b7f6-2bed2aa5c95f', null, null, '2014-07-19 15:20:03', '0', 'ea8f5eb9-8432-4a55-9864-0aa2ffd7f7f1', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '凤飞飞', 'user1');
INSERT INTO `review` VALUES ('41f90974-9c2b-42b7-9a9d-4b29aa930b4a', null, null, '2014-07-19 15:49:04', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133a', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '我简单来说', 'user1');
INSERT INTO `review` VALUES ('4e371a27-e7f9-4f5f-82fe-7ae9c5ccd7b1', null, null, '2014-07-19 16:12:24', '0', 'ea8f5eb9-8432-4a55-9864-0aa2ffd7f7f1', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '凤飞飞', 'user1');
INSERT INTO `review` VALUES ('50392e11-dc9c-4a66-94d1-b8bf78d8084f', null, null, '2014-12-21 14:27:57', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133s', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '0', 'f d', 'user1');
INSERT INTO `review` VALUES ('5131f130-9af5-48a5-890a-a85359a4a57b', null, null, '2014-06-18 11:01:12', '0', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '以后还不', '小明');
INSERT INTO `review` VALUES ('5bc3b704-4505-446a-abd6-e624cc26b99d', null, null, '2014-07-21 15:51:37', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133a', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '啦啦啦', 'user1');
INSERT INTO `review` VALUES ('6090749f-aba6-4904-904d-a40053c7563f', null, null, '2014-12-21 10:09:02', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133s', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '0', 'hhh', 'user1');
INSERT INTO `review` VALUES ('6991c528-45b7-4898-8f78-e8fc9f29077b', null, null, '2014-07-19 16:12:24', '0', 'ea8f5eb9-8432-4a55-9864-0aa2ffd7f7f1', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '凤飞飞', 'user1');
INSERT INTO `review` VALUES ('6df3a68b-1121-4292-a8f0-cc5a88e489ec', null, null, '2014-08-03 18:58:20', '0', 'ea8f5eb9-8432-4a55-9864-0aa2ffd7f7f1', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '不错', 'user1');
INSERT INTO `review` VALUES ('7880a996-0680-4375-a227-49d7c7b802ce', null, null, '2014-08-04 23:54:30', '0', '333cc570-e8a1-4a9c-a472-3021802546f9', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '8888', 'user1');
INSERT INTO `review` VALUES ('7a0f18ef-be81-49ca-848e-d4e614d6d329', null, null, '2014-05-23 14:42:48', '0', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '6f7581ec-91e5-4a21-b410-e127a37178ed', '0', '5月23', '小小');
INSERT INTO `review` VALUES ('868b92f4-3540-430d-a3e0-b0a8797b2e26', null, null, '2014-07-19 15:22:20', '0', 'ea8f5eb9-8432-4a55-9864-0aa2ffd7f7f1', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', 'CCC', 'user1');
INSERT INTO `review` VALUES ('8964f187-3c19-4a64-adff-08500d8df152', null, null, '2014-08-04 23:54:00', '0', '333cc570-e8a1-4a9c-a472-3021802546f9', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '没见', 'user1');
INSERT INTO `review` VALUES ('c1950304-a266-43ad-a004-53fbce77232c', null, null, '2014-12-21 15:41:52', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133s', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '0', '烦烦烦', 'user1');
INSERT INTO `review` VALUES ('e997c05f-2a88-4d83-ace6-692bccd07969', null, null, '2014-07-17 15:33:01', '0', '9df963ca-b4b7-47d8-b249-7fc40d66133a', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', 'ddddd', 'user1');
INSERT INTO `review` VALUES ('eb2754e9-b267-43ad-8f31-d2d7d37773d1', null, null, '2014-07-19 15:50:03', '0', '31ad0d72-da34-4a03-8212-da4e13ca48f2', 'f61f4360-4092-48e5-9066-9684934c65b1', '0', '大地发', 'user1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员', '2014-09-16 10:17:00', '0');
INSERT INTO `role` VALUES ('4195f48e-6aba-466f-bdda-8152fb10074d', 'VIP', 'VIP', '2014-12-22 18:23:51', '0');
INSERT INTO `role` VALUES ('85431849-d438-4f20-986d-a5ffebdd11a6', '同行', '权限略小于商户(验证会员),作用是可以查看批发商户.', '2014-12-27 09:46:51', '0');
INSERT INTO `role` VALUES ('91b61db6-397f-4c64-b7b5-a575c3c70281', '商户', '商户', '2014-12-01 09:54:18', '0');
INSERT INTO `role` VALUES ('a6ec52b8-4e56-4856-aa25-547348e66ebc', '普通注册用户', '普通注册用户', '2014-09-16 10:18:06', '0');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `roleId` varchar(36) NOT NULL,
  `menuId` varchar(36) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('099657a6-7864-4c53-94aa-2a03558300a8', null, null, '2014-07-12 16:28:31', '0', '1', '10614202-6f7f-49f1-8b78-edc091038414');
INSERT INTO `role_menu` VALUES ('09da3f74-3303-4293-87d3-c94d8c1d1b0c', null, null, '2014-07-23 16:36:22', '0', '1', 'bcadb20e-776d-40d4-bfee-c7a91501b84a');
INSERT INTO `role_menu` VALUES ('12c86dc7-9aa2-4e14-b630-4e05b3865af6', null, null, '2014-12-01 11:07:34', '0', '1', '2f4e4fa6-6887-4ecd-b2d2-28baf1d5908e');
INSERT INTO `role_menu` VALUES ('1477a141-7ecf-4f99-81b6-ed35d1a63bbf', null, null, '2014-12-01 09:57:50', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '');
INSERT INTO `role_menu` VALUES ('173f9813-d780-41f8-9be1-1d52ef2e0cfc', null, null, '2015-01-21 00:23:38', '0', '85431849-d438-4f20-986d-a5ffebdd11a6', '153f0e3e-8e27-4a43-a837-bc4e67e1c20e');
INSERT INTO `role_menu` VALUES ('17b50f88-52c7-4805-80cc-9ad3e63cce04', null, null, '2014-09-16 10:14:59', '0', '1', '1');
INSERT INTO `role_menu` VALUES ('1a4c835d-cc09-4d9b-818c-04c7990e4ffe', null, null, '2014-07-12 00:09:15', '0', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '10614202-6f7f-49f1-8b78-edc091038414');
INSERT INTO `role_menu` VALUES ('1bdccdd5-76b5-4c1e-8e11-44ea3f704a2b', null, null, '2014-08-05 16:00:01', '0', '1', '3e8af635-708c-4d60-aab3-34915f012e70');
INSERT INTO `role_menu` VALUES ('206e26c2-b2fb-4f45-84fe-537b60ee5726', null, null, '2014-04-18 20:41:26', '0', '1', '08361483-20a2-4606-a5e8-4e80ad3387b6');
INSERT INTO `role_menu` VALUES ('24234dfc-a057-48b7-a990-b70086f0f4d7', null, null, '2014-08-05 16:00:01', '0', '1', '450f0b03-e3ab-4e35-965a-e6f17406b93a');
INSERT INTO `role_menu` VALUES ('2b825fba-efc7-4ead-8861-28b3a2127110', null, null, '2014-12-01 09:57:53', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', 'bcadb20e-776d-40d4-bfee-c7a91501b84a');
INSERT INTO `role_menu` VALUES ('2e80d6be-4b88-44c1-a438-47dfd787889a', null, null, '2014-04-27 21:42:33', '0', '1', 'a1eb035e-f750-452d-8a97-0d8605dcd0dc');
INSERT INTO `role_menu` VALUES ('2f11affd-7cd6-4d1c-b562-a4b09f6fc1d9', null, null, '2014-04-21 20:06:51', '0', '1', '3cedbd0b-afb1-4ac6-9fc9-6919e3113efb');
INSERT INTO `role_menu` VALUES ('3244f237-99be-4588-b208-bbcfe4701c99', null, null, '2014-08-05 16:00:01', '0', '1', 'f44c0542-ee7d-4d48-9b92-2d10c870631f');
INSERT INTO `role_menu` VALUES ('33434404-889d-438e-b113-21b9276bada2', null, null, '2014-12-01 11:06:46', '0', '1', '15c5303b-ebd9-4239-bee1-2a87e092aa05');
INSERT INTO `role_menu` VALUES ('38885434-581e-47c0-b9d6-1d3410de146c', null, null, '2014-04-21 20:06:51', '0', '1', '19e904d1-e02d-46b1-807e-d5b43ddcaed2');
INSERT INTO `role_menu` VALUES ('39ecb8e7-c165-4661-9d3f-8d081481b895', null, null, '2014-12-01 09:57:57', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '3cedbd0b-afb1-4ac6-9fc9-6919e3113efb');
INSERT INTO `role_menu` VALUES ('3d8f2a78-2b04-47b5-829a-c7db65bfa933', null, null, '2015-01-21 00:26:20', '0', '4195f48e-6aba-466f-bdda-8152fb10074d', '153f0e3e-8e27-4a43-a837-bc4e67e1c20e');
INSERT INTO `role_menu` VALUES ('3e9253fe-29bf-4ca9-8f89-8dcc9cb1b61e', null, null, '2014-04-27 21:42:33', '0', '1', 'c74e14f3-a300-4904-8a9d-0ed6903a51a2');
INSERT INTO `role_menu` VALUES ('40f38af6-ddb2-4ccc-99bb-5625f0f031d6', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', 'f44c0542-ee7d-4d48-9b92-2d10c870631f');
INSERT INTO `role_menu` VALUES ('553f0c5a-49ea-4b24-bfb1-4da38e1f1603', null, null, '2014-05-10 20:47:53', '0', '1', 'e3caf782-a74e-49ec-88f5-39342e5c5c6c');
INSERT INTO `role_menu` VALUES ('65e5a9d4-be68-4836-8293-6c689fbe9fa8', null, null, '2014-11-29 16:42:34', '0', '1', '2');
INSERT INTO `role_menu` VALUES ('6752127a-8236-4aa7-b03e-973d5a216b71', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '3e8af635-708c-4d60-aab3-34915f012e70');
INSERT INTO `role_menu` VALUES ('6e9bba56-f11f-4774-aa7e-aa45ed855d9e', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '153f0e3e-8e27-4a43-a837-bc4e67e1c20e');
INSERT INTO `role_menu` VALUES ('739d2b1d-0ef9-4f34-9273-819d1ee9f5cb', null, null, '2014-05-10 20:47:53', '0', '1', '4c84ed0f-41db-42bb-94eb-4926e223e4eb');
INSERT INTO `role_menu` VALUES ('7913b9c9-78bf-4cc4-8b21-9e7a129c9f87', null, null, '2014-12-06 15:47:14', '0', '1', '8ee52458-a69f-453f-a738-a621db870b55');
INSERT INTO `role_menu` VALUES ('7dd60155-4c80-45e3-873e-66798c7cf1b7', null, null, '2014-06-19 16:02:37', '0', '1', '14f69e64-61f1-4da9-b4b7-aa5d1812ba8c');
INSERT INTO `role_menu` VALUES ('7dd60155-4c80-45e3-873e-66798c7cfdc7', null, null, '2014-11-03 10:53:53', '0', '1', '14f69e64-61f1-4da9-b4b7-aa5d1812bid0');
INSERT INTO `role_menu` VALUES ('7f2ba8e8-79e0-41a4-9ff8-18fcfde1531a', null, null, '2014-12-01 11:06:18', '0', '1', '8cfb8e4e-9909-4c4d-a23e-02b8db083635');
INSERT INTO `role_menu` VALUES ('8264f21d-8baf-4c12-8c6d-5928da446081', null, null, '2014-04-16 22:32:26', '0', '1', 'e99e85d5-e809-46b1-aa02-a9da03d0a0b8');
INSERT INTO `role_menu` VALUES ('835dd7c4-e05a-4e7f-8fbb-e85d042a5cec', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '3cedbd0b-afb1-4ac6-9fc9-6919e3113efb');
INSERT INTO `role_menu` VALUES ('a968688f-8d98-41dd-8fcf-52787fc53da8', null, null, '2014-04-16 22:32:26', '0', '1', '153f0e3e-8e27-4a43-a837-bc4e67e1c20e');
INSERT INTO `role_menu` VALUES ('ab58a435-915b-46a9-a8f4-440806bfab4f', null, null, '2014-12-01 09:58:04', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', 'f44c0542-ee7d-4d48-9b92-2d10c870631f');
INSERT INTO `role_menu` VALUES ('af188663-f517-47b0-a9f5-bb47e6028ad8', null, null, '2014-12-01 09:58:04', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '450f0b03-e3ab-4e35-965a-e6f17406b93a');
INSERT INTO `role_menu` VALUES ('b0bab276-8edd-4a97-8e65-a27dc330ed94', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '10614202-6f7f-49f1-8b78-edc091038414');
INSERT INTO `role_menu` VALUES ('b21238ba-dd30-4760-8cc8-232894ecd388', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '450f0b03-e3ab-4e35-965a-e6f17406b93a');
INSERT INTO `role_menu` VALUES ('b5b702e2-361a-471b-9c5d-bcbca4f4dbd9', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '19e904d1-e02d-46b1-807e-d5b43ddcaed2');
INSERT INTO `role_menu` VALUES ('bb70868b-6c5d-477a-9e38-e5553b3b5bb5', null, null, '2014-09-12 15:51:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', 'bcadb20e-776d-40d4-bfee-c7a91501b84a');
INSERT INTO `role_menu` VALUES ('c40449f8-316e-4b9a-b0f8-51348a765830', null, null, '2014-12-01 09:58:07', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '19e904d1-e02d-46b1-807e-d5b43ddcaed2');
INSERT INTO `role_menu` VALUES ('cfe8330c-f564-4442-8203-49ac4af0476f', null, null, '2014-06-17 16:36:40', '0', '1', 'f3725eaf-ea0d-451f-af77-cfde3e073f05');
INSERT INTO `role_menu` VALUES ('dd7d2ec6-06d3-4d57-ad1e-97a3fd016a76', null, null, '2014-12-01 09:58:09', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', '3e8af635-708c-4d60-aab3-34915f012e70');
INSERT INTO `role_menu` VALUES ('e6a08a42-ac9c-475d-b3b7-552740205dd1', null, null, '2015-01-21 00:23:38', '0', '85431849-d438-4f20-986d-a5ffebdd11a6', '10614202-6f7f-49f1-8b78-edc091038414');
INSERT INTO `role_menu` VALUES ('e799de1a-3d76-475e-97dd-474c650ab619', null, null, '2014-07-12 00:09:15', '0', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '153f0e3e-8e27-4a43-a837-bc4e67e1c20e');
INSERT INTO `role_menu` VALUES ('e7bfd1c2-b00f-4941-adfe-49f7d056b89b', null, null, '2014-08-31 14:17:12', '0', '1', '47f1adf0-393a-4e59-87d4-81ec029d4864');
INSERT INTO `role_menu` VALUES ('e8b0801b-1873-491c-ab3c-88372b19cf5a', null, null, '2015-01-21 00:26:20', '0', '4195f48e-6aba-466f-bdda-8152fb10074d', '10614202-6f7f-49f1-8b78-edc091038414');
INSERT INTO `role_menu` VALUES ('ea3fd1a3-5399-47c7-abc0-ad17e8634c04', null, null, '2014-12-22 10:52:10', '0', '1', 'c12ffe7b-5da1-49ea-acbf-890f8fa3cebf');
INSERT INTO `role_menu` VALUES ('ee468daa-584d-4744-991c-285e58a17d3d', null, null, '2014-12-01 11:04:36', '0', '1', 'd5ea81e9-72be-4ab8-ac63-98f3b1fd644e');
INSERT INTO `role_menu` VALUES ('ffdb23ed-efe7-4708-91b4-8ffd409d01d3', null, null, '2014-11-29 14:51:53', '0', '1', 'd24d64ce-fcff-40ec-9a33-9c15714aaf90');
INSERT INTO `role_menu` VALUES ('haha1', null, null, '2014-10-17 16:14:41', '0', '1', 'e6676084-7de0-46ee-ac65-62fd9219f71c');
INSERT INTO `role_menu` VALUES ('haha2', null, null, '2014-10-17 16:14:47', '0', '1', '341770f7-612b-4e3b-9943-54643a13a86e');
INSERT INTO `role_menu` VALUES ('haha3aa', null, null, '2014-12-01 09:58:14', '0', '91b61db6-397f-4c64-b7b5-a575c3c70281', 'e6676084-7de0-46ee-ac65-62fd9219f71c');

-- ----------------------------
-- Table structure for rotatepicture
-- ----------------------------
DROP TABLE IF EXISTS `rotatepicture`;
CREATE TABLE `rotatepicture` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` datetime default NULL,
  `type` int(11) NOT NULL COMMENT '1，代表首页轮播图片；2，代表论坛轮播图片。',
  `status` int(11) NOT NULL COMMENT '0，代表不可用；1，代表可用状态。',
  `address` varchar(45) NOT NULL COMMENT '图片地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rotatepicture
-- ----------------------------
INSERT INTO `rotatepicture` VALUES ('11fd20a8-71dd-496d-8ca2-c4b910b0654e', null, null, '2015-01-19 22:27:41', '2', '1', '15011922273368.jpg');
INSERT INTO `rotatepicture` VALUES ('1bb5354b-eb6d-4a1f-92b0-dc0fc09c2216', null, null, '2015-01-21 16:38:50', '2', '1', '15012116384940.jpg');
INSERT INTO `rotatepicture` VALUES ('563ad894-fcef-4c11-ae3a-2e1cc91b2c14', null, null, '2015-01-19 22:17:03', '1', '1', '15011922165939.jpg');
INSERT INTO `rotatepicture` VALUES ('64d6ddb9-50f3-41b5-8614-6ae77c572530', null, null, '2015-01-19 22:31:08', '1', '1', '15011922310288.jpg');
INSERT INTO `rotatepicture` VALUES ('ba9ff525-4148-4903-928e-8b0c6001b42b', null, null, '2015-01-19 22:21:08', '1', '1', '15011922210174.jpg');
INSERT INTO `rotatepicture` VALUES ('db49bfd2-f489-4833-a8fd-59bda75cbc32', null, null, '2015-01-21 16:38:41', '2', '1', '15012116383911.jpg');

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `userId` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syslog
-- ----------------------------
INSERT INTO `syslog` VALUES ('0008bc1b-88b8-49d7-b45f-52e11fdf7d1f', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:02:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('00fbae41-980b-4847-937a-3393da8a57da', '修改', '【shuilong】修改操作权限4195f48e-6aba-466f-bdda-8152fb10074d', '2015-01-21 00:26:20', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('0175c6c0-3d11-4fc1-b4af-5fc7c0553de2', '修改', '【liang】修改商户信息【null】', '2014-09-22 00:54:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('01d24e32-11f2-40f9-89f6-698c863d57d0', '修改', '【huang】修改团购商品信息【null】', '2014-08-01 11:11:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0291e2a9-e4b4-4176-990c-38432bb08947', '修改', '【huang】修改角色【测试】', '2014-09-12 15:50:20', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('02a0b96f-33f0-4f27-b3ca-3c1ea5e2216c', '修改', '【liang】修改操作权限91b61db6-397f-4c64-b7b5-a575c3c70281', '2014-12-01 11:20:09', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('02c417c9-6f27-48e3-89fd-b3391f759de6', '添加', '【huang】添加菜单【车类管理】', '2014-06-17 15:59:48', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0359b423-be0e-4f89-937b-f258c7ad0c61', '删除', '【huang】删除资源【null】', '2014-06-29 16:55:04', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('051632a0-caf7-49e0-99bb-1281ea696eac', '删除', '【huang】删除操作员【test】', '2014-07-12 16:33:07', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('077cf195-2d66-4509-9ba9-d905ca91bf65', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0782c5c2-1f4f-419d-954b-895cf44a7e15', '添加', '【liang】添加滚动图片【null】', '2014-12-21 23:28:31', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('07abcc3c-2bf1-4f2a-8a2d-07eed29fe09b', '审核', '【huang】审核商户【huang】', '2014-09-03 17:04:47', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0960b2d1-b1a0-49d0-98e9-6b363488f0b5', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:18:48', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('098e97b3-14d1-4394-bf74-bda7a26bdee0', '修改', '【liang】修改操作权限1', '2014-09-16 10:13:56', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('0a37f790-a796-4ac6-93c9-d51843c9f798', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:03:11', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('0ae31069-057f-42a2-9ae3-e438aea6b7aa', '审核', '【shuilong】审核商户【shuilong】', '2015-01-11 23:18:54', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('0b3c2a70-0f7b-4ecd-b045-f32a8865fc15', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:08:54', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('0c6f05ff-b300-428f-bd90-6fd056ce4c23', '删除', '【shuilong】删除车类【null】', '2015-01-20 22:56:45', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('0d27368f-afcd-4e2f-bcb6-a8d36d470436', '删除', '【huang】删除角色【测试】', '2014-09-12 15:50:30', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0d813104-a746-4c75-b25c-139b96e61581', '添加', '【huang】添加资源【null】', '2014-06-15 14:59:53', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0df41338-3caf-4a4b-aa2d-37be8d2e0c1d', '添加', '【liang】添加滚动图片【null】', '2015-01-21 16:38:41', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('0e235fc8-2930-46c9-9e5d-c6249936ce3c', '修改', '【huang】修改操作权限1', '2014-07-12 16:28:31', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('0eb55807-e502-4b85-95ae-0bb78ce76f49', '添加', '【liang】添加车类【null】', '2015-01-20 23:09:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('0fb73680-01bb-40e1-877f-1f1d5e5918b9', '删除', '【liang】删除团购商品信息【O型丝扣锁】', '2014-09-17 10:17:56', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('1196949b-72ae-4445-a15f-10761bc4e868', '添加', '【user1】添加商品【bbb】', '2014-07-21 11:15:47', 'ca2a697e-b868-4d9f-aff1-66b03a0ed785');
INSERT INTO `syslog` VALUES ('121222c7-f28c-4d80-a2b1-a9988e1aa185', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('13264d7b-5f88-4d25-a105-5f716dc5f032', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('13513207-da69-4667-9113-49e4df18872a', '删除', '【liang】删除资源【null】', '2015-01-21 00:31:24', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('1383fec3-ebb0-489a-a6d5-b9be38770019', '修改', '【shuilong】修改滚动图片【null】', '2015-01-10 23:30:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('13ad62da-8c2e-493a-be35-680dc19d90a7', '删除', '【liang】删除角色【测试123】', '2014-09-16 15:15:04', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('13b3e92a-5cf9-434b-ab43-e820cca0fa6f', '删除', '【liang】删除操作员【liang】', '2015-01-23 17:51:42', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('13b5708e-6d62-4b06-aaa8-08a5d233c9e8', '修改', '【shuilong】修改滚动图片【null】', '2015-01-19 22:21:08', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('13c1df4b-7916-492f-b3f2-d5fa9ccef6b5', '添加', '【shuilong】添加车类【null】', '2015-01-20 23:07:57', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('15a667f9-1ef8-49db-a21d-2703c827af2a', '修改', '【huang】修改操作权限1', '2014-07-12 00:09:07', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('15c1fb2b-f320-4aec-8bc9-e163ab11a419', '删除', '【huang】删除资源【null】', '2014-06-29 11:48:07', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('15d9ae20-b00f-4200-a3be-404e24019a74', '添加', '【liang】添加会员【test7】', '2015-01-04 11:22:06', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('15e8384f-99a0-446d-8722-55a8afc3244c', '修改', '【huang】修改角色【普通注册用户】', '2014-09-12 16:09:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('1711b630-4ebe-4016-a7ed-0f8f4a9a96fc', '删除', '【huang】删除团购商品信息【null】', '2014-07-29 09:23:56', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('17be6838-5be6-4ac4-9e20-4ca46ba3fe81', '删除', '【liang】删除滚动图片【null】', '2015-01-01 20:01:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('17e1a0f1-5615-41e1-a752-f814a341c5f4', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('181f6b10-f0aa-4897-a472-cb8568eaa783', '修改', '【huang】修改操作权限91b61db6-397f-4c64-b7b5-a575c3c70281', '2014-09-12 15:51:07', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('184a063f-b05e-4581-ab56-a29220a10dee', '添加', '【huang】添加操作员【test】', '2014-07-12 00:09:35', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('191fc13d-4afe-48cb-baa1-e5337616b73a', '删除', '【huang】删除商品信息【2】', '2014-07-01 17:05:03', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('19c643f8-4ca5-4692-a6d6-66cdc3bd3993', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('1a0de3d9-d03d-44a9-af70-59f45d1c7591', '删除', '【user1】删除商品信息【aa】', '2014-12-26 20:56:45', '4a3b0049-2c3b-43d7-94c6-102dc779fa16');
INSERT INTO `syslog` VALUES ('1b0cce11-c917-4236-8c8d-f97ea01574ed', '修改', '【liang】修改商户信息【null】', '2014-09-15 15:42:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('1b1ed3e1-0803-40b4-ab81-ca68d2dbaec1', '添加', '【liang】添加滚动图片【null】', '2014-12-20 13:34:34', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('1b2ef5a0-4538-436d-8548-8158e0b65034', '删除', '【liang】删除车类【null】', '2015-01-21 00:06:12', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('1c348f8e-c7d8-45a4-b66f-77019f222d15', '审核', '【huang】审核商户【huang】', '2014-08-31 13:21:48', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('1d55b421-a752-4539-8373-52e7aa2058aa', '删除', '【huang】删除角色【测试】', '2014-09-12 16:22:15', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('1e7d55b6-7218-4f12-8bfe-575188c49b8f', '添加', '【liang】添加滚动图片【null】', '2014-11-12 10:41:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('1ed2d840-c264-49e4-b481-fdc1fa5113e4', '修改', '【huang】修改操作权限1', '2014-06-17 16:36:40', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('1f17dd6d-cc93-41c8-8d68-a5adb9bfec33', '审核', '【shuilong】审核商户【null】', '2015-01-11 23:29:21', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('1f4638d9-de09-411f-9a40-c121de7ad19a', '审核', '【huang】审核商户【xiaoA】', '2014-06-19 16:52:26', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('1f78468a-f15d-492f-adbf-7b9a3f613d09', '修改', '【huang】修改角色【商户】', '2014-09-12 16:04:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2092b9d1-dcc7-4df3-b844-9357a460e5ff', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('211442c0-5e1f-480f-9602-aec87bc370d5', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('22f265dd-3f62-42b3-b617-a58a6c74d319', '添加', '【huang】添加资源【null】', '2014-06-22 11:37:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('235d8aed-251e-4e10-a9b7-55a3f1f453b4', '添加', '【liang】添加滚动图片【null】', '2014-12-08 18:55:20', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('23e5e53d-947e-4c6f-aa99-64cf191de43d', '添加', '【liang】添加车类【null】', '2015-01-21 00:04:24', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('243428ac-ff00-4fd9-9bb1-2d9d8ec214cb', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('244b7c59-8a35-4109-870e-a441716d4d36', '添加', '【huang】添加操作员【谭水龙】', '2014-07-11 17:28:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('24a815ff-6fbe-4e7e-afff-d4a610c444ad', '审核', '【huang】审核商户【huang】', '2014-07-28 11:35:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2522edb9-f838-4a6b-808d-665939fc4e22', '添加', '【liang】添加滚动图片【null】', '2015-01-01 20:02:30', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('255f93cc-5381-495e-94f4-23f451e9785b', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('25779108-cff4-4aa8-90d8-422ace72c10c', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('25bcd8b2-8f9a-496d-8f85-9fc801de94be', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:10:57', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('2680ae56-5dfb-46d2-8325-b4cacbb11880', '添加', '【huang】添加资源【null】', '2014-07-17 15:13:35', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2802bc82-4aeb-41e4-aa81-d7e4567c8a44', '修改', '【shuilong】修改滚动图片【null】', '2015-01-10 23:09:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('28107a3f-1273-4bb5-af14-e0fee4716e62', '修改', '【huang】修改商品信息【t】', '2014-07-28 12:41:04', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('28a4f1c4-c462-4b73-8907-3e1de8060fe2', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:14:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('293aae3f-f8a8-4592-8f4e-23c23c7ecee2', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('29c9f0eb-33b2-4cc8-baa9-ee9fe0b8b477', '修改', '【huang】修改商品信息【t】', '2014-07-28 13:11:22', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2a2180b3-5115-48e6-b19f-44610eecfcb7', '删除', '【liang】删除滚动图片【null】', '2014-12-21 23:27:45', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('2a4b524f-c3a1-46d2-aba4-62154093a382', '修改', '【huang】修改操作权限1', '2014-07-12 16:27:20', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2b606ffb-680a-4901-a0a0-3e88cbc3885a', '删除', '【liang】删除车类【null】', '2015-01-21 01:06:28', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('2c584459-bfec-4bad-80ed-d78c999b9837', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:29:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2ce83ef2-39e0-44e9-9076-972cf15d23a2', '修改', '【huang】修改菜单【车类管理】', '2014-06-17 16:38:15', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2d2bdeec-628a-4555-b9ce-7819b493549e', '添加', '【huang】添加团购商品【null】', '2014-07-28 16:40:40', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2d2ca6ae-9ec7-4c02-98ad-63fcef505c69', '修改', '【huang】修改操作权限1', '2014-07-15 18:44:50', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2dd5fe8e-dee7-4b78-8d47-d8164227d957', '删除', '【liang】删除资源【null】', '2015-01-21 00:02:33', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('2e83e156-346d-4a47-aeb1-b2258e59e649', '修改', '【huang】修改论坛版块类型【lkj】', '2014-07-18 10:30:46', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('2feac9a9-a589-4952-9802-43a3657ae411', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('3021b20d-fde5-4ddf-afac-1e31fb0865fa', '修改', '【liang】修改商户信息【null】', '2014-09-22 00:55:42', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('31f96598-0612-46b4-aa59-5e6b3751f36f', '添加', '【huang】添加资源【null】', '2014-06-15 14:57:58', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('337c1ad6-de70-4225-9679-485c122afed0', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-05 16:57:45', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('337cbfa4-3474-4e59-b641-7f7d417e1afd', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('34057757-c186-4f92-b763-327dd7c17422', '添加', '【shuilong】添加会员【】', '2015-01-11 22:27:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('3452e586-f332-4c09-a6ce-8faf15bfc354', '删除', '【huang】删除团购商品信息【null】', '2014-07-29 09:23:56', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('3633eae0-5e82-46e0-9098-bae9f2ecf1a9', '删除', '【huang】删除操作员【huanm】', '2014-07-16 12:39:53', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('36eb23b8-ae7a-48ee-b21b-1c8cd9c57b73', '添加', '【liang】添加菜单【广告专区】', '2014-11-29 11:48:18', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('3758d96b-4f9b-49a3-9322-992bc241f15a', '删除', '【huang】删除论坛版块类型【lkj】', '2014-07-18 10:30:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('37d846fd-1b81-4819-96cc-a1d3a79a56b8', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:05:05', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('39769444-10df-4dac-a5ef-c1bc6cc1f829', '添加', '【huang】添加角色【普通注册用户】', '2014-09-12 16:22:58', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('39833311-3438-475d-8e75-8ac07f7a5547', '修改', '【liang】修改角色【测试123】', '2014-09-16 15:04:26', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('3ae0d559-3066-441e-b04b-111a98342664', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:03:28', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('3b237791-2b6d-460e-83e0-745672da314d', '修改', '【huang】修改角色【普通注册用户】', '2014-09-12 16:23:12', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('3d7a4faa-b55c-487b-99fc-75378ea46cc6', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:09:00', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('3de15465-d93d-4ede-879e-b510f0ea7050', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:10:09', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('3de4d979-9027-4e85-ac05-ca674e34cbe3', '撤销', '【user1】撤销提现申请【null】', '2014-10-24 16:41:01', '4a3b0049-2c3b-43d7-94c6-102dc779fa16');
INSERT INTO `syslog` VALUES ('3e966a3a-6dde-4849-b1a4-86b4bcb5ac10', '审核', '【huang】审核商户【common】', '2014-06-19 16:52:21', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('3eb59229-bd99-48b9-b6e4-b77fbd035d3e', '审核', '【liang】审核商户【liang】', '2015-01-23 14:32:54', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('3f26a803-d1e6-4e29-acfe-aee19e5136fb', '删除', '【huang】删除论坛版块类型【wwwwww】', '2014-07-05 16:50:34', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('3f714cfb-23ee-4d66-9b6a-f865c471cc70', '审核', '【shuilong】审核商户【0791sy】', '2015-01-21 00:50:40', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('3fec8921-bba3-4c20-b609-43d9351dc855', '添加', '【huang】添加团购商品【杂牌锁】', '2014-08-04 17:27:29', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('400a3cfe-55f5-443b-a6d6-593279d53aac', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('40cfc6e4-87de-4448-9298-aa1c602fda38', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:33:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('40dbb5d6-27ac-4593-9a03-1f7c101f7599', '删除', '【huang】删除车类【null】', '2014-07-05 16:16:40', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4173383a-7b5f-49c0-95ae-e2053768ff73', '添加', '【huang】添加车类【null】', '2014-08-03 09:31:49', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4212e746-2a39-4c20-bffd-64b31393b67b', '添加', '【huang】添加菜单【帖子类型管理】', '2014-06-19 16:02:27', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('426563c3-7d71-438f-a5a6-5c4d907bfe32', '添加', '【liang】添加滚动图片【null】', '2014-12-19 12:52:27', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('426bd370-77a8-4547-aec8-d3597cbd3685', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('44125754-ceef-442e-9e19-781bad29fb96', '添加', '【huang】添加菜单【测试菜单】', '2014-09-12 15:52:02', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('44eca7da-6290-40cf-bb21-6a774fb8675e', '添加', '【liang】添加会员【user】', '2014-12-21 16:07:17', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('4532eec3-845c-444b-b5e6-ee738eb258ec', '添加', '【huang】添加角色【普通注册用户】', '2014-07-12 00:04:32', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('454ee608-6b86-4bd1-89fc-4294d6fe33ab', '修改', '【huang】修改菜单【系统管理】', '2014-06-22 17:18:04', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('45b52cea-01e8-49e3-a7a0-daae1d98a483', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:03:05', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('45c62ea9-ab57-41ec-ba96-8dd2fc5dc884', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('46dd1c27-4658-4227-afff-96697fb77d20', '添加', '【liang】添加团购商品【O型丝扣锁】', '2014-09-17 10:10:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('47efe072-6973-4013-9aca-df88cd69daec', '删除', '【huang】删除资源【null】', '2014-06-29 11:47:09', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('48300d05-06f7-4005-8035-d5ea47edf6c5', '删除', '【huang】删除角色【商户】', '2014-09-12 16:04:58', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('495397cd-04d0-48fc-a6a5-2d8902d571ef', '添加', '【huang】添加菜单【基本锁】', '2014-08-05 15:59:09', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4a15300a-bcdc-4a25-83d6-4b7cc471a42d', '添加', '【huang】添加车类【null】', '2014-08-03 09:31:24', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4b9c66ed-3bdf-4df9-b6ea-c570a86ea9c2', '删除', '【shuilong】删除会员【】', '2015-01-11 22:26:11', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('4c13e91f-717c-461e-a3ca-f5cb08322df0', '删除', '【huang】删除团购商品信息【null】', '2014-07-28 17:07:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4cb0c0dc-69b7-45ee-bd8c-8cc257683c10', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:08:23', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('4cd0352d-6563-40d4-a94b-071c1d10cd72', '添加', '【liang】添加滚动图片【null】', '2015-01-01 20:02:17', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('4db51114-985b-4e70-be36-af79f253a88c', '审核', '【huang】审核商户【huang】', '2014-07-28 11:15:48', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4de16abb-9fd5-474f-bd46-26e07f5a5122', '添加', '【huang】添加车类【null】', '2014-08-05 13:33:29', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4df61dcc-9f06-4648-9f40-4980c237229d', '添加', '【liang】添加滚动图片【null】', '2014-12-19 15:50:39', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('4e54e756-0176-4f18-ab07-42032752f090', '删除', '【huang】删除菜单【车类管理】', '2014-06-17 15:50:13', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4e9f0cf1-ca20-4655-8eb2-6c56cdb0bd12', '删除', '【huang】删除操作员【huang】', '2014-07-28 11:57:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4f014fa1-6b3a-445b-91cf-136023ae44e4', '删除', '【liang】删除会员【null】', '2015-01-04 11:21:49', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('4f48f5bd-23bb-4352-9a0e-71b5b9556b08', '删除', '【liang】删除滚动图片【null】', '2015-01-01 20:01:43', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('4f50028f-c00c-4805-9347-025146878c3a', '删除', '【huang】删除操作员【huang】', '2014-07-28 15:29:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('4f8a50f3-c2ca-4b5a-852d-f542d9dfc256', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('5193af1b-9e4c-4384-b2d2-03436922a7f1', '修改', '【liang】修改商户信息【null】', '2014-12-21 17:50:16', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('5289db39-1eef-4d57-b2b6-f21f81ce8d09', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('52faadba-9cbc-403b-acc6-74957616ada3', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:08:51', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('53a94b9d-5abe-4ce4-b2e5-c872581126a4', '删除', '【huang】删除资源【null】', '2014-06-29 11:48:14', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('565b594d-f591-473a-822b-2529ef5b821e', '修改', '【shuilong】修改滚动图片【null】', '2015-01-10 23:23:14', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('568a4624-6ff6-444c-af1e-82c56062a22c', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('57511475-3988-4616-9179-b15824caef31', '删除', '【liang】删除操作员【liang】', '2015-01-23 18:03:27', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('576a6e70-723c-47b9-8621-53221dd0b385', '删除', '【huang】删除回帖【null】', '2014-08-28 09:45:33', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('58304d61-f043-4f96-94bc-1ee83248d092', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-05 17:11:45', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('586d71e3-f7d3-45d4-99cf-b2be9037781b', '添加', '【shuilong】添加滚动图片【null】', '2015-01-19 22:06:25', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('58edc34e-980c-4390-96bb-2e01b2e0b8df', '修改', '【huang】修改车类信息【null】', '2014-07-02 16:20:36', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('58f32dc2-9195-4fb7-933b-d5af85a5c521', '添加', '【huang】添加角色【测试】', '2014-09-12 16:04:50', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('59278829-c72f-4b9f-afc6-5e8ae2552973', '添加', '【liang】添加会员【123】', '2014-10-15 11:20:31', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('5a086703-0d99-44ca-b28f-0139aab3c729', '审核', '【huang】审核商户【user1】', '2014-07-17 09:24:24', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('5a45be6a-7b66-4a37-8cb7-da957612c4ba', '删除', '【huang】删除资源【null】', '2014-06-29 16:55:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('5c1fa3ac-ac72-40f7-9dfc-b1c4264b15d7', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('5c34a215-4a97-4938-b76f-e93e4353431b', '删除', '【liang】删除滚动图片【null】', '2014-11-03 16:49:54', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('5c70570f-86b1-4471-bb89-b7cf6b89bc2b', '删除', '【huang】删除资源【null】', '2014-06-15 14:58:16', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('5c70d08c-21cf-4a40-a937-0b6de5c48752', '修改', '【huang】修改论坛版块类型【草】', '2014-07-05 16:21:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('5ed0a4c5-983b-4005-b87f-96546099316a', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:07:13', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('5fa77020-de82-42b1-a888-e7f7084049c9', '修改', '【shuilong】修改商户信息【null】', '2015-01-21 00:51:18', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('60743359-b815-470d-a03b-6d8e47db07d7', '添加', '【huang】添加商品【t】', '2014-07-28 12:27:06', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('61507ea9-d418-4f9e-9264-638a05b038b1', '添加', '【liang】添加资源【null】', '2014-12-22 10:43:42', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('61cf772b-6822-49cf-af7b-58ae5cd79de5', '修改', '【liang】修改角色【测试123】', '2014-09-16 15:08:49', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('620a10fc-e49b-4ee0-aeda-b139527f8adf', '修改', '【huang】修改操作员信息【test】', '2014-07-12 16:25:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('63efd901-69ce-495a-b7db-aa5ab05c4140', '添加', '【liang】添加滚动图片【null】', '2014-12-06 13:52:13', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('63f38efb-f94c-419f-99a6-b654f6610c81', '修改', '【huang】修改操作权限1', '2014-07-23 16:36:22', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('64400da3-e949-46bc-8353-e84ce2379892', '删除', '【huang】删除角色【测试】', '2014-09-12 16:22:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('655ab67c-d232-4543-b3a5-38f90084b43e', '删除', '【shuilong】删除会员【null】', '2015-01-11 22:10:52', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('664bdae4-455f-4268-b8b4-f6384c20b320', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:03:51', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('6680d78e-9bfe-4659-9d57-e815d8b82de5', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('66d41b2d-fbb6-442e-80fb-7f0c304fa917', '删除', '【huang】删除菜单【前台系统管理】', '2014-06-22 17:18:47', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('67374177-0bc1-4213-bc43-13e3dbe9c650', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-05 16:59:08', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('67673982-70b5-4a0e-8fe1-a9c67932f929', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:33:34', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('679fa3ef-556b-4d85-9377-1d691d3a0bd6', '添加', '【huang】添加团购商品【杂牌锁】', '2014-08-12 17:04:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('6857aafe-53a5-4367-8164-d43f1ddb92a5', '添加', '【liang】添加滚动图片【null】', '2014-12-08 17:46:59', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('68f23b7c-b5fb-4296-9625-42c6f0113c6b', '添加', '【huang】添加菜单【车类管理】', '2014-06-17 15:29:27', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('69342d00-3aa0-403d-8a7a-48760d5d4ee9', '删除', '【liang】删除帖子【null】', '2014-12-21 15:17:52', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('6c81bb3e-4030-4ebe-b13e-bafa2910f34f', '修改', '【liang】修改菜单【广告专区】', '2014-12-01 16:51:30', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('6cb25680-7795-4128-8976-5b99f2eda3d7', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-05 17:11:09', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('6d0493c1-cf84-4902-a57a-033be09d43ba', '修改', '【huang】修改操作权限cae61c58-113c-42cb-88d0-2e0cbc22ed63', '2014-08-05 16:00:25', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('6e3751a3-8882-4eb9-902a-43ac4f96d451', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:10:30', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('6ef7e59e-f9d9-49c8-a155-ea889f1d7764', '添加', '【liang】添加资源【null】', '2015-01-21 00:27:33', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('6f1a0061-512c-4030-a1f5-bf2a9fb62c36', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('6f5c29e5-3560-4740-8f4c-c2fcf5183dce', '修改', '【huang】修改操作权限a6ec52b8-4e56-4856-aa25-547348e66ebc', '2014-07-12 00:09:15', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('6f72d1d0-45ce-4fee-9d1f-207d27bcfc3f', '删除', '【huang】删除团购商品信息【null】', '2014-08-01 11:40:51', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('708ca4bf-7816-4aec-8ca4-1012987b51bc', '添加', '【huang】添加论坛版块类型【lkj】', '2014-07-18 10:30:34', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('70f9ec93-6a38-4069-963c-6d68f57cd14b', '添加', '【liang】添加滚动图片【null】', '2014-12-08 19:04:01', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('7108c3d9-3d4f-43f1-9a32-03798e2415a8', '修改', '【huang】修改商品信息【金牌锁】', '2014-07-10 10:07:04', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('712d5a3a-684b-4958-8bad-a2b51aff16a6', '添加', '【huang】添加车类【null】', '2014-07-01 11:31:45', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('739edc80-46fd-4dc9-9f15-541d1b4db16b', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('73e79d44-80e2-4737-a243-95e474f62ed5', '添加', '【huang】添加操作员【user】', '2014-07-16 12:39:30', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('73f93748-6932-46bb-9249-b66326a62d3b', '添加', '【user1】添加商品【零售】', '2014-12-26 20:56:28', '4a3b0049-2c3b-43d7-94c6-102dc779fa16');
INSERT INTO `syslog` VALUES ('7439b9e9-820b-42d0-a647-fc8671ffc09a', '审核', '【shuilong】审核商户【null】', '2015-01-11 23:30:54', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('744cea7c-d8db-4f8e-81a1-fc56fe64a7da', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:32:39', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('757e8d5c-22e6-4af9-952c-2aa19f60fec0', '修改', '【huang】修改论坛版块类型【哈哈哈tr】', '2014-07-05 16:35:50', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('757ee887-2aef-48be-897c-7913210269d7', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:09:51', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('75cbdee4-ee59-432b-9c25-f955dc0373b7', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:17:16', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7754fad6-1f7b-4f76-ba3d-9482e6a8e38d', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('77710413-16b7-49b3-b3b7-eca8c246e98e', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:10:39', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('77968c3a-7cb5-4a42-8dab-d0a593baf936', '修改', '【huang】修改车类信息【null】', '2014-07-02 16:20:20', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7895b45d-0825-403f-8366-6d9de7b724b5', '修改', '【shuilong】修改滚动图片【null】', '2015-01-11 00:04:22', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('78c21076-a40c-4420-91a8-fafdad8a2856', '修改', '【huang】修改操作权限cae61c58-113c-42cb-88d0-2e0cbc22ed63', '2014-09-03 09:53:17', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('793a3d20-4aac-4c15-bbc9-26d5899899d7', '修改', '【huang】修改商品信息【t】', '2014-07-28 13:12:39', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('79dcfad4-d105-473f-b17d-0c1a565a0eab', '添加', '【liang】添加滚动图片【null】', '2015-01-01 20:02:50', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('79f11be6-4425-4e71-9f3c-8d0965e6808f', '修改', '【liang】修改操作权限1', '2014-12-01 17:12:02', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('7a4ca8e3-6176-47e2-8d8c-9950d5a1ee77', '添加', '【liang】添加滚动图片【null】', '2014-12-01 16:36:33', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('7a548813-1b6c-4165-8cd6-11cebe6d1c29', '修改', '【huang】修改论坛版块类型【dsa】', '2014-07-05 16:51:45', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7b05b394-9d74-44ba-9a8f-e1f6fc9f1e66', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:02:47', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('7baf880a-6688-45e2-9acb-9bf3d4c4b48b', '删除', '【huang】删除资源【null】', '2014-06-15 14:57:34', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7cbc6f12-175e-4a4d-98b0-9956aa4404bc', '添加', '【huang】添加资源【null】', '2014-06-22 11:36:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7cc01c05-1024-462a-a69f-b8b5830b5ca0', '修改', '【huang】修改操作权限1', '2014-07-12 16:24:09', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7d2bff23-6914-44e7-b29a-bb3bcda056eb', '添加', '【liang】添加资源【null】', '2015-01-21 00:23:36', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('7e7b382c-a36a-4c32-911a-a05d22e1d0bc', '删除', '【huang】删除团购商品信息【null】', '2014-08-01 11:40:51', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('7ed1d06e-e75b-456d-8aee-629976472451', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('7fa624b4-8ed7-441f-9e78-5a80b477412c', '添加', '【huang】添加团购商品【null】', '2014-07-29 09:27:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('802027b5-e106-40ba-b80b-93d458cf39c0', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:03:13', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('805f5362-d530-4a61-aef3-311f213cd4fd', '审核', '【huang】审核商户【test】', '2014-07-12 16:30:37', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('80a910b4-72e4-4f9e-a329-07f927ae23b9', '添加', '【liang】添加菜单【申请提现】', '2014-10-17 15:44:21', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('8135772b-3cf6-4015-94f1-17f9a473d22c', '修改', '【huang】修改商品信息【t】', '2014-07-28 13:22:08', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8158383f-7c87-4cae-829e-2d1a83909152', '添加', '【liang】添加车类【null】', '2014-10-15 16:00:15', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('81e1c183-7e69-4928-90af-1fdec0ec0514', '添加', '【liang】添加会员【123】', '2014-10-15 11:35:17', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('8209e05b-9e96-44b0-8746-1ae030f46643', '审核', '【huang】审核商户【huang】', '2014-08-31 13:21:44', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('83c398ef-e30d-468e-b47b-412024bb58f9', '添加', '【liang】添加滚动图片【null】', '2015-01-01 20:02:22', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('8408b136-ad80-4f2b-87d7-48db2cfda224', '删除', '【huang】删除资源【null】', '2014-06-29 16:54:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('84ec30b3-b088-4975-b2ff-8fb970caf813', '删除', '【huang】删除资源【null】', '2014-06-29 16:54:42', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8679b174-bf9c-48ba-b689-568f2586eb1f', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('86a218c7-e47e-4c3e-8779-8e0ad038f86f', '添加', '【liang】添加团购商品【银牌锁】', '2014-12-21 17:30:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('86f13c9d-eec7-4260-b768-bb4cc73e91da', '添加', '【huang】添加会员【测试】', '2014-09-12 15:58:53', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('88cd9446-3dff-452e-8afb-896c75b7d4c1', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8a48a099-09f2-4b60-b232-93660872c768', '修改', '【huang】修改操作权限1', '2014-07-12 00:10:49', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8a89f738-f224-4a7f-b841-c9803ac8b11c', '添加', '【huang】添加资源【null】', '2014-08-27 16:51:51', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8af45f81-535c-4904-8184-d72d3d35a6d8', '修改', '【huang】修改菜单【车类管理】', '2014-06-17 17:37:14', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8bc380c7-695d-4183-9bd2-11afce08785f', '添加', '【huang】添加资源【null】', '2014-06-29 10:56:07', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8c93ee6d-c9bc-4881-b20f-dd31b609e9a1', '删除', '【huang】删除角色【测试】', '2014-09-12 15:51:14', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8d0673b1-e0be-4366-bd10-a5aa13477c92', '添加', '【huang】添加角色【测试】', '2014-09-12 16:09:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8d148699-f926-4413-868f-c33695e817bb', '添加', '【huang】添加论坛版块类型【dsa】', '2014-07-05 15:24:25', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8d4421d8-417d-4f65-9ea4-56c08126881e', '添加', '【huang】添加论坛版块类型【wwwwww】', '2014-07-05 15:32:16', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8e15a0af-fac4-4492-8c9b-3de344843945', '添加', '【huang】添加团购商品【杂牌锁】', '2014-08-04 17:29:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8e48418d-551f-4227-9dd1-412a7544ccab', '删除', '【liang】删除帖子【null】', '2014-12-21 15:21:22', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('8e7050ba-aceb-49bd-a5c3-56aa7247ca2c', '删除', '【huang】删除角色【测试】', '2014-09-12 16:22:10', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('8eb8708d-fa63-409c-b311-60e5ef092b7f', '添加', '【shuilong】添加滚动图片【null】', '2015-01-19 22:17:03', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('8ee458a1-dfb4-45fc-b394-c49638fc4baf', '删除', '【liang】删除滚动图片【null】', '2014-12-01 16:37:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('8eed5016-55a4-45be-92c6-6c3652453ca2', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('90451cfa-f61e-448c-bbf8-7ebc420a4898', '添加', '【huang】添加菜单【同行管理】', '2014-08-31 14:16:50', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('90860737-fb40-472c-a4fc-57ab8b06e009', '添加', '【liang】添加滚动图片【null】', '2015-01-01 20:02:09', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('908947d4-33a2-458c-884e-c60d9e657641', '添加', '【liang】添加菜单【广告管理】', '2014-11-29 11:45:33', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('91f6d174-49bc-4368-82a9-eecb9bb3aa88', '修改', '【shuilong】修改滚动图片【null】', '2015-01-11 00:04:36', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('92488615-b02a-4e07-8228-65a81ce3be61', '审核', '【huang】审核商户【huang】', '2014-09-03 17:04:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('926eec09-63b5-46ef-a263-02da776638ea', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('93d3c239-78a5-48d2-9fd0-068d0ff731e4', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('942f0f0b-306c-45a1-a9e0-e393cc1d5521', '添加', '【huang】添加角色【测试】', '2014-09-12 15:50:03', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('95528a67-484b-463b-81c7-afdc79bcd1ec', '修改', '【huanm】修改角色【商户】', '2014-06-04 10:23:44', '320a65db-d36a-4a61-8dfb-a391c8e2b3d5');
INSERT INTO `syslog` VALUES ('95cf3cab-bbbc-4ac8-b8c8-8da7f5e48e5b', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9604b873-8709-4409-8b7d-52523c83c746', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:08:18', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('96cd82e4-9249-4a4e-8890-c09bcca4b1b8', '修改', '【shuilong】修改滚动图片【null】', '2014-12-20 22:01:53', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('981eacf1-921f-479f-8e84-93d549caecd9', '删除', '【liang】删除滚动图片【null】', '2015-01-01 20:01:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('985ae69a-09b3-4e32-a195-74f3004d5869', '添加', '【shuilong】添加滚动图片【null】', '2015-01-19 22:27:41', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('99073576-6bbe-45c0-8e41-681d38a50fb8', '审核', '【huang】审核商户【huang】', '2014-09-15 09:52:43', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('994d0b4e-c746-46b7-9260-cf43a5448ebc', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:07:36', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('995d0aad-ee2f-46d2-ad5b-a51f75f61e75', '删除', '【huang】删除菜单【会员信息管理】', '2014-06-22 17:18:47', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9a593303-ba7d-4dea-b90e-cd055e51421e', '添加', '【huang】添加资源【null】', '2014-08-23 16:40:33', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9a821e22-4f10-4f28-8c58-a56e447b64d2', '修改', '【liang】修改商户信息【null】', '2014-09-22 00:59:37', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('9b07a746-d2de-4c22-979b-53c5c37c7ff7', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('9b812d5c-c346-4d67-9aac-0d4728fe36c8', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:00:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('9bb55ce7-49d5-4563-8a14-39eb929da31e', '修改', '【liang】修改菜单【指纹锁专区】', '2014-12-01 16:47:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('9c6dde8f-7d80-469d-85de-4c070faf5e97', '修改', '【huang】修改菜单【测试菜单】', '2014-09-12 15:52:25', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9c76e386-cfcb-49e2-90dc-c4ed1b1b6417', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9c86d2ae-c87f-42ba-acf9-a7a2a5d50385', '添加', '【user1】添加商品【arafr】', '2014-07-21 10:17:58', 'ca2a697e-b868-4d9f-aff1-66b03a0ed785');
INSERT INTO `syslog` VALUES ('9ccc7586-3ab0-489d-9d74-6edfaca97192', '添加', '【liang】添加滚动图片【null】', '2014-12-06 09:40:21', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('9cd2dafd-5fee-466c-9f5e-045d71fc997e', '添加', '【liang】添加滚动图片【null】', '2014-12-06 13:50:29', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('9d2271c0-b1bc-4d6a-b2df-eb43f55bbb39', '添加', '【huang】添加车类【null】', '2014-07-22 15:37:37', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9e37e733-68e7-4254-8045-99df20f7b9b3', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('9eaa8279-3254-44d7-9a9b-e58948b9fca0', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-05 17:16:05', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('9f55b6a1-5c52-4f01-a4c4-e3095ad5a796', '删除', '【liang】删除滚动图片【null】', '2014-12-26 21:08:57', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a00cb1ef-970a-420e-81cb-e2150c6dd848', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a0260417-5208-459f-8980-fe969ceae5bc', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:04:20', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a06ab566-7bbb-48c4-88d2-08670e1ec9e8', '修改', '【huang】修改车类信息【null】', '2014-07-01 15:59:33', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a070d9a6-adb7-4f2f-bcb4-68d3315be0c0', '修改', '【huang】修改商品信息【金牌锁】', '2014-07-01 17:06:20', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a0c7b6f8-6cbd-4353-b7f2-a057043cc954', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a0e08b3e-e6d2-4af2-8760-d28be4020d29', '添加', '【huang】添加操作员【钟宏强】', '2014-09-12 15:57:42', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a14b3ccf-7d74-4556-9934-8c10d7bb9d46', '修改', '【huang】修改操作权限1', '2014-06-19 16:02:37', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a218dd96-6e4f-4eff-8ede-6594256d8ec0', '审核', '【liang】审核商户【aaa】', '2015-01-23 18:40:02', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a26289fd-332d-49ba-a7e9-6c97af1b8610', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:04:42', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a28658d2-a8a6-49b8-a1e0-10d5b5d86604', '添加', '【shuilong】添加会员【】', '2015-01-11 22:25:42', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('a2a81c2b-6d52-4f4a-8711-2f530ed96d1d', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a2adee1b-5ace-4c85-8c95-0ef1e4f6b22b', '添加', '【huang】添加资源【null】', '2014-06-15 14:57:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a2bdd66d-a7d0-4f3b-85d1-be2e7a729742', '添加', '【liang】添加滚动图片【null】', '2015-01-01 20:02:39', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a2da7373-b974-4cb7-b6bd-d35d2cbe6610', '添加', '【liang】添加会员【123】', '2014-10-15 11:27:28', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a31c533b-b692-4633-8d39-0a97a8b95c04', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a348fe08-424f-48f6-9da9-fcd467edc848', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a4e624c4-3cb6-46ca-8c2e-3e8502a56650', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a56df655-37e4-4804-9f7d-467e001018e3', '删除', '【liang】删除帖子【null】', '2014-12-21 15:21:22', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a5b4de49-b1f8-4884-96c8-083ccc08b2e2', '添加', '【liang】添加滚动图片【null】', '2014-12-20 13:34:59', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a5fafb80-25e7-49c2-8381-102ce4e30da8', '删除', '【shuilong】删除操作员【null】', '2015-01-11 23:31:01', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('a722a8ac-9cbe-4bff-9e07-39370f1605e6', '审核', '【liang】审核商户【liang】', '2015-01-14 16:24:43', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a7259806-8223-4790-aafb-fa549a371600', '修改', '【liang】修改菜单【康耐尔】', '2014-12-01 11:34:06', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a958bc2d-e8fe-4150-9c74-d302ba14e621', '修改', '【huang】修改车类信息【null】', '2014-07-02 15:21:49', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a9a0e6e7-0f41-4695-8d5d-c3448659c493', '添加', '【liang】添加会员【】', '2014-10-15 10:02:26', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('a9bc0d97-4e15-4ac8-a9fd-7b5038e01f4f', '添加', '【huang】添加菜单【团购锁】', '2014-08-05 15:59:45', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('a9c9296e-c195-40b8-83ad-d0903ec818c1', '添加', '【liang】添加车类【null】', '2015-01-21 01:06:14', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('aa1491d6-9551-439e-a8f0-678e38e5962c', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('aa9226eb-85ee-4645-bc65-2e1897dc221f', '修改', '【huang】修改论坛版块类型【草】', '2014-07-05 16:21:38', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ab66b7b6-7be5-47e0-bd0d-9232c5e1e946', '添加', '【liang】添加会员【123】', '2014-10-15 11:52:23', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('ac15634a-c843-4e4a-9862-dea017d32795', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:08:56', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('acec5df9-078b-4a8a-8ae9-c6ad80476236', '添加', '【huang】添加资源【null】', '2014-08-03 09:25:57', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ad490207-fab1-4357-bce7-9971a6897270', '修改', '【liang】修改滚动图片【null】', '2014-11-03 16:49:44', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('ad8318a9-1897-4796-a831-4324c2f3cdbd', '删除', '【huang】删除团购商品信息【null】', '2014-07-28 17:07:40', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('af195445-b5a9-4f75-851f-78d52185d0ab', '添加', '【liang】添加滚动图片【null】', '2014-12-20 13:34:00', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('afa54ec8-e981-451e-8286-e09196e14d7a', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('afa8dc60-2cd8-48ca-9f06-2dc47cbaf2f6', '删除', '【liang】删除回帖【null】', '2014-10-15 15:48:39', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('afb59778-2bb9-48d2-9caf-ac3ccb6b8bb7', '删除', '【huang】删除菜单【测试菜单】', '2014-09-12 15:52:46', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('afb9e240-25d9-4ff6-a6e3-41f67928f6f6', '添加', '【huang】添加角色【测试】', '2014-09-12 15:50:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b04d132f-2e5a-4608-b91f-f486be6023a7', '添加', '【huang】添加资源【null】', '2014-06-29 11:50:05', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b04de1d5-9a42-41ca-b870-9c8311a75f45', '删除', '【huang】删除操作员【钟宏强】', '2014-09-12 15:58:17', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b0969838-ad3b-4fff-ba5e-f2cd922ba2a3', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-07 10:43:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b0a9a1d4-847b-405a-bb2e-d5a110c5842f', '添加', '【liang】添加会员【nina】', '2015-01-04 10:27:47', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('b16f0d51-5da8-48b4-a5fb-41d5bf32b39d', '添加', '【liang】添加滚动图片【null】', '2014-12-01 15:30:35', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('b2886921-cbf4-4735-ae35-9e8c6e6591ba', '删除', '【liang】删除帖子【null】', '2014-12-21 15:18:58', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('b43dba39-a7e1-4419-8553-f412d8e3c14c', '修改', '【huang】修改操作权限1', '2014-07-23 10:35:28', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b49a6313-5dc5-4e68-bc30-2b581b27d025', '添加', '【liang】添加资源【null】', '2015-01-20 23:40:46', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('b4c14d6d-d059-4076-9f8e-6fa318dd9a00', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('b4fa4305-c352-4998-9b2c-3cb1c019c512', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b6cf6be7-07b1-412c-81c0-51e7468c1d1f', '添加', '【liang】添加角色【测试】', '2014-09-16 15:08:55', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('b6ed5836-dd8e-4b26-8011-ec85b3142cc6', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-07 11:02:29', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b7bee087-312b-403c-af8a-922e0a80f695', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('b81ffac5-2ce2-4bc6-b01f-ccb90329c8c5', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('b852b3fb-7cf8-4f6d-87b8-3cf561329ebe', '修改', '【huang】修改角色【商户】', '2014-09-12 16:23:18', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('b914ad08-a8a1-4ef5-9a9f-28545ded4362', '审核', '【huang】审核商户【common】', '2014-06-19 16:52:43', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ba78d3e0-bd30-44b0-9c21-cde4d2debfad', '删除', '【liang】删除角色【测试】', '2014-09-16 15:15:04', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('ba7b7797-2752-4a0b-ac7f-bba13127b630', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('ba8a92e8-41c3-4803-a673-6b123b90729f', '修改', '【shuilong】修改滚动图片【null】', '2014-12-20 22:06:02', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('ba925eb3-e180-4d17-8ccf-3140e30c976e', '修改', '【huang】修改操作权限1', '2014-08-31 14:17:12', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('bad34d9f-102e-4b30-92fa-a510fd6cc08c', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('bba5b85f-f917-4f96-8a19-618040674f16', '删除', '【huang】删除菜单【商品管理】', '2014-06-22 17:18:47', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('bc065abc-035b-4d59-acea-5495b0f9c1c7', '添加', '【huang】添加资源【null】', '2014-06-17 15:02:33', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('bc9fd955-a17a-4a81-a305-88eecd5c518d', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:11:16', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('bca060e9-7973-43c7-9692-eb37ac64b402', '添加', '【huang】添加论坛版块类型【草】', '2014-07-05 15:33:51', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('bd9c9f75-26c9-43be-b75b-e1a1c6fdf558', '添加', '【liang】添加滚动图片【null】', '2014-12-08 17:48:12', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('bdb4dc4d-1fd2-483d-bca1-9b5ef05f1628', '添加', '【huang】添加角色【测试】', '2014-09-12 16:05:03', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('be2e7acd-c217-4a05-9947-98a23a0b09a9', '添加', '【huang】添加资源【null】', '2014-06-29 10:52:53', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('be47cf9d-b2f5-4b25-966e-438bbd0ae470', '删除', '【huang】删除操作员【null】', '2014-07-16 12:39:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('bec37984-e78f-4ab0-a3b7-11300515ffa0', '添加', '【liang】添加滚动图片【null】', '2014-12-08 18:55:32', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('bffaa04b-34ef-4bea-a679-085b5a087766', '审核', '【huang】审核商户【huang】', '2014-09-15 09:48:51', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c041a160-e06e-447c-b140-f16d7679e393', '审核', '【huang】审核商户【huang】', '2014-07-28 10:20:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c17429f7-ea1e-495d-8d12-8ff62aa46912', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:10:00', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c21cbf1f-9012-49b6-9472-7e4fef58b0bc', '修改', '【liang】修改商户信息【null】', '2014-09-15 15:47:53', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c23b5c6f-cafc-48c7-866d-86e68e9e6b8f', '审核', '【huang】审核商户【huang】', '2014-09-03 14:52:18', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c25daf13-76d3-4565-882e-1c8d6e7fd718', '修改', '【huang】修改论坛版块类型【哈哈哈】', '2014-07-05 16:50:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c298e2e8-e58a-4395-bf5a-c3216f51113c', '修改', '【shuilong】修改滚动图片【null】', '2015-01-10 23:58:37', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('c3369a26-246c-4e6d-9a0e-ab3b21aad396', '添加', '【liang】添加会员【123】', '2014-10-15 11:42:20', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c36a52d6-fd66-4050-8434-bb77a930bcbf', '审核', '【huang】审核商户【huang】', '2014-06-19 16:52:50', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c3cf0e9b-f458-4ff7-a786-1d30fe1709ea', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:00:26', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c4ff9340-d9ae-4d6f-b286-2532687c20c9', '修改', '【huang】修改商品信息【金牌锁】', '2014-06-22 15:14:32', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c50a2adc-575d-4901-9692-77e57982333d', '删除', '【liang】删除滚动图片【null】', '2015-01-01 20:01:32', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c5bd6379-69a7-4db3-8f98-ef18a4740bc7', '删除', '【liang】删除会员【null】', '2015-01-04 11:21:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c709189f-46e8-40c0-bad4-4278a39074ec', '审核', '【huang】审核商户【huang】', '2014-07-28 15:27:59', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c70ac253-e861-4b04-ad27-006da9773dd3', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:02:54', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('c8cfd3db-4c6b-4d76-9217-3246f53abc35', '删除', '【huang】删除资源【null】', '2014-06-29 16:54:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c967f308-adc9-4d80-be80-7c3916fd7d9a', '添加', '【huang】添加资源【null】', '2014-06-29 10:51:56', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('c9b5f483-b29a-42bb-b6af-917c8d7b51f8', '审核', '【huang】审核商户【xiaoA】', '2014-06-15 14:56:18', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ca1a062c-059e-4e5e-8de7-1508408405bc', '添加', '【liang】添加角色【a】', '2014-09-16 14:41:23', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('cb97e71c-a52b-478c-bd58-5bee60446f9f', '添加', '【huang】添加资源【null】', '2014-06-17 15:06:21', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('cbdd0f13-15bc-437f-9f70-4d09f4d51a24', '添加', '【liang】添加菜单【康耐尔】', '2014-11-29 11:47:44', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('cc420a04-588e-44aa-a508-cceb574e8384', '修改', '【huang】修改操作权限1', '2014-07-12 00:05:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ccf6f1d5-c90f-4760-b72e-0719c90c0dd3', '添加', '【shuilong】添加会员【】', '2015-01-11 22:10:24', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('cd2405f6-8d9c-401b-811e-5f0c0ce3a78f', '删除', '【huang】删除车类【null】', '2014-07-05 16:16:40', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ce588faa-1506-4fcf-b073-181ea8575d47', '修改', '【shuilong】修改滚动图片【null】', '2014-12-20 22:04:05', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('ce79692a-4e87-4767-a69e-c12c308bb700', '修改', '【huang】修改菜单【商户申请】', '2014-07-12 16:28:18', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('cf11282c-264a-49be-8b73-43842e9b70ab', '添加', '【shuilong】添加滚动图片【null】', '2015-01-19 22:31:08', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('cf57f71e-92af-494c-892a-f517ce264690', '添加', '【liang】添加菜单【指纹锁专区】', '2014-11-29 11:47:56', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('cf84b441-737e-4ea3-b036-9e30f736a9cb', '审核', '【liang】审核商户【liang】', '2014-09-16 10:54:50', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('cf885dba-8fbe-4303-b342-3ac6db692690', '删除', '【huang】删除角色【普通注册用户】', '2014-09-12 16:09:58', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('cfb38842-ffa0-4c96-a267-fa653b4e145f', '添加', '【liang】添加滚动图片【null】', '2014-12-20 13:34:09', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('cfd5e894-a979-4542-ac3d-e73015c7b69b', '审核', '【huang】审核商户【common】', '2014-06-15 14:56:22', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d0b03437-ee19-46d5-9d6b-c82cba86058d', '修改', '【liang】修改菜单【锁芯专区】', '2014-12-01 16:50:12', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d1579bc2-e326-47af-8711-282bf5d17295', '审核', '【huang】审核商户【huang】', '2014-08-31 13:21:24', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d1eb8a0b-0bca-4136-85b7-6946f8ac7a1a', '删除', '【liang】删除滚动图片【null】', '2015-01-01 20:01:46', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d3098376-f5ff-411a-87f8-b1f2cd110e81', '审核', '【huang】审核商户【xiaoA】', '2014-06-15 14:56:14', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d435a0bb-4032-410b-a71f-44990c1584c8', '修改', '【liang】修改操作权限1', '2014-09-16 10:14:59', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d44246d7-44f6-46f3-953d-69d30cfd45f1', '添加', '【liang】添加资源【null】', '2014-10-15 16:09:31', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d4900857-b07e-4539-a251-fdbc3ab4e2f8', '添加', '【liang】添加滚动图片【null】', '2014-12-06 13:54:30', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d5c00e06-1a6d-4f10-bc8b-bcea576c16bb', '添加', '【huang】添加团购商品【null】', '2014-08-04 16:12:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d5d7a4b3-888b-478c-b80f-cbdf44d20bd5', '删除', '【liang】删除资源【null】', '2015-01-20 00:07:10', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d70bd47b-b5c7-4121-acb1-5c2685ae2708', '删除', '【huang】删除回帖【null】', '2014-08-28 09:45:26', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d71f6388-65d0-44fd-91a4-9c8989c2fb45', '修改', '【huang】修改商品信息【t】', '2014-07-28 12:47:55', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d7589b8d-1648-4bdd-97e0-2e2ecd4a53b8', '添加', '【liang】添加菜单【提现管理】', '2014-10-17 15:45:44', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d7614291-adb9-4c88-bde7-14ef50ff825b', '添加', '【liang】添加滚动图片【null】', '2014-12-20 13:34:46', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d76b95dc-2980-4396-ad08-e79fddff238b', '添加', '【huang】添加资源【null】', '2014-06-16 11:22:12', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d7763858-e285-4630-9b47-dd34e63152de', '添加', '【liang】添加滚动图片【null】', '2014-11-12 10:41:17', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d7d096eb-5e46-4d8b-86ba-c1ff0f2b9a1b', '修改', '【liang】修改商户信息【null】', '2014-09-22 00:59:50', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d80e656a-eb5d-4b39-8440-11aeae1a5392', '删除', '【huang】删除车类【null】', '2014-07-02 15:13:35', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('d8b38554-6859-4267-8e01-20552b887ddd', '添加', '【liang】添加会员【哈哈】', '2014-10-15 09:40:34', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d9c85cfb-0680-4a64-a4f9-bf62eabf7315', '添加', '【liang】添加角色【测试】', '2014-09-16 14:58:21', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('d9d0ff36-4a6c-456a-acb2-57ed0edb3c98', '删除', '【liang】删除滚动图片【null】', '2014-12-20 13:33:44', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('dba9487a-fc0b-45db-a539-bf1445df04a6', '删除', '【huang】删除操作员【common】', '2014-07-16 12:39:53', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('dc3f7e86-0bce-4f0d-9598-e6770f8205f0', '添加', '【liang】添加滚动图片【null】', '2014-11-03 16:33:06', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e02db8eb-1e4d-4ee2-b405-5fc75e7f6459', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e09587ab-4020-45df-bce7-6f441dab5527', '修改', '【shuilong】修改操作权限85431849-d438-4f20-986d-a5ffebdd11a6', '2015-01-21 00:25:36', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('e0ac4f5c-9721-4b6f-a818-ddc870116c7c', '删除', '【liang】删除资源【null】', '2015-01-21 00:23:43', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e1091977-4449-4e8a-9f40-e2b7c1ffa10c', '删除', '【huang】删除团购商品信息【null】', '2014-07-28 17:07:11', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e160ff7a-b9ca-4c18-ace6-657a774853a4', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e1a1dc98-47d8-4152-9ca9-b76c51dd292d', '添加', '【huang】添加资源【null】', '2014-07-17 15:13:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e1b4f15c-8605-40e8-9cae-1013dfec15d6', '添加', '【liang】添加滚动图片【null】', '2014-12-01 17:03:36', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e20c6915-660a-442a-95f7-13d1f1746f91', '删除', '【liang】删除角色【a】', '2014-09-16 14:41:30', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e248fd01-12a3-4509-8f24-193c28892e42', '删除', '【shuilong】删除会员【null】', '2015-01-11 22:10:47', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('e26915df-e7e3-4c28-880f-9a30f569fa6f', '修改', '【shuilong】修改滚动图片【null】', '2015-01-10 23:19:25', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('e2e203e8-feaf-4ec3-baef-c8b456a4c38d', '添加', '【huang】添加车类【null】', '2014-07-01 11:24:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e3211c4d-c862-4639-a697-d52b3d570a2c', '删除', '【liang】删除滚动图片【null】', '2015-01-01 20:01:40', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e3b93827-6c8c-494b-86d0-03f8d8b3e267', '修改', '【huang】修改团购商品信息【null】', '2014-08-01 11:18:54', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e3eeb598-54ef-4e75-9f8c-e9c5eeeeb80c', '添加', '【huang】添加资源【null】', '2014-08-09 11:58:47', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e5806cdd-e13b-48c4-be35-04ba1607077e', '修改', '【shuilong】修改操作权限85431849-d438-4f20-986d-a5ffebdd11a6', '2015-01-21 00:23:38', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('e5c2cbc9-4497-44bb-8fe8-45b85e8e3175', '添加', '【user1】添加商品【aa】', '2014-12-21 17:39:08', '4a3b0049-2c3b-43d7-94c6-102dc779fa16');
INSERT INTO `syslog` VALUES ('e61996ef-3551-4651-9b3b-33fa5636cb4f', '添加', '【liang】添加滚动图片【null】', '2014-11-03 15:43:52', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e6d7df4d-537a-4a67-8f71-4f7d872af9a8', '添加', '【liang】添加资源【null】', '2015-01-21 00:14:03', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('e781c901-e765-48e3-b041-2cf20944444f', '修改', '【huang】修改论坛版块类型【草】', '2014-07-05 16:47:35', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e8905d5a-22e0-45ec-9749-48f5a8e465b0', '修改', '【huang】修改操作权限1', '2014-07-12 00:02:47', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e8e00b24-2372-405b-a62b-c84ab022924e', '修改', '【huang】修改商品信息【t】', '2014-07-28 12:36:38', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('e9791b81-96a4-4799-97a5-a4ab1a3ca09d', '添加', '【user1】添加商品【user1锁】', '2014-07-21 11:20:51', 'ca2a697e-b868-4d9f-aff1-66b03a0ed785');
INSERT INTO `syslog` VALUES ('e97ad515-18f4-42f9-b94b-3f3de4c14f48', '添加', '【shuilong】添加会员【0791锁业】', '2015-01-11 22:24:22', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('e9900eae-d238-46cf-8b7b-1521d9f25432', '修改', '【liang】修改商户信息【null】', '2014-09-22 01:08:06', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('ea2fa0f5-dc2a-46f0-ad40-16e51e0a6a7b', '删除', '【shuilong】删除会员【null】', '2015-01-11 22:22:53', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('ecf7e982-94fd-4060-8654-8cc40e5c581b', '删除', '【huang】删除资源【null】', '2014-06-16 11:22:21', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('edd8b875-53ea-477e-996b-525153a3d4b9', '添加', '【liang】添加论坛版块类型【啊啊】', '2014-10-15 15:52:23', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('eecf72e0-36ec-463b-a04b-9c7c0acc8832', '删除', '【liang】删除资源【null】', '2015-01-21 00:31:24', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('eed8367b-e9e6-4c64-b303-24214b885390', '修改', '【huang】修改商品信息【t】', '2014-07-28 13:19:22', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('eedc0a8b-1abf-4213-bb4a-e1d15dd09784', '添加', '【huang】添加角色【商户】', '2014-09-12 16:22:26', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ef788b4b-3fde-4db9-b8ac-fdbcac7f95e6', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ef7f02df-b2d4-4fea-875c-8c579e46b1a0', '添加', '【huang】添加菜单【商户认证】', '2014-07-12 00:08:49', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('efc4d8c0-1aff-423f-9f1e-5b070b600ee7', '删除', '【liang】删除滚动图片【null】', '2014-12-19 15:50:07', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('efcb5376-5cf9-4c00-a210-85e15b71fe4f', '删除', '【huang】删除菜单【论坛管理】', '2014-06-22 17:18:46', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('efd2d677-fe2a-48d0-bfe9-1c7906e61558', '删除', '【shuilong】删除车类【null】', '2015-01-20 23:06:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105b');
INSERT INTO `syslog` VALUES ('f01c174f-4da7-409c-bd21-83154b02fd7b', '添加', '【huang】添加资源【null】', '2014-08-07 15:31:22', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f08aba84-10c4-472a-85a1-d6111b87ff14', '修改', '【liang】修改角色【测试】', '2014-09-16 15:04:40', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('f0a1d26c-f75f-4874-adc7-7877a959b1ca', '修改', '【huang】修改论坛版块类型【汽车电脑维修资料】', '2014-07-07 10:44:52', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f0abcafd-2bd6-45a5-9c69-542dc058f9ed', '添加', '【huang】添加论坛版块类型【哈哈哈】', '2014-07-05 16:01:57', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f11ad29e-320a-4856-922e-058206b6a585', '删除', '【huang】删除菜单【资源管理】', '2014-06-22 17:18:46', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f2b45c66-2c92-486b-b1fb-8d3b07c13bf0', '修改', '【huang】修改论坛版块类型【二手设备出售】', '2014-07-05 17:17:38', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f47fd259-e4d9-4157-b8f6-9870fe8ace44', '删除', '【huang】删除资源【null】', '2014-08-07 15:31:28', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f579c58a-e695-4602-a502-24f78079751d', '添加', '【liang】添加滚动图片【null】', '2014-12-26 21:10:18', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('f6221f74-1fc3-410e-a314-4f3647f031fe', '删除', '【liang】删除会员【null】', '2015-01-04 11:21:48', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('f67a009b-f5a5-48f3-95d8-da3e77b9be64', '添加', '【huang】添加菜单【订单管理】', '2014-08-05 15:56:50', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('f767e447-96e7-49be-b550-640ec33b2a28', '添加', '【liang】添加滚动图片【null】', '2015-01-21 16:38:50', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('f86912ee-4f1c-4499-92a0-520b4f4994d4', '添加', '【liang】添加菜单【锁芯专区】', '2014-11-29 11:48:07', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('fa220a79-7131-4b49-a0fd-b89166ccd6a1', '修改', '【huang】修改操作权限1', '2014-07-12 00:02:19', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('fa269205-26eb-42a0-866a-2b496564eec8', '删除', '【huang】删除车类【null】', '2014-07-02 15:13:35', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('fa5ed091-a343-4004-8b5e-e495bb9502a7', '添加', '【user1】添加商品【user1锁】', '2014-07-21 10:03:10', 'ca2a697e-b868-4d9f-aff1-66b03a0ed785');
INSERT INTO `syslog` VALUES ('fabc0357-86fc-4d06-bec1-5d5097241a73', '删除', '【huang】删除资源【null】', '2014-06-15 15:01:24', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('faef7e5c-7786-449d-86b0-e8c64d7476dd', '删除', '【huang】删除操作员【null】', '2014-07-16 12:38:41', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('fd15dc42-ef1b-4478-a84f-7de368b28478', '添加', '【liang】添加滚动图片【null】', '2014-12-20 13:33:32', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('fd5637a2-d8de-4358-8c16-76151937c359', '修改', '【liang】修改车类信息【null】', '2015-01-21 00:06:00', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('fd9215ae-56fa-44c7-9a9b-3b78394d4175', '添加', '【huang】添加菜单【团购商品管理】', '2014-07-23 10:31:10', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ff28cfc7-8ed4-4501-bc19-c01a1a101ce9', '修改', '【huang】修改团购商品信息【null】', '2014-08-01 10:47:58', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');
INSERT INTO `syslog` VALUES ('ff7e02b6-5ae3-491e-a2b1-e8b4e5c335bc', '添加', '【liang】添加滚动图片【null】', '2014-12-08 17:47:14', 'f9691425-29da-4c3d-a3a4-f9b62bc3105h');
INSERT INTO `syslog` VALUES ('ffed9256-4750-40da-9676-6837e035efd4', '修改', '【huang】修改操作权限1', '2014-08-05 16:00:01', '0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `account` varchar(30) default NULL,
  `password` varchar(300) default NULL,
  `UserRoleId` varchar(36) default NULL,
  `status` int(11) default '0',
  `image` varchar(100) default 'user.jpg',
  `gender` bit(1) default NULL,
  `birthday` date default NULL,
  `email` varchar(100) default 'xiaopohai85707@126.com',
  `phone` varchar(15) default '110',
  `coins` bigint(20) default '0',
  `coinsTime` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0a0cb097-0fa7-46e4-b77e-6fbe1f8c411a', 'huang', '1', '2014-07-14 10:03:14', 'huang', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'd8f7bba0-77ba-48c7-9870-8281cc28a3ce', '1', 'user.jpg', '', null, null, null, '0', '2014-09-09 14:33:44');
INSERT INTO `user` VALUES ('1402ff5a-028d-40db-bef5-a309eff55dec', '', '', '2015-01-11 22:25:42', '0791sy1', 'd850647350d822301ae3b3fe0d5bd57b99eb90b334b5bd98ce86477d3011f1a26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, '', '', '30', '2015-01-21 23:37:42');
INSERT INTO `user` VALUES ('1ea9b11d-f7c3-49d6-9d33-43debd98091d', '', '', '2015-01-11 22:27:34', '0791sy2', 'd850647350d822301ae3b3fe0d5bd57b99eb90b334b5bd98ce86477d3011f1a26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, '', '', '20', '2015-01-21 00:58:41');
INSERT INTO `user` VALUES ('2841c13a-3d8f-47a6-9228-ef95318d3df5', null, null, '2015-01-04 19:30:47', '人品差怎么办呢', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, '45667764346@qq.com', null, '10', '2015-01-04 19:30:47');
INSERT INTO `user` VALUES ('313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '', '', '2015-01-23 14:10:18', 'NinaXuYuan', '8cf10f6be6c6597c7d321590947a3e3e066bc4f6e6ffcde640888fecd3e3a2de6e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '0', 'default.jpg', '\0', null, '547548054@qq.com', '', '10', '2015-01-23 14:10:18');
INSERT INTO `user` VALUES ('4a3b0049-2c3b-43d7-94c6-102dc779fa16', '商铺', null, '2014-09-19 15:56:02', 'user1', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '1', '14112411581435.jpg', '\0', '2014-05-10', 'nextday123@qq.com', '18070049985', '1120', '2014-12-26 23:57:49');
INSERT INTO `user` VALUES ('55522a93-260f-41bb-8bf5-c55744b96772', null, null, '2014-12-26 17:55:16', '许园nina', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0', 'default.jpg', '', null, 'fghhjjjkk@qq.com', null, '10', '2014-12-26 17:55:16');
INSERT INTO `user` VALUES ('688bdfb1-db64-4764-bf3b-d594b43bec23', null, null, '2014-12-25 10:09:27', '梁在超123456', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '', null, 'twmjgp@163.com', null, '10', '2014-12-25 10:09:27');
INSERT INTO `user` VALUES ('7257b67c-5448-4d00-a592-334d65e2c869', null, null, '2014-12-26 17:43:24', '黄是黄学坚123', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '', null, 'sdsdsds@qq.com', null, '10', '2014-12-26 17:43:24');
INSERT INTO `user` VALUES ('7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', 'xiaoa', null, '2014-08-28 11:56:03', 'xiaoa', '4973ae9635f539e8a7686630dd0a29539c5d44d63303dc41a36fd08e052e16606e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '1', '小a.jpg', '\0', '2014-05-10', 'xiaoa@163.com', '13012341234', '0', '2014-05-23 15:43:50');
INSERT INTO `user` VALUES ('7c1dd44a-4491-46ff-82b2-ac2cf89214b4', null, null, '2015-01-04 14:09:30', '人品差怎么办', 'b5b8f349e9ff919ffea0a4b22ad39053dd22c5ba4c1b9094c88bf2e3be8e96e26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0', 'default.jpg', '\0', null, '1334566788@qq.com', null, '10', '2015-01-04 14:09:30');
INSERT INTO `user` VALUES ('858690c7-9792-4b56-bccf-cd86f0b137d1', null, null, '2014-09-11 10:30:06', 'user3', '1548e5b5c7c8c2ef28c6ceff16f5231da70d8377e2c09181', '2daae34e-274d-4661-b8da-e4891c83948e', '0', 'default.jpg', '', null, 'user3@163.com', null, '10', '2014-09-11 10:30:06');
INSERT INTO `user` VALUES ('89c66323-1ee7-43c2-90b4-bfcd25fce4a5', null, null, '2015-01-21 16:37:18', 'cjm1234', 'f187c629ee9df29b5243d758166ee6b9d3c372a794ebb3ea38b01b2d3193f5db6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, '1678841720@qq.com', null, '10', '2015-01-21 16:37:18');
INSERT INTO `user` VALUES ('abc', null, null, '2015-01-15 10:05:22', 'abc', 'd9eac52e85c89745df430ebbcdbf51c25f340400c378ed0984f9a9d0d31933a26e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0', 'user.jpg', '\0', null, '123456@789.com', null, '0', null);
INSERT INTO `user` VALUES ('b78e8b2e-420a-4b98-92c6-17a927dfd120', 'user', '', '2014-12-21 16:07:17', 'user', 'd9eac52e85c89745df430ebbcdbf51c25f340400c378ed0984f9a9d0d31933a26e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, null, null, '0', '2014-12-21 16:07:17');
INSERT INTO `user` VALUES ('c204ceac-c2ef-4d15-af6e-4348695bcbc5', null, null, '2015-01-03 14:22:08', 'hxj123', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '', null, '123@QQ.123', null, '10', '2015-01-03 14:22:08');
INSERT INTO `user` VALUES ('c28212ed-9a7e-4bd5-909f-988b5089ed08', 'nina', '', '2015-01-04 10:27:47', 'nina', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '4195f48e-6aba-466f-bdda-8152fb10074d', '0', 'default.jpg', '\0', null, null, null, '0', '2015-01-04 10:27:47');
INSERT INTO `user` VALUES ('dea2fc81-a0da-4a13-a8e8-7a9c05a18b57', null, null, '2015-01-13 12:24:50', '547548789', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '', null, '547548789@qq.com', null, '10', '2015-01-13 12:24:50');
INSERT INTO `user` VALUES ('e0e0643a-93a8-4a1c-a41d-43f4a6f01a3e', '0791锁业', '', '2015-01-11 22:24:22', '0791sy', 'd850647350d822301ae3b3fe0d5bd57b99eb90b334b5bd98ce86477d3011f1a26e8662b6d7f37c27', '91b61db6-397f-4c64-b7b5-a575c3c70281', '0', 'default.jpg', '\0', null, null, null, '20', '2015-01-21 00:21:14');
INSERT INTO `user` VALUES ('e2832b54-17e7-4406-ba2a-62af7a7b3385', 'xiaoming', null, '2014-06-05 16:36:56', '小明', '49449660afe4e5539fbf9a2ffb721b71', 'd8f7bba0-77ba-48c7-9870-8281cc28a3ce', '1', 'xiaoming.jpg', '\0', null, 'dd1@qq.com', null, '46', '2014-10-16 01:25:01');
INSERT INTO `user` VALUES ('ea894836-dcad-4206-80a9-c9d90784160e', null, null, '2015-01-03 14:12:41', 'huanghuang', '157d5d6781e6d97da4b1bed183a17963be3215ab13c5b75e58634c61de2ffcde6e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, '761780598@qq.com', null, '10', '2015-01-03 14:12:41');
INSERT INTO `user` VALUES ('f292f8ac-4b1e-4b62-bca8-0cf752dcc9c6', 'test7', '', '2015-01-04 11:22:05', 'test7', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'a6ec52b8-4e56-4856-aa25-547348e66ebc', '0', 'default.jpg', '\0', null, null, null, '0', '2015-01-04 11:22:05');
INSERT INTO `user` VALUES ('f61f4360-4092-48e5-9066-9684934c65b2', '普通注册会员', null, '2014-06-04 14:50:02', 'user2', '49449660afe4e5539fbf9a2ffb721b71', '2daae34e-274d-4661-b8da-e4891c83948e', '1', '小明.jpg', '\0', '2014-07-02', 'dd@qq.com', '13056785678', '20', '2014-09-09 14:33:36');
INSERT INTO `user` VALUES ('f9691425-29da-4c3d-a3a4-f9b62bc3105b', '谭水龙', '', '2014-08-03 10:03:18', 'shuilong', '33f832a077d10f48de98a5b0f9bd7c03c8b4bb3cce9d6223a6c93bb9ab1a69cb6e8662b6d7f37c27', '1', '0', 'user.jpg', '', null, null, null, '0', '2014-09-09 14:33:39');
INSERT INTO `user` VALUES ('f9691425-29da-4c3d-a3a4-f9b62bc3105h', null, null, '2015-01-13 16:29:56', 'liang', 'd9eac52e85c89745df430ebbcdbf51c25f340400c378ed0984f9a9d0d31933a26e8662b6d7f37c27', '1', '1', 'user.jpg', '', '2015-01-13', null, null, '0', '2015-01-13 16:30:49');

-- ----------------------------
-- Table structure for user_copy
-- ----------------------------
DROP TABLE IF EXISTS `user_copy`;
CREATE TABLE `user_copy` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `account` varchar(30) default NULL,
  `password` varchar(200) default NULL,
  `UserRoleId` varchar(36) default NULL,
  `status` int(11) default '0',
  `image` varchar(100) default 'user.jpg',
  `gender` bit(1) default NULL,
  `birthday` date default NULL,
  `email` varchar(100) default NULL,
  `phone` varchar(15) default NULL,
  `coins` bigint(20) default '0',
  `coinsTime` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_copy
-- ----------------------------
INSERT INTO `user_copy` VALUES ('105a5021-db29-44b9-9eec-7ad1ed974b24', null, null, '2014-05-26 10:22:21', '777777', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 'dfe@qq.com', null, '0', null);
INSERT INTO `user_copy` VALUES ('1b72adf6-4a09-4aa1-b8e2-184dfba1a6ed', null, null, '2014-05-26 10:22:21', '555555', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 's@dd.com', null, '0', null);
INSERT INTO `user_copy` VALUES ('4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'liang', null, '2014-06-12 11:01:48', '梁', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '1', '1', '梁.jpg', '\0', '2014-05-16', 'liang@.qq.com', '18012345678', '7509', '2014-05-23 15:41:28');
INSERT INTO `user_copy` VALUES ('4f5f8c3d-5f0e-4f7f-923a-cc8274bada6c', null, null, '2014-05-26 10:22:21', '333333', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, '1@qq.com', null, '0', null);
INSERT INTO `user_copy` VALUES ('54e08f7c-751e-4ee7-8e3c-91a8f2063dfb', null, null, '2014-05-26 10:22:21', '小明111111', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, '2@qq.com', null, '0', '2014-05-23 15:42:13');
INSERT INTO `user_copy` VALUES ('6f7581ec-91e5-4a21-b410-e127a37178ed', null, null, '2014-05-26 10:22:21', '小小', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 'xiaoxiao@.123.com', null, '0', '2014-05-23 15:42:31');
INSERT INTO `user_copy` VALUES ('7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', 'xiaoa', null, '2014-05-26 15:26:25', '小a', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'd8f7bba0-77ba-48c7-9870-8281cc28a3ce', '1', '小a.jpg', '\0', '2014-05-10', 'xiaoa@163.com', '13012341234', '0', '2014-05-23 15:43:50');
INSERT INTO `user_copy` VALUES ('84d4e72f-94c8-42c9-94ac-63a2a0f24e9b', null, null, '2014-05-26 10:22:21', '666666', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 'ewfd@qq.com', null, '0', null);
INSERT INTO `user_copy` VALUES ('89eb3026-c58b-45fc-b3b6-43d80de16e5a', null, null, '2014-05-26 10:22:21', '小明ddddd2', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 's@11.com', null, '0', '2014-05-23 15:44:08');
INSERT INTO `user_copy` VALUES ('a250f5cf-1744-47a3-9c31-f22aa589cafa', null, null, '2014-05-26 10:22:21', '444444', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 'sdf@qq.co', null, '0', null);
INSERT INTO `user_copy` VALUES ('c8071432-2e90-45b5-a50d-5319d1458a68', null, null, '2014-05-26 10:22:21', '222222', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, '22@qq.com', null, '0', '2014-05-23 15:44:30');
INSERT INTO `user_copy` VALUES ('e2832b54-17e7-4406-ba2a-62af7a7b3385', null, null, '2014-05-26 10:22:21', '小明ddddd', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', '2daae34e-274d-4661-b8da-e4891c83948e', '1', null, '\0', null, 'dd@qq.com', null, '40', '2014-05-23 15:44:48');
INSERT INTO `user_copy` VALUES ('f61f4360-4092-48e5-9066-9684934c65b1', 'xiaoming', null, '2014-06-22 14:12:14', '小明', '03c86363dc602dc26423dab91d0ec75b8b7779905cff26f1610b3813ad5057526e8662b6d7f37c27', 'd8f7bba0-77ba-48c7-9870-8281cc28a3ce', '1', '小明.jpg', '\0', '2014-05-10', 'xiaoming@163.com', '13056785678', '80', '2014-05-30 10:03:52');

-- ----------------------------
-- Table structure for usermenu
-- ----------------------------
DROP TABLE IF EXISTS `usermenu`;
CREATE TABLE `usermenu` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `_order` int(20) default NULL,
  `porder` int(10) default NULL,
  `icon` varchar(30) default NULL,
  `url` varchar(100) default NULL,
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermenu
-- ----------------------------

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL COMMENT '订单号',
  `comment` text,
  `privilege` int(11) default '0',
  `createtime` timestamp NULL default NULL,
  `status` int(11) NOT NULL default '0',
  `orderNum` varchar(20) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `consignee` varchar(20) default NULL,
  `consigneePhone` varchar(20) NOT NULL,
  `deliveryAddress` varchar(200) NOT NULL,
  `groupLocks` int(11) NOT NULL default '1' COMMENT '1为基本锁，2为团购锁',
  `lockId` varchar(360) NOT NULL,
  `price` double NOT NULL,
  `number` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES ('04d72bc1-a548-41ad-8a74-8b590ff9e42c', '14082317143823', null, '0', '2014-08-23 17:14:38', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'hh', 'hh', 'hh', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('07102f06-1b37-4d8e-9261-0a7e17839846', '140825130505807', null, '0', '2014-08-25 13:05:05', '1', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'ff', 'ss', 'gg', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('086902b1-1092-4254-b52d-1fba3a3e4fab', '140823170705980', null, '0', '2014-08-23 17:07:05', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('0d46a090-f593-48b2-9e12-965c72b3c7a7', '140913134207921', null, '0', '2014-09-13 13:42:07', '0', '1,', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '陌陌', '16464647979', '末末', '1', '27c3d26d-e78f-48b9-b676-b1278fdac7bb,', '23.98', null);
INSERT INTO `userorder` VALUES ('125f2d0e-a4fe-48ed-8ff9-9693ffc8ac1f', '140825094857310', null, '0', '2014-08-25 09:48:57', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'gg', 'gg', 'gg', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('1a63230b-bda8-450b-95c3-ebf9f11a4856', '140913145355816', null, '0', '2014-09-13 14:53:55', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('1a9d9593-296c-4fb9-861f-0ade2f25915a', '140711003117179', null, '0', '2014-08-14 17:32:12', '1', '10,20,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '梁', '18012341234', '南京东路', '1', '27c3d26d-e78f-48b9-b676-b1278fdac7bb,04ac2b60-1e8b-4a98-a454-d5ab20cd3535,', '34.38', null);
INSERT INTO `userorder` VALUES ('1cf46a36-fc22-4cdd-a517-04717111e482', '141220155502417', null, '0', '2014-12-20 15:55:02', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('254231b1-defa-4585-90ff-fedfb794a874', '140823171718119', null, '0', '2014-08-23 17:17:18', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'jj', 'kj', 'jj', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('341c014e-8a97-43d8-9af6-f78f4e7e2ec2', '140823170457185', null, '0', '2014-08-23 17:04:57', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('378709bc-c7ac-4025-852a-c40b0e4be6e7', '140828103827459', null, '0', '2014-08-28 10:38:27', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '快乐', '15577854885', '莫名', '1', '27c3d26d-e78f-48b9-b676-b1278fdac7bb,', '23.98', null);
INSERT INTO `userorder` VALUES ('3a3e0f16-fdc4-46d8-9298-719d87317bc0', '150110162428743', null, '0', '2015-01-10 16:24:28', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'Hhh', 'Hh', 'Hh', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('42a7ebe5-a321-44cf-b969-ae7c3711ef39', '140825130210934', null, '0', '2014-08-25 13:02:10', '1', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'cc', 'cc', 'cc', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('43d69c9c-17ff-4ec0-ba4d-193e4e6487ca', '140814170149416', null, '0', '2014-08-15 10:13:55', '0', '23,32', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'liang', '18012345678', '南京东路', '2', '0229b13b-5970-4519-8b77-50de4c29f450,19d76141-0be6-451a-99e3-991a49d30835,', '453', null);
INSERT INTO `userorder` VALUES ('4570ada2-da83-4799-8ca7-dc97df7d8cfb', '14122015504942', null, '0', '2014-12-20 15:50:49', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('476f4de2-db93-43f1-9215-065d6ac7e02a', '150110162535498', null, '0', '2015-01-10 16:25:35', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '57ca0268-3b85-4143-9cfa-f4bc28e4aa6b,', '34', null);
INSERT INTO `userorder` VALUES ('47a3ce57-e5f0-415d-8521-441381f4bbb4', '14082511233468', null, '0', '2014-08-25 11:23:34', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'hh', 'hh', 'hh', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('48b53705-4420-43ba-b7a9-ce480b515fa6', '141219223804800', null, '0', '2014-12-19 22:38:04', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('4f27bddd-0e94-4e58-84e2-8017cb57fa8f', '15011711012037', null, '0', '2015-01-17 11:01:20', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'Gaff ', '17728838777', 'John ', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('57515a24-945d-4b15-b609-8b38fd64caac', '140913145247704', null, '0', '2014-09-13 14:52:47', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '南昌', '13646467979', '莫得', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('5ba9e101-c206-42c1-a000-44a614269d7a', '150110163246454', null, '0', '2015-01-10 16:32:46', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '莫', '莫', '莫', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('5e521ea8-a789-4425-88c0-d97b39761e80', '141226175849875', null, '0', '2014-12-26 17:58:49', '1', '1,', '55522a93-260f-41bb-8bf5-c55744b96772', 'dd', 'dd', 'dd', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('72dd1bb9-0968-4871-b135-7c2d8db0d2cd', '140823172028392', null, '0', '2014-08-23 17:20:28', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'aa', 'aa', 'ss', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('7c93cbef-1f4d-44ef-99f7-1be10a178620', '140711001733790', null, '0', '2014-08-14 17:32:11', '1', '14', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '梁', '18012341234', '南京东路', '1', '27c3d26d-e78f-48b9-b676-b1278fdac7bb,', '23.98', null);
INSERT INTO `userorder` VALUES ('89d5906a-bc53-4ae9-b52c-f3692416acf2', '141220155027113', null, '0', '2014-12-20 15:50:27', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('9a089890-5f16-4877-8d5a-9089a123c2c8', '141217184028712', null, '0', '2014-12-17 18:40:28', '0', '2,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '19.4', null);
INSERT INTO `userorder` VALUES ('9c097af8-3774-45c6-aa81-85363a405780', '140814170458133', null, '0', '2014-08-15 10:14:01', '0', '43', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'liang', '18012345678', '南京东路', '1', '1027e34e-422b-41f9-884a-e1922011c55d,', '42', null);
INSERT INTO `userorder` VALUES ('aa176be9-865c-40cd-9b68-2659562633ec', '141227153926155', null, '0', '2014-12-27 15:39:26', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('b69bebd7-b111-4c3c-8c39-e433f50195d9', '141220145733428', null, '0', '2014-12-20 14:57:33', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('bb76e19d-003d-4a08-9fd8-2fe0d31ffcfe', '150117112340137', null, '0', '2015-01-17 11:23:40', '0', '2,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'Gg', 'Gg', 'Gg ', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '19.4', null);
INSERT INTO `userorder` VALUES ('be831151-bece-48eb-82d4-def4add432b9', '150117112741868', null, '0', '2015-01-17 11:27:41', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('c050c4ec-b86c-4490-87b2-482df0eeff88', '141220155156684', null, '0', '2014-12-20 15:51:56', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('d6dbcad0-2ec2-4f07-8072-85d7e58d187c', '141220155106388', null, '0', '2014-12-20 15:51:06', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);
INSERT INTO `userorder` VALUES ('e6a8a1d6-ce19-43fc-909d-080b3dbfefd6', '140825130047839', null, '0', '2014-08-25 13:00:47', '1', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'cc', 'cc', 'cc', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('eb912472-8aa1-4538-b9bc-a080cb09e282', '141221101428588', null, '0', '2014-12-21 10:14:28', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('fba7c418-6f2f-4fe4-be49-4e2626893bdc', '140823170946430', null, '0', '2014-08-23 17:09:46', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '19d76141-0be6-451a-99e3-991a49d30835,', '8.8', null);
INSERT INTO `userorder` VALUES ('fe9506a0-be08-4566-beca-8f9ba4057eb8', '141221103119143', null, '0', '2014-12-21 10:31:19', '0', '1,', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '', '', '', '2', '0229b13b-5970-4519-8b77-50de4c29f450,', '9.7', null);

-- ----------------------------
-- Table structure for userordert
-- ----------------------------
DROP TABLE IF EXISTS `userordert`;
CREATE TABLE `userordert` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `userOrderId` varchar(36) NOT NULL,
  `locksId` varchar(36) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `businessId` varchar(36) NOT NULL,
  `number` int(11) NOT NULL,
  `status` int(11) NOT NULL default '0' COMMENT '用户状态：0为未付款；1为已付款(待发货)。',
  `businessStatus` int(11) NOT NULL default '0' COMMENT '商家发货状态：-1为退货；0无意义(可理解为该订单用户未付款)；1为未发货(已付款)；2为已发货。',
  `groupLocks` int(11) NOT NULL default '1' COMMENT '是否为团购锁(1表示否，为基本锁；2表示是，为团购锁)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userordert
-- ----------------------------
INSERT INTO `userordert` VALUES ('03fa9759-f8a9-4cd3-a5c8-930862827167', null, null, '2014-12-26 17:58:49', '141226175849875', '0229b13b-5970-4519-8b77-50de4c29f450', '55522a93-260f-41bb-8bf5-c55744b96772', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '1', '1', '2');
INSERT INTO `userordert` VALUES ('048c886b-ecaa-4c35-a419-9173f43362fd', '', '', '2014-08-23 17:14:38', '14082317143823', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('0701f466-ba47-4dc1-9869-89d1bb6cb2c9', '', '', '2014-08-23 17:09:46', '140823170946430', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('0dd272b5-2729-4a48-9862-07c0748b5cbb', null, null, '2014-12-17 18:40:28', '141217184028712', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '2', '0', '0', '2');
INSERT INTO `userordert` VALUES ('135acb02-7cc7-4a30-95ef-149b7503735b', '', '', '2014-09-13 13:42:07', '140913134207921', '27c3d26d-e78f-48b9-b676-b1278fdac7bb', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '1', '2', '1');
INSERT INTO `userordert` VALUES ('1be48973-dc2f-40c9-8ba4-771107e0d834', '', '', '2014-08-23 17:04:57', '140823170457185', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('29d7d619-9d5e-4d3c-a0b2-d67a0aeb2c9f', '', '', '2014-09-13 14:53:56', '140913145355816', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('335ccc2f-6547-46db-97c2-51e1265676d0', null, null, '2014-12-20 14:57:33', '141220145733428', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('35843c24-d42b-4721-917a-4681bf5c6989', '', '', '2014-08-23 17:07:05', '140823170705980', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('408c2f26-83e1-4bdf-af25-5cb6b943f21f', null, null, '2015-01-10 16:32:46', '150110163246454', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('461ee6f1-b3b2-4f4d-8d91-b5ab2e283c1b', null, null, '2015-01-17 11:23:40', '150117112340137', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '2', '0', '0', '2');
INSERT INTO `userordert` VALUES ('6de9a31f-00b9-40d5-8af4-051df518853b', null, null, '2014-12-20 15:50:27', '141220155027113', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('76a0d12a-4d95-45d9-a24b-d6ac9f8c477a', null, null, '2014-12-27 15:39:26', '141227153926155', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('7bf2935c-6b9e-402b-a6a9-3cb1f34a2054', null, null, '2015-01-10 16:25:35', '150110162535498', '57ca0268-3b85-4143-9cfa-f4bc28e4aa6b', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('9981205a-e5da-4ae0-8666-0d655ff7a750', null, null, '2014-12-19 22:38:04', '141219223804800', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('9bd25682-8085-4020-9781-6a549d9313c2', '', '', '2014-08-25 13:05:05', '140825130505807', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '1', '2', '2');
INSERT INTO `userordert` VALUES ('9d404760-721d-4420-8e3b-8cd23eafd41e', '', '', '2014-08-14 17:34:47', '140814170149416', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '33', '0', '0', '2');
INSERT INTO `userordert` VALUES ('9d404760-721d-4420-8e3b-8cd23eafd41w', '', '', '2014-08-12 11:16:13', '140814170149416', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '22', '1', '1', '2');
INSERT INTO `userordert` VALUES ('a0f1968f-32b5-4156-8eff-ce206a5273d5', '', '', '2014-08-23 17:20:28', '140823172028392', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('a537edce-0938-4359-9c9b-72901224b778', null, null, '2014-12-21 10:31:19', '141221103119143', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('ac72656d-56de-4daf-8351-afb55bcf8f50', '', '', '2014-08-28 10:38:27', '140828103827459', '27c3d26d-e78f-48b9-b676-b1278fdac7bb', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '1', '1', '1');
INSERT INTO `userordert` VALUES ('b2d8fa4a-a1fc-451a-87d3-29535850bdc7', '', '', '2014-08-25 11:23:34', '14082511233468', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('b84c5b9e-f16d-4f7c-8749-7f0af1af3355', '', '', '2014-08-25 13:00:47', '140825130047839', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('ccc86525-0a6a-4f9f-9761-dc8d0ceee834', null, null, '2014-12-21 10:14:28', '141221101428588', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('ce240087-b6ce-480c-80c4-004dc25999a5', null, null, '2014-12-20 15:51:06', '141220155106388', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('d117c8be-7e12-4d54-89a2-8c0ef03a3854', '', '', '2014-08-12 11:07:14', '140814170458133', '04ac2b60-1e8b-4a98-a454-d5ab20cd3535', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '32', '0', '1', '1');
INSERT INTO `userordert` VALUES ('d117c8be-7e12-4d54-89a2-8c0ef03a385d', '', '', '2014-08-20 15:02:36', '140814170458133', '27c3d26d-e78f-48b9-b676-b1278fdac7bb', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '43', '0', '1', '1');
INSERT INTO `userordert` VALUES ('d6a74f80-3116-4d06-849b-8c131494f33a', null, null, '2014-12-20 15:55:02', '141220155502417', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('deeb7795-bd7b-4021-bc8b-9e8fdb1fc9db', null, null, '2015-01-10 16:24:28', '150110162428743', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('df6de124-4eb9-49e0-8876-d8d4f5a9adbf', '', '', '2014-08-23 17:17:19', '140823171718119', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('e374cfc6-07f5-4ff1-a7a3-71d42ccb04b4', null, null, '2015-01-17 11:01:20', '15011711012037', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('e63eaee4-9392-4754-b5ed-d41ac519c573', '', '', '2014-08-25 09:48:57', '140825094857310', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '1', '1', '2');
INSERT INTO `userordert` VALUES ('e9d7c1e9-d50d-42c0-99e1-71e212ba3491', '', '', '2014-08-25 13:02:10', '140825130210934', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '1', '1', '2');
INSERT INTO `userordert` VALUES ('ed4c3cf9-3f2f-4d25-8f4a-ec1c5cf1a2fe', null, null, '2014-12-20 15:51:56', '141220155156684', '19d76141-0be6-451a-99e3-991a49d30835', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('ee9541a7-f01b-49d2-8171-5e4b26d524e5', '', '', '2014-09-13 14:52:47', '140913145247704', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('ef7d990a-47ca-4010-b7ad-bb057ed4c5ae', null, null, '2015-01-17 11:27:41', '150117112741868', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');
INSERT INTO `userordert` VALUES ('ff0e3703-0bd7-4280-817c-f75035e1c5cf', null, null, '2014-12-20 15:50:49', '14122015504942', '0229b13b-5970-4519-8b77-50de4c29f450', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '1', '0', '0', '2');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '管理员', '所有权限', '2014-05-26 15:23:21', '1');
INSERT INTO `userrole` VALUES ('4195f48e-6aba-466f-bdda-8152fb10074d', 'VIP会员', '可浏览和下载站内任何信息，发表论坛', '2014-04-16 22:20:20', '0');
INSERT INTO `userrole` VALUES ('85431849-d438-4f20-986d-a5ffebdd11a6', '同行', '权限略小于商户(验证会员),作用是可以查看批发商户.', '2014-12-27 09:46:51', '0');
INSERT INTO `userrole` VALUES ('91b61db6-397f-4c64-b7b5-a575c3c70281', '验证会员', '可浏览更多信息及下载部分信息，一定条件下可以花金币购买下载信息', '2014-12-05 11:53:21', '0');
INSERT INTO `userrole` VALUES ('a6ec52b8-4e56-4856-aa25-547348e66ebc', '普通会员', '浏览信息，可选择是否成为验证会员', '2014-12-05 11:53:23', '0');
INSERT INTO `userrole` VALUES ('afdd6e1c-216e-47a1-9f4b-48181c2c3d06', '游客', '浏览信息，可选择是否注册会员', '2014-04-16 22:20:20', '0');

-- ----------------------------
-- Table structure for userrole_menu
-- ----------------------------
DROP TABLE IF EXISTS `userrole_menu`;
CREATE TABLE `userrole_menu` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `roleId` varchar(36) NOT NULL,
  `menuId` varchar(36) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole_menu
-- ----------------------------
INSERT INTO `userrole_menu` VALUES ('0008950c-8a79-4076-af8a-8ed1fa143d76', null, null, '2014-01-14 20:20:42', '0', '1', 'a898288b-9415-49a6-8ca0-5ac6293b6e75');
INSERT INTO `userrole_menu` VALUES ('00163d03-9c49-4c9a-8e1a-d7d9ce4f9ad3', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('003087d3-2c23-4669-8a6b-8223d2d77d2c', null, null, '2013-10-07 05:08:54', '0', '1', 'c70953cd-ebd7-4747-a39f-6a32da5a2996');
INSERT INTO `userrole_menu` VALUES ('006797d1-79ee-455b-bcb7-f3a559a9dc0a', null, null, '2013-10-07 05:08:55', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '3088b773-aaa8-4f9b-8285-e69df2fe7072');
INSERT INTO `userrole_menu` VALUES ('034099eb-f598-4efd-87b3-51eba4be5bf6', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '4a857bdf-599b-4ac4-9238-69202a8a0848');
INSERT INTO `userrole_menu` VALUES ('038d232b-3887-49d7-9176-d436e7a0380a', null, null, '2013-10-07 05:08:56', '0', '1', 'e6e1947a-6980-4928-8acd-f63732e262fd');
INSERT INTO `userrole_menu` VALUES ('064130f5-78f8-4d21-8ddb-d90cba3f863a', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('0661fe70-8f46-4a10-9675-52ec3fbf2257', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('06d3808b-6951-4096-b876-b8f03eedab31', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'afbae9aa-85d3-4a8e-9733-ce34ffa31271');
INSERT INTO `userrole_menu` VALUES ('09065da1-35f7-406f-844c-4e6d50cd0429', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'afcb1599-9d05-42fa-9598-23211052782a');
INSERT INTO `userrole_menu` VALUES ('0adb1988-db03-4d01-bad4-3047def08054', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('0e4f49d8-8cda-4403-abb6-d5a9cc9a19a4', null, null, '2013-10-07 05:08:57', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '');
INSERT INTO `userrole_menu` VALUES ('0f3f0fdd-6d8d-4bbd-85dc-fc03bb7c7948', null, null, '2013-09-01 23:18:47', '0', '1', '2eb6ca35-6c45-4010-8f98-b8b7237eae3a');
INSERT INTO `userrole_menu` VALUES ('1', '1', null, '2013-08-27 21:39:21', '0', '1', '1');
INSERT INTO `userrole_menu` VALUES ('101805b8-807b-4447-8e34-5fa9f685eb24', null, null, '2014-01-15 14:59:40', '0', '1', 'bea09251-7af8-4688-b429-caceb2a94f6e');
INSERT INTO `userrole_menu` VALUES ('11543da2-5900-4aae-81f6-7d6974d0c1ef', null, null, '2013-10-07 05:08:58', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '522de825-4243-4495-9f70-284d4e01fcf6');
INSERT INTO `userrole_menu` VALUES ('15b4a883-8314-40f9-bcd6-6d3b9a50ca3b', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('17fc4447-9686-43bd-8806-74bf4e0d5435', null, null, '2014-03-01 09:06:55', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('19758846-3ba1-4a2e-af69-be9d9bbe6914', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'beebc53d-3e3d-481a-9edb-b6389530ba76');
INSERT INTO `userrole_menu` VALUES ('198d02a1-270b-45cc-94c4-15996449fff4', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('19e89923-d128-4a2c-8933-c846fc9ba801', null, null, '2013-12-01 09:10:46', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('1d6b2c47-a085-493d-8691-f44551dab957', null, null, '2014-03-01 09:06:55', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('1db17fb3-d099-4a3b-9441-b140cba7fcee', null, null, '2014-03-15 09:21:19', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '6205c0fe-3ae1-42c4-a2d8-1ad170ad2e62');
INSERT INTO `userrole_menu` VALUES ('1e0e8514-5e3a-4a7e-83e5-0dc6143e3d2a', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'afbae9aa-85d3-4a8e-9733-ce34ffa31271');
INSERT INTO `userrole_menu` VALUES ('1f48fe93-7691-44c4-b186-235c602ea94a', null, null, '2013-10-07 05:09:00', '0', '1', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('2', '2', null, null, '0', '1', '2');
INSERT INTO `userrole_menu` VALUES ('20b8f00c-b859-4bcb-a292-cc47c6a74775', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('22598400-5232-4302-9a1f-12d277f46331', null, null, '2013-10-07 05:09:02', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('2305ec9c-56c0-43c5-811e-8d2766b51847', null, null, '2014-03-01 09:06:55', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('2389b780-c0ad-4daa-9aa5-92f4e2ce04db', null, null, '2013-10-07 05:09:03', '0', '1', '44e169b6-89c2-452b-a71f-bdfbcd922bc8');
INSERT INTO `userrole_menu` VALUES ('23c80d54-7a88-4a77-8027-ae8c9c4a7794', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'beebc53d-3e3d-481a-9edb-b6389530ba76');
INSERT INTO `userrole_menu` VALUES ('298489be-a29b-4515-8495-e61f5a1eb969', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '1a88ccf8-5227-453e-bd5a-59e26165cd1b');
INSERT INTO `userrole_menu` VALUES ('2a3f3a4a-1024-4353-85d5-4fea8c4e6563', null, null, '2013-10-07 05:09:04', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '05a2fe24-b496-493c-a3c8-fce527a1587d');
INSERT INTO `userrole_menu` VALUES ('2b650ac3-dbf8-484a-88fa-d9e596abf23c', null, null, '2013-10-07 05:09:05', '0', '1', '05a2fe24-b496-493c-a3c8-fce527a1587d');
INSERT INTO `userrole_menu` VALUES ('2cc1f7bf-9a2a-4bda-aa9e-c33d60f4c5f1', null, null, '2013-10-18 11:03:09', '0', '1', '3b3226f8-0f7a-40df-a9f1-5becc9dadaf9');
INSERT INTO `userrole_menu` VALUES ('2d505ba0-b8a2-4e21-afc5-24fcdb0069cc', null, null, '2014-01-17 10:14:55', '0', '1', '74d2fa83-5b51-438c-b68a-9138545c9654');
INSERT INTO `userrole_menu` VALUES ('2efb50d9-333a-4358-a0a8-e807256e002f', null, null, '2013-10-07 05:09:06', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('305ba272-c560-4307-b643-4d52ba5cfa1b', null, null, '2013-10-07 05:09:07', '0', '1', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('317aa2b2-7e57-41fe-83ea-771db07048ec', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('355fa19b-f580-42a9-97e0-8e2be187f6c1', null, null, '2013-10-07 05:09:09', '0', '1', '75fa77d5-cb80-4fa6-b6b5-b285fa381c66');
INSERT INTO `userrole_menu` VALUES ('35e66ab3-487c-4e98-968e-393687001131', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('376d9c63-44f9-4f28-82f4-515daa340b53', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('38dff6dd-ea0a-416a-a982-5c4bf44a0ce4', null, null, '2013-10-07 05:09:11', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '0334b23b-221d-461b-9766-49981183ad62');
INSERT INTO `userrole_menu` VALUES ('39ce59e1-bce8-45c4-9fc5-bb01e89b467d', null, null, '2013-10-07 05:09:12', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'd44b392c-0434-47f5-a164-6062b58fec0e');
INSERT INTO `userrole_menu` VALUES ('3a49e9d6-a284-4ce8-973a-ede316d161f9', null, null, '2013-10-07 05:11:31', '0', '1', '629a6004-db48-49a2-ab07-097bd9a19eb7');
INSERT INTO `userrole_menu` VALUES ('3aa5658d-0026-49cd-80de-d96e7ffcdec8', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'afcb1599-9d05-42fa-9598-23211052782a');
INSERT INTO `userrole_menu` VALUES ('3af1e273-21c7-4fd1-9ad7-05e38c757395', null, null, '2013-10-07 14:22:12', '0', 'bc056dec-9a18-4584-804c-1c4368909312', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('3e1389e5-5c2a-4dfd-a7d4-311d3c9ee859', null, null, '2013-12-01 09:10:47', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '1a88ccf8-5227-453e-bd5a-59e26165cd1b');
INSERT INTO `userrole_menu` VALUES ('3e2cc824-bb73-42e3-bdfd-db9b6cd764a6', null, null, '2014-03-01 09:06:55', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('3f33cd02-f805-4c7b-9bd3-86c94af72f77', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '388e6246-800d-460b-8def-90e7d4bd2dd4');
INSERT INTO `userrole_menu` VALUES ('40211655-fe51-49ab-a1ad-cb12cb308da9', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('4308e606-bdd7-4fb0-9266-1570b6895843', null, null, '2013-10-07 05:11:31', '0', '1', 'f131072b-c1a3-409c-8194-0fb2cca1c079');
INSERT INTO `userrole_menu` VALUES ('4398b9f1-493c-43d0-b0c8-a517818cb4e4', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '9b6e1447-a682-4f69-8f15-b40febbf83e2');
INSERT INTO `userrole_menu` VALUES ('43f1bfb2-47c3-442c-afd3-e8760635f6ec', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '17af738f-3596-40ac-8c8f-a0d02faa288f');
INSERT INTO `userrole_menu` VALUES ('445d50f1-9082-48bb-b3f6-0a0c310eda5c', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('453bccf2-53fa-40fe-9907-512ffbf0a70a', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('459bf2ff-34a8-444b-a495-1f0506bf0ae5', null, null, '2013-10-07 05:11:31', '0', '1', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('49ab2725-9043-47d7-a6b8-075da4fd9fb1', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'beebc53d-3e3d-481a-9edb-b6389530ba76');
INSERT INTO `userrole_menu` VALUES ('4a8b1b64-7f01-4631-8738-7ddfa6da18a8', null, null, '2013-10-07 05:11:31', '0', 'bc056dec-9a18-4584-804c-1c4368909389', 'a7e88c81-dc19-4059-9720-e5bd2ad6c7e8');
INSERT INTO `userrole_menu` VALUES ('4b294728-732f-4eee-b463-9595aff5713e', null, null, '2013-11-30 09:52:30', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('4d145456-6895-427f-ab5c-253c36300259', null, null, '2013-12-01 09:10:47', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '9b6e1447-a682-4f69-8f15-b40febbf83e2');
INSERT INTO `userrole_menu` VALUES ('4d523cd7-a9b4-4658-9ee8-7e1c47672e6c', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'afbae9aa-85d3-4a8e-9733-ce34ffa31271');
INSERT INTO `userrole_menu` VALUES ('4e0b8806-72ee-4eff-8076-e5068643e5cc', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '4a857bdf-599b-4ac4-9238-69202a8a0848');
INSERT INTO `userrole_menu` VALUES ('50efb349-a99f-4a9c-b5a9-a0534248a6ab', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'a7e88c81-dc19-4059-9720-e5bd2ad6c7e8');
INSERT INTO `userrole_menu` VALUES ('51b54726-4dd9-4305-8e4e-a2f805c1a327', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('51e23bac-38a8-4647-9175-bd71d14d998c', null, null, '2013-10-07 05:11:31', '0', '1', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('5215ec3c-d025-4926-8506-1853a1f0264c', null, null, '2014-02-10 16:10:55', '0', '1', 'f00e9331-c0c6-40bd-94fd-85eb71da2adf');
INSERT INTO `userrole_menu` VALUES ('52581b78-111f-4f68-a6eb-d5efca3acf4e', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('55b44ef0-1780-492d-8f2e-1eadd875fb43', null, null, '2013-10-07 05:11:31', '0', 'bc056dec-9a18-4584-804c-1c4368909389', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('56659e5d-59e7-4f82-b643-9c291aef51c3', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'a898288b-9415-49a6-8ca0-5ac6293b6e75');
INSERT INTO `userrole_menu` VALUES ('5670d883-2bf2-4912-a6a0-e3c37e12f3c6', null, null, '2013-10-07 05:11:31', '0', '1', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('5807775e-5ee1-4eae-8793-953e607db912', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '629a6004-db48-49a2-ab07-097bd9a19eb7');
INSERT INTO `userrole_menu` VALUES ('59e8433c-762a-4576-b5b7-ec50fedb11e6', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('5ba3877d-37c6-4202-bbb9-eca99fd19bb6', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('5ba3b3dc-b78a-45f5-a2bc-9fe34ebffff4', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '8eee92d2-ef5c-425e-a1dd-1e851f580caa');
INSERT INTO `userrole_menu` VALUES ('5c9a2414-da4b-4aa1-a9b2-6a1324de0e97', null, null, '2014-03-15 09:21:42', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '44e42e04-9584-4ff4-9eba-9a78a7c4f4cc');
INSERT INTO `userrole_menu` VALUES ('5cf30136-9a39-4411-9cb5-eb12f7a2c78e', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '388e6246-800d-460b-8def-90e7d4bd2dd4');
INSERT INTO `userrole_menu` VALUES ('5dca54ef-0a6e-473f-b38b-d1ce032edf2f', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('5f13935d-93b3-4c3a-82a1-2c5fcf027c35', null, null, '2013-12-01 09:10:46', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('5f5e1354-bf70-464c-9fd6-4816fa8349a0', null, null, '2014-03-20 11:26:47', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', '8319a70e-b086-495c-92e9-40b5e1f268f0');
INSERT INTO `userrole_menu` VALUES ('5f636876-3a81-4c87-b859-ca387d9cb6c7', null, null, '2013-10-07 05:11:31', '0', '1', '35b91a18-f131-49aa-b720-d2cbf5b42d9b');
INSERT INTO `userrole_menu` VALUES ('60c20792-ee79-4ad3-a843-91c990061498', null, null, '2014-01-13 20:24:49', '0', '1', 'beebc53d-3e3d-481a-9edb-b6389530ba76');
INSERT INTO `userrole_menu` VALUES ('627ce8ce-d59a-4b98-bcc5-4acc58bf1473', null, null, '2013-10-13 11:50:37', '0', '1', '34e6c510-49f7-4121-8f54-a9adfca701f6');
INSERT INTO `userrole_menu` VALUES ('6280eee2-5a0f-44bf-99ee-21aefe805f6a', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '11e7e88c-e6e7-413f-815a-62fe6382e386');
INSERT INTO `userrole_menu` VALUES ('629d951a-63c1-4111-8469-29521545e695', null, null, '2013-10-07 05:11:31', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', 'a7e88c81-dc19-4059-9720-e5bd2ad6c7e8');
INSERT INTO `userrole_menu` VALUES ('6334670f-68fb-4775-844f-46cf8547e158', null, null, '2013-09-04 11:16:47', '0', '1', '6205c0fe-3ae1-42c4-a2d8-1ad170ad2e62');
INSERT INTO `userrole_menu` VALUES ('63dce6dd-41e5-4a64-91ec-499846886dce', null, null, '2014-02-10 16:10:55', '0', '1', '0334b23b-221d-461b-9766-49981183ad62');
INSERT INTO `userrole_menu` VALUES ('63e80b1a-7950-4ce3-9956-df32c20d0453', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '4a857bdf-599b-4ac4-9238-69202a8a0848');
INSERT INTO `userrole_menu` VALUES ('654c3ce9-a01f-4e9f-9a70-97663e1f20e4', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('66ff0b92-fee3-4118-b6e4-7545f8a3d467', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('67cc6ac5-631e-4ff7-b49e-63a5af2931e2', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '6205c0fe-3ae1-42c4-a2d8-1ad170ad2e62');
INSERT INTO `userrole_menu` VALUES ('68198645-f275-4159-8108-a6ddccd601a7', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('687763d8-5b5e-4ddd-b211-29fe123dd48d', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'beebc53d-3e3d-481a-9edb-b6389530ba76');
INSERT INTO `userrole_menu` VALUES ('6a42d054-e66c-41b9-a1d7-8dfd568d2cbc', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('6b198dd8-ebc8-455a-b560-f7cf8c6b0e60', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('6bf802f6-b9ca-4c4d-bc7d-d8e201c24a17', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '9b6e1447-a682-4f69-8f15-b40febbf83e2');
INSERT INTO `userrole_menu` VALUES ('6ca6c8cf-70e0-423d-ac42-4a802a3cb40a', null, null, '2013-11-30 13:34:25', '0', '1', 'fc54a06e-acc7-45c5-9832-bbc07d89bb0f');
INSERT INTO `userrole_menu` VALUES ('6f2ac1cf-682b-4952-8451-16c8d721246d', null, null, '2014-01-04 11:50:56', '0', 'bc056dec-9a18-4584-804c-1c4368909389', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('6fc9973f-6848-434d-b03c-65cf3932ddf7', null, null, '2013-12-01 09:10:46', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('7076f6eb-9193-42f1-8a2a-bec8dca67c39', null, null, '2014-03-15 09:21:19', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'a898288b-9415-49a6-8ca0-5ac6293b6e75');
INSERT INTO `userrole_menu` VALUES ('716746b9-7e15-49e3-ad4c-9e16ebf90d78', null, null, '2013-10-07 05:11:31', '0', '1', '522de825-4243-4495-9f70-284d4e01fcf6');
INSERT INTO `userrole_menu` VALUES ('721cc004-3e07-4b04-adb9-8c3f01c65fb0', null, null, '2013-10-07 05:11:31', '0', '1', '8f61c399-74cf-4b56-b9ce-77fb8c96429a');
INSERT INTO `userrole_menu` VALUES ('78f2ccf4-ff66-47a3-ad41-ca7b83053049', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('7be8515b-0256-4735-9f1b-8480101eda7c', null, null, '2013-10-07 05:11:31', '0', '1', '18363562-837c-43e1-9eb6-a9e255ef6480');
INSERT INTO `userrole_menu` VALUES ('7c177938-a1ff-4cc3-be60-d0761650cfcf', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('7e2833f5-8edf-4a95-8df5-55e9d5d3052f', null, null, '2013-09-24 21:03:21', '0', '1', 'afbae9aa-85d3-4a8e-9733-ce34ffa31271');
INSERT INTO `userrole_menu` VALUES ('7e621a4c-e97e-48d2-93fb-c4c5a9f46aa5', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '3b3226f8-0f7a-40df-a9f1-5becc9dadaf9');
INSERT INTO `userrole_menu` VALUES ('7e9d3de7-37dc-4e58-8b23-2cafce9a4747', null, null, '2013-10-07 05:11:31', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('838abfd6-bb8d-4237-878c-e7583e4471ed', null, null, '2013-10-07 14:22:13', '0', 'bc056dec-9a18-4584-804c-1c4368909312', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('838e42ab-f2a9-4bb4-b053-68938f495833', null, null, '2013-11-30 13:34:25', '0', '1', 'b1267f6c-be38-4ee8-8cbf-04aa8b538f57');
INSERT INTO `userrole_menu` VALUES ('83b38ce6-d6e6-41f3-986d-772292ec89ce', null, null, '2013-10-07 05:11:31', '0', '1', '33c50927-1e36-45ec-bf85-1ffc596864d7');
INSERT INTO `userrole_menu` VALUES ('87699362-f149-4777-aafb-d1f88e4a6d6f', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '7a9463c6-3b04-4e5e-bff3-e259bf159408');
INSERT INTO `userrole_menu` VALUES ('87ae520f-6719-449e-bda6-c2295074c199', null, null, '2014-02-10 16:10:55', '0', '1', '44e42e04-9584-4ff4-9eba-9a78a7c4f4cc');
INSERT INTO `userrole_menu` VALUES ('8ad7c96f-ee32-44e2-a800-9d2664c485e9', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '1a88ccf8-5227-453e-bd5a-59e26165cd1b');
INSERT INTO `userrole_menu` VALUES ('8b81b084-337c-4351-b4ab-a339bdfafed3', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('8e293b93-7dbc-4e96-8f2e-ca18daf9b813', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '7a9463c6-3b04-4e5e-bff3-e259bf159408');
INSERT INTO `userrole_menu` VALUES ('8f00b564-bb7e-4a07-b53e-040e08022de8', null, null, '2013-10-07 05:11:31', '0', 'bc056dec-9a18-4584-804c-1c4368909389', '8f61c399-74cf-4b56-b9ce-77fb8c96429a');
INSERT INTO `userrole_menu` VALUES ('910b0a1c-d6e2-422f-9fc1-47d597fd87ed', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('91b9be3f-1b6c-4a87-9015-779646d5dcf5', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '75fa77d5-cb80-4fa6-b6b5-b285fa381c66');
INSERT INTO `userrole_menu` VALUES ('935927be-ad78-4337-8f64-b820c0f9ddd8', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '6205c0fe-3ae1-42c4-a2d8-1ad170ad2e62');
INSERT INTO `userrole_menu` VALUES ('936be8a8-beef-408c-b996-0204bb4ab531', null, null, '2013-12-01 09:10:46', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('94659320-aa1b-45dd-865a-9ebb6f7d6c98', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('9570d23d-1612-4ff9-8a7d-5360684f905a', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '35b91a18-f131-49aa-b720-d2cbf5b42d9b');
INSERT INTO `userrole_menu` VALUES ('966bbd80-0cd1-4ba8-b471-0dc049d4f95d', null, null, '2013-10-07 05:11:31', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('96933dc7-b302-41c3-8afa-7391fa0ff317', null, null, '2013-10-18 11:03:09', '0', '1', '5a3af400-daee-4915-b05d-8dd75c5cc606');
INSERT INTO `userrole_menu` VALUES ('97f4e82a-0913-4d1b-9ab1-be355b14cd04', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('9984a728-a6c7-4199-9028-c101670d0a2a', null, null, '2014-03-01 09:06:55', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('9c78bda5-6392-46d4-8173-fc5e469868ea', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '388e6246-800d-460b-8def-90e7d4bd2dd4');
INSERT INTO `userrole_menu` VALUES ('9f500e26-0e6b-4166-a5e4-349ce735b86b', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'a898288b-9415-49a6-8ca0-5ac6293b6e75');
INSERT INTO `userrole_menu` VALUES ('a0ac7c97-4100-4e74-bcf3-07df7285e306', null, null, '2013-10-07 05:11:31', '0', '1', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('a1056e6a-18e4-4136-a6b2-59a52a328a05', null, null, '2013-10-07 05:11:31', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', '522de825-4243-4495-9f70-284d4e01fcf6');
INSERT INTO `userrole_menu` VALUES ('a11e8e88-b953-429b-bf84-b8fdceb365c6', null, null, '2014-02-25 21:51:07', '0', '1', '8319a70e-b086-495c-92e9-40b5e1f268f0');
INSERT INTO `userrole_menu` VALUES ('a198513e-d258-47ff-8b5e-8953e0efbb18', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('a211a55c-20fc-441a-92d1-a19539d2f0a7', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('a3b552f0-c024-47f2-88dc-2575bd68746d', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '1a88ccf8-5227-453e-bd5a-59e26165cd1b');
INSERT INTO `userrole_menu` VALUES ('a513fa29-85fd-48a0-96d6-76c3a45da0c7', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '17af738f-3596-40ac-8c8f-a0d02faa288f');
INSERT INTO `userrole_menu` VALUES ('a6c50575-3a8b-4ac5-aa4f-04b397d3487b', null, null, '2013-10-07 05:11:31', '0', '1', 'd44b392c-0434-47f5-a164-6062b58fec0e');
INSERT INTO `userrole_menu` VALUES ('a7844e12-9c8a-47c7-8c52-1bc28988d82b', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('a836ca9c-3367-419c-b131-19cf4ab6c162', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'e82be641-9a37-457a-a8bd-dc3df9287fa8');
INSERT INTO `userrole_menu` VALUES ('a8492a6d-a196-4bd9-9b97-cbf31f2494ea', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '7a9463c6-3b04-4e5e-bff3-e259bf159408');
INSERT INTO `userrole_menu` VALUES ('a990441c-c732-4dc9-a0df-b2d125d510c3', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('a9932075-5e48-4e16-ae40-321acc9f4c3f', null, null, '2013-12-01 09:10:46', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('a9af348f-54d9-48b4-8d37-470e38cd31f5', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '1a88ccf8-5227-453e-bd5a-59e26165cd1b');
INSERT INTO `userrole_menu` VALUES ('ab8dc27d-70e7-40e7-abb8-657cd8164ac3', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('ae45101b-6640-429d-b16a-844d5865a6d1', null, null, '2014-03-15 09:21:19', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '17af738f-3596-40ac-8c8f-a0d02faa288f');
INSERT INTO `userrole_menu` VALUES ('ae534734-8730-4fd9-b0e5-0fe4e0e23480', null, null, '2013-10-07 05:11:31', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', '44e169b6-89c2-452b-a71f-bdfbcd922bc8');
INSERT INTO `userrole_menu` VALUES ('b04d480c-2abb-4273-9aad-bc4e7723cbbd', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('b21d99d7-5e16-4302-9611-8d7d9ff10002', null, null, '2013-10-18 11:03:09', '0', '1', 'e82be641-9a37-457a-a8bd-dc3df9287fa8');
INSERT INTO `userrole_menu` VALUES ('b2bed4e2-db02-4540-a5ca-7c23cfbdea92', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '64c9064f-0dd5-492c-8088-a3afdc8b8a5c');
INSERT INTO `userrole_menu` VALUES ('b3690e47-aca0-48e9-ba24-9ae2c498c396', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('b3791595-dfcc-4b40-9a87-0614d0a9374c', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('b5eae48d-e1b5-4e55-b331-e3bf72163cbd', null, null, '2013-10-13 14:08:06', '0', '1', '475f88f1-85f1-4234-9e7a-35325f231ffa');
INSERT INTO `userrole_menu` VALUES ('b6e8b4df-4e0d-4cdc-b1ed-62c6445b0945', null, null, '2013-10-07 05:11:31', '0', '1', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('b7879f80-7231-45d1-87b0-5a4a0d332fc7', null, null, '2013-10-07 05:11:31', '0', 'bc056dec-9a18-4584-804c-1c4368909389', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('b7f5a761-bdaa-45d6-9b48-4fc9ed1698dc', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'e6e1947a-6980-4928-8acd-f63732e262fd');
INSERT INTO `userrole_menu` VALUES ('b831d169-654a-4102-b178-82f232f21469', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('b84797fd-9434-418e-9442-65eaebedebf6', null, null, '2013-10-01 22:49:42', '0', '1', '9409dd99-6250-4fba-af11-38d72697e747');
INSERT INTO `userrole_menu` VALUES ('b8620a60-198e-476b-a96c-9f35118cf419', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '6205c0fe-3ae1-42c4-a2d8-1ad170ad2e62');
INSERT INTO `userrole_menu` VALUES ('b953102e-6d75-4aab-8742-333d5d417a8d', null, null, '2013-11-30 09:52:30', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('bb2f0024-97ea-4731-9b0c-63cbc9892733', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('bb969552-5fd3-411b-b1fb-328aabff1601', null, null, '2013-12-01 09:10:47', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '388e6246-800d-460b-8def-90e7d4bd2dd4');
INSERT INTO `userrole_menu` VALUES ('bbb7d55e-af7b-460d-8588-58ee50523ae2', null, null, '2013-10-07 05:11:31', '0', 'bc056dec-9a18-4584-804c-1c4368909389', '522de825-4243-4495-9f70-284d4e01fcf6');
INSERT INTO `userrole_menu` VALUES ('bc4d3d5f-c1df-4090-8c0c-458182ea1730', null, null, '2013-10-07 05:11:31', '0', '1', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('bd1dcf22-caad-44d3-aa7e-e58b430ea37b', null, null, '2014-01-04 11:50:56', '0', 'bc056dec-9a18-4584-804c-1c4368909389', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('be2ac58f-0c35-4897-be98-47e483d3a629', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'f00e9331-c0c6-40bd-94fd-85eb71da2adf');
INSERT INTO `userrole_menu` VALUES ('befad755-9b54-4f4f-ad33-cef5a11cfefe', null, null, '2013-10-07 05:11:31', '0', '1', '3088b773-aaa8-4f9b-8285-e69df2fe7072');
INSERT INTO `userrole_menu` VALUES ('bf52ec93-3aa9-49ab-90ea-8a316aca5e12', null, null, '2013-11-30 09:52:30', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('bf6c90b3-d368-403a-b455-f7efc4d20b5c', null, null, '2014-03-15 09:21:19', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'afcb1599-9d05-42fa-9598-23211052782a');
INSERT INTO `userrole_menu` VALUES ('bfaa298b-abba-4de0-801b-a5031200cf75', null, null, '2013-10-07 05:11:31', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('c07ad008-0319-413e-8656-9c7c4d8125e0', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'afcb1599-9d05-42fa-9598-23211052782a');
INSERT INTO `userrole_menu` VALUES ('c0d82381-8d3a-4e1c-ae90-db3198b8e9eb', null, null, '2013-10-07 05:11:31', '0', '1', '64c9064f-0dd5-492c-8088-a3afdc8b8a5c');
INSERT INTO `userrole_menu` VALUES ('c30b346d-3d21-4b6c-8830-5bbae3ecdc13', null, null, '2013-10-07 14:22:12', '0', 'bc056dec-9a18-4584-804c-1c4368909312', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('c36ad0cf-fcf9-4f50-949f-3b0cced9fc2e', null, null, '2013-10-07 05:11:31', '0', '1', 'f2043306-05ea-441c-b8e9-3e5af51370f4');
INSERT INTO `userrole_menu` VALUES ('c397d622-5be8-4007-965a-08588cba3770', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '17af738f-3596-40ac-8c8f-a0d02faa288f');
INSERT INTO `userrole_menu` VALUES ('c5f59712-3fc4-485d-be1e-7526f7fa66e2', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'f2043306-05ea-441c-b8e9-3e5af51370f4');
INSERT INTO `userrole_menu` VALUES ('c8d66e70-91e3-4a79-9597-e1143ae30a9c', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('c8f95765-34a0-45d3-9ad7-743008ca12cb', null, null, '2013-09-22 21:08:37', '0', '1', '7254799d-7dbc-42b0-9634-205ca255e177');
INSERT INTO `userrole_menu` VALUES ('cbba6b18-09d5-41ae-9929-12cba80a8fa1', null, null, '2013-09-15 16:28:39', '0', '77617c8f-cc06-41ad-9d13-033a4d2deabe', '8f61c399-74cf-4b56-b9ce-77fb8c96429a');
INSERT INTO `userrole_menu` VALUES ('cc44e0b2-61d0-4fce-a729-816d035b5ed5', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '5a3af400-daee-4915-b05d-8dd75c5cc606');
INSERT INTO `userrole_menu` VALUES ('cc7542fd-5953-4c29-a3d9-b885a26749bc', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('ce0619e7-00a6-4f4a-8896-acce9ab06007', null, null, '2013-10-07 05:11:31', '0', '1', '8eee92d2-ef5c-425e-a1dd-1e851f580caa');
INSERT INTO `userrole_menu` VALUES ('cfc9fdb4-016b-42fa-aa51-e46610bcfc1c', null, null, '2013-10-07 05:11:31', '0', '1', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('cfed28e0-e82b-4598-9786-6aa2d43327ac', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '6205c0fe-3ae1-42c4-a2d8-1ad170ad2e62');
INSERT INTO `userrole_menu` VALUES ('d239e160-86a0-44a1-aa27-5eaf6aef5e32', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'd4a3ad7a-88aa-4b51-a3d9-2bc40c5c9241');
INSERT INTO `userrole_menu` VALUES ('d23e3fc0-5d59-44ae-8338-b3d2f7ad6a2a', null, null, '2013-10-07 05:11:31', '0', '1', '6');
INSERT INTO `userrole_menu` VALUES ('d28b6ba3-7d18-4120-b656-f760027252f2', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '388e6246-800d-460b-8def-90e7d4bd2dd4');
INSERT INTO `userrole_menu` VALUES ('d3df1954-8179-4a7e-99e1-3f592bc3a54c', null, null, '2013-10-07 05:11:31', '0', '1', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('d42c1cdc-eba6-4f16-a0ae-fa7c8b2e429e', null, null, '2013-10-07 14:22:13', '0', 'bc056dec-9a18-4584-804c-1c4368909312', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('d47e07a1-c810-4ae7-8c36-a30d6e0e2a6b', null, null, '2013-10-07 05:11:31', '0', '1', '26b771e5-8d2d-487a-ae17-9a46f3699e4f');
INSERT INTO `userrole_menu` VALUES ('d4949ed0-2934-48ce-b6ec-213305a14dd2', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('d5636eae-418c-468f-8c71-ae5b7bae5180', null, null, '2014-03-15 09:21:42', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'f00e9331-c0c6-40bd-94fd-85eb71da2adf');
INSERT INTO `userrole_menu` VALUES ('d5b516a2-41e6-4018-bd02-7992263d65f9', null, null, '2013-10-07 05:11:31', '0', '1', 'a7e88c81-dc19-4059-9720-e5bd2ad6c7e8');
INSERT INTO `userrole_menu` VALUES ('d6f57de2-1dd8-4f32-be02-f05194dc68ac', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('d7ed9fa6-11ad-48c7-9f16-45f3c25f33d1', null, null, '2013-09-07 12:20:43', '0', '1', '17af738f-3596-40ac-8c8f-a0d02faa288f');
INSERT INTO `userrole_menu` VALUES ('d86dc1ba-7c4e-402d-a479-c58a92b42669', null, null, '2013-11-30 09:52:30', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', 'b5eef99e-6771-4389-836c-44f5f5a83209');
INSERT INTO `userrole_menu` VALUES ('d8ac8785-bda7-4f2f-a40a-72296740e91b', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('d8ce41fa-c8f2-4dec-8b1b-8b137b019717', null, null, '2013-11-30 13:29:53', '0', '56e3036f-64b6-4ea1-a740-b32ca18dba99', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('d9889802-18b8-4914-9c8b-84d3fb402a49', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('dbcdf7e3-8460-4346-936f-e255d008d8b6', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '627a517a-832a-432f-917e-85c816cdb5d7');
INSERT INTO `userrole_menu` VALUES ('dbf9acff-fbda-4e1e-89e0-e8addfa62306', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('df074e0e-2886-4e6e-9188-4960ef67fa61', null, null, '2013-10-07 05:11:31', '0', '1', '11e7e88c-e6e7-413f-815a-62fe6382e386');
INSERT INTO `userrole_menu` VALUES ('df9af697-f79d-45e0-8042-922938fe6ce9', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('e07e17da-ff83-4848-8fe4-e2edbb2bc133', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('e22cd1c6-c932-4d6d-a378-dc23fdf11cc3', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '8319a70e-b086-495c-92e9-40b5e1f268f0');
INSERT INTO `userrole_menu` VALUES ('e25d5d9c-0de9-4c96-beef-03efdf600efa', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '4a857bdf-599b-4ac4-9238-69202a8a0848');
INSERT INTO `userrole_menu` VALUES ('e3acd77f-ecb2-495e-a47e-d8860979ff7f', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'ab37b18b-aaf1-4ba0-9bcc-3141a843004b');
INSERT INTO `userrole_menu` VALUES ('e3e7ce6d-88ea-4be8-8579-e6a15621230a', null, null, '2013-09-04 11:16:47', '0', '1', '7a9463c6-3b04-4e5e-bff3-e259bf159408');
INSERT INTO `userrole_menu` VALUES ('e47f8915-f6b3-43a7-9ada-f19e1f439ac8', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'f131072b-c1a3-409c-8194-0fb2cca1c079');
INSERT INTO `userrole_menu` VALUES ('e4d555c9-03e1-4fc9-b517-be3782709f0e', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '26b771e5-8d2d-487a-ae17-9a46f3699e4f');
INSERT INTO `userrole_menu` VALUES ('e591528c-0186-497b-a2bf-c7c1868815cb', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '9b6e1447-a682-4f69-8f15-b40febbf83e2');
INSERT INTO `userrole_menu` VALUES ('e74c22ca-ace5-4dfe-96eb-e5aadea9cdbc', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('e7f0c5f8-4650-4b2f-94c2-363810312dda', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'a02ea23d-cebd-4385-b0fb-5850a84673f6');
INSERT INTO `userrole_menu` VALUES ('e92cb731-8c9a-4ecc-81ee-dfd47b612de8', null, null, '2013-09-26 12:09:31', '0', '1', '5f2e3e8a-1d5b-4af1-991c-f137b5b7885c');
INSERT INTO `userrole_menu` VALUES ('e96125aa-6cf9-4802-8b5f-e490e3282143', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '17af738f-3596-40ac-8c8f-a0d02faa288f');
INSERT INTO `userrole_menu` VALUES ('e99b441b-46fd-4601-8d42-9ddb04874b66', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', 'c1ba6525-8728-490a-a564-5b8e4cc2db06');
INSERT INTO `userrole_menu` VALUES ('ecb3657e-0de6-4629-ad33-a53768bf4003', null, null, '2013-10-07 05:11:31', '0', '1', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('edd7df18-8ae0-45de-b770-4946a7d02105', null, null, '2014-01-15 14:59:40', '0', '1', '77436526-c889-4e8c-af47-dd592902b909');
INSERT INTO `userrole_menu` VALUES ('ee5a3ab5-765c-4a8b-8a42-f0f41102854a', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('ef451f70-17b3-4eeb-8aa3-ee23cb8586a5', null, null, '2014-03-15 09:21:18', '0', '1d8f8841-7fc7-4dc5-aae6-5f6c990e7a3d', '152108b4-116d-4b74-af37-da5de840db58');
INSERT INTO `userrole_menu` VALUES ('efb1c21d-3349-4c2b-9755-e62c4910b612', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', '44e42e04-9584-4ff4-9eba-9a78a7c4f4cc');
INSERT INTO `userrole_menu` VALUES ('efcb5d4a-202d-4890-8518-a73008415b61', null, null, '2013-10-07 05:11:31', '0', 'db1a87e5-3d0a-460f-bde1-a795e320fb2f', 'c70953cd-ebd7-4747-a39f-6a32da5a2996');
INSERT INTO `userrole_menu` VALUES ('efcc1aa8-2687-46ba-8828-f8a9c6722339', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '45e61997-2dbc-461a-b987-1b9ffedc03f4');
INSERT INTO `userrole_menu` VALUES ('f06cdb32-194b-4fad-a16c-7e354712d44f', null, null, '2013-09-15 10:31:36', '0', '1', 'afcb1599-9d05-42fa-9598-23211052782a');
INSERT INTO `userrole_menu` VALUES ('f3dec597-a620-4432-aaea-8c0e7a458389', null, null, '2013-12-07 15:57:56', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '8dd28715-294f-467f-a6e8-943b98b52d31');
INSERT INTO `userrole_menu` VALUES ('f4385169-7a8f-4947-b3ad-0ce14869849a', null, null, '2013-12-07 15:57:57', '0', '574d2f5e-953e-4212-b1ed-868548215d63', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('f43e8e0d-dfd6-4490-a0dc-9f28eb92083f', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', 'dca3df88-f5f5-47b0-9f7f-2193f130a627');
INSERT INTO `userrole_menu` VALUES ('f5486c8c-7c90-4c1c-822c-4b9ca6acb0b7', null, null, '2014-03-20 11:29:22', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', '8319a70e-b086-495c-92e9-40b5e1f268f0');
INSERT INTO `userrole_menu` VALUES ('f54d02e5-bc06-4c8e-bde2-32a526f929be', null, null, '2013-11-30 09:52:30', '0', '205d3737-6eff-4b2f-9851-c7e7aeef9da1', '7e598218-8c88-4ded-a046-0941421c1d63');
INSERT INTO `userrole_menu` VALUES ('f5ba7a14-3403-4419-8206-f2084ede1bde', null, null, '2013-09-16 21:51:54', '0', '1', '1a88ccf8-5227-453e-bd5a-59e26165cd1b');
INSERT INTO `userrole_menu` VALUES ('f75f26dc-6f25-4432-bb50-0877ac92562b', null, null, '2014-01-14 20:20:42', '0', '1', '4a857bdf-599b-4ac4-9238-69202a8a0848');
INSERT INTO `userrole_menu` VALUES ('f99718ec-73d0-42cc-9cf8-3f231c9a81a2', null, null, '2014-02-10 08:54:49', '0', '6dda0409-1512-4d2f-9849-6d327a3f7e19', '9b6e1447-a682-4f69-8f15-b40febbf83e2');
INSERT INTO `userrole_menu` VALUES ('fdc6cbb6-1665-47db-827c-451d90f4a4ff', null, null, '2014-03-20 11:35:23', '0', 'bdb086fa-8a7f-4cf6-9194-a8e03bef7b3e', 'a898288b-9415-49a6-8ca0-5ac6293b6e75');

-- ----------------------------
-- Table structure for verifybusiness
-- ----------------------------
DROP TABLE IF EXISTS `verifybusiness`;
CREATE TABLE `verifybusiness` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `verify` int(8) NOT NULL default '0' COMMENT '0，未审核；1，审核通过。',
  `userId` varchar(36) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `idCard` varchar(36) NOT NULL COMMENT '身份证号码',
  `imageBusinessLicense` varchar(200) NOT NULL COMMENT '营业执照图片',
  `imagePoliceProve` varchar(200) NOT NULL COMMENT '公安备案图片',
  `content` text COMMENT '介绍',
  `imageIdCard` varchar(200) default NULL COMMENT '身份证图片',
  `companyName` varchar(36) default NULL,
  `companyAddress` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verifybusiness
-- ----------------------------
INSERT INTO `verifybusiness` VALUES ('4156c618-7d8f-4e01-ab29-9cd17104240a', '谭水龙', null, '2015-01-11 22:45:30', '1', 'e0e0643a-93a8-4a1c-a41d-43f4a6f01a3e', '13970089440', '360122198406038400', 'e37a04a1c4c0438aa8d4da5280502568.jpg', '01a1a4cd199542a38a100e8f96eb2637.jpg', '', 'a772594825db4fe4a4c586f6bb05bfde.jpg', '0791锁业', '江西南昌');
INSERT INTO `verifybusiness` VALUES ('71f0494e-ccd0-48e8-bdfe-7a649f1bf843', '许园', null, '2015-01-23 14:12:18', '1', '313ccb37-eb79-48a1-b7f4-fa8e7eee43b2', '15807006977', '362330199203109060', '9af1af2ec1ae434f8c41eb072180cfac.jpg', '7628a102cb134a6389a28006b328c158.jpg', '', 'f5d20173f2224f70abb83642aa7e9f1b.jpg', '南昌万山科技', '南昌市红谷滩区鼎峰中央');
INSERT INTO `verifybusiness` VALUES ('b365dc4e-e52a-4875-908b-3a29587dfa98', '', '', '2014-08-27 09:33:20', '1', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '12312312311', '123123123123123120', 'e8058305df0848aaab7b6052e1f5fee4.jpg', 'b4750190f3004b0ab755320c588e61df.jpg', '我要睡觉', '', '', '');

-- ----------------------------
-- Table structure for viewhistory
-- ----------------------------
DROP TABLE IF EXISTS `viewhistory`;
CREATE TABLE `viewhistory` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `status` int(11) default '0',
  `userId` varchar(36) default NULL,
  `newsId` varchar(36) default NULL,
  `viewTime` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of viewhistory
-- ----------------------------
INSERT INTO `viewhistory` VALUES ('01ec64b7-025a-4b25-9c7b-c18577ed077f', null, null, '2014-08-01 17:13:35', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('020d4379-a8c7-45a2-bf29-2c7c41d2673d', null, null, '2014-08-01 13:22:52', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('02a9a76c-98dd-4070-8d98-109d72c68792', null, null, '2015-01-16 21:58:54', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('03f75df8-e5f8-4822-b165-ddcc7f19eede', null, null, '2015-01-04 09:56:08', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('0450ead5-9f02-41e5-a7cc-b75a5a18dac5', null, null, '2015-01-16 21:56:38', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('0483aab8-a851-455d-af72-5489cb84356c', null, null, '2014-08-27 11:48:03', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('07c7fdb8-ced5-4b00-8486-d73f557fd170', null, null, '2014-08-17 10:49:45', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('07cc357d-1c12-4a7f-86bc-d5d92a26713e', null, null, '2014-12-21 10:09:12', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('08d4bec5-4308-440c-91ab-7cfb7d88ffb5', null, null, '2014-08-28 09:45:42', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('08df69f1-afda-4d84-980d-6b481565c30e', null, null, '2014-07-31 14:27:15', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('099f82b2-32bf-4304-bfbf-fd539d3c242d', null, null, '2015-01-16 21:58:43', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('0b8a8d9e-0f21-4e30-86a2-5a5ecd433454', null, null, '2014-08-03 17:29:34', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('0dd80514-9b02-4423-b84d-629172537ae2', null, null, '2014-08-03 18:57:49', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('10ee8601-1e90-488b-a96f-5e63a92396fb', null, null, '2014-08-17 10:49:36', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('124014d1-527b-49b1-9cb3-c445283b9ea8', null, null, '2014-09-09 16:57:12', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('1258002a-7508-41f9-a5ec-0b06a5086355', null, null, '2014-09-10 10:03:38', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('12885838-1cc3-4486-8770-194088af0b05', null, null, '2014-08-02 10:37:13', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('1390171f-368b-4732-97a3-b37ff105d019', null, null, '2014-10-01 18:15:11', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('13b5e4c6-cc2a-46ed-9fef-6ea5770ac0d8', null, null, '2014-09-09 16:38:43', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('13d047d2-e263-4441-ac29-4ec889b2f1cd', null, null, '2014-08-25 14:42:37', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('14c91729-fa71-422c-9098-3e598227c0e7', null, null, '2014-12-26 16:57:54', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('14d73e16-d8e0-44c0-9340-0945849fdece', null, null, '2015-01-07 17:42:31', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('19464e96-d1a9-4707-8d9e-7a88f5a7aa1f', null, null, '2014-08-27 11:49:59', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('19d67acd-b10d-4139-882a-4fc643554879', null, null, '2014-08-01 15:46:44', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('1a10a208-3258-49a4-8c50-c57c6391a93f', null, null, '2014-09-13 11:55:44', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('1ea71946-9fee-467f-bb00-3ad9bf91fb13', null, null, '2014-08-01 15:58:23', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('1fa32f1b-14e5-4aea-a76e-e123561a127c', null, null, '2014-08-18 09:23:32', '0', '', '1193ed59-4b94-4448-9e56-7c0fb748c6a8', null);
INSERT INTO `viewhistory` VALUES ('2040964b-7f88-4857-af0a-24a1ee3d92e8', null, null, '2014-08-01 14:15:36', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('21709921-0d11-454e-b48a-7bf48161c060', null, null, '2015-01-21 23:36:52', '0', '1402ff5a-028d-40db-bef5-a309eff55dec', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('232f8896-ce7d-4b9a-8230-ab5572250c61', null, null, '2014-08-01 14:11:26', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('23d95b3a-541b-4737-8bac-fa3f7cf62b58', null, null, '2014-08-01 14:07:30', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('23e9db72-78d1-4454-8630-6ac80fdb4ab2', null, null, '2015-01-09 17:46:01', '0', '', '26', null);
INSERT INTO `viewhistory` VALUES ('284ef602-2acd-4fdd-a6b7-0c575300c860', null, null, '2014-08-01 17:40:13', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('28a238ec-5a4e-47e2-9e06-5581564c6656', null, null, '2014-08-28 09:12:37', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('28c088d1-ac4a-4562-9f14-231a2f50e732', null, null, '2015-01-16 21:56:27', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('290c644d-6229-4233-8ce7-0e0adcbd37aa', null, null, '2014-08-03 17:29:30', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('2a0f4c4e-da9d-4753-a7fb-4341137e5854', null, null, '2015-01-16 21:58:45', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('2b211b29-803d-4fef-aa1e-95334b75548a', null, null, '2014-10-18 12:56:15', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('2bc7f3d1-e457-425e-b32a-b7bc49cfb5ca', null, null, '2015-01-16 21:58:22', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('2bc94d50-57b5-48ba-ae05-2b45321e34bb', null, null, '2014-12-26 22:16:02', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('2dcc0174-9db9-4fed-bbd7-9b1bf4d698a4', null, null, '2014-09-09 16:42:40', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('2e4a8e1c-a9de-4e90-ada5-432a917d4f0b', null, null, '2014-10-20 17:32:54', '0', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('30bdb05b-4816-444f-96d4-78849b7feb8b', null, null, '2014-08-02 21:11:05', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('3215c80a-186d-412d-985f-e04284ed9f3f', null, null, '2015-01-12 14:41:51', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('32a88baa-942a-49a1-85f1-2d5348d86a15', null, null, '2015-01-16 21:55:12', '0', '\'\"><scRipt>alert(98733)</sCript>', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('332c2a79-bdc6-4546-9fe4-cb829a27a402', null, null, '2014-09-13 11:56:00', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('347fdc6b-b71c-4175-8190-9c81c92b9d88', null, null, '2014-08-18 09:23:38', '0', '', '25dd1ba4-b64b-4bc9-af8c-3d4fdd530897', null);
INSERT INTO `viewhistory` VALUES ('358f908d-7c07-43f1-8b82-393663674b4c', null, null, '2015-01-21 16:45:51', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('365e0536-2f7e-49dc-bc62-a78f631b1693', null, null, '2015-01-10 17:24:17', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('3db15c88-389d-4c78-91b5-f1c763988c18', null, null, '2015-01-16 21:58:25', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('3dddcc17-9136-46ce-8079-9895296536a2', null, null, '2014-08-05 11:16:48', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('3f5715b2-383c-44e4-8eb5-bbd67bd376de', null, null, '2014-08-01 15:49:30', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('40d71e6f-80f7-4757-b925-53704938b18b', null, null, '2014-08-01 13:36:25', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('426359f8-7863-4e95-9bc6-d3b6afd0f592', null, null, '2014-12-21 10:08:49', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('442117a5-fe8a-4c04-9a8d-0e6d278fcdb0', null, null, '2014-08-28 09:45:24', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('4466594f-320c-4e86-82c0-0c08fc6f7c49', null, null, '2015-01-21 23:37:09', '0', '1402ff5a-028d-40db-bef5-a309eff55dec', '28', null);
INSERT INTO `viewhistory` VALUES ('45c14b9f-c7b6-43d8-90f3-9ee7cacdc6e6', null, null, '2014-08-01 12:48:45', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('46713f1e-b412-453a-9060-2912a002047e', null, null, '2014-09-09 16:59:22', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('47c5d6d1-cf82-4795-81d3-2d6e36e9b926', null, null, '2015-01-12 14:40:45', '0', '', '28', null);
INSERT INTO `viewhistory` VALUES ('49095fad-9130-46c5-9096-b71b90df5db6', null, null, '2015-01-16 21:56:25', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('49872045-894b-4e57-acd5-e6ff95830ccb', null, null, '2015-01-16 21:58:02', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('49d07cee-a9e5-4d48-8843-ffd67574e2ef', null, null, '2015-01-16 21:56:35', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('4c21e70f-583d-4f26-b4c1-7241c94201cc', null, null, '2014-07-31 10:40:15', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('4c74fa1b-9de4-47be-bef9-b2f50f23ed4e', null, null, '2014-09-13 10:59:29', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('4caf413c-a5af-4ccd-8312-62dda3461fb5', null, null, '2014-07-30 16:19:39', '0', '7885e0fd-8ae7-4d4a-b136-523a2e4cca8d', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('4d01ff62-8059-4e31-b0b6-e01db70bd63e', null, null, '2014-08-01 13:40:34', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('4e9073c8-ce9d-458a-8c7e-ccfd47b46d75', null, null, '2014-10-01 18:16:02', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('5228882a-2ffb-41ff-a0da-141de0728958', null, null, '2014-08-02 09:39:01', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('52e3e77f-7458-4e01-b3ea-a59c27b904f8', null, null, '2014-09-10 10:36:55', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('52eb054f-3e45-45c3-86c9-daab96903930', null, null, '2014-08-04 23:52:36', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('56efa98c-221f-460c-9204-8ec2abed4fb4', null, null, '2014-09-09 17:08:02', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('5afc2115-76eb-4ebf-81b1-ea88b2295dd8', null, null, '2014-09-13 10:58:51', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('5c0120b0-c8b3-43d6-88cf-410f387cdc41', null, null, '2014-08-03 18:57:33', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('5f2b7152-ab5f-4634-b1c7-253d66bc7c6b', null, null, '2014-10-15 15:49:49', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('5f47bf02-233c-4a93-803c-79f9f6f682b0', null, null, '2014-12-21 11:11:48', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('60463380-35cf-4610-a73b-17e2fbc8e5db', null, null, '2014-12-21 12:11:14', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('61151d9c-9964-4278-898b-8b8bbfa82818', null, null, '2015-01-16 21:55:20', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('61a403e9-b57c-408e-ac33-02cd6a450449', null, null, '2014-12-20 07:46:05', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('61a55fff-3db9-4adb-a21c-dbcb9dec7c28', null, null, '2014-09-13 16:08:58', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('6267cc7c-b0c5-4890-820b-548a9f29cf56', null, null, '2014-09-13 11:52:42', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('63057150-551a-4b28-a211-a1af31c56098', null, null, '2015-01-16 21:55:14', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('64395fb2-1025-4b99-92c7-f736ee5109b8', null, null, '2014-08-27 11:45:18', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('65244b6f-331a-4ace-8d4d-6f92f67e846c', null, null, '2014-08-01 17:42:06', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('6572ad57-4177-4dd2-a277-afb28fd37575', null, null, '2014-08-01 13:56:33', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('65f7c514-c243-464e-a264-755f489fff49', null, null, '2014-08-28 09:45:00', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('663ce81e-91dd-49e5-9246-4f11a5d3aeb1', null, null, '2014-12-21 15:40:34', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('668c2997-da02-4ec9-832f-da74ffe41308', null, null, '2014-08-01 13:56:39', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('668db236-b99a-4f9e-83ff-979183fc3fd1', null, null, '2014-08-02 09:39:04', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('679d777c-7086-43e3-a3ae-b6dd8316503b', null, null, '2014-09-06 17:13:31', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'd93982c8-a39c-41db-9642-73c281a1b58d', null);
INSERT INTO `viewhistory` VALUES ('689bf31d-3fbc-428f-88bc-9306d01c9859', null, null, '2014-07-31 10:34:21', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('6a15fb03-b6d1-45d7-a15b-032dfbb6952f', null, null, '2014-09-13 11:54:33', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('6a7d552c-ac5b-453e-aebe-9421037a1098', null, null, '2014-08-03 17:34:07', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('6ab686fb-dff9-44f5-bd5f-a769db39d7cb', null, null, '2014-09-13 11:41:08', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('6fc4ec14-f04c-4362-8b7e-4b251c02a596', null, null, '2014-08-04 23:53:06', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('6fee50be-673b-4501-ac06-a8ed1895513c', null, null, '2014-12-21 14:27:22', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('6ff225f0-c683-49a3-a934-36a960915856', null, null, '2014-08-03 17:29:52', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('70511199-9401-4f1e-8e1d-be91cc2e1efe', null, null, '2014-12-21 16:38:17', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('74f69aa0-cd32-4266-a114-787ca013621d', null, null, '2014-08-01 17:11:51', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('7589444d-2dd5-4f24-86e2-7a59a75a0190', null, null, '2014-07-30 16:14:34', '0', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('7597f86f-4b8d-45fd-a137-c6a6f57029c1', null, null, '2014-08-01 13:56:44', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('75e9b6ba-837a-459b-afe7-920b989a56cd', null, null, '2015-01-16 21:56:41', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('75ed4a5e-7dcd-4a9f-8474-06ad36e9bf6e', null, null, '2014-09-13 11:53:42', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('76f2cef2-6d30-4529-b0b5-c2459a19594e', null, null, '2015-01-16 21:58:49', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('7a122f57-7b47-48e4-830a-a51bf202c4f9', null, null, '2014-09-06 17:21:45', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'd93982c8-a39c-41db-9642-73c281a1b58d', null);
INSERT INTO `viewhistory` VALUES ('7a90390e-6bc1-4ad7-bc10-17f294a536fe', null, null, '2015-01-21 16:38:35', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('7b238e95-224b-4732-9807-6dcc2ccc44c1', null, null, '2014-08-28 09:55:35', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('7d9d5a95-002a-4df7-8861-ea159b16cf9d', null, null, '2014-09-13 11:06:53', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('823eb7e2-b51c-484b-ad61-cb927cacb685', null, null, '2014-08-01 14:06:40', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('8340da29-f27c-404d-a00a-e9851402f336', null, null, '2014-08-04 23:45:58', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('85df3478-b916-4289-a790-ce59ea8a6490', null, null, '2014-09-13 11:26:03', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('86f047e7-d452-4cc8-aaf9-45f828e26aa7', null, null, '2014-09-10 11:09:50', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('87012c8c-ec00-4333-8153-53ba1bfb5c1e', null, null, '2015-01-21 21:25:39', '0', '', '758fce71-cd22-4cec-8cd1-f329f6ae7dd3', null);
INSERT INTO `viewhistory` VALUES ('88f5ce21-057f-4059-a3a0-4d23b303b25d', null, null, '2014-09-13 11:46:16', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('8b05d7f2-3535-46e4-81e8-0da229198045', null, null, '2014-08-01 13:56:24', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('8b711d26-8dd6-4777-8d42-3ea070976cda', null, null, '2014-08-28 09:57:50', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'd93982c8-a39c-41db-9642-73c281a1b58d', null);
INSERT INTO `viewhistory` VALUES ('8b9f9693-3548-40af-b2a2-b8eecea20429', null, null, '2015-01-16 21:56:18', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('8cc8e4ae-d28f-455c-85ec-f4c543f7f69a', null, null, '2014-09-10 10:41:12', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('8ce61c24-c1e3-47c6-b1b1-aec6a38711b8', null, null, '2015-01-16 21:58:08', '0', '../../../../../../../../etc/passwd', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('8d1e0093-6b00-4981-b2a6-13f8944add19', null, null, '2015-01-16 21:57:58', '0', '/etc/passwd', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('8d49fd1f-ac34-4656-8248-b158be3abae5', null, null, '2015-01-16 21:58:05', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('8f3c06ab-c6e0-45ed-a0ca-370b99cabd22', null, null, '2014-08-01 14:02:48', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('8fb8095f-04b8-455f-9a4c-a11f5f6a64bf', null, null, '2015-01-21 16:38:28', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', '758fce71-cd22-4cec-8cd1-f329f6ae7dd3', null);
INSERT INTO `viewhistory` VALUES ('904f2e14-5c97-44ba-98ea-ecd21d062518', null, null, '2015-01-21 16:38:25', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', '758fce71-cd22-4cec-8cd1-f329f6ae7dd3', null);
INSERT INTO `viewhistory` VALUES ('940609f8-850e-4a23-bde7-019ebe507984', null, null, '2014-09-13 12:02:57', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('96d7f1e1-a52f-47d4-b492-3b172ac547e0', null, null, '2015-01-21 16:40:15', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', '25', null);
INSERT INTO `viewhistory` VALUES ('97d43aac-3eee-42c7-8b9a-0885eccd4dd0', null, null, '2015-01-21 16:40:30', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('987296f7-e966-4541-a160-6805cf9b608d', null, null, '2014-08-01 14:09:57', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('9908f8da-042f-4dbe-949b-f3cc48d92b91', null, null, '2014-12-21 10:06:54', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('9940d620-a95d-4073-acc0-2b375999b45e', null, null, '2014-09-13 11:11:51', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('99b5f497-392d-4ff5-93fb-9f7c388c97be', null, null, '2014-08-18 09:22:01', '0', '', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('9fef1b8b-8a13-4f56-9282-78ced01749a6', null, null, '2014-08-28 09:32:13', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('a0a334cc-70bc-413a-bfff-8c7b5b9da169', null, null, '2014-08-01 17:13:53', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('a155c76b-1b51-4ea9-81cd-ece4c7e99d94', null, null, '2014-09-09 15:40:17', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('a19472a8-79a1-45a8-9680-7cc0387c76b6', null, null, '2014-09-23 19:31:07', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('a1ef4fb5-8b83-4461-b15c-2484d6a8e06e', null, null, '2015-01-16 21:58:28', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('a26a8a4d-270e-4ea0-9ee6-9ad4a9a66333', null, null, '2014-08-18 09:17:58', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('a35e02a8-5b89-4680-8187-cb90e09aaa36', null, null, '2014-12-21 15:41:48', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('a42e148e-f956-49ea-8727-b12d907b1e50', null, null, '2015-01-16 21:55:18', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('a59cc374-6fff-4694-959e-5b17dc6dc2f2', null, null, '2014-12-21 14:28:12', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('a61e3a1f-432f-4e1b-a56a-867a56c43a1e', null, null, '2015-01-16 21:56:20', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('a675a1dd-800b-4a9b-a157-f2d51c26225f', null, null, '2015-01-19 15:05:12', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('a67fce8c-edd8-4aca-911a-da264a71c3af', null, null, '2014-08-18 09:17:44', '0', '', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('a729f1e2-2fc6-4a08-9dbd-653dbab19115', null, null, '2014-12-20 02:02:41', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('aa3bf414-91c1-4954-b847-fc005176f36c', null, null, '2014-08-01 09:39:42', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('ac35c972-d28e-4fa1-a5e8-3e44c46c7177', null, null, '2015-01-16 21:58:51', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('ae2eea1a-7e17-4616-ae46-c024cca9a6a5', null, null, '2014-08-01 13:55:40', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('ae933bd8-2438-4bc1-8682-7a92d01ee5f7', null, null, '2014-07-31 14:27:21', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('afbaf609-4e88-4b09-9b9d-732711f9ee30', null, null, '2014-09-07 14:15:37', '0', '561d6c90-a7df-4253-bdc4-058408b941be', '24d3303d-bf8d-4c1b-9d01-b7e762478fa1', null);
INSERT INTO `viewhistory` VALUES ('afbfae1f-b018-45ba-bc67-602117f93b82', null, null, '2015-01-20 23:48:03', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('b06f6162-0e60-4fc0-ae27-43d33fb6df43', null, null, '2015-01-16 21:58:11', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('b1df288c-724c-451f-82f2-37bc7f13a894', null, null, '2014-09-10 10:39:13', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('b20a8faf-e63d-40a3-849c-6066e8b47fff', null, null, '2015-01-21 15:52:14', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('b24ee1f1-4846-4fc1-a1b0-7f2765ca7c78', null, null, '2014-08-18 09:23:27', '0', '', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('b37c6987-71d4-46dd-8949-cd72e4821002', null, null, '2014-09-13 12:03:10', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('b572f40a-6427-4fcc-b494-7521adae76c5', null, null, '2014-08-02 09:05:42', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('b61a2e12-227c-48c1-8855-fb811de792df', null, null, '2015-01-21 16:38:16', '0', '89c66323-1ee7-43c2-90b4-bfcd25fce4a5', '758fce71-cd22-4cec-8cd1-f329f6ae7dd3', null);
INSERT INTO `viewhistory` VALUES ('b97e1d49-ce5e-4686-9245-94e23d436b74', null, null, '2014-09-06 11:57:31', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'd93982c8-a39c-41db-9642-73c281a1b58d', null);
INSERT INTO `viewhistory` VALUES ('bae45e94-aaef-427e-9599-8803b82462db', null, null, '2015-01-16 21:58:00', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('bb9415b5-be48-46bf-982d-854579753ccb', null, null, '2014-08-28 09:29:11', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('be971575-7972-4425-a41e-0441a4a6cc2d', null, null, '2015-01-09 17:47:30', '0', '', '25', null);
INSERT INTO `viewhistory` VALUES ('bf45bbbe-0fa5-4492-b689-e2ff55cd9035', null, null, '2014-08-27 11:49:49', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('c0109a8d-0427-427a-889b-4fe495db36ea', null, null, '2014-09-13 11:53:36', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('c12de438-b7af-4728-b33a-10173aaff318', null, null, '2014-08-01 14:36:41', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('c147332b-cd46-4c7f-97f4-594d2509fe0f', null, null, '2014-08-18 09:23:20', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('c17c8158-0b51-4d1b-80c1-4886cda503d6', null, null, '2014-09-13 11:46:13', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('c4ab6175-9d35-482a-ae06-9ae084ba6f8b', null, null, '2015-01-16 21:58:19', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('c4e03cd9-bd10-4c1d-8620-dea07fab6ed8', null, null, '2014-09-10 10:15:02', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('c5bb1df7-6a19-400c-aaa1-634c2e5379bc', null, null, '2015-01-21 23:37:12', '0', '1402ff5a-028d-40db-bef5-a309eff55dec', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('c60fe313-447c-4fab-ad65-173aab79ea46', null, null, '2014-09-13 12:03:25', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('c7fcb276-9f1c-4176-8b63-4455facae648', null, null, '2014-07-31 14:27:26', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('c99cf2c5-16a8-43aa-a082-53daa7c4cd75', null, null, '2015-01-16 21:58:09', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('c9fc3474-ae8e-4116-b3c2-8ea8699133f6', null, null, '2015-01-16 21:58:41', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('ca523335-e29a-4fb8-990a-46e7c3a67034', null, null, '2014-09-10 09:59:25', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('ca63963d-9438-4dde-ac9b-1ac9f1cd237e', null, null, '2014-12-21 10:09:22', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('caf33613-91c6-42e3-ae6d-ab19f02c321e', null, null, '2014-08-04 11:20:42', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('cb59e3f6-db5a-4999-9b21-4ffc16a2760c', null, null, '2014-08-17 10:50:09', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('cdef77ec-067b-407c-8030-111d638606c7', null, null, '2014-09-13 10:59:18', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('ce390ca8-ad1d-4b32-a257-e974b2e836a0', null, null, '2014-08-01 15:37:10', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('cf93b4dd-7dd5-40ac-914c-8a3d0e24ffe2', null, null, '2014-12-21 11:56:04', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('d0d75856-1752-4127-9624-5f7c073fc801', null, null, '2014-09-09 16:57:00', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('d5098f54-c778-42d8-8a26-bb65cc93c6b2', null, null, '2014-08-01 13:20:35', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('d5ab1ed9-1154-434f-a703-a988383cc660', null, null, '2015-01-16 21:58:31', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('d6b6a15f-9800-4d32-8bdf-7424793621ae', null, null, '2014-09-10 10:36:26', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('d6ce9e8a-5e37-4d53-b341-784e6e0072ac', null, null, '2015-01-16 21:56:30', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('d7b0ab22-9476-4cd2-bfbf-6b2a54b20f57', null, null, '2015-01-16 21:56:16', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('d84f490f-eb35-4e1e-984d-83cfbc4d1cb9', null, null, '2015-01-16 21:58:14', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('d8a411f0-6d75-4ec1-9b1a-f8ce3c356c1b', null, null, '2014-12-21 15:41:53', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('d9b0b813-3be6-4f6b-a51b-474c7a0ab649', null, null, '2014-09-13 11:53:51', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('db0104e5-af72-407a-8b80-52855dd2133e', null, null, '2014-09-13 11:52:44', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('dc07b111-dae3-4867-9814-5bb11ab471b9', null, null, '2014-08-01 13:55:52', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('dd', null, null, '2014-07-30 17:14:05', '0', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('dde97558-7ee8-4ee4-897b-57e60a538775', null, null, '2014-08-01 13:56:27', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('dfe4fe1f-bb5a-40d7-9373-2f337dc88b8f', null, null, '2014-08-02 16:58:48', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('e0f4a6aa-eef2-47b9-8879-aa2543c657f5', null, null, '2014-09-10 10:37:48', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('e442ab6c-44dd-4ba1-9325-603f31a64b73', null, null, '2014-10-15 15:51:02', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('e488d176-e54d-47b7-9e47-41e7ece8bd08', null, null, '2014-08-27 11:52:53', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('e4ef157c-4c8b-41af-b4be-4430cfbbaba0', null, null, '2014-12-20 02:02:48', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('e671786c-41e1-4782-8c9f-fcabd8238171', null, null, '2014-08-04 13:05:32', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('e6e5aade-667a-45b9-b6f2-842f0910d90b', null, null, '2014-09-13 12:03:01', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('e6fbca7f-c94e-4ff1-8924-f77ae71c016b', null, null, '2015-01-16 21:58:35', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('e7b2c2d7-7777-4750-bbe2-9d6a6043dcde', null, null, '2014-08-01 12:45:02', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('e8ab856d-21cd-4ea8-9cd3-a5472a0e3e7f', null, null, '2014-08-01 13:55:01', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('e95de5e6-5b4a-4e56-956e-e1e54f1fd053', null, null, '2014-09-13 11:52:32', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133s', null);
INSERT INTO `viewhistory` VALUES ('eb30ac8e-dc1b-4f98-b18e-072bbc9a23f4', null, null, '2014-09-06 17:14:58', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'd93982c8-a39c-41db-9642-73c281a1b58d', null);
INSERT INTO `viewhistory` VALUES ('eca19918-1a16-4a65-a016-84e39efa719d', null, null, '2014-08-01 14:03:08', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('ed5d2f14-f673-40fa-9c79-b0398a02361e', null, null, '2014-08-01 17:40:26', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('f57165a8-b5eb-48cb-9ac2-af8be6162584', null, null, '2014-08-01 13:29:04', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('f5bdec4c-3084-4a15-ab50-8529edcc61e9', null, null, '2014-09-06 11:24:00', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', 'd93982c8-a39c-41db-9642-73c281a1b58d', null);
INSERT INTO `viewhistory` VALUES ('f775ddc5-fd64-451d-9286-990f83fdba2a', null, null, '2014-08-01 14:09:14', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('f87eb9b4-31b3-46b9-b4b5-f8b3d72035ac', null, null, '2014-09-09 16:39:34', '0', '', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('fa9e1b2c-e2d9-4873-b9f7-ca9d8c8e44e0', null, null, '2014-07-31 10:40:09', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('fb2c3e26-e701-4361-8670-91987c7221ce', null, null, '2014-08-02 16:58:43', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('fc5851ba-f139-47d3-8b48-811f4b0edc5e', null, null, '2014-08-02 09:38:52', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', 'f3969c8c-97e0-473d-9be0-4d1fb9d2bfe7', null);
INSERT INTO `viewhistory` VALUES ('fc6091df-325c-4d0f-82a2-5e38a2fec20d', null, null, '2014-09-13 11:57:37', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('fccdb928-cf73-48ed-b6f0-5e88f30040ce', null, null, '2014-08-01 13:55:08', '0', '', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('fd03ab4e-84fc-4f49-b5a9-1f4287ff6082', null, null, '2014-08-28 09:05:04', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('fd8c84ea-9880-41da-b125-ce0022f970f9', null, null, '2014-09-10 10:15:34', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('ff69d593-aecf-4c31-9933-f391971196bb', null, null, '2014-09-13 11:59:03', '0', '4a3b0049-2c3b-43d7-94c6-102dc779fa16', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('ff7df620-ccda-47c5-aa68-be2a0206bc0c', null, null, '2015-01-16 21:57:02', '0', '', 'd079847e-21f5-4671-bb4c-ebc1c741e835', null);
INSERT INTO `viewhistory` VALUES ('ffc2a177-35ba-4e98-9aae-2764f64f0693', null, null, '2015-01-07 17:47:01', '0', '', 'b84850b0-494a-4de7-8552-89a939b4a0ae', null);
INSERT INTO `viewhistory` VALUES ('ffdc5a20-c130-42d1-823a-70943b54136e', null, null, '2014-08-01 14:36:37', '0', 'f61f4360-4092-48e5-9066-9684934c65b1', '31ad0d72-da34-4a03-8212-da4e13ca48f2', null);
INSERT INTO `viewhistory` VALUES ('q', null, null, '2014-07-30 17:10:18', '0', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);
INSERT INTO `viewhistory` VALUES ('s', null, null, '2014-07-30 17:11:00', '0', 'e2832b54-17e7-4406-ba2a-62af7a7b3385', '9df963ca-b4b7-47d8-b249-7fc40d66133a', null);

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `endtime` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT 'vip结束时间(按需求是开通一年时间)',
  `userId` varchar(36) NOT NULL,
  `status` int(11) NOT NULL default '1' COMMENT '状态:1，表示会员没过期；0，表示会员已过期。',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='vip会员表';

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', null, null, '2015-01-14 15:47:31', '2015-01-14 15:29:22', '123', '1');
INSERT INTO `vip` VALUES ('2', null, null, '2014-09-23 17:49:06', '2015-03-12 17:52:51', 'b78e8b2e-420a-4b98-92c6-17a927dfd120', '1');
INSERT INTO `vip` VALUES ('29166505-260a-4f2b-984c-2660d82f4708', null, null, '2015-01-15 10:04:31', '2016-01-16 08:00:00', 's', '1');
INSERT INTO `vip` VALUES ('3e59671e-9cea-4122-8a45-fc681e8eee2e', null, null, '2015-01-15 11:28:02', '2016-01-16 08:00:00', 'abc', '1');

-- ----------------------------
-- Table structure for withdraw
-- ----------------------------
DROP TABLE IF EXISTS `withdraw`;
CREATE TABLE `withdraw` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) default NULL,
  `comment` text,
  `createtime` timestamp NULL default NULL,
  `applyTime` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '提现日期',
  `operationTime` timestamp NULL default NULL COMMENT '管理员审核日期',
  `businessId` varchar(36) NOT NULL,
  `amount` double(255,0) NOT NULL COMMENT '申请提现金额',
  `alipayAccount` varchar(45) NOT NULL COMMENT '申请人支付宝账户',
  `accountName` varchar(36) NOT NULL COMMENT '申请人账户户名',
  `status` int(255) NOT NULL default '0' COMMENT '1未审核，2审核通过，-1审核拒绝',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of withdraw
-- ----------------------------
INSERT INTO `withdraw` VALUES ('111', '', '', '2014-10-09 10:36:44', '2014-10-09 10:36:44', '2014-10-18 10:37:55', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '31', '110', '小明', '1');
INSERT INTO `withdraw` VALUES ('32415dsafgf', '', '', '2014-09-16 10:23:09', '2014-09-16 10:23:09', '2014-10-17 10:23:26', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '30', '110', '小明', '1');
INSERT INTO `withdraw` VALUES ('733758d8-9aca-4812-84d5-9abcc097a7c5', '', '', '2014-10-27 15:34:51', '2014-10-27 15:34:51', '0000-00-00 00:00:00', '31ad0d72-da34-4a03-8212-da4e13ca48f2', '33', '111', '111', '1');
INSERT INTO `withdraw` VALUES ('fdsagrew', '', '', '2014-09-16 10:24:10', '2014-09-16 10:24:10', '0000-00-00 00:00:00', 'c1a0c3e3-3b33-4935-a511-d16590b0f23d', '20', '119', '小a', '-1');
