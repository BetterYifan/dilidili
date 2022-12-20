import java.util.UUID;

/**
 * 链路id工具类
 */
public class TraceIdUtil {

    private static final String TRACE_ID = "traceId";

    private String DEFAULT_TRACE_ID = "a0b1c2d3e5f6-000";

    /**
     * 设置traceId
     */
    public static void setTraceId(String traceId){
        //如果参数为空，则设置默认traceId
        traceId = StringUtils.isBlank(traceId) ? DEFAULT_TRACE_ID : traceId;
        //将traceId放到MDC中
        MDC.put(TRACE_ID, traceId);
    }

    /**
     * 配置默认的traceId
     */
    public static String setAndGetTraceId() {
        String traceId = UUID.randomUUID().toString();
        //设置traceId
        TraceIdUtil.setTraceId(traceId);

        return traceId;
    }

    /**
     * 获取traceId
     */
    public static String getTraceId() {
        //获取
        String traceId = MDC.get(TRACE_ID);
        //如果traceId为空，则返回默认值
        return StringUtils.isBlank(traceId) ? DEFAULT_TRACE_ID : traceId;
    }
    
}
