package com.graphql.springboot.graphql.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j  @RequiredArgsConstructor
@Component
public class LoggingListener implements GraphQLServletListener {
    // Sunucuya yapılan reqestlerin loglanması için
    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        return new RequestCallback() {
            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                log.info("İşlem Başarılı");
            }

            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response,
                                Throwable throwable) {
                log.error("Hata ile karılaşıldı.", throwable);
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                log.info("Loglar temizlendi");
                MDC.clear();
            }
        };
    }

}
