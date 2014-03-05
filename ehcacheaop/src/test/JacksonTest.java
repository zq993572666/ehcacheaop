package test;

import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
/**
 * java json工具类
 * */
public class JacksonTest {

    private JsonGenerator jsonGenerator = null;

    private ObjectMapper objectMapper = null;


    @Before

   
    public void init() {

        bean = new AccountBean();

        bean.setAddress("china-Guangzhou");

        bean.setEmail("hoojo_@126.com");

        bean.setId(1);

        bean.setName("hoojo");

        

        objectMapper = new ObjectMapper();

        try {

            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    

    @After
    public void destory() {

        try {

            if (jsonGenerator != null) {

                jsonGenerator.flush();

            }

            if (!jsonGenerator.isClosed()) {

                jsonGenerator.close();

            }

            jsonGenerator = null;

            objectMapper = null;


            System.gc();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
    @Test

    public void writeEntityJSON() {

        try {

            System.out.println("jsonGenerator");

            //writeObject可以转换java对象，eg:JavaBean/Map/List/Array等


            System.out.println();

            

            System.out.println("ObjectMapper");

            //writeValue具有和writeObject相同的功能

            objectMapper.writeValue(System.out, bean);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}