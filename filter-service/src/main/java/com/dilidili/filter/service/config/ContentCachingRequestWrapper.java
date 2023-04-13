package com.dilidili.filter.service.config;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HttpServletRequest 不能对前端传来的参数进行修改，但实际场所像过滤xss攻击，取认证token统一去除token前缀等需要进行请求参数的处理。
 * 本质上是对请求参数进行修改
 */
public class ContentCachingRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    private BufferedReader reader;

    private ServletInputStream inputStream;

    public ContentCachingRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        loadBody(request);
    }

    private void loadBody(HttpServletRequest request) throws IOException {
        body = IOUtils.toByteArray(request.getInputStream());
        inputStream = new RequestCachingInputStream(body);
    }

    public byte[] getBody() {
        if (this.body == null) {
            return null;
        }
        return body.clone();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (inputStream != null) {
            return inputStream;
        }
        return super.getInputStream();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(inputStream, getCharacterEncoding()));
        }
        return reader;
    }

    private static class RequestCachingInputStream extends ServletInputStream {

        private final ByteArrayInputStream inputStream;

        private RequestCachingInputStream(byte[] bytes) {
            this.inputStream = new ByteArrayInputStream(bytes);
        }

        @Override
        public boolean isFinished() {
            return inputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }

        @Override
        public int read() throws IOException {
            return inputStream.read();
        }
    }
}
