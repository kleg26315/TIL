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
		
		// put(K key, V value) : Ű�� �� �߰�, ���� �� value ��ȯ
		map.put("�����", new Snack("§��", 1500));
		map.put("������", new Snack("����� ��", 2500));
		map.put("��������Ĩ", new Snack("§��", 1500));
		map.put("��ҹ�", new Snack("����Ѹ�", 1000));	// value�� �ߺ� ���
		System.out.println(map);
		
		map.put("�����", new Snack("�ſ��", 1500));	// key�� �ߺ� �Ұ�
		System.out.println(map);
		
		// �ִ��� ������ Ȯ���ϴ� �޼ҵ�
		// containsKey(Object key) : key�� ������ true ��ȯ
		// containsValue(Object value) : value�� ������ true ��ȯ
		System.out.println(map.containsKey("�����"));
		System.out.println(map.containsValue(new Snack("§��",1500)));
		
		// get(Object key) : Ű�� �� ��ȯ
		System.out.println(map.get("�����"));	// �ſ��[1500]
		System.out.println(map.get("Ȩ����"));	// null

		// 1. values() : ��� value�� Collection�� ��� ��ȯ
		System.out.println(map.values());
		
		// 2. keySet() : ��� key�� Set�� ��� ��ȯ
		Set<String> set1 = map.keySet();
//		System.out.println(set1);	// [������, �����, ��������Ĩ, ��ҹ�]
		Iterator<String> it = set1.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("Ű : "+ key + ", �� : "+ map.get(key));
		}
//		map.remove()
		// 3. entrySet() : ��� entry��ü(Ű+���� ��)�� set�� ��� ��ȯ
		Set<Entry<String, Snack>> set2 = map.entrySet();
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Entry<String,Snack> entry = it2.next();
			System.out.println("Ű : "+ entry.getKey() + ", �� : "+ entry.getValue());
		}
		
		Map<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2);
		
	}
	
	public void doProperties() {
		Properties prop = new Properties();
		prop.setProperty("ä��", "����");
		prop.setProperty("����", "���");
		prop.setProperty("����", "����");
		prop.setProperty("ä��", "�Ǹ�");
		System.out.println(prop);
		
		System.out.println(prop.getProperty("ä��"));			// �Ǹ�
		System.out.println(prop.getProperty("ä��", "����"));	// �Ǹ�
		System.out.println(prop.getProperty("�߰�", "����"));	// ����, key���� ������ value���� �������� key���� ������ ���ο� value�� ������
	}
	
	public void fileSave() {
//		try (FileOutputStream fos = new FileOutputStream("test.properties")){
		try (FileOutputStream fos = new FileOutputStream("test.xml")){
			
			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("language", "kor");
			
			// store(OutputStream os, String comments)
			// store(Writer writer, String comments)
			// os(�Ǵ� writer)�� prop����(����Ʈ �Ǵ� ���� ��������), comments�� �ּ����� ����
			
//			prop.store(fos, "Properties Test File");
			
			// storeToXML(OutputStream os, String comment)
			// ����� ������ ����Ʈ ��Ʈ������ xml ��� ����
			
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
			// : ����Ʈ��Ʈ������ ����� ������ ������ �о�ͼ� Properties��ü�� ����
			// load(Reader reader)
			// : ���ڽ�Ʈ������ ����� ������ ������ �о�ͼ� Properties ��ü�� ����
	
//			prop.load(fis);
			
			// loadFromXML(InputStream is)
			// : ����Ʈ��Ʈ������ ����� xml������ ������ �о�ͼ� Properties��ü�� ����
			
			prop.loadFromXML(fis);
			System.out.println(prop);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
