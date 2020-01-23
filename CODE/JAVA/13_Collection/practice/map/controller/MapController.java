package com.kh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.vo.Snack;

public class MapController {
	public void doMap() {
		Map<String, Snack> map = new HashMap<String, Snack>();
		
		// put(K key, V value) : 키와 값 추가, 성공 시 value 반환
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("고소한 맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한맛", 1000));	// value는 중복 허용
		System.out.println(map);
		
		map.put("새우깡", new Snack("매운맛", 1500));	// key는 중복 불가
		System.out.println(map);
		
		// 있는지 없는지 확인하는 메소드
		// containsKey(Object key) : key가 있으면 true 반환
		// containsValue(Object value) : value가 있으면 true 반환
		System.out.println(map.containsKey("새우깡"));
		System.out.println(map.containsValue(new Snack("짠맛",1500)));
		
		// get(Object key) : 키의 값 반환
		System.out.println(map.get("새우깡"));	// 매운맛[1500]
		System.out.println(map.get("홈런볼"));	// null

		// 1. values() : 모든 value를 Collection에 담아 반환
		System.out.println(map.values());
		
		// 2. keySet() : 모든 key를 Set에 담아 반환
		Set<String> set1 = map.keySet();
//		System.out.println(set1);	// [다이제, 새우깡, 포테이토칩, 고소미]
		Iterator<String> it = set1.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("키 : "+ key + ", 값 : "+ map.get(key));
		}
//		map.remove()
		// 3. entrySet() : 모든 entry객체(키+값의 쌍)를 set에 담아 반환
		Set<Entry<String, Snack>> set2 = map.entrySet();
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Entry<String,Snack> entry = it2.next();
			System.out.println("키 : "+ entry.getKey() + ", 값 : "+ entry.getValue());
		}
		
		Map<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2);
		
	}
	
	public void doProperties() {
		Properties prop = new Properties();
		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		prop.setProperty("채소", "피망");
		System.out.println(prop);
		
		System.out.println(prop.getProperty("채소"));			// 피망
		System.out.println(prop.getProperty("채소", "탕콩"));	// 피망
		System.out.println(prop.getProperty("견과", "땅콩"));	// 땅콩, key값이 있으면 value값을 가져오고 key값이 없으면 새로운 value를 가져옴
	}
	
	public void fileSave() {
//		try (FileOutputStream fos = new FileOutputStream("test.properties")){
		try (FileOutputStream fos = new FileOutputStream("test.xml")){
			
			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("language", "kor");
			
			// store(OutputStream os, String comments)
			// store(Writer writer, String comments)
			// os(또는 writer)에 prop저장(바이트 또는 문자 형식으로), comments는 주석으로 저장
			
//			prop.store(fos, "Properties Test File");
			
			// storeToXML(OutputStream os, String comment)
			// 저장된 정보를 바이트 스트림으로 xml 출력 저장
			
			prop.storeToXML(fos, "storeToXML Test");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen() {
//		try (FileInputStream fis = new FileInputStream("test.properties")) {
		try (FileInputStream fis = new FileInputStream("test.xml")) {	
			Properties prop = new Properties();
			
			// load(InputStram is)
			// : 바이트스트림으로 저장된 파일의 내용을 읽어와서 Properties객체에 저장
			// load(Reader reader)
			// : 문자스트림으로 저장된 파일의 내용을 읽어와서 Properties 객체에 저장
	
//			prop.load(fis);
			
			// loadFromXML(InputStream is)
			// : 바이트스트림으로 저장된 xml파일의 내용을 읽어와서 Properties객체에 저장
			
			prop.loadFromXML(fis);
			System.out.println(prop);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
