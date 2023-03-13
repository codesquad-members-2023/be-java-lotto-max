package kr.codesquad.domain;

import java.util.HashMap;
import java.util.Map;

import kr.codesquad.view.View;

public class LottoResult {
	Map<LottoNumber,Integer> results;
	public void addResult(LottoNumber lottoNumber){
		Integer lottoNumberValue = results.get(lottoNumber);
		results.remove(lottoNumber);
		results.put(lottoNumber, lottoNumberValue + 1);
	}

	public LottoResult(){
		results = new HashMap<>();
		LottoNumber[] values = LottoNumber.values();
		for(LottoNumber value : values){
			results.put(value, 0);
		}
	}
	public void printResults(){
		String lottoResultToString = "";
		for(LottoNumber lottoNumber : LottoNumber.values()){
			lottoResultToString+=(lottoNumber.toString()+results.get(lottoNumber)+"개\n");
		}
		View.printLottoResult(String.valueOf(lottoResultToString));
	}
}
