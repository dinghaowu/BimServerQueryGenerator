/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import querygenerator1.Global;
/**
 *
 * @author Yufei Jiang
 */


//我们有一件事情必须要做的是要在这个新文件夹中自动化寻找到MVD文件
//因为一个工程中有很多的文件，所以我们要自动化查找
//这个类就是帮我们在干这件事情

public class MVDFileNamesGetter {
    
    public void MVDFileNamesGetter(){
        //每次这个类在FinalProjectWizardBox被创建，我们都要更新list_of_mvd_paths
        Global.list_of_mvd_files_paths=new ArrayList();
   
    }
    
    



//这个方法包括了这个类的主要逻辑
    //我们使用递归的方法逐层深入的寻找脚本文件所在的文件夹
    //并且进一步的在其中找到正确的文件，
    //最终得到它的绝对路径，并且将其放入脚本文件绝对路径的list中（因为是批量生成，所以会有很多list）
    //这样之后的读取和重新写入，均根据这个绝对路径来进行。
    public void GetMVDFileNamesList(String strPath) {

        File dir = new File(strPath);

        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (int i = 0; i < files.length; i++) {

            if (files[i].isDirectory()) {

                //这里是个递归，结束条件是找到exp文件
                //if (!files[i].getAbsolutePath().endsWith("Action0")) {
                    GetMVDFileNamesList(files[i].getAbsolutePath());
                //}

            } else {

                String strFileName = files[i].getAbsolutePath().toLowerCase();

                //System.out.println("---" + strFileName);

                if (files[i].getAbsolutePath().endsWith(".exp")) {
                    Global.list_of_mvd_files_paths.add(files[i].getAbsolutePath());
                }
            }

        }

    }
}
