package me.shinsunyoung.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {

    Class testClass = Beep.class; // 클래스 또는 인터페이스를 가르킴. 클래스 정보 할당 가능
    Object instance = testClass.newInstance();

    // 클래스 찾기
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ클래스 찾기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    System.out.println("Class name : " + testClass.getName()); // Class name : me.shinsunyoung.reflection.Beep

    // 만약 클래스를 참조할 수 없고 이름만 알고 있다면?? (이름으로 클래스 찾기)
    Class testClass2 = Class.forName("me.shinsunyoung.reflection.Beep");
    System.out.println("Class name : " + testClass2.getName()); // Class name : me.shinsunyoung.reflection.Beep

    // 기본 생성자 찾기
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ생성자 찾기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    Constructor testConstructor = testClass.getDeclaredConstructor(); // 인자 없는 기본 생성자를 가져오기
    System.out.println("Constructor : " + testConstructor.getName()); // Constructor : me.shinsunyoung.reflection.Beep

    // 파라미터로 받는게 있는 생성자 찾기
    Constructor testConstructor2 = testClass.getDeclaredConstructor(String.class); // String을 파라미터로 받는 생성자를 가져오기 (private)
    System.out.println("Constructor : " + testConstructor2.getName()); // Constructor : me.shinsunyoung.reflection.Beep

    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    Method[] testConstructor3 = testClass.getDeclaredMethods(); // 메소드 목록 전체 가져오기 (자식것만)
    Arrays.stream(testConstructor3)
        .forEach(e -> System.out.println(e.getName()));

    // 메소드 찾고 호출하기
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ메소드 찾고 호출하기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    Method testMethod = testClass.getDeclaredMethod("beep2", int.class);
    testMethod.setAccessible(true); // private 접근 허용
    testMethod.invoke(instance, 10); // 메소드 실행

    // 변수 호출
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ변수 호출ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    Field str1 = testClass.getDeclaredField("str1");
    System.out.println("cstr1(public)의 값 : " + str1.get(instance));

    Field str2 = testClass.getDeclaredField("str2");
    str2.setAccessible(true); // private 접근 허용
    System.out.println("cstr1(private)의 값 : " + str2.get(instance));

  }
}
