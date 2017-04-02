package com.mogikanensoftware.cache.interceptor;

import com.hazelcast.map.MapInterceptor;

public class EventMapInterceptior implements MapInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public Object interceptGet(Object value) {
		System.out.println(String.format("getting object->%s",value));
		return null;
	}

	@Override
	public void afterGet(Object value) {
		System.out.println(String.format("object->%s was returned",value));
	}

	@Override
	public Object interceptPut(Object oldValue, Object newValue) {
		if(oldValue!=null){
			System.out.println(String.format("replacing object->%s with object->%s",oldValue,newValue));
		}else{
			System.out.println(String.format("putting object->%s",newValue));
		}
		
		return null;
	}

	@Override
	public void afterPut(Object value) {
		System.out.println(String.format("object->%s was added to the map",value));
		
	}

	@Override
	public Object interceptRemove(Object removedValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterRemove(Object value) {
		// TODO Auto-generated method stub
		
	}

}
