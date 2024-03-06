create table user
(
    id           bigint auto_increment comment '主键'
        primary key,
    username     varchar(255)                       null comment '用户名称',
    userAccount  varchar(255)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '用户头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(512)                       null comment '密码',
    phone        varchar(100)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 null comment '状态',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null comment '更新时间',
    isDelete     tinyint  default 0                 null comment '是否删除',
    userRole     int      default 0                 not null comment '用户角色 0 普通角色 1 管理员',
    planetCode   varchar(512)                       null comment '星球编号'
)
    comment '用户';


