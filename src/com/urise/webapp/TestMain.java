package com.urise.webapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Java\\bjava\\src\\com\\urise\\webapp");
//        List<Path> strings = null;
//        try (Stream<Path> walk = Files.walk(path)){
//            strings = walk.filter(Files::isRegularFile).collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assert strings != null;
//        strings.forEach(System.out::println);
        Stream<Path> list = null;
        try {
            list = Files.list(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert list != null;
        System.out.println(list.toArray().length);
    }
}
