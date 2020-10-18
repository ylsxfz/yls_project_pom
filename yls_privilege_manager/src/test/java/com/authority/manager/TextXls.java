package com.authority.manager;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Auther: yls
 * @Date: 2020/10/18 14:27
 * @Description:
 * @Version 1.0
 */
public class TextXls {
    public static void main(String[] args) {
        //创建存储数据
        Map<String, Map<String,Integer>> contentMap = new HashMap<>();
        try {
            jxl.Workbook wb = null;
            InputStream is = new FileInputStream("D:\\workspace\\demo.xls");
            wb = Workbook.getWorkbook(is);

            int sheetSize = wb.getNumberOfSheets();
            Sheet sheet = wb.getSheet(0);
            int row_total = sheet.getRows();
            // 第一列的标记位
            String newTemp = "";
            for (int j = 1; j < row_total; j++) {
                Cell[] cells = sheet.getRow(j);
                String contentsFirst = cells[0].getContents();
                String contentsTwo = cells[1].getContents();

                if (!"0".equals(contentsFirst)&& !"".equals(contentsFirst)){
                    newTemp = j+"_"+contentsFirst;
                }

                if (contentMap.containsKey(newTemp)){
                    Map<String, Integer> stringIntegerMap = contentMap.get(newTemp);
                    if (stringIntegerMap.containsKey(contentsTwo)){
                        stringIntegerMap.put(contentsTwo,stringIntegerMap.get(contentsTwo)+1);
                    }else {
                        stringIntegerMap.put(contentsTwo,1);
                    }
                }else {
                    Map<String, Integer> stringIntegerMap = new HashMap<>();
                    stringIntegerMap.put(contentsTwo,1);
                    contentMap.put(newTemp,stringIntegerMap);
                }

                // 打印每一行
                //System.out.println(cells[0].getContents()+","+cells[1].getContents()+","+cells[2].getContents());

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        Map<String, Map<String, Integer>> resultContentMap = sortMapKey(contentMap);

        System.out.println("第一列标记，第二列的值，去重数量，不去重数量");
        resultContentMap.forEach((key,value)->{
            Collection<Integer> values = value.values();
            int sum = values.stream().mapToInt(Integer::intValue).sum();
            System.err.println(key+":"+value.size()+":"+sum);
        });

        System.out.println();
        /**
         * 重复次数大于指定的数
         */
        int compareNum = 2;
        resultContentMap.forEach((key,value)->{
            Collection<Integer> values = value.values();
            int sum = values.stream().mapToInt(Integer::intValue).sum();
            // 重复数据量大于4
            value.forEach((tempKey,tempValue)->{
                if (tempValue>compareNum){
                    System.out.println("重复次数大于"+compareNum+"："+key+"=>"+tempKey+"=>"+tempValue);
                }
            });
        });
    }

    /**
     * @Description 生成UUID，全为小写
     * @return java.lang.String
     **/
    public static String uuidUpperCase() {
        return UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");
    }


    public static Map<String, Map<String, Integer>> sortMapKey(Map<String, Map<String,Integer>> map) {
        List<Map.Entry<String, Map<String,Integer>>> list = new ArrayList(map.entrySet());
        list.sort((o1, o2) -> Integer.parseInt(o1.getKey().split("_")[0]) - Integer.parseInt(o2.getKey().split("_")[0]));
        Map<String, Map<String,Integer>> linkedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : list) {
            linkedMap.put(entry.getKey(), entry.getValue());
        }
        return linkedMap;
    }

}
