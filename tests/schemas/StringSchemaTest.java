package slash.schemas;

import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringSchemaTest {
  
  @Test
  public void matches_failsOnNonStrings() {
    assertThat(new StringSchema().matches(123)).isFalse();
  }

  @Test
  public void matches_failsOnNonMatchingEnums() {
    StringSchema underTest = new StringSchema("enum1");

    assertThat(underTest.matches("enum2")).isFalse();
  }

  @Test
  public void matches_passesWithEmptyEnums() {
    assertThat(new StringSchema().matches("")).isTrue();
    assertThat(new StringSchema().matches("string with spaces")).isTrue();
  }

  @Test
  public void matches_passesWithEnums() {
    StringSchema underTest = new StringSchema("enum1", "another enum");
    
    assertThat(underTest.matches("enum1")).isTrue();
    assertThat(underTest.matches("another enum")).isTrue();
  }
}
