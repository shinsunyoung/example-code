package me.shinsunyoung.springtest.vo;

public class Positive {

  private int number;
  private boolean isPositive;

  public boolean isPositive() {
    return isPositive;
  }

  public Positive(int number) {
    this.number = number;
    this.isPositive = number > 0;
  }
}
