/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class SelPtCompiler {
    private ArrayList<SelPt> setpoints;
    
    public SelPtCompiler(ArrayList<Character> chars, ArrayList<Integer> indices){
        setpoints = new ArrayList<SelPt>(indices.size());
        for(int i = 0; i < indices.size(); i ++){
            int j = indices.get(i);
            String namecontent = "", vcontent = "", fcontent = "";
            StringBuilder sn = new StringBuilder(), sv = new StringBuilder(), sf = new StringBuilder();
            while(!chars.get(j).equals(' ')){
                sn.append(chars.get(j));
                j ++;
            }
            j ++;
            while(!chars.get(j).equals(' ')){
                sv.append(chars.get(j));
                j ++;
            }
            j ++;
            while(!chars.get(j).equals('\r')){
                sf.append(chars.get(j));
                j ++;
            }
            namecontent = sn.toString();
            vcontent = sv.toString();
            fcontent = sf.toString();
            setpoints.add(new SelPt(namecontent, Integer.parseInt(vcontent), Integer.parseInt(fcontent)));
        }
    }
    
    public void cleanSetPt(){
        for(int i = 0; i < setpoints.size(); i ++){
            String temp = setpoints.get(i).getname();
            for(int j = i+1; j < setpoints.size(); j ++){
                if(temp.equalsIgnoreCase(setpoints.get(j).getname())){
                    setpoints.remove(j);
                    j--;
                }
            }
        }
    }
    
    public ArrayList<SelPt> compileSetPt(){
        return setpoints;
    }
}
