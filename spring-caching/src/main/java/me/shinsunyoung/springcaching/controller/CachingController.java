package me.shinsunyoung.springcaching.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import me.shinsunyoung.springcaching.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachingController {

  @Autowired
  CashService cashService;

  private final char[] productCode = {'S', 'D', 'G'}; // 상품 코드들
  Random random = new Random();

  /**
   * 캐시 사용
   *
   * @return
   */
  @GetMapping("/cache")
  public List<String> cahce(){

    List<String> products = new ArrayList<>();

    for(int i=0; i<10; i++){
      // 랜덤으로 코드를 뽑아서 코드로 값을 바꿔주는 메소드 호출
      products.add(cashService.vendingMachine(productCode[random.nextInt(3)]));
    }

    return products;
  }


  /**
   * 캐시 사용
   *
   * @return
   */
  @GetMapping("/non-cache")
  public List<String> nonCahce(){

    List<String> products = new ArrayList<>();

    for(int i=0; i<10; i++){
      products.add(cashService.vendingMachine2(productCode[random.nextInt(3)]));
    }

    return products;
  }

}