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
public class SelPtReader {
    private String name;
    private String directory;
    private ArrayList<Character> content;
    private ArrayList<Integer> ptindex;
    
    public SelPtReader(String directory) throws FileNotFoundException, Exception{
        this.directory = directory;
        FileReader File = new FileReader(directory);
        content = new ArrayList<Character>();
        int marker;
        while((marker = File.read())!= -1) content.add((char)marker);
        File.close();
        ptindex = new ArrayList<Integer>();
        ptindex.add(0);
        for(int i = 1; i < content.size()-1; i ++){
            if(content.get(i).equals('\n')) ptindex.add(i+1);
        }
    }
    
    public ArrayList<Character> compileContent(){
        return content;
    }
    
    public ArrayList<Integer> compilePTindex(){
        return ptindex;
    }
}
