package com.mogikanensoftware.cache;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hello Hazelcast!
 *
 */
public class CustomAppWithCache 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Hazelcast!" );
        
        Config cfg = new Config();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
        Map<String,String> customers = instance.getMap("myCustomers");
        customers.put("A100", "jenny Doe");
        customers.put("B80", "Silva Brown");
        customers.put("C60", "Ejik Polevoi");
        
        System.out.println(String.format("# of customers in cache %d", customers.keySet().size()));
        
    }
}
