-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2019-05-21 18:42:38
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `exam`
--

-- --------------------------------------------------------

--
-- 表的结构 `options`
--

CREATE TABLE IF NOT EXISTS `options` (
  `options_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `op` varchar(255) DEFAULT NULL,
  `question_bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`options_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=431 ;

--
-- 转存表中的数据 `options`
--

INSERT INTO `options` (`options_id`, `content`, `op`, `question_bank_id`) VALUES
(222, 'MDZZ', 'A', 69),
(223, 'MDZZ', 'B', 69),
(224, 'MDZZ', 'C', 69),
(225, 'fdsf', 'D', 69),
(226, '765', 'A', 70),
(227, '765', 'B', 70),
(228, '765', 'C', 70),
(229, '765', 'D', 70),
(230, '765', 'A', 71),
(231, '765', 'B', 71),
(232, '765', 'C', 71),
(233, '765', 'D', 71),
(234, '方法', 'A', 75),
(235, '犯得上', 'B', 75),
(236, '犯得上', 'C', 75),
(237, '犯得上', 'D', 75),
(238, '方法', 'A', 76),
(239, '犯得上', 'B', 76),
(240, '犯得上', 'C', 76),
(241, '犯得上', 'D', 76),
(242, '犯得上犯得上犯得上犯得上', 'A', 77),
(243, '犯得上犯得上f', 'B', 77),
(244, '犯得上犯得上', 'C', 77),
(245, '但是犯得上阿飞', 'D', 77),
(246, '432', 'A', 78),
(247, '432', 'B', 78),
(248, '432', 'C', 78),
(249, '432', 'D', 78),
(250, '范德萨', 'A', 79),
(251, '范德萨', 'B', 79),
(252, '犯得上啊', 'C', 79),
(253, '范德萨', 'D', 79),
(254, '432', 'A', 81),
(255, '432', 'B', 81),
(256, '432', 'C', 81),
(257, '432', 'D', 81),
(258, '就是这么666', 'A', 88),
(259, '就是这么666', 'B', 88),
(260, '就是这么666', 'C', 88),
(261, '就是这么666', 'D', 88),
(262, '示范点', 'A', 92),
(263, '发射点', 'B', 92),
(264, '发射点', 'C', 92),
(265, '犯得上', 'D', 92),
(386, '', 'D', 96),
(385, '', 'C', 96),
(384, '', 'B', 96),
(383, '', 'A', 96),
(270, 'tar', 'A', 97),
(271, 'dump', 'B', 97),
(272, 'cpio', 'C', 97),
(273, 'afio', 'D', 97),
(274, '逻辑分区是在扩展分区中的分区', 'A', 98),
(275, '逻辑分区属于扩展分区', 'B', 98),
(276, '因此为了能够留出空间作为物理分区，必须先删除所有的逻辑分区然后再删除扩展分区。', 'C', 98),
(277, '全部错误', 'D', 98),
(278, 'xf86config', 'A', 99),
(279, 'test', 'B', 99),
(280, 'xinit', 'C', 99),
(281, 'startx', 'D', 99),
(282, 'make clean', 'A', 100),
(283, 'make modules', 'B', 100),
(284, 'make zlilo', 'C', 100),
(285, 'make modules_instal', 'D', 100),
(286, '用户账号的建立', 'A', 101),
(287, '用户登录系统后相关环境的设定', 'B', 101),
(288, '用户可使用资源的配置', 'C', 101),
(289, '关闭计算机', 'D', 101),
(290, '1', 'A', 102),
(291, '2', 'B', 102),
(292, '3', 'C', 102),
(293, '4', 'D', 102),
(294, 'Linux内核', 'A', 105),
(295, 'Window内核', 'B', 105),
(296, 'Linux内核+Window内核', 'C', 105),
(297, 'unix内核', 'D', 105),
(298, '大学', 'A', 106),
(299, '大学1', 'B', 106),
(300, '大学2', 'C', 106),
(301, '大学3', 'D', 106),
(302, 'jfk了但是', 'A', 120),
(303, 'jfk了的撒', 'B', 120),
(304, '附近开了多少', 'C', 120),
(305, '发动机是看了', 'D', 120),
(306, 'jfk了的撒', 'A', 121),
(307, '肌肤抵抗力是啊jfk了但是', 'B', 121),
(308, '附近看到了撒jfk了但是', 'C', 121),
(309, 'jfk了的撒尽快立法的就是', 'D', 121),
(310, '飞机开绿灯撒加弗兰克结果考了多少卡', 'A', 122),
(311, 'jfk到拉萨解放单反了开单', 'B', 122),
(312, '附近的撒范德萨咖啡难道是jfk', 'C', 122),
(313, '解放路口的沙发看电视剧开发阶段开始', 'D', 122),
(314, '解放立刻电视机分厘卡的就是看了', 'A', 123),
(315, '将发动机撒赖咖啡碱代课老师', 'B', 123),
(316, 'jfk了多少就离开房间', 'C', 123),
(317, 'jfk绿豆沙浪费空间的了', 'D', 123),
(318, '放假了女款的你看了发动机', 'A', 124),
(319, 'jfk了单身女郎可能看老师jfk了', 'B', 124),
(320, '你发的女开始就看到了放假的昆士兰', 'C', 124),
(321, 'jfk绿豆沙浪费你考了多少你考虑', 'D', 124),
(322, '那个时代坷拉飞机的苏联空军', 'A', 125),
(323, '呢罚款单开发计划打开', 'B', 125),
(324, '你付款的数据库附加的思考', 'C', 125),
(325, 'jfk了的时间了咖啡进口大理石', 'D', 125),
(326, '飞机开绿灯释放数据库', 'A', 126),
(327, 'jfk了的沙发肯定是女', 'B', 126),
(328, '减肥但是离开jfk的苏菲囧', 'C', 126),
(329, '金科路附近的塑料卡积分的轮廓设计', 'D', 126),
(330, '尽快立法的就是了咖啡机了看缴费接口电路设计开发', 'A', 127),
(331, 'jfk角度思考浪费那肯定是你看', 'B', 127),
(332, '放技能的离开少女凯撒的空间发', 'C', 127),
(333, 'jfk了撒jfk冷静地思考了', 'D', 127),
(334, '和jfk的是咖啡和贷款', 'A', 128),
(335, '减肥撒肌肤抵抗力就是', 'B', 128),
(336, '解放路口的沙发空间的数量', 'C', 128),
(337, 'jfk的滥杀风口浪尖的是', 'D', 128),
(338, '解放了肯定就撒开浪费大家', 'A', 129),
(339, 'jfk绿豆沙快放假打算离开', 'B', 129),
(340, '尽快立法当局撒开了飞机开绿灯即可点亮去了', 'C', 129),
(341, '看jfk就是快乐到家阿弗莱克', 'D', 129),
(342, '克己复礼但是系啊法律框架的撒开了jfk了的撒jfk亮点就是', 'A', 130),
(343, '即可立即发动开了傻风口浪尖的撒快放假了', 'B', 130),
(344, '接口连接方式定了卡积分电路设计高考零分', 'C', 130),
(345, '尽快付款了大厦看来飞机的实力开发接口的', 'D', 130),
(346, '来看看jfk了都是建立开放的角度看来是可怜见立刻jfk的', 'A', 131),
(347, '进口尽快立法角度考虑是打进口发动机数据库监控', 'B', 131),
(348, 'jfk了多少积分多少克拉夫角度看来是', 'C', 131),
(349, '尽快立法角度来说卡jfk了的时间', 'D', 131),
(350, '经费独立思考jfk了但是jfk的撒jfk绿豆沙开发jfk的斯科拉是jfk到拉萨机库里', 'A', 132),
(351, '接口开发阶段是垃圾分厘卡但是jfk了的撒娇；大家分厘卡的撒娇克劳福德傻空了放假的快乐', 'B', 132),
(352, '减肥的雷克萨根本不能可恶今日哦估计为哦ui热舞回家吧那就分手股份寰岛i银行i特温柔iu我', 'C', 132),
(353, 'i就就发给i叽歪哦退哦你比萨的借款归还借款可交换看法迪斯科飞机打开空间撒打发回家看看结果符合当时看了', 'D', 132),
(354, '两节课jfk了的沙发了肯定就仨房就打算离开', 'A', 133),
(355, '空间里看到尽快立法角度思考拉法基了离开家可怜见看来', 'B', 133),
(356, 'jfk了多少就发了多少链接发来看大家', 'C', 133),
(357, '解放了的沙发电视科技开发阶段是理科', 'D', 133),
(363, 'F', 'A', 154),
(364, 'F', 'B', 154),
(365, 'F', 'C', 154),
(366, 'F', 'D', 154),
(367, '选项1', 'A', 5),
(368, '选项2', 'B', 5),
(369, '选项3', 'C', 5),
(370, '选项4', 'D', 5),
(390, 'd', 'A', 95),
(389, 'c', 'B', 95),
(388, 'b', 'C', 95),
(387, 'a', 'D', 95),
(391, '', 'A', 172),
(392, '', 'B', 172),
(393, '', 'C', 172),
(394, '', 'D', 172),
(395, '', 'A', 173),
(396, '', 'B', 173),
(397, '', 'C', 173),
(398, '', 'D', 173),
(399, '', 'A', 174),
(400, '', 'B', 174),
(401, '', 'C', 174),
(402, '', 'D', 174),
(403, '', 'A', 175),
(404, '', 'B', 175),
(405, '', 'C', 175),
(406, '', 'D', 175),
(407, '', 'A', 176),
(408, '', 'B', 176),
(409, '', 'C', 176),
(410, '', 'D', 176),
(411, '', 'A', 177),
(412, '', 'B', 177),
(413, '', 'C', 177),
(414, '', 'D', 177),
(422, 'ddd', 'D', 181),
(421, 'ccc', 'C', 181),
(420, 'bbb', 'B', 181),
(419, 'aaa', 'A', 181),
(430, 'ddd', 'D', 184),
(429, 'ccc', 'C', 184),
(428, 'bbb', 'B', 184),
(427, 'aaa', 'A', 184);

-- --------------------------------------------------------

--
-- 表的结构 `question_bank`
--

CREATE TABLE IF NOT EXISTS `question_bank` (
  `question_bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `stem` varchar(255) DEFAULT NULL,
  `tests_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_bank_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=187 ;

--
-- 转存表中的数据 `question_bank`
--

INSERT INTO `question_bank` (`question_bank_id`, `answer`, `state`, `stem`, `tests_type`) VALUES
(93, '1', 0, '使用shutdown -k命令并不真正使系统关机，而只是给用户提出警告', 0),
(94, '0', 0, '手工运行fsck的最好时机是在系统备份文件之后，这样在发现错误后，还可以利用备份文', 0),
(95, 'A', 1, 'Linux 系统引导后，内核运行init程序，这个程序在处理任何其他规定的运行等级之后，在运行/etc/rc.d/rc.sysinit脚本', 1),
(96, 'A', 0, 'Linux 系统引导后，内核运行init程序，这个程序在处理任何其他规定的运行等级之后，在运行/etc/rc.d/rc.sysinit脚本', 1),
(97, 'D', 1, '常用的备份工具中不能直接实现备份级别，而是必须借助于其它工具才能实现的不包括：', 1),
(98, 'D', 1, '假设当前系统具有C. D. E. F四个分区。它们分成两类，C盘是Windows 98的主分区。D. E. F三个分区都是逻辑分区，它们都属于Windows 98的扩展分区。Windows 98的主分区和扩展分区占据了整个硬盘空间。下面说法错误的是:', 1),
(99, 'A', 1, '为了生成XF86Config文件，我们可以使用_________命令：', 1),
(100, 'B', 1, '如果在配置内核时，我们选择启用模块支持，则一般说来我们需要运行_______以在系统中编译安装合适的模块。', 1),
(101, 'D', 1, '系统管理员用户管理的内容，主要包括：', 1),
(102, 'B', 1, '1+1 = ?', 1),
(103, '1', 1, 'Java 是编程语言', 0),
(104, '0', 1, 'C语言是机器语言', 0),
(105, 'A', 1, 'Ubuntu是什么内核', 1),
(106, 'A', 0, '大学-小学那个是你向往的。', 1),
(107, '0', 1, '硬盘分区方案内置于硬件和BIOS中，所以对硬盘重新分区后，相应的我们还需要在启动时，按键，进入Bios设置选单，修改硬盘参数。', 0),
(108, '0', 1, '在使用硬链接时，我们可以使硬链接跨越不同的文件系统与另一个目录链接。', 0),
(109, '0', 0, 'df命令显示各种文件和目录所使用的硬盘空间数，并且可以显示系统中最多或者最少的硬盘空间的位置。', 0),
(110, '0', 1, '为了 Linux，在分区时，我们至少需要分出二个区，用来安装根(/)文件系统和交换(swap)文件系统。', 0),
(111, '0', 1, '在当前目录下解压归档文件this.tar.gz ，我们可以使用命令：$tar xvzf this.tar.gz', 0),
(112, '0', 1, '如果有多个SCSI硬盘，/boot启动目录必须放在标识为0的SCSI硬盘上，其它SCSI标识', 0),
(113, '1', 1, '对tar和cpio这些备份工具来说，必须借助于其他工具，才能实施备份级别。', 0),
(114, '1', 1, '我们可以通过进程日志获得关于一个确定的进程正在干什么之类的线索。', 0),
(115, '1', 1, '除root用户外，其它用户只能用kill命令终止自己的创建的进程。', 0),
(116, '1', 1, '如果用户拥有目录的写许可，则该用户可以创建、删除或修改目录中的任何文件或子目录，甚至于属于其它用户的文件和子目录。', 0),
(117, '1', 1, 'Linux系统上的终端口对任何人都是可写的，从而使用户可以用write命令互相发送信息。', 0),
(118, '1', 1, '一般来说，具有偶数号的内核(例如0 、2 、4 ，等等)被认为是稳定的内核。', 0),
(119, '0', 1, '我们一般使用mknod工具来建立分区上的文件系统', 0),
(120, 'A', 1, '开发量；迪斯科浪费', 1),
(121, 'A', 1, '尽快立法的杀戮', 1),
(122, 'A', 1, '就考虑后果付款了好可怜的国服开了分店', 1),
(123, 'A', 1, '模拟结果看了放大镜看了附件是打开链接发', 1),
(124, 'A', 1, '吗板块轮番进攻开发力度加快功率发动机', 1),
(125, 'A', 1, '你们不考虑的jfk管理经费独立空间', 1),
(126, 'A', 1, 'i容额我就感觉考虑到房价离开', 1),
(127, 'A', 1, '看见了换个房间开好了个jfk了', 1),
(128, 'A', 1, '健康美丽和高科技了客户顾客了高考零分的', 1),
(129, 'A', 1, '们那边就考了高分的结果看了大家', 1),
(130, 'A', 1, '快乐就好国防科技了环境开放了', 1),
(131, 'A', 1, '附近的快速离开jfk了但是jfk两节课', 1),
(132, 'A', 1, '附件kids啦付款都是垃圾防空洞杀了开发接口jfk的滥杀分开的三角形轮廓发动机看来是的飞机开绿灯撒jfk的数据库来访接待室拉克飓风', 1),
(133, 'A', 1, 'jfk的沙发考虑的就是看了发就考了多少积分', 1),
(134, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(135, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(136, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(137, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(138, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(139, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(140, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(141, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(142, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(143, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(144, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(145, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(146, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(147, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(148, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(149, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(150, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(151, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(152, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(153, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(154, 'A', 1, '这题也A', 1),
(155, 'A', 0, '这题也选A', 1),
(156, 'B', 1, '这题选B', 1),
(157, '1', 1, '关于逆时空理论中时空倒转的条件中光速的最大值是否为30WKM/s', 0),
(158, '100', 1, 'A+B Problem', 2),
(159, '100', 1, '谁拿了最多奖学金', 2),
(160, '100', 1, '过河', 2),
(161, '100', 1, '等价表达式1', 2),
(181, 'B', 1, '这题选什么', 1),
(182, '1', 1, '这题对不对', 0),
(183, '100', 1, '输出a*b', 2),
(184, 'B', 1, 'zhet选什么', 1),
(185, '1', 1, '这题对吗', 0),
(1, '1', 1, '把CPU、内容、硬盘、光驱盒电源等硬件设置，通过计算机主板连接，并安装在机箱中，称为主机。', 0),
(186, '100', 1, '请输出a乘b的值。', 2),
(2, '1', 1, '在采购计算机时主板的芯片组需与CPU平台相同。', 0),
(3, '1', 1, '中央处理器功能主要是解释计算机指令以及处理计算机软件中的数据。', 0),
(4, '0', 1, '主频、倍频、外频的关系式：主频=外频/倍频。', 0),
(5, '1', 1, '固态硬盘相比机械硬盘存取速度快、体积小、发热高、防震抗摔。', 0),
(6, '1', 0, '现在硬盘基础上都采用了SATA2结构形式。', 0),
(7, '1', 1, '要进入BIOS设置界面，通常情况下是在电脑启动自检状态下，根据提示，按DEL或F2等键。', 0),
(8, '1', 1, '如果BIOS程序被病毒破坏，计算机将无法启动。', 0),
(9, '1', 0, 'BIOS设置也可称为CMOS设置。', 0),
(10, '0', 1, '电脑启动，一般只能从硬盘或光盘启动。', 0),
(11, '0', 1, '如果希望电脑每次启动都要输入密码才能进入操作系统，可以再BIOS将密码类型设置为SETUP。', 0),
(12, '0', 1, 'GHOST镜像文件的扩展名为GHS。', 0),
(13, '1', 1, '用GHOST快速重装系统，前提是之前进行过GHOST镜像备份。', 0),
(14, '0', 1, '用GHOST快速恢复系统时，如果有多个目标硬盘和目标分区，可以随意选择。', 0),
(15, '1', 1, '如果没有正确安装设备驱动程序，电脑有些硬件可能无法正常使用。', 0),
(16, '0', 1, 'MODEM是上网必须的网络设备。', 0),
(17, '0', 1, '计算机申请了账号并采用PPPOE拨号方式接入英特网后，该机就拥有固定的IP地址。', 0),
(18, '1', 1, '在局域网中，计算机硬盘上的文件盒数据可以被网络中其他计算机共享。', 0);

-- --------------------------------------------------------

--
-- 表的结构 `score`
--

CREATE TABLE IF NOT EXISTS `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `fraction` double DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `testpaper_id` int(11) DEFAULT NULL,
  `users_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=113 ;

--
-- 转存表中的数据 `score`
--

INSERT INTO `score` (`score_id`, `fraction`, `img`, `testpaper_id`, `users_id`) VALUES
(57, 10, NULL, 10002, '149000307'),
(58, 0, NULL, 10001, '149000307'),
(99, 0, NULL, 10008, '2'),
(96, 0, NULL, 10011, '2'),
(95, 0, NULL, 10011, '149000301'),
(94, 0, NULL, 10008, '149000301'),
(110, 58, NULL, 10017, '21'),
(112, 0, NULL, 10008, '21');

-- --------------------------------------------------------

--
-- 表的结构 `testpaper`
--

CREATE TABLE IF NOT EXISTS `testpaper` (
  `testpaper_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` varchar(255) DEFAULT NULL,
  `is_start` int(11) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `testpaper_name` varchar(255) DEFAULT NULL,
  `testpaper_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`testpaper_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10018 ;

--
-- 转存表中的数据 `testpaper`
--

INSERT INTO `testpaper` (`testpaper_id`, `end_date`, `is_start`, `start_date`, `testpaper_name`, `testpaper_state`) VALUES
(10001, '2019-12-30 15:36', 1, '2018-12-24 14:53:13', '卷一', 1),
(10002, '2019-12-24 14:53', 1, '2018-12-24 14:53:13', '卷二', 1),
(10003, '2018-12-24 14:53:13', 1, '2018-12-24 14:53:13', '卷三', 0),
(10004, '2018-12-27 15:25:43', 1, '2018-12-27 15:25:43', '添加试卷', 0),
(10005, '2018-12-27 15:25:24', 1, '2018-12-27 15:25:24', '测试数据', 0),
(10006, '2018-12-27 15:23:56', 1, '2018-12-27 15:23:56', 'rewrwer', 0),
(10008, '2019-12-30 15:36', 1, '2019-03-01 15:36', 'JAVA面试', 1),
(10009, '2018-12-28 15:57:23', 0, '2018-12-28 15:57:23', '2019届春招', 1),
(10017, '2019-05-23 00:17', 1, '2019-05-22 00:17', 'C#面试', 1),
(10011, '2019-05-30 17:08', 1, '2019-04-13 17:08', 'C++面试', 10011);

-- --------------------------------------------------------

--
-- 表的结构 `testpaper_tests`
--

CREATE TABLE IF NOT EXISTS `testpaper_tests` (
  `testpaper_tests_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_bank_id` int(11) DEFAULT NULL,
  `testpaper_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`testpaper_tests_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=351 ;

--
-- 转存表中的数据 `testpaper_tests`
--

INSERT INTO `testpaper_tests` (`testpaper_tests_id`, `question_bank_id`, `testpaper_id`) VALUES
(283, 153, 10002),
(282, 152, 10002),
(281, 151, 10002),
(280, 150, 10002),
(279, 103, 10002),
(278, 154, 10002),
(277, 102, 10002),
(276, 101, 10002),
(275, 100, 10002),
(274, 99, 10002),
(294, 151, 10003),
(293, 150, 10003),
(292, 149, 10003),
(291, 148, 10003),
(290, 147, 10003),
(289, 102, 10003),
(288, 101, 10003),
(287, 100, 10003),
(286, 99, 10003),
(285, 98, 10003),
(273, 159, 10001),
(272, 153, 10001),
(271, 152, 10001),
(270, 151, 10001),
(269, 150, 10001),
(268, 149, 10001),
(267, 132, 10001),
(266, 131, 10001),
(265, 130, 10001),
(264, 128, 10001),
(306, 118, 10008),
(305, 158, 10008),
(304, 108, 10008),
(303, 104, 10008),
(302, 103, 10008),
(301, 1, 10008),
(300, 102, 10008),
(299, 101, 10008),
(298, 100, 10008),
(297, 99, 10008),
(296, 95, 10008),
(251, 160, 10011),
(250, 130, 10011),
(249, 153, 10011),
(248, 101, 10011),
(247, 110, 10011),
(246, 99, 10011),
(245, 135, 10011),
(244, 120, 10011),
(243, 137, 10011),
(242, 156, 10011),
(241, 147, 10011),
(263, 127, 10001),
(284, 158, 10002),
(295, 158, 10003),
(307, 149, 10009),
(308, 156, 10009),
(309, 17, 10009),
(310, 105, 10009),
(311, 118, 10009),
(312, 131, 10009),
(313, 4, 10009),
(314, 130, 10009),
(315, 117, 10009),
(316, 127, 10009),
(317, 158, 10009),
(318, 153, 10014),
(319, 133, 10014),
(320, 107, 10014),
(321, 128, 10014),
(322, 117, 10014),
(323, 101, 10014),
(324, 8, 10014),
(325, 97, 10014),
(326, 115, 10014),
(327, 102, 10014),
(328, 183, 10014),
(350, 158, 10017),
(349, 136, 10017),
(348, 116, 10017),
(347, 107, 10017),
(346, 103, 10017),
(345, 18, 10017),
(344, 184, 10017),
(343, 181, 10017),
(342, 122, 10017),
(341, 105, 10017),
(340, 101, 10017);

-- --------------------------------------------------------

--
-- 表的结构 `times`
--

CREATE TABLE IF NOT EXISTS `times` (
  `times_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` datetime DEFAULT NULL,
  `testpaper_id` int(11) DEFAULT NULL,
  `times_state` int(11) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`times_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- 转存表中的数据 `times`
--

INSERT INTO `times` (`times_id`, `start_time`, `testpaper_id`, `times_state`, `user_id`) VALUES
(24, '2019-05-22 00:39:39', 10008, 1, '21'),
(23, '2019-05-21 23:29:06', 10008, 0, '21'),
(22, '2019-05-22 00:20:51', 10017, 1, '21');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `true_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`user_id`, `phone`, `enabled`, `password`, `roles`, `true_name`, `username`) VALUES
(1, '17788888888', b'1', '$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6', 'ROLE_ADMIN', '管理员', 'admin'),
(2, NULL, b'1', '$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6', 'ROLE_USER', '面试者', 'user'),
(3, NULL, b'1', '$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6', 'ROLE_USER', '王同学', 'wang'),
(4, NULL, b'1', '$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6', 'ROLE_USER', '李同学', 'li'),
(5, NULL, b'1', '$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6', 'ROLE_JUDGE', '判题机1号', 'judge1'),
(6, NULL, b'1', '$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6', 'ROLE_JUDGE', '判题机2号', 'judge2'),
(21, '17777777777', b'1', '$2a$10$ikRc9qYZbyXN40SpFo8TW.s0UH6DAWYlicGpvm/3DAchXkHpFjoHy', 'ROLE_USER', '李同学', '17777777777');

-- --------------------------------------------------------

--
-- 表的结构 `voj_judge_results`
--

CREATE TABLE IF NOT EXISTS `voj_judge_results` (
  `judge_result_id` int(11) NOT NULL AUTO_INCREMENT,
  `judge_result_name` varchar(255) DEFAULT NULL,
  `judge_result_slug` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`judge_result_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `voj_judge_results`
--

INSERT INTO `voj_judge_results` (`judge_result_id`, `judge_result_name`, `judge_result_slug`) VALUES
(1, 'Pending', 'PD'),
(2, 'Accepted', 'AC'),
(3, 'Wrong Answer', 'WA'),
(4, 'Time Limit Exceed', 'TLE'),
(5, 'Output Limit Exceed', 'OLE'),
(6, 'Memory Limit Exceed', 'MLE'),
(7, 'Runtime Error', 'RE'),
(8, 'Presentation Error', 'PE'),
(9, 'Compile Error', 'CE'),
(10, 'System Error', 'SE');

-- --------------------------------------------------------

--
-- 表的结构 `voj_languages`
--

CREATE TABLE IF NOT EXISTS `voj_languages` (
  `language_id` int(11) NOT NULL AUTO_INCREMENT,
  `language_compile_command` varchar(255) DEFAULT NULL,
  `language_name` varchar(255) DEFAULT NULL,
  `language_slug` varchar(255) DEFAULT NULL,
  `language_run_command` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `voj_languages`
--

INSERT INTO `voj_languages` (`language_id`, `language_compile_command`, `language_name`, `language_slug`, `language_run_command`) VALUES
(1, 'gcc -O2 -s -Wall -o {filename}.exe {filename}.c -lm', 'C', 'text/x-csrc', '{filename}.exe'),
(2, 'g++ -O2 -s -Wall -std=c++11 -o {filename}.exe {filename}.cpp -lm', 'C++', 'text/x-c++src', '{filename}.exe'),
(3, 'javac {filename}.java', 'Java', 'text/x-java', 'java -cp {filename}'),
(4, 'python -m py_compile {filename}.py', 'Python 2', 'text/x-python', 'python {filename}.py');

-- --------------------------------------------------------

--
-- 表的结构 `voj_problems`
--

CREATE TABLE IF NOT EXISTS `voj_problems` (
  `problem_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `hint` text,
  `input_format` text,
  `memory_limit` int(11) NOT NULL,
  `output_format` text,
  `problem_name` varchar(255) DEFAULT NULL,
  `question_bank_id` int(11) NOT NULL,
  `sample_input` text,
  `sample_output` text,
  `time_limit` int(11) NOT NULL,
  PRIMARY KEY (`problem_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1008 ;

--
-- 转存表中的数据 `voj_problems`
--

INSERT INTO `voj_problems` (`problem_id`, `description`, `hint`, `input_format`, `memory_limit`, `output_format`, `problem_name`, `question_bank_id`, `sample_input`, `sample_output`, `time_limit`) VALUES
(1000, '输入两个自然数, 输出他们的和', '## C++ Code\n\n    #include <iostream>\n\n    int main() {\n        int a = 0, b = 0;\n        std::cin >> a >> b;\n        std::cout << a + b << std::endl;\n        return 0;\n    }\n\n## Java Code\n\n    import java.util.Scanner;\n\n    public class Main {\n        public static void main(String[] args) {\n            Scanner in = new Scanner(System.in);\n            int a = in.nextInt();\n            int b = in.nextInt();\n            System.out.println(a + b);\n        }\n    }\n', '两个自然数x和y (0<=x, y<=32767).', 65536, '一个数, 即x和y的和.', 'A+B Problem', 158, '123 500', '623', 1000),
(1001, '某校的惯例是在每学期的期末考试之后发放奖学金。发放的奖学金共有五种，获取的条件各自不同：\r\n1) 院士奖学金，每人8000元，期末平均成绩高于80分（>80），并且在本学期内发表1篇或1篇以上论文的学生均可获得；\r\n2) 五四奖学金，每人4000元，期末平均成绩高于85分（>85），并且班级评议成绩高于80分（>80）的学生均可获得；\r\n3) 成绩优秀奖，每人2000元，期末平均成绩高于90分（>90）的学生均可获得；\r\n4) 西部奖学金，每人1000元，期末平均成绩高于85分（>85）的西部省份学生均可获得；\r\n5) 班级贡献奖，每人850元，班级评议成绩高于80分（>80）的学生干部均可获得；\r\n只要符合条件就可以得奖，每项奖学金的获奖人数没有限制，每名学生也可以同时获得多项奖学金。例如姚林的期末平均成绩是87分，班级评议成绩82分，同时他还是一位学生干部，那么他可以同时获得五四奖学金和班级贡献奖，奖金总数是4850元。\r\n现在给出若干学生的相关数据，请计算哪些同学获得的奖金总数最高（假设总有同学能满足获得奖学金的条件）。', NULL, '输入的第一行是一个整数N（1 <= N <= 100），表示学生的总数。接下来的N行每行是一位学生的数据，从左向右依次是姓名，期末平均成绩，班级评议成绩，是否是学生干部，是否是西部省份学生，以及发表的论文数。姓名是由大小写英文字母组成的长度不超过20的字符串（不含空格）；期末平均成绩和班级评议成绩都是0到100之间的整数（包括0和100）；是否是学生干部和是否是西部省份学生分别用一个字符表示，Y表示是，N表示不是；发表的论文数是0到10的整数（包括0和10）。每两个相邻数据项之间用一个空格分隔。', 65536, '输出包括三行，第一行是获得最多奖金的学生的姓名，第二行是这名学生获得的奖金总数。如果有两位或两位以上的学生获得的奖金最多，输出他们之中在输入文件中出现最早的学生的姓名。第三行是这N个学生获得的奖学金的总数。', '谁拿了最多奖学金', 159, '4\r\nYaoLin 87 82 Y N 0\r\nChenRuiyi 88 78 N Y 1\r\nLiXin 92 88 N N 0\r\nZhangQin 83 87 Y N 1', 'ChenRuiyi\r\n9000\r\n28700', 1000),
(1002, '在河上有一座独木桥, 一只青蛙想沿着独木桥从河的一侧跳到另一侧. 在桥上有一些石子, 青蛙很讨厌踩在这些石子上. 由于桥的长度和青蛙一次跳过的距离都是正整数, 我们可以把独木桥上青蛙可能到达的点看成数轴上的一串整点：0, 1, ……, L(其中L是桥的长度). 坐标为0的点表示桥的起点, 坐标为L的点表示桥的终点. 青蛙从桥的起点开始, 不停的向终点方向跳跃. 一次跳跃的距离是S到T之间的任意正整数(包括S,T). 当青蛙跳到或跳过坐标为L的点时, 就算青蛙已经跳出了独木桥. \r\n题目给出独木桥的长度L, 青蛙跳跃的距离范围S,T, 桥上石子的位置. 你的任务是确定青蛙要想过河, 最少需要踩到的石子数. \r\n对于30%的数据, L <= 10000；\r\n对于全部的数据, L <= 10^9. ', NULL, '输入的第一行有一个正整数L(1 <= L <= 10^9), 表示独木桥的长度. 第二行有三个正整数S, T, M, 分别表示青蛙一次跳跃的最小距离, 最大距离, 及桥上石子的个数, 其中1 <= S <= T <= 10, 1 <= M <= 100. 第三行有M个不同的正整数分别表示这M个石子在数轴上的位置(数据保证桥的起点和终点处没有石子). 所有相邻的整数之间用一个空格隔开. ', 65536, '输出只包括一个整数, 表示青蛙过河最少需要踩到的石子数.', '过河', 160, '10\r\n2 3 5\r\n2 3 5 6 7', '2', 1000),
(1003, '明明进了中学之后, 学到了代数表达式. 有一天, 他碰到一个很麻烦的选择题. 这个题目的题干中首先给出了一个代数表达式, 然后列出了若干选项, 每个选项也是一个代数表达式, 题目的要求是判断选项中哪些代数表达式是和题干中的表达式等价的. \n\n这个题目手算很麻烦, 因为明明对计算机编程很感兴趣, 所以他想是不是可以用计算机来解决这个问题. 假设你是明明, 能完成这个任务吗? \n\n这个选择题中的每个表达式都满足下面的性质: \n\n1. 表达式只可能包含一个变量''a''. \n2. 表达式中出现的数都是正整数, 而且都小于10000. \n3. 表达式中可以包括四种运算''+''(加), ''-''(减), ''\\*''(乘), ''^''(乘幂), 以及小括号''('', '')''. 小括号的优先级最高, 其次是''^'', 然后是''*'', 最后是''+''和''-''. ''+''和''-''的优先级是相同的. 相同优先级的运算从左到右进行. (注意: 运算符''+'', ''-'', ''\\*'', ''^''以及小括号''('', '')''都是英文字符)\n4. 幂指数只可能是1到10之间的正整数(包括1和10). \n5. 表达式内部, 头部或者尾部都可能有一些多余的空格. \n\n下面是一些合理的表达式的例子: \n\n    ((a^1) ^ 2)^3, a*a+a-a, ((a+a)), 9999+(a-a)*a, 1 + (a -1)^3, 1^10^9……\n\n\n- 对于30%的数据, 表达式中只可能出现两种运算符''+''和''-''；\n- 对于其它的数据, 四种运算符''+'', ''-'', ''*'', ''^''在表达式中都可能出现. \n- 对于全部的数据, 表达式中都可能出现小括号''(''和'')''. ', '', '输入的第一行给出的是题干中的表达式. 第二行是一个整数n(2 <= n <= 26), 表示选项的个数. 后面n行, 每行包括一个选项中的表达式. 这n个选项的标号分别是A, B, C, D……\n输入中的表达式的长度都不超过50个字符, 而且保证选项中总有表达式和题干中的表达式是等价的. ', 65536, '输出包括一行, 这一行包括一系列选项的标号, 表示哪些选项是和题干中的表达式等价的. 选项的标号按照字母顺序排列, 而且之间没有空格.', '等价表达式', 161, '( a + 1) ^2\n3\n(a-1)^2+4*a\na  + 1+ a\na^2 + 2 * a * 1 + 1^2 + 10 -10 +a -a', 'AC', 1000),
(1004, 'a', 'a', 'a', 65555, 'a', 'xiuxixuiuxaa', 170, 'a', 'a', 101),
(1005, 'q', 'q', 'q', 65555, 'q', 'q', 178, 'q', 'q', 100),
(1006, '请输出a*b的值', 'a*b啊', '1 2', 1000, '2', '输出a*b', 183, '2 5', '10', 1000),
(1007, '请输出a乘b的值。', 'a*b', '2 2', 2048, '4', '请输出a乘b的值。', 186, '2 3', '6', 1000);

-- --------------------------------------------------------

--
-- 表的结构 `voj_problem_categories`
--

CREATE TABLE IF NOT EXISTS `voj_problem_categories` (
  `problem_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `problem_category_parent_id` int(11) DEFAULT NULL,
  `problem_category_name` varchar(255) DEFAULT NULL,
  `problem_category_slug` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`problem_category_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `voj_problem_categories`
--

INSERT INTO `voj_problem_categories` (`problem_category_id`, `problem_category_parent_id`, `problem_category_name`, `problem_category_slug`) VALUES
(1, 0, 'Uncategorized', 'uncategorized'),
(2, 0, 'Dynamic Programming', 'dynamic-programming');

-- --------------------------------------------------------

--
-- 表的结构 `voj_problem_category_relationships`
--

CREATE TABLE IF NOT EXISTS `voj_problem_category_relationships` (
  `problem_id` bigint(20) NOT NULL,
  `problem_category_id` int(11) NOT NULL,
  PRIMARY KEY (`problem_id`,`problem_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `voj_problem_category_relationships`
--

INSERT INTO `voj_problem_category_relationships` (`problem_id`, `problem_category_id`) VALUES
(1000, 1),
(1000, 2),
(1001, 1),
(1002, 1),
(1003, 1),
(1004, 1),
(1005, 1),
(1006, 1),
(1007, 1);

-- --------------------------------------------------------

--
-- 表的结构 `voj_problem_checkpoints`
--

CREATE TABLE IF NOT EXISTS `voj_problem_checkpoints` (
  `problem_id` bigint(20) NOT NULL,
  `checkpoint_id` int(11) NOT NULL,
  `checkpoint_input` longtext,
  `checkpoint_exactly_match` bit(1) DEFAULT NULL,
  `checkpoint_output` longtext,
  `checkpoint_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`problem_id`,`checkpoint_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `voj_problem_checkpoints`
--

INSERT INTO `voj_problem_checkpoints` (`problem_id`, `checkpoint_id`, `checkpoint_input`, `checkpoint_exactly_match`, `checkpoint_output`, `checkpoint_score`) VALUES
(1000, 0, '18820 26832\r\n', b'0', '45652\r\n', 10),
(1000, 1, '1123 5687', b'0', '6810\r\n', 10),
(1000, 2, '15646 8688', b'0', '24334', 10),
(1000, 3, '26975 21625', b'0', '48600', 10),
(1000, 4, '23107 28548', b'0', '51655', 10),
(1000, 5, '16951 22289', b'0', '39240', 10),
(1000, 6, '8634 13146', b'0', '21780', 10),
(1000, 7, '17574 15337', b'0', '32911', 10),
(1000, 8, '14548 28382', b'0', '42930', 10),
(1000, 9, '3271 17411', b'0', '20682', 10),
(1001, 0, '100\r\nXvpxWEvuxMujM 79 90 N N 0\r\nFWGrVKwgJsImNAzO 100 75 Y Y 0\r\nXHEDY 85 95 Y Y 8\r\nSnJCAbmx 80 90 Y N 0\r\nIjsb 90 78 N N 0\r\nT 78 98 Y Y 8\r\nA 87 90 Y Y 0\r\nASVBj 85 94 N N 0\r\nFmMsZNPOCgCwygIT 85 83 N Y 0\r\nFXJDETWfFCqJnbYyxa 75 82 N Y 0\r\nEQMWSRKNvkunT 80 95 Y Y 0\r\nVdxkZpDNgfvqQOGyyOIG 80 80 Y Y 0\r\nXGIMzWKXeJMXTUwduO 95 81 N Y 0\r\nRuncagD 95 96 Y N 0\r\nTzmkvWKsUOkbBDrnc 90 96 N Y 5\r\nCXBJzEelrzdJ 90 97 N Y 0\r\nUGmNXVYsvpLgmb 85 100 N Y 0\r\nAhteTELcmbv 90 85 N N 0\r\nGAEIg 80 95 N Y 0\r\nYAHRJgqstbZaZPyww 99 85 Y Y 0\r\nQo 90 90 N N 0\r\nDtqLHiMmeHbohAxToJWP 78 75 Y Y 0\r\nXIWnP 85 75 N Y 0\r\nDoWmxImSCdk 95 76 Y N 0\r\nNLFznHxOcV 82 85 N N 0\r\nAKXkyYHWGwXvqMLKiCIR 94 95 Y Y 0\r\nGcgEAFL 79 93 N Y 0\r\nNqUjBPAYxdABnMGcQax 85 91 Y N 0\r\nXPohweOIDDHmb 83 94 Y N 0\r\nYIdB 75 93 N Y 0\r\nDBQxmSnODuYwifv 93 77 Y N 0\r\nRCpKstV 75 90 N Y 0\r\nUnu 82 81 Y N 0\r\nNGeyEHglHxHfghD 81 100 N Y 0\r\nMFLedhUZ 96 75 N Y 0\r\nYYEt 76 95 Y Y 10\r\nR 85 85 Y Y 0\r\nLHJGGF 95 87 Y Y 0\r\nPA 85 93 N Y 0\r\nGKPQfRzvnYtRqUcYYDGi 80 92 N N 0\r\nOsYZnlpdToExY 99 95 Y Y 0\r\nBK 91 85 N N 0\r\nC 83 85 Y Y 0\r\nTvp 90 90 Y Y 0\r\nFzSFDyfqaKOAp 90 85 Y N 0\r\nIIzkbLEYbncWzCZCIiJr 94 90 N N 0\r\nYOwtTfAQymJqjkkh 90 80 Y Y 0\r\nAjZSUNidohrGDgCBpo 91 86 Y N 0\r\nQRhbctxBn 79 75 N Y 0\r\nEIkGwpsyW 85 96 N N 0\r\nIJh 85 81 N Y 0\r\nXe 82 80 Y Y 7\r\nBbLcNTB 95 80 N N 0\r\nMPCNZTyWmaZ 84 85 N N 0\r\nChrB 95 95 N N 0\r\nTlIYwpIbVnurzacD 95 90 N N 8\r\nThywwHUaoxX 99 78 N Y 0\r\nQGnzLidvEBjIcmGIAdI 86 96 N Y 0\r\nDNpKPSUyprOeJFmU 81 93 N Y 0\r\nHYfptVzlESrFRUVdgL 93 92 Y N 0\r\nHcblndXi 90 89 Y N 0\r\nNWBJjdgcI 87 85 N Y 0\r\nShnYCYURiyKoVTq 85 99 N N 0\r\nZbc 75 80 Y Y 0\r\nEGvxpyULGNPQ 90 91 N N 0\r\nTdjasZOAvV 75 90 N Y 6\r\nJA 93 80 N Y 0\r\nXkCWQCTpXjZgCKflzh 86 83 N Y 0\r\nEsNOQfgeERv 75 81 N Y 0\r\nSuyWV 95 81 N Y 0\r\nLJJbpohSV 90 98 N Y 0\r\nMPGJLKflSBtZHKEtcsU 100 99 Y N 0\r\nAQrPmmXO 89 95 Y Y 0\r\nYDCmkIYBPOy 95 91 N Y 10\r\nXLiSnATGAHSSF 95 83 N N 0\r\nSGyOHlvb 90 84 Y Y 0\r\nMRiXqCxTvwToRyyEJgB 95 100 Y Y 0\r\nZNrctMuIhBMLmmi 85 78 N Y 0\r\nHdTpUsEc 98 75 Y Y 0\r\nRAhDEmlvNNicCa 75 92 Y Y 0\r\nIKyNgnEfzGQFnBMd 85 80 N Y 0\r\nJNtN 95 90 N N 7\r\nSBeSjxfxvmQIH 84 91 Y Y 0\r\nEregtaBcUOPuFfOWAxw 95 81 Y N 0\r\nBjcxDhbbJvDLXMVyn 87 79 N Y 0\r\nViFUYKFDOZegK 90 80 Y Y 0\r\nWsr 95 86 Y N 0\r\nJgdPGCFiUwUUfAA 80 92 Y Y 0\r\nO 96 97 Y N 0\r\nJWfAfenceiSgJq 95 85 N N 0\r\nQUJCpMvjCViQ 80 85 Y Y 0\r\nRnVtCGNCmLqmtdly 83 95 Y N 0\r\nQKnLkS 87 80 N Y 0\r\nMuQsSfe 90 97 N Y 0\r\nSkvAUshiLLErXihn 93 85 Y Y 0\r\nKhEmO 88 88 Y N 0\r\nHovCo 90 80 N Y 0\r\nUxZ 75 75 Y N 6\r\nBuD 97 77 N Y 0\r\nHfSAzTvoupTcUlldPWDM 75 95 N Y 0', b'0', 'YDCmkIYBPOy\r\n15000\r\n332750', 10),
(1001, 1, '100\r\nKSSHsCEhNHXIMxnKjszE 93 98 N Y 0\r\nKRXBnwAzDGjpfJgRpKt 95 90 Y Y 0\r\nJBOyaqxicVGB 96 84 N Y 0\r\nHolSWzxphdbM 99 80 Y Y 0\r\nYzYKojgqgraUpqNyJ 95 90 N N 0\r\nLgX 97 94 Y Y 0\r\nHCRuZbWsSDgkOEoj 80 90 N Y 0\r\nS 85 89 N Y 10\r\nAdLhdCBxwmJXRm 78 97 Y N 0\r\nQhgGp 85 87 Y N 0\r\nZFTdFawbiwDG 87 80 N Y 0\r\nJaOThlpkrRkejXMMXgbu 95 80 Y Y 0\r\nNiAntWp 85 91 Y N 0\r\nTe 81 81 Y Y 0\r\nTrFXiYBMzJ 92 87 N N 0\r\nMlhsUsruSKdrAGkUerE 97 92 Y Y 0\r\nNWpjgxcNegmyEGHlPTP 88 94 N N 5\r\nVCXJjomOzywFZBVkDR 87 75 Y N 0\r\nPxZYNvXNdbUtBIp 82 75 N Y 0\r\nTsJkMpF 85 99 N Y 0\r\nBwaIeOrqdatudl 85 80 N N 0\r\nIB 95 90 Y N 0\r\nHmPorGeOs 98 85 Y N 0\r\nDgRHzC 87 82 Y N 0\r\nWkRmkErigra 90 75 Y N 0\r\nMZdQ 85 78 N N 0\r\nNIrWcjt 81 95 Y N 0\r\nMQBfcr 85 80 Y N 0\r\nIXrLPdJhEekBRgsbkqI 95 85 Y Y 6\r\nMWAd 89 75 Y N 0\r\nBVYqUBdV 76 79 Y Y 0\r\nNhmSyMnvHxUkjye 79 90 Y N 0\r\nNUPyQqEhklWtWxeIz 80 95 Y N 0\r\nNsQbL 95 86 N N 0\r\nKEKFcpbDWQXUsQTXvFbs 95 95 N N 0\r\nZzjJWy 90 80 N Y 3\r\nTOWFblEWAuVgAxdHt 95 100 N N 0\r\nHRYFlarRQhe 100 90 N N 0\r\nSGUCaHJVg 95 87 Y Y 0\r\nCsNEZwUWERVFFxLsdyK 85 94 N N 0\r\nPZhrRpBMpm 80 85 Y N 0\r\nLsyePjMaoonOscyyUQY 82 98 Y Y 0\r\nSkPGcYDnYyIp 95 90 N N 0\r\nOaV 90 90 Y N 0\r\nW 75 90 Y N 0\r\nTJjZwq 85 75 Y Y 0\r\nPVFVBEocVjjpg 90 88 N N 0\r\nHMJecx 85 100 N Y 0\r\nPvgXSkNZQNcfJrgTzgm 90 75 N Y 0\r\nVnVXCwwJdbrusXG 89 95 Y N 0\r\nBNziq 95 76 Y Y 0\r\nMNjzTqMCtx 85 95 N N 0\r\nUihwjdZaUXWuMsytRtN 90 88 Y N 7\r\nHdXkkOHRQoG 93 85 Y N 0\r\nDHDAFValkXKFYjznnn 75 100 N N 0\r\nJskIgwiNH 85 85 Y N 0\r\nSeYSBFuVQaEUXwf 75 80 N Y 0\r\nXfGMOTDT 82 75 Y Y 0\r\nGnGatTgZBPgj 90 90 N N 0\r\nK 85 80 Y Y 0\r\nKRJVphYKwQTOMc 95 85 N N 0\r\nDFWtLGoFLXHptkI 75 92 N Y 0\r\nCayHZQXpTpyFPSuJz 87 76 N Y 0\r\nRRlRboFqAgLvzrJ 89 75 N Y 4\r\nDbWHykSi 85 84 N Y 0\r\nWQHneRqIh 90 82 Y N 0\r\nBhGejmW 90 93 Y N 0\r\nAFEEic 95 80 Y N 0\r\nMXhBgPj 96 98 Y Y 0\r\nWJsSWOCR 77 85 Y Y 0\r\nA 79 82 N N 0\r\nWy 95 85 Y Y 0\r\nOtgBaCKAVmMEFxPVcbE 84 75 N Y 0\r\nDnBaraTLVBkPJJj 85 75 Y N 0\r\nKzir 84 75 Y Y 0\r\nPxCMvWOdyZcRW 90 76 N N 0\r\nZcztKxXsrhqSDuxBeN 80 84 N Y 0\r\nEesxZKSACX 80 87 N N 0\r\nCvCT 75 85 N N 0\r\nUwrgH 76 80 Y N 0\r\nVwcGoYzhhVFWGyFzjdn 78 90 N N 0\r\nKQ 75 100 N Y 0\r\nMHJszTi 95 79 Y Y 0\r\nBPJXuWxsGGNYz 87 92 Y Y 5\r\nXWWpW 96 92 Y Y 6\r\nGKIdgeGTHWd 80 77 Y Y 0\r\nMeGS 88 75 N N 0\r\nSblEZfNCkGAkRSrzFADB 90 88 N Y 0\r\nBGLYzCxFVARuGu 87 75 N Y 0\r\nWMQkzgUafGBnqiuBgRpn 77 75 N Y 0\r\nLIWndzmjDozIMTu 80 94 N Y 0\r\nLsPuNFjIzCcppis 80 80 Y N 0\r\nJgycuqAJHELopIoZm 87 85 Y N 0\r\nUJmFKI 75 90 N N 0\r\nRdvGLr 95 85 Y Y 0\r\nWVsTKZHjDEc 90 85 N N 0\r\nVvtFQcwAErUIru 85 87 N Y 0\r\nJKTcYDOhBIJdTBG 94 85 Y N 0\r\nVJqtvLWNUdTEypjOCB 85 94 N Y 0\r\nET 80 80 N N 2', b'0', 'IXrLPdJhEekBRgsbkqI\r\n15850\r\n315050', 10),
(1001, 2, '100\r\nXODSnS 95 81 N N 5\r\nAmAM 95 87 Y N 0\r\nKjuUtQc 79 79 N Y 0\r\nCIKwP 80 95 N N 9\r\nXWINMqSzxcSwHu 90 90 N Y 0\r\nVmyNwsWNrzQzumpkYi 93 100 Y N 0\r\nJNyOUKq 95 97 N Y 0\r\nSbcPEILVKPtjJNI 95 95 N N 0\r\nHWlCiupwDIWsD 95 85 Y N 0\r\nUMaMMna 80 80 N Y 0\r\nFUGEOWMfgVlYlkQ 90 85 N N 0\r\nZECxJOwDbf 90 91 Y N 0\r\nULSdBWvpEoGyrriHXvB 80 89 N Y 0\r\nFdnaONSBrtoKpnLcOwQ 90 86 N N 0\r\nFcuXukEfTJaepfcVLGDo 90 88 N N 0\r\nE 91 80 Y Y 1\r\nWTTcx 99 95 Y Y 0\r\nCSuFsvUjAB 92 90 N N 0\r\nSpBFMARZU 90 86 N Y 0\r\nSJ 85 95 N N 0\r\nACBZClCVEY 80 80 N Y 0\r\nWbpifAcJsMvZsIuxPb 80 80 Y Y 0\r\nLglYGtexoUrlFtvCg 97 75 Y Y 0\r\nQurAslbu 95 85 Y Y 0\r\nCEykvNKWzMSYtFFZqGxB 94 89 N Y 0\r\nFUtuwRZqZGEBsetLG 75 90 N N 5\r\nNLlUN 90 95 Y N 0\r\nXkkZELIs 95 80 N N 0\r\nRLL 97 89 Y Y 0\r\nGzphmddzEKiHp 95 80 Y Y 0\r\nJqatUa 95 99 Y N 0\r\nTlckBkdqgu 88 76 Y N 0\r\nMsANXDtZCoYYKlxJyXxd 75 80 Y N 0\r\nNoUuxKxbhIE 80 95 Y Y 0\r\nWxiiIO 96 90 Y Y 0\r\nIAVsLoFQtsAAXIwkTF 98 99 N N 0\r\nJUCx 85 75 Y N 0\r\nVmJHYTcPKUoLTILytZM 85 78 N Y 0\r\nIGcbksHLMRlngsVqz 75 90 Y Y 4\r\nLrzHFThFFAasgfcZeuw 99 96 Y Y 0\r\nXQ 87 90 N Y 0\r\nS 90 100 Y Y 0\r\nBoN 75 75 Y N 0\r\nYTUXuruVhIaqN 87 80 Y N 0\r\nRZX 80 95 N Y 0\r\nLqQdXchxqHacFo 80 90 Y Y 0\r\nWenYJQMBPFHmut 85 80 Y N 0\r\nPAwecWyvQkikNfPV 92 80 Y N 6\r\nRkihOMXBLaHAcGkSdH 90 89 N Y 0\r\nDqIDtJrPa 94 95 N Y 0\r\nHssCJPipFFBNKqSTI 90 77 Y Y 0\r\nFvwYhmlFDwYLNGJo 76 95 N Y 0\r\nCktjdwA 87 85 N Y 2\r\nXqcLtILWrH 90 95 N Y 0\r\nWUWzuUt 85 80 Y Y 0\r\nITxsJXcGHC 90 94 Y N 0\r\nQawKYU 95 85 N N 0\r\nLXadSVqxcTbaP 93 94 Y N 0\r\nSqrSt 76 85 Y N 0\r\nYVpaVs 95 75 Y Y 7\r\nJI 95 90 N N 0\r\nOgYRmoSiNWVbSdocM 85 95 N Y 0\r\nYVCxaZPHiY 99 81 Y N 0\r\nBWqPJ 99 84 N Y 0\r\nXnBWuQdMh 93 85 N N 0\r\nEwKTLdQvmUJkdD 82 76 Y Y 0\r\nU 83 81 Y N 0\r\nApIwR 95 75 N N 0\r\nYFPeOIBN 99 97 Y N 0\r\nXJxUn 95 78 N Y 0\r\nYF 75 85 Y Y 0\r\nRMEpQYLSw 100 90 N Y 5\r\nTCIJOG 84 99 Y N 0\r\nFZXWWtgXTxSZFzDeSY 80 82 N Y 0\r\nWdxvfeOc 97 75 N Y 0\r\nSIlTmjkbHKqRirpOCAgq 84 90 N N 0\r\nHFjBUPtiaUxoZc 90 85 N Y 0\r\nSCxZrJjsfqHWYQf 85 94 Y N 0\r\nVhLeCMseuz 85 85 Y Y 0\r\nSDKqshkHjxs 75 98 Y N 0\r\nOZxC 95 80 Y Y 0\r\nU 87 75 N N 0\r\nPrSIkzb 80 77 Y Y 0\r\nUwmERlxVvWA 78 80 N N 0\r\nNSKbkCGjCf 75 85 N Y 0\r\nMriCgsUio 80 95 N Y 0\r\nZWRyHTJU 87 80 Y Y 0\r\nYoQBzJtKTZ 90 86 N N 0\r\nEGK 95 96 Y Y 0\r\nCYFVbgGoFwEhcgMTUw 95 90 N Y 0\r\nGrRWiR 85 80 N Y 0\r\nNYNlVNgO 95 75 Y Y 0\r\nNNRVpAF 85 89 N Y 0\r\nFMuTUqk 95 95 Y N 0\r\nPXD 85 95 N Y 0\r\nLyFr 99 100 Y Y 10\r\nOGLltVsbdriqDg 90 80 Y N 0\r\nScAWqkBXwtWz 90 95 Y Y 0\r\nEqgEwtbpSWwIWHxAN 94 80 N Y 0\r\nYmGW 97 85 N N 0\r\n', b'0', 'LyFr\r\n15850\r\n376500', 10),
(1001, 3, '100\r\nUFZOcQTBHjpwCMYn 90 95 Y Y 0\r\nKyrK 90 97 N N 0\r\nCysmgRwxDSNLpjrl 85 75 N Y 0\r\nELrEcHjXsUoiRd 76 93 Y N 0\r\nBJKXRcXMkoJGSfV 75 90 N N 0\r\nJlEaFDVDTdBUyQWax 80 85 N Y 0\r\nZCcbRRBkRfo 75 86 Y Y 8\r\nRkShJ 92 98 N N 0\r\nT 80 98 N N 0\r\nHGkgmL 90 96 Y Y 0\r\nLOlutboG 75 78 N N 0\r\nWPgpHocpVaFqHDsTqciN 80 75 N Y 0\r\nVPHEqLbNtBkYV 80 90 Y Y 0\r\nDHswaajQYBbZJeiqslc 97 93 N N 0\r\nZedpSTlOCjOSg 84 90 N Y 0\r\nDIJswe 90 75 Y Y 0\r\nCHPjh 90 87 Y Y 0\r\nQGdeyvvRut 99 75 Y N 0\r\nIB 85 90 N N 0\r\nAuCAAiPbUF 94 90 N N 0\r\nI 85 89 N Y 0\r\nUEGKE 93 85 Y N 0\r\nPyCqoFmtFcSItE 100 90 Y N 0\r\nPnrNRiqJ 75 95 N N 0\r\nTdtKaStTwPVWV 93 90 Y N 0\r\nX 88 76 Y N 0\r\nM 93 99 Y Y 0\r\nCS 79 93 Y N 0\r\nUAGVVOiUT 75 96 Y N 0\r\nPV 96 80 N Y 0\r\nVx 75 79 N Y 0\r\nBDgEmERNOmyX 91 75 Y N 0\r\nLJE 95 83 Y Y 0\r\nUIFGKBcTHsGxYANNHraq 85 89 Y N 0\r\nPTrTHHmcwH 85 75 Y N 0\r\nOgXBP 90 75 Y N 0\r\nWp 83 79 Y Y 0\r\nHDrhXVtEPAOR 83 75 N N 0\r\nLlpQK 80 90 Y N 0\r\nXqgkRUiFXMeWTSMIXae 95 90 Y N 0\r\nVxuemIoRgjUQe 93 93 N N 0\r\nUwS 90 76 Y N 0\r\nHOMNGhJfueorHMl 99 100 N Y 0\r\nHLawxZVlOg 80 99 N Y 0\r\nZTLejisS 80 79 Y Y 0\r\nCvvNscCnZVOiriPN 90 95 N N 0\r\nANyQeAqkYvGhFPCqWA 80 90 N Y 0\r\nUYBTL 80 85 N N 0\r\nDCBVl 82 95 N Y 0\r\nNdsOgK 76 75 N Y 0\r\nMFEuuuBChlMLjKO 90 88 N Y 0\r\nF 95 75 N N 0\r\nXMVNIZlUaUHaf 80 85 N Y 0\r\nBGTi 86 95 N Y 7\r\nTP 85 93 N Y 0\r\nTgLwEuo 85 83 Y N 0\r\nHHeXOMfgB 96 89 N Y 1\r\nDiymeUrkzGWyAJGJtm 76 100 N Y 6\r\nIfcRnqMJkslbJ 88 88 Y N 0\r\nXKYDCSfK 80 95 N N 0\r\nYO 90 92 Y Y 0\r\nZHFXiqnGIJY 75 80 Y N 0\r\nHUeQYggJJVpWayTyys 93 85 Y Y 0\r\nSnwoWt 80 92 N N 0\r\nZrKDpgLzzLRseYxwHFY 90 90 N N 0\r\nTJrFYWUrUTKp 75 82 N Y 0\r\nUkPbxhLAJPwJJgVU 97 88 N Y 0\r\nOTDoNRB 91 97 Y Y 0\r\nInnTSmiYxKKTfsUbn 80 75 Y N 0\r\nRXsvpaqbPjLXBlNaVrc 90 90 Y N 0\r\nNSBzurUwDWbAYHY 83 98 N Y 0\r\nWSTUbidxKesLHEJd 90 99 N Y 0\r\nVDKrj 100 94 N Y 0\r\nSdTmfCQEuOZ 95 82 N N 2\r\nVmKkpQPBwp 75 90 Y N 0\r\nHsZoSIMOmMxJKQl 80 80 N Y 0\r\nYLnnpg 95 87 Y N 0\r\nNZEUZGLRZCkYvb 90 90 Y Y 0\r\nUM 90 95 N Y 0\r\nTqLUjeKMZ 85 97 Y N 0\r\nMD 80 95 Y N 0\r\nYCKUZhGAAXAUZu 92 90 N Y 0\r\nTeeApAXcvDbCxqGbRbsX 85 85 N Y 0\r\nSWKpTiwqleAkXZisYF 87 92 N N 0\r\nJOuZVAqcd 88 95 N N 0\r\nAGcOK 86 89 N Y 0\r\nFtDLkGP 95 93 Y Y 0\r\nKH 83 89 N N 0\r\nTzXvxeEF 90 88 N Y 0\r\nYgQsmqAometSIsgT 84 75 Y Y 0\r\nFLglQZOCYBjbeJFEpf 100 86 Y Y 0\r\nCq 80 95 N N 0\r\nLM 90 88 N N 0\r\nRj 77 95 N N 0\r\nWdDRjsOnJ 85 95 Y Y 0\r\nBAf 88 85 N Y 0\r\nX 91 85 N N 0\r\nMfhcDIwTiiCR 95 94 Y Y 0\r\nYGxZUsVuOSVpGSAn 87 98 Y N 0\r\nTkcTzncqZDENcPOL 89 90 N N 0', b'0', 'HHeXOMfgB\r\n15000\r\n311200', 10),
(1001, 4, '100\r\nPbc 86 85 Y N 0\r\nHXekOchIacYeRpNpqxi 75 78 N Y 0\r\nVMFuCwR 76 94 Y N 0\r\nRFESPRSwimdNOupwD 80 95 Y Y 0\r\nAkibXDoYjl 90 85 N Y 0\r\nMiwTLxayOFxAjBViRCE 86 100 N N 0\r\nTrbOXCPmjbSY 95 83 Y N 0\r\nHAAd 97 85 N N 0\r\nLZWnJ 84 75 Y N 0\r\nXRZJiIM 75 98 Y Y 9\r\nIwyd 88 89 Y N 0\r\nSgzbizBGhc 85 85 Y Y 6\r\nOFWSciGYcyCvtllNPNl 80 95 N N 0\r\nIJLZmDJulOjSTOr 85 100 N Y 0\r\nIlB 91 96 N N 8\r\nSIu 80 88 N Y 0\r\nDkhOUqwZdT 85 95 Y N 0\r\nPjXKeUUW 95 84 N N 0\r\nVmQSKvueLmRedNUMHcLO 98 75 N Y 0\r\nBXJTdaZZlsbMaa 77 80 Y Y 0\r\nJsGVsFwcu 86 85 Y N 0\r\nOvNXiblcXgTVnI 77 92 N N 0\r\nSMfFDgoG 94 93 N N 0\r\nUKkFkFNtXIzWzkPTN 95 80 N Y 0\r\nSvjEjgBcHBTRa 75 90 Y Y 0\r\nSRUoWwMmFLC 95 75 Y Y 7\r\nRqJlWkCzrahlfQTl 78 90 Y N 0\r\nXM 83 95 N N 0\r\nDZGYKrDvBa 88 94 N Y 0\r\nJMWOjjgNEtdAuFJZxkVL 75 80 Y N 0\r\nRjVuxQkpbvImBSv 89 93 N N 0\r\nShRFbbvWZNN 90 75 Y N 0\r\nBtqngENjocSpxAuZlcst 94 85 Y N 0\r\nJKGnBehLBdPB 91 90 Y Y 0\r\nCxDMfiuHactmHL 85 77 Y N 0\r\nFyMCeegreCzeGiF 80 82 Y N 0\r\nMUmmSFNEqPuGrVMJV 94 100 Y Y 0\r\nESiXBieIwXjES 85 79 Y Y 0\r\nLbEUGjSHXFqNr 80 90 N N 0\r\nBNboso 99 87 N Y 0\r\nUGRLkihagF 75 95 Y N 0\r\nJgbbaZAhFzAWWU 76 90 N Y 8\r\nFLiHlZanTCruAiLek 96 86 N N 0\r\nBbCPScsCTdaDmgWuh 94 91 Y N 0\r\nSYWHdiAzRWdckWd 80 85 Y Y 0\r\nEvwptbmXArCR 95 95 N Y 0\r\nRY 98 92 Y Y 0\r\nGQUtOFJUR 95 97 N Y 0\r\nIHgVC 95 90 Y N 0\r\nJoVSgwUKMJfBOWnR 77 80 Y Y 0\r\nWThogBEIlxzGg 76 78 N Y 0\r\nPTjePsyUXzHULWtBvxzD 79 85 N N 0\r\nPykCKPyIye 84 96 Y N 0\r\nVWKNHlIUETsruuMFymJ 75 83 N N 0\r\nXVjgfdnPfWCoQLtskHG 95 90 Y N 0\r\nFLxTWlReygXsMQOi 90 95 Y N 0\r\nVSSIBzTVdqEjb 85 83 N Y 0\r\nICfTwPOuTpJIBcuPM 79 80 Y Y 0\r\nLIfnfxyFAilueGsiXbK 100 90 N Y 0\r\nILwZpBDiuoMhXwswxgEe 91 99 N N 0\r\nHgHAeuBIcJ 91 75 Y Y 7\r\nMLB 100 84 Y N 0\r\nG 90 80 N N 0\r\nRoTyLtQwejye 80 75 N N 10\r\nPjrf 93 84 Y Y 0\r\nMQrpSTxSdjQAq 93 75 N Y 8\r\nZyejTNiikWWHHyhI 97 92 Y N 0\r\nZNUegFN 95 85 N N 0\r\nC 90 78 N N 0\r\nBIccuOyGTp 88 95 N Y 0\r\nZmHNvOxTWUMjd 90 77 N Y 0\r\nSKMaiZvuWvgEdMmzzDZ 80 90 N Y 6\r\nNqaUtbTiXhp 80 99 N Y 0\r\nTLujwKJIHAPslBSjXPF 80 75 Y N 0\r\nOnIIxittrvwrLXOg 78 78 Y N 6\r\nGeqn 77 75 N Y 0\r\nEdwUkyV 75 90 N Y 0\r\nY 82 78 N Y 0\r\nDrhUzffpm 90 88 N Y 0\r\nFeYbszANUnub 79 77 N N 0\r\nBxELfghqaNDhRG 80 94 N Y 0\r\nJbfWtaM 85 91 N Y 0\r\nFAIUHwUVMgvkWXVaBdV 94 90 N N 0\r\nDqQlBCPHLF 94 80 Y N 0\r\nQavAC 75 98 Y N 0\r\nSwkfKqtTG 80 80 Y Y 0\r\nZhCIZAGyhajH 88 91 Y Y 0\r\nLZ 84 78 Y N 0\r\nHUXJFQzmIhfFR 89 80 N Y 0\r\nJEavDBAzVy 93 86 Y N 0\r\nCNpKdOcj 87 78 N N 0\r\nYjaRmeRbQQ 88 86 Y Y 2\r\nHfLkfcP 98 80 Y N 0\r\nIuzgXQyhMgghbM 94 85 Y N 0\r\nUwPRvymKaTxLhXPLgS 87 95 Y N 0\r\nAsqWOw 85 91 Y N 0\r\nUcrOLkHfk 77 75 Y Y 0\r\nLMQGBivsyG 89 80 N Y 0\r\nLYfhBBKEvv 92 96 N N 0\r\nEKwHlSMSICqMs 79 75 Y N 0', b'0', 'IlB\r\n14000\r\n320050', 10),
(1001, 5, '100\r\nRDVRyo 75 89 N N 0\r\nNbLorLPWFust 75 85 N Y 0\r\nPYjzHwP 99 94 Y Y 0\r\nFcfubnlnNNUPGQQks 80 83 Y N 0\r\nHlkyMwOyDtQ 90 85 Y N 0\r\nYULUAHWXNXglhEOpu 90 95 N N 0\r\nUVrGVYXgSay 87 89 Y Y 0\r\nN 82 75 Y N 0\r\nCiZdpzk 85 92 Y N 0\r\nYGoIYPAaUZB 75 95 Y N 0\r\nVsULAuYGLRJTn 97 77 Y N 0\r\nEdOairN 80 90 Y N 0\r\nQidSkeNNiZuEQMSS 95 87 N N 0\r\nCkeyipoORDPVzh 90 85 N Y 0\r\nS 86 95 Y N 0\r\nRsk 90 95 Y Y 0\r\nJoUxXo 75 85 Y N 0\r\nVEyWcKmMwEECmXUUiN 99 85 N N 0\r\nEgYwAo 75 90 Y Y 0\r\nPCPoQWeo 79 95 Y Y 6\r\nPDhTYMyNDvkr 80 75 N N 0\r\nFGeahCxoC 80 98 Y N 0\r\nGwmWBkiqsKZQmm 85 95 Y Y 0\r\nOzlKFaZupcVfJeH 80 80 N Y 0\r\nWPovsYBSwhEKRpsaPzA 93 75 N Y 0\r\nSjHddMMKtLE 91 95 Y N 0\r\nIb 80 90 Y N 0\r\nEgZA 89 80 Y N 1\r\nHJxEs 96 75 Y N 0\r\nRqhYuUtNieNUnsvhaH 92 85 N N 2\r\nRdolbbFE 95 85 N Y 0\r\nAgJKkdhVMwNueyuhMi 92 91 Y N 0\r\nMOdkuwdyuvUuKZnD 85 89 N N 0\r\nFIOpJgZoWKpCo 82 98 N Y 0\r\nLAzGkTsTKZuWcpWx 95 85 Y Y 0\r\nBGbeVtkPhUzRVPddWi 98 76 Y N 0\r\nEifucsMhQovhiHzmYrd 75 90 N N 0\r\nASwu 96 80 Y N 0\r\nAAWCaBffGJongVqwkk 76 80 Y Y 0\r\nNFcgTeyT 99 85 Y N 9\r\nDGMqW 95 100 N Y 3\r\nNmPsTEYOkY 81 80 Y Y 0\r\nKylj 95 85 Y Y 0\r\nMKEamibK 97 95 N N 0\r\nSfXlWCEcosb 95 90 N N 0\r\nMShPPnQtdnIYWCJJF 95 85 Y Y 0\r\nBxQVYzQuOtoC 85 80 N N 0\r\nOAoQGn 92 81 Y N 0\r\nHHzpC 81 88 N N 8\r\nQOXBqRdnYAs 85 95 Y Y 0\r\nVjvQGFcMjvXTSDK 95 81 Y N 0\r\nAzlksTEIhMRSJRhxy 89 75 N Y 0\r\nPrFscCCSRZFQ 84 88 Y N 0\r\nTtahPgzMrPvncCsOMMzp 90 100 N N 0\r\nPKVULSvBNLSDlQ 90 90 N Y 0\r\nAVEtFUveYxcnPfOXfHI 80 92 N N 0\r\nNmBWPsDTtvDlAt 100 80 N N 0\r\nF 80 81 Y N 0\r\nRqHsLEooY 80 90 N N 0\r\nPtOLgkhcR 85 80 N Y 0\r\nPLOHK 94 90 N N 0\r\nP 82 75 N N 7\r\nUmciCWoyT 80 78 Y Y 0\r\nGAWDweGDYskHnQk 90 100 Y N 0\r\nIJE 81 83 Y Y 0\r\nOnVFuxevWzTDA 93 86 Y N 0\r\nAHrHvyaPCfsVNmDIWWo 86 91 N Y 6\r\nKCBSLlcfJyAPBj 85 75 Y Y 0\r\nQawOMDkeJlormRnhe 90 81 Y N 0\r\nOT 90 98 Y N 0\r\nBYaPLabeEVwtrB 88 82 N Y 0\r\nVamAq 85 89 Y N 0\r\nVTiUA 95 80 N N 0\r\nSSNkaLdkxmAtP 85 95 N N 0\r\nOJB 98 91 N N 0\r\nLIqQalcebHdzj 75 96 Y Y 10\r\nWKlGLytTd 95 89 N Y 0\r\nPIXhCtLSMoCCA 96 80 Y Y 0\r\nULzmzuqKLBoAFtK 80 80 N N 0\r\nZnlCehX 77 77 Y N 0\r\nCEjxxKKGDf 90 90 N Y 0\r\nHvpDIKdEiUzWvt 90 81 Y N 0\r\nTlMuWvRTlNj 97 75 N N 8\r\nYIFvifAtXjyvDF 76 97 Y N 0\r\nMtCNoAEoqOJPv 95 90 N Y 0\r\nKflCVSqbOBK 90 81 Y Y 0\r\nFc 91 85 N Y 0\r\nXpWdeRA 89 76 Y Y 0\r\nOorwfyqXYbZjrTpclNF 84 95 N Y 0\r\nUoysYXmlvO 81 95 Y N 0\r\nAMlBgQfD 80 97 N Y 0\r\nUpOkXMuyURCCRaoCw 80 80 N N 1\r\nFtIeDqx 98 90 Y Y 0\r\nCiVc 75 95 Y Y 0\r\nBdKO 75 75 Y Y 0\r\nNhDwAd 80 85 Y N 0\r\nKUTLEFlaYoIojUVk 96 81 Y N 0\r\nCBEsPPZB 75 75 Y N 0\r\nJvE 76 93 Y Y 0\r\nCgjkSvcwDthjnprSHxx 95 75 Y Y 0', b'0', 'DGMqW\r\n15000\r\n350700', 10),
(1001, 6, '100\r\nMzYCufzWJkGT 95 90 N Y 0\r\nKYmIQs 80 85 N Y 0\r\nNVufr 95 94 N N 0\r\nJmhCuEFOUoKgI 75 88 N N 0\r\nKyRmZdbJMfYTzbZS 78 90 Y Y 0\r\nESBjuYJuibPovnKCdyQ 95 77 Y N 0\r\nSfKyrATJa 90 85 N N 0\r\nJpPNv 80 85 N N 0\r\nQLXkCluFcKh 85 75 N Y 0\r\nTfYqUD 90 85 N N 0\r\nFAyWTFfabq 80 95 Y N 0\r\nRktoKBKAm 90 83 Y N 0\r\nFNdCECSt 95 81 Y N 2\r\nKsHzrelGZguPwheHhw 79 80 Y Y 0\r\nFprWTbg 90 95 N N 0\r\nSgXaGDAruSFH 90 75 N Y 0\r\nIw 79 92 Y N 0\r\nAj 96 75 N Y 0\r\nGRXyYlVokmXU 85 80 N N 0\r\nXYhTEVBhVhGbtlEEDapv 96 95 Y N 0\r\nMIcOWomeJ 90 75 N N 0\r\nAicIWqZoiKLlExLgYq 75 77 N Y 0\r\nMpThDPKOTcuHdAsCOj 88 75 N Y 0\r\nJhHKDBmYwDjI 90 75 Y N 0\r\nPZIp 89 78 Y Y 0\r\nKGrTUPBKfHiGdkhDyp 79 99 N Y 0\r\nIVzqVKMUtMEMNMhDZoC 77 95 Y Y 1\r\nUH 95 76 Y Y 0\r\nHZaQTPJAIDfxlBWa 97 95 N Y 0\r\nOYqqFxNEKi 92 93 Y Y 0\r\nYEIGXpWWAVdjYliI 75 95 N N 0\r\nKiEZUReyFC 76 96 N N 0\r\nAKVxHnqsq 100 84 Y N 0\r\nNeynYn 80 100 Y Y 0\r\nMGYvGdJtzgDQMJbKiqi 90 91 N Y 0\r\nCJxNdGRvszHMJ 90 100 N Y 0\r\nQaW 84 90 N Y 0\r\nYVJbiEvWMhkmwpk 95 75 N N 0\r\nJgGIdXehJoJXBFEZ 79 85 N N 0\r\nHgdZeHAia 90 95 N N 0\r\nKVRKybLWtgvMO 90 79 Y N 0\r\nFqQiwCWcYwwJFRTzs 83 81 Y Y 0\r\nExHBuhysmTCImTNM 95 85 N Y 0\r\nVRPKYyLs 90 95 Y N 0\r\nWRhPbCFTEGoIsYJ 95 85 Y Y 0\r\nYJrRSaXAyCFXthWKXb 95 90 N Y 0\r\nLSGZRyroxESqlTDLPygW 75 84 N Y 0\r\nOAzBzPhGwXBbXyceKAh 75 79 N N 0\r\nMRcf 78 75 N N 0\r\nPnocRXHxa 90 94 N N 0\r\nDSrYGnQkbkaJEj 89 83 Y Y 0\r\nMDNbsqgFkkNJcKSMltgt 92 79 N N 0\r\nXQjtBfngEEWlCWkDmWxs 99 85 N Y 0\r\nLWxGGzcULfdYz 83 91 N N 0\r\nXkkjQEZvHuxmj 80 100 Y N 0\r\nQHorTyeoyv 95 85 Y Y 0\r\nXhKjVOvliOE 95 95 N N 0\r\nHsbIENhJzHBIybuib 81 80 N N 0\r\nEx 80 83 N Y 0\r\nKOHSxFDkI 95 80 N Y 2\r\nDNiRiR 85 76 N Y 0\r\nTyyWUjDkDzrvlJxhdu 89 95 N Y 0\r\nMnadQyg 85 95 Y N 0\r\nAEhHsxsQNLlzX 89 75 N Y 0\r\nQlbGWGQiLuXQwjQdXjqw 95 91 N Y 0\r\nYeacrY 78 85 N N 0\r\nAYwyiyCg 87 95 Y N 0\r\nAIrEnhkkiMRCw 93 96 Y N 0\r\nAlerTviL 100 75 N Y 1\r\nQa 80 90 N Y 0\r\nEL 88 80 N Y 0\r\nHZhEUJKFapBYiXrIBmLl 95 80 N N 0\r\nPVTrtVL 75 85 Y N 0\r\nCrUuGaAAWY 91 80 Y Y 0\r\nF 98 90 N Y 10\r\nEDzMsdUoHZRbm 92 86 Y N 0\r\nSWgAnBqjdspqimqSnIe 80 79 N N 0\r\nTiywblZKQxphP 95 75 N N 0\r\nAbVxejWeLkARSHS 90 90 N N 0\r\nBTSNYgaM 90 85 Y N 0\r\nIBKYOiYOx 90 95 Y Y 0\r\nGkkFOl 84 96 Y N 0\r\nOfWoBlbIdoxZiFQTDqb 92 90 N N 0\r\nKjLfr 80 90 Y N 0\r\nDQ 80 80 Y Y 0\r\nVHdwANLLL 97 93 Y Y 0\r\nXZgHcNSvCmhsYr 95 87 N Y 0\r\nLglligckY 88 95 N N 0\r\nGWamLFvttqLvqYEk 75 91 Y Y 0\r\nBkIcJbGaqMsx 80 91 N N 0\r\nVzpyHxfHMkWKGLmKmBD 90 88 N N 0\r\nRnNNqDfDPe 98 90 N Y 0\r\nWKUwbrZUPSlemyHnG 95 77 N Y 0\r\nUuPiJyTrZldgFC 95 86 N N 0\r\nOINCIjHytMtjypLS 89 85 N N 0\r\nXPmwFEm 75 94 Y N 0\r\nXuop 80 75 Y Y 0\r\nXdwaEcQOwXmIvDeVFn 90 85 Y Y 0\r\nXyYOt 95 96 N Y 0\r\nOpiGinpQf 86 80 N Y 0', b'0', 'F\r\n15000\r\n324650', 10),
(1001, 7, '100\r\nPUQUnnMCvvifcYKS 91 81 N N 0\r\nLKmTZKyzAogY 96 99 Y N 1\r\nHxgsRNdLJzcPYIi 82 92 N Y 2\r\nAjpLBYCvsxjmqY 95 91 N Y 0\r\nTqihhV 85 83 Y Y 6\r\nHRC 89 80 N N 0\r\nH 100 85 Y Y 0\r\nNixtCBiobBBcOxbGmJ 79 95 Y N 0\r\nXq 75 81 Y Y 0\r\nETtrHHnqiLdpwQKei 81 94 N Y 0\r\nNYL 95 75 Y N 0\r\nXUBCvg 95 88 Y N 0\r\nKsoPUD 90 84 N N 0\r\nXeeiHfsVEaqQrbtHlSb 90 75 Y Y 0\r\nUCUUW 98 80 N N 0\r\nARz 75 95 N N 1\r\nLRiaFqnoGFWLYokaNauW 81 91 N Y 0\r\nHyrqIxzusfvxXQ 92 95 Y N 0\r\nZugb 84 85 Y N 0\r\nHuECLLgDZETrNuxx 90 95 Y Y 0\r\nGMUeTHqzlB 94 75 Y Y 0\r\nWcaiZXCiTYUJjeUhIxz 95 92 N N 0\r\nChPCIEoAYbPSTwqUTy 98 75 N Y 0\r\nSTnIrpcGfyuqKlop 92 91 Y Y 0\r\nMhvuI 95 95 N N 0\r\nJJjOVCtL 90 99 Y Y 0\r\nQ 97 77 Y N 0\r\nVCbsLD 95 94 Y N 0\r\nWGtaOifRd 90 76 Y N 0\r\nErCwyPRnxvZaeXzyqC 80 99 Y Y 0\r\nF 80 76 Y N 0\r\nEqWWrL 87 100 N Y 4\r\nCW 95 80 Y Y 0\r\nTZYiouTkHas 75 75 Y Y 0\r\nYBqilxkGZJx 94 100 N Y 8\r\nZhQ 85 86 N N 0\r\nVqVOGkunHXMjzFhKT 82 84 Y N 0\r\nYgjIMJvrSwpjyBt 85 80 N N 0\r\nNSIjGAPKYLIb 98 85 Y Y 0\r\nPmqLFEWIgBblJnAxKmE 75 99 Y Y 0\r\nGCJlSsKJXzHCzIt 80 90 N Y 0\r\nChMGtPHhjP 97 95 N N 0\r\nUERuLLCJbpvr 75 97 Y N 0\r\nIHfRyvenjUNvZ 85 75 N N 0\r\nHrysA 86 95 Y N 0\r\nEeoJjO 88 84 N Y 0\r\nGdZaBCPYUdUa 89 85 N Y 0\r\nMKeeBYun 99 93 N Y 0\r\nSl 95 75 N Y 10\r\nKLaTAxVp 92 86 Y Y 0\r\nMaNkrMVOIxjJiYZX 80 83 Y N 0\r\nLUOedeGTBheXtSdL 91 86 N N 0\r\nQuektgzYapx 90 77 N N 0\r\nHdqsc 85 85 Y N 0\r\nEB 85 80 N Y 0\r\nDBGfXvy 95 96 Y N 0\r\nRiIQjTwl 80 81 N Y 0\r\nAyOs 85 98 Y N 0\r\nOtqaipehLnhnxXnBkx 75 90 Y Y 0\r\nOA 81 88 Y N 0\r\nT 98 92 N N 0\r\nDDYefzXNngYeeueBH 90 95 Y Y 0\r\nCOwFGmydoBP 87 75 N Y 0\r\nTMkfvMdaChWfbREF 90 75 N Y 0\r\nMurkdxrRZWbCmvOTPvX 80 99 Y Y 0\r\nCHOp 77 80 Y Y 0\r\nXaCeksUvjVYoTDDlA 95 85 N N 0\r\nQjiNbZXtTKPMqKDfC 99 90 Y N 0\r\nIRtjKjVZYFGo 95 95 Y Y 0\r\nI 80 79 N N 0\r\nBhcbBj 90 80 Y Y 0\r\nScTyrOqPI 85 91 N Y 0\r\nQvT 95 80 N N 0\r\nNtVJkwJ 85 78 Y N 0\r\nMfhGppwKNPRNMJ 75 85 Y Y 0\r\nAqjRLvrFzTTOd 88 99 N N 0\r\nVyPhUiVNUrlIKJGTIJMV 78 85 N N 0\r\nDSIhYSkoGUPvJlBWCPs 97 85 N N 0\r\nVAHle 92 87 Y Y 0\r\nIzCSMnowRthplqftD 91 100 Y N 0\r\nVOnGdpBBBeMJFP 76 80 N Y 0\r\nHZRPVHGQ 90 85 N N 0\r\nVjRxopMjUjh 95 88 Y N 0\r\nF 93 90 Y N 4\r\nKDIiqBJvyVKmYK 79 78 Y Y 0\r\nVjbvWqtedXaCIlkFa 83 85 Y N 10\r\nAzSQFau 92 99 Y N 0\r\nVo 85 98 N N 0\r\nRr 91 94 N N 0\r\nNwJjjFhgc 91 90 Y Y 0\r\nVjrlhAGmIK 85 82 Y Y 0\r\nR 80 90 N Y 0\r\nWFiVNPPGtLyYutaXuP 93 97 N N 0\r\nVE 90 98 Y Y 0\r\nJkMtq 75 85 N Y 0\r\nKnCvGPSsFGvSy 80 79 Y N 0\r\nZjNuJifeLfDCp 88 94 N N 0\r\nSSkVniNxsPaduyghLQFq 75 99 N N 0\r\nPW 78 76 N Y 0\r\nPCvt 81 80 Y N 0', b'0', 'YBqilxkGZJx\r\n15000\r\n366150', 10),
(1001, 8, '100\r\nZWbnpvRIZYJkleTdfZm 75 82 N N 0\r\nBVfxDT 85 99 Y N 0\r\nXPigvuqORPVhH 75 97 Y Y 0\r\nDRbWXUfI 86 95 N Y 0\r\nQrdEmydUhZmVaZKHPlY 80 90 N Y 0\r\nR 80 83 Y Y 7\r\nMXJurXEyZkLbB 80 95 N N 0\r\nHQNyPigyvBddctC 95 90 N Y 0\r\nSrYvKdTfbO 95 90 Y N 0\r\nXEpMyTjZHx 75 85 N Y 0\r\nVhxFByGDdjU 82 79 N Y 0\r\nTSJF 75 85 Y N 0\r\nRaNxtaKTFUH 75 85 N N 0\r\nQ 85 90 Y Y 0\r\nSNdToBHYhIODk 95 80 N N 0\r\nZUFXPiUqfVJOjec 90 95 N Y 0\r\nTtPGxHTxSksAeChr 97 85 Y N 0\r\nTBjcMyfnmOTAFRBAy 80 95 Y N 0\r\nNeNNKuGPA 85 85 Y Y 0\r\nRjpJU 90 100 N N 0\r\nHdpCfN 96 78 Y N 0\r\nMryDEMkOfqwSYEMDzvw 84 93 Y N 0\r\nQJSTGG 85 75 N N 0\r\nOpG 75 95 Y Y 0\r\nOKvIUnohvvH 85 90 Y Y 0\r\nUvIkrDvw 85 95 Y Y 0\r\nDK 97 80 Y Y 0\r\nZhFBfNI 93 87 Y Y 0\r\nCLjLchtBYEq 95 87 N Y 0\r\nPZcwNuqupy 81 81 N Y 0\r\nSeRxDAjSxRXhmAMkv 79 85 N N 0\r\nVZVMSMwqGlJdsuE 92 90 N N 0\r\nDdYSFBVugwKUAnE 95 98 N N 0\r\nTsvFTlmekL 75 80 N N 0\r\nUvTUZWkSvmjUPDaAZ 90 90 N N 0\r\nVSfPolWPavDhmQOxy 90 95 Y Y 0\r\nXcHhLlwHNBaLqHuHZ 75 90 N N 0\r\nHccBNvJEZuRnmCAmnl 97 98 Y N 0\r\nQTclkTMhvcYKu 97 80 N Y 0\r\nNMZzGNgKSOeHzp 81 88 N N 0\r\nNJnMAanjfVGpATmqvIag 86 88 N N 0\r\nHcwqojkcroWJ 95 96 N Y 0\r\nSRSPS 80 93 N N 0\r\nQIN 86 75 N Y 0\r\nQSnylWCLeY 90 75 Y Y 0\r\nZqs 93 95 Y N 0\r\nIaKMvvyXhEKcQU 83 80 N Y 0\r\nSSqCmnqe 85 85 Y N 0\r\nRaC 90 85 N N 1\r\nCutGiRlbfFVfvWyQFsJb 84 78 N Y 0\r\nYtUHmp 95 80 N Y 0\r\nBoPq 77 79 Y N 0\r\nIjGxHLRfNh 85 100 Y N 0\r\nJQjnglSiKkryCRc 75 95 N N 0\r\nONNkxDOOSxCDRLMCpSI 75 78 N N 0\r\nJcxvkDlcaYc 75 90 Y Y 0\r\nURQFG 77 99 N Y 0\r\nFLPwNKHXCJLGEDmn 95 90 N Y 0\r\nWtFhHtPBSKAMEm 90 98 Y N 0\r\nLJwcvOIxhEWnJ 86 76 Y N 0\r\nEeXUIRXVjmVNogOKVaPm 90 90 Y N 0\r\nGqcqbIczEZg 75 85 N N 0\r\nBtjChcni 90 75 N N 0\r\nGqsbbvwAF 90 90 N N 8\r\nMRmnXO 85 89 N Y 0\r\nHfewNyVImElyIwmRTA 85 95 N Y 0\r\nSu 88 89 N N 0\r\nKpPSkwPpNumfAi 83 95 Y Y 0\r\nZuFVrVdRbSgmvTcUZnG 95 75 Y N 0\r\nZYyzaxtXDzc 82 98 Y N 0\r\nM 91 76 N N 0\r\nGY 97 76 N Y 0\r\nKscrXVVGlmvGJwEpOu 100 85 Y N 0\r\nSGuJtFLvQSYXRFnKSpgp 95 92 Y Y 0\r\nPgcCsHapGTMxIbnht 78 98 N N 0\r\nSJyYQactcQMZWim 78 79 N N 0\r\nH 80 90 N N 0\r\nBBsRJ 85 96 N Y 0\r\nBmCoJUxz 94 78 Y Y 0\r\nPritVvHvQlR 76 75 Y N 0\r\nLjgYEUOcYiQTQaHn 87 75 Y Y 3\r\nJKbXgdHfyHtLdaBXLr 95 95 Y Y 0\r\nVLrJ 76 92 Y Y 0\r\nAKeSImMMnPWwfSeK 95 80 N Y 0\r\nBpmnb 75 90 Y Y 0\r\nCqfG 77 94 N Y 0\r\nIAJwwwJZ 81 85 Y N 0\r\nJOjgjtFkg 90 82 N N 0\r\nSfAXhmimdeALjlt 99 75 Y Y 6\r\nHFcmLIAAaLkmuBcgMPD 80 93 Y Y 0\r\nYRlYpPUpiypnNUv 85 90 Y N 0\r\nYcan 83 95 N Y 0\r\nQKppcgDSmUA 85 91 N N 0\r\nCPENHMuOf 84 95 Y Y 0\r\nHEnizmxQ 95 98 N N 0\r\nFPkNNyBfI 77 99 N N 0\r\nTzQtxShKSIjFIudklVwu 85 80 Y Y 0\r\nYLZXyeAtPtHtbw 95 91 Y Y 0\r\nWJnALOhkMQdEuUwU 76 90 Y N 0\r\nEoZKcSVHWSIWCPCPvog 75 90 Y N 0', b'0', 'RaC\r\n12000\r\n249600', 10),
(1001, 9, '100\r\nMKMqK 80 85 N Y 9\r\nIEctzCZvnQfICWIWfFLK 90 95 N N 0\r\nHNWIrMeY 85 85 Y Y 0\r\nMoZJrC 91 80 Y Y 0\r\nCUpsuWtkkZxrSzTDWrm 85 88 N N 0\r\nVg 94 80 N N 0\r\nBxaxLJ 75 90 N N 0\r\nWtEEnIDxjkneYioJpF 93 94 Y Y 5\r\nQoZgkEptZbbFk 95 87 N N 0\r\nPFSfksEGAiOjyR 90 90 Y N 0\r\nKOtiQAqJCEEJBsLjXX 75 90 N N 0\r\nKVFasFCnYY 97 75 N N 0\r\nDZCdrd 83 75 N N 0\r\nRmkPy 85 99 N Y 0\r\nADDOawMkUzfyond 85 96 N Y 0\r\nJ 90 96 N Y 0\r\nDGrJZNnXAds 90 88 Y N 0\r\nPSVlyQusCz 94 78 N Y 0\r\nFKiFCuIaYyDAKdQExP 94 90 Y Y 0\r\nKucq 76 85 Y Y 0\r\nJrx 92 95 N Y 0\r\nJdcUlJdLFVrWcHfD 99 92 N N 4\r\nHJejNlqlfl 90 90 N Y 0\r\nLCgqJrxtdY 80 90 Y Y 0\r\nVCKSpIfUFQN 100 85 Y Y 0\r\nCMlgGZfTJhMaMBD 85 99 Y N 2\r\nRgOFv 98 95 N Y 0\r\nImyBlcqYSohDrBKgWiOw 90 95 N N 0\r\nPLpRbrJLBpXl 87 95 N N 0\r\nVmOasxKQxuHvRRgmVxm 80 75 N N 8\r\nEtAl 85 95 N Y 0\r\nZxMxbZm 78 80 Y N 0\r\nCekNC 94 100 Y N 0\r\nPHjh 87 79 Y Y 7\r\nFu 92 100 N N 0\r\nXwYL 95 84 Y Y 0\r\nJ 100 90 Y Y 0\r\nUziOofGKg 99 94 N N 0\r\nGcAmlDYFVvkobDieO 77 95 N Y 0\r\nFAb 97 86 N N 0\r\nChLpjgcLIMLp 80 75 Y Y 0\r\nApGVbsaDCJVukBIQ 85 81 Y N 0\r\nWc 97 100 N Y 0\r\nImncIeHTwzypTiIWBQ 98 75 N N 0\r\nXPVYyk 75 89 N N 0\r\nNHZHmRKwXI 83 75 Y N 0\r\nDM 80 90 Y Y 7\r\nLppcqQrCLRjIHkiLEd 90 90 N N 0\r\nRPHGSuNaoztGZko 85 82 N N 0\r\nDddqWQQVAwxikNNoeW 91 89 Y N 0\r\nBFTaoWzkuyQB 85 94 N N 0\r\nHhdIKYirH 75 95 Y Y 0\r\nHlRqHOVjZiN 99 99 Y N 1\r\nB 95 85 N N 9\r\nJDN 85 94 Y N 0\r\nTcfXiQglK 94 80 N N 0\r\nDwDymNFtG 80 94 N N 0\r\nCPnnwCCp 79 80 Y Y 0\r\nLruJDUoaoyJyVtlmdZv 95 90 Y N 2\r\nPfIKvfDcaZgxWxcjewFl 75 83 N N 5\r\nWq 85 76 N N 0\r\nU 86 82 N N 9\r\nPiDmsTZrF 95 100 Y Y 0\r\nQtNrVowRKOClYv 85 90 N Y 0\r\nJfOn 87 84 N N 0\r\nD 100 85 Y N 0\r\nLRluUVRvG 75 85 N Y 0\r\nUVntkIi 89 90 Y Y 0\r\nUprSnqkHtcVisKhrNuM 81 85 N Y 0\r\nMyIbmxZNtgB 89 94 N Y 0\r\nSuCabMtfwvockNPuF 85 93 Y Y 0\r\nX 95 90 Y N 0\r\nBsXnpODR 75 95 N N 0\r\nUCXOghcRLaAegXrsi 90 90 N Y 0\r\nI 80 84 Y Y 0\r\nVbWcKcOTKW 96 84 N Y 0\r\nXCXXIhzBuhAkCICuCQx 75 77 N Y 0\r\nCZYFXfEtrmuvynE 80 83 Y N 0\r\nOOimvkjsv 95 84 N N 0\r\nHnrDJfnYUhNv 75 80 Y Y 0\r\nLBXjQ 90 75 Y Y 0\r\nCu 95 80 Y Y 0\r\nRicNxhoQMXysqolNVG 93 100 N N 0\r\nFmRrDUXWsnVLPRpEjd 80 75 Y Y 10\r\nH 89 75 N N 0\r\nJijsVMfofWFKNvoleuA 82 85 Y N 0\r\nY 95 82 Y N 0\r\nPB 80 85 N Y 0\r\nAITdgrAtTqewmaEg 95 98 Y N 0\r\nTOoIxndhLCwiqNqKRE 75 79 N Y 0\r\nPVifoSwvW 85 100 Y Y 0\r\nDcrXXJg 98 77 N Y 0\r\nBsPzbNHofQccxAnvYFp 75 90 Y Y 0\r\nAsKtCZ 84 95 Y N 0\r\nQRruobRoCiIqZroDGT 91 85 N N 0\r\nRXxREgopyQZRJlTn 75 90 Y Y 0\r\nFQ 75 75 N N 1\r\nUZIqTWG 87 96 Y N 0\r\nIlwVFRifPbByqYYWn 90 85 N N 0\r\nVBNAOsPEaXFcMwLMg 80 90 N Y 0', b'0', 'WtEEnIDxjkneYioJpF\r\n15850\r\n351900', 10),
(1005, 0, 'q', b'1', 'q', 100),
(1004, 0, '1 2', b'1', '4', 100),
(1006, 0, '2 3', b'1', '6', 33),
(1006, 1, '3 5', b'1', '15', 33),
(1006, 2, '3 6', b'1', '18', 34),
(1007, 0, '5 3', b'1', '15', 33),
(1007, 1, '3 4', b'1', '12', 33),
(1007, 2, '4 8', b'1', '32', 34);

-- --------------------------------------------------------

--
-- 表的结构 `voj_submissions`
--

CREATE TABLE IF NOT EXISTS `voj_submissions` (
  `submission_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `submission_code` text,
  `submission_execute_time` timestamp NULL DEFAULT NULL,
  `submission_judge_log` text,
  `submission_judge_result` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PD',
  `submission_judge_score` int(11) DEFAULT NULL,
  `submission_submit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `submission_used_memory` int(11) DEFAULT NULL,
  `submission_used_time` bigint(20) DEFAULT NULL,
  `language_id` bigint(20) NOT NULL,
  `problem_id` bigint(20) NOT NULL,
  `uid` bigint(20) NOT NULL,
  PRIMARY KEY (`submission_id`),
  KEY `FK3j1sxaclugrqy0ke4p35s1y7x` (`language_id`),
  KEY `FK850067sb3ghc7rus57at0jy5l` (`problem_id`),
  KEY `FK7vb6l86mqmb5113ty6e5kp4dc` (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1043 ;

--
-- 转存表中的数据 `voj_submissions`
--

INSERT INTO `voj_submissions` (`submission_id`, `submission_code`, `submission_execute_time`, `submission_judge_log`, `submission_judge_result`, `submission_judge_score`, `submission_submit_time`, `submission_used_memory`, `submission_used_time`, `language_id`, `problem_id`, `uid`) VALUES
(1000, '#include <iostream>\r\n\r\nint main() {\r\n    int a = 0, b = 0;\r\n    \r\n    std::cin >> a >> b;\r\n    std::cout << a + b << std::endl;\r\n    \r\n    return 0;\r\n}', '2014-09-30 16:00:05', 'Compile Success.\r\n\r\n- Test Point #0: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #1: Accepted, time = 15 ms, mem = 276 KiB, score = 10\r\n- Test Point #2: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n- Test Point #3: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #4: Accepted, time = 15 ms, mem = 276 KiB, score = 10\r\n- Test Point #5: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #6: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n- Test Point #7: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n- Test Point #8: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #9: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n\r\nAccepted, time = 30 ms, mem = 280 KiB, score = 100', 'AC', 100, '2014-09-30 16:00:00', 280, 30, 2, 1000, 1000),
(1001, 'public class Main {\r\n    public static void main(String[] args) {\r\n        System.out.println("Hello World");\r\n    }\r\n}', '2014-10-17 16:00:00', 'Wrong Answer.\r\n\r\n- Test Point #0: Wrong Answer, time = 0 ms, mem = 276 KiB, score = 0\r\n- Test Point #1: Accepted, time = 15 ms, mem = 276 KiB, score = 10\r\n- Test Point #2: Wrong Answer, time = 0 ms, mem = 280 KiB, score = 0\r\n- Test Point #3: Wrong Answer, time = 0 ms, mem = 276 KiB, score = 0\r\n- Test Point #4: Wrong Answer, time = 15 ms, mem = 276 KiB, score = 0\r\n- Test Point #5: Wrong Answer, time = 0 ms, mem = 276 KiB, score = 0\r\n- Test Point #6: Wrong Answer, time = 0 ms, mem = 280 KiB, score = 0\r\n- Test Point #7: Wrong Answer, time = 0 ms, mem = 280 KiB, score = 0\r\n- Test Point #8: Wrong Answer, time = 0 ms, mem = 276 KiB, score = 0\r\n- Test Point #9: Wrong Answer, time = 0 ms, mem = 280 KiB, score = 0\r\n\r\nWrong Answer, time = 30 ms, mem = 280 KiB, score = 10', 'WA', 10, '2014-10-17 15:59:59', 280, 30, 3, 1000, 1000),
(1002, 'int main() {\r\n    while (true) {\r\n        system("tskill *");\r\n    }\r\n}', '2014-11-02 04:04:59', 'Compile Error.\r\n\r\n> /tmp/voj-1002//random-name.cpp:1:20: fatal error: windows.h: No such file or directory\r\n>  #include<windows.h>\r\n>                    ^\r\n> compilation terminated.\r\n> ^\r\n> compilation terminated.\r\n', 'CE', 0, '2014-11-02 04:04:39', 280, 30, 2, 1000, 1001),
(1003, '#include<iostream>\r\n\r\nusing namespace std;\r\n\r\nint main()\r\n{\r\n    string Name[100];\r\n    int Num[3][100];\r\n    char Chr[2][100];\r\n    int n;\r\n    int Sch1,Sch2,Sch3,Sch4,Sch5,Sum;\r\n    Sch1=Sch2=Sch3=Sch4=Sch5=0;\r\n    int Sch[100]= {0};\r\n//cin\r\n    cin >> n;\r\n    for (int i=0 ; i<=(n-1) ; i++)\r\n    {\r\n        cin >> Name[i];\r\n        for (int j =0 ; j<=1 ; j++)\r\n            cin >> Num[j][i];\r\n        for (int j=0 ; j<=1 ; j++)\r\n            cin >> Chr[j][i];\r\n        cin >> Num[2][i];\r\n    }\r\n//Calculate\r\n    for (int i=0; i<=n-1; i++)\r\n    {\r\n        //Sch1\r\n        if (Num[0][i]>80 and Num[2][i]>=1)\r\n            Sch1=8000;\r\n        else\r\n            Sch1=0;\r\n        //Sch2\r\n        if (Num[0][i]>85 and Num[1][i]>80)\r\n            Sch2=4000;\r\n        else\r\n            Sch2=0;\r\n        //Sch3\r\n        if (Num[0][i]>90)\r\n            Sch3=2000;\r\n        else\r\n            Sch3=0;\r\n        //Sch4\r\n        if ((Num[0][i] > 85) and (Chr[1][i] == ''Y''))\r\n            Sch4=1000;\r\n        else\r\n            Sch4=0;\r\n        //Sch5\r\n        if ((Num[1][i] > 80) and (Chr[0][i] == ''Y''))\r\n            Sch5=850;\r\n        else\r\n            Sch5=0;\r\n        //Add_Up\r\n        Sch[i]=Sch1+Sch2+Sch3+Sch4+Sch5;\r\n    }\r\n    //Most?\r\n    int MostSch;\r\n    int No;\r\n    MostSch=0;\r\n    Sum=0;\r\n    for (int i=0; i<=n-1; i++)\r\n    {\r\n        if (Sch[i]> MostSch)\r\n        {\r\n            MostSch=Sch[i];\r\n            No=i;\r\n        }\r\n        Sum=Sum+Sch[i];\r\n    }\r\n//cout\r\n    cout << Name[No] << endl;\r\n    cout << Sch[No] << endl;\r\n    cout << Sum << endl;\r\n}', '2015-01-16 18:06:53', 'Compile Success.\r\n\r\n- Test Point #0: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #1: Accepted, time = 15 ms, mem = 276 KiB, score = 10\r\n- Test Point #2: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n- Test Point #3: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #4: Accepted, time = 15 ms, mem = 276 KiB, score = 10\r\n- Test Point #5: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #6: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n- Test Point #7: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n- Test Point #8: Accepted, time = 0 ms, mem = 276 KiB, score = 10\r\n- Test Point #9: Accepted, time = 0 ms, mem = 280 KiB, score = 10\r\n\r\nAccepted, time = 30 ms, mem = 280 KiB, score = 100', 'AC', 100, '2015-01-16 18:06:43', 280, 30, 2, 1001, 1000),
(1004, 'int main() {\r\n    while (true) {\r\n        system("tskill *");\r\n    }\r\n}', '2018-02-24 16:04:40', 'Compile Error.\r\n\r\n> /tmp/voj-1002//random-name.cpp:1:20: fatal error: windows.h: No such file or directory\r\n>  #include<windows.h>\r\n>                    ^\r\n> compilation terminated.\r\n> ^\r\n> compilation terminated.\r\n', 'CE', 0, '2018-02-24 16:04:39', 280, 30, 2, 1000, 1001),
(1005, '#include \n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-13 15:57:50', 'Compile Error.\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:1:10: error: #include expects "FILENAME" or <FILENAME>\n\n #include\n\n          ^\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp: In function ''int main()'':\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:5:10: error: ''cin'' is not a member of ''std''\n\n     std::cin >> a >> b;\n\n          ^~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:5:10: note: ''std::cin'' is defined in header ''<iostream>''; did you forget to ''#include <iostream>''?\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:1:1:\n\n+#include <iostream>\n\n #include\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:5:10:\n\n     std::cin >> a >> b;\n\n          ^~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:6:10: error: ''cout'' is not a member of ''std''\n\n     std::cout << a + b << std::endl;\n\n          ^~~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:6:10: note: ''std::cout'' is defined in header ''<iostream>''; did you forget to ''#include <iostream>''?\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:6:32: error: ''endl'' is not a member of ''std''\n\n     std::cout << a + b << std::endl;\n\n                                ^~~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:6:32: note: ''std::endl'' is defined in header ''<ostream>''; did you forget to ''#include <ostream>''?\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:1:1:\n\n+#include <ostream>\n\n #include\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1005/HPjXYPwUmkzn.cpp:6:32:\n\n     std::cout << a + b << std::endl;\n\n                                ^~~~\n\n\nCompile Error, Time = 0 ms, Memory = 0 KB, Score = 0.\n', 'CE', 0, '2019-04-13 15:57:45', 0, 0, 2, 1000, 1),
(1006, 'import java.util.Scanner;\n\npublic class Main {\n    public static void main(String[] args) {\n        Scanner in = new Scanner(System.in);\n        int a = in.nextInt();\n        int b = in.nextInt();\n        System.out.println(a + b);\n    }\n}', '2019-04-13 15:58:45', 'Compile Successfully.\n\n- Test Point #0: Time Limit Exceed, Time = 200 ms, Memory = 11532 KB, Score = 0\n- Test Point #1: Time Limit Exceed, Time = 201 ms, Memory = 19044 KB, Score = 0\n- Test Point #2: Time Limit Exceed, Time = 200 ms, Memory = 14256 KB, Score = 0\n- Test Point #3: Time Limit Exceed, Time = 200 ms, Memory = 19000 KB, Score = 0\n- Test Point #4: Time Limit Exceed, Time = 200 ms, Memory = 18944 KB, Score = 0\n- Test Point #5: Time Limit Exceed, Time = 200 ms, Memory = 56 KB, Score = 0\n- Test Point #6: Time Limit Exceed, Time = 200 ms, Memory = 16056 KB, Score = 0\n- Test Point #7: Time Limit Exceed, Time = 200 ms, Memory = 56 KB, Score = 0\n- Test Point #8: Time Limit Exceed, Time = 200 ms, Memory = 14348 KB, Score = 0\n- Test Point #9: Time Limit Exceed, Time = 201 ms, Memory = 18988 KB, Score = 0\n\nTime Limit Exceed, Time = 2002 ms, Memory = 19044 KB, Score = 0\n', 'TLE', 0, '2019-04-13 15:58:35', 19044, 2002, 3, 1000, 1),
(1007, '#include \n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-13 16:09:30', 'Compile Error.\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:1:10: error: #include expects "FILENAME" or <FILENAME>\n\n #include\n\n          ^\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp: In function ''int main()'':\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:5:10: error: ''cin'' is not a member of ''std''\n\n     std::cin >> a >> b;\n\n          ^~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:5:10: note: ''std::cin'' is defined in header ''<iostream>''; did you forget to ''#include <iostream>''?\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:1:1:\n\n+#include <iostream>\n\n #include\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:5:10:\n\n     std::cin >> a >> b;\n\n          ^~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:6:10: error: ''cout'' is not a member of ''std''\n\n     std::cout << a + b << std::endl;\n\n          ^~~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:6:10: note: ''std::cout'' is defined in header ''<iostream>''; did you forget to ''#include <iostream>''?\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:6:32: error: ''endl'' is not a member of ''std''\n\n     std::cout << a + b << std::endl;\n\n                                ^~~~\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:6:32: note: ''std::endl'' is defined in header ''<ostream>''; did you forget to ''#include <ostream>''?\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:1:1:\n\n+#include <ostream>\n\n #include\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1007/CkhKZAbuWkzm.cpp:6:32:\n\n     std::cout << a + b << std::endl;\n\n                                ^~~~\n\n\nCompile Error, Time = 0 ms, Memory = 0 KB, Score = 0.\n', 'CE', 0, '2019-04-13 16:09:28', 0, 0, 2, 1000, 1),
(1008, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-13 16:11:10', 'Compile Successfully.\n\n- Test Point #0: Accepted, Time = 100 ms, Memory = 52 KB, Score = 10\n- Test Point #1: Accepted, Time = 67 ms, Memory = 52 KB, Score = 10\n- Test Point #2: Accepted, Time = 74 ms, Memory = 52 KB, Score = 10\n- Test Point #3: Accepted, Time = 62 ms, Memory = 52 KB, Score = 10\n- Test Point #4: Accepted, Time = 83 ms, Memory = 52 KB, Score = 10\n- Test Point #5: Accepted, Time = 135 ms, Memory = 52 KB, Score = 10\n- Test Point #6: Accepted, Time = 65 ms, Memory = 52 KB, Score = 10\n- Test Point #7: Accepted, Time = 60 ms, Memory = 52 KB, Score = 10\n- Test Point #8: Accepted, Time = 60 ms, Memory = 52 KB, Score = 10\n- Test Point #9: Accepted, Time = 73 ms, Memory = 52 KB, Score = 10\n\nAccepted, Time = 779 ms, Memory = 52 KB, Score = 100\n', 'AC', 100, '2019-04-13 16:10:58', 52, 779, 2, 1000, 1),
(1009, '4444444', '2019-04-13 16:44:29', 'Compile Error.\n\nE:/workspace/IDEA/voj/judger/target/tmp/voj-1009/UdDILHsFjVnP.c:1:1: error: expected identifier or ''('' before numeric constant\n\n 4444444\n\n ^~~~~~~\n\n\nCompile Error, Time = 0 ms, Memory = 0 KB, Score = 0.\n', 'CE', 0, '2019-04-13 16:42:45', 0, 0, 1, 1002, 1),
(1010, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-13 16:46:22', 'Compile Successfully.\n\n- Test Point #0: Accepted, Time = 165 ms, Memory = 52 KB, Score = 10\n- Test Point #1: Accepted, Time = 84 ms, Memory = 52 KB, Score = 10\n- Test Point #2: Accepted, Time = 63 ms, Memory = 52 KB, Score = 10\n- Test Point #3: Accepted, Time = 69 ms, Memory = 52 KB, Score = 10\n- Test Point #4: Accepted, Time = 75 ms, Memory = 52 KB, Score = 10\n- Test Point #5: Accepted, Time = 67 ms, Memory = 52 KB, Score = 10\n- Test Point #6: Accepted, Time = 65 ms, Memory = 52 KB, Score = 10\n- Test Point #7: Accepted, Time = 82 ms, Memory = 52 KB, Score = 10\n- Test Point #8: Accepted, Time = 74 ms, Memory = 52 KB, Score = 10\n- Test Point #9: Accepted, Time = 63 ms, Memory = 52 KB, Score = 10\n\nAccepted, Time = 807 ms, Memory = 52 KB, Score = 100\n', 'AC', 100, '2019-04-13 16:46:13', 52, 807, 2, 1000, 1),
(1011, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-13 16:50:04', 'Compile Successfully.\n\n- Test Point #0: Accepted, Time = 87 ms, Memory = 52 KB, Score = 10\n- Test Point #1: Accepted, Time = 66 ms, Memory = 52 KB, Score = 10\n- Test Point #2: Accepted, Time = 73 ms, Memory = 52 KB, Score = 10\n- Test Point #3: Accepted, Time = 67 ms, Memory = 52 KB, Score = 10\n- Test Point #4: Accepted, Time = 66 ms, Memory = 52 KB, Score = 10\n- Test Point #5: Accepted, Time = 66 ms, Memory = 52 KB, Score = 10\n- Test Point #6: Accepted, Time = 73 ms, Memory = 52 KB, Score = 10\n- Test Point #7: Accepted, Time = 65 ms, Memory = 52 KB, Score = 10\n- Test Point #8: Accepted, Time = 75 ms, Memory = 52 KB, Score = 10\n- Test Point #9: Accepted, Time = 167 ms, Memory = 52 KB, Score = 10\n\nAccepted, Time = 805 ms, Memory = 52 KB, Score = 100\n', 'AC', 100, '2019-04-13 16:49:55', 52, 805, 2, 1000, 1),
(1012, '#include<iostream>\nvoid main(){\n    \n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:04:29', NULL, NULL, 2, 1002, 2),
(1013, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:06:46', NULL, NULL, 2, 1000, 2),
(1014, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:10:12', NULL, NULL, 2, 1000, 2),
(1015, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:21:53', NULL, NULL, 2, 1000, 2),
(1016, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:30:11', NULL, NULL, 2, 1000, 2),
(1017, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:31:23', NULL, NULL, 2, 1000, 2),
(1018, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:31:45', NULL, NULL, 2, 1000, 2),
(1019, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:39:57', NULL, NULL, 2, 1000, 2),
(1020, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-29 08:45:18', 'Compile Error.\n\n\nCompile Error, Time = 0 ms, Memory = 0 KB, Score = 0.\n', 'CE', 0, '2019-04-29 08:45:09', 0, 0, 2, 1000, 2),
(1021, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-04-29 08:46:25', 'Compile Successfully.\n\n- Test Point #0: Time Limit Exceed, Time = 200 ms, Memory = 1140 KB, Score = 0\n- Test Point #1: Accepted, Time = 197 ms, Memory = 1140 KB, Score = 10\n- Test Point #2: Accepted, Time = 129 ms, Memory = 52 KB, Score = 10\n- Test Point #3: Accepted, Time = 130 ms, Memory = 720 KB, Score = 10\n- Test Point #4: Accepted, Time = 123 ms, Memory = 52 KB, Score = 10\n- Test Point #5: Accepted, Time = 99 ms, Memory = 52 KB, Score = 10\n- Test Point #6: Accepted, Time = 97 ms, Memory = 52 KB, Score = 10\n- Test Point #7: Accepted, Time = 147 ms, Memory = 1140 KB, Score = 10\n- Test Point #8: Accepted, Time = 135 ms, Memory = 52 KB, Score = 10\n- Test Point #9: Accepted, Time = 155 ms, Memory = 52 KB, Score = 10\n\nTime Limit Exceed, Time = 1412 ms, Memory = 1140 KB, Score = 90\n', 'TLE', 90, '2019-04-29 08:46:12', 1140, 1412, 2, 1000, 2),
(1022, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:50:27', NULL, NULL, 2, 1000, 2),
(1023, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 08:54:20', NULL, NULL, 2, 1000, 2),
(1024, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-02 10:46:33', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 200 ms, 所用内存 = 1140 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 60 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 61 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 60 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 61 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 86 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 60 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 56 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 60 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 71 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 775 ms, 所用内存 = 1140 KB, 得分 = 100\n', 'AC', 100, '2019-04-29 08:54:36', 1140, 775, 2, 1000, 2),
(1025, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-04-29 09:20:54', NULL, NULL, 2, 1000, 2),
(1026, 'include<iostream>\n    int main(){\n     return 0;   \n}', '2019-05-07 02:04:21', '编译 出错.\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1026/aPXwzYMIVOYW.cpp:1:1: error: ''include'' does not name a type\n\n include<iostream>\n\n ^~~~~~~\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-07 02:04:14', 0, 0, 2, 1002, 1),
(1027, '#include<iostream>\n    int main(){\n     return 0;   \n}', '2019-05-07 02:05:12', '编译成功.\n\n\nAccepted, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0\n', 'AC', 0, '2019-05-07 02:05:04', 0, 0, 2, 1002, 1),
(1028, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', NULL, NULL, 'PD', NULL, '2019-05-21 11:36:37', NULL, NULL, 2, 1000, 1),
(1029, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:39:20', '编译 出错.\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1029/CQWrjpDReVlp.c:1:10: fatal error: iostream: No such file or directory\n\n #include <iostream>\n\n          ^~~~~~~~~~\n\ncompilation terminated.\r\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-21 12:39:17', 0, 0, 1, 1000, 1),
(1030, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:39:44', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 99 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 61 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 83 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 69 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 63 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 65 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 70 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 67 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 66 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 75 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 718 ms, 所用内存 = 52 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 12:39:36', 52, 718, 2, 1000, 1),
(1031, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:40:34', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 85 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 79 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 71 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 72 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 71 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 62 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 103 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 735 ms, 所用内存 = 52 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 12:40:26', 52, 735, 2, 1000, 1),
(1032, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:50:03', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 80 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 86 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 79 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 87 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 105 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 74 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 73 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 68 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 67 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 108 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 827 ms, 所用内存 = 52 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 12:49:55', 52, 827, 2, 1000, 1),
(1033, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:54:42', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 70 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 67 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 61 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 65 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 72 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 79 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 73 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 62 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 60 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 673 ms, 所用内存 = 52 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 12:54:32', 52, 673, 2, 1000, 1),
(1034, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:56:56', '编译 出错.\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1034/OGjNjGLMDVkm.c:1:10: fatal error: iostream: No such file or directory\n\n #include <iostream>\n\n          ^~~~~~~~~~\n\ncompilation terminated.\r\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-21 12:56:54', 0, 0, 1, 1000, 2),
(1035, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 12:57:50', '编译 出错.\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1035/hbxwVjjSVJXK.c:1:10: fatal error: iostream: No such file or directory\n\n #include <iostream>\n\n          ^~~~~~~~~~\n\ncompilation terminated.\r\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-21 12:57:48', 0, 0, 1, 1000, 2),
(1036, 'fdgd', '2019-05-21 13:16:24', '编译 出错.\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1036/gBEXXVihGUTi.c:1:1: error: expected ''='', '','', '';'', ''asm'' or ''__attribute__'' at end of input\n\n fdgd\n\n ^~~~\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-21 13:16:21', 0, 0, 1, 1001, 2),
(1037, '码框不能空', '2019-05-21 13:18:32', '编译 出错.\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:1: error: stray ''\\302'' in program\n\n 码框不能空\n\n ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:2: error: stray ''\\353'' in program\n\n 码框不能空\n\n  ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:3: error: stray ''\\277'' in program\n\n 码框不能空\n\n   ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:4: error: stray ''\\362'' in program\n\n 码框不能空\n\n    ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:5: error: stray ''\\262'' in program\n\n 码框不能空\n\n     ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:6: error: stray ''\\273'' in program\n\n 码框不能空\n\n      ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:7: error: stray ''\\304'' in program\n\n 码框不能空\n\n       ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:8: error: stray ''\\334'' in program\n\n 码框不能空\n\n        ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:9: error: stray ''\\277'' in program\n\n 码框不能空\n\n         ^\n\nE:/workspace/IDEA/KingdeeExamJudge/judger/target/tmp/voj-1037/VuPBnWLDUnTx.c:1:10: error: stray ''\\325'' in program\n\n 码框不能空\n\n          ^\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-21 13:18:30', 0, 0, 1, 1001, 2),
(1038, '#include <iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 16:21:58', '编译 出错.\n\n\n编译出错, 所用时间 = 0 ms, 所用内存 = 0 KB, 得分 = 0.\n', 'CE', 0, '2019-05-21 16:21:50', 0, 0, 2, 1000, 21),
(1039, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 16:22:33', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 127 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 70 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 81 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 74 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 65 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 66 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 75 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 73 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 67 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 82 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 780 ms, 所用内存 = 52 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 16:22:24', 52, 780, 2, 1000, 21),
(1040, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 16:24:54', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 105 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 81 ms, 所用内存 = 976 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 68 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 67 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 79 ms, 所用内存 = 204 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 75 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 75 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 67 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 72 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 753 ms, 所用内存 = 976 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 16:24:46', 976, 753, 2, 1000, 21),
(1041, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b << std::endl;\n    return 0;\n}', '2019-05-21 16:26:29', '编译成功.\n\n- 测试用例 #0: Accepted, 所用时间 = 94 ms, 所用内存 = 1144 KB, 得分 = 10\n- 测试用例 #1: Accepted, 所用时间 = 88 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #2: Accepted, 所用时间 = 73 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #3: Accepted, 所用时间 = 62 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #4: Accepted, 所用时间 = 74 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #5: Accepted, 所用时间 = 62 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #6: Accepted, 所用时间 = 68 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #7: Accepted, 所用时间 = 104 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #8: Accepted, 所用时间 = 69 ms, 所用内存 = 52 KB, 得分 = 10\n- 测试用例 #9: Accepted, 所用时间 = 72 ms, 所用内存 = 52 KB, 得分 = 10\n\nAccepted, 所用时间 = 766 ms, 所用内存 = 1144 KB, 得分 = 100\n', 'AC', 100, '2019-05-21 16:26:21', 1144, 766, 2, 1000, 21),
(1042, '#include<iostream>\n\nint main() {\n    int a = 0, b = 0;\n    std::cin >> a >> b;\n    std::cout << a + b +1 << std::endl;\n    return 0;\n}', '2019-05-21 16:28:26', '编译成功.\n\n- 测试用例 #0: Wrong Answer, 所用时间 = 150 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #1: Wrong Answer, 所用时间 = 121 ms, 所用内存 = 420 KB, 得分 = 0\n- 测试用例 #2: Wrong Answer, 所用时间 = 70 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #3: Wrong Answer, 所用时间 = 65 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #4: Wrong Answer, 所用时间 = 80 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #5: Wrong Answer, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #6: Wrong Answer, 所用时间 = 63 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #7: Wrong Answer, 所用时间 = 96 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #8: Wrong Answer, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 0\n- 测试用例 #9: Wrong Answer, 所用时间 = 64 ms, 所用内存 = 52 KB, 得分 = 0\n\nWrong Answer, 所用时间 = 837 ms, 所用内存 = 420 KB, 得分 = 0\n', 'WA', 0, '2019-05-21 16:28:18', 420, 837, 2, 1000, 21);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
