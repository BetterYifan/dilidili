use filter;

CREATE TABLE `filter_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID, 帖子的评论和回复ID',
  `area` varchar(50) NOT NULL COMMENT '业务名称',
  `typeid` smallint(6) NOT NULL COMMENT '分区id',
  `filterid` int(11) NOT NULL COMMENT '过滤内容id',
  `level` tinyint(4) NOT NULL DEFAULT '0' COMMENT '业务过滤等级',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：0:未删除 1:已删除',
  `ctime` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `mtime` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_area_tpid_filterid` (`area`,`typeid`,`filterid`),
  KEY `ix_filterid` (`filterid`),
  KEY `ix_filterid2` (`filterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='敏感词对应业务表';

CREATE TABLE `filter_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID, 过滤id',
  `mode` tinyint(4) NOT NULL COMMENT '过滤模式 0-正则 ，1-string',
  `filter` varchar(255) NOT NULL COMMENT '过滤内容',
  `level` tinyint(4) NOT NULL COMMENT '过滤等级',
  `comment` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '过滤备注',
  `ctime` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `mtime` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间',
  `etime` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '失效时间',
  `stime` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '生效时间',
  `key` varchar(255) NOT NULL DEFAULT '' COMMENT '业务方指定key',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除,0：未删除,1：已删除',
  `type` smallint(5) NOT NULL DEFAULT '0' COMMENT '类型',
  `source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '来源：0 上级部门;2 审核规避;4 运营规避;8 审核提示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_filter_key` (`filter`,`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过滤内容';

CREATE TABLE `filter_white_area` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `area` varchar(50) NOT NULL COMMENT '业务名称',
  `tpid` int(11) NOT NULL COMMENT '分区id',
  `content_id` int(11) NOT NULL COMMENT '内容id',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：删除',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_area_tyid_contentid` (`content_id`,`tpid`,`area`),
  KEY `ix_mtime` (`mtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过滤白名单业务关系表';

CREATE TABLE `filter_white_content` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` varchar(64) NOT NULL COMMENT '过滤规则',
  `mode` tinyint(4) NOT NULL COMMENT '模式，0：正则，1：字符串',
  `comment` varchar(50) NOT NULL COMMENT '说明',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0：正常，1：删除',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_content` (`content`),
  KEY `ix_mtime` (`mtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过滤白名单内容表';

