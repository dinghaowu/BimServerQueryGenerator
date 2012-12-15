/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yzj107
 */
public class ExpressEntity {
    
    public String entityName;
    public String leaveEntiyName;
    public List<AttributeAndMeasure> attributeList;
    public List<AttributeAndMeasure> inverseList;
    
    public ExpressEntity(){
        attributeList=new ArrayList();
        inverseList=new ArrayList();
    }
    
}
