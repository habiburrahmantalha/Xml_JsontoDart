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
        String className = "FilterResponse";

        String json = FilterResponse;

        printJsonObject(className, json);

    }

    //@Test
    public void printJsonObject(String className, String json) {

        System.out.print(json);

        String str = "\n\n@JsonSerializable()\n" +
                "class " + className + " extends Object with _$" + className + "SerializerMixin{\n";
        System.out.print(str);
        try {
            JSONObject jsonObject = new JSONObject(json);
            for (Iterator<String> it = jsonObject.keys(); it.hasNext(); ) {
                Object key = it.next();
                //based on you key types
                String keyStr = (String) key;
                Object keyValue = null;
                try {
                    keyValue = jsonObject.get(keyStr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Print key and value
                System.out.print("@JsonKey(name: '" + keyStr + "')\n");
                if (keyValue instanceof Integer) {
                    System.out.println("int " + toCamelCase(keyStr) + ";");
                } else if (keyValue instanceof String) {
                    System.out.println("String " + toCamelCase(keyStr) + ";");
                } else if (keyValue instanceof Boolean) {
                    System.out.println("bool " + toCamelCase(keyStr) + ";");
                } else if (keyValue instanceof ArrayList) {
                    System.out.println("List<" + getClassName(keyStr) + "> " + toCamelCase(keyStr) + "List;");
                } else if (keyValue != null) {
                    //printJsonObject( getClassName(keyStr) , keyValue.toString());
                    System.out.println("Object " + toCamelCase(keyStr) + ";");
                }
                //System.out.println("key: "+ keyStr + " value: " + keyValue);

                //for nested objects iteration if required
                //if (keyvalue instanceof JSONObject)
                //printJsonObject((JSONObject)keyvalue);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.print(className+"();");
        String s = MessageFormat.format("\nfactory {0}.fromJson(Map<String, dynamic> json) => _${1}FromJson(json);\n}\n\n", className, className);
        System.out.print(s);

    }

    static String toCamelCase(String s) {
        String[] parts = s.split("_");
        if (parts.length == 1)
            return s;
        String camelCaseString = "";
        for (String part : parts) {
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

    static String getClassName(String className) {
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
            "    \"short_code\": \"string\",\n" +
            "    \"created_at\": \"$now\",\n" +
            "    \"updated_at\": \"$now\",\n" +
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
            "  \"created_at\": {},\n" +
            "  \"updated_at\": {},\n" +
            "  \"id\": 0,\n" +
            "  \"userId\": 0,\n" +
            "  \"mentoringSubjectId\": 0\n" +
            "}";

    String mentoringSubject = " {\n" +
            "    \"name\": \"string\",\n" +
            "    \"created_at\": {},\n" +
            "    \"updated_at\": {},\n" +
            "    \"id\": 0\n" +
            "  }";
    String tutor = " {\n" +
            "            \"short_bio\": \"test ggh\",\n" +
            "            \"is_admin\": false,\n" +
            "            \"is_mentor\": false,\n" +
            "            \"phoneno\": 09,\n" +
            "            \"rating\": 4,\n" +
            "            \"rating_ppl_count\": 4,\n" +
            "            \"total_selling_amount\": 4,\n" +
            "            \"total_buying_amount\": 4,\n" +
            "            \"address\": \"test ggh\",\n" +
            "            \"image_url\": \"test ggh\",\n" +
            "            \"tutoring_bio\": \"test ggh\",\n" +
            "            \"mentoring_bio\": \"test ggh\",\n" +
            "            \"realm\": \"1234567\",\n" +
            "            \"username\": \"talhaaits\",\n" +
            "            \"email\": \"talhaaits@gmail.com\",\n" +
            "            \"emailVerified\": false,\n" +
            "            \"id\": 1,\n" +
            "            \"universityId\": 2,\n" +
            "            \"departmentId\": 4,\n" +
            "            \"tutoringSubjects\": \"test ggh\"}";

    String ResponseTutors = "{\"msg\": \"Found Tutors & Tutoring Subjects\",\n" +
            "    \"tutors\": \"test ggh\"}";

    String filter = "{\"include\":\"mentoringSubject\"}";

    String mentor = "{\"mentorships\": 2 }";

    String ResponseMentors = "{\"mentors\": \"test ggh\"}";

    String Order = "{\n" +
            "  \"is_book_sold\": false,\n" +
            "  \"is_note_sold\": false,\n" +
            "  \"is_order_complete\": false,\n" +
            "  \"transaction_date\": \"$now\",\n" +
            "  \"created_at\": \"$now\",\n" +
            "  \"updated_at\": \"$now\",\n" +
            "  \"id\": 0,\n" +
            "  \"buyerId\": 0,\n" +
            "  \"bookId\": 0,\n" +
            "  \"userId\": 0,\n" +
            "  \"noteId\": 0\n" +
            "}";

    String Favorite = "{\n" +
            "  \"created_at\": \"$now\",\n" +
            "  \"updated_at\": \"$now\",\n" +
            "  \"id\": 0,\n" +
            "  \"userId\": 0,\n" +
            "  \"tutor_user_id\": 0,\n" +
            "  \"bookId\": 0,\n" +
            "  \"noteId\": 0\n" +
            "}";


    String filterTest = "{\"include\":[{\"relation\":\"orders\",\"scope\":{\"where\":{\"buyerId\":2},\"limit\":1}},{\"relation\":\"user\",\"scope\":{\"include\":[\"university\",\"department\"]}}]}";
    String BookInformation = "{\"orders\":\"\", \"user\": \"\"}";
    String NoteInformation = "{\"orders\":\"\", \"user\": \"\"}";

    String UserInformation = "{\"university\":\"\",\"department\":\"\"}";
    String FacebookResponse = "{\"picture\":{\"data\":{\"height\":200,\"is_silhouette\":false,\"url\":\"https:\\/\\/platform-lookaside.fbsbx.com\\/platform\\/profilepic\\/?asid=682658515420999&height=200&width=200&ext=1536129760&hash=AeQivCyJZEiQHkAu\",\"width\":200}},\"name\":\"Fatema Tuzzohura Jannet Riya\",\"first_name\":\"Fatema\",\"last_name\":\"Jannet Riya\",\"email\":\"aitsmotog\\u0040gmail.com\",\"id\":\"682658515420999\"}";
    String Picture = "{\"data\":{\"height\":200,\"is_silhouette\":false,\"url\":\"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=682658515420999&height=200&width=200&ext=1536129760&hash=AeQivCyJZEiQHkAu\",\"width\":200}}";
    String Data = "{\"height\":200,\"is_silhouette\":false,\"url\":\"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=682658515420999&height=200&width=200&ext=1536129760&hash=AeQivCyJZEiQHkAu\",\"width\":200}";
    String OrderHistoryResponse = "{\"msg\":\"f\",\"items\":\"f\",\"total_selling_amount\":0, }";

    String AllCount = "{booksCount: 2, notesCount: 19, tutorsCount: 3, mentorsCount: 2}";

    String SearchResponse = "{\"msg\":\"f\"}";
    String FilterResponse = "{\"books\":\"f\"}";
    String FreeItemsResponse = "{\"id\":0}";


}

//flutter packages pub run build_runner build











