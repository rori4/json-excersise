package com.productsshop.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReader  {
    public String readFile(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try (
                InputStream is = this.getClass().getResourceAsStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))
        ) {
            String line = reader.readLine();
            while (line != null){
                stringBuilder.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void writeFile(String path, String content){
        try (
            OutputStream os = new FileOutputStream(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
        ){
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
