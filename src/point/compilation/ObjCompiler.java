/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.compilation;

import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

/**
 *
 * @author Jerry
 */
public class ObjCompiler{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        JFileChooser selectedobj = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        selectedobj.setDialogTitle("Select a .obj File:");
        selectedobj.setAcceptAllFileFilterUsed(false);
        selectedobj.addChoosableFileFilter(new FileNameExtensionFilter(".obj Files", "obj"));
        if(selectedobj.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
        
        JFileChooser selectedtxt = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        selectedtxt.setDialogTitle("Select a .txt File:");
        selectedtxt.setAcceptAllFileFilterUsed(false);
        selectedtxt.addChoosableFileFilter(new FileNameExtensionFilter(".txt Files", "txt"));
        if(selectedtxt.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
        
        String name = selectedobj.getSelectedFile().getName().substring(0, selectedobj.getSelectedFile().getName().length()-4);
        
        ObjReader obj = new ObjReader(name, selectedobj.getSelectedFile().getAbsolutePath());
        VertexCompiler vcom = new VertexCompiler(obj.compileContent(), obj.compileVindex());
        SelPtReader set = new SelPtReader(selectedtxt.getSelectedFile().getAbsolutePath());
        SelPtCompiler ptcom = new SelPtCompiler(set.compileContent(), set.compilePTindex());
        ptcom.cleanSetPt();
        
        JFileChooser targetfolder = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        targetfolder.setDialogTitle("Where to Save your File:");
        targetfolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(targetfolder.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            String SEL_dir = targetfolder.getSelectedFile().getAbsolutePath() + "\\" + name + " SEL.obj";
            PrintWriter writer = new PrintWriter(SEL_dir, "UTF-8");
            for(int i = 0; i < ptcom.compileSetPt().size(); i ++){
                writer.print("# ");
                writer.println(ptcom.compileSetPt().get(i).getname());
                writer.print("v ");
                writer.print(vcom.compileVertices().get(ptcom.compileSetPt().get(i).getv1index()-1).getX());
                writer.print(" ");
                writer.print(vcom.compileVertices().get(ptcom.compileSetPt().get(i).getv1index()-1).getY());
                writer.print(" ");
                writer.println(vcom.compileVertices().get(ptcom.compileSetPt().get(i).getv1index()-1).getZ());
            }
            writer.close();
        }
    }
}