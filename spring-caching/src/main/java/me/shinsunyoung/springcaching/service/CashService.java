package me.shinsunyoung.springcaching.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CashService {

  @Cacheable(value = "product")
  public String vendingMachine(char code) {

    String output = "";

    System.out.println(code + " product를 조회합니다 ...");

    // 각 코드에 맞는 결과물 리턴
    if (code == 'S') {
      output = "과자";
    } else if (code == 'D') {
      output = "음료수";
    } else if (code == 'G') {
      output = "껌";
    }

    return output;
  }

  public String vendingMachine2(char code) {

    String output = "";

    System.out.println(code + " product를 조회합니다 ...");

    // 각 코드에 맞는 결과물 리턴
    if (code == 'S') {
      output = "과자";
    } else if (code == 'D') {
      output = "음료수";
    } else if (code == 'G') {
      output = "껌";
    }

    return output;
  }
}