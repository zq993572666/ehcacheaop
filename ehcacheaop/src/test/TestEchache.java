package test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEchache {
	public static void main(String[] args) {

		CacheManager manager = CacheManager.create();// 默认配置文件创建

		String[] names = manager.getCacheNames();

		for (int i = 0; i < names.length; i++) {

		System.out.println(names[i]);

		}

		//Cache cache = manager.getCache(names[0]);

		Cache cache = new Cache("test", 150, true, false, 5, 2);

		manager.addCache(cache);

		cache.put(new Element("key1","value1"));

		Element element = cache.get("key1");

		System.out.println("element" +element.getValue());

		String[] names1 = manager.getCacheNames();

		for (int i = 0; i < names1.length; i++) {

		System.out.println("cache  "+names1[i]);

		}

		}
}
