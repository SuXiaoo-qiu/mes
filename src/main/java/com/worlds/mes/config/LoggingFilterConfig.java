package com.worlds.mes.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Slf4j
@Configuration
public class LoggingFilterConfig implements Filter {
        @Bean
        public FilterRegistrationBean registrationBean(){
            FilterRegistrationBean filter = new FilterRegistrationBean(new LoggingFilterConfig());
            filter.addUrlPatterns("/*");
            //多个过滤器时执行顺序
            // 最高级别。
            filter.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
            return filter;
        }
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest)request;
            Map<String, Object> map = new HashMap<String, Object>();

            // Get request URL.
            map.put("URL", req.getRequestURL());
            map.put("Method", req.getMethod());
            map.put("Protocol",req.getProtocol());
            // 获取header信息
            List<Map<String, String>> headerList = new ArrayList<>();
            Map<String, String> headerMaps = new HashMap<String, String>();
            for(Enumeration<String> enu = req.getHeaderNames(); enu.hasMoreElements();){
                String name = enu.nextElement();
                headerMaps.put(name,req.getHeader(name));
            }
            headerList.add(headerMaps);
            map.put("headers", headerList);
            //获取parameters信息
            List<Map<String, String>> parameterList = new ArrayList<>();
            Map<String, String> parameterMaps = new HashMap<String, String>();
            for(Enumeration<String> names = req.getParameterNames(); names.hasMoreElements();){
                String name = names.nextElement();
                parameterMaps.put(name, req.getParameter(name));
            }
            parameterList.add(parameterMaps);
            map.put("parameters", parameterList);
            String line = "";
            int idx = req.getRequestURL().indexOf("?");
            if (idx != -1) {
                line = req.getRequestURL().substring(idx + 1);
            } else {
                line = null;
            }
            if (line != null) {
                map.put("Context", new String[] { line });
            }
            log.info("请求路径: "+ JSONObject.toJSONString(map.get("URL")));

//        log.info(JSONObject.toJSONString(map));
            chain.doFilter(request, response);
            log.info(response.getContentType());
        }

        @Override
        public void destroy() {

        }



}
