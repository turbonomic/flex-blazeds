/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package blazeds.qa.remotingService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Calendar;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.sql.Time;
import java.sql.Timestamp;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

import flex.messaging.FlexContext;
import flex.messaging.io.PropertyProxyRegistry;
import flex.messaging.io.PropertyProxy;
import flex.messaging.io.ArrayCollection;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;


public class Echo
{
    static
    {
        PropertyProxyRegistry registry = PropertyProxyRegistry.getRegistry();
        PropertyProxy proxy = registry.getProxy(java.io.File.class);
        if (proxy == null)
        {
            registry.register(java.io.File.class, new FileProxy());
        }
        proxy = registry.getProxy(FileReference.class);
        if (proxy == null)
        {
            registry.register(FileReference.class, new FileReferenceProxy());
        }    
    }
    public Echo()
    {

    }
    
    public BigDecimal echoBigDecimal(BigDecimal bigD)
    {
        return bigD;
    }

    public BigDecimal[] echoBigDecimals(BigDecimal[] bigD)
    {
        return bigD;
    }
    
    //  BigInteger
    public BigInteger echoBigInteger(BigInteger bigI)
    {
        return bigI;
    }

    public BigInteger[] echoBigIntegers(BigInteger[] bigI)
    {
        return bigI;
    }

    //boolean
    public boolean echoBoolean(boolean b)
    {
        return b;
    }

    public Boolean echoBooleanClass(Boolean b)
    {
        return b;
    }

    public boolean[] echoBooleans(boolean[] b)
    {
        return b;
    }

    public Boolean[] echoBooleanClasses(Boolean[] b)
    {
        return b;
    }

    //int
    public int echoInt(int i)
    {
        return i;
    }

    public Integer echoIntClass(Integer i)
    {
        return i;
    }

    public int[] echoInts(int[] i)
    {
        return i;
    }

    public Integer[] echoIntClasses(Integer[] i)
    {
        return i;
    }

    //short
    public short echoShort(short s)
    {
        return s;
    }

    public Short echoShortClass(Short s)
    {
        return s;
    }

    public short[] echoShorts(short[] s)
    {
        return s;
    }

    public Short[] echoShortClasses(Short[] s)
    {
        return s;
    }

    //byte
    public byte echoByte(byte b)
    {
        return b;
    }

    public Byte echoByteClass(Byte b)
    {
        return b;
    }

    public byte[] echoBytes(byte[] b)
    {
        return b;
    }

    public Byte[] echoByteClasses(Byte[] b)
    {
        return b;
    }

    //long
    public long getLong()
    {
        return Long.MAX_VALUE;
    }

    public long echoLong(long l)
    {
        return l;
    }

    public Long echoLongClass(Long l)
    {
        return l;
    }

    public long[] echoLongs(long[] l)
    {
        return l;
    }

    public Long[] echoLongClasses(Long[] l)
    {
        return l;
    }

    //float
    public float echoFloat(float f)
    {
        return f;
    }

    public Float echoFloatClass(Float f)
    {
        return f;
    }

    public float[] echoFloats(float[] f)
    {
        return f;
    }

    public Float[] echoFloatClasses(Float[] f)
    {
        return f;
    }

    //double
    public double echoDouble(double d)
    {
        return d;
    }

    public Double echoDoubleClass(Double d)
    {
        return d;
    }

    public double[] echoDoubles(double[] d)
    {
        return d;
    }

    public Double[] echoDoubleClasses(Double[] d)
    {
        return d;
    }

    //char
    public char echoChar(char c)
    {
        return c;
    }

    public Character echoCharacterClass(Character c)
    {
        return c;
    }

    public char[] echoChars(char[] c)
    {
        return c;
    }

    public Character[] echoCharacterClasses(Character[] c)
    {
        return c;
    }

    //string
    public String echoString(String s)
    {
        return s;
    }

    public String[] echoStrings(String[] s)
    {
        return s;
    }

    //Date
    public java.util.Date echoDate(java.util.Date d)
    {
        return d;
    }

    public java.util.Date[] echoDates(java.util.Date[] d)
    {
        return d;
    }

    public Time echoTime(Time t)
    {
        return t;
    }

    public Time[] echoTimes(Time[] t)
    {
        return t;
    }

    public Timestamp echoTimestamp(Timestamp t)
    {
        return t;
    }

    public Timestamp[] echoTimestamps(Timestamp[] t)
    {
        return t;
    }

    public java.sql.Date echoSQLDate(java.sql.Date d)
    {
        return d;
    }

    public java.sql.Date[] echoSQLDates(java.sql.Date[] d)
    {
        return d;
    }
    
    public Calendar echoCalendar(Calendar c)
    {
        return c;
    }
    
    public Calendar[] echoCalendars(Calendar[] c)
    {
        return c;
    }
    
    public Document echoXML(Document d)
    {
        return d;
    }
    
    //Strongly Typed Objects
    public Book echoBook(Book b)
    {
        return b;
    }

    public Book[] echoBooks(Book[] b)
    {
        return b;
    }
    public Book getBook()
    {
    	return new Book();
    }

    //Object
    public Object echoObject(Object o)
    {
        return o;
    }

    public String getObjectClassName(Object o)
    {
        if (o != null)
            return o.getClass().getName();
        else
            return "null";
    }

