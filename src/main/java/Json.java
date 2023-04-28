import  com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class Json {

    public Json(){

    }
    public void writeToFileJson(String file, List<Student> students){
        ObjectMapper  objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            objectMapper.writeValue(new File(file),students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Student> readFromFileJson(String file){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();

        try {
            List<Student> students = objectMapper.readValue(new File(file)  , new TypeReference<>(){});
            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
