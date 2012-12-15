/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import querygenerator1.Global;

/**
 *
 * @author yzj107
 */
public class JavaFileWriter {
    
    public JavaFileWriter(){
        //
        Global.list_of_query_code_of_building_element=new ArrayList();
        Global.list_of_query_code_of_IfcSpace=new ArrayList();
    }
    
    public void writeFile(String folder){
        
        //初始化list_of_buildingElement，可以改成文件读取
        Global.list_of_IfcBuildingElement=new ArrayList();
        Global.list_of_IfcBuildingElement.add("IfcBuildingElementProxy");
        Global.list_of_IfcBuildingElement.add("IfcCovering");
        Global.list_of_IfcBuildingElement.add("IfcBeam");
        Global.list_of_IfcBuildingElement.add("IfcColumn");
        Global.list_of_IfcBuildingElement.add("IfcCurtainWall");
        Global.list_of_IfcBuildingElement.add("IfcDoor");
        Global.list_of_IfcBuildingElement.add("IfcMember");
        Global.list_of_IfcBuildingElement.add("IfcRailing");
        Global.list_of_IfcBuildingElement.add("IfcRamp");
        Global.list_of_IfcBuildingElement.add("IfcRampFlight");
        Global.list_of_IfcBuildingElement.add("IfcWall");
        Global.list_of_IfcBuildingElement.add("IfcSlab");
        Global.list_of_IfcBuildingElement.add("IfcStairFlight");
        Global.list_of_IfcBuildingElement.add("IfcWindow");
        Global.list_of_IfcBuildingElement.add("IfcStair");
        Global.list_of_IfcBuildingElement.add("IfcRoof");
        Global.list_of_IfcBuildingElement.add("IfcPile");
        Global.list_of_IfcBuildingElement.add("IfcFooting");
        Global.list_of_IfcBuildingElement.add("IfcBuildingElementComponent");
        Global.list_of_IfcBuildingElement.add("IfcPlate");
        
        Global.list_of_IfcDistributionElement=new ArrayList();
        Global.list_of_IfcDistributionElement.add("IfcFlowFitting");
        Global.list_of_IfcDistributionElement.add("IfcFlowSegment");
        Global.list_of_IfcDistributionElement.add("IfcFlowController");
        Global.list_of_IfcDistributionElement.add("IfcFlowTerminal");
        Global.list_of_IfcDistributionElement.add("IfcFlowMovingDevice");
        Global.list_of_IfcDistributionElement.add("IfcEnergyConversionDevice");
        Global.list_of_IfcDistributionElement.add("IfcFlowStorageDevice");
        Global.list_of_IfcDistributionElement.add("IfcFlowTreatmentDevice");
        Global.list_of_IfcDistributionElement.add("IfcDistributionChamberElement");
        
        //如果是IfcBuildingElement的一部分，我们就用另一种方法去生成（.class法）
        
        
        for(String str:Global.list_of_java_filenames){
            Global.list_of_query_code_of_building_element = new ArrayList();
            Global.list_of_query_code_of_IfcSpace=new ArrayList();
            Global.list_of_query_code_of_distribution_element=new ArrayList();
            
           
            //如果要switch,那么就在这里switch
            
            
           
            choose_a_content_maker(str);
            //mainContentMaker(str); 类似于这样的方法会在choose_a_content_maker内部被调用
           
        }

        
        //
        for(String filename:Global.list_of_java_filenames){
            
        }
        
        //在java文件中写入内容
        // writeContent();
    }
    
    //用switch？
    boolean isBuildingElement(String IfcObject){
        return Global.list_of_IfcBuildingElement.contains(IfcObject);
    }
    
