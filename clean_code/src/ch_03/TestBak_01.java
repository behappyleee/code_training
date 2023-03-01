package ch_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestBak_01 {
	
	private static HashMap<String, Object> fashion = new HashMap<String, Object>();
	
	public static void main(String[] args) throws IOException {
//		문제
//		해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 
//		예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 
//		해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
//
//		입력
//		첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
//
//		각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
//		다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
//		모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
//
//		출력
//		각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int caseCount = Integer.parseInt(br.readLine());
		
		for(int i=0; i<caseCount; i++) {
			fashion = new HashMap<>();
			int fashionCount = Integer.parseInt(br.readLine());
			for(int j=0; j<fashionCount; j++) {
				String[] clothes = br.readLine().split(" ");
				fashion.put(clothes[0], clothes[1]);
			}
			int dailyFashionCount = countDailyFashion();
			bw.write(dailyFashionCount + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int countDailyFashion() {
		int sameClothCount = 0;
		Set<String> valueSet = new HashSet<>();
		Iterator iter = fashion.values().iterator();
		while(iter.hasNext()) {
			valueSet.add((String)iter.next());
		}
		sameClothCount = fashion.size() * valueSet.size();
		if(valueSet.size() > 1) {
			sameClothCount = (fashion.size() * valueSet.size()) - (fashion.size() - valueSet.size());
		}
		
		return sameClothCount;
	}
	
}
 