### Redis命令
打开客户端$ redis-cli

### zookeeper命令

启动：$ ./zkCli.sh <br/>
查看节点：ls /

启动ZK服务: sh bin/zkServer.sh start<br/>
查看ZK服务状态: sh bin/zkServer.sh status<br/>
停止ZK服务: sh bin/zkServer.sh stop<br/>
重启ZK服务: sh bin/zkServer.sh restart<br/>
删除节点：<br/>
使用delete命令可以删除指定znode. 当该znode拥有子znode时, 必须先删除其所有子znode, 否则操作将失败. rmr命令可用于代替delete命令, rmr是一个递归删除命令, 如果发生指定节点拥有子节点时, rmr命令会首先删除子节点.

