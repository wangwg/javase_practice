package com.xiaogang.lottery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Lottery {

	public static void main(String[] args) throws Exception {

		HashMap<String, String[]> hashMap = new HashMap<String, String[]>();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("lottery.txt"));

		while (true) {
			String line = bufferedReader.readLine();
			if (line == null) {
				break;
			}

			String dateKey = line.substring(0, 5);

			String values = line.substring(6, 26);

			String[] split = values.split("\t");

			hashMap.put(dateKey, split);
		}

		bufferedReader.close();

		TreeMap<String, Integer> red = new TreeMap<String, Integer>();
		TreeMap<String, Integer> blue = new TreeMap<String, Integer>();

		Set<String> keySet = hashMap.keySet();

		Iterator<String> iterator = keySet.iterator();

		while (iterator.hasNext()) {

			String key = iterator.next();

//			if ("20000".compareTo(key) > 0) {
//				continue;
//			}

			String[] items = hashMap.get(key);

			for (int i = 0; i < items.length; i++) {

				if (isRed(i)) {
					if (red.get(items[i]) == null) {
						red.put(items[i], 1);
					} else {
						int times = red.get(items[i]);
						red.put(items[i], ++times);
					}
				} else {
					if (blue.get(items[i]) == null) {
						blue.put(items[i], 1);
					} else {
						int times = blue.get(items[i]);
						blue.put(items[i], ++times);
					}
				}

			}

		}

		Set<String> redKey = red.keySet();
		System.out.println("============Red===============");
		for (String item : redKey) {
			System.out.println(item + " --> " + red.get(item));
		}

		Set<String> blueKey = blue.keySet();
		System.out.println("============blue===============");
		for (String item : blueKey) {
			System.out.println(item + " --> " + blue.get(item));
		}

	}

	public static boolean isRed(int index) {
		if (index < 5) {
			return true;
		}

		return false;
	}

}
