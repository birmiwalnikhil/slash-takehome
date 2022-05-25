package slash.data;

import static com.google.common.truth.Truth.assertThat;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PropertyMapTest {
  
  @Test
  public void propertyMap_addsAllProperties() {
    PropertyMap underTest = new PropertyMap();
    PropertyMap nestedPropertyMap = new PropertyMap();
    
    underTest.addProperty("prop1", 123);
    underTest.addProperty("another property", true);
    underTest.addProperty("recursion!", nestedPropertyMap);

    assertThat(underTest.hasProperty("prop1", 123)).isTrue();
    assertThat(underTest.hasProperty("prop1", "123")).isFalse();
    assertThat(underTest.hasProperty("another property", true)).isTrue();
    assertThat(underTest.hasProperty("recursion!",
nestedPropertyMap)).isTrue();
  }
}

