/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ObjReader {
    private String name;
    private String directory;
    private ArrayList<Character> content;
    private ArrayList<Integer> vindex;
    private ArrayList<Integer> findex;
    private ArrayList<Integer> vnindex;
    
    public ObjReader(String name, String directory) throws FileNotFoundException, Exception{
        this.name = name;
        this.directory = directory;
        FileReader File = new FileReader(directory);
        content = new ArrayList<Character>();
        int marker;
        while((marker = File.read())!= -1) content.add((char)marker);
        File.close();
        vindex = new ArrayList<Integer>();
        findex = new ArrayList<Integer>();
        vnindex = new ArrayList<Integer>();
        for(int i = 0; i < content.size() - 2; i ++){
            if(content.get(i).equals('v') && content.get(i+1).equals(' ')) vindex.add(i+2);
            if(content.get(i).equals('f') && content.get(i+1).equals(' ')) findex.add(i+2);
            if(content.get(i).equals('v') && content.get(i+1).equals('n') && content.get(i+2).equals(' ')) vnindex.add(i+3);
        }
    }
    
    public ArrayList<Character> compileContent(){
        return content;
    }
    
    public ArrayList<Integer> compileVindex(){
        return vindex;
    }
    
    public ArrayList<Integer> compileFindex(){
        return findex;
    }
    
    public ArrayList<Integer> compileVNindex(){
        return vnindex;
    }
}
