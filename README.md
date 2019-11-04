# redis实现消息队列
- RedisConfig还是老配置，注入各种属性 
- 注入方向  jedisPoolConfig-JedisConnectionFactory-redisTemplate
- RedisClient实现push和pop的操作 leftpush rightpop 通过redisTemplate.opsForList()来进行操作
- List<String> list=Arrays.asList() new String[]{"xxx","xxxx","xxx"}初始化string数组。。。
- TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
- postman开启两个终端，一个实现生产，一个实现消费
- 在rightpop设置 timeout 为具体时间数字 TimeUnit设置数字对应的单位，防止队列阻塞 
