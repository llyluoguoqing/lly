package com.lly.demo.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileInputStream;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Picture;
import org.w3c.dom.Document;

public class docTohtml {


    public static void main(String[] args) throws Exception {
        docxToHtml();
    }

    public static void docxToHtml() throws Exception {
        String sourceFileName = "D:/zpdtolly/工作总结文档/客户端/x86/客户端x86版使用手册网络版.doc";
        String targetFileName = "D:/zpdtolly/工作总结文档/客户端/x86/客户端x86版使用手册网络版.html";
        String imagePathStr = "D:/doc2htmltest/image/";
        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager((a, b, suggestedName, d, e) -> {
           // convertFileToBase64()
            System.out.println(suggestedName);

            //返回图片路径
            //return "image" + File.separator + suggestedName;
            //返回图片base64值
            return "data:image/"+b.getExtension().toLowerCase()+";base64,"+new String(Base64.encodeBase64(a));
        });
        wordToHtmlConverter.processDocument(wordDocument);
        List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();
        System.out.println(pics);
        Iterator var8 = pics.iterator();

        //转换图片
        imgToBase64 imgToBase64pl=new imgToBase64();
        int i=1;
        while(var8.hasNext()) {
            Picture pic = (Picture)var8.next();
            //下载图片
           // pic.writeImageContent(new FileOutputStream(imagePathStr + pic.suggestFullFileName()));
            //System.out.println("第"+i++ +":"+imgToBase64pl.convertFileToBase64(imagePathStr + pic.suggestFullFileName()));
        }

        Document htmlDocument = wordToHtmlConverter.getDocument();
        //生成空文档
        DOMSource domSource = new DOMSource(htmlDocument);
        //获取路径下html
        StreamResult streamResult = new StreamResult(new File(targetFileName));
        //设置html文件规范
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty("encoding", "utf-8");
        serializer.setOutputProperty("indent", "yes");
        serializer.setOutputProperty("method", "html");
        serializer.transform(domSource, streamResult);
        System.out.println("doc转换完毕！"+streamResult.getSystemId());


    }
}

