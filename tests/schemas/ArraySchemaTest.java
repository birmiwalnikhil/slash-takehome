package slash.schemas;

import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import slash.data.PropertyMap;
import slash.data.Property;
import java.util.Map;
import java.util.HashMap;

@RunWith(JUnit4.class)
public class ArraySchemaTest {

  private NumberSchema numberSchema; 
  private ArraySchema underTest;

  private Object[] data;

  @Before
  public void setUp() {
    numberSchema = new NumberSchema();

    underTest = new ArraySchema(numberSchema); 
    data = new Object[4];
  }
  
  @Test
  public void matches_whenAllObjectsMatch() {
    data[0] = 1;
    data[1] = 2;
    data[2] = -1234;
    data[3] = 987654;
    
    assertThat(underTest.matches(data)).isTrue();
  }

  @Test 
  public void matches_failsWhenOneElementMismatch() {
    data[0] = 1;
    data[3] = "2";
    
    assertThat(underTest.matches(data)).isFalse();
  }
}
