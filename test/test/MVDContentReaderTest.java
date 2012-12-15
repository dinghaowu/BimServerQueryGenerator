package test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import utility.ExpressEntity;
import utility.MVDContentReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yzj107
 */
public class MVDContentReaderTest {
    
    private MVDContentReader mvd_content_reader=new MVDContentReader();
    private String file_path;
    
    public MVDContentReaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        file_path="C:\\Users\\yzj107\\Desktop\\exp folder\\IFCDoor.exp";
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testGetLeaveEntityName() {
        assertTrue(mvd_content_reader.getEntityName("ENTITY IfcDoor;").equals("IfcDoor"));
    }
    
    @Test
    public void testReadFileByLines() {
        mvd_content_reader.readFileByLines(file_path);
        
    }
    
    @Test
    public void testGetThisLineAttributeAndMeasure() {
        assertTrue(mvd_content_reader.getThisLineAttributeAndMeasure("GlobalId 	 :  	IfcGloballyUniqueId;").attribute.equals("GlobalId"));
        assertTrue(mvd_content_reader.getThisLineAttributeAndMeasure("GlobalId 	 :  	IfcGloballyUniqueId;").measure.equals("IfcGloballyUniqueId"));
        assertTrue(mvd_content_reader.getThisLineAttributeAndMeasure("FillsVoids 	 :  	SET [0:1] OF IfcRelFillsElement FOR RelatedBuildingElement;").
                measure.equals("SET [0:1] OF IfcRelFillsElement FOR RelatedBuildingElement"));
        assertTrue(mvd_content_reader.getThisLineAttributeAndMeasure("FillsVoids 	 :  	SET [0:1] OF IfcRelFillsElement FOR RelatedBuildingElement;").
                attribute.equals("FillsVoids"));
    }
    
    @Test
    public void testParseContent() {
        System.out.println(mvd_content_reader.line_list.size());
        mvd_content_reader.readFileByLines(file_path);
        System.out.println(mvd_content_reader.line_list.size());
        mvd_content_reader.parseContent();
        for(ExpressEntity e:mvd_content_reader.entity_inheritance_list){
            
                System.out.println(e.entityName);
                System.out.println(e.leaveEntiyName);
                
            
        }

    }
    
    
    
}
