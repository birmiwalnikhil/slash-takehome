import slash.schemas.Schema;
import slash.data.PropertyMap;
import slash.data.Property;
import java.util.Map;
import java.util.HashMap;
import slash.schemas.*;

public class Main {

  private static final String ENUM_1 = "enum1";

  public static void main(String[] args) {
    // Setup all the possible Schemas.
    Schema stringSchema = new StringSchema();
    Schema stringSchemaEnums = new StringSchema(ENUM_1);
    Schema numberSchema = new NumberSchema();
    Schema booleanSchema = new BooleanSchema();
    
    // Object A that requires a->number, b->String.
    Map<String, Schema> aSchemas = new HashMap<>();
    aSchemas.put("a", numberSchema);
    aSchemas.put("b", stringSchema);
    Schema objectASchema = new ObjectSchema(aSchemas);

    // Object B that requires c->"enum1", d->Object A, e->boolean.
    Map<String, Schema> bSchemas = new HashMap<>();
    bSchemas.put("c", stringSchemaEnums);
    bSchemas.put("d", objectASchema);
    bSchemas.put("e", booleanSchema);
    Schema objectBSchema = new ObjectSchema(bSchemas);
    
    // ObjectAArraySchema
    Schema arrayNumberSchema = new ArraySchema(numberSchema);
    Schema arrayObjectASchema = new ArraySchema(objectASchema);

    PropertyMap a = new PropertyMap();
    a.addProperty("a", 123);
    a.addProperty("b", "xyz");
    
    PropertyMap b = new PropertyMap();
    b.addProperty("c", ENUM_1);
    b.addProperty("d", a);
    b.addProperty("e", true);

    // Insert tests here...
    runTest(stringSchema, 123, false);
    runTest(stringSchema, "123", true);
    runTest(stringSchema, null, false);
  
    runTest(stringSchemaEnums, ENUM_1, true);
    runTest(stringSchemaEnums, "", false);
    
    runTest(numberSchema, 123, true);
    runTest(numberSchema, "123", false);
    runTest(numberSchema, null, false);
  
    runTest(booleanSchema, true, true);
    runTest(booleanSchema, null, false);
    runTest(booleanSchema, "false", false);
    
    runTest(objectASchema, new PropertyMap(), false);
    runTest(objectASchema, a, true);
    runTest(objectASchema, b, false);

    runTest(objectBSchema, a, false);
    runTest(objectBSchema, b, true);

    runTest(arrayNumberSchema, new int[0], false);
    runTest(arrayNumberSchema, new Integer[0], true);
    runTest(arrayNumberSchema, new Integer[] {1, 2, 3}, true);
    runTest(arrayNumberSchema, new String[5], false);

    runTest(arrayObjectASchema, new PropertyMap[0], true); 
    runTest(arrayObjectASchema, new PropertyMap[] { a, a, a }, true); 
    runTest(arrayObjectASchema, new PropertyMap[] { a, b, a }, false); 
  }

  private static void runTest(Schema schema, Object o, boolean expected) {
    if (schema.matches(o) != expected) {
      System.out.println("Test failed.");
    } else {
      System.out.println("OK.");
    }
  }
}
