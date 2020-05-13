package cn.sora.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LogManager.getLogger(WebLogAspect.class.getName());

    private ObjectMapper objectMapper = new ObjectMapper(); // jackJson
    private String requestPath = null ; // 请求地址
    private Map<?,?> inputParamMap = null ; // 传入参数
    private HttpServletRequest request = null;
    private String  host="";
    private String  method="";

    @Pointcut("execution(public * cn.sora.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("#####################请求开始####################");

//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes re = (ServletRequestAttributes)requestAttributes;
//        request = re.getRequest();
//        StringBuffer  buffer = new StringBuffer();
//        inputParamMap =  request.getParameterMap();
//        requestPath= request.getRequestURL().toString(); // 请求地址
//        host = request.getRemoteHost();
//        method = request.getMethod();
//        buffer.append("inputParamMap:"+objectMapper.writeValueAsString(inputParamMap)+"\t");
//        buffer.append("requestPath:"+requestPath+"\t");
//        buffer.append("host:"+host+"\t");
//        buffer.append("method:"+method+"\t");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint,Object ret) throws Throwable {
        // 处理完请求，返回内容

        //logger.info("RESPONSE : " + ret);
        //logger.info("#####################请求结束####################");

        StringBuffer  buffer = new StringBuffer();
        buffer.append("signatureName:"+joinPoint.getSignature().getName());
        buffer.append("methodName:"+joinPoint.getSignature().getName());

        logger.info("resultData:"+buffer.toString());
    }
}
