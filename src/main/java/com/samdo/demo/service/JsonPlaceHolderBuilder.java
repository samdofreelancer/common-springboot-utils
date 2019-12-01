package com.samdo.demo.service;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonPlaceHolderBuilder {
    public static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(type))
            .logLevel(Logger.Level.FULL)
            .target(type, uri);
    }
}
