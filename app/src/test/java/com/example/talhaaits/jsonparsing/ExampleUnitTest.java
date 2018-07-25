package com.example.talhaaits.jsonparsing;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);
        String className = "Mentorship";

        String json = mentorship;

        printJsonObject(className, json);

    }
    //@Test
    public void printJsonObject(String className, String json) {

        System.out.print(json);

        String str = "\n\n@JsonSerializable()\n" +
                "class "+className+" extends Object with _$"+className+"SerializerMixin{\n";
        System.out.print(str);
        try {
            JSONObject jsonObject  = new JSONObject(json);
            for (Iterator<String> it = jsonObject.keys(); it.hasNext(); ) {
                Object key = it.next();
                //based on you key types
                String keyStr = (String)key;
                Object keyValue = null;
                try {
                    keyValue = jsonObject.get(keyStr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Print key and value
                System.out.print("@JsonKey(name: '"+keyStr+"')\n");
                if(keyValue instanceof Integer){
                    System.out.println("int "+ toCamelCase(keyStr)+";");
                }else if(keyValue instanceof String){
                    System.out.println("String "+ toCamelCase(keyStr)+";");
                }else if(keyValue instanceof Boolean){
                    System.out.println("bool "+ toCamelCase(keyStr)+";");
                }else if(keyValue instanceof ArrayList){
                    System.out.println("List<"+getClassName(keyStr)+"> "+ toCamelCase(keyStr)+"List;");
                }else if(keyValue instanceof Object){
                    printJsonObject( getClassName(keyStr) , keyValue.toString());
                }
                //System.out.println("key: "+ keyStr + " value: " + keyValue);

                //for nested objects iteration if required
                //if (keyvalue instanceof JSONObject)
                    //printJsonObject((JSONObject)keyvalue);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String s = MessageFormat.format("\n factory {0}.fromJson(Map<String, dynamic> json) => _${1}FromJson(json);\n}\n\n",className,className);
        System.out.print(s);

    }

    static String toCamelCase(String s){
        String[] parts = s.split("_");
        if(parts.length == 1)
            return s;
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        camelCaseString = toFirstCharLowerCase(camelCaseString);
        return camelCaseString;
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

    static String toFirstCharLowerCase(String s) {
        return s.substring(0, 1).toLowerCase() +
                s.substring(1);
    }

    static String toFirstCharUpperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1);
    }

    static String getClassName(String className){
        className = toCamelCase(className);
        className = toFirstCharUpperCase(className);
        return className;
    }

    String book = "  {\n" +
            "    \"title\": \"string\",\n" +
            "    \"price\": 0,\n" +
            "    \"author\": \"string\",\n" +
            "    \"edition\": \"string\",\n" +
            "    \"isbn\": \"string\",\n" +
            "    \"condition_new\": true,\n" +
            "    \"special_info\": \"string\",\n" +
            "    \"image_url\": \"\",\n" +
            "    \"contact_via_phone\": false,\n" +
            "    \"is_approved\": false,\n" +
            "    \"is_available\": true,\n" +
            "    \"pay_via_pickup\": false,\n" +
            "    \"pay_via_cash_on_delivery\": false,\n" +
            "    \"id\": 0,\n" +
            "    \"userId\": 0\n" +
            "  }";

    String user = "{\n" +
            "    \"short_bio\": \"\",\n" +
            "    \"is_admin\": false,\n" +
            "    \"is_mentor\": false,\n" +
            "    \"phoneno\": \"string\",\n" +
            "    \"rating\": 0,\n" +
            "    \"rating_ppl_count\": 0,\n" +
            "    \"total_selling_amount\": 0,\n" +
            "    \"total_buying_amount\": 0,\n" +
            "    \"realm\": \"string\",\n" +
            "    \"username\": \"string\",\n" +
            "    \"email\": \"string\",\n" +
            "    \"emailVerified\": true,\n" +
            "    \"id\": 0,\n" +
            "    \"universityId\": 0,\n" +
            "    \"departmentId\": 0\n" +
            "  }";

    String item = " {\n" +
            "    \"name\": \"string\",\n" +
            "    \"id\": 0\n" +
            "  }";

    String note = " {\n" +
            "    \"title\": \"string\",\n" +
            "    \"subject\": \"string\",\n" +
            "    \"subject_code\": \"string\",\n" +
            "    \"price\": 0,\n" +
            "    \"num_pages\": 0,\n" +
            "    \"note_type\": \"string\",\n" +
            "    \"special_info\": \"string\",\n" +
            "    \"image_url\": \"string\",\n" +
            "    \"is_available\": true,\n" +
            "    \"is_approved\": false,\n" +
            "    \"contact_via_phone\": false,\n" +
            "    \"pay_via_pickup\": false,\n" +
            "    \"pay_via_cash_on_delivery\": false,\n" +
            "    \"id\": 0,\n" +
            "    \"userId\": 0\n" +
            "  }";
    String fileResponse = "{\"container\": \"books\",\n" +
            "                    \"name\": \"10078640800305738.jpg\",\n" +
            "                    \"type\": \"image/jpeg\",\n" +
            "                    \"field\": \"Image\",\n" +
            "                    \"originalFilename\": \"SampleJPGImage_50kbmb.jpg\",\n" +
            "                    \"size\": 51085}";

    String s = "{\n" +
            "    \"result\": {\n" +
            "        \"files\": {\n" +
            "            \"Image\": [\n" +
            "                {\n" +
            "                    \"container\": \"notes\",\n" +
            "                    \"name\": \"5854319679998405.jpg\",\n" +
            "                    \"type\": \"image/jpeg\",\n" +
            "                    \"field\": \"Image\",\n" +
            "                    \"originalFilename\": \"SampleJPGImage_50kbmb.jpg\",\n" +
            "                    \"size\": 51085\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        \"fields\": {}\n" +
            "    }\n" +
            "}";

    String tutoring = "{\n" +
            "  \"title\": \"string\",\n" +
            "  \"total_classes\": 0,\n" +
            "  \"hours_per_class\": 0,\n" +
            "  \"price\": 0,\n" +
            "  \"special_info\": \"string\",\n" +
            "  \"id\": 0,\n" +
            "  \"userId\": 0\n" +
            "}";

    String mentorship = "{\n" +
            "  \"id\": 0,\n" +
            "  \"userId\": 0,\n" +
            "  \"mentoringSubjectId\": 0\n" +
            "}";
}
//flutter packages pub run build_runner build

