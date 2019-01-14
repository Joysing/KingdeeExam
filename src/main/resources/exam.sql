/*
Navicat MySQL Data Transfer

Source Server         : CDB
Source Server Version : 50628
Source Host           : 5828484357b83.gz.cdb.myqcloud.com:14259
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-12-30 20:36:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options` (
  `options_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `op` varchar(10) NOT NULL COMMENT '选项',
  `content` text NOT NULL COMMENT '选项内容',
  `question_bank_id` int(11) NOT NULL,
  PRIMARY KEY (`options_id`)
) ENGINE=InnoDB AUTO_INCREMENT=371 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of options
-- ----------------------------
INSERT INTO `options` VALUES ('222', 'A', 'MDZZ', '69');
INSERT INTO `options` VALUES ('223', 'B', 'MDZZ', '69');
INSERT INTO `options` VALUES ('224', 'C', 'MDZZ', '69');
INSERT INTO `options` VALUES ('225', 'D', 'fdsf', '69');
INSERT INTO `options` VALUES ('226', 'A', '765', '70');
INSERT INTO `options` VALUES ('227', 'B', '765', '70');
INSERT INTO `options` VALUES ('228', 'C', '765', '70');
INSERT INTO `options` VALUES ('229', 'D', '765', '70');
INSERT INTO `options` VALUES ('230', 'A', '765', '71');
INSERT INTO `options` VALUES ('231', 'B', '765', '71');
INSERT INTO `options` VALUES ('232', 'C', '765', '71');
INSERT INTO `options` VALUES ('233', 'D', '765', '71');
INSERT INTO `options` VALUES ('234', 'A', '方法', '75');
INSERT INTO `options` VALUES ('235', 'B', '犯得上', '75');
INSERT INTO `options` VALUES ('236', 'C', '犯得上', '75');
INSERT INTO `options` VALUES ('237', 'D', '犯得上', '75');
INSERT INTO `options` VALUES ('238', 'A', '方法', '76');
INSERT INTO `options` VALUES ('239', 'B', '犯得上', '76');
INSERT INTO `options` VALUES ('240', 'C', '犯得上', '76');
INSERT INTO `options` VALUES ('241', 'D', '犯得上', '76');
INSERT INTO `options` VALUES ('242', 'A', '犯得上犯得上犯得上犯得上', '77');
INSERT INTO `options` VALUES ('243', 'B', '犯得上犯得上f', '77');
INSERT INTO `options` VALUES ('244', 'C', '犯得上犯得上', '77');
INSERT INTO `options` VALUES ('245', 'D', '但是犯得上阿飞', '77');
INSERT INTO `options` VALUES ('246', 'A', '432', '78');
INSERT INTO `options` VALUES ('247', 'B', '432', '78');
INSERT INTO `options` VALUES ('248', 'C', '432', '78');
INSERT INTO `options` VALUES ('249', 'D', '432', '78');
INSERT INTO `options` VALUES ('250', 'A', '范德萨', '79');
INSERT INTO `options` VALUES ('251', 'B', '范德萨', '79');
INSERT INTO `options` VALUES ('252', 'C', '犯得上啊', '79');
INSERT INTO `options` VALUES ('253', 'D', '范德萨', '79');
INSERT INTO `options` VALUES ('254', 'A', '432', '81');
INSERT INTO `options` VALUES ('255', 'B', '432', '81');
INSERT INTO `options` VALUES ('256', 'C', '432', '81');
INSERT INTO `options` VALUES ('257', 'D', '432', '81');
INSERT INTO `options` VALUES ('258', 'A', '就是这么666', '88');
INSERT INTO `options` VALUES ('259', 'B', '就是这么666', '88');
INSERT INTO `options` VALUES ('260', 'C', '就是这么666', '88');
INSERT INTO `options` VALUES ('261', 'D', '就是这么666', '88');
INSERT INTO `options` VALUES ('262', 'A', '示范点', '92');
INSERT INTO `options` VALUES ('263', 'B', '发射点', '92');
INSERT INTO `options` VALUES ('264', 'C', '发射点', '92');
INSERT INTO `options` VALUES ('265', 'D', '犯得上', '92');
INSERT INTO `options` VALUES ('266', 'A', '安装新内核', '96');
INSERT INTO `options` VALUES ('267', 'B', '重新配置内核', '96');
INSERT INTO `options` VALUES ('268', 'C', '安装设备驱动', '96');
INSERT INTO `options` VALUES ('269', 'D', '没有办法', '96');
INSERT INTO `options` VALUES ('270', 'A', 'tar', '97');
INSERT INTO `options` VALUES ('271', 'B', 'dump', '97');
INSERT INTO `options` VALUES ('272', 'C', 'cpio', '97');
INSERT INTO `options` VALUES ('273', 'D', 'afio', '97');
INSERT INTO `options` VALUES ('274', 'A', '逻辑分区是在扩展分区中的分区', '98');
INSERT INTO `options` VALUES ('275', 'B', '逻辑分区属于扩展分区', '98');
INSERT INTO `options` VALUES ('276', 'C', '因此为了能够留出空间作为物理分区，必须先删除所有的逻辑分区然后再删除扩展分区。', '98');
INSERT INTO `options` VALUES ('277', 'D', '全部错误', '98');
INSERT INTO `options` VALUES ('278', 'A', 'xf86config', '99');
INSERT INTO `options` VALUES ('279', 'B', 'test', '99');
INSERT INTO `options` VALUES ('280', 'C', 'xinit', '99');
INSERT INTO `options` VALUES ('281', 'D', 'startx', '99');
INSERT INTO `options` VALUES ('282', 'A', 'make clean', '100');
INSERT INTO `options` VALUES ('283', 'B', 'make modules', '100');
INSERT INTO `options` VALUES ('284', 'C', 'make zlilo', '100');
INSERT INTO `options` VALUES ('285', 'D', 'make modules_instal', '100');
INSERT INTO `options` VALUES ('286', 'A', '用户账号的建立', '101');
INSERT INTO `options` VALUES ('287', 'B', '用户登录系统后相关环境的设定', '101');
INSERT INTO `options` VALUES ('288', 'C', '用户可使用资源的配置', '101');
INSERT INTO `options` VALUES ('289', 'D', '关闭计算机', '101');
INSERT INTO `options` VALUES ('290', 'A', '1', '102');
INSERT INTO `options` VALUES ('291', 'B', '2', '102');
INSERT INTO `options` VALUES ('292', 'C', '3', '102');
INSERT INTO `options` VALUES ('293', 'D', '4', '102');
INSERT INTO `options` VALUES ('294', 'A', 'Linux内核', '105');
INSERT INTO `options` VALUES ('295', 'B', 'Window内核', '105');
INSERT INTO `options` VALUES ('296', 'C', 'Linux内核+Window内核', '105');
INSERT INTO `options` VALUES ('297', 'D', 'unix内核', '105');
INSERT INTO `options` VALUES ('298', 'A', '大学', '106');
INSERT INTO `options` VALUES ('299', 'B', '大学1', '106');
INSERT INTO `options` VALUES ('300', 'C', '大学2', '106');
INSERT INTO `options` VALUES ('301', 'D', '大学3', '106');
INSERT INTO `options` VALUES ('302', 'A', 'jfk了但是', '120');
INSERT INTO `options` VALUES ('303', 'B', 'jfk了的撒', '120');
INSERT INTO `options` VALUES ('304', 'C', '附近开了多少', '120');
INSERT INTO `options` VALUES ('305', 'D', '发动机是看了', '120');
INSERT INTO `options` VALUES ('306', 'A', 'jfk了的撒', '121');
INSERT INTO `options` VALUES ('307', 'B', '肌肤抵抗力是啊jfk了但是', '121');
INSERT INTO `options` VALUES ('308', 'C', '附近看到了撒jfk了但是', '121');
INSERT INTO `options` VALUES ('309', 'D', 'jfk了的撒尽快立法的就是', '121');
INSERT INTO `options` VALUES ('310', 'A', '飞机开绿灯撒加弗兰克结果考了多少卡', '122');
INSERT INTO `options` VALUES ('311', 'B', 'jfk到拉萨解放单反了开单', '122');
INSERT INTO `options` VALUES ('312', 'C', '附近的撒范德萨咖啡难道是jfk', '122');
INSERT INTO `options` VALUES ('313', 'D', '解放路口的沙发看电视剧开发阶段开始', '122');
INSERT INTO `options` VALUES ('314', 'A', '解放立刻电视机分厘卡的就是看了', '123');
INSERT INTO `options` VALUES ('315', 'B', '将发动机撒赖咖啡碱代课老师', '123');
INSERT INTO `options` VALUES ('316', 'C', 'jfk了多少就离开房间', '123');
INSERT INTO `options` VALUES ('317', 'D', 'jfk绿豆沙浪费空间的了', '123');
INSERT INTO `options` VALUES ('318', 'A', '放假了女款的你看了发动机', '124');
INSERT INTO `options` VALUES ('319', 'B', 'jfk了单身女郎可能看老师jfk了', '124');
INSERT INTO `options` VALUES ('320', 'C', '你发的女开始就看到了放假的昆士兰', '124');
INSERT INTO `options` VALUES ('321', 'D', 'jfk绿豆沙浪费你考了多少你考虑', '124');
INSERT INTO `options` VALUES ('322', 'A', '那个时代坷拉飞机的苏联空军', '125');
INSERT INTO `options` VALUES ('323', 'B', '呢罚款单开发计划打开', '125');
INSERT INTO `options` VALUES ('324', 'C', '你付款的数据库附加的思考', '125');
INSERT INTO `options` VALUES ('325', 'D', 'jfk了的时间了咖啡进口大理石', '125');
INSERT INTO `options` VALUES ('326', 'A', '飞机开绿灯释放数据库', '126');
INSERT INTO `options` VALUES ('327', 'B', 'jfk了的沙发肯定是女', '126');
INSERT INTO `options` VALUES ('328', 'C', '减肥但是离开jfk的苏菲囧', '126');
INSERT INTO `options` VALUES ('329', 'D', '金科路附近的塑料卡积分的轮廓设计', '126');
INSERT INTO `options` VALUES ('330', 'A', '尽快立法的就是了咖啡机了看缴费接口电路设计开发', '127');
INSERT INTO `options` VALUES ('331', 'B', 'jfk角度思考浪费那肯定是你看', '127');
INSERT INTO `options` VALUES ('332', 'C', '放技能的离开少女凯撒的空间发', '127');
INSERT INTO `options` VALUES ('333', 'D', 'jfk了撒jfk冷静地思考了', '127');
INSERT INTO `options` VALUES ('334', 'A', '和jfk的是咖啡和贷款', '128');
INSERT INTO `options` VALUES ('335', 'B', '减肥撒肌肤抵抗力就是', '128');
INSERT INTO `options` VALUES ('336', 'C', '解放路口的沙发空间的数量', '128');
INSERT INTO `options` VALUES ('337', 'D', 'jfk的滥杀风口浪尖的是', '128');
INSERT INTO `options` VALUES ('338', 'A', '解放了肯定就撒开浪费大家', '129');
INSERT INTO `options` VALUES ('339', 'B', 'jfk绿豆沙快放假打算离开', '129');
INSERT INTO `options` VALUES ('340', 'C', '尽快立法当局撒开了飞机开绿灯即可点亮去了', '129');
INSERT INTO `options` VALUES ('341', 'D', '看jfk就是快乐到家阿弗莱克', '129');
INSERT INTO `options` VALUES ('342', 'A', '克己复礼但是系啊法律框架的撒开了jfk了的撒jfk亮点就是', '130');
INSERT INTO `options` VALUES ('343', 'B', '即可立即发动开了傻风口浪尖的撒快放假了', '130');
INSERT INTO `options` VALUES ('344', 'C', '接口连接方式定了卡积分电路设计高考零分', '130');
INSERT INTO `options` VALUES ('345', 'D', '尽快付款了大厦看来飞机的实力开发接口的', '130');
INSERT INTO `options` VALUES ('346', 'A', '来看看jfk了都是建立开放的角度看来是可怜见立刻jfk的', '131');
INSERT INTO `options` VALUES ('347', 'B', '进口尽快立法角度考虑是打进口发动机数据库监控', '131');
INSERT INTO `options` VALUES ('348', 'C', 'jfk了多少积分多少克拉夫角度看来是', '131');
INSERT INTO `options` VALUES ('349', 'D', '尽快立法角度来说卡jfk了的时间', '131');
INSERT INTO `options` VALUES ('350', 'A', '经费独立思考jfk了但是jfk的撒jfk绿豆沙开发jfk的斯科拉是jfk到拉萨机库里', '132');
INSERT INTO `options` VALUES ('351', 'B', '接口开发阶段是垃圾分厘卡但是jfk了的撒娇；大家分厘卡的撒娇克劳福德傻空了放假的快乐', '132');
INSERT INTO `options` VALUES ('352', 'C', '减肥的雷克萨根本不能可恶今日哦估计为哦ui热舞回家吧那就分手股份寰岛i银行i特温柔iu我', '132');
INSERT INTO `options` VALUES ('353', 'D', 'i就就发给i叽歪哦退哦你比萨的借款归还借款可交换看法迪斯科飞机打开空间撒打发回家看看结果符合当时看了', '132');
INSERT INTO `options` VALUES ('354', 'A', '两节课jfk了的沙发了肯定就仨房就打算离开', '133');
INSERT INTO `options` VALUES ('355', 'B', '空间里看到尽快立法角度思考拉法基了离开家可怜见看来', '133');
INSERT INTO `options` VALUES ('356', 'C', 'jfk了多少就发了多少链接发来看大家', '133');
INSERT INTO `options` VALUES ('357', 'D', '解放了的沙发电视科技开发阶段是理科', '133');
INSERT INTO `options` VALUES ('363', 'A', 'F', '154');
INSERT INTO `options` VALUES ('364', 'B', 'F', '154');
INSERT INTO `options` VALUES ('365', 'C', 'F', '154');
INSERT INTO `options` VALUES ('366', 'D', 'F', '154');
INSERT INTO `options` VALUES ('367', 'A', '鍐呭-op1', '5');
INSERT INTO `options` VALUES ('368', 'B', '鍐呭-op2', '5');
INSERT INTO `options` VALUES ('369', 'C', '鍐呭-op3', '5');
INSERT INTO `options` VALUES ('370', 'D', '鍐呭-op4', '5');

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank` (
  `question_bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `stem` text COMMENT '题目',
  `answer` varchar(255) DEFAULT NULL COMMENT '正确答案',
  `tests_type` int(5) DEFAULT NULL COMMENT '题目类型（判断 0或者选择 1）',
  `state` int(5) DEFAULT NULL COMMENT '状态 0 删除 1有效',
  PRIMARY KEY (`question_bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_bank
-- ----------------------------
INSERT INTO `question_bank` VALUES ('93', '使用shutdown -k命令并不真正使系统关机，而只是给用户提出警告', '1', '0', '0');
INSERT INTO `question_bank` VALUES ('94', '手工运行fsck的最好时机是在系统备份文件之后，这样在发现错误后，还可以利用备份文', '0', '0', '0');
INSERT INTO `question_bank` VALUES ('95', 'Linux 系统引导后，内核运行init程序，这个程序在处理任何其他规定的运行等级之后，在运行/etc/rc.d/rc.sysinit脚本', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('96', '如果我们需要在Linux下安装一个新的硬件设备，而这个设备在已经安装的Linux内核中并不支持，下面错误的方法是_____。', 'D', '1', '1');
INSERT INTO `question_bank` VALUES ('97', '常用的备份工具中不能直接实现备份级别，而是必须借助于其它工具才能实现的不包括：', 'D', '1', '1');
INSERT INTO `question_bank` VALUES ('98', '假设当前系统具有C. D. E. F四个分区。它们分成两类，C盘是Windows 98的主分区。D. E. F三个分区都是逻辑分区，它们都属于Windows 98的扩展分区。Windows 98的主分区和扩展分区占据了整个硬盘空间。下面说法错误的是:', 'D', '1', '1');
INSERT INTO `question_bank` VALUES ('99', '为了生成XF86Config文件，我们可以使用_________命令：', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('100', '如果在配置内核时，我们选择启用模块支持，则一般说来我们需要运行_______以在系统中编译安装合适的模块。', 'B', '1', '1');
INSERT INTO `question_bank` VALUES ('101', '系统管理员用户管理的内容，主要包括：', 'D', '1', '1');
INSERT INTO `question_bank` VALUES ('102', '1+1 = ?', 'B', '1', '1');
INSERT INTO `question_bank` VALUES ('103', 'Java 是编程语言', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('104', 'C语言是机器语言', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('105', 'Ubuntu是什么内核', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('106', '大学-小学那个是你向往的。', 'A', '1', '0');
INSERT INTO `question_bank` VALUES ('107', '硬盘分区方案内置于硬件和BIOS中，所以对硬盘重新分区后，相应的我们还需要在启动时，按键，进入Bios设置选单，修改硬盘参数。', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('108', '在使用硬链接时，我们可以使硬链接跨越不同的文件系统与另一个目录链接。', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('109', 'df命令显示各种文件和目录所使用的硬盘空间数，并且可以显示系统中最多或者最少的硬盘空间的位置。', '0', '0', '0');
INSERT INTO `question_bank` VALUES ('110', '为了 Linux，在分区时，我们至少需要分出二个区，用来安装根(/)文件系统和交换(swap)文件系统。', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('111', '在当前目录下解压归档文件this.tar.gz ，我们可以使用命令：$tar xvzf this.tar.gz', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('112', '如果有多个SCSI硬盘，/boot启动目录必须放在标识为0的SCSI硬盘上，其它SCSI标识', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('113', '对tar和cpio这些备份工具来说，必须借助于其他工具，才能实施备份级别。', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('114', '我们可以通过进程日志获得关于一个确定的进程正在干什么之类的线索。', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('115', '除root用户外，其它用户只能用kill命令终止自己的创建的进程。', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('116', '如果用户拥有目录的写许可，则该用户可以创建、删除或修改目录中的任何文件或子目录，甚至于属于其它用户的文件和子目录。', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('117', 'Linux系统上的终端口对任何人都是可写的，从而使用户可以用write命令互相发送信息。', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('118', '一般来说，具有偶数号的内核(例如0 、2 、4 ，等等)被认为是稳定的内核。', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('119', '我们一般使用mknod工具来建立分区上的文件系统', '0', '0', '1');
INSERT INTO `question_bank` VALUES ('120', '开发量；迪斯科浪费', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('121', '尽快立法的杀戮', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('122', '就考虑后果付款了好可怜的国服开了分店', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('123', '模拟结果看了放大镜看了附件是打开链接发', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('124', '吗板块轮番进攻开发力度加快功率发动机', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('125', '你们不考虑的jfk管理经费独立空间', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('126', 'i容额我就感觉考虑到房价离开', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('127', '看见了换个房间开好了个jfk了', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('128', '健康美丽和高科技了客户顾客了高考零分的', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('129', '们那边就考了高分的结果看了大家', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('130', '快乐就好国防科技了环境开放了', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('131', '附近的快速离开jfk了但是jfk两节课', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('132', '附件kids啦付款都是垃圾防空洞杀了开发接口jfk的滥杀分开的三角形轮廓发动机看来是的飞机开绿灯撒jfk的数据库来访接待室拉克飓风', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('133', 'jfk的沙发考虑的就是看了发就考了多少积分', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('134', '卡佛的是；啊卡佛骗点卡收费口独守空房了；', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('135', '分独守空房；肯定撒付款了独守空房了打开骚乱付款都是范德萨发生的', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('136', '反对思考了；刚翻开历史；啊端口封了端口是否送达范德萨反对犯得上', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('137', '付款都是开放了但是看了付款了独守空房了', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('138', '就看他如何看两个分开了回来看了购房贷款；的贵客来访待客过路费的广泛大使馆犯得上', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('139', '好多没看过劳动节快乐高空流水的开发；了都是开放的是', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('140', '开个连发的空间管理的结果考了积分抵扣个个犯得上广泛大使馆', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('141', '发kid骚风口独守空房了空间看电视啦房间看幅度萨芬大师傅', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('142', '更加开放了结果风流看到结果来看放大镜看价格付款了电视剧高考零分的就是看了估计价格付款了电视剧高考辅导老师就开了个房间都开始了来看过分但是高浮雕功夫大师', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('143', '已经热今天就考虑打个飞机离开的时间法律减肥打开拉萨解放开绿灯时间路费即可登录时间发了多少空间', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('144', '付款i都上了飞机空手道解放了可见度撒了空间范德萨会计法立刻大师傅尽量靠近当时考虑加分地方撒d\'sa', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('145', '也看镜头拉开距离达jfk绿豆沙快乐放进口袋里克劳福德急啊开始了大家分厘卡电视机啊看觉得是flak就离开的沙发犯得上范德萨', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('146', '犹太人天津港口的福建高考加分的两款价格范德萨幅度萨芬撒范德萨', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('147', '犯得上看见了附近开了就好了国服进度很快广泛大使馆反对个犯得上功夫大师', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('148', 'greg吗健康度风纪扣个链接发的快乐升级更快法国大使馆犯得上个', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('149', '退热贴记录就反过来看机房的恐惧感开发了广泛大使馆犯得上g', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('150', '广泛大锅饭的教科书结构开发的结果看了就犯得上广泛大使馆', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('151', '放到手机开发建设地块jfk绿豆沙看来飞机的系啊看来飞机都是尽快立法的杀浪费就看到了撒健康范德萨范德萨啊f\'d\'s', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('152', '认为人家看jfk角度思考jfk来的撒酒疯的时间发多少卡开了房间独立思考啊范德萨范德萨法撒旦', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('153', '好的世界观马卡罗夫的jfk冷静地思考了放假范德萨范德萨倒萨', '1', '0', '1');
INSERT INTO `question_bank` VALUES ('154', 'FFFFFF', 'A', '1', '1');
INSERT INTO `question_bank` VALUES ('155', 'Test123', 'A', '1', '0');
INSERT INTO `question_bank` VALUES ('156', '娴嬭瘯涓�涓尓', 'B', '1', '1');
INSERT INTO `question_bank` VALUES ('157', '关于逆时空理论中时空倒转的条件中光速的最大值是否为30WKM/s', '1', '0', '1');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分数ID',
  `users_id` varchar(30) DEFAULT NULL COMMENT '用户ID',
  `testpaper_id` int(11) DEFAULT NULL,
  `fraction` double(255,0) DEFAULT NULL COMMENT '分数',
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('57', '149000307', '10002', '10', null);
INSERT INTO `score` VALUES ('58', '149000307', '10001', '0', null);

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper` (
  `testpaper_id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaper_name` varchar(255) NOT NULL COMMENT '试卷名',
  `testpaper_state` int(5) NOT NULL COMMENT '试卷状态 0为无效  1为有效',
  `start_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `is_start` int(5) DEFAULT '1' COMMENT '是否开始考试 0 关闭 1开始',
  PRIMARY KEY (`testpaper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES ('10001', '卷一', '1', '2016-12-24 14:53:13', '2016-12-24 14:53:13', '1');
INSERT INTO `testpaper` VALUES ('10002', '卷二', '1', '2016-12-24 14:53:13', '2016-12-24 14:53:13', '1');
INSERT INTO `testpaper` VALUES ('10003', '卷三', '1', '2016-12-24 14:53:13', '2016-12-24 14:53:13', '1');
INSERT INTO `testpaper` VALUES ('10004', '添加试卷', '0', '2016-12-27 15:25:43', '2016-12-27 15:25:43', '1');
INSERT INTO `testpaper` VALUES ('10005', '测试数据', '0', '2016-12-27 15:25:24', '2016-12-27 15:25:24', '1');
INSERT INTO `testpaper` VALUES ('10006', 'rewrwer', '0', '2016-12-27 15:23:56', '2016-12-27 15:23:56', '1');
INSERT INTO `testpaper` VALUES ('10007', '5435435', '0', '2016-12-27 15:23:50', '2016-12-27 15:23:50', '1');
INSERT INTO `testpaper` VALUES ('10008', 'Test', '1', '2016-12-28 15:36:00', '2016-12-30 15:36:00', '1');
INSERT INTO `testpaper` VALUES ('10009', '', '0', '2016-12-28 15:57:23', '2016-12-28 15:57:23', '1');
INSERT INTO `testpaper` VALUES ('10010', '668767887877777', '0', '2016-12-30 16:33:28', '2016-12-30 16:33:28', '1');
INSERT INTO `testpaper` VALUES ('10011', 'AFAFA', '1', '2016-12-30 17:08:00', '2016-12-30 17:08:00', '1');

-- ----------------------------
-- Table structure for testpaper_tests
-- ----------------------------
DROP TABLE IF EXISTS `testpaper_tests`;
CREATE TABLE `testpaper_tests` (
  `testpaper_tests_id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaper_id` int(11) DEFAULT NULL,
  `question_bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`testpaper_tests_id`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testpaper_tests
-- ----------------------------
INSERT INTO `testpaper_tests` VALUES ('179', '10002', '99');
INSERT INTO `testpaper_tests` VALUES ('180', '10002', '100');
INSERT INTO `testpaper_tests` VALUES ('181', '10002', '101');
INSERT INTO `testpaper_tests` VALUES ('182', '10002', '102');
INSERT INTO `testpaper_tests` VALUES ('183', '10002', '103');
INSERT INTO `testpaper_tests` VALUES ('184', '10002', '150');
INSERT INTO `testpaper_tests` VALUES ('185', '10002', '151');
INSERT INTO `testpaper_tests` VALUES ('186', '10002', '152');
INSERT INTO `testpaper_tests` VALUES ('187', '10002', '153');
INSERT INTO `testpaper_tests` VALUES ('188', '10002', '154');
INSERT INTO `testpaper_tests` VALUES ('189', '10003', '98');
INSERT INTO `testpaper_tests` VALUES ('190', '10003', '99');
INSERT INTO `testpaper_tests` VALUES ('191', '10003', '100');
INSERT INTO `testpaper_tests` VALUES ('192', '10003', '101');
INSERT INTO `testpaper_tests` VALUES ('193', '10003', '102');
INSERT INTO `testpaper_tests` VALUES ('194', '10003', '147');
INSERT INTO `testpaper_tests` VALUES ('195', '10003', '148');
INSERT INTO `testpaper_tests` VALUES ('196', '10003', '149');
INSERT INTO `testpaper_tests` VALUES ('197', '10003', '150');
INSERT INTO `testpaper_tests` VALUES ('198', '10003', '151');
INSERT INTO `testpaper_tests` VALUES ('209', '10001', '127');
INSERT INTO `testpaper_tests` VALUES ('210', '10001', '128');
INSERT INTO `testpaper_tests` VALUES ('211', '10001', '130');
INSERT INTO `testpaper_tests` VALUES ('212', '10001', '131');
INSERT INTO `testpaper_tests` VALUES ('213', '10001', '132');
INSERT INTO `testpaper_tests` VALUES ('214', '10001', '149');
INSERT INTO `testpaper_tests` VALUES ('215', '10001', '150');
INSERT INTO `testpaper_tests` VALUES ('216', '10001', '151');
INSERT INTO `testpaper_tests` VALUES ('217', '10001', '152');
INSERT INTO `testpaper_tests` VALUES ('218', '10001', '153');
INSERT INTO `testpaper_tests` VALUES ('219', '10008', '94');
INSERT INTO `testpaper_tests` VALUES ('220', '10008', '95');
INSERT INTO `testpaper_tests` VALUES ('221', '10008', '99');
INSERT INTO `testpaper_tests` VALUES ('222', '10008', '100');
INSERT INTO `testpaper_tests` VALUES ('223', '10008', '101');
INSERT INTO `testpaper_tests` VALUES ('224', '10008', '102');
INSERT INTO `testpaper_tests` VALUES ('225', '10008', '103');
INSERT INTO `testpaper_tests` VALUES ('226', '10008', '104');
INSERT INTO `testpaper_tests` VALUES ('227', '10008', '108');
INSERT INTO `testpaper_tests` VALUES ('228', '10008', '124');

-- ----------------------------
-- Table structure for times
-- ----------------------------
DROP TABLE IF EXISTS `times`;
CREATE TABLE `times` (
  `times_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `testpaper_id` int(11) NOT NULL COMMENT '试卷_id',
  `user_id` varchar(30) NOT NULL COMMENT '用户ID',
  `data_min` double DEFAULT NULL,
  `times_state` int(5) DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`times_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of times
-- ----------------------------
INSERT INTO `times` VALUES ('39', '10002', '149000307', '41', '1');
INSERT INTO `times` VALUES ('40', '10001', '149000307', '58', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(30) NOT NULL COMMENT '用户id',
  `user_name` varchar(25) NOT NULL COMMENT '用户真实姓名',
  `user_pass` varchar(25) NOT NULL COMMENT '登陆密码',
  `permission` int(5) NOT NULL COMMENT '用户权限',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('10000', '管理员', 'admin', '1');
INSERT INTO `users` VALUES ('149000301', '王谦', 'admin', '1');
INSERT INTO `users` VALUES ('149000307', 'ICE', 'admin', '0');
