package org.shadowx4fox.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import io.micronaut.context.env.Environment;

import javax.annotation.PreDestroy;
import javax.inject.Singleton;

@Singleton
public class HazelcastManagerImpl implements HazelcastManager {

    private HazelcastInstance hazelcast;

    public HazelcastManagerImpl()
    {
        hazelcast = Hazelcast.newHazelcastInstance();
    }

    @PreDestroy
    public void stopCache(){

        if(hazelcast != null)
            hazelcast.shutdown();
    }

    @Override
    public HazelcastInstance getHazelcastInstance() {
        return hazelcast;
    }
}
