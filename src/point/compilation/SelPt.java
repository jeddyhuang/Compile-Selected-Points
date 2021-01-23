/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.util.ArrayList;

/**
 *
 * @author Jerry
 */
public class SelPt {
    private String name;
    private int findex;
    private Vertex main;
    private int mainindex;
    
    public SelPt(String name, int vindex, int findex){
        this.name = name;
        mainindex = vindex;
        this.findex = findex;
    }
    
    public String getname(){
        return name;
    }
    
    public int getv1index(){
        return mainindex;
    }
}