    public Object[] echoObjects(Object[] o)
    {
        return o;
    }

    public String[] getObjectClassNames(Object[] o)
    {
        String[] names = new String[o.length];
        for (int i = 0; i < names.length; i++)
        {
            names[i] = o[i].getClass().getName();
        }
        return names;
    }

    //Collection
    public Collection echoVector(Vector v)
    {
        return v;
    }

    public Collection echoVector(Vector v, String name) throws Exception
    {
        Object temp;
        int len = v.size();
        for (int i = 0; i < len; i++)
        {
            temp = v.elementAt(i);
            System.out.println("Element Type:" + temp.getClass().getName() + ",expected type:" + name);
            if (temp != null && !temp.getClass().getName().equals(name))
                throw new Exception("Incorrect type");
        }
        return v;
    }

    public Collection echoLinkedList(LinkedList l)
    {
        return l;
    }

    public Collection echoLinkedList(LinkedList l, String name) throws Exception
    {
        Object temp;
        int len = l.size();
        for (int i = 0; i < len; i++)
        {
            temp = l.get(i);
            System.out.println("Element Type:" + temp.getClass().getName() + ",expected type:" + name);
            if (temp != null && !temp.getClass().getName().equals(name))
                throw new Exception("Incorrect type");
        }
        return l;
    }

    public Collection echoArrayList(ArrayList l)
    {
        return new ArrayList(l);
    }

    public Collection echoArrayList(ArrayList a, String name) throws Exception
    {
        Object temp;
        int len = a.size();
        for (int i = 0; i < len; i++)
        {
            temp = a.get(i);
            System.out.println("Element Type:" + temp.getClass().getName() + ",expected type:" + name);
            if (temp != null && !temp.getClass().getName().equals(name))
                throw new Exception("Incorrect type");
        }
        return new ArrayList(a);
    }

    public Collection echoHashSet(HashSet h)
    {
        return h;
    }

    public Collection echoHashSet(HashSet s, String name) throws Exception
    {
        Object temp;
        Iterator iterator = s.iterator();
        for (; iterator.hasNext();)
        {
            temp = iterator.next();
            System.out.println("Element Type:" + temp.getClass().getName() + ",expected type:" + name);
            if (temp != null && !temp.getClass().getName().equals(name))
                throw new Exception("Incorrect type");
        }
        return s;
    }

    public byte[] getPictureAsBytes()  throws Exception{
        String path = FlexContext.getServletContext().getRealPath("/");
        path = path.charAt(path.length()-1 ) == '/'? path : path + "/";
        File pic = new File(path + "caching/type1.jpg");
        if (pic.exists()) {
            FileInputStream fos = new FileInputStream(pic);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            int b;
            while ((b = fos.read()) > -1) {
                bao.write(b);
            }
            return bao.toByteArray();
        }
        return null;
    }

    public void writePicToFile(byte[] bytes, String fileName) throws Exception {
        String path = FlexContext.getServletContext().getRealPath("/");
        path = path.charAt(path.length()-1 ) == '/'? path : path + "/";
        FileOutputStream fos = new FileOutputStream(path +fileName);
        fos.write(bytes);
        fos.close();
    }
    
    public void getCustomException() throws Exception
    {
        CustomException e = new CustomException();
        e.setReason("some reason");
        throw e;
    }

    public File echoFile(File file)
    {
        return file;
    }

    /**
     *
     * @param doc -  w3c XML Document
     * @param shouldHasNamespace - if it is true and the document.getNamespace return null, it throws exception
     * @return passed in doc
     * @throws Exception
     */
    public Document echoDocument(Document doc, boolean shouldHasNamespace) throws Exception
    {
        StringWriter sw = new StringWriter();
        Transformer serializer = TransformerFactory.newInstance().newTransformer();
        serializer.transform(new DOMSource(doc), new StreamResult(sw));
        String namespace = doc.getFirstChild().getNamespaceURI();
        if (namespace == null && shouldHasNamespace)
        {
            throw new Exception("No namespace");
        }
        return doc;
    }

    /**
     *
     * @return a document which multiple namespaces
     * @throws Exception
     */
    public Document getDocument() throws Exception
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder dbuilder = dbf.newDocumentBuilder();
        Document doc = dbuilder.newDocument();

        Element root = doc.createElementNS("http://www.adobe.com/qa", "qa:testsuites");
        doc.appendChild(root);
        Element flexunit = doc.createElementNS("http://foo", "foo:flexunit");
        root.appendChild(flexunit);
        flexunit.appendChild(doc.createTextNode("bar"));
        return doc;
    }

    public List echoDenseArray(List array)
    {
        return array;
    }

    public Map echoSparseArray(Map array)
    {
        return array;
    }

    public Map echoMap(Map map)
    {
        return map;
    }

    public Map echoDictionary(Map dict)
    {
        return dict;
    }

    public ArrayList echoIntVector(ArrayList vector)
    {
        return vector;
    }

    public ArrayList echoUIntVector(ArrayList vector)
    {
        return vector;
    }

    public ArrayList echoDoubleVector(ArrayList vector)
    {
        return vector;
    }

    public ArrayList echoObjectVector(ArrayList vector)
    {
        return vector;
    }

    public ArrayList echoStringVector(ArrayList vector)
    {
        return vector;
    }
}
