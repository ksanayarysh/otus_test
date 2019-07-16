package data;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestData {

    public static Person readJson() throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("MyJson.txt")));
        String s = br.readLine();
        br.close();
        Gson g = new Gson();
        return g.fromJson(s, Person.class);
    }

}
