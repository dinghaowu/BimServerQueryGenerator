/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querygenerator1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import utility.ExpressEntity;

/**
 *
 * @author yzj107
 */
public class Global {
    //用到了
    public static String mvdFolder="empty mvd folder";
    //用到了
    public static String queryJavaCode="empty java code";//用于存放输出的目录
    //用到了
    public static List<ExpressEntity> entity_inheritance_list =null;
    
    public static List<String> list_of_IfcBuildingElement=null; //用到了，在JavaFileWriter中初始化
    public static List<String> list_of_IfcDistributionElement=null;//用到了，在JavaFileWriter中初始化
    
    
    public static List<String> list_of_mvd_files_paths=new ArrayList();//所有待生成query的mvd的路径
    
    public static List<String> list_of_java_filenames=new ArrayList();
    
    //可以考虑搞个query类，添一个新成员加一个类，把这些都变成其类里的私有变量？
    public static List<String> list_of_query_code_of_building_element=new ArrayList(); //用到了，在JavaFileWriter中初始化
    public static List<String> list_of_query_code_of_distribution_element=new ArrayList();//用到了，在JavaFileWriter中被初始化
    public static List<String> list_of_query_code_of_IfcSpace=new ArrayList(); //用到了，在JavaFileWriter中被初始化
    
    public static List<String> main_content_container_list=new ArrayList();
    
    public static List<Double> list_of_storey_elevation=new ArrayList();
    
    //public static String leave_entity_name=null;//暂时没有用到，用list_of_java_filenames即可
}
