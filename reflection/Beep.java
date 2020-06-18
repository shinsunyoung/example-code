package me.shinsunyoung.reflection;

public class Beep {

  public String str1 = "1";
  private String str2 = "2";

  public Beep() {
  }

  private Beep(String str1) {
    this.str1 = str1;
  }

  private void beep1() {
    System.out.println("Beep1");
  }

  private void beep2(int n) {
    System.out.println("Beep2 : " + n);
  }

  public void beep3() {
    System.out.println("Beep3");
  }

}
