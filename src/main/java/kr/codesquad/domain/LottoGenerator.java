package kr.codesquad.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public LottoGenerator() {
    }

    public List<List<Integer>> generateLottoLists(int lottoAmount) {
        return IntStream.range(0, lottoAmount)
                .mapToObj(i -> generateLottoList())
                .collect(Collectors.toList());
    }

    private List<Integer> generateLottoList() {
        List<Integer> allNumbers = generateShuffledNumbersList();

        // 6개 뽑아오기
        List<Integer> lottoNumber = allNumbers.subList(0, 6);

        // 오름차순 정렬
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    private List<Integer> generateShuffledNumbersList() {
        List<Integer> allNumbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        // 리스트 섞어주기
        Collections.shuffle(allNumbers);
        return allNumbers;
    }
}
