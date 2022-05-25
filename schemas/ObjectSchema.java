package slash.schemas;

import slash.data.PropertyMap;
import slash.data.Property;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/** 
 * Implement a schema for validating arbitrary key-value pairs, i.e.
 *  for {@link PropertyMap}s. 
 */
public class ObjectSchema extends Schema {
  
  /** A collection of named {@link Schema}s to match on. */
  private Map<String, Schema> schemas; 

  /** A collection of required property names, if any. */
  private Set<String> requiredPropertyNames;

  public ObjectSchema(Map<String, Schema> schemas, String... requiredPropertyNames) {
    this.schemas = schemas;
    this.requiredPropertyNames = new HashSet<String>();
    for (String prop : requiredPropertyNames) {
      this.requiredPropertyNames.add(prop);
    }
  }

  @Override
  public boolean matches(Object o) {
    if (!(o instanceof PropertyMap)) return false;

    PropertyMap propertyMap = (PropertyMap) o;
    Set<Property> properties = propertyMap.properties;
    
    // Verify all required property names are present.
    for (String name : requiredPropertyNames) {
      if (!propertyMap.getAllPropertyNames().contains(name)) {
        return false;
      }
    } 

    // Verify that the number of properties is correct.
    if (properties.size() != this.schemas.size()) {
      return false;
    } 
    
    // Verify that all the properties match.
    for (Property property : properties) {
      Schema schema = this.schemas.get(property.key);
      if (schema == null || !schema.matches(property.val)) {
        return false;
      }
    }

    return true;
  }
}
