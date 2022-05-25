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
public class ObjectSchemaTest {

  private NumberSchema numberSchema; 
  private StringSchema stringSchema; 
  private ObjectSchema underTest;

  private PropertyMap propertyMap;

  @Before
  public void setUp() {
    numberSchema = new NumberSchema();
    stringSchema = new StringSchema();

    Map<String, Schema> schemas = new HashMap<>();
    schemas.put("number", numberSchema);
    schemas.put("string", stringSchema);

    underTest = new ObjectSchema(schemas, /* requiredPropertyNames= */ "number"); 
    propertyMap = new PropertyMap();
  }

  @Test
  public void matches_onlyOnPropertyMaps() {
    assertThat(underTest.matches(123)).isFalse();
    assertThat(underTest.matches("false")).isFalse();
    assertThat(underTest.matches(new Object[0])).isFalse();
  }

  @Test
  public void matches_requiresPropertyNames() {
    propertyMap.addProperty("not number", 123);
    propertyMap.addProperty("string", "xyz");
    
    assertThat(underTest.matches(propertyMap)).isFalse();
  }

  @Test
  public void matches_requiresSameNumberOfProperties() {
    propertyMap.addProperty("number", 123);
    propertyMap.addProperty("string", "xyz");
    propertyMap.addProperty("boolean", true);
    
    assertThat(underTest.matches(propertyMap)).isFalse();
  }
  
  @Test
  public void matches_whenHasAllProperties() {
    propertyMap.addProperty("number", 123);
    propertyMap.addProperty("string", "xyz");

    assertThat(underTest.matches(propertyMap)).isTrue();
  }
}
