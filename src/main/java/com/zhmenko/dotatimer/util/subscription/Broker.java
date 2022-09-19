package com.zhmenko.dotatimer.util.subscription;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Broker {
    private final Map<Class, List<SubscriberInfo>> map = new LinkedHashMap<Class, List<SubscriberInfo>>();

    public void addSubscriber(Object o) {
        for (Method method : o.getClass().getMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (method.getAnnotation(Subscription.class) == null || parameterTypes.length != 1) continue;
            Class subscribeTo = parameterTypes[0];
            List<SubscriberInfo> subscriberInfos = map.computeIfAbsent(subscribeTo, k -> new ArrayList<SubscriberInfo>());
            subscriberInfos.add(new SubscriberInfo(method, o));
        }
    }
    public void removeSubscriber(Object o) {
        for (List<SubscriberInfo> subscriberInfos : map.values()) {
            for (int i = subscriberInfos.size() - 1; i >= 0; i--)
                if (subscriberInfos.get(i).object == o)
                    subscriberInfos.remove(i);
        }
    }
    public int publish(Object o) {
        List<SubscriberInfo> subscriberInfos = map.get(o.getClass());
        if (subscriberInfos == null) return 0;
        int count = 0;
        for (SubscriberInfo subscriberInfo : subscriberInfos) {
            subscriberInfo.invoke(o);
            count++;
        }
        return count;
    }
    static class SubscriberInfo {
        final Method method;
        final Object object;

        SubscriberInfo(Method method, Object object) {
            this.method = method;
            this.object = object;
        }

        void invoke(Object o) {
            try {
                method.invoke(object, o);
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }
    }
}