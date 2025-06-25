package kr.project;

import org.json.JSONArray;
import org.json.JSONObject;

public class project01B {
    public static void main(String[] args) {
        JSONArray students = new JSONArray();
        JSONObject student = new JSONObject();
        student.put("name", "solJava");
        student.put("phone", "010-1234-5678");
        student.put("address", "종로구 관철동");
        System.out.println(student);
        students.put(student);

        student.put("name", "건강박수");
        student.put("phone", "010-1234-5678");
        student.put("address", "하라다머레이");
        
        System.out.println(student);
        students.put(student);
        System.out.println(students);
        System.out.println(students.toString(2));

        JSONObject object = new JSONObject();
        object.put("stinfo", students);
        System.out.println(object);
        System.out.println(object.toString(2));
    }
}
