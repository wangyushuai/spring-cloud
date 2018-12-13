package com.example.springcloud.util.api;

import com.example.springcloud.util.response.RestResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description：AOP 程序耗时切面
 * @author wangyushuai@fang.com
 * @date 2018/11/23
 */

@Aspect
@Component
public class TimeTakesAspect {

    /**
     * 定义切点
     */
//    @Pointcut("execution(* com.example.springboot.controller.*(..))")
//    public void setTimeTakes() {}

    /**
     * @Pointcut  用于定义切面的匹配规则，如果想要同时匹配多个的话，可以使用 || 把两个规则连接起来，具体可以参照上面的代码
     * @Before  目标方法执行前调用，前置方法
     * @After  目标方法执行后调用，后置方法
     * @Around 环绕通知
     * @AfterReturning  目标方法执行后调用，可以拿到返回结果，执行顺序在 @After 之后
     * @AfterThrowing  目标方法执行异常时调用
     */

        /**
     * @description: 定义切点-切点 为RedisClient全部方法
     * execution 参数介绍：
     * 1. public * *(..) ——  第一个* 表示任意返回值，前面可能有public, 一般省略
     * 2. * *.*(..) —— 第二个 * 表示任意包
     * 3. * *.*(..) —— 第三个 *  表示任意方法
     * 4. * *.*(..) —— (..) 表示任意参数
     * 5. 参考文档： https://blog.csdn.net/weixin_40315550/article/details/78941291
     */


    /**
     * API计时切面
     * 切入点为
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(public com.example.springcloud.util.response.RestResponse *..controller.*.*(..))")
    public Object addKeyPrevStr(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis  = System.currentTimeMillis();
        RestResponse response = (RestResponse) proceedingJoinPoint.proceed();
        long execTimeMillis = System.currentTimeMillis() - startTimeMillis ;
        response.setTime(execTimeMillis);
        return response;
    }

}
