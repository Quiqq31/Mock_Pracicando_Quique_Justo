package com.example.Backend2;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonManager {
      public ArrayList<Vehicle> getUsers() throws IOException{
    String root = System.getProperty("user.dir");
    String path = root + "/src/main/resources/users.json";
    String jsonContent = new String(Files.readAllBytes(Paths.get(path)));
    Gson gson = new Gson();
    Type userListType = new TypeToken<ArrayList<Vehicle>>(){}.getType();
    ArrayList<Vehicle> users = gson.fromJson(jsonContent, userListType);
    return users;
  }

  public void saveUsers(ArrayList<Vehicle> users) throws IOException{
    Gson gson = new Gson();
    String jsonContent = gson.toJson(users);
    String projectRoot = System.getProperty("user.dir");
    String path = projectRoot + "/src/main/resources/users.json";
    Writer writer = Files.newBufferedWriter(Paths.get(path));
    writer.write(jsonContent);
    writer.close();
  }
}
