package me.shinsunyoung.springtest.vo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PositiveTest {

  @Test
//  @Parameters({
//      "1, true",
//      "2, true",
//      "-1, false"
//  })
//  @Parameters(method = "parametersForPositive")
  @Parameters
  public void positive(int number, boolean isPositive) {
    Positive positive = new Positive(number);
    assertThat(positive.isPositive()).isEqualTo(isPositive);
  }

  private Collection<Object[]> parametersForPositive() { // parametersFor + method name
    return Arrays.asList(new Object[][]{
        {1, true},
        {2, true},
        {-1, false}
    });
  }
}