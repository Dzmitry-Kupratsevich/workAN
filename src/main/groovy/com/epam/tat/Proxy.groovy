package com.epam.tat

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpMethod
import io.netty.handler.codec.http.HttpObject
import io.netty.handler.codec.http.HttpRequest
import io.netty.handler.codec.http.HttpResponse
import io.netty.util.AttributeKey
import org.littleshoot.proxy.DefaultHostResolver
import org.littleshoot.proxy.HostResolver
import org.littleshoot.proxy.HttpFilters
import org.littleshoot.proxy.HttpFiltersAdapter
import org.littleshoot.proxy.HttpFiltersSourceAdapter
import org.littleshoot.proxy.HttpProxyServer
import org.littleshoot.proxy.impl.DefaultHttpProxyServer

class Proxy {

    HttpProxyServer server =
            DefaultHttpProxyServer.bootstrap()
                    .withPort(8080)
                    .withTransparent(true)
                    .withFiltersSource(new HttpFiltersSourceAdapter() {
                HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                    if (originalRequest.getMethod() == HttpMethod.CONNECT) {

                        new HttpFiltersAdapter(originalRequest) {
                            @Override
                            HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                if (httpObject instanceof HttpRequest) {
                                    HttpRequest httpRequest = (HttpRequest) httpObject
                                    println("hj")
                                }
                                null
                            }
                        }
                    }
                }
            })
                    .start()


//    HttpResponse clientToProxyRequest(HttpObject httpObject) {
//        if(httpObject instanceof FullHttpRequest) {
//            FullHttpRequest httpRequest = (FullHttpRequest)httpObject
//            httpRequest.headers().remove("Host")
//            httpRequest.headers().add("Host", "myserver.com:8080")
//        }
//        return null
//    }


}
