package slash.schemas;

import slash.data.PropertyMap;
import slash.data.Property;
import java.util.Set;
import java.util.HashSet;

/** 
 * Implement a schema for validating arbitrary key-value pairs, i.e.
 *  for {@link PropertyMap}s. 
 */
public class ObjectSchema extends Schema {
  
  /** A collection of {@link Properties} to match on. */
  private Set<Property> properties;  

  /** A collection of required property names, if any. */
  private Set<String> requiredPropertyNames;

  public ObjectSchema(Set<Property> properties, String... requiredPropertyNames) {
    this.properties = properties;
    this.requiredPropertyNames = new HashSet<String>();
    for (String prop : requiredPropertyNames) {
      this.requiredPropertyNames.add(prop);
    }
  }

  @Override
  public boolean matches(Object o) {
    if (!(o instanceof PropertyMap)) return false;

    PropertyMap propertyMap = (PropertyMap) o;
    return true; 
  }
}
