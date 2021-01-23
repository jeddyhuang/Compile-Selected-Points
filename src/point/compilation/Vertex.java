/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

/**
 *
 * @author Jerry
 */
public class Vertex {
    private int index;
    private final double x;
    private final double y;
    private final double z;
    
    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vertex(double x, double y, double z, int index){
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getZ(){
        return z;
    }
    
    public int getindex(){
        return index;
    }
}
