package com.lly.demo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.parser.XmlTreeBuilder;
import org.jsoup.select.Elements;


import java.io.*;


public class htmlgonorm {

    public static void main(String[] args) throws Exception {
        htmlgonorm();
    }

    public static void htmlgonorm() throws Exception {
        String filePath = "D:\\doc2htmltest\\aaaa.html";
        //读取.html文件为字符串
        File input = new File(filePath);
        Document doc1 =Jsoup.parse(input,"utf-8","");

        Element style = doc1.select("style").first();
        style.prepend("body{background:#e6d8d8;text-align:center;}\n" +
                "\n" +
                "div{width:100%;margin:0 auto;background:#ecdfdf;text-align:left;}\n" +
                "* {\n" +
                "  padding: 0;\n" +
                "  margin: 0;\n" +
                "  box-sizing: border-box;\n" +
                "}\n" +
                ".aside {\n" +
                "  width: 240px;\n" +
                "  height: 100%;\n" +
                "  position: fixed;\n" +
                "  left: -240px;\n" +
                "  top: 0px;\n" +
                "  border-right: 1px solid #ccc;\n" +
                "  -ms-transition: all 0.3s linear;\n" +
                "  -moz-transition: all 0.3s linear;\n" +
                "  -webkit-transition: all 0.3s linear;\n" +
                "  transition: all 0.3s linear;\n" +
                "}\n" +
                ".aside:hover{\n" +
                "  left: 0;\n" +
                "}\n" +
                ".aside:hover + .article{\n" +
                "  padding-left: 260px;\n" +
                "}\n" +
                ".nav-list{\n" +
                "  width: 100%;\n" +
                "  height: 100%;\n" +
                "  overflow: auto;\n" +
                "  padding: 10px 0px;\n" +
                "}\n" +
                ".nav-mark{\n" +
                "  position: absolute;\n" +
                "  right: -20px;\n" +
                "  top: 50%;\n" +
                "  z-index: 2;\n" +
                "  height: 80px;\n" +
                "  width: 20px;\n" +
                "  margin-top: -40px;\n" +
                "  background-color: #44a7ff;\n" +
                "  box-shadow: 2px 0px 3px #eee;\n" +
                "  border-radius: 0 40px 40px 0;\n" +
                "  font-size: 12px;\n" +
                "  text-align: center;\n" +
                "  line-height: 24px;\n" +
                "  padding-top: 16px;\n" +
                "  color: #fff;\n" +
                "}\n" +
                ".nav {\n" +
                "  display: block;\n" +
                "  width: 100%;\n" +
                "  height: 32px;\n" +
                "  line-height: 32px;\n" +
                "  font-size: 16px;\n" +
                "  color: #333;\n" +
                "  text-decoration: none;\n" +
                "  padding-left: 20px;\n" +
                "}\n" +
                ".nav:hover {\n" +
                "  background-color: #44a7ff;\n" +
                "  color: #fff;\n" +
                "}\n" +
                "\n" +
                ".grade2 {\n" +
                "  text-indent: 1em;\n" +
                "}\n" +
                "\n" +
                ".grade3 {\n" +
                "  text-indent: 2em;\n" +
                "}\n");
        //style.attr("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


        Element p8 = doc1.getElementsByClass("p8").first();
        Element p5 = doc1.getElementsByClass("p5").last();

        p8.before(" <aside class=\"aside\">\n" +
                "    <div class=\"nav-list\">");

        p5.after("</div>\n" +
                "<div class=\"nav-mark\">导航</div>\n" +
                "</aside>");


        System.out.println(style);
        System.out.println(p8);
        System.out.println(p5);
        String newStr = doc1.toString();//处理后的HTML
        PrintStream ps = new PrintStream(new FileOutputStream(input));
        ps.println(newStr);// 将HTML文件里写入修改好的内容

        //解析字符串为Document对象
        //Document doc = Jsoup.parse(htmlStr);
       //doc.getElementsByTag("style").addClass("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        //获取body元素，获取class="fc"的table元素
        //Elements table = doc.body().getElementsByClass("p8");
        //获取tbody元素
        //Elements children = table.first().children();
        //获取tr元素集合
//        Elements tr = table.get(0).getElementsByTag("head");
//
//        //遍历tr元素，获取td元素，并打印
//        for (int i = 0; i < tr.size(); i++) {
//            Element e1 = tr.get(i);
//            Elements td = e1.getElementsByTag("td");
//            for (int j = 0; j < td.size(); j++) {
//                String value = td.get(j).text();
//                System.out.print("  " + value);
//            }
//            System.out.println();
//        }
    }



    /**
     *  读取本地html文件里的html代码
     * @return
     */
    public static String toHtmlString(File file) {
        // 获取HTML文件流
        StringBuffer htmlSb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "utf-8"));
            while (br.ready()) {
               htmlSb.append(br.readLine());
            }
            br.close();
            // 删除临时文件
            //file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // HTML文件字符串
        String htmlStr = htmlSb.toString();
        System.out.println(htmlStr);
        // 返回经过清洁的html文本
        return htmlStr;
    }

}
