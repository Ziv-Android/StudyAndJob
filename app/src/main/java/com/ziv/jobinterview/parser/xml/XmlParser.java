package com.ziv.jobinterview.parser.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用xml存储数据，在需要时解析
 * Created by Ziv on 2016/4/26.
 */
public class XmlParser extends DefaultHandler{
    // 保存解析后的结果
    private List<Product> products;
    private Product product;
    private StringBuffer buffer = new StringBuffer();

    public List<Product> getProducts(){
        return products;
    }

    /**
     * 保存解析后标签对应的的值，用来赋值给Product对象中的属性
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
        super.characters(ch, start, length);
    }

    /**
     * 开始解析一个xml文件
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        products = new ArrayList<>();
    }

    /**
     * 开始解析一个xml标签
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 当遇到<product>结点时创建Product对象
        if (localName.equals("product")){
            product = new Product();
        }
        super.startElement(uri, localName, qName, attributes);
    }

    /**
     * 标签解析完成
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // 遇到<product>结点后将在startElement方法中创建的Product对象添加到List对象{products}中
        if (localName.equals("product")){
            products.add(product);
        }
        // 遇到<id>结点后将节点值赋给Product.id属性
        if (localName.equals("id")){
            product.setId(Integer.parseInt(buffer.toString().trim()));
            // 清空数据缓冲区
            buffer.setLength(0);
        }
        if (localName.equals("name")){
            product.setName(buffer.toString().trim());
            buffer.setLength(0);
        }
        if (localName.equals("price")){
            product.setPrice(Float.parseFloat(buffer.toString().trim()));
            buffer.setLength(0);
        }
        super.endElement(uri, localName, qName);
    }

    /**
     * xml文件解析完成
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
