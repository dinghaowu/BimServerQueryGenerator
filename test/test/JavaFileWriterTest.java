/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import utility.JavaFileWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import querygenerator1.Global;
import static org.junit.Assert.*;

/**
 *
 * @author yzj107
 */
public class JavaFileWriterTest {
    
    private JavaFileWriter java_file_writer=new JavaFileWriter();
    
    public JavaFileWriterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example
    @Test
    public void testCreateFile() {
        //java_file_writer.createFile("IfcDoor");
    }
    
    @Test
    public void testFileReader() {
        java_file_writer.fileReader("src\\resources\\preparation.txt",Global.list_of_query_code_of_building_element);
    }
    
}
