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
    
    // ObjetAArraySchema
    Schema arrayNumberSchema = new ArraySchema(numberSchema);
    Schema arrayObjectASchema = new ArraySchema(objectASchema);

    // Insert tests here...
    runTest(stringSchema, 123, false);
    runTest(stringSchema, "123", true);
  }

  private static void runTest(Schema schema, Object o, boolean expected) {
    if (schema.matches(o) != expected) {
      System.out.println("Test failed.");
    } else {
      System.out.println("OK.");
    }
  }
}
