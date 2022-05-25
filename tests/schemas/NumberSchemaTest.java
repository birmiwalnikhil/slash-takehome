package slash.schemas;

import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NumberSchemaTest {
  
  @Test
  public void matches_onIntegers() {
    assertThat(new NumberSchema().matches(123)).isTrue();
  }

  @Test
  public void matches_failsOnNonIntegers() {
    NumberSchema underTest = new NumberSchema();

    assertThat(underTest.matches("123")).isFalse();
    assertThat(underTest.matches(123.456)).isFalse();
  }
}
