package slash.schemas;

import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BooleanSchemaTest {
  
  @Test
  public void matches_onBoolean() {
    assertThat(new BooleanSchema().matches(true)).isTrue();
    assertThat(new BooleanSchema().matches(false)).isTrue();
  }

  @Test
  public void matches_failsOnNonBooleans() {
    BooleanSchema underTest = new BooleanSchema();

    assertThat(underTest.matches("false")).isFalse();
    assertThat(underTest.matches(0)).isFalse();
  }
}
