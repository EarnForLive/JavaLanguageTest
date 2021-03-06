package com.example.script;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/3 10:44 上午
 */
public class ChoseWhiteOrBlackList {

    public static void main(String[] args) throws IOException {
        AddAllFilesPath addAllFilesPath = new AddAllFilesPath();

        Scanner in = new Scanner(System.in);
        String src;
        src = in.nextLine();
        File srcFile = new File(src);

        List<String> allFiles = new ArrayList<>();

        allFiles = (List<String>) addAllFilesPath.collectAllPath1(allFiles, srcFile);
        // print(allFiles);

//        读取黑白名单中的数据
        src = in.nextLine();
//        JDK8中按行读取全部内容的方法
        Path path = Paths.get(src);
        List<String> lines = Files.readAllLines(path);

//        直接在定义时把List转换为Set
        List<String> listlines = new ArrayList<>(lines);

//        System.out.println(listlines);

        System.out.println();
        System.out.println(src);


//        显示处理后的结果
        if (src.endsWith("whitelist.txt")) {
            System.out.println("src.endsWith(\"whitelist.txt\")");
            print(doWhiteList(allFiles, listlines));
        } else {
            if (src.endsWith("blacklist.txt")) {
                System.out.println("src.endsWith(\"blacklist.txt\")");
                print(doBlackList(allFiles, listlines));
            }
        }

        in.close();
    }

    private static void print(List<String> allFiles) {
        System.out.println();
        System.out.printf("共有%d行信息", allFiles.size());
        System.out.println();
        for (String s : allFiles) {
            System.out.println(s);
        }
    }

//    private static Set<String> doWhiteList(Set<String> allFiles, Set<String> whitelines) {
//
//        Set<String> adds = new HashSet<>();
////        内部实现使用的是迭代器，在遍历的时候不能进行删除操作
//        for (String all : allFiles) {
//            for (String white : whitelines) {
//                if (all.startsWith(white)) {
//                    adds.add(all);
//                    break;
//                }
//            }
//        }
//        return adds;
//    }
//
//    private static Set<String> doBlackList(Set<String> allFiles, Set<String> blacklines) {
//        List<String> deletes = new ArrayList<>();
////        内部实现使用的是迭代器，在遍历的时候不能进行删除操作
//        for (String all : allFiles) {
//            for (String black : blacklines) {
//                if (all.startsWith(black)) {
//                    deletes.add(all);
//                    break;
//                }
//            }
//        }
////        进行删除操作
//        for (String s : deletes) {
//            allFiles.remove(s);
//        }
//        return allFiles;
//    }


    private static List<String> doWhiteList(List<String> allFiles, List<String> whitelines) {
        List<String> adds = new ArrayList<>();
//        内部实现使用的是迭代器，在遍历的时候不能进行删除操作
        for (String all : allFiles) {
            for (String white : whitelines) {
                if (all.startsWith(white)) {
                    adds.add(all);
                    break;
                }
            }
        }
        return adds;
    }

    private static List<String> doBlackList(List<String> allFiles, List<String> blacklines) {
        List<String> deletes = new ArrayList<>();
//        内部实现使用的是迭代器，在遍历的时候不能进行删除操作
        for (String all : allFiles) {
            for (String black : blacklines) {
                if (all.startsWith(black)) {
                    deletes.add(all);
                    break;
                }
            }
        }
//        进行删除操作
        for (String s : deletes) {
            allFiles.remove(s);
        }
        return allFiles;
    }
}
