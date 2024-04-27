package com.worlds.mes.utils;


import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Component
public final class BeanConvertUtils {

        private static final Log log = LogFactory.getLog(BeanConvertUtils.class);
        private static final Enhancer enhancer = new Enhancer();
        private static final Object[] NULL_ARGS = new Object[0];

        private BeanConvertUtils() {
        }

        public static <T> T mapToBeanEffective(Map<String, Object> map, Class<T> clazz) {
            BeanConvertUtils.MapToBeanProxyHandler<T> handler = new BeanConvertUtils.MapToBeanProxyHandler();
            return handler.getProxyObject(map, clazz);
        }

        public static <T> T mapToBeanEffective(Map<String, Object> map, T instance) {

            return (T) mapToBeanEffective(map, instance.getClass());
        }

        public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) {
            Object instance = null;

            try {
                instance = clazz.newInstance();
                BeanUtils.populate(instance, map);
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException var4) {
                log.error("Convert map to java bean instance fail", var4);
            }

            return (T) instance;
        }

        private static void invokeMethod(Method method, Object instance, Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
            String name = method.getName();
            String key = name.substring(3, 4).toLowerCase() + name.substring(4);
            if (name.startsWith("set") && map.containsKey(key)) {
                method.invoke(instance, map.get(key));
            }

        }

        public static <T> T mapToBean(Map<String, Object> map, T instance) {
            return (T) mapToBean(map, instance.getClass());
        }

        public static <D, S> D beanToBeanEffective(S src, Class<D> distClass) {
            BeanConvertUtils.BeanToBeanProxyHandler<D, S> handler = new BeanConvertUtils.BeanToBeanProxyHandler();
            return handler.getProxyObject(src, distClass);
        }

        public static <D, S> D beanToBeanEffective(S src, D dist) {
            return (D) beanToBeanEffective(src, dist.getClass());
        }

        public static <D, S> D beanToBean(S src, Class<D> distClass) {
            Object dist = null;

            try {
                dist = distClass.newInstance();
                BeanUtils.copyProperties(dist, src);
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException var4) {
                log.error("Copy properties fail", var4);
            }

            return (D) dist;
        }

        public static <D, S> D beanToBean(S src, D dist) {
            return (D) beanToBean(src, dist.getClass());
        }

        public static <T> Map<String, Object> beanToMap(T bean) {
            return BeanMap.create(bean);
        }

    public static <T> List<T> mapToBeanInList(List<Map<String, Object>> mapList, final Class<T> clazz) {
        return Lists.transform(mapList, new Function<Map<String, Object>, T>() {
            public T apply(Map<String, Object> input) {
                return BeanConvertUtils.mapToBean(input, clazz);
            }
        });
    }

        public static <T> List<Map<String, Object>> beanToMapInList(List<T> beanList) {
            return Lists.transform(beanList, new Function<T, Map<String, Object>>() {
                @Override
                public Map<String, Object> apply(T input) {
                    return BeanConvertUtils.beanToMap(input);
                }
            });
        }

        public static <D, S> List<D> beanToBeanInList(List<S> srcList, final Class<D> distClass) {
            return Lists.transform(srcList, new Function<S, D>() {
                @Override
                public D apply(S input) {
                    return BeanConvertUtils.beanToBean(input, distClass);
                }
            });
        }

        private static class BeanToBeanProxyHandler<D, S> implements MethodInterceptor, Serializable {
            private transient S source;

            private BeanToBeanProxyHandler() {
            }

            public D getProxyObject(S bean, Class<D> clazz) {
                this.source = bean;
                BeanConvertUtils.enhancer.setSuperclass(clazz);
                BeanConvertUtils.enhancer.setCallback(this);
                return (D) BeanConvertUtils.enhancer.create();
            }

            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                String name = method.getName();
                if (name.startsWith("set")) {
                    Object value = null;
                    if (args[0] != null) {
                        value = args[0];
                    }

                    try {
                        this.source.getClass().getDeclaredMethod(name).invoke(this.source, value);
                    } catch (NoSuchMethodException var8) {
                        this.source.getClass().getSuperclass().getDeclaredMethod(name).invoke(this.source, value);
                    }

                    return null;
                } else if (name.startsWith("get")) {
                    try {
                        return this.source.getClass().getDeclaredMethod(name).invoke(this.source, BeanConvertUtils.NULL_ARGS);
                    } catch (NoSuchMethodException var9) {
                        return this.source.getClass().getSuperclass().getDeclaredMethod(name).invoke(this.source, BeanConvertUtils.NULL_ARGS);
                    }
                } else {
                    return proxy.invokeSuper(o, args);
                }
            }
        }

        private static class MapToBeanProxyHandler<T> implements MethodInterceptor, Serializable {
            private transient Map<String, Object> map;

            private MapToBeanProxyHandler() {
            }

            public T getProxyObject(Map<String, Object> map, Class<? extends T> clazz) {
                this.map = map;
                BeanConvertUtils.enhancer.setSuperclass(clazz);
                BeanConvertUtils.enhancer.setCallback(this);
                return (T) BeanConvertUtils.enhancer.create();
            }

            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                String name = method.getName();
                String key = name.substring(3, 4).toLowerCase() + name.substring(4);
                if (name.startsWith("set")) {
                    Object value = null;
                    if (args[0] != null) {
                        value = args[0];
                    }

                    this.map.put(key, value);
                    return null;
                } else {
                    return name.startsWith("get") ? this.map.get(key) : proxy.invokeSuper(o, args);
                }
            }
        }
    }

