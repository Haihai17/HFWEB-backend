package com.haihai.hfweb.service;

import com.haihai.hfweb.model.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: shayu
 * @date: 2022/12/06
 * @ClassName: yupao-backend01
 * @Description:    用户插入单元测试，注意打包时要删掉或忽略，不然打一次包就插入一次
 */
@SpringBootTest
public class InsertUserTest {

    @Resource
    private UserService userService;

    //线程设置
    private ExecutorService executorService = new ThreadPoolExecutor(16, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));
    /**
     * 循环插入用户  耗时：7260ms
     * 批量插入用户   1000  耗时： 4751ms
     */
    @Test
    public void doInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 300000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假haihia");
            user.setUserAccount("haihia");
            user.setAvatarUrl("https://image-haihai.oss-cn-shenzhen.aliyuncs.com/img/images.jpeg");
            user.setProfile("这是一个假人");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123456789108");
            user.setEmail("32143214213@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("931");
            user.setTags("[\"女\",\"青铜\"]");
            userList.add(user);
        }
        userService.saveBatch(userList,100);
        stopWatch.stop();
        System.out.println( stopWatch.getLastTaskTimeMillis());
    }

    /**
     * 并发批量插入用户   100000  耗时： 26830ms
     */
    @Test
    public void doConcurrencyInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 500000;
        // 分十组
        int j = 0;
        //批量插入数据的大小
        int batchSize = 10000;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        // i 要根据数据量和插入批量来计算需要循环的次数。（鱼皮这里直接取了个值，会有问题,我这里随便写的）
        for (int i = 0; i < INSERT_NUM/batchSize; i++) {
            List<User> userList = new ArrayList<>();
            while (true){
                j++;
                User user = new User();
                user.setUsername("假haihia");
                user.setUserAccount("haihia");
                user.setAvatarUrl("https://image-haihai.oss-cn-shenzhen.aliyuncs.com/img/images.jpeg");
                user.setProfile("这是一个假人");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("123456789108");
                user.setEmail("32143214213@qq.com");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("931");
                user.setTags("[\"男\",\"白银\"]");
                userList.add(user);
                if (j % batchSize == 0 ){
                    break;
                }
            }
            //异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
                System.out.println("ThreadName：" + Thread.currentThread().getName());
                userService.saveBatch(userList,batchSize);
            },executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.println( stopWatch.getLastTaskTimeMillis());
    }
}

