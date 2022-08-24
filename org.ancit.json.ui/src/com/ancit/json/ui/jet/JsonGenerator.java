package com.ancit.json.ui.jet;

import Json.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonGenerator
{
  protected static String nl;
  public static synchronized JsonGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    JsonGenerator result = new JsonGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t{  " + NL + "   \"Cluster\": " + NL + "\t[\t" + NL + "\t\t{" + NL + "\t\t  \"Name\": ";
  protected final String TEXT_2 = "," + NL + "\t}" + NL + "\t]\t" + NL + "\t\t}";
  protected final String TEXT_3 = NL + "\t\t{  " + NL + "   \"Node1\": " + NL + "\t[\t" + NL + "\t\t{" + NL + "\t\t  \"Name\": ";
  protected final String TEXT_4 = "," + NL + "\t\t  \"Type\": ";
  protected final String TEXT_5 = ", " + NL + "\t\t  ";
  protected final String TEXT_6 = NL + "\t\t\"Date\":=";
  protected final String TEXT_7 = NL + "\t}" + NL + "\t]\t" + NL + "\t\t}";
  protected final String TEXT_8 = NL + "\t\t{  " + NL + "   \"Node2\": " + NL + "\t[\t" + NL + "\t\t{" + NL + "\t\t  \"Name\": ";
  protected final String TEXT_9 = NL + "\t\t{  " + NL + "   \"Node3\": " + NL + "\t[\t" + NL + "\t\t{" + NL + "\t\t  \"Name\": ";
  protected final String TEXT_10 = NL + "\t\t{  " + NL + "   \"Node4\": " + NL + "\t[\t" + NL + "\t\t{" + NL + "\t\t  \"Name\": ";
  protected final String TEXT_11 = NL + "\t\t{  " + NL + "   \"Node5\": " + NL + "\t[\t" + NL + "\t\t{" + NL + "\t\t  \"Name\": ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Object argument2 = argument;
	  if (argument2 instanceof Cluster) {
		Cluster cluster = (Cluster) argument2;
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cluster.getName());
    stringBuffer.append(TEXT_2);
    
		}
	  else if (argument2 instanceof Node1) {
		Node1 node1 = (Node1) argument2;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(node1.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(node1.getType().getLiteral());
    stringBuffer.append(TEXT_5);
    
		  	DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		  String date=df.format(node1.getDate());
		  
    stringBuffer.append(TEXT_6);
    stringBuffer.append(date);
    stringBuffer.append(TEXT_7);
    
	}
	 else if (argument2 instanceof Node2) {
		Node2 node2 = (Node2) argument2;
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(node2.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(node2.getType().getLiteral());
    stringBuffer.append(TEXT_5);
    
		  	DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		  String date=df.format(node2.getDate());
		  
    stringBuffer.append(TEXT_6);
    stringBuffer.append(date);
    stringBuffer.append(TEXT_7);
    
		
	}
	 else if (argument2 instanceof Node3) {
		Node3 node3 = (Node3) argument2;
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(node3.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(node3.getType().getLiteral());
    stringBuffer.append(TEXT_5);
    
		  	DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		  String date=df.format(node3.getDate());
		  
    stringBuffer.append(TEXT_6);
    stringBuffer.append(date);
    stringBuffer.append(TEXT_7);
    
		
	}
	 else if (argument2 instanceof Node4) {
		Node4 node4 = (Node4) argument2;
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(node4.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(node4.getType().getLiteral());
    stringBuffer.append(TEXT_5);
    
		  	DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		  String date=df.format(node4.getDate());
		  
    stringBuffer.append(TEXT_6);
    stringBuffer.append(date);
    stringBuffer.append(TEXT_7);
    
		
	}
	 else if (argument2 instanceof Node5) {
		Node5 node5 = (Node5) argument2;
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(node5.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(node5.getType().getLiteral());
    stringBuffer.append(TEXT_5);
    
		  	DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		  String date=df.format(node5.getDate());
		  
    stringBuffer.append(TEXT_6);
    stringBuffer.append(date);
    stringBuffer.append(TEXT_7);
    
		
	}
    return stringBuffer.toString();
  }
}
