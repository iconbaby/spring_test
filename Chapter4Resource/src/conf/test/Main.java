package conf.test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.WritableResource;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/slkk/spring_projects/Chapter4Resource/src/test.txt";
        WritableResource res1 = new PathResource(filePath);
        ClassPathResource res2 = new ClassPathResource("Main.java");
        String absolutePath = res2.getFile().getAbsolutePath();

        System.out.println(absolutePath);
        OutputStream stream1 = res1.getOutputStream();
        stream1.write("欢迎来到spring".getBytes());
        stream1.close();
        InputStream ins1 = res1.getInputStream();
        InputStream ins2 = res2.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = ins1.read()) != -1) {
            baos.write(i);
        }
        System.out.println(baos.toString());

        System.out.println("res1:" + res1.getFilename());
        System.out.println("res2" + res2.getFilename());

    }
}