    void choose_a_content_maker(String IfcObject) {
        
        if(IfcObject.equals("IfcSpace")){
            fileReader("/resources/IfcSpaceCode.txt",Global.list_of_query_code_of_IfcSpace );
            createFile(IfcObject, Global.list_of_query_code_of_IfcSpace);
        }
        
        if(Global.list_of_IfcBuildingElement.contains(IfcObject)){
            //读取前半部分
            fileReader("/resources/IfcBuildingElementPreparation.txt",Global.list_of_query_code_of_building_element);
             //参数化中间部分
            BuildingElementContentMaker(IfcObject);
             //读取最后部分
            fileReader("/resources/IfcBuildingElementSecondHalf.txt",Global.list_of_query_code_of_building_element);
            //创建java文件并写入内容
            
            createFile(IfcObject,Global.list_of_query_code_of_building_element);
        }
        
        if(Global.list_of_IfcDistributionElement.contains(IfcObject)){
            //读取前半部分
            fileReader("/resources/DistributionElementPreparation.txt",Global.list_of_query_code_of_distribution_element);
            //参数化中间部分
            
            DistributionElementContentMaker(IfcObject);
            //读取最后部分
            fileReader("/resources/DistributionElementSecondHalf.txt", Global.list_of_query_code_of_distribution_element);
            //call a method
            
            createFile(IfcObject,Global.list_of_query_code_of_distribution_element);
        }    
    }
    
    public void createFile(String filename, List<String> list){
        File java_query_file = new File(Global.queryJavaCode+"\\"+filename+".java");//我的输出
       
        BufferedWriter bw;
        //List<String> str_of_repaired_event_sequence = list_of_repaired_event_sequence;
        
        

        try {
            bw = new BufferedWriter(new FileWriter(java_query_file, false)); //此处true为追加
            
            for (String str: list) {
                bw.write(str+"\n");
            }

            bw.close();
        } catch (IOException ex) {
            System.out.println("IOException ex");
            //Logger.getLogger(GuitarEventWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("aaaa");
    }
    
    public void fileReader(String filePathAndName, List<String> list) {
        //File file = new File(filePathAndName); in this way, jar file cannot find the resource file.
        
        InputStream is=this.getClass().getResourceAsStream(filePathAndName);   
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));  
        
        //BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            //reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
                //Global.list_of_query_code_of_building_element.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try { 
                    reader.close();
                } catch (IOException e1) {
                }
            }
            for(String str:list){
                System.out.println(str);
            }
            
        }
    }
    
    //*************************************************
    public void doesContainsVariable() {
        ;
        //things to do
    }
    //************************************************
    
    public void DistributionElementContentMaker(String str){
        String instance=str;
        
        Global.list_of_query_code_of_distribution_element.add("        List<"+instance+"> list_of_instance = model.getAll("+instance+".class);");
        Global.list_of_query_code_of_distribution_element.add("        for ("+instance+" instance : list_of_instance) {");
        
    }
    
    public void BuildingElementContentMaker(String str){
        //Global.list_of_query_code_of_building_element=new ArrayList();
        String instance=str;
        
        //多文件的问题都是从这里出来的
/*        for(String str:Global.list_of_java_filenames){
            instance=str;
        }*/
        
//******************************************************              
        //如果这个属性本身有变量
/*        for(int i=0;i++;i<-1){
            ifContainsVariable(the_name_of_the_entity);
        }*/
//*********************************************************
        
        //那么首先获得这个属性的名字
        //让用户直接多选择他们要的 (name选项框是一定有的)
        //一旦选择就让他们选择范围，选一个min,选一个max
        //把这段代码插入到整个的代码中

        Global.list_of_query_code_of_building_element.add("                        if (product instanceof "+instance+") {");
        Global.list_of_query_code_of_building_element.add("                            "+instance+" "+instance+"instance=("+instance+") product;");
        Global.list_of_query_code_of_building_element.add("                                out.println("+instance+"instance.getName());");
        Global.list_of_query_code_of_building_element.add("                            List<IfcRelDefines> list_defines = "+instance+"instance.getIsDefinedBy();");

    
    }
    

    
}
