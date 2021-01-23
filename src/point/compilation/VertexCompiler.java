/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class VertexCompiler {
    private ArrayList<Vertex> vertices;
    
    public VertexCompiler(ArrayList<Character> chars, ArrayList<Integer> indices){
        vertices = new ArrayList<Vertex>(indices.size());
        for(int i = 0; i < indices.size(); i ++){
            int j = indices.get(i);
            String xcontent = "", ycontent = "", zcontent = "";
            StringBuilder sx = new StringBuilder(), sy = new StringBuilder(), sz = new StringBuilder();
            while(!chars.get(j).equals(' ')){
                sx.append(chars.get(j));
                j ++;
            }
            j ++;
            while(!chars.get(j).equals(' ')){
                sy.append(chars.get(j));
                j ++;
            }
            j ++;
            while(!chars.get(j).equals('\n')){
                sz.append(chars.get(j));
                j ++;
            }
            xcontent = sx.toString();
            ycontent = sy.toString();
            zcontent = sz.toString();
            vertices.add(new Vertex(Double.parseDouble(xcontent), Double.parseDouble(ycontent), Double.parseDouble(zcontent), i+1));
        }
    }
    
    public ArrayList<Vertex> compileVertices(){
        return vertices;
    }
}
