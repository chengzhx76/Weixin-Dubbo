Redis启动方式
[cheng@redis redis-3.0.7]$ pwd
/usr/local/redis-3.0.7
[cheng@redis redis-3.0.7]$ redis-server ./redis.conf
[cheng@redis redis-3.0.7]$ redis-cli
127.0.0.1:6379> set "abc" "123"
OK
127.0.0.1:6379> get "abc"
"123"
127.0.0.1:6379>