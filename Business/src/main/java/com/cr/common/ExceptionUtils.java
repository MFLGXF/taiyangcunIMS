package com.cr.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常工具类
 *
 *  <strong>ExceptionUtil使用示例</strong><br>
 *  <code><pre>
 *  ・・・
 *  try {
 *     ・・・
 *  } catch (Exception e) {
 *      // 取得trace信息
 *      log.error("error-message", ExceptionUtil.getStackTrace(e));
 *  }
 *  ・・・
 * </pre></code>
 * </p>
 * @author pengzhengming
 * @version 1.0 2015/05/25
 */
public final class ExceptionUtils {

    /**
     * log
     */
    private static Logger log = LoggerFactory.getLogger(ExceptionUtils.class);

    /**
     * 只是支持ServletException
     */
    private static final String SERVLET_EXCEPTION_NAME =
        "javax.servlet.ServletException";

    /**
     * ServletException发生的时候，抛出时的方法名
     */
    private static final String GET_ROOT_CAUSE = "getRootCause";

    /**
     * 指定异常的trace信息取得
     *
     * @param throwable 异常
     * @return trace信息
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String getStackTrace(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (throwable != null) {
            baos.reset();
            throwable.printStackTrace(new PrintStream(baos));
            sb.append(baos.toString());

            Class throwableClass = throwable.getClass();

            if (SERVLET_EXCEPTION_NAME.equals(throwableClass.getName())) {
                try {
                    Method method = throwableClass.getMethod(GET_ROOT_CAUSE);
                    throwable = (Throwable) method.invoke(throwable);
                } catch (NoSuchMethodException e) {
                    log.error(e.getMessage());
                    throwable = null;
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                    throwable = null;
                } catch (InvocationTargetException e) {
                    log.error(e.getMessage());
                    throwable = null;
                }
            } else {
                throwable = throwable.getCause();
            }
        }
        return sb.toString();
    }

}
